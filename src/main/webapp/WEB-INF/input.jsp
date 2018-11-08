<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
Create User
</div>
<div class="container">
<table>
<form:form action="/postuser" method="post" modelAttribute="user">
<tr>
<td>User Id:<font color="red">*</font></td><td><form:input id="userid" type="text" path="userId"/></td>
<td>Password:<font color="red">*</font></td><td><form:input id="password" type="password" path="password"/></td>
<td>Role:<font color="red">*</font></td>
<td><form:select path="role">
  <form:option value="Admin">Admin</form:option>
</form:select></td></tr>
<tr>
<td>First Name:<font color="red">*</font></td><td><form:input id="firstname" type="text" path="firstName"/></td>
<td>Last Name:<font color="red">*</font></td><td><form:input id="lastname" type="text" path="lastName"/></td>
<td>Middle Name:</td><td><form:input id="middlename" type="text" path="middleName"/></td>
</tr>
<tr>
<td>Email:<font color="red">*</font></td><td><form:input id="email" type="text" path="email"/></td>
<td>Phone:</td><td><form:input id="phone" type="text" path="phone"/></td>
<td>Status:<font color="red">*</font></td>
<td><form:select path="status">
  <form:option value="Active">Active</form:option>
</form:select></td></tr>
<tr><td>
<input class="btn" type="submit" value="Save User Info"/></td>
<td>
<input class="butn" type="reset" value="Cancel"/></td></tr>
</form:form>
</table>
</div>
</body>
</html>