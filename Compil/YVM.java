package Compil;

import java.io.OutputStream;
import Compil.Ecriture;

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
}