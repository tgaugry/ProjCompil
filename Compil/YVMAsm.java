package Compil;

public class YVMAsm extends YVM {
	
	public YVMAsm(String nomFic) {
		super(nomFic);
	}
	public void entete() {
		// ; entete
		// .model SMALL
		// .586
		// .CODE
		// debut:
		// STARTUPCODE
	}
	public void ouvreprinc() {
		// ; ouvrePrinc n
		// mov bp,sp
		// sub sp,n
	}
	public void iconst() {
		// push n
	}
	public void idiv(){
		/* pop bx
		 * pop ax
		 * cwd
		 * idiv bx
		 * push ax
		 */
	}
	public void iadd(){
		/* pop bx
		pop ax
		add ax,bx
		push ax
		*/
	}
	public void istore(){
		/* pop ax
		 * mow word ptr[bp-2],ax
		 */
	}
	
}
