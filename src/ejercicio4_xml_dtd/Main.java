package ejercicio4_xml_dtd;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
/**
 * @author Gabriel Moreno
 */
public class Main {

    public static void main(String[] args) {
        File file = new File("Ejercicio1&3_XML.xml");
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();

            Menu.menuPrincipal(doc, Menu.opcMenuPrincipal);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
