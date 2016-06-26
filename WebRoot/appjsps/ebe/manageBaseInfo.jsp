<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>基础数据汇总</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/easyui-1.3.6/themes/default/easyui.css"/>
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/easyui-1.3.6/themes/icon.css" />
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/css/common.css" />

  </head>
  
  <body>
		<div id="projectBaseInfoTB" style="height: auto" align="left">
		</div>
		<div class="link_button_div">
			<table id="projectBaseInfo"></table>
		</div>

		<div id="projectBaseInfoMenu" class="easyui-menu" style="width: 120px;">
			<div iconCls="icon-tip" id="forManageGroup">
				设置评审小组
			</div>
			<div iconCls="icon-tip" id="forManageExpert">
				评审专家管理
			</div>
			<div iconCls="icon-tip" id="forManageWeight">
				权重管理
			</div>
		</div>


	<script type="text/javascript" src="<%=path %>/resources/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/easyui-1.3.6/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/easyui-1.3.6/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/esourcing.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/esourcing.util.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/jquery.serializeJSON.js"></script>
	<!--js脚本区-->
	<script type="text/javascript" charset="utf-8">
	var projectBaseInfo;
	var currentIndex;
	$(window).ready(function(){
		$('#projectBaseInfoMenu').menu({   
			onClick:function(item){ 
				if(item.id=="forManageGroup"){
					forManageGroup(); 
				}else if(item.id=="forManageExpert"){
					forManageExpert();
				}else if(item.id=="forManageWeight"){
					forManageWeight();
				}
		}});
	});
	
	
	$(function(){
		$('#projectBaseInfo').datagrid({   
		    url:'queryEbpProjectAllData.action',  
		    title:'基础数据汇总>>' ,
		    rownumbers:true,
		    pagination:true,
			fitColumns: true,
			singleSelect: true,
			toolbar: '#projectBaseInfoTB',
			onLoadSuccess:function(){
				projectBaseInfo = $('#projectBaseInfo').data('datagrid').data;
			},
		    columns:[[
		          {field:'projectId',title:'项目编号',width:100},   //vo里错了，居然是projectId
		       	  {field:'projectName',title:'项目名称',width:100}, 
		    ]], 

		    //单击的时候不起作用
		    onClickRow: function(rowIndex, rowData){
				$('#projectBaseInfo').datagrid('selectRow', rowIndex);
				currentIndex = rowIndex;
				$('#projectBaseInfoMenu').menu('show', {
					left:event.clientX,
					top:event.clientY
				});
			},

			onRowContextMenu: function(e, rowIndex, rowData) { //右键时触发事件
                e.preventDefault(); //阻止浏览器捕获右键事件
                $('#projectBaseInfo').datagrid("clearSelections"); //取消所有选中项
                $('#projectBaseInfo').datagrid("selectRow", rowIndex); //根据索引选中该行
                currentIndex = rowIndex;
                $('#projectBaseInfoMenu').menu('show', {
					//显示右键菜单
                    left: e.pageX,//在鼠标点击处显示菜单
                    top: e.pageY
                });
            }  
		});  	
	});
	
	//设置项目下的评审小组
	function forManageGroup(){
		var projectId = projectBaseInfo.rows[currentIndex].projectId;
		var projectName = projectBaseInfo.rows[currentIndex].projectName;
		window.open('jumpEbeGroup.action?myProjectId='+projectId+'&myProjectName='+projectName);
	}
	
	//设置评审专家
	function forManageExpert(){
		var projectId = projectBaseInfo.rows[currentIndex].projectId;
		var projectName = projectBaseInfo.rows[currentIndex].projectName;
		window.open('jumpEbeExpertGroup.action?myProjectId='+projectId+'&myProjectName='+projectName);
	}
	//设置权重
	function forManageWeight(){
		var projectId = projectBaseInfo.rows[currentIndex].projectId;
		var projectName = projectBaseInfo.rows[currentIndex].projectName;
		window.open('jumpPackageWeight.action?myProjectId='+projectId+'&myProjectName='+projectName);
	}
	</script>
	<!--脚本结束-->
  </body>
</html>
