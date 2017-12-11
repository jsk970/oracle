<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("path", basePath);
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>好友</title>
<link href="${path}css/findByIdResultStyle.css" rel='stylesheet' type='text/css' />
</head>
<body>

<div class="main">
		<div class="login-form">
		
			<table border="1" class="ResultTable">
			<tr>
				
				<th>fFriendTel</th>
				<th>fUser</th>
				<th>fMemo</th>
				<th>操作</th>
			</tr>
			<c:forEach var="item" items="${requestScope.friendlist}">
			<tr>
				<td>${item.fFriendTel }</td>
				<td>${item.fUser }</td>
				<td>${item.fMemo }</td>
				<td><input type="button" value="删除" onclick="location='FriendController?action=deletefriend&fFriendTel=${item.fFriendTel }'">
				<input type="button" value="修改" onclick="location=''">
				</td>
			</tr>
			</c:forEach>
		   
		   
		</table>
	</div>
</div>
</body>
</html>