package Compil;

import java.util.Stack;

public class Fonction {
	public Stack<String> foncts;
	public Stack<Stack<Integer>> typesParam; // prends ses valeurs dans YakaConstants

	public Fonction(){
		foncts = new Stack<String>();
		typesParam = new Stack<Stack<Integer>>();
	}

	public void empilerFonct(String name)
	{
		typesParam.push(new Stack<Integer>());
		foncts.push(name);
	}
	
	public String depilerFonct()
	{
		typesParam.pop();
		return foncts.pop();
	}

	public String getFonctCourante()
	{
		return foncts.peek();
	}
	
	public void empilerParam(int type)
	{
		typesParam.peek().push(type);
	}
	
	public int depilerParam()
	{
		return typesParam.peek().pop();
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
		int nbParamsAttendus = paramAttendus.size();
		while(!typesParam.peek().empty() && nbParamsAttendus > 0)
		{
			nbParamsAttendus--; //pour l'utiliser comme index
			if((temp1 = depilerParam()) != (temp2 = paramAttendus.get(nbParamsAttendus))) {
				Yaka.afficherErreur("Parametre incorrect : "+typeToString(temp1)+" lu, "+typeToString(temp2)+" attendu");
			}
		}
		if(!typesParam.peek().empty()) {
			Yaka.afficherErreur("Trop de parametres");
		}
		if(nbParamsAttendus > 0) { //si tout se passe bien il est à -1 à la fin de la boucle
			Yaka.afficherErreur("Parametre manquant");
		}
		//typesParam.pop(); //géré dans dépileFonction
	}
	
	public void verifieRetour(int operande, String nomFonc) {
		int typeRetourVoulu = Yaka.tabIdent.chercherFonc(nomFonc).getRetour();
		if (typeRetourVoulu != operande){
			Yaka.afficherErreur("Mauvais type de retour pur la fonction " + nomFonc + ", un " + (typeRetourVoulu == 15 ? "ENTIER" : "BOOLEEN") + " était attendu.");
		}
	}
}
