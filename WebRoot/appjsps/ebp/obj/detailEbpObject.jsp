<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.ceit.ebs.ebp.vo.EbpObjectVo"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
EbpObjectVo ebpObjectVo = (EbpObjectVo)request.getAttribute("ebpObjectVo");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>分标详情</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/easyui-1.3.6/themes/default/easyui.css"/>
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/easyui-1.3.6/themes/icon.css" />
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/css/common.css" />

  </head>
  
  <body>
     <br>
     <br>

	<table class="table_common"  align="center" width="800px">
		
		<tr height="15%">
			<th class="table_head" colspan="4" style="text-align:center;">分标信息信息详情</th>  	
		</tr>
		<tr >
	  		 	<td class="table_td1">标名称:</td><td><input value="<%=ebpObjectVo.getObjectName()==null?"":ebpObjectVo.getObjectName() %>" name="objectName"   type="text" disabled/></td>
	   		
		</tr>
		<tr>
			<td class="table_td1">项目ID:</td>
	   		<td>
	   			<input value="<%=ebpObjectVo.getProjectId()==null?"":ebpObjectVo.getProjectId() %>" name="projectId"   type="text" disabled/>
	   		</td>
		</tr>
		<tr >
	   		<td class="table_td1">创始人ID:</td><td><input value="<%=ebpObjectVo.getCreatorId()==null?"":ebpObjectVo.getCreatorId() %>" name="creatorId"   type="text" disabled/></td>
		</tr>
		<tr>
			<td class="table_td1">是否有效:</td>
			<td >
				<input value="<%=ebpObjectVo.getIsValid()==null?"":ebpObjectVo.getIsValid() %>" name="isValid"   type="text" disabled/>
	   		</td>
		</tr>
	    <tr>
	    	<td><input name="projectId" style="display:none;" value="<%=ebpObjectVo.getId() %>" /></td>
	    	<td><input  type="button" value="返回" onclick="javascript:top.close();" align="middle"/></td>
	    </tr>
   </table>
    
    
    <script type="text/javascript" src="<%=path %>/resources/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/easyui-1.3.6/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/easyui-1.3.6/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/esourcing.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/esourcing.util.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/jquery.serializeJSON.js"></script>
	
	<script type="text/javascript">
		$(function(){

		

		});
	
	</script>
  </body>
</html>
