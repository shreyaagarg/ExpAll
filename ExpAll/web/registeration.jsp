<%-- 
    Document   : registeration
    Created on : Nov 6, 2018, 11:12:05 AM
    Author     : HP
--%>

<%@ page import ="java.sql.*" %>
<%
    String user = request.getParameter("name");
    String em = request.getParameter("email");
    String pwd = request.getParameter("pass");
    String p = request.getParameter("repass");
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/expall?autoReconnect=true&useSSL=false", "root","");
    Statement st = con.createStatement();
    //ResultSet rs;
    int i = st.executeUpdate("insert into userreg(name,email,pass,repass) values('"+ user + "','" + em + "','" + pwd + "','" + p +"')");
    if (i > 0) {
        //session.setAttribute("userid", user);
        response.sendRedirect("welcome.jsp");
       // out.print("Registration Successfull!"+"<a href='index.jsp'>Go to Login</a>");
    } else {
        response.sendRedirect("signin.jsp");
    }
%>
