package Compil;

import java.util.*;

import Compil.Ident.TypeVar;

public class Declaration {
	
	public void declConst(String nom, int val) {
		IdConst id = new IdConst(val);
		//table.rangeIdent (nom, id);
	}
	public void declConst(String nom, boolean val) {
		IdConst id = new IdConst(val);
		//table.rangeIdent (nom, id);
	}
	
	public void declVar(String nom) {
		IdVar id = new IdVar(TypeVar.BOOL);
		//table.rangeIdent (nom, id);
	}
}
