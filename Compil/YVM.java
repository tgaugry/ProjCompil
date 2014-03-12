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
	
	public void lireOperation(Op typeOp) throws IOException{
		switch(typeOp)
		{
		case ADD:
			Ecriture.ecrireStringln(output, "iadd");
			break;
		case SOUS:
			Ecriture.ecrireStringln(output, "isub");
			break;
		case MUL:
			Ecriture.ecrireStringln(output, "imul");
			break;
		case DIV:
			Ecriture.ecrireStringln(output, "idiv");
			break;
		case OU:
			Ecriture.ecrireStringln(output, "ior");
			break;
		case ET:
			Ecriture.ecrireStringln(output, "iand");
			break;
		case MOINS:
			Ecriture.ecrireStringln(output, "imul");
			break;
		case NON:
			Ecriture.ecrireStringln(output, "idiv");
			break;
		case INF:
			Ecriture.ecrireStringln(output, "iadd");
			break;
		case INFEG:
			Ecriture.ecrireStringln(output, "isub");
			break;
		case SUP:
			Ecriture.ecrireStringln(output, "imul");
			break;
		case SUPEG:
			Ecriture.ecrireStringln(output, "idiv");
			break;
		case EG:
			Ecriture.ecrireStringln(output, "imul");
			break;
		case DIF:
			Ecriture.ecrireStringln(output, "idiv");
			break;
		default:
			System.out.println("Operation non reconnue :-(");
			break;
		}
	}

	public void finProg() throws IOException{
		Ecriture.ecrireStringln(output, "queue");
		Ecriture.fermer(output);
	}
}
