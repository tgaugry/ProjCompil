package Compil;

public class IdVar extends Ident {
	public static int lastOffset;
	
	public boolean estVar()
	{
		return true;
	}
	
	public IdVar(TypeVar t)
	{
		super(t, (lastOffset-=2));
	}
}
