<!DOCTYPE html>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<html>

<head>
    <meta charset="UTF-8">
   </head>
<body>
                <FORM action="mainPage.jsp" method="get">
                    Document Revision Number:   <input type="number"     NAME="revisionNumber">
                    Document Title:             <input type="text"       NAME="documentTitle" autofocus>
                    Document Author:            <input type="text"       NAME="documentAuthor">
                    Document Creation Date:     <input type="text"       NAME="documentCreationDate">
                    URL:                        <input type="text"      NAME="documentPath">
                    Document Status:            <input type="text"      NAME="documentStatus">

                    <input type="submit"  value="Save">
                </FORM>

                <%
                    String revisionNumber = request.getParameter("revisionNumber");
                    String documentTitle = request.getParameter("documentTitle");
                    String documentAuthor = request.getParameter("documentAuthor");
                    String documentCreationDate = request.getParameter("documentCreationDate");
                    String documentPath = request.getParameter("documentPath");
                    String documentStatus = request.getParameter("documentStatus");

                    Connection con= null;

                    PreparedStatement ps = null;

                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    int updateQuery = 0;

                    try {
                        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ip3","root2", "ip3db");

                        String sql = "INSERT INTO document(revisionNumber, documentTitle, documentAuthor, documentCreationDate, documentPath, documentStatus) VALUES (?, ?, ?, ?, ?, ?)";


                        ps = con.prepareStatement(sql);

                        ps.setString(1, revisionNumber);
                        ps.setString(2, documentTitle);
                        ps.setString(3, documentAuthor);
                        ps.setString(4, documentCreationDate);
                        ps.setString(5, documentPath);
                        ps.setString(6, documentStatus);

                        updateQuery = ps.executeUpdate();
                        if (updateQuery != 0) { %>
                <br>
                <TABLE style="background-color: #E3E4FA;"WIDTH="30%" border="1">
                    <tr><th>Data is inserted successfully
                        in database.</th></tr>
                </table>
                <%
                        }
                    }
                    catch (Exception ex) {
                        out.println("Unable to connect to batabase.");
                    }
                    finally {
                        // close all the connections.
                        ps.close();
                        con.close();
                    }
                %>

</body>
</html>