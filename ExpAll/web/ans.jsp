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
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Query Answer</title>
    </head>
    
    <body>
        <script>
        function myfn()
        {
            window.location = "print.jsp";
        }
    </script>
        <input type="text" id="answer" placeholder="Write the answer to submit" />
        
        <input type="button" value="Submit" onClick="myfn()">
    </body>
    
</html>
