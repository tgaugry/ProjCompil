package Compil;

import Compil.TabIdent.KeyAlreadyThereException;

public class Declaration {

	public void declConst(String nom, int type, int val) throws KeyAlreadyThereException
	{
		IdConst id = new IdConst(type, val);
		Yaka.tabIdent.rangeIdent (nom, id);
	}
	
	public void declConst(String nom, String nomBis) throws TabIdent.KeyAlreadyThereException, TabIdent.NoSuchKeyException {
		IdConst id = new IdConst(Yaka.tabIdent.chercherIdent(nomBis));
		Yaka.tabIdent.rangeIdent (nom, id);
	}
	
	public void declVar(String nom, int type) throws KeyAlreadyThereException {
		IdVar id = new IdVar(type);
		Yaka.tabIdent.rangeIdent (nom, id);
	}
}
