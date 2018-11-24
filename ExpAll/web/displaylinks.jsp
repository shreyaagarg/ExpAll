<%-- 
    Document   : displaylinks
    Created on : 14 Oct, 2018, 7:39:40 PM
    Author     : isha gupta
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ExpAll</title>
    </head>
    <body>
        <h1><center>Search Query Results</center></h1>
        <%@page import="mypack.*,java.util.*"%>
        <%
            String q = request.getParameter("query");
            //java code    
            Search obj=new Search();
            ArrayList <String> links=obj.extract(q);
            for(String a: links)
            {
            %>
     
        <p> <a href="<%= a%>"><%= a%> </a></p>
        <%
        }
        if(links.isEmpty())
            {%>
            <p> OOPS you seem to have entered a wrong query!!! go back and query again!!!</p>
            <%}%>
    </body>
</html>
