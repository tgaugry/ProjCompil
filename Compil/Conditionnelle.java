package Compil;

import java.util.Stack;

public class Conditionnelle {
	public int nbDebCond;
	public Stack<Integer> conds;
	
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
}
