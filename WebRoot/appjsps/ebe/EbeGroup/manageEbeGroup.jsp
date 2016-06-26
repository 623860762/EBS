<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String projectName=(String)request.getAttribute("myProjectName");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>项目<%=projectName%>下的评审小组</title>
    
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
		<div id="ebeGroupTB" style="height: auto" align="left">
		</div>
		<div class="link_button_div">
			<table id="ebeGroup"></table>
		</div>

		<div id="ebeGroupMenu" class="easyui-menu" style="width: 150px;">
			<div iconCls="icon-tip" id="forSetHeader">
				设置组负责人
			</div>
			<div iconCls="icon-tip" id="forshowPackageInGroup">
				查看组下关联的包
			</div>
			<div iconCls="icon-tip" id="forMerge">
				修改
			</div>
			<div iconCls="icon-tip" id="forDelete">
				删除
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
	var ebeGroup;
	var currentIndex;
	$(window).ready(function(){
		
		$('#ebeGroupMenu').menu({   
			onClick:function(item){ 
				if(item.id=="forMerge"){
					forMerge();
				}
				else if(item.id=="forDelete"){
					forDelete();
				}else if(item.id=="forshowPackageInGroup"){
					forshowPackageInGroup();
				}
		}});
	});
	
	
	$(function(){
		$('#ebeGroup').datagrid({   
		    url:'queryGroupInProject.action',  
		    title:'项目 <%=projectName%> 下的评审小组>>' ,
		    rownumbers:true,
		    pagination:true,
			fitColumns: true,
			singleSelect: true,
			toolbar: '#ebeGroupTB',
			tools: [{   
	    		   iconCls:'icon-add', 
	    		   text: '添加|', 
	   		   	   handler:function(){
				   window.open('appjsps/ebe/EbeGroup/addEbeGroup.jsp');
	   		   	   }   
	  		    }],
			onLoadSuccess:function(){
				ebeGroup = $('#ebeGroup').data('datagrid').data;
			},
		    columns:[[
		          {field:'id',title:'小组编号',width:100,hidden:false},   
		       	  {field:'groupName',title:'小组名称',width:100},    
		          {field:'groupType',title:'小组类型',width:100},
		          {field:'groupPrincipalId',title:'组负责人账号',width:100},
		          {field:'groupPrincipalName',title:'组负责人名称',width:100}   
		    ]], 
			//TODO 小组类型要经过数据字典映射？？
		    //单击的时候不起作用
		    onClickRow: function(rowIndex, rowData){
				$('#ebeGroup').datagrid('selectRow', rowIndex);
				currentIndex = rowIndex;
				$('#ebeGroupMenu').menu('show', {
					left:event.clientX,
					top:event.clientY
				});
			},

			onRowContextMenu: function(e, rowIndex, rowData) { //右键时触发事件
                e.preventDefault(); //阻止浏览器捕获右键事件
                $('#ebeGroup').datagrid("clearSelections"); //取消所有选中项
                $('#ebeGroup').datagrid("selectRow", rowIndex); //根据索引选中该行
                currentIndex = rowIndex;
                $('#ebeGroupMenu').menu('show', {
					//显示右键菜单
                    left: e.pageX,//在鼠标点击处显示菜单
                    top: e.pageY
                });
            }  
		});  	
	});
	function forMerge(){
		var groupId = ebeGroup.rows[currentIndex].id;
		window.open('showEbeGroupInModifyPage.action?id='+groupId);
	};

	function forDelete(){
		var groupId = ebeGroup.rows[currentIndex].id;
		if(!confirm('确定要删除此条数据吗？')) {
			return false;
		}
		$.ajax({
			type:'POST',
			url: "deleteEbeGroupbyId.action",
			data: "groupId ="+groupId,
			dataType: "text",
			success:function(info){
				$.messager.alert("操作提示", "操作成功！");
				$('#ebeGroup').datagrid('reload'); 
			}
		});
	}
	//查看组下关联的包
	function forshowPackageInGroup(){
		var groupId = ebeGroup.rows[currentIndex].id;
		var type = ebeGroup.rows[currentIndex].groupType;
		window.open('jumpEbeGroupPackage?groupId='+groupId+"&type="+type);
	}
	
	//设置组长
	function forSetHeader(){
	}

	</script>
	<!--脚本结束-->
  </body>
</html>
