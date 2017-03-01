import java.io.IOException;

public class Run {	
	
	public static void main(String[] args) throws IOException {	
		
		Pobieranie.Pobierz();		
		Gui okno = new Gui(CzytajXml.nazwyWalut());
		
	}
}