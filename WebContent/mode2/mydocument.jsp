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
<title>我的文档</title>
<link href="${path}css/findByIdResultStyle.css" rel='stylesheet' type='text/css' />
</head>
<body>
<div class="main">
		<div class="login-form">
			<table border="1" class="ResultTable">
			<tr>
				
				<th>fTitle</th>
				
				
				<th>fUploadTime</th>
				<th>fSize</th>
				
				<th>操作</th>
			</tr>
			<c:forEach var="item" items="${requestScope.DocumentList}">
			<tr>
				
				<td>${item.fTitle }</td>
				<td>${item.fUploadTime }</td>
				<td>${item.fSize }KB</td>
				
				<td><input type="button" value="删除" onclick="location='deleteuploadfile?fid=${item.fid }&filename=${item.fTitle}'">
				
				<input type="button" value="下载" onclick="location='downloadfile?filename=${item.fTitle }'">
				</td>
			</tr>
			</c:forEach>
		</table>
	</div>
</div>
</body>
</html>