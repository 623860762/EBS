<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>新增项目</title>
    
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
    <form >
		<table>
			<tr>
				<td>名字</td>
				<td><input type="text" id="projectName" name="projectName"/></td>
			</tr>
			<tr>
				<td>年龄</td>
				<td><input type="text" id="comments" name="comments"/></td>
			</tr>
			<tr>
				<td><input type="button" value="提交" onclick="commit();"/> </td>
			</tr>
		</table>
		<table id="ulist" border="2">
		</table>
	</form>
  </body>
  <script type="text/javascript">
  	alert("aa");
  	alert($);
	function commit(){
		alert("skjfd");
    	$.ajax(
            {type : "post",
             data:{projectName:$('#projectName').val(),comments:$('#comments').val()},
             url : "insertProject.action",
             dataType : "text",
             success : callback
                }
            );
	}
	function callback(data){
   		 var json =  JSON.parse(data);
   		 alert(data);
   		var ulist =  $("#ulist");
    	$.each(json, function(i,item){
         	ulist.append(
        	"<tr><td>"+item.projectName+"</td><td>"+item.comments+"</td></tr>"
              );
        })
	}
</script>
</html>
