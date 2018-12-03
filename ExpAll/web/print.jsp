<%-- 
    Document   : print
    Created on : Dec 2, 2018, 12:29:32 PM
    Author     : HP
--%>

<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.*"%>
<%@page import="java.io.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

   

<%
    String name = request.getParameter( "username" );
    String keyword= (String)session.getAttribute( "theans" );
   session.setAttribute( "theName", name );
   out.write(request.getParameter("answer"));
   Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/expall?autoReconnect=true&useSSL=false", "root","");
    Statement st = con.createStatement();
    int i=st.executeUpdate("insert into user_table(query,answer)values('"+keyword+"','"+name+"')");
    int j=st.executeUpdate("delete from query_ans where keyword ="+ "\'"+keyword+"\'");
    out.print("Data updated successfully");
 %>

