<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.ceit.ebs.ebe.vo.EbeRepealVo"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
EbeRepealVo ebeRepealVo = (EbeRepealVo)request.getAttribute("ebeRepealVo");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>废标信息查看</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/css/common.css" />
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/easyui-1.3.6/themes/default/easyui.css"/>
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/easyui-1.3.6/themes/icon.css" />

  </head>
  
  <body>
 
    <form id="showEbeRepeal" method="post" >
        <input  name="id"  type="hidden" value="10"><!--从列表页面获得 -->
		<table class="table_common"  class="easyui-datagrid" center" width="800px">
	
			<tr height="15%">
    			<th class="table_head" colspan="4" style="text-align:center;">废标信息查看</th>  	
    		</tr>
    		<tr >
       		 	<td class="table_td1">包名称:</td><td><input value="<%=ebeRepealVo.getPackageName()==null?"":ebeRepealVo.getPackageName() %>" style="height:150px" class="easyui-validatebox text w150" data-options="novalidate = true" readonly="true"></td>
        	</tr>
        	<tr>
        		<td class="table_td1">供应商名称:</td><td><input   value="<%=ebeRepealVo.getSupplierName()==null?"":ebeRepealVo.getSupplierName() %>" style="height:50px" class="easyui-validatebox text w150" data-options="novalidate = true" readonly="true"></td>
        	</tr>
        	<tr>
        		<td class="table_td1">废标原因:</td><td><input value="<%=ebeRepealVo.getBlankOutReason()==null?"":ebeRepealVo.getBlankOutReason() %>" style="height:50px"  class="easyui-validatebox text w150" data-options="novalidate = true" readonly="true"></td>
        	</tr>
        	<tr>
        		<td class="table_td1">招标文件规定:</td><td><input value="<%=ebeRepealVo.getFileRequire()==null?"":ebeRepealVo.getFileRequire() %>"  style="height:50px" class="easyui-validatebox text w150" data-options="novalidate = true" readonly="true"></td>
        	</tr>
        	<tr>
        		<td class="table_td1">招标文件响应:</td><td><input value="<%=ebeRepealVo.getFileRelpy()==null?"":ebeRepealVo.getFileRelpy() %>" style="height:50px"  class="easyui-validatebox text w150" data-options="novalidate = true" readonly="true"></td>	
    		</tr>
    	<tr style="height:30px;"><td colspan="4" style="text-align:center;">
    	<input  type="button" value="关闭" class="easyui-linkbutton" onclick="javascript:window.close();" /></td></tr>
	</table>
</form>



<!--js引入区域	-->
	<script type="text/javascript" src="<%=path %>/resources/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/easyui-1.3.6/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/easyui-1.3.6/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/esourcing.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/esourcing.util.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/jquery.serializeJSON.js"></script>
<!--end	-->

<script type="text/javascript">
</script>
  </body>
</html>
