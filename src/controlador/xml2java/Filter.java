package controlador.xml2java;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

public class Filter {
    private Document doc;

    public Filter(Document doc) {
        this.doc = doc;
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
