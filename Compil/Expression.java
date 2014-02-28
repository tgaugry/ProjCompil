package Compil;

import java.util.Stack;

import Compil.Ident.TypeVar;

public class Expression {
	public enum TypeOp {ARITH2, LOGIQUE2, ARITH1, LOGIQUE1, ARLO }
	private Stack<TypeVar> operateurs;
	private Stack<TypeOp>  operandes;
	
	public Expression (){
		operateurs = new Stack<TypeVar>();
		operandes = new Stack<TypeOp>();
	}
	
	public void addImmediate(TypeVar t) {
		operateurs.push(t);
	}
	
	public void addOp(TypeOp t) {
		operandes.push(t);
	}
	
	public void addIdent(String identName) {
		Ident i = Yaka.tabIdent.chercherIdent(identName);
		operateurs.push(i.getType());
	}
	
	public boolean evaluate() {
		TypeOp operande;
		TypeVar n1, n2;
		if(operandes.empty()) {
			if (operateurs.size() == 1) {return true;}
			else {return false;}
		}
		else {
			operande = operandes.pop();
			switch (operande) {
			case ARITH1 :
				if (operateurs.size() >= 1) {
					n1 = operateurs.pop();
					if(n1 == TypeVar.INT){
						operateurs.push(TypeVar.INT);
						return evaluate();
					}
				}
				break;
			case ARITH2 :
				if (operateurs.size() >= 2) {
					n1 = operateurs.pop();
					n2 = operateurs.pop();
					if(n1 == TypeVar.INT && n2 == TypeVar.INT){
						operateurs.push(TypeVar.INT);
						return evaluate();
					}
				}
				break;
			case LOGIQUE1 :
				if (operateurs.size() >= 1) {
					n1 = operateurs.pop();
					if(n1 == TypeVar.BOOL){
						operateurs.push(TypeVar.BOOL);
						return evaluate();
					}
				}
				break;
			case LOGIQUE2 :
				if (operateurs.size() >= 2) {
					n1 = operateurs.pop();
					n2 = operateurs.pop();
					if(n1 == TypeVar.BOOL && n2 == TypeVar.BOOL){
						operateurs.push(TypeVar.BOOL);
						return evaluate();
					}
				}
				break;
			case ARLO :
				if (operateurs.size() >= 2) {
					n1 = operateurs.pop();
					n2 = operateurs.pop();
					if(n1 == TypeVar.INT && n2 == TypeVar.INT){
						operateurs.push(TypeVar.BOOL);
						return evaluate();
					}
				}
				break;
			}
		}
		return false;	
	}
}
