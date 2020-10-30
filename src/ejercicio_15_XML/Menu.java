package ejercicio_15_XML;

import java.util.Scanner;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
/**
 *
 * @author Gabriel Moreno
 */
public class Menu {

    public static final String[] opcMenuPrincipal = {"\n\nElige la opción que deseas:", "1.Imprimir todos los coches", "2.Imprimir por Matrícula",
        "3.Imprimir por Marca", "4.Imprimir por Modelo", "5.Imprimir por color", "6.Imprimir por precio", "7.Imprimir por cliente", "8.Imprimir por revisiones", "9.Salir"};

    public static int menus(String[] opcMenuPrincipal) {
        Scanner sc = new Scanner(System.in);

        for (String opc : opcMenuPrincipal) {
            System.out.println(opc);
        }
        int opcElegida = sc.nextInt();
        sc.nextLine();

        return opcElegida;

    }

    public static void imprimir(Document doc, String atributoX) {
        NodeList nList = doc.getElementsByTagName(atributoX);
        for (int i = 0; i < nList.getLength(); i++) {
            Node nNode = nList.item(i);
            Element eElement = (Element) nNode;
            System.out.println(eElement.getTextContent());

        }
    }

    public static void imprimirRevisiones(Document doc, String atributoX) {
        NodeList nList = doc.getElementsByTagName(atributoX);
        for (int i = 0; i < nList.getLength(); i++) {
            Node nNode = nList.item(i);
            Element eElement = (Element) nNode;
            System.out.println("\nRevisiones");
            System.out.println("**********");

            System.out.print("  Filtro:" + eElement.getElementsByTagName("filtro").item(0).getTextContent());
            System.out.println(" con código: " + ((Element) eElement.getElementsByTagName("filtro").item(0)).getAttribute("cod"));
            System.out.print("  Aceite:" + eElement.getElementsByTagName("aceite").item(0).getTextContent());
            System.out.println(" con código: " + ((Element) eElement.getElementsByTagName("aceite").item(0)).getAttribute("cod"));
            System.out.print("  Frenos:" + eElement.getElementsByTagName("frenos").item(0).getTextContent());
            System.out.println(" con código: " + ((Element) eElement.getElementsByTagName("frenos").item(0)).getAttribute("cod"));
            System.out.print("  Otros:" + eElement.getElementsByTagName("otros").item(0).getTextContent());
            System.out.println(" con código: " + ((Element) eElement.getElementsByTagName("otros").item(0)).getAttribute("cod"));

        }

    }

    public static void imprimirCliente(Document doc, String atributoX) {
        NodeList nList = doc.getElementsByTagName(atributoX);
        for (int i = 0; i < nList.getLength(); i++) {
            Node nNode = nList.item(i);
            Element iElement = (Element) nNode;
            System.out.println("\nCliente");
            System.out.println("*******");

            System.out.println("  Nº Código de Cliente: " + iElement.getAttribute("id"));
            System.out.println("  NIF:" + iElement.getElementsByTagName("NIF").item(0).getTextContent());
            System.out.println("  Nombre:" + iElement.getElementsByTagName("nombre").item(0).getTextContent());
            System.out.println("  Dirección:" + iElement.getElementsByTagName("direccion").item(0).getTextContent());
            System.out.println("  Ciudad:" + iElement.getElementsByTagName("ciudad").item(0).getTextContent());
            System.out.println("  Teléfono:" + iElement.getElementsByTagName("telefono").item(0).getTextContent());

        }

    }

    public static void menuPrincipal(Document doc, String[] opcMenuPrincipal) {
        NodeList nList = doc.getElementsByTagName("coche");
        int opcion;
        do {
            opcion = menus(opcMenuPrincipal);

            switch (opcion) {
                case 1:
                    imprimirTodo(doc);
                    break;
                case 2:
                    imprimir(doc, "matricula");
                    break;
                case 3:
                    imprimir(doc, "marca");
                    break;
                case 4:
                    imprimir(doc, "modelo");
                    break;
                case 5:
                    imprimir(doc, "color");
                    break;
                case 6:
                    imprimir(doc, "precioDeVenta");
                    break;
                case 7:
                    imprimirCliente(doc, "cliente");
                    break;
                case 8:
                    imprimirRevisiones(doc, "revisiones");
                    break;
                case 9:
                    System.out.println("Adiós!!");
                    break;
                default:
                    System.out.println("**OPCIÖN INCORRECTA**");
                    break;

            }
        } while (opcion != 9);

    }

    public static void imprimirTodo(Document doc) {

        NodeList nList = doc.getElementsByTagName("coche");

        System.out.println("Número total de coches de la BBDD: " + (nList.getLength()));

        for (int temp = 0; temp < nList.getLength(); temp++) {

            Node nNode = nList.item(temp);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;

                System.out.println("\nVehículo");
                System.out.println("********");

                System.out.println("Nº Código del vehículo: " + eElement.getAttribute("id"));
                System.out.println("Matrícula:" + eElement.getElementsByTagName("matricula").item(0).getTextContent());
                System.out.println("Marca:" + eElement.getElementsByTagName("marca").item(0).getTextContent());
                System.out.println("Modelo:" + eElement.getElementsByTagName("modelo").item(0).getTextContent());
                System.out.println("Color:" + eElement.getElementsByTagName("color").item(0).getTextContent());
                System.out.println("Precio de Venta:" + eElement.getElementsByTagName("precioDeVenta").item(0).getTextContent());

                NodeList iList = doc.getElementsByTagName("cliente");

                Node iNode = iList.item(temp);

                if (iNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element iElement = (Element) iNode;

                    System.out.println("\nCliente");
                    System.out.println("*******");

                    System.out.println("  Nº Código de Cliente: " + iElement.getAttribute("id"));
                    System.out.println("  NIF:" + iElement.getElementsByTagName("NIF").item(0).getTextContent());
                    System.out.println("  Nombre:" + iElement.getElementsByTagName("nombre").item(0).getTextContent());
                    System.out.println("  Dirección:" + iElement.getElementsByTagName("direccion").item(0).getTextContent());
                    System.out.println("  Ciudad:" + iElement.getElementsByTagName("ciudad").item(0).getTextContent());
                    System.out.println("  Teléfono:" + iElement.getElementsByTagName("telefono").item(0).getTextContent());

                    NodeList jList = doc.getElementsByTagName("revisiones");

                    Node jNode = jList.item(temp);

                    if (jNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element jElement = (Element) jNode;

                        System.out.println("\nRevisiones");
                        System.out.println("**********");

                        System.out.print("  Filtro:" + jElement.getElementsByTagName("filtro").item(0).getTextContent());
                        System.out.println(" con código: " + ((Element) jElement.getElementsByTagName("filtro").item(0)).getAttribute("cod"));
                        System.out.print("  Aceite:" + jElement.getElementsByTagName("aceite").item(0).getTextContent());
                        System.out.println(" con código: " + ((Element) jElement.getElementsByTagName("aceite").item(0)).getAttribute("cod"));
                        System.out.print("  Frenos:" + jElement.getElementsByTagName("frenos").item(0).getTextContent());
                        System.out.println(" con código: " + ((Element) jElement.getElementsByTagName("frenos").item(0)).getAttribute("cod"));
                        System.out.print("  Otros:" + jElement.getElementsByTagName("otros").item(0).getTextContent());
                        System.out.println(" con código: " + ((Element) jElement.getElementsByTagName("otros").item(0)).getAttribute("cod"));
                    }
                }
            }
        }
    }
}
