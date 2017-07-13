package ro.teamnet.zth.api.database;

import java.sql.*;
import java.util.Properties;

/**
 * Created by Ioana.Popescu on 7/13/2017.
 */
public class DBManager {

    private static String CONNECTION_STRING = "jdbc:oracle:thin:@" + DBProperties.IP + ":" + DBProperties.PORT + ":xe";

    private DBManager() throws UnsupportedOperationException {

    }

    private static void registerDriver() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }
        catch(ClassNotFoundException ex) {
            System.out.println("Error: unable to load driver class!");
            System.exit(1);
        }
    }

    public static Connection getConnection() throws SQLException{
        registerDriver();
        return DriverManager.getConnection(CONNECTION_STRING, DBProperties.USER, DBProperties.PASS);
    }

    public static void checkConnection(Connection conn) {
        String SQL = "SELECT 1 FROM DUAL";
        try (Statement stmt = conn.createStatement()){
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                System.out.println(rs.getString(1));
        }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
