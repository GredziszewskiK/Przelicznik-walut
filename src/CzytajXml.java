import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * 
 * @author Krzysztof Grêdziszewski
 *
 */
public class CzytajXml {
	
	private static ArrayList<Object> lista;
	private static Node nNode;	
	private static NodeList nList;
	private static String[] odczytaneDane;
	
	/**
	 * Metoda odczytuje nazwy walut z pliku xml.
	 * @return tabele z nazwami walut
	 */
	public static String[] nazwyWalut(){
		try {	
			pars();
			for (int temp = 0; temp < nList.getLength(); temp++) {
				nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {		 
					Element eElement = (Element) nNode;						
					lista.add(eElement.getElementsByTagName("nazwa_waluty").item(0).getTextContent());
				}
			}
			lista.add("PLN");
			odczytaneDane = (String[]) lista.toArray(new String[0]);		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return odczytaneDane;
	}
	
	/**
	 * Metoda pobiera przelicznik oraz kurs wszystkich walut w pliku xml.
	 * @return tabele z danymi (nazwa_waluty, przelicznik, kurs_sredni)
	 */
	public static String[] kursWalut() {
	
		try{	
			pars();
			for (int temp = 0; temp < nList.getLength(); temp++) {
				nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {	
									
					Element eElement = (Element) nNode;						
					lista.add(eElement.getElementsByTagName("nazwa_waluty").item(0).getTextContent());
					lista.add(eElement.getElementsByTagName("przelicznik").item(0).getTextContent());
					lista.add(eElement.getElementsByTagName("kurs_sredni").item(0).getTextContent());
				}
			}				
			odczytaneDane = (String[]) lista.toArray(new String[0]);
				
		} catch (Exception e) {					
			e.printStackTrace();					
		}
		return odczytaneDane;
	}
	
	private static void pars() {
		try {
			File fXmlFile = new File("LastA.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
						
			doc.getDocumentElement().normalize();
			nList = doc.getElementsByTagName("pozycja");
			lista = new ArrayList<Object>();
			
		} catch (Exception e) {			
			e.printStackTrace();			
		}		
	}
}