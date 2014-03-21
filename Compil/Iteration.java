package Compil;

import java.util.Stack;


public class Iteration {

	private static int nbIter;
	private static Stack<Integer>  niveau;
	
	public Iteration() {
		nbIter = 1;
		niveau = new Stack<Integer>();
	}
	
	public static int getEtiquette() {
		return niveau.peek(); 
	}
	
	
	public void debutTantQue() {
		niveau.push(nbIter);
		nbIter++;
	}
	public void finTantQue() {
		niveau.pop();
	}
	
	public void verifieTypeExpr()
	{
		if(Yaka.expression.dernierOperande() != YakaConstants.BOOLEEN) {
			System.out.println("Condition non booléenne" + Yaka.afficherLigne());
			Yaka.nbErreurs++;
		}
	}
}
