package Compil;

public class YVMAsm extends YVM {
	
	public YVMAsm(String nomFic) {
		super(nomFic);
	}
	public void entete() {
		Ecriture.ecrireStringln(output, "; entete\n" +
				".model SMALL\n" +
				".586\n" +
				".CODE\n" +
				"debut:\n" +
				"STARTUPCODE\n");
	}
	public void ouvrePrinc() {
		Ecriture.ecrireString(output, "; ouvrePrinc");
		Ecriture.ecrireInt(output, Yaka.tabIdent.compteVariables());
		Ecriture.ecrireString(output, "\nmov bp,sp\nsub sp,");
		Ecriture.ecrireInt(output, Yaka.tabIdent.compteVariables());
		Ecriture.ecrireStringln(output, "\n");
	}
	public void queue(){
		Ecriture.ecrireStringln(output, "; queue\n"
				+ "nop\n"
				+ "exitcode\n"
				+ "end debut\n");
	}
	public void iconst() {
		Ecriture.ecrireString(output, "; iconst\n"
				+ "push ");
		// faudrait récup le nombre, j'ai pas la doc, LAWL
		//Ecriture.ecrireInt(output, Yaka.tabIdent.compteVariables());
		Ecriture.ecrireStringln(output, "\n");
	}
	public void istore(){
		Ecriture.ecrireStringln(output, "; istore\n" +
				"pop ax\n" +
				"mov word ptr[bp-2],ax\n");
	}
	public void iload(){
		Ecriture.ecrireString(output, "; iload\n" +
				"push word ptr[bp");
		//
		Ecriture.ecrireStringln("]\n");
	
	}
	public void iadd(){
		Ecriture.ecrireStringln(output, "; iadd\n" +
				"pop bx\n" +
				"pop ax\n" +
				"add ax,bx\n" +
				"push ax\n");

	}
	public void isub() {
		Ecriture.ecrireStringln(output, "; isub\n"
				+ "pop bx\n"
				+ "pop ax\n"
				+ "sub ax,bx\n"
				+ "push ax\n");
	}
	public void imul(){
		Ecriture.ecrireStringln(output, "; imul\n"
				+ "pop bx\n"
				+ "pop ax\n"
				+ "imul bx\n"
				+ "push ax\n");

	}
	public void idiv(){
		Ecriture.ecrireStringln(output, "; idiv\n" +
				"pop bx\n" +
				"pop ax\n" +
				"cwd\n" +
				"idiv bx\n" +
				"push ax\n");
	}

	public void ior(){
		Ecriture.ecrireStringln(output, "; ior\n"
				+ "pop bx\n"
				+ "pop ax\n"
				+ "or ax,bx\n"
				+ "push ax\n");
	}
	public void iinfegal(){
		Ecriture.ecrireStringln(output, "; iinfegal\n"
				+ "pop bx\n"
				+ "pop ax\n"
				+ "cmp ax,bx\n"
				+ "jg $+6\n"
				+ "push -1\n"
				+ "jmp $+4\n"
				+ "push 0\n");
	}
	
	
}
