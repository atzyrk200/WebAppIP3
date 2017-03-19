<html>

<head>

    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    <title>Login</title>

</head>

<body>
<%@ page import="java.sql.*" %>

<%!
    String userdbName;

    String userdbPsw;

    String dbUsertype;

%>

<%

    Connection con= null;

    PreparedStatement ps = null;

    ResultSet rs = null;



    String driverName = "com.mysql.jdbc.Driver";

    String url = "jdbc:mysql://localhost:3306/ip3";

    String user = "root2";

    String dbpsw = "ip3db";



    String sql = "select * from users where userUsername=? and userPassword=? and userRole=?";



    String name = request.getParameter("userUsername");

    String password = request.getParameter("userPassword");

    String userRole = request.getParameter("userRole");



    if((!(name.equals(null) || name.equals("")) && !(password.equals(null) ||
            password.equals(""))) && !userRole.equals("select"))

    {

        try{

            Class.forName(driverName);

            con = DriverManager.getConnection(url, user, dbpsw);

            ps = con.prepareStatement(sql);

            ps.setString(1, name);

            ps.setString(2, password);

            ps.setString(3, userRole);

            rs = ps.executeQuery();

            if(rs.next())

            {

                userdbName = rs.getString("userUsername");

                userdbPsw = rs.getString("userPassword");

                dbUsertype = rs.getString("userRole");

                if(name.equals(userdbName) && password.equals(userdbPsw) && userRole.equals(dbUsertype))

                {

                    session.setAttribute("name",userdbName);

                    session.setAttribute("userRole", dbUsertype);

                    response.sendRedirect("mainPage.jsp");

                }

            }

            else

               out.println("Log in error");

            rs.close();

            ps.close();

        }

        catch(SQLException sqe)

        {

            out.println(sqe);

        }

    }

    else

    {}
%>

<p style="color:red">Error In Login</p>

</body>

</html>