package reflexion;

import controlador.accesoDB.AccesoDB;
import modelo.entidades.*;

import java.lang.reflect.Field;

public class ReflexionSQL {

    public static String crearTabla(Object obj) throws NoSuchFieldException {
        String sql = "create table if not exists ";
        Field[] propiedades = obj.getClass().getDeclaredFields();

        sql += obj.getClass().getSimpleName().toLowerCase() + " (";

        for (int i = 0; i < propiedades.length; i++) {
            Field propiedad = propiedades[i];

            String columna = propiedad.getName();
            String tipo = propiedad.getType().getSimpleName();

            sql += columna + " " + tipo;

            if (i < propiedades.length - 1) {
                sql += ", ";
            }
        }

        sql += ");";

        System.out.println(sql);

        return sql;
    }

    public static void main(String[] args) {

    }

    public static void main2(String[] args) throws NoSuchFieldException {
        Curso curso = new Curso("", "");
        Actividad actividad = new Actividad("", "", "", "", "");
        Dependencia dependencia = new Dependencia("", "");
        Materia materia = new Materia("", "", "");
        Profesor profesor = new Profesor("", "", "", "", "", "");
        Tramo tramo = new Tramo("", "", "", "", "");

        String url = "/home/pablo/Escritorio/db.db";
        AccesoDB.crearTabla(url, curso);
        AccesoDB.crearTabla(url, actividad);
        AccesoDB.crearTabla(url, dependencia);
        AccesoDB.crearTabla(url, materia);
        AccesoDB.crearTabla(url, profesor);
        AccesoDB.crearTabla(url, tramo);

    }
}
