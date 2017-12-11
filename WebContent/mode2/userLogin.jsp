<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("path", basePath);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${path}/css/loginStyle.css" rel='stylesheet' type='text/css' />
<script type="text/javascript" src="${path}/js/login.js">

</script>

<title>Login in</title>
</head>
<body>
 <div class="main">
		<div class="login-form">
			<h1>Member Login</h1>
					<div class="head">
						<img src="../image/user.png" alt=""/>
					</div>
				<form action="/oracle/UserController?action=login" name="loginform" method="post" onsubmit="return check()">
						FTEL：<input type="text" id="fTel" class="text" name="fTel" placeholder="Phone number" ><br/>
						PASSWORD：<input type="password" name="fPassword" placeholder="Password" ><br/>
						<div class="submit">
							<input type="submit" onclick="myFunction()" value="LOGIN" >
							<a href="userRegist.jsp">注册新用户</a>
					</div>	
					<p><a href="#">Forgot Password</a></p>
				</form>
			</div>
		</div>
		
</body>
</html>