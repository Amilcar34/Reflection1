package jarroba;

public class MiClase {
	
	public String unaVariableString = "Un Texto";
	private String otraVariableString = "Otro textito";
	public String terceraVariable = null;
	long l = 359650L;
	private int unaVariableInt = 5;
	public int varInt= 4;

	public String getUnaVariableString(String concatenar) {
		return unaVariableString + concatenar;
	}

	private int getUnaVariableInt(int suma) {
		return unaVariableInt + suma;
	}

	public long getL() {
		return l;
	}

	public MiClase(String unaVariableString, long l, int unaVariableInt) {
		super();
		this.unaVariableString = unaVariableString;
		this.l = l;
		this.unaVariableInt = unaVariableInt;

	}
	
	public MiClase() {}

	public void setUnaVariableString(String unaVariableString) {
		this.unaVariableString = unaVariableString;
	}

	public void setL(long l, boolean f) {
		this.l = l;
	}

	public void setOtraVariableString(String otraVariableString) {
		this.otraVariableString = otraVariableString;
	}

	public void setUnaVariableInt(int unaVariableInt) {
		this.unaVariableInt = unaVariableInt;
	}


	public String getUnaVariableString() {
		return unaVariableString;
	}

	public String getOtraVariableString() {
		return otraVariableString;
	}

	public String getTerceraVariable() {
		return terceraVariable;
	}

	public int getVarInt() {
		return varInt;
	}	
}
