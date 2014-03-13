package Compil;

public class Declaration {
	
	public void declConst(String nom, int type, int val)
	{
		IdConst id = new IdConst(type, val);
		Yaka.tabIdent.rangeIdent (nom, id);
	}
	
	public void declVar(String nom, int type) {
		IdVar id = new IdVar(type);
		Yaka.tabIdent.rangeIdent (nom, id);
	}
}
