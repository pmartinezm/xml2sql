package controlador.java2sql;

import controlador.accesoDB.AccesoDB;

import java.sql.Connection;

public class Java2Sql {
    AccesoDB db;

    public Java2Sql() {
        this.db.conectar();
    }

    public static void main(String[] args) {
        new Java2Sql();
    }
}
