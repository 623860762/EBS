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
<title>公告模板</title>
	
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/easyui-1.3.6/themes/default/easyui.css"/>
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/easyui-1.3.6/themes/icon.css" />
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/css/common.css" />
</head>
<body>
	<div>
	<input id="span_tempID" type="hidden" value="0"/>
	<span><select id="seleTempId" class="easyui-combobox" data-options="panelHeight:'auto'" onChange=changeTempStyle(this.value)>
	<option value="0">公开招标</option>
	<option value="1">中标公示</option>
	<option value="2">澄清公告</option>
	<option value="3">中标通知书</option>
	</select></span>
	<table id="articleTemplateListId"/></table>	
</div>
	<script type="text/javascript" src="<%=path %>/resources/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/easyui-1.3.6/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/easyui-1.3.6/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/esourcing.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/esourcing.util.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/jquery.serializeJSON.js"></script>

<script type="text/javascript">
//全局变量
		var tempStyleID=$("#span_tempID").val();
		
		$(function(){
		$('#seleTempId').combobox('setValue', tempStyleID);
		$('#seleTempId').combobox({   
    		onChange : function(n,o){
				tempStyleID=n;
				$('#articleTemplateListId').datagrid({url:'getArticleTemplateList.action',    
					queryParams:{templateType:n}
				});
			} 
		}); 
		
		var ArticleTemplateIdList;
		$('#articleTemplateListId').datagrid({
			url: 'getArticleTemplateList.action?templateType='+tempStyleID,
			title: '模板维护  <span id=\"messg_id\" style=\"color:red;margin-left:10px;font-weight:normal;\"></span>',
			pagination:true,
			fitColumns: true,
			rownumbers:true,
			toolbar: '#tb',
			singleSelect: false,
			tools: [{   
    		   iconCls:'icon-add', 
   		   	   handler:function(){forArticleTemplateAdd();}   
  		    },
  		    {   
    		   iconCls:'icon-remove', 
   		   	   handler:function(){forArticleTemplateDelete();}   
  		    },
  		    {   
    		   iconCls:'icon-edit', 
   		   	   handler:function(){forArticleTemplateMerge();}   
  		    },
  		    {   
               iconCls:'icon-search',   
               handler:function(){forArticleTemplateView();}   
  			}],
			columns:[[
			    {field:'checkBox',checkbox:true},
				{field:'name',title:'模板名称',width:150,align:'center'},
				{field:'templateType',title:'模板类型',width:150,align:'center',formatter:esourcing.util.TempStyleFormatter},
				{field:'opTime',title:'模板时间',width:150,align:'center'}
			]],
			onLoadSuccess:function(){
				//ObjList = $('#ListId').data('datagrid').data;
		}
	});	

		function forArticleTemplateAdd(){
			 esourcing.util.goUrl("cmsArticleTemplatepersist.jsp?templateType="+tempStyleID);
		};
		function forArticleTemplateMerge(){
					ArticleTemplateIdList = esourcing.util.getSelections("articleTemplateListId","id");
					if(ArticleTemplateIdList.length==1){
						esourcing.util.goUrl("editArticleTemplatePage.action?id="+ArticleTemplateIdList[0]);
					}else if(ArticleTemplateIdList.length==0){
						$("#messg_id").html('请选择一条记录');
						return false;
					}else{
						$("#messg_id").html('只能选择一条记录');
						return false;
					}				
		};
		function forArticleTemplateDelete(){
					ArticleTemplateIdList = esourcing.util.getSelections("articleTemplateListId","id");
					var articleTemplateIds = ArticleTemplateIdList.join();
					rowNum = ArticleTemplateIdList.length;
					if(rowNum==0){
						$("#messg_id").html('请选择一条或多条记录');
						return false;
						}
					$.messager.confirm('', '确定删除选中'+rowNum+'记录', function(del){
						if (del){
							$.ajax({
								   type: "POST",
								   url: "delArticleTemplatesByIds.action",
								   data: "cmsArticleTemplateIds="+articleTemplateIds,
								   success: function(data){
										if(data.result=='true'){
											esourcing.util.rightMessage("删除提示","删除模板成功");
										}else{
											esourcing.util.rightMessage("删除提示","删除模板失败");
											return false;
										}
										$('#articleTemplateListId').datagrid('reload');
								   }
							});
						}
					});				
		};
		function forArticleTemplateView(){
					ArticleTemplateIdList = esourcing.util.getSelections("articleTemplateListId","id");
					if(ArticleTemplateIdList.length==1){
						esourcing.util.goUrl("viewArticleTemplatePage.action?id="+ArticleTemplateIdList[0]);
					}else if(ArticleTemplateIdList.length==0){
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
