<%-- 
    Document   : success
    Created on : Nov 6, 2018, 12:39:23 PM
    Author     : HP
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%
    if ((session.getAttribute("userid") == null) || (session.getAttribute("userid") == "")) {
%>
You are not logged in<br/>
<a href="signin.jsp">Please Login</a>
<%} else {
%>
Welcome <%=session.getAttribute("userid")%>
<p>The queries to be addressed are:- </p>
<html>
    <body>
<%
Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/expall?autoReconnect=true&useSSL=false", "root","");
    Statement st = con.createStatement();
     String query="select keyword from query_ans ";
    ResultSet rs = st.executeQuery(query);
    ArrayList<String> User  = new ArrayList();
    while(rs.next())
    {
        User.add(rs.getString("keyword"));
       
       
        }
    for(String i : User)
    {
        request.setAttribute("ans",i);
        out.write("<input type=\"text\" name=\"ans\" id=\"hey\" value=\""+i+"\"/>");
        out.write("&nbsp;&nbsp;&nbsp;&nbsp;");
        out.write("<input type=\"button\" value=\"submit\" onclick=\"myfn()\" id=\""+i+"\" ");
        out.write("<br>");
        out.write("<br/>");
    }
%>
<script>
    function myfn()
    {
        window.location = "ans.jsp";
    }
</script>
    </body>
</html>

   
<a href='logout.jsp'>Log out</a>
<%
    }
%>
