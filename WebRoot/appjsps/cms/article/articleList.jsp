<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.ceit.common.util.StaticSource"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公告</title>
	
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/easyui-1.3.6/themes/default/easyui.css"/>
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/easyui-1.3.6/themes/icon.css" />
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/css/common.css" />
</head>
<body>
<div align="center">
	<table id="articleListId"/></table>	
</div>
	<script type="text/javascript" src="<%=path %>/resources/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/easyui-1.3.6/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/easyui-1.3.6/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/esourcing.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/esourcing.util.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/jquery.serializeJSON.js"></script>

<script type="text/javascript">
	$(function(){
		var ArticleIdList;
		$('#articleListId').datagrid({
			url: 'getArticleList.action',
			title: '公告维护<span id=\"messg_id\" style=\"color:red;margin-left:10px;font-weight:normal;\"></span>',
			pagination:true,
			fitColumns: true,
			rownumbers:true,
			toolbar: '#tb',
			singleSelect: false,
			tools: [{   
    		   iconCls:'icon-add', 
   		   	   handler:function(){forArticleAdd();}   
  		    },
  		    {   
    		   iconCls:'icon-remove', 
   		   	   handler:function(){forArticleDelete();}   
  		    },
  		    {   
    		   iconCls:'icon-edit', 
   		   	   handler:function(){forArticleMerge();}   
  		    },
  		    {   
               iconCls:'icon-search',   
               handler:function(){forArticleView();}   
  			}],
			columns:[[
			    {field:'checkBox',checkbox:true},
				{field:'name',title:'公告名称',width:150,align:'center'},
				{field:'type',title:'公告类型',width:150,align:'center'},
				{field:'opTime',title:'公告时间',width:150,align:'center'}
			]],
			onLoadSuccess:function(){
				//ObjList = $('#ListId').data('datagrid').data;
		}
	});	

		function forArticleAdd(){
			 esourcing.util.goUrl("cmsArticlepersist.jsp");
		};
		function forArticleMerge(){
					ArticleIdList = esourcing.util.getSelections("articleListId","id");
					if(ArticleIdList.length==1){
						esourcing.util.goUrl("editArticlePage.action?id="+ArticleIdList[0]);
					}else if(ArticleIdList.length==0){
						$("#messg_id").html('请选择一条记录');
						return false;
					}else{
						$("#messg_id").html('只能选择一条记录');
						return false;
					}				
		};
		function forArticleDelete(){
					ArticleIdList = esourcing.util.getSelections("articleListId","id");
					var articleIds = ArticleIdList.join();
					rowNum = ArticleIdList.length;
					if(rowNum==0){
						$("#messg_id").html('请选择一条或多条记录');
						return false;
						}
					$.messager.confirm('', '确定删除选中'+rowNum+'记录', function(del){
						if (del){
							$.ajax({
								   type: "POST",
								   url: "delArticlesByIds.action",
								   data: "articleIds="+articleIds,
								   success: function(data){
										if(data.result=='true'){
											esourcing.util.rightMessage("删除提示","删除公告成功");
										}else{
											esourcing.util.rightMessage("删除提示","删除公告失败");
											return false;
										}
										$('#articleListId').datagrid('reload');
								   }
							});
						}
					});				
		};
		function forArticleView(){
					ArticleIdList = esourcing.util.getSelections("articleListId","id");
					if(ArticleIdList.length==1){
						esourcing.util.goUrl("viewArticlePage.action?id="+ArticleIdList[0]);
					}else if(ArticleIdList.length==0){
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
	