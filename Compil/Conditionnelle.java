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
	
	public void verifieTypeExpr()
	{
		if(Yaka.expression.dernierOperande() != YakaConstants.BOOLEEN)
		{
			Yaka.afficherErreur("Condition non booléenne");
		}
	}
}
