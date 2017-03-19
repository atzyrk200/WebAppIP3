package WebApp;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.users.FullAccount;

import java.sql.*;

@SuppressWarnings("ThrowablePrintedToSystemOut")
public class Connector {

    /**
     * Main method for initializing the program.
     *
     * @param args null.
     */
    public static void main(String args[]) {
        DbxClientV2 dropboxConnection = connectDropbox();
        Connection databaseConnecton = connectDatabase();
        PreparedStatement ps = null;
        ResultSet rs = null;
    }

    /**
     * Attempts connection to XAMPP MySQL connection.
     * When found, returns connection object.
     *
     * @return Database connection object.
     */
    private static Connection connectDatabase() {

        // Required details for establishing connection.
        final String driverName = "com.mysql.cj.jdbc.Driver";
        final String url = "jdbc:mysql://localhost:8080/ip3";
        final String user = "root2";
        final String password = "ip3db";

        // Attempt to connect.
        try {
            Class.forName(driverName);
            Connection c = DriverManager.getConnection(url, user, password);
            if (c != null) {
                System.out.println("Connection Established.");
                return c;
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);  // Would be better with stack-traces, these don't help.
        }
        return null;
    }

    /**
     * Attempts a connection to DropBox through API using an access token.
     * If successful, returns the connection object.
     *
     * @return DropBox connection object.
     */
    @SuppressWarnings("deprecation")
    private static DbxClientV2 connectDropbox() {

        // Get access token from here: https://www.dropbox.com/developers/apps
        final String DROPBOX_ACCESS_TOKEN = "R0RCE_QGgiAAAAAAAAAADzkLvY76wn6MTz1XgeZwAkTVSACMz4hJVUvwyjoNOUjO";

        // Establish connection to DropBox.
        DbxRequestConfig config = new DbxRequestConfig("dropbox/IdeaGen_DocumentServer", "en_US");
        DbxClientV2 client = new DbxClientV2(config, DROPBOX_ACCESS_TOKEN);

        // Check there is a connection.
        try {
            FullAccount account = client.users().getCurrentAccount();
            System.out.println("DropBox successfully connected: " + account.getName().getDisplayName());
            return client;
        } catch (DbxException e) {
            e.printStackTrace();
            return null;
        }
    }

}