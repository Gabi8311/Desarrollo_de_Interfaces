package ejercicio_15_XML;

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
 * @author Gabriel Moreno
 */
public class Main {

    public static void main(String[] args) {

        String nombre_archivo = "miConcesionario";
        ArrayList<String> matriculas = new ArrayList<>();
        ArrayList<String> marcas = new ArrayList<>();
        ArrayList<String> modelos = new ArrayList<>();
        ArrayList<String> colores = new ArrayList<>();
        ArrayList<String> precioVenta = new ArrayList<>();
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Revisiones> revisiones = new ArrayList<>();

        matriculas.add("4545-BGH");
        matriculas.add("5678-LRG");

        marcas.add("Seat");
        marcas.add("Toyota");

        modelos.add("Ibiza");
        modelos.add("Yaris");

        colores.add("Blanco");
        colores.add("Rojo");

        precioVenta.add("5.000€");
        precioVenta.add("11.000€");

        Revisiones revisiones1 = new Revisiones("NO", "SI", "NO", "SI");
        Revisiones revisiones2 = new Revisiones("NO", "NO", "NO", "NO");

        revisiones.add(revisiones1);
        revisiones.add(revisiones2);

        Cliente cliente1 = new Cliente("51515134-K", "Francisco Alegre Romero", "Calle de los Olivos Nº3 Bajo A", "Teruel", "906 555 555");
        Cliente cliente2 = new Cliente("51853675-U", "Ignacio Arrimadas Sancho", "Calle de las Flores Nº47 7ºC", "Madrid", "902 333 333");

        clientes.add(cliente1);
        clientes.add(cliente2);

        try {
            generate(nombre_archivo, matriculas, marcas, modelos, colores, precioVenta, clientes, revisiones);
        } catch (Exception e) {
        }

    }

    public static void generate(String nombre_archivo, ArrayList<String> matriculas, ArrayList<String> marcas, ArrayList<String> modelos,
            ArrayList<String> colores, ArrayList<String> precioVenta, ArrayList<Cliente> clientes, ArrayList<Revisiones> revisiones) throws Exception {

        ArrayList<ArrayList> todo = new ArrayList<>();
        todo.add(matriculas);
        todo.add(marcas);
        todo.add(modelos);
        todo.add(colores);
        todo.add(precioVenta);
        todo.add(clientes);
        todo.add(revisiones);
        int tamArrays = matriculas.size();

        for (ArrayList a : todo) {
            if (a.isEmpty() || a.size() != tamArrays) {
                System.out.println("ERROR empty ArrayList or your ArrayList have different sizes");
                break;
            }
        }

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        DOMImplementation implementation = builder.getDOMImplementation();
        Document document = implementation.createDocument(null, nombre_archivo, null);
        document.setXmlVersion("1.0");

        //Main Node
        Element raiz = document.getDocumentElement();
        //Por cada key creamos un item que contendrá la key y el value
        for (int i = 0; i < marcas.size(); i++) {
            //Item Node
            Element itemNode = document.createElement("coche");
            //Key Node
            Element matriculaNode = document.createElement("matricula");
            Text nodeMatriculaValue = document.createTextNode(matriculas.get(i));
            matriculaNode.appendChild(nodeMatriculaValue);

            Element marcaNode = document.createElement("marca");
            Text nodeMarcaValue = document.createTextNode(marcas.get(i));
            marcaNode.appendChild(nodeMarcaValue);
            //Value Node
            Element modeloNode = document.createElement("modelo");
            Text nodeModeloValue = document.createTextNode(modelos.get(i));
            modeloNode.appendChild(nodeModeloValue);
            //Value Node
            Element colorNode = document.createElement("color");
            Text nodeColorValue = document.createTextNode(colores.get(i));
            colorNode.appendChild(nodeColorValue);
            //Value Node
            Element precioNode = document.createElement("precioDeVentas");
            Text nodePrecioValue = document.createTextNode(precioVenta.get(i));
            precioNode.appendChild(nodePrecioValue);
            //Value Node
            Element clienteNode = document.createElement("cliente");
            Element nifNode = document.createElement("NIF");
            Text nodeNifValue = document.createTextNode(clientes.get(i).getNIF());
            nifNode.appendChild(nodeNifValue);
            Element nombreNode = document.createElement("nombre");
            Text nodeNombreValue = document.createTextNode(clientes.get(i).getNombre());
            nombreNode.appendChild(nodeNombreValue);
            Element direccionNode = document.createElement("direccion");
            Text nodeDireccionValue = document.createTextNode(clientes.get(i).getDireccion());
            direccionNode.appendChild(nodeDireccionValue);
            Element ciudadNode = document.createElement("ciudad");
            Text nodeCiudadValue = document.createTextNode(clientes.get(i).getCiudad());
            ciudadNode.appendChild(nodeCiudadValue);
            Element telefonoNode = document.createElement("telefono");
            Text nodeTelefonoValue = document.createTextNode(clientes.get(i).getTelefono());
            telefonoNode.appendChild(nodeTelefonoValue);
            //Value Node
            Element revisionNode = document.createElement("revisiones");
            Element filtroNode = document.createElement("filtro");
            Text nodeFiltroValue = document.createTextNode(revisiones.get(i).getFiltro());
            filtroNode.appendChild(nodeFiltroValue);
            Element aceiteNode = document.createElement("aceite");
            Text nodeAceiteValue = document.createTextNode(revisiones.get(i).getAceite());
            aceiteNode.appendChild(nodeAceiteValue);
            Element frenosNode = document.createElement("frenos");
            Text nodeFrenosValue = document.createTextNode(revisiones.get(i).getFrenos());
            frenosNode.appendChild(nodeFrenosValue);
            Element otrosNode = document.createElement("otros");
            Text nodeOtrosValue = document.createTextNode(revisiones.get(i).getOtros());
            otrosNode.appendChild(nodeOtrosValue);

            //append keyNode and valueNode to itemNode
            itemNode.appendChild(matriculaNode);
            itemNode.appendChild(marcaNode);
            itemNode.appendChild(modeloNode);
            itemNode.appendChild(colorNode);
            itemNode.appendChild(precioNode);
            itemNode.appendChild(clienteNode);
            itemNode.appendChild(revisionNode);
            clienteNode.appendChild(nifNode);
            clienteNode.appendChild(nombreNode);
            clienteNode.appendChild(direccionNode);
            clienteNode.appendChild(ciudadNode);
            clienteNode.appendChild(telefonoNode);
            revisionNode.appendChild(filtroNode);
            revisionNode.appendChild(aceiteNode);
            revisionNode.appendChild(frenosNode);
            revisionNode.appendChild(otrosNode);

            //append itemNode to raiz
            raiz.appendChild(itemNode); //pegamos el elemento a la raiz "Documento"
        }
        //Generate XML
        Source source = new DOMSource(document);
        //Indicamos donde lo queremos almacenar
        Result result = new StreamResult(new java.io.File(nombre_archivo + ".xml")); //nombre del archivo
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(source, result);
    }
}
