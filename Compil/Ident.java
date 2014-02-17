package Compil;

public final enum Type {BOOL, INT};

public abstract class Ident {
	
	protected Type type;
	protected int valOuOffset;
	
	public Ident(Type t, int v)
	{
		type = t;
		valOuOffset = v;
	}
	
	public boolean estVar();
	
	public int getValOuOffset()
	{
		return valOuOffset;
	}
	
	public Type getType()
	{
		return type;
	}
}
