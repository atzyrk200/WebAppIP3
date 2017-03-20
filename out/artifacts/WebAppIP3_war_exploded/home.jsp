<%@ page import="java.sql.*" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Login</title>
</head>

<body>

<%

    Connection con= null;

    PreparedStatement ps = null;

    ResultSet rs = null;



    String driverName = "com.mysql.jdbc.Driver";

    String url = "jdbc:mysql://localhost:3306/ip3";

    String user = "root2";

    String password = "ip3db";



    String sql = "select userRole from users";



    try {

        Class.forName(driverName);

        con = DriverManager.getConnection(url, user, password);

        ps = con.prepareStatement(sql);

        rs = ps.executeQuery();

%>

    <div class="login-container">
        <section class="login" id="login">
            <header>
                <h2>Ideagen</h2>
                <h4>Login</h4>
            </header>
            <form class="login-form" action="login.jsp" method = "post">
                <input type="text" class="login-input" name="userUsername" required autofocus/>
                <input type="password" class="login-input" name="userPassword" required/>
                <table>
                    <td>Select UserType</td>

                    <td><select name="userRole">

                        <option value="select">select</option>

                        <%

                            while(rs.next())

                            {

                                String userRole = rs.getString("userRole");

                        %>

                        <option value=<%=userRole%>><%=userRole%></option>

                        <%

                                }

                            }

                            catch(SQLException sqe)

                            {

                                out.println("home"+sqe);

                            }

                        %>
                    </select>
                    </td>
                </table>



                <div class="submit-container">
                    <button  type="submit" class="btn medium primary">SIGN IN</button>
                </div>
            </form>
        </section>
    </div>







</body>

</html>