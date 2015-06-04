package assicurazione;

public class Incidente {
	private Data dataIncidente;
	private double importo;
	private boolean colpevole;
	public Incidente(){
		
	}
	public Incidente(Data dI,double i,boolean c){
		dataIncidente=dI;
		importo=i;
		colpevole=c;
	}
	public Data getDataIncidente() {
		return dataIncidente;
	}
	public void setDataIncidente(Data dataIncidente) {
		this.dataIncidente = dataIncidente;
	}
	public double getImporto() {
		return importo;
	}
	public void setImporto(double importo) {
		this.importo = importo;
	}
	public boolean isColpevole() {
		return colpevole;
	}
	public void setColpevole(boolean colpevole) {
		this.colpevole = colpevole;
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Incidente))
			return false;
		Incidente other = (Incidente) obj;
		if (!dataIncidente.equals(other.dataIncidente))
			return false;
		return true;
	}
}