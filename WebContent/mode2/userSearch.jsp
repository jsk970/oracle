<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("path", basePath);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${path}/css/userManagStyle.css" rel='stylesheet' type='text/css' />
<script type="application/x-javascript"> 
addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); 
function hideURLbar(){ window.scrollTo(0,1); } 
function check(){
	if(Searchform.fTel.value == ""){
		alert("SEARCH USER不能为空！");
		return false;
	}
}
</script>

<title>userManag</title>
</head>
<body>
 <div class="main">
		<div class="login-form">
			<form action="../UserController?action=findById" name="Searchform" method="post" onsubmit="return check()">
				SEARCH USER：<input type="text" name='fTel' placeholder="fTel">
					<div class="submit">
						<input type="submit" value="SEARCH" >
					</div>		
			</form>
		</div>
</div>
		
</body>
</html>