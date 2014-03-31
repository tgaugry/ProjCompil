package Compil;

import java.util.Stack;

public class Fonction {
	public Stack<String> foncts;
	public Stack<Integer> typesParam; // prends ses valeurs dans YakaConstants

	public Fonction(){
		foncts = new Stack<String>();
		typesParam = new Stack<Integer>();
	}

	public void empilerFonct(String name)
	{
		foncts.push(name);
	}
	
	public String depilerFonct()
	{
		return foncts.pop();
	}

	public String getFonctCourante()
	{
		return foncts.peek();
	}
	
	public void empilerParam(int type)
	{
		typesParam.push(type);
	}
	
	public void depilerParam()
	{
		typesParam.pop();
	}

	private static String typeToString(int type)
	{
			String t ="";
			switch(type)
			{
				case YakaConstants.ENTIER:
					t = "entier";
					break;
				case YakaConstants.BOOLEEN:
					t = "booleen";
					break;
				default:
					break;
			}
		return t;
	}

	public void verifieParams()
	{
		int temp1;
		int temp2;
		Stack<Integer> paramAttendus = Yaka.tabIdent.chercherFonc(foncts.peek()).getParam();
		while(!typesParam.empty() && !paramAttendus.empty())
		{
			if((temp1 = typesParam.pop()) != (temp2 = paramAttendus.pop())) {
				Yaka.afficherErreur("Parametre incorrect : "+typeToString(temp1)+" lu, "+typeToString(temp2)+" attendu");
			}
		}
		if(!typesParam.empty()) {
			Yaka.afficherErreur("Trop de parametres");
		}
		if(!paramAttendus.empty()) {
			Yaka.afficherErreur("Parametre manquant");
		}
	}
}
