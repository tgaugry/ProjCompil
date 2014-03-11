package Compil;

public class IdConst extends Ident {
	
	public boolean estVar()
	{
		return false;
	}
	
	public IdConst(int v)
	{
		super(Ident.TypeVar.INT, v);
	}
	
	public IdConst(boolean b)
	{
		super(Ident.TypeVar.BOOL, b? 1 : 0);
	}

	public String toString() {
		String res = "iconst "+ valOuOffset +"\n";
		return res;
	}
	
}
