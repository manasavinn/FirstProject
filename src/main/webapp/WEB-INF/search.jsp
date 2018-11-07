<%@taglib uri="http://www.springframework.org/tags/form" prefix="c"%>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
	$("#sp").hide();
	$("#b2").hide();
    $("#button").click(function(){
        $.post('/searchUser',
        {
          username: $("#username").val()
        },
        function(data){
        	$("#sp").show();
        	$("#l1").text(data.username);
        	$("#l2").text(data.password);
        	$("#user").hide();
        	$("#password").hide();
        	
        });
    });
    $("#b1").click(function(){
    	var l1=$("#l1").text();
    	var l2=$("#l2").text();
    	  $("#l1").hide();
    	   $("#l2").hide();
    	   $("#b1").hide();
     	   $("#user").show();
        	$("#password").show();
        	 $("#b2").show();
             $("#user").val(l1),
             $("#password").val(l2)

        });

    $("#b2").click(function(){
        $.post('/updateUser',
        {
          username: $("#user").val(),
          password: $("#password").val()
        },
        function(data){
        	$("#user").hide();
        	$("#password").hide();
        	 $("#b2").hide();
        	 $("#l1").show();
      	     $("#l2").show();
      	    $("#b1").show();
        	$("#l1").val(data.username);
        	$("#l2").val(data.password);
        });
    });
});
</script>
</head>
<body>
<jsp:include page="layout.jsp" />
<div style="background-image:url('images/demo/backgrounds/01.jpg');">
  <div id="pageintro" class="hoc clear"> 
<input type="text" name="username" id="username"/>
<input id="button" class="btn" type="submit" value="Search"/><br/>
<span id="sp">
<table style="width:50%" >
<font color="black"><tr><td>Username:</td><td><label id="l1"></label><input id="user" type="text"/></td></tr>
<tr><td>Password:</td><td><label id="l2"></label><input id="password" type="text"/></td></tr></font>
<tr><td><input id="b1" type="submit" value="Update"/>
<input id="b2" type="submit" value="Save"/></td></tr>
</table>
</span>
   <!-- ################################################################################################ -->
  </div>
</div>

</body>

</html>