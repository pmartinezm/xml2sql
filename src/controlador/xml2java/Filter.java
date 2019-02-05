package controlador.xml2java;

import org.w3c.dom.*;
import util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Filter {
    private Document doc;

    public Filter(Document xmlDocument) {
        this.doc = xmlDocument;
    }

    /**
     * Obtiene los nodos del documento cuyo tag sea "grupo_datos".
     *
     * @return un arraylist con los nodos de tipo "grupo_datos" cuyo atributo req sea "CURSO".
     */
    public ArrayList<Node> getCursos() {
        ArrayList<Node> cursos = new ArrayList<>();
        NodeList nodos = this.doc.getElementsByTagName("grupo_datos");

        for (int i = 0; i < nodos.getLength(); i++) {
            Node nodo = nodos.item(i);
            Element elemento = (Element) nodo;

            String atributo = elemento.getAttribute("seq");

            if (atributo.startsWith("CURSO")) {
                cursos.add(nodo);
            }
        }
        return cursos;
    }

    /**
     * Obtiene los nodos de tipo TAG que tengan un atributo ATRIB que empieze por CONTIENE.
     * <elemento atrib="contiene"></elemento>
     *
     * @param tag
     * @param atrib
     * @param contiene
     * @return arrayList con los nodos que respondan a la fórmula.
     */
    public ArrayList<Node> getNodes(String tag, String atrib, String contiene) {
        ArrayList<Node> cursos = new ArrayList<>();
        NodeList nodos = this.doc.getElementsByTagName(tag);

        for (int i = 0; i < nodos.getLength(); i++) {
            Node nodo = nodos.item(i);
            Element elemento = (Element) nodo;

            String atributo = elemento.getAttribute(atrib);

            if (atributo.startsWith(contiene)) {
                cursos.add(nodo);
            }
        }
        return cursos;
    }

    /**
     * Obtiene los nodos que coinciden con la expresión regular.
     *
     * @param expresionRegular
     * @return ArrayList con los nodos que coinciden con la expresión regular.
     */
    public ArrayList<Node> getNodos(String expresionRegular) {
        NodeList nodos = this.doc.getElementsByTagName("grupo_datos");
        ArrayList<Node> lista = new ArrayList<>();

        for (int i = 0; i < nodos.getLength(); i++) {
            Node nodo = nodos.item(i);
            Element elemento = (Element) nodo;
            String atributo = elemento.getAttribute("seq");

            if (atributo != null && atributo.matches(expresionRegular)) {
                lista.add(nodo);
            }
        }

        return lista;
    }
}
