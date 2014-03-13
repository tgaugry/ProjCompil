package Compil;

public class Declaration {
	
	public void declConst(String nom, int val) {
		IdConst id = new IdConst(val);
		Yaka.tabIdent.rangeIdent (nom, id);
	}
	
	public void declConst(String nom, boolean val) {
		IdConst id = new IdConst(val);
		Yaka.tabIdent.rangeIdent (nom, id);
	}
	
	public void declVar(String nom, int type) {
		IdVar id = new IdVar(type);
		Yaka.tabIdent.rangeIdent (nom, id);
	}
}
