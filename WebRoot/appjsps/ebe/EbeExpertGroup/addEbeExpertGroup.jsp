<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">    
    <title>为小组添加专家</title>    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/easyui-1.3.6/themes/default/easyui.css"/>
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/easyui-1.3.6/themes/icon.css" />
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/css/common.css" />
	
	<script type="text/javascript" src="<%=path %>/resources/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/easyui-1.3.6/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/easyui-1.3.6/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/esourcing.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/esourcing.util.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/jquery.serializeJSON.js"></script>
  </head>

<script type="text/javascript">
var currentIndex;
$(function(){
  $('#expertCouldInGroup').datagrid({
	  	url: 'showExpertCouldInGroup.action',
		title: '小组内可以添加的专家',
		pagination:true,
		width: 1100,
		height: 425,
		fitColumns: true,
		singleSelect:false,
		columns:[[
				  {field:'select',width:80,checkbox:true},
		          {field:'id',title:'主键',width:100,hidden:false},   
		       	  {field:'expertName',title:'姓名',width:100},    
		          {field:'expertAccount',title:'账号',width:100},
		          {field:'isHeader',title:'是否是组长',width:100}  
		]],
		toolbar: '#ExpertIntoGroupTB',	
		tools: [{   
	    		   iconCls:'icon-add', 
	    		   text: '添加|', 
	   		   	   handler:function(){
				  		forAddExpertIntoGroup();
	   		   	   }   
	  		    }],

		onClickRow: function(rowIndex, rowData){
			$('#ExpertIntoGroupTB').datagrid('selectRow', rowIndex);
			currentIndex = rowIndex;
		}
	});
});

//专家批量入组
function forAddExpertIntoGroup(){
		var rows = $('#expertCouldInGroup').datagrid('getChecked');
		if (rows == "" || rows == null) {
			alert("请选择一条数据！");
			return false;
		}
		var expertGroupIds = "";
		for ( var i = 0; i < rows.length; i++) {
			if (i != (rows.length - 1)) {
				expertGroupIds = expertGroupIds + rows[i].id + ",";
			} else {
				expertGroupIds = expertGroupIds + rows[i].id;
			}
		}
		$.ajax({
			type:'POST',
			url: "addExpertToGroup.action",
			data: "expertGroupIds ="+expertGroupIds,
			dataType: "text",
			success:function(info){
				$.messager.alert("操作提示", "操作成功！");
				$('#expertCouldInGroup').datagrid('reload'); 
				window.opener.location.href=window.opener.location.href;
			}
		});
}
</script>
<body>
	<div title="小组内可以添加的专家" >
		<table id="expertCouldInGroup"></table>
	</div>
</body>
</html>
