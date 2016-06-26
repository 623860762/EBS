<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MdCategory.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<script type="text/javascript" src="http://localhost:8080/EBS/resources/js/jquery-1.8.3.min.js"></script>
	<link rel="stylesheet" type="text/css" href="http://localhost:8080/EBS/resources/css/common.css"/>
	<script type="text/javascript" src="http://localhost:8080/EBS/resources/js/json.js"></script>
	
  </head>
  
  <body>
    <form action="persistCategory.action" method="post">
		<table>
			<tr>
				<td>分类编码</td>
				<td><input type="text" id="code" name="code"/></td>
			</tr>
			<tr>
				<td>分类名称</td>
				<td><input type="text" id="remark" name="remark"/></td>
			</tr>
			<tr>
				<td>分类别名</td>
				<td><input type="text" id="aliasName" name="aliasName"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="提交" /> </td>
			</tr>
		</table>
		<table id="ulist" border="2">
		</table>
	</form>
  </body>
</html>
