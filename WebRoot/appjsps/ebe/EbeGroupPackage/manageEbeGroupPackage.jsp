<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">    
    <title>组-包关系管理</title>    
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
  $('#packageInGroup').datagrid({
	  	url: 'showGroupPackageList.action',
		title: '评标小组组内的包',
		pagination:true,
		width: 1100,
		height: 425,
		fitColumns: true,
		singleSelect:false,
		columns:[[
		
			{field:'select',width:80,checkbox:true},
			{field:'id',title:'主键',width:80,hidden:true},
			{field:'projectId',title:'项目ID',width:80,hidden:true},
			{field:'packageId',title:'包id',width:80},
			{field:'groupId',title:'组id',width:80,hidden:true},
			{field:'packageName',title:'包名称',width:120}
		]],
		toolbar: '#packageInGroupTB',	
		tools: [{   
	    		   iconCls:'icon-remove', 
	    		   text: '删除|', 
	   		   	   handler:function(){
				  		forRemovePackageFromGroup();
	   		   	   }   
	  		    }],

		onClickRow: function(rowIndex, rowData){
			$('#packageInGroup').datagrid('selectRow', rowIndex);
			currentIndex = rowIndex;
		}

	});
});

  $(function(){
	$('#packageNotInGroup').datagrid({
	  	url: 'showPackageNotInGroupList.action',
		title: '未分配评标小组的包',
		pagination:true,
		width: 1100,
		height: 425,
		fitColumns: true,
		singleSelect:false,
		columns:[[
			{field:'select',width:80,checkbox:true},
			{field:'id',title:'主键',width:80,hidden:true},
			{field:'projectId',title:'项目ID',width:80,hidden:true},
			{field:'packageId',title:'包id',width:80},
			{field:'packageName',title:'包名称',width:120}
		]],
		toolbar: '#packageNotInGroup',	
		tools: [{   
	    		   iconCls:'icon-add', 
	    		   text: '添加|', 
	   		   	   handler:function(){
	   		   	  	 forAddPackageToGroup();
	   		   	   }   
	  		    }],
		onClickRow: function(rowIndex, rowData){
			$('#packageNotInGroup').datagrid('selectRow', rowIndex);
			currentIndex = rowIndex;
		}

	});
  });
  	//包出组
  	function forRemovePackageFromGroup(){
  	var rows = $('#packageInGroup').datagrid('getChecked');
		if (rows == "" || rows == null) {
			alert("请选择一条数据！");
			return false;
		}
		var packageIds = "";
		for ( var i = 0; i < rows.length; i++) {
			if (i != (rows.length - 1)) {
				packageIds = packageIds + rows[i].packageId + ",";
			} else {
				packageIds = packageIds + rows[i].packageId;
			}
		}
		$.ajax({
			type:'POST',
			url: "removePackagefromGroup.action",
			data: "myPackageIds ="+packageIds,
			dataType: "text",
			success:function(info){
				$.messager.alert("操作提示", "操作成功！");
				$('#packageNotInGroup').datagrid('reload'); 
				$('#packageInGroup').datagrid('reload'); 
			}
		});
  	}
	//包入组
	function forAddPackageToGroup() {
		var rows = $('#packageNotInGroup').datagrid('getChecked');
		if (rows == "" || rows == null) {
			alert("请选择一条数据！");
			return false;
		}
		var packageIds = "";
		for ( var i = 0; i < rows.length; i++) {
			if (i != (rows.length - 1)) {
				packageIds = packageIds + rows[i].packageId + ",";
			} else {
				packageIds = packageIds + rows[i].packageId;
			}
		}
		$.ajax({
			type:'POST',
			url: "addPackageToGroup.action",
			data: "myPackageIds ="+packageIds,
			dataType: "text",
			success:function(info){
				$.messager.alert("操作提示", "操作成功！");
				$('#packageNotInGroup').datagrid('reload'); 
				$('#packageInGroup').datagrid('reload'); 
			}
		});
	}
</script>
<body>
<div id="groupPackageTab" class="easyui-tabs" data-options="border:false,fit:true">	
	<div title="评标小组组内产品" >
		<table id="packageInGroup"></table>
	</div>

	<div title="未分配评标项目产品">
		<table id="packageNotInGroup"></table>
	</div>
</div>
</body>
</html>
