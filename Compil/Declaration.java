package Compil;

import Compil.TabIdent.KeyAlreadyThereException;

public class Declaration {

	public void declConst(String nom, int type, int val)
	{
		try {
			IdConst id = new IdConst(type, val);
			Yaka.tabIdent.rangeIdent (nom, id);
		}
		catch (Exception e){
			System.out.println(e.getMessage());
			Yaka.nbErreurs++;
		}
	}
	
	public void declConst(String nom, String nomBis) {
		try {
			IdConst id = new IdConst(Yaka.tabIdent.chercherIdent(nomBis));
			Yaka.tabIdent.rangeIdent (nom, id);
		}
		catch (Exception e){
			System.out.println(e.getMessage());
			Yaka.nbErreurs++;
		}
	}
	
	public void declVar(String nom, int type) {
		try {
			IdVar id = IdVar.newIdVarLocal(type);
			Yaka.tabIdent.rangeIdent (nom, id);
		}
		catch (Exception e){
			System.out.println(e.getMessage());
			Yaka.nbErreurs++;
		}
	}
}
