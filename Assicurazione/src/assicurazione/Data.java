package assicurazione;

public class Data {
	private int giorno;
	private int mese;
	private int anno;
	public Data(){
		
	}
	public Data(int g,int m,int a){
		giorno=g;
		mese=m;
		anno=a;
	}
	public int getGiorno() {
		return giorno;
	}
	public void setGiorno(int giorno) {
		this.giorno = giorno;
	}
	public int getMese() {
		return mese;
	}
	public void setMese(int mese) {
		this.mese = mese;
	}
	public int getAnno() {
		return anno;
	}
	public void setAnno(int anno) {
		this.anno = anno;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Data))
			return false;
		Data other = (Data) obj;
		if (anno != other.anno)
			return false;
		if (giorno != other.giorno)
			return false;
		if (mese != other.mese)
			return false;
		return true;
	}
	public String toString(){
		String s=""+"Giorno: "+giorno+" Mese: "+mese+" Anno: "+anno;
		return s;
	}
}
