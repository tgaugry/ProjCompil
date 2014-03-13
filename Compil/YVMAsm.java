package Compil;

public class YVMAsm extends YVM {
	
	public YVMAsm(String nomFic) {
		super(nomFic);
	}
	
	
	public void debutProg() {
		Ecriture.ecrireStringln(output, "; entete\n" +
				".model SMALL\n" +
				".586\n" +
				".CODE\n" +
				"debut:\n" +
				"STARTUPCODE\n");
	}
	public void ouvrePrinc() {
		int nbVar = Yaka.tabIdent.compteVariables();
		Ecriture.ecrireString(output, "; ouvrePrinc");
		Ecriture.ecrireInt(output, nbVar);
		Ecriture.ecrireString(output, "\nmov bp,sp\nsub sp,");
		Ecriture.ecrireInt(output, nbVar);
		Ecriture.ecrireStringln(output, "\n");
	}
	public void finProg(){
		Ecriture.ecrireStringln(output, "; queue\n"
				+ "nop\n"
				+ "exitcode\n"
				+ "end debut\n");
	}
	
	
	public void lireConstOuVar(String nom) {
		Ecriture.ecrireString(output, "; iconst\n");
		Ident i = Yaka.tabIdent.chercherIdent(nom);
		String texte = i.toYVMAsm();
		Ecriture.ecrireStringln(output, texte);
	}
	public void lireImmediat(int i){
		Ecriture.ecrireStringln(output, "push "+i);
	}
	public void affecter(String nom){
		Ident i = Yaka.tabIdent.chercherIdent(nom);
		Ecriture.ecrireStringln(output, "; istore\n"
				+ "pop ax\n"
				+ "mov word ptr[bp"
				+ i.getValOuOffset()
				+ "],ax\n");
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
}
