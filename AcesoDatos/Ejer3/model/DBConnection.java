package model;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

    private static final String PROPS_FILE = "db.properties";
    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    static {
    Properties props = new Properties();
    try (InputStream in = DBConnection.class.getClassLoader().getResourceAsStream(PROPS_FILE)) {
        if (in == null) {
            throw new IOException("No se encontró el archivo " + PROPS_FILE + " en el classpath");
        }
        props.load(in);
        url = props.getProperty("jdbc.url");
        user = props.getProperty("jdbc.user");
        password = props.getProperty("jdbc.password");
        driver = props.getProperty("jdbc.driver");

        if (driver != null && !driver.isEmpty()) {
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException e) {
                System.err.println("Driver JDBC no encontrado: " + driver);
            }
        }
    } catch (IOException e) {
        throw new RuntimeException("Error leyendo " + PROPS_FILE, e);
    }
}


    public static Connection getConnection() throws SQLException {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw e;
        }
    }
}
