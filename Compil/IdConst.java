package Compil;

public class IdConst extends Ident {
	
	public boolean estVar()
	{
		return false;
	}
	
	public IdConst(int v)
	{
		super(Ident.Type.INT, v);
	}
	
	public IdConst(boolean b)
	{
		super(Ident.Type.BOOL, b? 1 : 0);
	}
	
}
