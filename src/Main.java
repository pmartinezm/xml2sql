import controlador.xml2java.Filter;
import controlador.xml2java.Xml2Java;
import modelo.ExpresionesRegulares;
import modelo.entidades.Curso;
import modelo.entidades.Materia;
import modelo.entidades.Profesor;
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

        ArrayList<Curso> cursos = filter.getCursos();
        for (Curso curso : cursos) {
            System.out.println(curso.toString());
        }

        ArrayList<Materia> materias = filter.getMaterias();
        for (Materia materia : materias) {
            System.out.println(materia.toString());
        }

        ArrayList<Profesor> profesores = filter.getProfesores();
        for (Profesor profesor : profesores) {
            System.out.println(profesor.toString());
        }
    }
}
