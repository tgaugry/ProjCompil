package Compil;

import java.io.IOException;
import java.io.OutputStream;
import Compil.Ecriture;

public class YVM
{	
	public enum Op {ADD, SOUS, MUL, DIV, OU, ET, MOINS, NON, INF, INFEG, SUP, SUPEG, EG, DIF }
	protected OutputStream output;

	public YVM(String nomFic)
	{
		output=Ecriture.ouvrir(nomFic);		
	}

	public void debutProg() throws IOException{
		Ecriture.ecrireStringln(output, "entete");
	}

	public void ouvrePrinc() throws IOException{
		Ecriture.ecrireString(output, "ouvrePrinc ");
		Ecriture.ecrireInt(output, Yaka.tabIdent.compteVariables());
		Ecriture.ecrireStringln("");
	}

	public void lireConstOuVar(String nom) throws IOException{
		Ident i = Yaka.tabIdent.chercherIdent(nom);
		String texte = i.toString();
		Ecriture.ecrireStringln(output, texte);
	}

	public void lireImmediat(int i){
		String texte = "iconst "+i;
		Ecriture.ecrireStringln(output, texte);
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

	public void finProg() throws IOException{
		Ecriture.ecrireStringln(output, "queue");
		Ecriture.fermer(output);
	}
}