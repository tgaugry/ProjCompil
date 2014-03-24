package Compil;

public abstract class Ident {

	
	public Ident()
	{
		
	}
	
	public abstract boolean estVar();
	
	public abstract String toString();
	
	public abstract String toYVM();
	public abstract String toYVMAsm();
}
