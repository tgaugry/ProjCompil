package Compil;

import java.util.Stack;

public class Iteration {

	private static int nbIter;
	private Stack<Integer>  niveau;
	
	public void debutTantQue() {
		niveau.push(nbIter);
		nbIter++;
	}
	public void finTantQue() {
		niveau.pop();
	}
}
