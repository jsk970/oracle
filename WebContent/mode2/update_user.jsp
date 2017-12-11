<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../css/registStyle.css" rel='stylesheet' type='text/css' />
<script type="text/javascript" src="../js/regist.js">
	
</script>
<title>Regist</title>
</head>
<body>
 <div class="main">
		<div class="login-form">
			<h1>Member Regist</h1>
					<div class="head">
						<img src="../image/user.png" alt=""/>
					</div>
				<form action="../UserController?action=update_user" name="registform" method="post" enctype="multipart/form-data" onsubmit="return check()">
						FTEL：<input type="text" id="fTel" class="text" name="fTel" value="${sessionScope.loginUser.fTel }" readonly="readonly"><br/>
						PASSWORD：<input type="password" name="fPassword"  ><br/>
						PASSWORD AGAIN:<input type="password" name="fPwd"  ><br/>
						NAME:<input type="text" name="fUser" placeholder="${sessionScope.loginUser.fUser }"><br/>
						CHANGE HEAD SCULPTURE:<input type="file" name="fphoto" value="选择文件"><br/>
						INTRODUCE:<br/><textarea  name="fintroduction" placeholder="${sessionScope.loginUser.fIntroduction }"></textarea>
						<div class="submit">
							<input type="submit"  value="SUBMIT" >
							<input type="reset"  value="RESET">
					</div>	
				</form>
			</div>
			
 
				
		</div>
		
</body>
</html>