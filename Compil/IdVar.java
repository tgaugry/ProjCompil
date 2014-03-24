package Compil;

public class IdVar extends IdVal {
	public static int lastOffset;
	
	public boolean estVar()
	{
		return true;
	}
	
	public IdVar(int t)
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
		return "; iload " + valOuOffset + "\npush word ptr[bp" + valOuOffset + "]";
	}
	
	public static void resetOffsets()
	{
		lastOffset = 0;
	}
	
}
