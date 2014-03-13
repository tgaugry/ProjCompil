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

	public void evaluerAffectation() throws IncorrectTypeException{
		if (typeAffectation != operandes.pop()) {
			throw new IncorrectTypeException("1 " + ((typeAffectation == YakaConstants.BOOLEEN) ? "BOOL" : "INT"));
		}
	}

	public void evaluate() throws OperandeManquanteException, IncorrectTypeException {
		Op operaeurSom;
		int n1, n2;
		if(operateurs.empty()) {
			if (operandes.size() != 1) {throw new OperandeManquanteException();}
		}
		else {
			operaeurSom = operateurs.pop();
			switch (operaeurSom) {
			case NEG :
				if (operandes.size() >= 1) {
					n1 = operandes.pop();
					if(n1 == YakaConstants.ENTIER){
						operandes.push(YakaConstants.ENTIER);
					}
					else throw new IncorrectTypeException("1 INT");
				}
				else throw new OperandeManquanteException();
				break;
			case ADD :case SOUS :case MUL :case DIV :
				if (operandes.size() >= 2) {
					n1 = operandes.pop();
					n2 = operandes.pop();
					if(n1 == YakaConstants.ENTIER && n2 == YakaConstants.ENTIER){
						operandes.push(YakaConstants.ENTIER);
					}
					else throw new IncorrectTypeException("2 INT");
				}
				else throw new OperandeManquanteException();
				break;
			case NON :
				if (operandes.size() >= 1) {
					n1 = operandes.pop();
					if(n1 == YakaConstants.BOOLEEN){
						operandes.push(YakaConstants.BOOLEEN);
					}
					else throw new IncorrectTypeException("1 BOOL");
				}
				else throw new OperandeManquanteException();
				break;
			case OU :case ET :
				if (operandes.size() >= 2) {
					n1 = operandes.pop();
					n2 = operandes.pop();
					if(n1 == YakaConstants.BOOLEEN && n2 == YakaConstants.BOOLEEN){
						operandes.push(YakaConstants.BOOLEEN);
					}
					else throw new IncorrectTypeException("2 BOOL");
				}
				else throw new OperandeManquanteException();
				break;
			case INF :case SUP :case INFEG :case SUPEG :case DIFF :case EGAL :
				if (operandes.size() >= 2) {
					n1 = operandes.pop();
					n2 = operandes.pop();
					if(n1 == YakaConstants.ENTIER && n2 == YakaConstants.ENTIER){
						operandes.push(YakaConstants.BOOLEEN);
					}
					else  throw new IncorrectTypeException(" 2 INT");
				}
				else throw new OperandeManquanteException();
				break;
			default:
				break;
			}
		}
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
