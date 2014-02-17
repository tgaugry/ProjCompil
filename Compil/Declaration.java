package Compil;

public class Declaration {
	public void declConst(String nom, int val) {
		IdConst id = new IdConst(val);
		table.rangeIdent (nom, id);
	}
	public void declConst(String nom, boolean val) {
		IdConst id = new IdConst(val);
		table.rangeIdent (nom, id);
	}
	
	public void declVar(String nom) {
		IdVar id = new IdVar();
		table.rangeIdent (nom, id);
	}
}
