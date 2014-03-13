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
	
	
	public static class KeyAlreadyThereException extends Exception {
		public KeyAlreadyThereException(String clef){
			super("L'identifiant " + clef + " est déclaré plusieurs fois");
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
	
	public boolean evaluate() {
		Op operande;
		int n1, n2;
		if(operateurs.empty()) {
			if (operandes.size() == 1) {return true;}
			else {return false;}
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
				}
				break;
			case ADD :case SOUS :case MUL :case DIV :
				if (operandes.size() >= 2) {
					n1 = operandes.pop();
					n2 = operandes.pop();
					if(n1 == YakaConstants.ENTIER && n2 == YakaConstants.ENTIER){
						operandes.push(YakaConstants.ENTIER);
						return evaluate();
					}
				}
				break;
			case NON :
				if (operandes.size() >= 1) {
					n1 = operandes.pop();
					if(n1 == YakaConstants.BOOLEEN){
						operandes.push(YakaConstants.BOOLEEN);
						return evaluate();
					}
				}
				break;
			case OU :case ET :
				if (operandes.size() >= 2) {
					n1 = operandes.pop();
					n2 = operandes.pop();
					if(n1 == YakaConstants.BOOLEEN && n2 == YakaConstants.BOOLEEN){
						operandes.push(YakaConstants.BOOLEEN);
						return evaluate();
					}
				}
				break;
			case INF :case SUP :case INFEG :case SUPEG :case DIFF :case EGAL :
				if (operandes.size() >= 2) {
					n1 = operandes.pop();
					n2 = operandes.pop();
					if(n1 == YakaConstants.ENTIER && n2 == YakaConstants.ENTIER){
						operandes.push(YakaConstants.BOOLEEN);
						return evaluate();
					}
				}
				break;
			default:
				break;
			}
		}
		return false;	
	}
	
	public Op dernierOp()
	{
		try {
			return operateurs.peek();
		}
		catch(EmptyStackException e) {
			return Op.EGAL;
		}
	}
}
