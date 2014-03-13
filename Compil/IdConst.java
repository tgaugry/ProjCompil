package Compil;

public class IdConst extends Ident {
	
	public boolean estVar()
	{
		return false;
	}
	
	public IdConst(int type, int val)
	{
		super(type, val);
	}
	
	public IdConst(Ident i) {
		super(i.getType(), i.getValOuOffset());
	}

	public String toString(){
		return "IdConst type :" + type +" val :" + valOuOffset;
	}

	public String toYVM() {
		String res = "iconst "+ valOuOffset;
		return res;
	}
	
	public String toYVMAsm() {
		return "push " + valOuOffset;
	}
	
}
