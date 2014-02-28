package Compil;

import java.util.Stack;

public class Expression {
	public enum optype {ARITH, LOGIQUE, ARLO }
	private Stack<Character> operateurs;
	private Stack<optype>  operandes;
	
	public Expression (){
		operateurs = new Stack<Character>();
		operandes = new Stack<optype>();
		
	}
	public boolean evaluate() {
		optype operande;
		if(operandes.empty()) {
			if (operateurs.size() == 1) {return true;}
			else {return false;}
		}
		else {
			operande = operandes.pop();
		}
		return false;
		
	}
}
