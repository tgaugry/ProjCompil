package Compil;

public class IdVar extends Ident {
	public static int lastOffset;
	
	protected int offset;
	
	public boolean estVar()
	{
		return true;
	}
	
	public IdVar()
	{
		offset = (lastOffset-=2);
	}
	
	public getOffset()
	{
		return offset;
	}
}
