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
table, tr, td {
    border: none;
}
</style>
</head>
<body>
<jsp:include page="loginlayout.jsp" />

<div style="background-image:url('images/demo/backgrounds/01.jpg');">
<div id="pageintro" class="hoc clear">
 <font color="#000080">
Create User
<table>
<form:form id="form" action="/postuser"  method="post" modelAttribute="user">
<tr>
<td>User Id:<font color="red">*</font></td><td><form:input id="userid" type="text" path="userId" required="required"/></td>
<td>Password:<font color="red">*</font></td><td><form:input id="password" type="password" path="password" required="required" pattern="^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$" title="Atleast 8 characters, Atleast 1 special character, 1 uppercase, 1 lowercase"/></td>
<td>Role:<font color="red">*</font></td>
<td><form:select path="role">
  <form:option value="Admin">Admin</form:option>
</form:select></td></tr>
<tr>
<td>First Name:<font color="red">*</font></td><td><form:input id="firstname" type="text" path="firstName" required="required"/></td>
<td>Last Name:<font color="red">*</font></td><td><form:input id="lastname" type="text" path="lastName" required="required"/></td>
<td>Middle Name:</td><td><form:input id="middlename" type="text" path="middleName"/></td>
</tr>
<tr>
<td>Email:<font color="red">*</font></td><td><form:input id="email" type="text" path="email" required="required" pattern="[^@\s]+@[^@\s]+\.[^@\s]+" title="somebody@domain.com"/></td>
<td>Phone:</td><td><form:input id="phone" type="text" path="phone" pattern="\d{3}[\-]\d{3}[\-]\d{4}" required="required" title="123-456-7890"/></td>
<td>Status:<font color="red">*</font></td>
<td><form:select path="status">
  <form:option value="Active">Active</form:option>
</form:select></td></tr>
<tr><td>
<input id="button" class="btn" type="submit" value="Save User Info"/></td>
<td>
<input class="btn" type="reset" value="Cancel"/></td></tr>
</form:form>
</table>
</font>
</div>
</div>
</body>
</html>