import controlador.xml2java.Filtro;
import controlador.xml2java.Xml2Java;
import modelo.entidades.*;
import org.w3c.dom.Document;

import java.util.ArrayList;

public class Main<T> {
    public static void main(String[] args) {
        Xml2Java xj = new Xml2Java("/home/pablo/Escritorio/ExportacionHorarios-1.xml");
        Document doc = xj.getXmlDoc();
        Filtro filtro = new Filtro(doc);

        ArrayList<Curso> cursos = filtro.getCursos();
        ArrayList<Materia> materias = filtro.getMaterias();
        ArrayList<Profesor> profesores = filtro.getProfesores();
        ArrayList<Actividad> actividades = filtro.getActividades();
        ArrayList<Dependencia> dependencias = filtro.getDependencias();
        ArrayList<Tramo> tramos = filtro.getTramos();

        System.out.println(cursos);
        System.out.println(materias);
        System.out.println(profesores);
        System.out.println(cursos);
        System.out.println(actividades);
        System.out.println(dependencias);
        System.out.println(tramos);
    }
}
