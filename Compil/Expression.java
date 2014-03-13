package Compil;

import java.util.Stack;

import Compil.Ident.TypeVar;

public class Expression {
	public enum TypeOp {ARITH2, LOGIQUE2, ARITH1, LOGIQUE1, ARLO }
	private Stack<TypeVar> operandes;
	private Stack<TypeOp>  operateurs;
	
	public Expression (){
		operandes = new Stack<TypeVar>();
		operateurs = new Stack<TypeOp>();
	}
	
	public void addImmediate(TypeVar t) {
		operandes.push(t);
	}
	
	public void addOp(TypeOp t) {
		operateurs.push(t);
	}
	
	public void addIdent(String identName) {
		Ident i = Yaka.tabIdent.chercherIdent(identName);
		operandes.push(i.getType());
	}
	
	public boolean evaluate() {
		TypeOp operande;
		TypeVar n1, n2;
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
					if(n1 == TypeVar.INT){
						operandes.push(TypeVar.INT);
						return evaluate();
					}
				}
				break;
			case ARITH2 :
				if (operandes.size() >= 2) {
					n1 = operandes.pop();
					n2 = operandes.pop();
					if(n1 == TypeVar.INT && n2 == TypeVar.INT){
						operandes.push(TypeVar.INT);
						return evaluate();
					}
				}
				break;
			case LOGIQUE1 :
				if (operandes.size() >= 1) {
					n1 = operandes.pop();
					if(n1 == TypeVar.BOOL){
						operandes.push(TypeVar.BOOL);
						return evaluate();
					}
				}
				break;
			case LOGIQUE2 :
				if (operandes.size() >= 2) {
					n1 = operandes.pop();
					n2 = operandes.pop();
					if(n1 == TypeVar.BOOL && n2 == TypeVar.BOOL){
						operandes.push(TypeVar.BOOL);
						return evaluate();
					}
				}
				break;
			case ARLO :
				if (operandes.size() >= 2) {
					n1 = operandes.pop();
					n2 = operandes.pop();
					if(n1 == TypeVar.INT && n2 == TypeVar.INT){
						operandes.push(TypeVar.BOOL);
						return evaluate();
					}
				}
				break;
			}
		}
		return false;	
	}
}
