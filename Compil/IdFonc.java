package Compil;

import java.util.Stack;

public class IdFonc extends Ident {
	
	private int typeRetour; //prend des valeurs de YakaConstants
	private Stack<Integer> typeParam;
	// rajouter les fun dans yaka.jj !!!
	
	public IdFonc(int typeRetour){
		super ();
		this.typeRetour = typeRetour;
		typeParam = new Stack<Integer>();
	}
	
	public void ajouteParam(int type ){
		typeParam.push(type);
	}
	
	public Stack<Integer> getParam() {
		return typeParam;
	}

	@Override
	public boolean estVar() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toYVM() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toYVMAsm() {
		// TODO Auto-generated method stub
		return null;
	}

}
