package Compil;

public abstract class Ident {
	
	protected TypeVar type;
	protected int valOuOffset;
	public enum TypeVar {BOOL, INT};
	
	public Ident(TypeVar t, int v)
	{
		type = t;
		valOuOffset = v;
	}
	
	public abstract boolean estVar();
	
	public int getValOuOffset()
	{
		return valOuOffset;
	}
	
	public TypeVar getType()
	{
		return type;
	}
	
	public abstract String toString();
	
	public abstract String toYVM();
	public abstract String toYVMAsm();
}
