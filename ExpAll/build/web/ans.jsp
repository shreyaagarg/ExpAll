<%-- 
    Document   : ans
    Created on : Dec 2, 2018, 11:57:43 AM
    Author     : HP
--%>

<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
   String name = request.getParameter( "ans" );
   session.setAttribute( "theans", name );
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Query Answer</title>
    </head>
    
    <body>
        
    <form name="myform" method="POST" action="print.jsp">
        <p> The query to be answered is <%= session.getAttribute( "theans" ) %></p>
        <br>
        <INPUT TYPE=TEXT NAME=username SIZE=20 placeholder="Enter the answer you want to submit.">
        
        <input type="SUBMIT" value="Submit">
    </form>
    </body>
    
</html>
