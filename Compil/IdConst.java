package Compil;

public class IdConst extends Ident {
	
	public boolean estVar()
	{
		return false;
	}
	
	public int IdConst(int v)
	{
		super(INT, v);
	}
	
	public int IdConst(boolean b)
	{
		super(BOOL, (int)b);
	}
	
}
