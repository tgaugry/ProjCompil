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
	public void ouvreprinc() {
		Ecriture.ecrireString(output, "; ouvrePrinc");
		Ecriture.ecrireInt(output, Yaka.tabIdent.compteVariables());
		Ecriture.ecrireString(output, "\nmov bp,sp\nsub sp,");
		Ecriture.ecrireInt(output, Yaka.tabIdent.compteVariables());
		Ecriture.ecrireStringln(output, "");
	}
	public void iconst() {
		Ecriture.ecrireString(output, "; iconst\npush ");
		// faudrait récup le nombre, j'ai pas la doc, LAWL
		//Ecriture.ecrireInt(output, Yaka.tabIdent.compteVariables());
		Ecriture.ecrireStringln(output, "");
	}
	public void idiv(){
		Ecriture.ecrireStringln(output, "; idiv\n" +
				"pop bx\n" +
				"pop ax\n" +
				"cwd\n" +
				"idiv bx\n" +
				"push ax");
	}
	public void iadd(){
		Ecriture.ecrireStringln(output, "; iadd\n" +
				"pop bx\n" +
				"pop ax\n" +
				"add ax,bx\n" +
				"push ax");
	}
	public void istore(){
		Ecriture.ecrireStringln(output, "; istore\n" +
				"pop ax\n" +
				"mov word ptr[bp-2],ax");
	}
	
}
