package Compil;

public class Conditionnelle {
	public static int nbConditionnelles;
	
	public Conditionnelle(){
		nbConditionnelles = 0;
	}
	
	public void verifieTypeExpr()
	{
		if(Yaka.expression.dernierOperande() == YakaConstants.BOOLEEN)
		{
			System.out.println("Erreur : condition non booléenne");
			Yaka.nbErreurs++;
		}
	}
}
