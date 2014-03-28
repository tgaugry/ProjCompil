package Compil;

public class Declaration {

	public void declConst(String nom, int type, int val)
	{
		IdConst id = new IdConst(type, val);
		Yaka.tabIdent.rangeIdent (nom, id);
	}
	
	public void declConst(String nom, String nomBis) {
		IdConst id = new IdConst(Yaka.tabIdent.chercherIdent(nomBis));
		Yaka.tabIdent.rangeIdent (nom, id);
	}
	
	public void declVar(String nom, int type) {
		IdVar id = IdVar.newIdVarLocal(type);
		Yaka.tabIdent.rangeIdent (nom, id);
	}
}
