<%-- 
    Document   : contact
    Created on : 15 Oct, 2018, 12:08:50 AM
    Author     : isha gupta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
html {
  box-sizing: border-box;
}

*, *:before, *:after {
  box-sizing: inherit;
}

.column {
  float: left;
  width: 33.3%;
  margin-bottom: 16px;
  padding: 0 8px;
}

@media screen and (max-width: 650px) {
  .column {
    width: 100%;
    display: block;
  }
}

.card {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
}

.container {
  padding: 0 16px;
}

.container::after, .row::after {
  content: "";
  clear: both;
  display: table;
}

.title {
  color: grey;
}

.button {
  border: none;
  outline: 0;
  display: inline-block;
  padding: 8px;
  color: white;
  background-color: #000;
  text-align: center;
  cursor: pointer;
  width: 100%;
}

.button:hover {
  background-color: #555;
}
</style>
</head>
<body>

<h2>MEET THE TEAM</h2>
<br>

<div class="row">
  <div class="column">
    <div class="card">
      <img src="" alt="Chetna" style="width:100%">
      <div class="container">
        <h2>CHETNA GUPTA</h2>
        <p class="title">DEVELOPER</p>
        
        <p>guptachetna1998@gmail.com</p>
        <p><button class="button">Contact</button></p>
      </div>
    </div>
  </div>

  <div class="column">
    <div class="card">
      <img src="img_5.jpg" alt="Shreya" style="width:100%">
      <div class="container">
        <h2>Shreya</h2>
        <p class="title">Developer</p>
        
        <p>shreyagrg09@gmail.com</p>
        <p><button class="button">Contact</button></p>
      </div>
    </div>
  </div>
  <div class="column">
    <div class="card">
      <img src="" alt="Aditya" style="width:100%">
      <div class="container">
        <h2>Aditya</h2>
        <p class="title">Developer</p>
        <p>example@example.com</p>
        <p><button class="button">Contact</button></p>
      </div>
    </div>
  </div>
</div>

</body>
</html>
