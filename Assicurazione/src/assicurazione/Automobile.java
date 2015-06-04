package assicurazione;

public class Automobile {
	private String targa;
	private Data dataImmatricolazione;
	private String proprietario;
	private String marca;
	private String modello;
	
	public Automobile(){
	}
	public Automobile(String t,Data dI,String p,String ma,String mo){
		targa=t;
		dataImmatricolazione=dI;
		proprietario=p;
		marca=ma;
		modello=mo;
	}
	public String getTarga() {
		return targa;
	}
	public void setTarga(String targa) {
		this.targa = targa;
	}
	public Data getDataImmatricolazione() {
		return dataImmatricolazione;
	}
	public void setDataImmatricolazione(Data dataImmatricolazione) {
		this.dataImmatricolazione = dataImmatricolazione;
	}
	public String getProprietario() {
		return proprietario;
	}
	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModello() {
		return modello;
	}
	public void setModello(String modello) {
		this.modello = modello;
	}
	
	@Override
	public boolean equals(Object obj) {//confronta solo la targa
		if(!(obj instanceof Automobile ))//----------l'ho aggiunto correttamente???
			return false;
		Automobile other = (Automobile) obj;
		if (!targa.equals(other.targa))
			return false;
		return true;
	}
	
	public String toString(){
		String s=""+"targa: "+targa+" marca: "+marca+" modello: "+modello;
		return s;
	}
}