package mate.academy.internetshop.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.servlet.http.HttpServlet;
import mate.academy.internetshop.controller.LoginController;
import org.apache.log4j.Logger;

public class ConnectionUtil extends HttpServlet {
    private static final String URL =
            "jdbc:mysql://localhost:3306/internet_shop?serverTimezone=UTC";
    private static final Logger LOGGER = Logger.getLogger(LoginController.class);

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver not found", e);
        }
    }

    public static Connection getConnection() {
        Properties dbProperties = new Properties();
        dbProperties.put("user", "root");
        dbProperties.put("password", "1234");
        try {
            Connection connection = DriverManager.getConnection(URL, dbProperties);
            LOGGER.info("Connection to DB established");
            return connection;
        } catch (SQLException e) {
            LOGGER.error("Can't establish the connection to DB", e);
            throw new RuntimeException("Can't establish the connection to DB", e);
        }
    }
}
