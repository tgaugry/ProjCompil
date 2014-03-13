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

	public String toString(){
		return "IdVar type :" + type + "Offset :" + valOuOffset + " LastOffset :" + lastOffset;
	}

	public String toYVM() {
		String res = "iload "+ valOuOffset;
		return res;
	}
	
	public String toYVMAsm() {
		return "push word ptr[bp" + valOuOffset + "]";
	}
}
