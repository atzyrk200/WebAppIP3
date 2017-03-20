package WebApp;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBUtils {

    public static user findUser(Connection conn, String userUsername, String userPassword) throws SQLException {

        String sql = "select * from users where userUsername=? and userPassword=?";

        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, userUsername);
        pstm.setString(2, userPassword);
        ResultSet rs = pstm.executeQuery();

        if (rs.next()) {
            user user = new user();
            user.setUserUsername(userUsername);
            user.setUserPassword(userPassword);
            return user;
        }
        return null;
    }

    public static user findUser(Connection conn, String userUsername) throws SQLException {

        String sql = "Select * from users  where userUsername = ? ";

        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, userUsername);

        ResultSet rs = pstm.executeQuery();

        if (rs.next()) {
            String userPassword = rs.getString("userPassword");
            user user = new user();
            user.setUserUsername(userUsername);
            user.setUserPassword(userPassword);
            return user;
        }
        return null;
    }

    public static List<document> querydocument(Connection conn) throws SQLException {
        String sql = "Select * from document";

        PreparedStatement pstm = conn.prepareStatement(sql);

        ResultSet rs = pstm.executeQuery();
        List<document> list = new ArrayList<document>();
        while (rs.next()) {
            String revisionNumber = rs.getString("revisionNumber");
            String documentTitle = rs.getString("documentTitle");
            String documentAuthor = rs.getString("documentAuthor");
            String documentCreationDate = rs.getString("documentCreationDate");
            String documentPath = rs.getString("documentPath");
            String documentStatus = rs.getString("documentStatus");


            document document = new document();
            document.setRivisionNumber(revisionNumber);
            document.setDocumentTitle(documentTitle);
            document.setDocumentAuthor(documentAuthor);
            document.setDocumentCreationDate(documentCreationDate);
            document.setDocumentPath(documentPath);
            document.setDocumentStatus(documentStatus);
            list.add(document);
        }
        return list;
    }


    //find document with document title
    public static document findDocument(Connection conn, String documentTitle) throws SQLException {
        String sql = "Select revisionNumber, documentTitle, documentAuthor from document  where documentTitle=?";

        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, documentTitle);

        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {
            String name = rs.getString("revisionNumber");
            String author = rs.getString("documentAuthor");
            document document = new document(name, documentTitle, author);
            return document;
        }
        return null;
    }

    //edit document
    public static void updateDocument(Connection conn, document document) throws SQLException {
        String sql = "Update document set revisionNumber =?, documentAuthor=? where documentTitle=? ";

        PreparedStatement pstm = conn.prepareStatement(sql);

        pstm.setString(1, document.getRevisionNumber());
        pstm.setString(2, document.getDocumentTitle());
        pstm.setString(3, document.getDocumentAuthor());
        pstm.executeUpdate();
    }

    //add document
    public static void insertDocument(Connection conn, document document) throws SQLException {
        String sql = "Insert into document(documentTitle, name,author) values (?,?,?)";

        PreparedStatement pstm = conn.prepareStatement(sql);

        pstm.setString(1, document.getDocumentTitle());
        pstm.setString(2, document.getRevisionNumber());
        pstm.setString(3, document.getDocumentAuthor());

        pstm.executeUpdate();
    }

    //delete Doc
    public static void deleteDocument(Connection conn, String documentTitle) throws SQLException {
        String sql = "Delete document where documentTitle= ?";

        PreparedStatement pstm = conn.prepareStatement(sql);

        pstm.setString(1, documentTitle);

        pstm.executeUpdate();
    }

}