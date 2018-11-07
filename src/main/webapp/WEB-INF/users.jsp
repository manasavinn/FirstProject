<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
function deleteUser(index){
	var ind=index;
	 $.post('/deleteUser',
		        {
		          index: ind
		        },
		        function(data){
		        	location.reload();
		        });
}
</script>
</head>
<body>
<jsp:include page="layout.jsp"/>
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<div class="wrapper bgded overlay" style="background-image:url('images/demo/backgrounds/01.jpg');">
  <div id="pageintro" class="hoc clear"> 
    <!-- ################################################################################################ -->
    <article>
       <h3 class="heading">Users</h3>
       
		<c:forEach var="user" items="${users}" varStatus="loop">
		<table style="width:50%">
		  <tr>
			<td width="30%"><span id="${loop.index}">${user.username}</span></td><td width="30%"><input id="b1" type="submit" class="btn" value="Delete"
			onClick="deleteUser(${loop.index})"/></td></tr>
		</table>
		</c:forEach>
	
    </article>
    <!-- ################################################################################################ -->
  </div>
</div>
</body>
</html>
