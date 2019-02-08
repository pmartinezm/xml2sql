package controlador.accesoDB;

import modelo.entidades.Actividad;
import modelo.entidades.Curso;
import reflexion.ReflexionSQL;
import util.Log;

import java.sql.*;

public class AccesoDB {
    private static String conector = "jdbc:sqlite:";

    public static void conectar() {
        Connection conexion = null;
        String url = conector + "/home/pablo/Escritorio/database.db";
        try {
            conexion = DriverManager.getConnection(url);
            Log.msg("Conectado");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static void crearBD(String url) {
        try (Connection conn = DriverManager.getConnection(conector + url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void crearTabla(String url, Object obj) throws NoSuchFieldException {
        String sql = ReflexionSQL.crearTabla(obj);

        try (Connection conn = DriverManager.getConnection(conector + url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws NoSuchFieldException {
        Actividad curso = new Actividad("", "", "", "", "");
        crearTabla("/home/pablo/Escritorio/db.db", curso);
    }
}
