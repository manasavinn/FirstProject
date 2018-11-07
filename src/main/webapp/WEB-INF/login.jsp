<%@taglib uri="http://www.springframework.org/tags/form" prefix="c"%>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
<jsp:include page="layout.jsp" />
<div style="background-image:url('images/demo/backgrounds/01.jpg');">
  <div id="pageintro" class="hoc clear">
<form action="/checkUser" method="POST"> 
<font color="black">Username:<input id="u" type="text" name="username" required/><br/>
Password:<input id="p" type="password" name="password" required/><br/></font>
<input id="btn1" class="btn" type="submit"/>
</form>
   <!-- ################################################################################################ -->
  </div>
</div>
</body>
</html>