package Compil;

import java.io.OutputStream;

import Compil.Ecriture;
import Compil.TabIdent.NoSuchKeyException;

public class YVM
{	
	public static final int vrai = -1;
	public static final int faux = 0;
	
	protected OutputStream output;

	public YVM(String nomFic)
	{
		output=Ecriture.ouvrir(nomFic);
	}

	public void debutProg(){
		Ecriture.ecrireStringln(output, "entete");
	}

	public void ouvrePrinc(){
		String texte = "ouvrePrinc "+Yaka.tabIdent.compteVariables()*2;
		Ecriture.ecrireStringln(output, texte);
	}

	public void lireConstOuVar(String nom) {
		try {
			Ident i = Yaka.tabIdent.chercherIdent(nom);
			String texte = i.toYVM();
			Ecriture.ecrireStringln(output, texte);
		}
		catch (Exception e){
			System.out.println(e.getMessage());
			Yaka.nbErreurs++;
		}
	}
	
	public void lireOp(Expression.Op op)
	{
		switch(op)
		{
		case SUP:
			lireSup();
			break;
		case INF:
			lireInf();
			break;
		case SUPEG:
			lireSupEg();
			break;
		case INFEG:
			lireInfEg();
			break;
		case EGAL:
			lireEg();
			break;
		case DIFF:
			lireDiff();
			break;
		case ADD:
			lireAdd();
			break;
		case SOUS:
			lireSous();
			break;
		case OU:
			lireOu();
			break;
		case MUL:
			lireMul();
			break;
		case DIV:
			lireDiv();
			break;
		case ET:
			lireEt();
			break;
		case NEG:
			lireNeg();
			break;
		case NON:
			lireNon();
			break;									
		}
	}

	public void lireImmediat(int i){
		String texte = "iconst "+i;
		Ecriture.ecrireStringln(output, texte);
	}
	
	public void affecter(String nom) {
		try {
			Ident i = Yaka.tabIdent.chercherIdent(nom);
			Ecriture.ecrireStringln(output, "istore " + i.getValOuOffset());
		}
		catch (Exception e){
			System.out.println(e.getMessage());
			Yaka.nbErreurs++;
		}
	}

	public void lireAdd(){
		Ecriture.ecrireStringln(output, "iadd");
	}

	public void lireSous(){
		Ecriture.ecrireStringln(output, "isub");
	}

	public void lireMul(){
		Ecriture.ecrireStringln(output, "imul");
	}

	public void lireDiv(){
		Ecriture.ecrireStringln(output, "idiv");
	}

	public void lireOu(){
		Ecriture.ecrireStringln(output, "ior");
	}

	public void lireEt(){
		Ecriture.ecrireStringln(output, "iand");
	}

	public void lireNeg(){
		Ecriture.ecrireStringln(output, "ineg");
	}

	public void lireNon(){
		Ecriture.ecrireStringln(output, "inot");
	}

	public void lireInf(){
		Ecriture.ecrireStringln(output, "iinf");
	}

	public void lireInfEg(){
		Ecriture.ecrireStringln(output, "iinfegal");
	}

	public void lireSup(){
		Ecriture.ecrireStringln(output, "isup");
	}

	public void lireSupEg(){
		Ecriture.ecrireStringln(output, "isupegal");
	}

	public void lireEg(){
		Ecriture.ecrireStringln(output, "iegal");
	}

	public void lireDiff(){
		Ecriture.ecrireStringln(output, "idiff");
	}

	public void finProg(){
		Ecriture.ecrireStringln(output, "queue");
		Ecriture.fermer(output);
	}
	
	public void ecrireEnt() {
		Ecriture.ecrireStringln(output, "ecrireEnt");
	}
	
	public void ecrireBool() {
		Ecriture.ecrireStringln(output, "ecrireBool");
	}
	
	/**
	 * Choisit d'appeler ecrireEnt ou ecrireBool suivant le type de l'expression (en haut de la pile)
	 */
	
	public void ecrireExpr(){
		int type = Yaka.expression.dernierOperande();
		switch (type){
			case YakaConstants.BOOLEEN :
				ecrireBool();
				break;
			case YakaConstants.ENTIER :
				ecrireEnt();
				break;
			case YakaConstants.DEFAULT :
				System.out.println("Expression non valide.");
				break;
			default :
				System.out.println("Probleme de type d'expression. ");
				break ;		
		}
	}
	
	public void ecrireChaine(String s) {
		Ecriture.ecrireStringln(output, "ecrireChaine " + s);
	}
	
	public void aLaLigne() {
		Ecriture.ecrireStringln(output, "aLaLigne");
	}

	public void lireEnt(String id) {
		try {
			Ident i = Yaka.tabIdent.chercherIdent(id) ;
			if(i.estVar()){
				Ecriture.ecrireStringln(output, "lireEnt " + i.getValOuOffset());
			}
			else{
				System.out.println("Affectation d'une nouvelle valeur a une constante :(");
			}
		}
		catch (Exception e){
			System.out.println(e.getMessage());
			Yaka.nbErreurs++;
		}
	}
	
	public void dtantQue() {
		Ecriture.ecrireString(output, "\nFAIRE");
		Ecriture.ecrireInt(output, Iteration.getEtiquette());
		Ecriture.ecrireStringln(output, ":");
	}
	
	public void ftantQue() {
		Ecriture.ecrireString(output, "goto FAIRE");
		Ecriture.ecrireInt(output, Iteration.getEtiquette());
		Ecriture.ecrireStringln(output, "\n");
		
		Ecriture.ecrireString(output, "FAIT");
		Ecriture.ecrireInt(output, Iteration.getEtiquette());
		Ecriture.ecrireStringln(output, ":");
	}
	public void condtantQue() {
		Ecriture.ecrireStringln(output, "iffaux FAIT" + Iteration.getEtiquette());
	}
	
	/*
	 * Fonctions de conditionelles 
	 */

	public void lireAlors(){
		Ecriture.ecrireStringln(output, "iffaux SINON" + Yaka.conditionnelle.incNbConditionnelles());
	}
	
	public void lireSinon(){
		Ecriture.ecrireStringln(output, "goto FSI" + Yaka.conditionnelle.getNbConditionnelles());
		Ecriture.ecrireStringln(output, "SINON" + Yaka.conditionnelle.getNbConditionnelles()+" :");
	}
	
	public void lireFSi(){
		Ecriture.ecrireStringln(output, "FSI" + Yaka.conditionnelle.getNbConditionnelles()+" :");
	}
}