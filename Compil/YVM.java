package Compil;

import java.io.OutputStream;

import Compil.Ecriture;
import Compil.TabIdent.NoSuchKeyException;

public class YVM
{	
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

	public void lireConstOuVar(String nom){
		Ident i = Yaka.tabIdent.chercherIdent(nom);
		String texte = i.toYVM();
		Ecriture.ecrireStringln(output, texte);
	}

	public void lireImmediat(int i){
		String texte = "iconst "+i;
		Ecriture.ecrireStringln(output, texte);
	}
	
	public void affecter(String nom){
		Ident i = Yaka.tabIdent.chercherIdent(nom);
		Ecriture.ecrireStringln(output, "istore " + i.getValOuOffset());
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
	
	/*public void ecrireExpr(){
		int type = Yaka.expression.getLastPileType();
		switch (type){
			case YBOOLEEN :
				ecrireBool();
				break;
			case ENTIER :
				ecrireEnt();
				break;
			case ERREUR :
				System.out.println("Expression non valide. ");
				break;
			default :
				System.out.println("Probleme de type d'expression. ");
				break ;		
		}
	}*/
	
	public void ecrireChaine(String s) {
		Ecriture.ecrireStringln(output, "ecrireChaine " + s);
	}
	
	public void aLaLigne() {
		Ecriture.ecrireStringln(output, "aLaLigne");
	}

	public void lireEnt(String id) throws NoSuchKeyException {
		Ident i = Yaka.tabIdent.chercherIdent(id) ;
		if(i.estVar()){
			Ecriture.ecrireStringln(output, "lireEnt " + i.getValOuOffset());
		}
		else{
			System.out.println("Affectation d'une nouvelle valeur a une constante :(");
		}
	}
}