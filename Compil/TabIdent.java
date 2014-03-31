package Compil;

import java.util.HashMap;
import java.util.Map.Entry;

public class TabIdent {
	
	private HashMap<String,IdFonc> globaux;
	private HashMap<String,IdVal> locaux;
	
	public TabIdent()
	{
		globaux = new HashMap<String,IdFonc>();
		locaux = new HashMap<String,IdVal>();
	}
	
	public IdVal chercherIdent(String clef)
	{	
		IdVal i = locaux.get(clef); 
		if (i == null){
			Yaka.afficherErreur("L'identifiant "+ clef + " n'existe pas");
		}
		return i;
	}
	
	public IdFonc chercherFonc(String clef)
	{	
		IdFonc i = globaux.get(clef); 
		if (i == null){
			Yaka.afficherErreur("L'identifiant "+ clef + " n'existe pas");
		}
		return i;
	}
	
	public boolean existeIdent(String clef)
	{
		return locaux.containsKey(clef);
	}
	
	public void rangeIdent(String clef, IdVal id)
	{
		Ident i = locaux.get(clef); 
		if (i != null){
			Yaka.afficherErreur("L'identifiant " + clef + " est déclaré plusieurs fois");
		}
		locaux.put(clef, id);
	}
	
	public void rangeIdent(String clef, IdFonc id)
	{
		Ident i = globaux.get(clef); 
		if (i != null){
			Yaka.afficherErreur("L'identifiant " + clef + " est déclaré plusieurs fois");
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
	
	public void ajouteParam(String nom, int type) {
		chercherFonc(nom).ajouteParam(type);
	}
	
	public int getNbParam(String foncName)
	{
		return chercherFonc(foncName).getParam().size();
	}
	
	public void videLocaux()
	{
		locaux.clear();
	}
	
}
