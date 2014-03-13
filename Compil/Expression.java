package Compil;

import java.util.EmptyStackException;
import java.util.Stack;

import Compil.TabIdent.NoSuchKeyException;

public class Expression {

	public enum Op {SUP, INF, SUPEG, INFEG, EGAL, DIFF, ADD, SOUS, OU, MUL, DIV, ET, NEG, NON};
	//public enum TypeOp {ARITH2, LOGIQUE2, ARITH1, LOGIQUE1, ARLO }
	private Stack<Integer> operandes; //prend ses valeurs dans YakaConstants
	private Stack<Op>  operateurs;
	private int typeAffectation;
	
	
	public static class IncorrectTypeException extends Exception {
		private static final long serialVersionUID = 1L;
		public IncorrectTypeException(String s){
			super("Type incorrect, "+ s +" était attendu");
		}
	}
	public static class OperandeManquanteException extends Exception {
		private static final long serialVersionUID = 1L;
		public OperandeManquanteException(){
			super("Operande Manquante");
		}
	}
	
	public Expression (){
		operandes = new Stack<Integer>();
		operateurs = new Stack<Op>();
	}
	
	public void addImmediate(int t) {
		operandes.push(t);
	}
	
	public void addOp(Op t) {
		operateurs.push(t);
	}
	
	public void addIdent(String nom) throws NoSuchKeyException {
		Ident i = Yaka.tabIdent.chercherIdent(nom);
		operandes.push(i.getType());
	}
	
	public void stockeAffectation(String nom) throws NoSuchKeyException {
		Ident i = Yaka.tabIdent.chercherIdent(nom);
		typeAffectation = i.getType();
		
	}
	
public boolean evaluerAffectation() {
		return typeAffectation == operandes.pop();
	}
	
	public boolean evaluate() throws OperandeManquanteException, IncorrectTypeException {
		Op operande;
		int n1, n2;
		if(operateurs.empty()) {
			if (operandes.size() == 1) {return true;}
			else {throw new OperandeManquanteException();}
		}
		else {
			operande = operateurs.pop();
			switch (operande) {
			case NEG :
				if (operandes.size() >= 1) {
					n1 = operandes.pop();
					if(n1 == YakaConstants.ENTIER){
						operandes.push(YakaConstants.ENTIER);
						return evaluate();
					}
					else { throw new IncorrectTypeException("1 INT");}
				}
				throw new OperandeManquanteException();
			case ADD :case SOUS :case MUL :case DIV :
				if (operandes.size() >= 2) {
					n1 = operandes.pop();
					n2 = operandes.pop();
					if(n1 == YakaConstants.ENTIER && n2 == YakaConstants.ENTIER){
						operandes.push(YakaConstants.ENTIER);
						return evaluate();
					}
					else { throw new IncorrectTypeException("2 INT");}
				}
				throw new OperandeManquanteException();
			case NON :
				if (operandes.size() >= 1) {
					n1 = operandes.pop();
					if(n1 == YakaConstants.BOOLEEN){
						operandes.push(YakaConstants.BOOLEEN);
						return evaluate();
					}
					else { throw new IncorrectTypeException("1 BOOL");}
				}
				throw new OperandeManquanteException();
			case OU :case ET :
				if (operandes.size() >= 2) {
					n1 = operandes.pop();
					n2 = operandes.pop();
					if(n1 == YakaConstants.BOOLEEN && n2 == YakaConstants.BOOLEEN){
						operandes.push(YakaConstants.BOOLEEN);
						return evaluate();
					}
					else { throw new IncorrectTypeException("2 BOOL");}
				}
				throw new OperandeManquanteException();
			case INF :case SUP :case INFEG :case SUPEG :case DIFF :case EGAL :
				if (operandes.size() >= 2) {
					n1 = operandes.pop();
					n2 = operandes.pop();
					if(n1 == YakaConstants.ENTIER && n2 == YakaConstants.ENTIER){
						operandes.push(YakaConstants.BOOLEEN);
						return evaluate();
					}
					else { throw new IncorrectTypeException(" 2 INT");}
				}
				throw new OperandeManquanteException();
			default:
				break;
			}
		}
		return false;	
	}
	
	public Op dernierOperateur()
	{
		try {
			return operateurs.peek();
		}
		catch(EmptyStackException e) {
			return Op.EGAL;
		}
	}
	
	public int dernierOperande()
	{
		try {
			return operandes.peek();
		}
		catch(EmptyStackException e) {
			return YakaConstants.DEFAULT;
		}
	}
}
