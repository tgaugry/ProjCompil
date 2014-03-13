package Compil;

public abstract class Ident {
	
	protected int type; //prend des valeurs de YakaConstants
	protected int valOuOffset;
	
	//public enum TypeVar {BOOL, INT};
	
	public Ident(int t, int v)
	{
		type = t;
		valOuOffset = v;
	}
	
	public abstract boolean estVar();
	
	public int getValOuOffset()
	{
		return valOuOffset;
	}
	
	public int getType()
	{
		return type;
	}
	
	public abstract String toString();
	
	public abstract String toYVM();
	public abstract String toYVMAsm();
}
