package sn.sysbudgep.elaboration.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection {

    private static final String DB_DRIVER_CLASS = "oracle.jdbc.driver.OracleDriver";
    private static final String DB_USERNAME = "sysbudget";
    private static final String DB_URL = "jdbc:oracle:thin:@10.1.4.1:1521/debug";
    private static final String DB_PASSWORD = "sysbudget";

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName(DB_DRIVER_CLASS);

            // création de la connexion
            con = DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}
