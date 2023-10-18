package net.weg.api.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Banco {

    private static final String urlBanco = "jdbc:mysql://localhost:3306/dbintegracao";
    private static final String usuario = "root";
    private static final String senha = "root";

    static public Connection conectar() {

        try {
           return DriverManager.getConnection(urlBanco,usuario,senha);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
