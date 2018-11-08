<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<style>
.btn {background-color: #008CBA;}
.butn {background-color: #f44336;}
</style>
</head>
<body>
<div class="container">
Manage User
</div>
<div class="container">
<form action="/postuser" method="post">
<table>

<tr>
<td>User Id:</td><td><input id="userid" type="text"/></td>
<td>Role:</td>
<td><select>
  <option value="Admin">Admin</option>
</select></td></tr>
<tr>
<td>First Name:</td><td><input id="firstname" type="text"/></td>
<td>Last Name:</td><td><input id="lastname" type="text"/></td>
<td>Status:</td>
<td><select>
  <option value="Active">Active</option>
</select></td></tr>
<tr>
<td>
<input class="btn" type="submit" value="Search"/></td>
<td>
<input class="butn" type="reset" value="Cancel"/></td></tr>

</table>
</form><br/>
</div>
<div class="container">
<table class="table table-hover">
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
<form:forEach var="user" items="${users}">
<tr>
<td>1</td>
<td>${user.userId}</td>
<td>${user.firstName}</td>
<td>${user.lastName}</td>
<td>${user.role}</td>
<td>${user.status}</td>
</tr>
</form:forEach>
</table>
</div>
</body>
</html>