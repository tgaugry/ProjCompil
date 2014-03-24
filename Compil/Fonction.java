package Compil;

import java.util.Stack;

import Compil.TabIdent.NoSuchKeyException;

public class Fonction {
	public Stack<String> foncts;
	public Stack<Integer> typesParam; // prends ses valeurs dans YakaConstants

	public Fonction(){
		foncts = new Stack<String>();
		typesParam = new Stack<Integer>();
	}

	public void empilerFonct(String name) throws NoSuchKeyException
	{
		foncts.push(name);
	}
	
	public String depilerFonct()
	{
		return foncts.pop();
	}
	
	public void empilerParam(int type)
	{
		typesParam.push(type);
	}
	
	public void depilerParam()
	{
		typesParam.pop();
	}

	private static class ParamIncorrectException extends Exception {
		private static final long serialVersionUID = 1L;
		//public ParamIncorrectException(){
		//	super("Parametre incorrect" + Yaka.afficherLigne());
		//}
		//public ParamIncorrectException(int type){
		//	super("Parametre incorrect : "+typeToString(type)+" attendu" + Yaka.afficherLigne());
		//}
		public ParamIncorrectException(int typeLu, int typeAtt){
			super("Parametre incorrect : "+typeToString(typeLu)+" lu, "+typeToString(typeAtt)+" attendu" + Yaka.afficherLigne());
		}
	}
	
	private static String typeToString(int type)
	{
			String t ="";
			switch(type)
			{
				case YakaConstants.ENTIER:
					t = "entier";
					break;
				case YakaConstants.BOOLEEN:
					t = "booleen";
					break;
				default:
					break;
			}
		return t;
	}

	private static class ParamManquantException extends Exception {
		private static final long serialVersionUID = 1L;
		public ParamManquantException(){
			super("Parametre manquant" + Yaka.afficherLigne());
		}
	}

	private static class ParamEnTropException extends Exception {
		private static final long serialVersionUID = 1L;
		public ParamEnTropException(){
			super("Trop de parametres" + Yaka.afficherLigne());
		}
	}
	
	public void verifieParams()
	{
		int temp1;
		int temp2;
		try
		{
			Stack<Integer> paramAttendus = Yaka.tabIdent.chercherFonc(foncts.peek()).getParam();
			while(!typesParam.empty() && !paramAttendus.empty())
			{
				if((temp1 = typesParam.pop()) != (temp2 = paramAttendus.pop()))
					throw new ParamIncorrectException(temp1, temp2);
			}
			if(!typesParam.empty())
				throw new ParamEnTropException();
			if(!paramAttendus.empty())
				throw new ParamManquantException();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			Yaka.nbErreurs++;
		}
	}
}
