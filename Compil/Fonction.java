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
		public ParamIncorrectException(){
			super("Parametre incorrect" + Yaka.afficherLigne());
		}
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
		try
		{
			Stack<Integer> paramAttendus = Yaka.tabIdent.chercherFonc(foncts.peek()).getParam();
			while(!typesParam.empty() && !paramAttendus.empty())
			{
				if(typesParam.pop() != paramAttendus.pop())
					throw new ParamIncorrectException();
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
/*
package Compil;

import java.util.Stack;

public class Conditionnelle {
	public int nbDebCond;
	
	public Conditionnelle(){
		nbDebCond = 0;
		conds = new Stack<Integer>();
	}

	//ajoute une condition a la pile et renvoie son ID
	public int nouvelleCond()
	{
		conds.add(++nbDebCond);
		return nbDebCond;
	}
	
	//renvoie l'ID de la condition courante
	public int getCondCourante()
	{
		return conds.peek();
	}
	
	//Depile la condition courante et renvoie son ID
	public int finitCond()
	{
		return conds.pop();
	}
	
	private static class IncorrectConditionException extends Exception {
		private static final long serialVersionUID = 1L;
		public IncorrectConditionException(){
			super("Condition non booléenne" + Yaka.afficherLigne());
		}
	}
	
	public void verifieTypeExpr()
	{
		try
		{
			if(Yaka.expression.dernierOperande() != YakaConstants.BOOLEEN)
			{
				throw new IncorrectConditionException();
			}
		}
		catch(IncorrectConditionException e)
		{
			System.out.println(e.getMessage());
			Yaka.nbErreurs++;
		}
	}
}*/
