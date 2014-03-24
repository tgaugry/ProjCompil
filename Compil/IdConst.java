package Compil;

public class IdConst extends IdVal {
	
	public boolean estVar()
	{
		return false;
	}
	
	public IdConst(int type, int val)
	{
		super(type, val);
	}
	
	public IdConst(IdVal i) {
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
		return "; iconst " + valOuOffset + "\npush word ptr " + valOuOffset;
	}
	
}
