<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("path", basePath);
%>
<style type="text/css">
.clear{
clear:both;
}
.dierhang{
margin-top:20px;
float:left;
border:1px solid gray;
width:100%;
height: 300px;
}
.dierhang{

padding-top:30px;
}
.dierhang img{
margin-left: 100px;
}
.dierhang p{
margin-left: 100px;
}
.dierhang img p{
	margin-left:10px;
	text-align:center;
	align-content: center;
}
.div_table1{
float:left;
	width: 100%;
	height: 300px;
	margin: 20px auto;
}
.table1 th{
font-size:20px;
background-color: gray;
}
.table1 td{
text-align:center;
	border:1px solid gray;
}
.div_table2{
float:left;
	width: 100%;
	height: 300px;
}
.table2 th{
font-size:20px;
background-color: gray;
}
.table2 td{
text-align:center;
	border:1px solid gray;
}

</style>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${path}/css/menuStyle.css" rel='stylesheet' type='text/css' />
<title>User Menu</title>
</head>
<body>
<div class="main">
	<div class="login-form">
		
		
		<div class="daohang">
			<a href="DocumentController">管理我的文档</a>
		</div>
		<div class="daohang">
			<a href="${path}/mode2/update_user.jsp">修改个人信息</a>
		</div>
		<div class="daohang">
			<a href="${path}/mode2/uploadfile.jsp">上传文件</a>
		</div>
		
		
		
		
		<div class="dierhang">
			<div class="image">			
				<img src="${sessionScope.loginUser.fPhoto }" width="150">
				<p>账号:${sessionScope.loginUser.fTel}</p>
								
			</div>
			<div class="info">
				<p>姓名：${sessionScope.loginUser.fUser}</p>
				<p>等级:${sessionScope.loginUser.fLevel}</p>
				<p>个人简介:${sessionScope.loginUser.fIntroduction}</p>
				<p>网盘空间:${sessionScope.loginUser.fSize}G</p>
			</div>
			
		</div>
	
			<div class="div_table1">
				
				<table class="table1" >
					<tr class="table1_th">
						<th colspan="10">我的文档</th>
					</tr>
					<tr class="table1_td">
						<td>标题</td>
						<td>类型</td>
						<td>上传时间</td>
						<td>文件大小</td>
						
						
					</tr>
					<c:forEach var="doc" items="${requestScope.DocumentList }" >
					<tr>
						<td>${doc.fTitle }</td>
						<td>${doc.fType }</td>
						
						<td>${doc.fUploadTime }</td>
						<td>${doc.fSize }KB</td>
						
					</tr>
					</c:forEach>
					
				</table>
			
		</div>
		
		
		</div>
			</div>
			<div class="clear"></div>
			
		</div>
</body>
</html>