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
<title>分类说明</title>
	
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/easyui-1.3.6/themes/default/easyui.css"/>
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/easyui-1.3.6/themes/icon.css" />
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/css/common.css" />
</head>
<body>
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
	<script type="text/javascript" src="<%=path %>/resources/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/easyui-1.3.6/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/easyui-1.3.6/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/esourcing.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/esourcing.util.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/jquery.serializeJSON.js"></script>

<script type="text/javascript">
	$(function(){
		
		var ObjList;
		var currentIndex;
		var rowNum;
		var pareMoDiaObj = new Object();
		pareMoDiaObj.isModalDialog = "yes";
		$('#ListId').datagrid({
			url: 'getJsonList.action',
			title: '分类维护列表',
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
				{field:'name',title:'分类名称',width:150,align:'center'},
				{field:'remark',title:'分类说明',width:150,align:'center'},
				{field:'aliasName',title:'分类别名',width:150,align:'center'}
			]],
			onLoadSuccess:function(){
				//ObjList = $('#ListId').data('datagrid').data;
		}
	});

		function forAdd(){
					var chidDiaVal = window.showModalDialog('assWallController.do?method=forWallPersist',pareMoDiaObj,'dialogWidth:750px;dialogHeight=570px;center=yes;border=thick;status=no;help=no;scrollbars=no');
					if(chidDiaVal=="2"){
						esourcing.util.rightMessage("新增提示","新增挡土墙信息成功");
						$('#ListId').datagrid('reload');
					}else if(typeof(chidDiaVal)=='undefined'){
							return false;
					}else{
						esourcing.util.rightMessage("新增提示","新增挡土墙信息失败");
						return false;
					}	
		};
		function forMerge(){
					ObjList = esourcing.util.getSelections("ListId","wallId");
					rowNum = ObjList.length;
					if(ObjList.length==1){
						var chidDiaVal = window.showModalDialog('assWallController.do?method=forWallMerge&wallId='+ObjList[0],pareMoDiaObj,'dialogWidth:750px;dialogHeight=570px;center=yes;border=thick;status=no;help=no;scrollbars=no');
						if(chidDiaVal=="2"){
							esourcing.util.rightMessage("修改提示","修改挡土墙信息成功");	
							$('#ListId').datagrid('reload');
						}else if(typeof(chidDiaVal)=='undefined'){
							return false;
						}else{
							esourcing.util.rightMessage("修改提示","修改挡土墙信息失败");
							return false;
						}
					}else if(ObjList.length==0){
						$("#messg_id").html('请选择一条记录');
						return false;
					}else{
						$("#messg_id").html('只能选择一条记录');
						return false;
					}				
		};
		function forDelete(){
					ObjList = esourcing.util.getSelections("ListId","wallId");
					var objIds = ObjList.join();
					rowNum = ObjList.length;
					if(rowNum==0){
						$("#messg_id").html('请选择一条或多条记录');
						return false;
						}
					$.messager.confirm('', '确定删除选中'+rowNum+'记录', function(del){
						if (del){
							$.ajax({
								   type: "POST",
								   url: "assWallController.do?method=wallDelete",
								   data: "objIds="+objIds,
								   success: function(data){
											if(data=='2'){
												esourcing.util.rightMessage("删除提示","删除挡土墙信息成功");
											}else{
												esourcing.util.rightMessage("删除提示","删除挡土墙信息失败");
											}
										$('#ListId').datagrid('reload');
								   }
							});
						}
					});				
		};
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
		
		$("#expScore").click(
			function(){
					ObjList = esourcing.util.getSelections("ListId","wallId");
					rowNum = ObjList.length;
					if(ObjList.length==1){
						esourcing.util.goUrl('expertScoreController.do?method=forExpScoreList&wallId='+ObjList[0]);
					}else if(ObjList.length==0){
						$("#messg_id").html('请选择一条记录');
						return false;
					}else{
						$("#messg_id").html('只能选择一条记录');
						return false;
					}				
			});
		$("#viewStatus").click(
			function(){
					ObjList = esourcing.util.getSelections("ListId","wallId");
					rowNum = ObjList.length;
					if(ObjList.length==1){
						esourcing.util.goUrl('assWallController.do?method=forWallStatus&wallId='+ObjList[0]);
					}else if(ObjList.length==0){
						$("#messg_id").html('请选择一条记录');
						return false;
					}else{
						$("#messg_id").html('只能选择一条记录');
						return false;
					}				
			});
		
		$("#viewOverScore").click(function(){
					ObjList = esourcing.util.getSelections("ListId","wallId");
					var row = $('#ListId').datagrid('getSelected');
					rowNum = ObjList.length;
					if(ObjList.length==1){
						if(row.assWallStatu>2){
							esourcing.util.goUrl('assWallController.do?method=forOverScore&wallId='+ObjList[0]);
						}else{
							alert("总体评估尚未完成，请查看评估进度！");
							return false;
						}
					}else if(ObjList.length==0){
						$("#messg_id").html('请选择一条记录');
						return false;
					}else{
						$("#messg_id").html('只能选择一条记录');
						return false;
					}			
		});
		$("#viewDetailScore").click(function(){
					ObjList = esourcing.util.getSelections("ListId","wallId");
					rowNum = ObjList.length;
					var row = $('#ListId').datagrid('getSelected');
					if(ObjList.length==1){
						if(row.assWallStatu>4){
							esourcing.util.goUrl('assWallController.do?method=forDetailScore&wallId='+ObjList[0]);
						}else{
							alert("详细评估尚未完成，请查看评估进度！");
							return false;
						}
					}else if(ObjList.length==0){
						$("#messg_id").html('请选择一条记录');
						return false;
					}else{
						$("#messg_id").html('只能选择一条记录');
						return false;
					}			
		});
		
	});
</script>
</body>
</html>
	