package Compil;



public abstract class Ident {
	
	protected Type type;
	protected int valOuOffset;
	public enum Type {BOOL, INT};
	
	public Ident(Type t, int v)
	{
		type = t;
		valOuOffset = v;
	}
	
	public abstract boolean estVar();
	
	public int getValOuOffset()
	{
		return valOuOffset;
	}
	
	public Type getType()
	{
		return type;
	}
}
