<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>新增评审小组</title>
    
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
    <form id="insertEbeGroup" method="post">
    	<input  name="projectId"  type="hidden"  value="1" >
		<table class="table_common"  class="easyui-datagrid" center" width="800px">
	
			<tr height="15%">
    			<th class="table_head" colspan="4" style="text-align:center;">新增评审小组</th>  	
    		</tr>
    		    		<tr >
       		 	<td class="table_td1">组名称:</td><td><input name='groupName' style="height:150px" class="easyui-validatebox text w150" data-options="novalidate = true" ></td>
        	</tr>
        	<tr>
        		<td class="table_td1">小组类型:</td>
        		<td><input class="easyui-combobox"  name='groupType'
        		data-options="
							valueField: 'label',
							textField: 'value',
							data: [{
								label: 'BUSI',
								value: '商务组'
							},{
								label: 'PRICE',
								value: '价格组'
							},{
								label: 'TECH',
								value: '技术组'
							}]" />

        		</td>
        	</tr>
    	<tr style="height:30px;"><td colspan="4" style="text-align:center;"><input id="subFormEbeGroup" class="easyui-linkbutton"  type="button" value="保存"/>
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
//js书写区域	
	//设置两个name
	$("#subFormEbeGroup").click(function(){
			$("#insertEbeGroup").form("submit", {    
    						url:"insertEbeGroup.action",
    						onSubmit: function(){},
    						success:function(data){ 
        							alert("添加成功");
        							window.opener.location.href=window.opener.location.href;
		    						self.opener=null;
        							self.close();	
   							 }});
			});	
//end	
</script>
  </body>
</html>
