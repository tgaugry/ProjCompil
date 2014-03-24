package Compil;

import java.util.HashMap;
import java.util.Map.Entry;

public class TabIdent {
	
	private HashMap<String,IdFonc> globaux;
	private HashMap<String,IdVal> locaux;
	
	
	public static class NoSuchKeyException extends Exception {
		private static final long serialVersionUID = 1L;

		public NoSuchKeyException(String clef){
			super("L'identifiant "+ clef + " n'existe pas" + Yaka.afficherLigne());
		}
	}
	
	public static class KeyAlreadyThereException extends Exception {
		private static final long serialVersionUID = 1L;

		public KeyAlreadyThereException(String clef){
			super("L'identifiant " + clef + " est déclaré plusieurs fois" + Yaka.afficherLigne());
		}
	}
	
	public TabIdent()
	{
		globaux = new HashMap<String,IdFonc>();
		locaux = new HashMap<String,IdVal>();
	}
	
	public IdVal chercherIdent(String clef) throws NoSuchKeyException
	{	
		IdVal i = locaux.get(clef); 
		if (i == null){
			throw new NoSuchKeyException(clef);
		}
		return i;
	}
	
	public IdFonc chercherFonc(String clef) throws NoSuchKeyException
	{	
		IdFonc i = globaux.get(clef); 
		if (i == null){
			throw new NoSuchKeyException(clef);
		}
		return i;
	}
	
	public boolean existeIdent(String clef)
	{
		return locaux.containsKey(clef);
	}
	
	public void rangeIdent(String clef, IdVal id)// throws KeyAlreadyThereException
	{
		Ident i = locaux.get(clef); 
		if (i != null){
			//throw new KeyAlreadyThereException(clef);
		}
		locaux.put(clef, id);
	}
	
	public void rangeIdent(String clef, IdFonc id)// throws KeyAlreadyThereException
	{
		Ident i = globaux.get(clef); 
		if (i != null){
			//throw new KeyAlreadyThereException(clef);
		}
		globaux.put(clef, id);
	}
	
	public int compteVariables(){
		int cpt=0;
		for(Entry<String, IdVal> entry : locaux.entrySet()) {
			if(entry.getValue().estVar())
				cpt++;
		}
		return cpt;
	}
	
	public void ajouteParam(String nom, int type) throws NoSuchKeyException {
		chercherFonc(nom).ajouteParam(type);
	}
	
}
