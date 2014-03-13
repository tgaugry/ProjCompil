package Compil;

public class IdConst extends Ident {
	
	public boolean estVar()
	{
		return false;
	}
	
	public IdConst(int v)
	{
		super(YakaConstants.ENTIER, v);
	}
	
	public IdConst(boolean b)
	{
		super(YakaConstants.BOOLEEN, b? YakaConstants.VRAI : YakaConstants.FAUX);
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
