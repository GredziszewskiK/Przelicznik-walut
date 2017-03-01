import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class Pobieranie {
	/**
	 * Metoda pobiera plik xml z aktualnymi kursami, ze strony NBP.
	 * @throws IOException
	 */
	public static void Pobierz() throws IOException {
		
		URL url = new URL("http://nbp.pl/kursy/xml/LastA.xml");
		InputStream ip = url.openStream();
		OutputStream op = new FileOutputStream("LastA.xml");
		
		byte[] dane = new byte[1024];
		int linczik;
		while( (linczik =ip.read(dane)) != -1){
			
			op.write(dane, 0, linczik);
			
		}		
		ip.close();
		op.close();
	}
}