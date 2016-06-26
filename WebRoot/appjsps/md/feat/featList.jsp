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
<title>分类列表</title>
	
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/easyui-1.3.6/themes/default/easyui.css"/>
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/easyui-1.3.6/themes/icon.css" />
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/css/common.css" />
</head>
<body>
<div align="center">
	<table id="featListId"/></table>	
</div>
	<script type="text/javascript" src="<%=path %>/resources/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/easyui-1.3.6/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/easyui-1.3.6/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/esourcing.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/esourcing.util.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/jquery.serializeJSON.js"></script>

<script type="text/javascript">
	$(function(){
		var FeatIdList;
		$('#featListId').datagrid({
			url: 'getFeatList.action?categoryId=<%=categoryId%>',
			title: '属性维护<span id=\"messg_id\" style=\"color:red;margin-left:10px;font-weight:normal;\"></span>',
			pagination:true,
			fitColumns: true,
			rownumbers:true,
			toolbar: '#tb',
			singleSelect: false,
			tools: [{   
    		   iconCls:'icon-add', 
   		   	   handler:function(){forFeatAdd();}   
  		    },
  		    {   
    		   iconCls:'icon-remove', 
   		   	   handler:function(){forFeatDelete();}   
  		    },
  		    {   
    		   iconCls:'icon-edit', 
   		   	   handler:function(){forFeatMerge();}   
  		    },
  		    {   
               iconCls:'icon-search',   
               handler:function(){forFeatView();}   
  			}],
			columns:[[
			    {field:'checkBox',checkbox:true},
				{field:'code',title:'属性编码',width:150,align:'center'},
				{field:'name',title:'属性名称',width:150,align:'center'},
				{field:'aliasName',title:'属性别名',width:150,align:'center'}
			]],
			onLoadSuccess:function(){
				//ObjList = $('#ListId').data('datagrid').data;
		}
	});	

		function forFeatAdd(){
			 esourcing.util.goUrl("mdFeatpersist.jsp?categoryId=<%=categoryId%>");
		};
		function forFeatMerge(){
					FeatIdList = esourcing.util.getSelections("featListId","id");
					if(FeatIdList.length==1){
						esourcing.util.goUrl("editFeatPage.action?id="+FeatIdList[0]);
					}else if(FeatIdList.length==0){
						$("#messg_id").html('请选择一条记录');
						return false;
					}else{
						$("#messg_id").html('只能选择一条记录');
						return false;
					}				
		};
		function forFeatDelete(){
					FeatIdList = esourcing.util.getSelections("featListId","id");
					var featIds = FeatIdList.join();
					rowNum = FeatIdList.length;
					if(rowNum==0){
						$("#messg_id").html('请选择一条或多条记录');
						return false;
						}
					$.messager.confirm('', '确定删除选中'+rowNum+'记录', function(del){
						if (del){
							$.ajax({
								   type: "POST",
								   url: "delFeatsByIds.action",
								   data: "featIds="+featIds,
								   success: function(data){
										if(data.result=='true'){
											esourcing.util.rightMessage("删除提示","删除属性成功");
										}else{
											esourcing.util.rightMessage("删除提示","删除属性失败");
											return false;
										}
										$('#featListId').datagrid('reload');
								   }
							});
						}
					});				
		};
		
	});
</script>
</body>
</html>
	