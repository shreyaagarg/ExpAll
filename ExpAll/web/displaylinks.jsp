
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%-- 
    Document   : displaylinks
    Created on : 14 Oct, 2018, 7:39:40 PM
    Author     : isha gupta
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ExpAll</title>
    </head>
    <a href="displaylinks.jsp"></a>
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
            
 <%
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/expall?autoReconnect=true&useSSL=false", "root","");
    Statement st = con.createStatement();
    int i=st.executeUpdate("insert into query_ans(keyword)values('"+q+"')");
out.println("Your query has been successfully recorded!! ");
%>
  
            <%}%>
    </body>

