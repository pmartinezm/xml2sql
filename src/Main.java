import controlador.xml2java.Filter;
import controlador.xml2java.Xml2Java;
import modelo.ExpresionesRegulares;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import util.Log;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Xml2Java xj = new Xml2Java("/home/pablo/Escritorio/ExportacionHorarios-1.xml");
        Document doc = xj.getXmlDoc();
        Filter filter = new Filter(doc);

        ArrayList<Node> cursos = filter.getNodos(ExpresionesRegulares.Curso.getExpresion());

        for (Node nodo : cursos) {
            System.out.println(nodo.getTextContent());
        }

    }

    public static void main3(String[] args) {
//        Xml2Java xj = new Xml2Java("/home/pablo/Escritorio/ExportacionHorarios-1.xml");
//        Document doc = xj.getXmlDoc();
//        Filter filter = new Filter(doc);
//
//        ArrayList<Node> cursos = filter.getCursos();
//        int cont = 0;
//        for (Node nodo : cursos) {
//            System.out.println(((Element) nodo).getAttribute("seq"));
//            if (nodo.hasChildNodes() && cont != 0) {
//                NodeList hijos = ((Element) nodo).getElementsByTagName("dato");
//                for (int i = 0; i < hijos.getLength(); i++) {
//                    Node hijo = hijos.item(i);
//                    Element elemento = (Element) hijo;
//                    String atributo = elemento.getAttribute("nombre_dato");
//                    System.out.println(atributo + ": " + hijo.getTextContent());
//                }
//            }
//            cont++;
//        }
    }

    public static void main2(String[] args) {
        Log.msg("Starting program.");

        Xml2Java xj = new Xml2Java("/home/pablo/Escritorio/ExportacionHorarios-1.xml");
        Document doc = xj.getXmlDoc();
        Filter filter = new Filter(doc);

        NodeList nl = doc.getElementsByTagName("grupo_datos");
        for (int i = 0; i < nl.getLength(); i++) {
            Node node = nl.item(i);
            Element element = (Element) node;
            String atrribute = element.getAttribute("seq");
            System.out.println(atrribute);
            if (atrribute.equalsIgnoreCase("cursos_del_centro")) {
                System.out.println(node.getNodeName());
            }
        }
    }
}
