<%-- 
    Document   : UpdateData
    Created on : Jun 4, 2020, 8:15:06 PM
    Author     : SCINDIA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java" import="bean.User" %>
<!DOCTYPE html>
<html>
<body>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
.collapsible {
  background-color: #888;
  color: white;
  cursor: pointer;
  padding: 18px;
  width: 100%;
  border: none;
  text-align: left;
  outline: none;
  font-size: 15px;
}

.active, .collapsible:hover {
  background-color: #333;
}

.content {
  padding: 0 18px;
  display: none;
  overflow: hidden;
  background-color: #f1f1f1;
}
</style>
</head>


<button type="button" class="collapsible">Tap here to update user</button>
<div class="content">
  <h1>Edit Details:</h1>
<form action="./EditServlet2" method="post">
  <% User e= (User)request.getAttribute("data"); %>
   <div class="form-group">
    <label for="userid">User ID:</label>
   
    <input type="text" class="form-control" name="id" value="<%=e.getId()%>" readonly>
  </div>
    <div class="form-group">
    <label for="fullname">Full Name:</label>
    <input type="text" class="form-control" name="name" value="<%=e.getName()%>">
  </div>
  <div class="form-group">
    <label for="password">Password:</label>
    <input type="text" class="form-control" name="password" value="<%=e.getPassword()%>">
  </div>
    <div class="form-group">
    <label for="emailid">Email:</label>
    <input type="text" class="form-control" name="email" value="<%=e.getEmail()%>">
  </div>
    <div class="form-group">
    <label for="countryname">Country:</label>
  
    <select name="country" style="width:150px">  
          <option value = "INDIA">INDIA</option>
            <option value = "USA" >USA</option>
            <option value = "UK">UK</option> 
            <option value = "Other">Other</option> 
    </select>
  </div>
  <button type="submit" class="btn btn-default">Submit</button>
 
</form>
  <form action="./ViewServlet" method="get">
      <a href="ViewServlet">View Users</a>
  </form>
  
       

<script>
var coll = document.getElementsByClassName("collapsible");
var i;

for (i = 0; i < coll.length; i++) {
  coll[i].addEventListener("click", function() {
    this.classList.toggle("active");
    var content = this.nextElementSibling;
    if (content.style.display === "block") {
      content.style.display = "none";
    } else {
      content.style.display = "block";
    }
  });
}
</script>
</body>
</html>
