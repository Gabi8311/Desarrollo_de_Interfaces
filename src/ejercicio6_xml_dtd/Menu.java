package ejercicio6_xml_dtd;

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

    public static int imprimirMatricula(Document doc, String atributoX, String atributoY) {
        NodeList nList = doc.getElementsByTagName("coche");

        System.out.println("Número total de coches de la BBDD: " + (nList.getLength()));

        for (int temp = 0; temp < nList.getLength(); temp++) {

            Node nNode = nList.item(temp);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                if (atributoY.equalsIgnoreCase(atributoY)) {
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

                return 1;
            }
        }
        return 0;
    }

    public static int imprimir(Document doc, String atributoX, String atributoY) {

        NodeList nList = doc.getElementsByTagName(atributoX);
        for (int i = 0; i < nList.getLength(); i++) {
              if (((Element)doc.getElementsByTagName(atributoX).item(0)).getTextContent().equalsIgnoreCase(atributoY)) {
                Node nNode = nList.item(i);
                Element eElement = (Element) nNode;
                System.out.println(eElement.getTextContent());
                return 1;
            }
        }
        return 0;
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

            System.out.println("El cliente introducido no se encuentra");
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
        Scanner sc = new Scanner(System.in);
        NodeList nList = doc.getElementsByTagName("coche");
        int opcion;
        String aux = "";
        do {
            opcion = menus(opcMenuPrincipal);

            switch (opcion) {
                case 1:
                    imprimirTodo(doc);
                    break;
                case 2:
                    System.out.println("Introduce la matrícula que buscas");
                    aux = sc.nextLine();
                    if (imprimirMatricula(doc, "matricula", aux) == 0) {
                        System.out.println("La matrícula no se encuentra en la BBDD");
                    } else {
                        System.out.println("\n\nDatos de coche con dicha matrícula");
                        System.out.println("----------------------------------");
                    }
                    break;
                case 3:

                    System.out.println("Introduce la marca que buscas");
                    aux = sc.nextLine();
                    if (imprimir(doc, "marca", aux) == 0) {
                        System.out.println("La marca no se encuentra en la BBDD");
                    } else {
                        System.out.println("Estos son los coches encontrados de dicha marca");
                    }
                    break;
                case 4:
                    System.out.println("Introduce el modelo que buscas");
                    aux = sc.nextLine();
                    if (imprimir(doc, "modelo", aux) == 0) {
                        System.out.println("El modelo no se encuentra en la BBDD");
                    } else {
                        System.out.println("Estos son los coches encontrados de dicho modelo");
                    }
                    break;
                case 5:
                    System.out.println("Introduce el color que buscas");
                    aux = sc.nextLine();
                    if (imprimir(doc, "color", aux) == 0) {
                        System.out.println("El color no se encuentra en la BBDD");
                    } else {
                        System.out.println("Estos son los coches encontrados de dicho color");
                    }
                    break;
                case 6:
                    System.out.println("Introduce el precio de venta que buscas");
                    aux = sc.nextLine();
                    if (imprimir(doc, "precioDeVenta", aux) == 0) {
                        System.out.println("El precio de venta no se encuentra en la BBDD");
                    } else {
                        System.out.println("Estos son los coches encontrados con este precio de venta");
                    }
                    break;
                case 7:
                    System.out.println("Introduce el cliente que buscas");
                    aux = sc.nextLine();
                    imprimirCliente(doc, "cliente");

                    break;
                case 8:
                    System.out.println("Introduce la palabra que buscas");
                    aux = sc.nextLine();
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
