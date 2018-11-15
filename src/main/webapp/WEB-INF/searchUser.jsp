<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 <script>
$(document).ready(function(){
  $("#myInput").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#myTable tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });
});
</script>
<style>

.btn {background-color: #008CBA;}
.butn {background-color: #f44336;}
ul.b {list-style-type: square;}
</style>
</head>
<body>
<div class="container">
<h3>Manage User</h3>
</div>
<br/>
<div class="container">
<ul class="a">
<li><h5>${users.size()} Matches Found</h5></li> 
</ul>
</div>
<div class="container">
<form action="/searchUsers" method="post">
<table>
<tr>
<td>User Id:</td><td><input id="userid"  name="userid" type="text"/></td>
<td>Role:</td>
<td><select name="role">
  <option value="Admin">Admin</option>
</select></td></tr>
<tr>
<td>First Name:</td><td><input id="firstname" name="firstname" type="text"/></td>
<td>Last Name:</td><td><input id="lastname" name="lastname" type="text"/></td>
<td>Status:</td>
<td><select name="value" id="value">
  <option  value="Active">Active</option>
</select></td></tr>
<tr>
<td>
<font color="red">Use WildCard * for better result</font>
</td>
<td>
</td>
<td>
</td>
<td>
</td>
<td>
<input id="click" class="btn" type="submit" value="Search"/></td>
<td>
<input class="butn" type="reset" value="Cancel"/></td></tr>

</table>
</form><br/>
</div>
<div class="container">
Filter:&nbsp;&nbsp;<input id="myInput" type="text" placeholder="Type to Filter..."/>
</div>
<div class="container">
<table class="table table-striped">
<thead>
<tr>
<th>Actions</th>
<th>User Name</th>
<th>First Name</th>
<th>Last Name</th>
<th>Role</th>
<th>Status</th>
</tr>
</thead>
<tbody id="myTable">
<c:forEach var="user" items="${users}" varStatus="loop">
<tr>
<td><span class="glyphicon glyphicon-align-justify"></span></td>
<td>${user[0]}</td>
<td>${user[2]}</td>
<td>${user[3]}</td>
<td>${user[7]}</td>
<td>${user[8]}</td>
</tr>
</c:forEach>
</tbody>
</table>
</div>
</body>
</html>