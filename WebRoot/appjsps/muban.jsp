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
<title>挡土墙评估历史列表</title>
<!--css引入区域	-->
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/easyui-1.3.6/themes/default/easyui.css"/>
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/easyui-1.3.6/themes/icon.css" />
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/css/common.css" />
<!--end	-->
</head>
<body>
<!--html标签引入区域	-->
	<div align="center">
	<div class="link_button_div">
	<table id="ListId"/></table>
	<div id="tb" style="height:auto">
		<a id="viewStatus" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:'true'">查看评估进度</a>
		<a id="viewOverScore" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:'true'">查看总体评估得分</a>
		<a id="viewDetailScore" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true">查看细部评估得分</a>
		<a id="messg_id" style="color:red;float:right;margin-right:16px;margin-top:3px;"></a>
	</div>
	</div>
</div>
<!--end	-->

<!--js引入区域	-->
	<script type="text/javascript" src="<%=path %>/resources/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/easyui-1.3.6/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/easyui-1.3.6/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/esourcing.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/esourcing.util.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/jquery.serializeJSON.js"></script>
<!--end	-->


<script type="text/javascript">
<!--js书写区域	-->
	$(function(){
		
		var ObjList;
		var currentIndex;
		var rowNum;
		var pareMoDiaObj = new Object();
		pareMoDiaObj.isModalDialog = "yes";
		$('#ListId').datagrid({
			url: 'assWallController.do?method=forListContent',
			title: '评估挡土墙列表',
			pagination:true,
			width: 780,
			height: 352,
			fitColumns: true,
			rownumbers:true,
			toolbar: '#tb',
			singleSelect: false,
			tools: [{   
    		   iconCls:'icon-add', 
   		   	   handler:function(){forAdd();}   
  		    },
  		    {   
    		   iconCls:'icon-remove', 
   		   	   handler:function(){forDelete();}   
  		    },
  		    {   
    		   iconCls:'icon-edit', 
   		   	   handler:function(){forMerge();}   
  		    },
  		    {   
               iconCls:'icon-search',   
               handler:function(){forView();}   
  			}],
			columns:[[
			    {field:'checkBox',checkbox:true},
				{field:'wallName',title:'挡土墙名称',width:150,align:'center'},
				{field:'wallLocation',title:'所在地区',width:150,align:'center'},
				{field:'wallOwer',title:'所属铁路局',width:150,align:'center'},
				{field:'assWallStatu',title:'当前评估状态',width:150,align:'center',formatter:esourcing.util.wallStatu},
				{field:'opTime',title:'创建时间',width:60,align:'center',formatter:esourcing.util.timeFormatter}
			]],
			onLoadSuccess:function(){
				//ObjList = $('#ListId').data('datagrid').data;
		}
	});
		
		function forView(){
					ObjList = esourcing.util.getSelections("ListId","wallId");
					rowNum = ObjList.length;
					if(ObjList.length==1){
						var chidDiaVal = window.showModalDialog('assWallController.do?method=forWall&wallId='+ObjList[0],pareMoDiaObj,'dialogWidth:750px;dialogHeight=570px;center=yes;border=thick;status=no;help=no;scrollbars=no');
					}else if(ObjList.length==0){
						$("#messg_id").html('请选择一条记录');
						return false;
					}else{
						$("#messg_id").html('只能选择一条记录');
						return false;
					}
		};
		
		<!--js函数定义区域	-->
			function(){};
			function(){};
		<!--end	-->
		
	});
<!--end	-->
</script>
</body>
</html>
	