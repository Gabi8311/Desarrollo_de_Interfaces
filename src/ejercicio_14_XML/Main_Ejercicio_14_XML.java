package ejercicio_14_XML;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
/**
 *
 * @author Gabriel Moreno
 */
public class Main_Ejercicio_14_XML {
    
    public static void main(String[] args) {
     String nombre_archivo = "concesionario";
        ArrayList marcas = new ArrayList(); 
        ArrayList modelos = new ArrayList();
        ArrayList cilindradas = new ArrayList();

        marcas.add("Renault");
        marcas.add("Seat");
        marcas.add("Suzuki");
        marcas.add("Suzuki");
        marcas.add("Suzuki");
       
        modelos.add("Megane");
        modelos.add("León");
        modelos.add("Vitara");
        modelos.add("Vitara");
        modelos.add("Vitara");
        
        cilindradas.add("1.5");
        cilindradas.add("1.6");
        cilindradas.add("1.9");
        cilindradas.add("1.9");
        cilindradas.add("1.9");

        try { 
            generate(nombre_archivo, marcas, modelos, cilindradas);
        } catch (Exception e) {}
    }

    public static void generate(String nombre_archivo, ArrayList<String> marcas,ArrayList<String> modelos,ArrayList<String> cilindradas) throws Exception{

        if(marcas.isEmpty() || modelos.isEmpty() || cilindradas.isEmpty() || marcas.size()!= modelos.size() || marcas.size()!= cilindradas.size()){
            System.out.println("ERROR empty ArrayList");
            return;
        }else{

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = implementation.createDocument(null, nombre_archivo, null);
            document.setXmlVersion("1.0");

            //Main Node
            Element raiz = document.getDocumentElement();
            //Por cada key creamos un item que contendrá la key y el value
            for(int i=0; i< marcas.size();i++){
                //Item Node
                Element itemNode = document.createElement("coche"); 
                //Key Node
                Element marcasNode = document.createElement("marcas"); 
                Text nodeMarcasValue = document.createTextNode(marcas.get(i));
                marcasNode.appendChild(nodeMarcasValue);      
                //Value Node
                Element modelosNode = document.createElement("modelos"); 
                Text nodeModelosValue = document.createTextNode(modelos.get(i));                
                modelosNode.appendChild(nodeModelosValue);
                //Value Node
                Element cilindradasNode = document.createElement("cilindradas"); 
                Text nodeCilindradasValue = document.createTextNode(cilindradas.get(i));                
                cilindradasNode.appendChild(nodeCilindradasValue);
                //append keyNode and valueNode to itemNode
                itemNode.appendChild(marcasNode);
                itemNode.appendChild(modelosNode);
                 itemNode.appendChild(cilindradasNode);
                //append itemNode to raiz
                raiz.appendChild(itemNode); //pegamos el elemento a la raiz "Documento"
            }                
            //Generate XML
            Source source = new DOMSource(document);
            //Indicamos donde lo queremos almacenar
            Result result = new StreamResult(new java.io.File(nombre_archivo+".xml")); //nombre del archivo
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
        }
    }

}


