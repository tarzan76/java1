package assicurazione;

import java.util.LinkedList;

public class GestioneAssicurazione {
	private static LinkedList<Automobile> lautomobili;
	private static LinkedList<Polizza> lpolizze;
	public GestioneAssicurazione(){
	}
	
	public GestioneAssicurazione(LinkedList<Automobile>a,LinkedList<Polizza>p){
		lautomobili=a;
		lpolizze=p;
	}
	public static void main(String[] args) {
		Data im1=new Data(1,10,2013);
		Data im2=new Data(13,8,2002);
		Data im3=new Data(12,3,2015);
		Automobile a1=new Automobile("EC123TW",im1,"Marco","Fiat","Punto");
		Automobile a2=new Automobile("AS123TB",im2,"Francesco","Lancia","Y");
		Automobile a3=new Automobile("CZ123TQ",im3,"Paolo","Alfa Romeo","Giulietta");
		
		Data d1=new Data(10,3,2016);
		Data d2=new Data(11,4,2016);
		Data d3=new Data(28,7,2015);
		LinkedList<Incidente> inc1=new LinkedList<Incidente>();
		LinkedList<Incidente> inc2=new LinkedList<Incidente>();
		LinkedList<Incidente> inc3=new LinkedList<Incidente>();
		Polizza p1=new Polizza ("AA111",a1.getTarga(),d1,300.00,inc1);
		Polizza p2=new Polizza ("AA112",a2.getTarga(),d2,330.00,inc2);
		Polizza p3=new Polizza ("AA113",a3.getTarga(),d3,789.00,inc3);
		LinkedList<Automobile>l1=new LinkedList<Automobile>();
		LinkedList<Polizza> l2=new LinkedList<Polizza>();
		l1.add(a1);// riempio lista Automobile
		l1.add(a2);
		l1.add(a3);
		l2.add(p1);// riempio lista Polizza
		l2.add(p2);
		l2.add(p3);
		
		metodo(l1,l2);// passo le liste piene (Automobile e Polizza) al metodo "metodo"
	}
	
	public static void metodo(LinkedList<Automobile>l1,LinkedList<Polizza>l2){
		GestioneAssicurazione gA=new GestioneAssicurazione(l1,l2); 
		//creo oggetto gA per usare i metodi della classe, gli passo lista Automobile e Polizza
		
		Polizza d=gA.polizzaMaggiore();  //Trovo la polizza con costo maggiore
		Automobile a=gA.trovaAutomobile(d); //Trovo tramite la targa l'automobile associata alla polizza max trovata sopra
		System.out.println("Automobile "+a);
		boolean b=true;
		boolean aa=aggiungiIncidente(d.getCodice(),1,06,2015,90.0,b); //aggiungo incidente alla polizza trovata sopra
		if(aa)
			System.out.println("Incidente aggiunto");
		else
			System.out.println("Incidente non aggiunto");
		//aggiungi tre incidenti alla lista di incidenti nella polizza trovata sopra e
		//successivamente mi trovi la data dell'incidente con l'importo danni maggiore
		aggiungiIncidente(d.getCodice(), 2,02,2012, 100,true);
		aggiungiIncidente(d.getCodice(), 2,04,2012, 50,false);
		aggiungiIncidente(d.getCodice(), 2,05,2012, 10,false);
		Data dataMax=dataIncMax(d.getCodice());
		System.out.println(dataMax);
	}
		
	public static Data dataIncMax(String cod){
		double max=0;
		Data d=null;
		for(Polizza polizza:lpolizze)//scorro polizze
			if(polizza.getCodice().equals(cod))
				for(Incidente ii:polizza.getIncidenti())
					if(ii.getImporto()>max){
						max=ii.getImporto();
						d=ii.getDataIncidente();
					}
		return d;
	}
		
	public static Polizza polizzaMaggiore(){
		double max=lpolizze.getFirst().getPremio();//LinkedList<Polizza>
		Polizza pmax=lpolizze.getFirst();
		for(Polizza pi:lpolizze)// per ogni oggetto Polizza in lista lpolizze
			if(pi.getPremio()>max){
				max=pi.getPremio();// premio, costo //--------- NON SERVE?????
				pmax=pi;// il codice della polizza
			}
		System.out.println(pmax);//Camillo: ho sovrascritto toString();
		return pmax;// oggetto Polizza
	}
	public static Automobile trovaAutomobile(Polizza p){
		Automobile a=null;
		for(Automobile ai:lautomobili)
			if(ai.getTarga().equals(p.getTargaAutomobile()))//equals di Automobile (confronta targa)
				a=ai;
		return a;
	}
	public static boolean aggiungiIncidente(String codice,int g,int m,int a,double imp,boolean colpevole){
		Data d=new Data(g,m,a);
		Incidente inc=new Incidente(d,imp,colpevole);
		for(Polizza pi:lpolizze)// scorri la lista di polizze
			if(IncidentePresente(pi,inc)==false&&pi.getCodice().equals(codice)){//equals di Polizza
 //se la polizza non contiene questo incidente && il codice è uguale a quello in ingresso				
				pi.getIncidenti().add(inc);
		//della polizza ottieni la lista incidenti e aggiungi questo oggetto incidente	
				return true;
			}
		return false;
	}
	//Il meccanismo è come trovare un intero in un vettore di interi
	//il ciclo for è diverso
	public static boolean IncidentePresente(Polizza pol, Incidente inc){
		//  oggetto      oggetto Polizza LinkedList<Incidente>
		for(Incidente ii:pol.getIncidenti())//devo ricordare oggetti di LinkedList<Incidente>
			if(ii.equals(inc))
				return true;
		return false;
	}
}