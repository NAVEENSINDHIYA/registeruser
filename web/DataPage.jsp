<%-- 
    Document   : DataPage
    Created on : May 30, 2020, 10:15:38 AM
    Author     : SCINDIA
--%>


<%@page language="java" import="java.util.*" %>
<%@page language="java" import="bean.User" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.datatables.net/1.10.21/css/dataTables.bootstrap4.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.css">
  <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
  <script src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
  <script src="https://cdn.datatables.net/1.10.21/js/dataTables.bootstrap4.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
    .content {
  padding: 0 18px;
  display: none;
  overflow: hidden;
  background-color: #f1f1f1;
}
</style>
<title>Data Page</title>
</head>
<body> 
<table id="example" class="table table-striped table-bordered" style="width:100%">
   <thead>
    <div class="content">
        
<tr>
     <td width="168"><b>ID</b></td> 
      <td width="119"><b>NAME</b></td>
      <td width="168"><b>PASSWORD</b></td>
      <td width="168"><b>EMAIL ID</b></td>
      <td width="168"><b>COUNTRY</b></td>
       <td><input type="button" name="ADD" value="Add NEW" style="background-color:white;font-weight:bold;color:black;" onclick="location.href='register.html'" ></td>

</tr>
        
     </div>
   </thead>
                 
          <tbody>
          <div class="content">
              <% List<User> list= (List)request.getAttribute("data"); 
     for(User e:list){ %>
     
     <tr>
         <td width="168"><%=e.getId()%></td>
         <td width="168"><%=e.getName()%></td>
         <td width="168"><%=e.getPassword()%></td>
         <td width="168"><%=e.getEmail()%></td>
         <td width="168"><%=e.getCountry()%></td>
         <td><a href='EditServlet?id=<%=e.getId()%>'>edit</a></td> 
         <td><a href='DeleteServlet?id=<%=e.getId()%>'>delete</a></td>

        
     </tr>
         
                     
     <%    }  %>
                         
              

             
          </div>
         </tbody>
   
</table>
<script>
    $(document).ready(function() {
    $('#example').DataTable();
} );
</script>
<script language="javascript">
function editRecord(id){
    var f=document.form;
    f.method="post";
    f.action='UpdateData.jsp?id='+id;
    f.submit();
}
</script>

</body>
</html>