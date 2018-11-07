<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(document).ready(function(){

 
 $("#loginuser").focusout(function(){
       $.get('/allUsers',
        function(data){
    	   var user=$("#loginuser").val();
        	$.each(data, function(i, item) {
        		 if(user==item.username)
     		        alert('user already exists');
        		    
        	});
        });
    });
 $("#cfrm").focusout(function(){
     var pwd1=$("#pwd").val();
     var pwd2=$("#cfrm").val();
     if(pwd1!=pwd2)
    	 alert("password doesn't match");
    });
});
 </script>
</head>
<body>
<jsp:include page="layout.jsp" />
<div style="background-image:url('images/demo/backgrounds/01.jpg');">
  <div id="pageintro" class="hoc clear"> 
<form:form action="/adduser" method="post" modelAttribute="user">
<font color="black">Username:<form:input id="loginuser" type="text" path="username"/><br/>
Password:<form:input id="pwd" type="password" path="password"/><br/>
Confirm Password:<input id="cfrm" type="password" /><br/></font>
<input class="btn" type="submit"/>
</form:form>
   <!-- ################################################################################################ -->
  </div>
</div>

</body>
</html>