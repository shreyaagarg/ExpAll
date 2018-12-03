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
<%ResultSet rs =null;%>
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
        <form METHOD=POST ACTION="ans.jsp">
<%
Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/expall?autoReconnect=true&useSSL=false", "root","");
    Statement st = con.createStatement();
     String query="select keyword from query_ans ";
     rs = st.executeQuery(query);
    
    //ArrayList<String> User  = new ArrayList();%>
    <select name="ans">
        <%
    while(rs.next())
    { %>
            <option><%= rs.getString("keyword")%></option>
        <% } %>
        </select>
        <br><br>
        <input type="submit">
  <!--  for(String i : User)
    {
        //request.setAttribute("ans",i);
        
        out.write("<input type=\"text\" name=\"ans\" value=\""+i+"\"/>");
        out.write("&nbsp;&nbsp;&nbsp;&nbsp;");
        out.write("<input type=\"SUBMIT\" value=\"submit\" name=\""+i+"\" ");
        out.write("<br>");
        out.write("<br/>");
    }
    
%>-->

        </form>
    </body>
</html>

   
<a href='logout.jsp'>Log out</a>
<%
    }
%>
