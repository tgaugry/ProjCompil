package Compil;

import java.util.EmptyStackException;
import java.util.Stack;

public class Expression {

	public enum Op {SUP, INF, SUPEG, INFEG, EGAL, DIFF, ADD, SOUS, OU, MUL, DIV, ET, NEG, NON};
	private Stack<Integer> operandes; //prend ses valeurs dans YakaConstants
	private Stack<Op>  operateurs;
	private int typeAffectation;

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

	public Boolean addIdent(String nom){
		IdVal i = Yaka.tabIdent.chercherIdent(nom);
		if(i != null)
		{
			operandes.push(i.getType());
			return true;
		}
		else
		{
			operandes.push(-1);
			return false;
		}
	}

	public void stockeAffectation(String nom) {
		IdVal i = Yaka.tabIdent.chercherIdent(nom);
		if(i != null)
		{
			if (!i.estVar()) {
				Yaka.afficherErreur(nom + " n'est pas une variable");
			}
			typeAffectation = i.getType();
		}
		else
		{
			typeAffectation = -1;
		}
	}

	public boolean evaluerAffectation() {
		int op = operandes.pop();
		if(op != -1 && typeAffectation != -1)
		{
			if (typeAffectation != op) {
				Yaka.afficherErreur("Type incorrect, 1 " + ((typeAffectation == YakaConstants.BOOLEEN) ? "BOOL" : "INT") +" était attendu");
			}
			return true;
		}
		//else
		return false;
	}

	public void evaluate() {
		Op operaeurSom;
		int n1, n2;
		if(operateurs.empty()) {
			if (operandes.size() != 1) {
				Yaka.afficherErreur("Operande Manquante");
			}
		}
		else {
			operaeurSom = operateurs.pop();
			switch (operaeurSom) {
			case NEG :
				if (operandes.size() >= 1) {
					n1 = operandes.pop();
					if(n1 != YakaConstants.ENTIER){
						Yaka.afficherErreur("Type incorrect, 1 INT était attendu");
					}
						operandes.push(YakaConstants.ENTIER);
				}
				else {
					Yaka.afficherErreur("Operande Manquante");
				}
				break;
			case ADD :case SOUS :case MUL :case DIV :
				if (operandes.size() >= 2) {
					n1 = operandes.pop();
					n2 = operandes.pop();
					if(n1 == YakaConstants.ENTIER && n2 == YakaConstants.ENTIER){
						operandes.push(YakaConstants.ENTIER);
					}
					else {
						Yaka.afficherErreur("Type incorrect, 2 INT étaient attendus");
					}
				}
				else {
					Yaka.afficherErreur("Operande Manquante");
				}
				break;
			case NON :
				if (operandes.size() >= 1) {
					n1 = operandes.pop();
					if(n1 == YakaConstants.BOOLEEN){
						operandes.push(YakaConstants.BOOLEEN);
					}
					else {
						Yaka.afficherErreur("Type incorrect, 1 BOOL était attendu");
					}
				}
				else {
					Yaka.afficherErreur("Operande Manquante");
				}
				break;
			case OU :case ET :
				if (operandes.size() >= 2) {
					n1 = operandes.pop();
					n2 = operandes.pop();
					if(n1 == YakaConstants.BOOLEEN && n2 == YakaConstants.BOOLEEN){
						operandes.push(YakaConstants.BOOLEEN);
					}
					else {
						Yaka.afficherErreur("Type incorrect, 2 BOOL étaient attendus");
					}
				}
				else {
					Yaka.afficherErreur("Operande Manquante");
				}
				break;
			case INF :case SUP :case INFEG :case SUPEG :
				if (operandes.size() >= 2) {
					n1 = operandes.pop();
					n2 = operandes.pop();
					if(n1 == YakaConstants.ENTIER && n2 == YakaConstants.ENTIER){
					}
					else  {
						Yaka.afficherErreur("Type incorrect, 2 INT étaient attendus");
					}
						operandes.push(YakaConstants.BOOLEEN);
				}
				else {
					Yaka.afficherErreur("Operande Manquante");
				}
				break;
			case DIFF :case EGAL :
				if (operandes.size() >= 2) {
					n1 = operandes.pop();
					n2 = operandes.pop();
					if(n1 == n2){
						operandes.push(YakaConstants.BOOLEEN);
					}
					else  {
						Yaka.afficherErreur("Type incorrect, 2 opérandes de même type attendues");
					}
				}
				else {
					Yaka.afficherErreur("Operande Manquante");
				}
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
