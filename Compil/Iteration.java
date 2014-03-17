package Compil;

import java.util.Stack;

public class Iteration {

	private static int nbIter;
	private static Stack<Integer>  niveau;
	
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
}
