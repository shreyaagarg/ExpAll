<%-- 
    Document   : login
    Created on : Nov 6, 2018, 12:37:01 PM
    Author     : HP
--%>

<%@ page import ="java.sql.*" %>
<%
    String userid = request.getParameter("name");    
    String pwd = request.getParameter("pass");
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/expall?autoReconnect=true&useSSL=false", "root","");
    Statement st = con.createStatement();
    ResultSet rs;
    rs = st.executeQuery("select * from userreg where name='" + userid + "' and pass='" + pwd + "'");
    if (rs.next()) {
        session.setAttribute("userid", userid);
        //out.println("welcome " + userid);
        //out.println("<a href='logout.jsp'>Log out</a>");
        response.sendRedirect("success.jsp");
    } else {
        out.println("Invalid password <a href='signin.jsp'>try again</a>");
    }
%>
