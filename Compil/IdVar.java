package Compil;

public class IdVar extends IdVal {
	public static int lastOffset;
	
	
	/*public IdVar(int t, int offset)
	{
		super(t, offset);
	}
	
	public IdVar IdVarParam(int t) {
		return new IdVar(t, lastOffset+=2);
	}
	
	public IdVar IdVarLocal(int t) {
		return new IdVar(t, lastOffset-=2);
	}*/
	public IdVar(int t)
	{
		super(t, lastOffset-=2);
	}
	
	public boolean estVar()
	{
		return true;
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
