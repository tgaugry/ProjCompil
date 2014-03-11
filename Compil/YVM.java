package Compil;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class YVM
{	
	public enum Op {ADD, SOUS, MUL, DIV, OU, ET, MOINS, NON, INF, INFEG, SUP, SUPEG, EG, DIF }

	BufferedWriter output;
	public YVM(String nomFic)
	{
		try {
			FileWriter fw = new FileWriter(nomFic, true);
			output = new BufferedWriter(fw);
		}
		catch (IOException e) {
			System.out.println("File " + nomFic +" exists but is a directory, cannot be created, or cannot be opened");
		}
		
	}
	
	public void debutProg() throws IOException{
		output.write("entete\n");
	}
	
	public void ouvrePrinc() throws IOException{
		output.write("ouvrePrinc ");
		output.write(Yaka.tabIdent.compteVariables()+"\n");
	}
	
	public void lireConstOuVar(String nom) throws IOException{
		Ident i = Yaka.tabIdent.chercherIdent(nom);
		String texte = i.toString();
		output.write(texte);
	}
	
	public void lireOperation(Op typeOp) throws IOException{
		switch(typeOp)
		{
		case ADD:
			output.write("iadd");
			break;
		case SOUS:
			output.write("isub");
			break;
		case MUL:
			output.write("imul");
			break;
		case DIV:
			output.write("idiv");
			break;
		case OU:
			output.write("iadd");
			break;
		case ET:
			output.write("isub");
			break;
		case MOINS:
			output.write("imul");
			break;
		case NON:
			output.write("idiv");
			break;
		case INF:
			output.write("iadd");
			break;
		case INFEG:
			output.write("isub");
			break;
		case SUP:
			output.write("imul");
			break;
		case SUPEG:
			output.write("idiv");
			break;
		case EG:
			output.write("imul");
			break;
		case DIF:
			output.write("idiv");
			break;
		default:
			System.out.println("Operation non reconnue :-(");
			break;
		}
		output.write("\n");
	}

	public void finProg() throws IOException{
		output.write("queue\n");
		output.flush();
		output.close();
	}
}
