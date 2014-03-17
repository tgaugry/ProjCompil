package Compil;

public class Conditionnelle {
	public int nbConditionnelles;
	
	public Conditionnelle(){
		nbConditionnelles = 0;
	}
	
	public int incNbConditionnelles()
	{
		return ++nbConditionnelles;
	}
	
	public int getNbConditionnelles()
	{
		return nbConditionnelles;
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
			if(Yaka.expression.dernierOperande() == YakaConstants.BOOLEEN)
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
