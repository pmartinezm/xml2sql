package controlador.xml2java;

import modelo.Clases;
import modelo.ExpresionesRegulares;
import modelo.entidades.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Filtro {
    private Document doc;

    public Filtro(Document doc) {
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

    /**
     * @param expresionRegular
     * @param padre
     * @param atrib
     * @return ArrayList de mapas con clave/valor
     */
    public ArrayList<Map<String, String>> getNodosMap(String expresionRegular, String padre, String atrib) {
        ArrayList<Node> nodos = this.getNodos(expresionRegular, padre, atrib);
        ArrayList<Map<String, String>> mapas = new ArrayList<Map<String, String>>();

        for (Node nodo : nodos) {
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

    public ArrayList<Object> get(ExpresionesRegulares expresion, Clases clase) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> obj = Class.forName(clase.getClase());

        ArrayList<Object> lista = new ArrayList<>();
        ArrayList<Map<String, String>> mapas = this.getNodosMap(expresion.getExpresion(), "grupo_datos", "seq");

        for (Map mapa : mapas) {
            Object instancia = obj.getConstructor(Map.class).newInstance(mapa);
            lista.add(instancia);
        }

        return lista;
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Xml2Java xj = new Xml2Java("/home/pablo/Escritorio/ExportacionHorarios-1.xml");
        Document doc = xj.getXmlDoc();
        Filtro filtro = new Filtro(doc);


    }

    public ArrayList<Curso> getCursos() {
        ArrayList<Curso> lista = new ArrayList<>();
        ArrayList<Map<String, String>> mapas = this.getNodosMap(ExpresionesRegulares.Curso.getExpresion(), "grupo_datos", "seq");
        for (Map mapa : mapas) {
            lista.add(new Curso(mapa));
        }
        return lista;
    }

    public ArrayList<Materia> getMaterias() {
        ArrayList<Materia> lista = new ArrayList<>();
        ArrayList<Map<String, String>> mapas = this.getNodosMap(ExpresionesRegulares.Materia.getExpresion(), "grupo_datos", "seq");
        for (Map mapa : mapas) {
            lista.add(new Materia(mapa));
        }
        return lista;
    }

    public ArrayList<Profesor> getProfesores() {
        ArrayList<Profesor> lista = new ArrayList<>();
        ArrayList<Map<String, String>> mapas = this.getNodosMap(ExpresionesRegulares.Profesor.getExpresion(), "grupo_datos", "seq");
        for (Map mapa : mapas) {
            lista.add(new Profesor(mapa));
        }
        return lista;
    }

    public ArrayList<Actividad> getActividades() {
        ArrayList<Actividad> lista = new ArrayList<>();
        ArrayList<Map<String, String>> mapas = this.getNodosMap(ExpresionesRegulares.Actividad.getExpresion(), "grupo_datos", "seq");
        for (Map mapa : mapas) {
            lista.add(new Actividad(mapa));
        }
        return lista;
    }

    public ArrayList<Dependencia> getDependencias() {
        ArrayList<Dependencia> lista = new ArrayList<>();
        ArrayList<Map<String, String>> mapas = this.getNodosMap(ExpresionesRegulares.Dependencia.getExpresion(), "grupo_datos", "seq");
        for (Map mapa : mapas) {
            lista.add(new Dependencia(mapa));
        }
        return lista;
    }

    public ArrayList<Tramo> getTramos() {
        ArrayList<Tramo> lista = new ArrayList<>();
        ArrayList<Map<String, String>> mapas = this.getNodosMap(ExpresionesRegulares.Tramo.getExpresion(), "grupo_datos", "seq");
        for (Map mapa : mapas) {
            lista.add(new Tramo(mapa));
        }
        return lista;
    }
}
