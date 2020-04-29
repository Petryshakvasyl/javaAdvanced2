package ua.lviv.lgs.pv.config;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionManager {

    private static final Logger log = Logger.getLogger(ConnectionManager.class);

    private static final String URL = "jdbc:mysql://localhost:3306/i_shop";

    private static String USER_NAME = "user";

    private static String PASSWORD = "1111";

    private static Connection connection;

    private ConnectionManager() {
    }

    public static Connection createConnection() {
        log.info("creating connection to db");
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            } catch (SQLException e) {
                log.error("Error while creating connection to db with url " + URL, e);
            }
        }
        log.debug("connection was created successfully");
        return connection;
    }

    public static void closeConnection() {
        log.debug("close connection");
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                log.error("Error while closing connection to db with url " + URL, e);
            }
        }
    }
}
