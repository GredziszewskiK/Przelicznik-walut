/**
 * Klasa odpowiedzialna za przeliczenie na wskazan¹ walutê.
 * 
 * @author Krzysztof Grêdziszewski
 * @param wpisanaLiczba podana liczba do przeliczenia
 * @param walutaA nazwa waluty z której wartoœæ podajemy
 * @param walutaB nazwa waluty na która przeliczamy
 *
 */
public class Obliczenia {

	//wartoœci u¿ywane w obliczeniach
	private double a,b,c;
	//nazwy walut
	private String walutaA, walutaB;
	
	public Obliczenia(String wpisanaLiczba,String walutaA, String walutaB) {
		this.a = Double.parseDouble(wpisanaLiczba.replace(",",	"."));
		this.walutaA = walutaA;
		this.walutaB = walutaB;
	}
	
	/**
	 *  
	 * @return przeliczona wartosc z walutyA na waluteB
	 * 
	 */
	public double oblicz()	{
		dane(walutaA);
		a=a*(b/c);
		dane(walutaB);
		a=a/(b/c);
		a*=100;
		a = Math.round(a);
		a /=100;
		return a;
	}
	
	//pobiera dane z pliku xml: przelicznik waluty i kurs
	private void dane(String nazwaWaluty)	{
			
		String[] tabelaWartosci = CzytajXml.kursWalut();		
		for(int i=0; i<tabelaWartosci.length;i++) {
			
			if(tabelaWartosci[i].equals(nazwaWaluty)){
				i=i+1;
				c = Double.parseDouble(tabelaWartosci[i]);					
				i=i+1;					
				b = Double.parseDouble(tabelaWartosci[i].replace(',','.'));
				
			}else if(nazwaWaluty.equals("PLN")){					
				c = 1;										
				b = 1;
			}
		}
	}	
}