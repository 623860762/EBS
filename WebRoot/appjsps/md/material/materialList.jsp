<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.ceit.common.util.StaticSource"%>
<%
	String path = request.getContextPath();
	String categoryId = request.getParameter("categoryId");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>物料维护</title>
	
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/easyui-1.3.6/themes/default/easyui.css"/>
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/easyui-1.3.6/themes/icon.css" />
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/css/common.css" />
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/css/ebs.css" />
</head>
<body>
<div align="center">
	<table id="MatListId"/></table>	
</div>
	<script type="text/javascript" src="<%=path %>/resources/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/easyui-1.3.6/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/easyui-1.3.6/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/esourcing.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/esourcing.util.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/jquery.serializeJSON.js"></script>

<script type="text/javascript">
	$(function(){
		var rowNum;
		var MatIdList;
		$('#MatListId').datagrid({
			url: 'getMaterialList.action?categoryId=<%=categoryId%>',
			title: '物料维护<span id=\"messg_id\" style=\"color:red;margin-left:10px;font-weight:normal;\"></span>',
			pagination:true,
			fitColumns: true,
			rownumbers:true,
			toolbar: '#tb',
			singleSelect: false,
			tools: [{   
    		   iconCls:'icon-add', 
   		   	   handler:function(){forMatAdd();}   
  		    },
  		    {   
    		   iconCls:'icon-remove', 
   		   	   handler:function(){forMatDelete();}   
  		    },
  		    {   
    		   iconCls:'icon-edit', 
   		   	   handler:function(){forMatMerge();}   
  		    },
  		    {   
               iconCls:'icon-search',   
               handler:function(){forMatView();}   
  			}],
			columns:[[
			    {field:'checkBox',checkbox:true},
				{field:'code',title:'物料编码',width:150,align:'center'},
				{field:'name',title:'物料名称',width:150,align:'center'},
				{field:'remark',title:'物料描述',width:150,align:'center'},
				{field:'purchaseLevel',title:'购买等级',width:150,align:'center'},
				{field:'opTime',title:'操作时间',width:150,align:'center'}
			]],
			onLoadSuccess:function(){
				//ObjList = $('#ListId').data('datagrid').data;
		}
	});	

		function forMatAdd(){
			 //esourcing.util.goUrl("addMaterial.jsp?categoryId=<%=categoryId%>");
			 esourcing.util.goUrl("forMatInsertPage.action?categoryId=<%=categoryId%>");
		};
		function forMatMerge(){
					MatIdList = esourcing.util.getSelections("MatListId","id");
					if(MatIdList.length==1){
						esourcing.util.goUrl("foreditMaterial.action?id="+MatIdList[0]);
					}else if(MatIdList.length==0){
						$("#messg_id").html('请选择一条记录');
						return false;
					}else{
						$("#messg_id").html('只能选择一条记录');
						return false;
					}				
		};
		function forMatDelete(){
					MatIdList = esourcing.util.getSelections("MatListId","id");
					var matIds = MatIdList.join();
					rowNum = MatIdList.length;
					if(rowNum==0){
						$("#messg_id").html('请选择一条或多条记录');
						return false;
						}
					$.messager.confirm('', '确定删除选中'+rowNum+'记录', function(del){
						if (del){
							$.ajax({
								   type: "POST",
								   url: "delMatByIds.action",
								   data: "matIds="+matIds,
								   success: function(data){
										if(data.result=='true'){
											esourcing.util.rightMessage("删除提示","删除物料成功");
										}else{
											esourcing.util.rightMessage("删除提示","删除物料失败");
											return false;
										}
										$('#MatListId').datagrid('reload');
								   }
							});
						}
					});				
		};
		function forMatView(){
					MatIdList = esourcing.util.getSelections("MatListId","id");
					if(MatIdList.length==1){
						esourcing.util.goUrl("forMaterialPage.action?id="+MatIdList[0]);
					}else if(MatIdList.length==0){
						$("#messg_id").html('请选择一条记录');
						return false;
					}else{
						$("#messg_id").html('只能选择一条记录');
						return false;
					}
		};
		
	});
</script>
</body>
</html>
	