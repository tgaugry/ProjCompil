package Compil;

import java.util.Stack;

import Compil.TabIdent.NoSuchKeyException;

public class Expression {
	public enum TypeOp {ARITH2, LOGIQUE2, ARITH1, LOGIQUE1, ARLO }
	private Stack<Integer> operandes; //prend ses valeurs dans YakaConstants
	private Stack<TypeOp>  operateurs;
	
	public Expression (){
		operandes = new Stack<Integer>();
		operateurs = new Stack<TypeOp>();
	}
	
	public void addImmediate(int t) {
		operandes.push(t);
	}
	
	public void addOp(TypeOp t) {
		operateurs.push(t);
	}
	
	public void addIdent(String identName) throws NoSuchKeyException {
		Ident i = Yaka.tabIdent.chercherIdent(identName);
		operandes.push(i.getType());
	}
	
	public boolean evaluate() {
		TypeOp operande;
		int n1, n2;
		if(operateurs.empty()) {
			if (operandes.size() == 1) {return true;}
			else {return false;}
		}
		else {
			operande = operateurs.pop();
			switch (operande) {
			case ARITH1 :
				if (operandes.size() >= 1) {
					n1 = operandes.pop();
					if(n1 == YakaConstants.ENTIER){
						operandes.push(YakaConstants.ENTIER);
						return evaluate();
					}
				}
				break;
			case ARITH2 :
				if (operandes.size() >= 2) {
					n1 = operandes.pop();
					n2 = operandes.pop();
					if(n1 == YakaConstants.ENTIER && n2 == YakaConstants.ENTIER){
						operandes.push(YakaConstants.ENTIER);
						return evaluate();
					}
				}
				break;
			case LOGIQUE1 :
				if (operandes.size() >= 1) {
					n1 = operandes.pop();
					if(n1 == YakaConstants.BOOLEEN){
						operandes.push(YakaConstants.BOOLEEN);
						return evaluate();
					}
				}
				break;
			case LOGIQUE2 :
				if (operandes.size() >= 2) {
					n1 = operandes.pop();
					n2 = operandes.pop();
					if(n1 == YakaConstants.BOOLEEN && n2 == YakaConstants.BOOLEEN){
						operandes.push(YakaConstants.BOOLEEN);
						return evaluate();
					}
				}
				break;
			case ARLO :
				if (operandes.size() >= 2) {
					n1 = operandes.pop();
					n2 = operandes.pop();
					if(n1 == YakaConstants.ENTIER && n2 == YakaConstants.ENTIER){
						operandes.push(YakaConstants.BOOLEEN);
						return evaluate();
					}
				}
				break;
			}
		}
		return false;	
	}
}
