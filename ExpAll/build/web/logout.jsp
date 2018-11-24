<%-- 
    Document   : logout
    Created on : Nov 6, 2018, 12:40:10 PM
    Author     : HP
--%>

<%
session.setAttribute("userid", null);
session.invalidate();
response.sendRedirect("signin.jsp");
%>
