<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.ceit.ebs.sup.vo.SupProjectSupplierVo" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
SupProjectSupplierVo supProjectSupplierVo = new SupProjectSupplierVo();
supProjectSupplierVo = (SupProjectSupplierVo)request.getAttribute("supSupplierVo");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>投标</title>
    
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
    <form id="insertReplyVal" method="post" >
		<table class="table_common"  align="center" width="800px">
	
			<tr height="15%">
    			<th class="table_head" colspan="4" style="text-align:center;" >投标</th>  	
    		</tr>
    	    <tr height="15%">
    	    <td class="table_td1">报价:</td><td><input style="height: 40" maxlength="32" id="price" name="price"  class="easyui-validatebox text w150" missingMessage="不能为空!"   validType="length[1,32]" invalidMessage="必须填写1-32个字符！" type="text" /></td>
    	    <td colspan="2" style="text-align:left;"><input id="subPay" class="easyui-linkbutton"  type="button" value="提交" /></td>
    	    </tr>
    	    <tr>
    	    <td class="table_td1">价格文件:</td><td><input style="height: 40" maxlength="32" name="costFile"  class="easyui-validatebox text w150" missingMessage="不能为空!"   validType="length[1,32]" invalidMessage="必须填写1-32个字符！" type="text" /></td>
    	    <td colspan="2" style="text-align:left;"><input id="subCost" class="easyui-linkbutton"  type="button" value="提交" onclick="forSubCost()"/></td>
    	    </tr>
    		<tr >
       		<td class="table_td1">商务文件:</td><td><input style="height: 40" maxlength="32" name="busFile"  class="easyui-validatebox text w150" missingMessage="不能为空!"   validType="length[1,32]" invalidMessage="必须填写1-32个字符！" type="text" /></td>
    		<td colspan="2" style="text-align:left;"><input id="subBus" class="easyui-linkbutton"  type="button" value="提交" onclick="forSubBus()"/></td>
    		</tr>
    		<tr >
       		<td class="table_td1">技术文件:</td><td><input style="height: 40" maxlength="32" name="tecFile"  class="easyui-validatebox text w150" missingMessage="不能为空!"   validType="length[1,32]" invalidMessage="必须填写1-32个字符！" type="text" /></td>
    		<td colspan="2" style="text-align:left;"><input id="subTec" class="easyui-linkbutton"  type="button" value="提交" onclick="forSubTec()"/></td>
    		</tr>

	     
	    <tr style="height:40px;"><td colspan="4" style="text-align:center;">
	    	<input  type="button" value="关闭" class="easyui-linkbutton" onclick="javascript:top.close();" /></td></tr>
</table>
</form>

	<script type="text/javascript" src="<%=path %>/resources/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/easyui-1.3.6/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/easyui-1.3.6/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/esourcing.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/esourcing.util.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/jquery.serializeJSON.js"></script>

<script type="text/javascript">

</script>
  </body>
</html>
