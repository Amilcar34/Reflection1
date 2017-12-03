package jarroba;

public class MiClase {
	
	private String otraVariableString = "Otro textito";
	public String unaVariableString = "Un Texto";
	long l = 359650L;
	private int unaVariableInt = 5;
	protected MiClase miClase = null;

	public String getUnaVariableString(String concatenar) {
		return unaVariableString + concatenar;
	}

	private int getUnaVariableInt(int suma) {
		return unaVariableInt + suma;
	}

	public long getL() {
		return l;
	}

	public MiClase(String unaVariableString, long l, int unaVariableInt, MiClase miClase) {
		super();
		this.unaVariableString = unaVariableString;
		this.l = l;
		this.unaVariableInt = unaVariableInt;
		this.miClase = miClase;
	}
	
	public MiClase() {}

	public void setUnaVariableString(String unaVariableString) {
		this.unaVariableString = unaVariableString;
	}

	public void setL(long l, boolean f) {
		this.l = l;
	}

	public void setUnaVariableInt(int unaVariableInt) {
		this.unaVariableInt = unaVariableInt;
	}

	public void setMiClase(MiClase miClase) {
		this.miClase = miClase;
	}

	
	
}
