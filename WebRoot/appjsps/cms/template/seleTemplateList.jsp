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
<title>请选择公告模板</title>
	
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/easyui-1.3.6/themes/default/easyui.css"/>
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/easyui-1.3.6/themes/icon.css" />
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/css/common.css" />
</head>
<body>

	<div id="mm" class="easyui-menu" style="width:120px;">  
    	<div iconCls="icon-tip" id="selectTemplate">选择公告模板</div>
	</div>

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
		var data;
		var tempStyleID=$("#span_tempID").val();

		$('#mm').menu({   
			onClick:function(item){ 
				//alert(item.id); 
				if(item.id=="selectTemplate"){
					selectTemplate(); 
				}
			}
		});
		
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
			title: '选择公告模板  <span id=\"messg_id\" style=\"color:red;margin-left:10px;font-weight:normal;\"></span>',
			pagination:true,
			fitColumns: true,
			rownumbers:true,
			toolbar: '#tb',
			singleSelect: true,
			columns:[[
			    {field:'checkBox',checkbox:true},
				{field:'name',title:'模板名称',width:150,align:'center'},
				{field:'templateData',title:'模板内容',width:150,align:'center'},
				{field:'templateType',title:'模板类型',width:150,align:'center',formatter:esourcing.util.TempStyleFormatter},
				{field:'opTime',title:'模板时间',width:150,align:'center'}
			]],
			onLoadSuccess:function(){
			},
			
			onRowContextMenu: function(e, rowIndex, rowData) {
                e.preventDefault(); //阻止浏览器捕获右键事件
                $('#articleTemplateListId').datagrid("clearSelections"); //取消所有选中项
                data=rowData; //根据索引选中该行
                $('#mm').menu('show', {
                    left: e.pageX,//在鼠标点击处显示菜单
                    top: e.pageY
                });
            }
		});	
		
	});
		/* 获取当前模态窗口点击对象所得到的值并返回给父页面*/
		function data(){
			var obj=event.srcElement.parentNode.parentNode;
			var templateDate;	
			templateDate = obj.outerHTML;
			window.returnValue = templateDate; 
			window.close();
		}
		
		
		function selectTemplate(){
			console.log(data.templateData);
			window.returnValue = data.templateData; 
			window.close();
		}
</script>
</body>
</html>
