import controlador.xml2java.Filter;
import controlador.xml2java.Xml2Java;
import modelo.ExpresionesRegulares;
import modelo.entidades.Curso;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import util.Log;

import java.util.ArrayList;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Xml2Java xj = new Xml2Java("/home/pablo/Escritorio/ExportacionHorarios-1.xml");
        Document doc = xj.getXmlDoc();
        Filter filter = new Filter(doc);

        ArrayList<Map<String, String>> mapas = filter.getNodosMap(ExpresionesRegulares.Curso.getExpresion(), "grupo_datos", "seq");
        System.out.println("Size: " + mapas.size());
        System.out.println("Keys: " + mapas.get(0).keySet());
        for (Map mapa :
                mapas) {

        }
    }

    public static void main4(String[] args) {
        Xml2Java xj = new Xml2Java("/home/pablo/Escritorio/ExportacionHorarios-1.xml");
        Document doc = xj.getXmlDoc();
        Filter filter = new Filter(doc);

        ArrayList<Node> cursos = filter.getNodos(ExpresionesRegulares.Curso.getExpresion());
        ArrayList<Curso> cursosObj = new ArrayList<>();
        ArrayList<Map<String, String>> mapas = new ArrayList<Map<String, String>>();

//        for (Node nodo : cursos) {
//            NodeList hijos = ((Element) nodo).getElementsByTagName("dato");
//
//            Map<String, String> mapa = new HashMap<>();
//
//            for (int i = 0; i < hijos.getLength(); i++) {
//                Node hijo = hijos.item(i);
//                String atributo = ((Element) hijo).getAttribute("nombre_dato");
//                String valor = hijo.getTextContent();
//                mapa.put(atributo, valor);
//            }
//            mapas.add(mapa);
//        }
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
