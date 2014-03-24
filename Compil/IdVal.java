package Compil;

public abstract class IdVal extends Ident {
	protected int valOuOffset;
	protected int type; //prend des valeurs de YakaConstants

	public IdVal(int t, int v) {
		super();
		type = t;
		valOuOffset = v;
	}
	
	public int getValOuOffset()
	{
		return valOuOffset;
	}
	
	public int getType()
	{
		return type;
	}

	@Override
	public abstract boolean estVar();

	@Override
	public abstract String toString();

	@Override
	public abstract String toYVM();

	@Override
	public abstract String toYVMAsm();

}
