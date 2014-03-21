package Compil;

import Compil.TabIdent.NoSuchKeyException;

public class YVMAsm extends YVM {
	private int nbChaines;
	
	public YVMAsm(String nomFic) {
		super(nomFic);
		nbChaines = 0;
	}
	
	
	public void debutProg() {
		Ecriture.ecrireStringln(output, "extrn lirent:proc, ecrent:proc\n"
				+ "extrn ecrbool:proc\n"
				+ "extrn ecrch:proc, ligsuiv:proc\n"
				+ "; entete\n"
				+ ".model SMALL\n"
				+ ".586\n\n"
				+ ".CODE\n"
				+ "debut:\n"
				+ "STARTUPCODE\n");
	}
	public void ouvrePrinc() {
		int nbVar = Yaka.tabIdent.compteVariables()*2;
		Ecriture.ecrireString(output, "; ouvrePrinc ");
		Ecriture.ecrireInt(output, nbVar);
		Ecriture.ecrireString(output, "\nmov bp,sp\nsub sp,");
		Ecriture.ecrireInt(output, nbVar);
		Ecriture.ecrireStringln(output, "\n");
	}
	public void finProg(){
		Ecriture.ecrireStringln(output, "; queue\n"
				+ "nop\n"
				+ "EXITCODE\n"
				+ "End debut\n");
	}
	
	
	public void lireConstOuVar(String nom) {
		try {
			Ident i = Yaka.tabIdent.chercherIdent(nom);
			String texte = i.toYVMAsm();
			Ecriture.ecrireStringln(output, texte + "\n");
		}
		catch (Exception e){
			System.out.println(e.getMessage());
			Yaka.nbErreurs++;
		}
	}
	public void lireImmediat(int i){
		Ecriture.ecrireStringln(output, "; iconst " + i + "\npush word ptr " + i + "\n");
	}
	public void affecter(String nom) {
		try {
			Ident i = Yaka.tabIdent.chercherIdent(nom);
		int offset = i.getValOuOffset();
		Ecriture.ecrireStringln(output, "; istore " + offset + "\n"
					+ "pop ax\n"
					+ "mov word ptr[bp"
				+ offset
				+ "], ax\n");
		}
		catch (Exception e){
			System.out.println(e.getMessage());
			Yaka.nbErreurs++;
		}
	}
	
	
	public void lireAdd(){
		Ecriture.ecrireStringln(output, "; iadd\n" +
				"pop bx\n" +
				"pop ax\n" +
				"add ax,bx\n" +
				"push ax\n");

	}
	public void lireSous() {
		Ecriture.ecrireStringln(output, "; isub\n"
				+ "pop bx\n"
				+ "pop ax\n"
				+ "sub ax,bx\n"
				+ "push ax\n");
	}
	public void lireMul(){
		Ecriture.ecrireStringln(output, "; imul\n"
				+ "pop bx\n"
				+ "pop ax\n"
				+ "imul bx\n"
				+ "push ax\n");
	}
	public void lireDiv(){
		Ecriture.ecrireStringln(output, "; idiv\n" +
				"pop bx\n" +
				"pop ax\n" +
				"cwd\n" +
				"idiv bx\n" +
				"push ax\n");
	}
	public void lireNeg(){
		Ecriture.ecrireStringln(output, "; ineg\n"
				+ "pop bx\n"
				+ "mov ax, 0\n"
				+ "sub ax,bx\n"
				+ "push ax\n");
	}


	public void lireNon(){
		Ecriture.ecrireStringln(output, "; inot\n"
				+ "pop ax\n"
				+ "not ax\n"
				+ "push ax\n");
	}
	public void lireOu(){
		Ecriture.ecrireStringln(output, "; ior\n"
				+ "pop bx\n"
				+ "pop ax\n"
				+ "or ax,bx\n"
				+ "push ax\n");
	}
	public void lireEt(){
		Ecriture.ecrireStringln(output, "; iand\n"
				+ "pop bx\n"
				+ "pop ax\n"
				+ "and ax,bx\n"
				+ "push ax\n");
	}
	
	
	public void lireInf(){
		Ecriture.ecrireStringln(output, "; iinf\n"
				+ "pop bx\n"
				+ "pop ax\n"
				+ "cmp ax,bx\n"
				+ "jge $+6\n"
				+ "push -1\n"
				+ "jmp $+4\n"
				+ "push 0\n");
	}
	public void lireInfEg(){
		Ecriture.ecrireStringln(output, "; iinfegal\n"
				+ "pop bx\n"
				+ "pop ax\n"
				+ "cmp ax,bx\n"
				+ "jg $+6\n"
				+ "push -1\n"
				+ "jmp $+4\n"
				+ "push 0\n");
	}
	public void lireSup(){
		Ecriture.ecrireStringln(output, "; isup\n"
				+ "pop bx\n"
				+ "pop ax\n"
				+ "cmp ax,bx\n"
				+ "jle $+6\n"
				+ "push -1\n"
				+ "jmp $+4\n"
				+ "push 0\n");
	}
	public void lireSupEg(){
		Ecriture.ecrireStringln(output, "; isupegal\n"
				+ "pop bx\n"
				+ "pop ax\n"
				+ "cmp ax,bx\n"
				+ "jl $+6\n"
				+ "push -1\n"
				+ "jmp $+4\n"
				+ "push 0\n");
	}
	public void lireEg(){
		Ecriture.ecrireStringln(output, "; iegal\n"
				+ "pop bx\n"
				+ "pop ax\n"
				+ "cmp ax,bx\n"
				+ "jne $+6\n"
				+ "push -1\n"
				+ "jmp $+4\n"
				+ "push 0\n");
	}
	public void lireDiff(){
		Ecriture.ecrireStringln(output, "; idiff\n"
				+ "pop bx\n"
				+ "pop ax\n"
				+ "cmp ax,bx\n"
				+ "je $+6\n"
				+ "push -1\n"
				+ "jmp $+4\n"
				+ "push 0\n");
	}
	

	public void ecrireEnt() {
		Ecriture.ecrireStringln(output, "; ecrireEnt\n"
				+ "call ecrent\n");
	}
	
	public void ecrireBool() {
		Ecriture.ecrireStringln(output, "; ecrireBool\n"
				+ "call ecrbool\n");
	}
	public void ecrireChaine(String chaine) {
		Ecriture.ecrireStringln(output, "; ecrireChaine "
				+ chaine);
		chaine = chaine.substring(0, chaine.length()-1);
		chaine += "$\"";
		Ecriture.ecrireStringln(output, ".DATA\n"
				+ "mess" + nbChaines +  " DB " + chaine + "\n"
				+ ".CODE\n"
				+ "lea dx, mess" + nbChaines + "\n"
				+ "push dx\n"
				+ "call ecrch\n");
		nbChaines++;
	}
	public void aLaLigne() {
		Ecriture.ecrireStringln(output, "; aLaLigne\n"
				+ "call ligsuiv\n");
	}
	public void lireEnt(String id) {
		try {
			Ident i = Yaka.tabIdent.chercherIdent(id) ;
			int ent = i.getValOuOffset();
			Ecriture.ecrireStringln(output, "; lireEnt "
					+ ent + "\n"
					+ "lea dx, [bp" + ent + "]\n"
					+ "push dx\n"
					+ "call lirent\n");
		}
		catch (Exception e){
			System.out.println(e.getMessage());
			Yaka.nbErreurs++;
		}
	}
	
	public void dtantQue() {
		Ecriture.ecrireString(output, "FAIRE");
		Ecriture.ecrireInt(output, Iteration.getEtiquette());
		Ecriture.ecrireStringln(output, ":");
	}
	public void ftantQue() {
		int etiquette = Iteration.getEtiquette();
		Ecriture.ecrireString(output, "; goto FAIRE");
		Ecriture.ecrireInt(output, etiquette);
		Ecriture.ecrireStringln(output, "");
		
		Ecriture.ecrireString(output, "jmp FAIRE");
		Ecriture.ecrireInt(output, etiquette);
		Ecriture.ecrireStringln(output, "\n");
		
		Ecriture.ecrireString(output, "FAIT");
		Ecriture.ecrireInt(output, etiquette);
		Ecriture.ecrireStringln(output, ":");
	}
	public void condtantQue() {
		Ecriture.ecrireStringln(output, "; iffaux FAIT" + Iteration.getEtiquette());
		Ecriture.ecrireStringln(output, "pop ax");
		Ecriture.ecrireStringln(output, "cmp ax, 0");
		Ecriture.ecrireStringln(output, "je FAIT" + Iteration.getEtiquette() + "\n");
	}
	
	/*
	 * Fonctions de conditionelles 
	 */

	public void lireAlors(){
		String etiquette = "SINON"+Yaka.conditionnelle.nouvelleCond();
		Ecriture.ecrireStringln(output, "; iffaux "+etiquette);
		Ecriture.ecrireStringln(output, "pop ax");
		Ecriture.ecrireStringln(output, "cmp ax, 0");
		Ecriture.ecrireStringln(output, "je "+etiquette+"\n");
		
	}
	
	public void lireSinon(){
		String etiquetteSinon = "SINON"+Yaka.conditionnelle.getCondCourante();
		String etiquetteFsi = "FSI"+Yaka.conditionnelle.getCondCourante();
		Ecriture.ecrireStringln(output, "; goto "+etiquetteFsi);
		Ecriture.ecrireStringln(output, "jmp "+etiquetteFsi+"\n");
		Ecriture.ecrireStringln(output, etiquetteSinon+":");
	}
	
	public void lireFSi(){
		String etiquetteFsi = "FSI"+Yaka.conditionnelle.finitCond();
		Ecriture.ecrireStringln(output, etiquetteFsi+":\n");
	}
}
