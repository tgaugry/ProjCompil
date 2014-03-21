package Compil;

import java.util.Stack;

public class IdFonc extends Ident {
	
	private int typeRetour;
	private Stack<Integer> typeParam;
	// rajouter les fun dans yaka.jj !!!
	
	public IdFonc(int offset, int t){
		super (YakaConstants.FONCTION, offset);
		typeRetour = t;
		typeParam = new Stack<Integer>();
		
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
