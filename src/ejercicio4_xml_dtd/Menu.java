package ejercicio4_xml_dtd;

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

    public static final String[] opcMenuPrincipal = {"\n\nElige la opción que deseas:", "1.Imprimir todos los discos", "2.Imprimir por Título",
        "3.Imprimir por artista", "4.Imprimir por pais", "5.Imprimir por Compañía Discográfica", "6.Imprimir por precio", "7.Imprimir por año de lanzamiento", "8.salir"};

    public static int menus(String[] opcMenuPrincipal) {
        Scanner sc = new Scanner(System.in);

        for (String opc : opcMenuPrincipal) {
            System.out.println(opc);
        }
        int opcElegida = sc.nextInt();
        sc.nextLine();

        return opcElegida;

    }

    public static void imprimir(Document doc, String atributoX) {//3
        NodeList nList = doc.getElementsByTagName(atributoX);
        for (int i = 0; i < nList.getLength(); i++) {
            Node nNode = nList.item(i);
            Element eElement = (Element) nNode;
            System.out.println(eElement.getTextContent());

        }
    }

    public static void menuPrincipal(Document doc, String[] opcMenuPrincipal) {//1
        NodeList nList = doc.getElementsByTagName("cd");
        int opcion;
        do {
            opcion = menus(opcMenuPrincipal);

            switch (opcion) {
                case 1:
                    imprimirTodo(doc);
                    break;
                case 2:
                    imprimir(doc, "titulo");
                    break;
                case 3:
                    imprimir(doc, "artista");
                    break;
                case 4:
                 ;
                    imprimir(doc, "pais");
                    break;
                case 5:
                    imprimir(doc, "compañiaDiscografica");
                    break;
                case 6:
                    imprimir(doc, "precio");
                    break;
                case 7:
                    imprimir(doc, "añoDePublicacion");
                    break;
                case 8:
                    System.out.println("Adiós!!");
                    break;
                default:
                    System.out.println("**OPCIÖN INCORRECTA**");
                    break;

            }
        } while (opcion != 8);

    }

    public static void imprimirTodo(Document doc) {

        NodeList nList = doc.getElementsByTagName("cd");

        System.out.println("Número de cd " + nList.getLength());

        for (int temp = 0; temp < nList.getLength(); temp++) {

            Node nNode = nList.item(temp);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;

                System.out.println("\nCD:" + eElement.getAttribute("id"));
                System.out.println("Título:" + eElement.getElementsByTagName("titulo").item(0).getTextContent());
                System.out.println("Artísta:" + eElement.getElementsByTagName("artista").item(0).getTextContent());
                System.out.println("País:" + eElement.getElementsByTagName("pais").item(0).getTextContent());
                System.out.println("Compañía Discográfica:" + eElement.getElementsByTagName("compañiaDiscografica").item(0).getTextContent());
                System.out.println("Precio:" + eElement.getElementsByTagName("precio").item(0).getTextContent());
                System.out.println("Año de Publicación:" + eElement.getElementsByTagName("añoDePublicacion").item(0).getTextContent());

            }

        }

    }

}
