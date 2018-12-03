<%-- 
    Document   : base
    Created on : 14 Oct, 2018, 6:58:53 PM
    Author     : isha gupta
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<title> search</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}

.topnav {
  overflow: hidden;
  background-color: #333;
}

.topnav a {
  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.topnav a:hover {
  background-color: #ddd;
  color: black;
}

.topnav a.active {
  background-color: #4CAF50;
  color: white;
}
</style>

</head>
<body>
<div class="topnav">
  <a href="about.jsp">About</a>
  <a href="signup.jsp">SignUp</a>
  <a href="signin.jsp">SignIn</a>
  <a href="contact.jsp">Contact</a>
</div>
<center>
<h1 style="font-size:49px;margin-top:200px;"><span style="color:blue">E</span><span style="color:#CE2029">x</span><span style="color:#ffdb58">p</span><span style="color:blue">A</span><span style="color:green">l</span><span style="color:#CE2029">l</span></h1>
<form method="post" action="displaylinks.jsp" name="quering">
    <LABEL for="search"></LABEL><input type="text" name="query"/><br><br>
    <input type="submit" value="Expall search">
</form>
</center>
</body>
</html>