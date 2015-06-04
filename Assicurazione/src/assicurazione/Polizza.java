package assicurazione;

import java.util.LinkedList;

public class Polizza {
	private String codice;
	private String targaAutomobile;
	private Data dataScadenza;
	private double premio;
	private LinkedList<Incidente> incidenti;// =new LinkedList<Incidente>();
	
	public Polizza(){
	}
	public Polizza(String c,String tA,Data dS,double p,LinkedList<Incidente>i){
		codice=c;
		targaAutomobile=tA;
		dataScadenza=dS;
		premio=p;
		incidenti=i;
	}
	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	public String getTargaAutomobile() {
		return targaAutomobile;
	}
	public void setTargaAutomobile(String targaAutomobile) {
		this.targaAutomobile = targaAutomobile;
	}
	public Data getDataScadenza() {
		return dataScadenza;
	}
	public void setDataScadenza(Data dataScadenza) {
		this.dataScadenza = dataScadenza;
	}
	public double getPremio() {
		return premio;
	}
	public void setPremio(double premio) {
		this.premio = premio;
	}
	public LinkedList<Incidente> getIncidenti() {
		return incidenti;
	}
	public void setIncidenti(LinkedList<Incidente> incidenti) {
		this.incidenti = incidenti;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Polizza))
			return false;
		Polizza other = (Polizza) obj;
		 if (!codice.equals(other.codice))
			return false;
		return true;
	}
	@Override
	public String toString(){//Camillo
		String s=""+"Polizza: codice "+codice+", targa "+targaAutomobile+", data scadenza "+dataScadenza+", premio "+premio;
		return s;
	}
}