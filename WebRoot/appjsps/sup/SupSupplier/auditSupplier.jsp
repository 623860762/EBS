<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.ceit.ebs.sup.vo.SupSupplierVo"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
SupSupplierVo supSupplierVo = new SupSupplierVo();
supSupplierVo = (SupSupplierVo)request.getAttribute("supSupplierVo");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>供应商审核</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/easyui-1.3.6/themes/default/easyui.css"/>
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/easyui-1.3.6/themes/icon.css" />
    <link rel="stylesheet" type="text/css" href="<%=path %>/resources/css/common.css" />
	
  </head>
  
  <body>
      <form id="auditForm" method="post">
		<table class="table_common"  align="center" width="800px">
		<tr height="40%">
    		<th class="table_head" colspan="4" style="text-align:center;" >供应商审核</th>  	
    	</tr>
		<tr>
		<td class="table_td1" colspan="1" style="text-align: left;" height="40%">审核结果：</td>
		</tr>
		<tr>
		<td height="40%"><input type="radio" name="audit" value="1" checked="checked"/>&nbsp;&nbsp;&nbsp;审核不通过 </td>
		</tr>
		<tr>
		<td height="40%"><input type="radio" name="audit" value="2" />&nbsp;&nbsp;&nbsp;审核通过 </td>
		</tr>
		<tr colspan="4" style="text-align:center;">
		<td >
		<input id="subForm" type="button" class="easyui-linkbutton" value="保存"/>
		<input id="return" type="button" class="easyui-linkbutton" value="关闭" onclick="javascript:top.close();"/>
		</td>
		</tr>
		</table>
      </form>
    
	<script type="text/javascript" src="<%=path %>/resources/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/easyui-1.3.6/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/easyui-1.3.6/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/esourcing.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/esourcing.util.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/jquery.serializeJSON.js"></script>

<script type="text/javascript">
var supId;
	$(function(){
		$('#subForm').click(function(){
	        var val=$('input[name="audit"]:checked').attr("value");
			switch(val){
			case "1":
				window.open('failAudit.action?supId='+<%=supSupplierVo.getId() %>);				
				break;
			case "2":
				window.open('passAudit.action?supId='+<%=supSupplierVo.getId() %>);
				break;
				default:
					break;
			}
		});
	});
</script>
  </body>  
</html>
