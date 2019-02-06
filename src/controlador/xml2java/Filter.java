package controlador.xml2java;

import modelo.ExpresionesRegulares;
import modelo.entidades.Curso;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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

    /**
     * Obtiene los nodos que respondan a la fórmula
     * <padre atrib="valida expresión regular"></padre>
     *
     * @param expresionRegular
     * @param padre
     * @param atrib
     * @return
     */
    public ArrayList<Node> getNodos(String expresionRegular, String padre, String atrib) {
        NodeList nodos = this.doc.getElementsByTagName(padre);
        ArrayList<Node> lista = new ArrayList<>();

        for (int i = 0; i < nodos.getLength(); i++) {
            Node nodo = nodos.item(i);
            Element elemento = (Element) nodo;
            String atributo = elemento.getAttribute(atrib);

            if (atributo != null && atributo.matches(expresionRegular)) {
                lista.add(nodo);
            }
        }

        return lista;
    }

    public ArrayList<Map<String, String>> getNodosMap(String expresionRegular, String padre, String atrib) {
        ArrayList<Node> lista = this.getNodos(ExpresionesRegulares.Curso.getExpresion(), padre, atrib);
        ArrayList<Map<String, String>> mapas = new ArrayList<Map<String, String>>();

        for (Node nodo : lista) {
            NodeList hijos = ((Element) nodo).getElementsByTagName("dato");

            Map<String, String> mapa = new HashMap<>();

            for (int i = 0; i < hijos.getLength(); i++) {
                Node hijo = hijos.item(i);
                String atributo = ((Element) hijo).getAttribute("nombre_dato");
                String valor = hijo.getTextContent();
                mapa.put(atributo, valor);
            }
            mapas.add(mapa);
        }
        return mapas;
    }

    public ArrayList<Curso> getCursos() {
        ArrayList<Curso> cursos = new ArrayList<>();
        ArrayList<Map<String, String>> mapas = this.getNodosMap(ExpresionesRegulares.Curso.getExpresion(), "grupo_datos", "seq");
        for (Map mapa :
                mapas) {
            cursos.add(new Curso(mapa));
        }
        return cursos;
    }
}
