package Compil;

public class Declaration {

	public void declConst(String nom, int type, int val)
	{
		IdConst id = new IdConst(type, val);
		Yaka.tabIdent.rangeIdent (nom, id);
	}
	
	public void declConst(String nom, String nomBis) {
		IdVal a = Yaka.tabIdent.chercherIdent(nomBis);
		if (a != null) {
			IdConst id = new IdConst(a);
			Yaka.tabIdent.rangeIdent (nom, id);
		}
	}
	
	public void declVar(String nom, int type) {
		IdVar id = IdVar.newIdVarLocal(type);
		Yaka.tabIdent.rangeIdent (nom, id);
	}
}
