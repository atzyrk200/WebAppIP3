package WebApp;

import java.sql.*;

public class Connector {

    public static void main(String args[]) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;


        String driverName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:8080/ip3";
        String user = "root2";
        String password = "ip3db";




        try {
            Class.forName(driverName);

            con = DriverManager.getConnection(url, user, password);

            System.out.println("Connection Established.");



        } catch (Exception e) {
            System.out.println(e);
        }
    }


}