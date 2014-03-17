package Compil;

public class Conditionnelle {
	public static int nbConditionnelles;
	
	public Conditionnelle(){
		nbConditionnelles = 0;
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
