package Compil;

import java.util.HashMap;
import java.util.Map.Entry;

public class TabIdent
{
	private HashMap<String,Ident> table;
	
	public TabIdent(int taille)
	{
		table = new HashMap<String,Ident>(taille);
	}
	
	public Ident chercherIdent(String clef)
	{
		return table.get(clef);
	}
	
	public boolean existeIdent(String clef)
	{
		return table.containsKey(clef);
	}
	
	public void rangeIdent(String clef, Ident id)
	{
		table.put(clef, id);
	}
	
	public int compteVariables(){
		int cpt=0;
		for(Entry<String, Ident> entry : table.entrySet()) {
			if(entry.getValue().estVar())
				cpt++;
		}
		return cpt;
	}
}
