package Compil;

import Compil.Ident.TypeVar;

public class Declaration {
	
	public void declConst(String nom, int val) {
		IdConst id = new IdConst(val);
		Yaka.tabIdent.rangeIdent (nom, id);
	}
	
	public void declConst(String nom, boolean val) {
		IdConst id = new IdConst(val);
		Yaka.tabIdent.rangeIdent (nom, id);
	}
	
	public void declVar(String nom) {
		IdVar id = new IdVar(TypeVar.BOOL);
		Yaka.tabIdent.rangeIdent (nom, id);
	}
}
