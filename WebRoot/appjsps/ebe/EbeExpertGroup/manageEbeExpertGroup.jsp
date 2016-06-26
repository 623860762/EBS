<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String projectName=(String)request.getAttribute("myProjectName");
String projectId=(String)request.getAttribute("myProjectId");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>项目 <%=projectName%> 下的专家-小组 管理</title>
    
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

	<script type="text/javascript">
		var ebeExpertGroup;
	var currentIndex;
	var treeNode =0;
	$(function(){
		  $("#groupTree").tree({ 
		  	animate : true,  
		    url : "getGroupTree.action?myProjectId="+<%=projectId%>,
		    //展开事件
		    onBeforeExpand:function(node,param){ 
               $("#groupTree").tree('options').url = "getGroupTree.action?groupId=" + node.id;
            },
            //双击事件
            onDblClick : function(node){ 
            	if (node.state == 'closed'){
                 	$(this).tree('expand', node.target);  
                }else if (node.state == 'open'){  
                 	$(this).tree('collapse', node.target);  
                }
            },
            onSelect : function(node){
            	treeNode = node.id;
            	$('#ebeExpertGroup').datagrid('reload',{myGroupId : treeNode});
            }
		  });
	});
	
	$(window).ready(function(){
		
		$('#ebeExpertGroupMenu').menu({   
			onClick:function(item){ 
				if(item.id=="forSetHeader"){
					forSetHeader();
				}
				else if(item.id=="forDelete"){
					forDelete();
				}
		}});
	});
	$(function(){
		$('#ebeExpertGroup').datagrid({   
		   	url:'showExpertInGroup.action',  
		    title:'小组下的专家>>' ,
		    rownumbers:true,
		    pagination:true,
			fitColumns: true,
			singleSelect: true,
			toolbar: '#ebeExpertGroupTB',
			tools: [{   
					//text:"添加",
	    		   iconCls:'icon-add', 
	    		   text: '添加|', 
	   		   	   handler:function(){
				   window.open('appjsps/ebe/EbeExpertGroup/addEbeExpertGroup.jsp');
	   		   	   }   
  		    }], 
			onLoadSuccess:function(){
				ebeExpertGroup = $('#ebeExpertGroup').data('datagrid').data;
				treeNode =0;
			},
		    columns:[[
		        //{field:'rowIndex',title:'编号',width:100}, 
		          {field:'id',title:'主键',width:100,hidden:false},   
		       	  {field:'expertName',title:'姓名',width:100},    
		          {field:'expertAccount',title:'账号',width:100},
		       //   {field:'expertRate',title:'等级',width:100},
		          {field:'isHeader',title:'是否是组长',width:100}   
		    ]], 

		    //单击的时候不起作用
		    onClickRow: function(rowIndex, rowData){
				$('#ebeExpertGroup').datagrid('selectRow', rowIndex);
				//var row = $('#ebpProject').dataGrid('getSelected');
				currentIndex = rowIndex;
				$('#ebeExpertGroupMenu').menu('show', {
					left:event.clientX,
					top:event.clientY
				});
			},

			onRowContextMenu: function(e, rowIndex, rowData) { //右键时触发事件
                e.preventDefault(); //阻止浏览器捕获右键事件
                $('#ebeExpertGroup').datagrid("clearSelections"); //取消所有选中项
                $('#ebeExpertGroup').datagrid("selectRow", rowIndex); //根据索引选中该行
                currentIndex = rowIndex;
                $('#ebeExpertGroupMenu').menu('show', {
					//显示右键菜单
                    left: e.pageX,//在鼠标点击处显示菜单
                    top: e.pageY
                });
            }  
		});  	
	});
	
	function forSetHeader(){
	var expertGroupId = ebeExpertGroup.rows[currentIndex].id;
			if(!confirm('确定修改此条数据吗？')) {
				return false;
			}
		$.ajax({
				type:'POST',
				url: "setHeader.action",
				data: "expertGroupId ="+expertGroupId,
				dataType: "text",
				success:function(info){
					$.messager.alert("操作提示", "操作成功！");
					$('#ebeExpertGroup').datagrid('reload'); 
				}
			});
	}
	
	function forDelete(){
		var expertGroupId = ebeExpertGroup.rows[currentIndex].id;
			if(!confirm('确定要删除此条数据吗？')) {
				return false;
			}
			$.ajax({
				type:'POST',
				url: "deleteEbeExpertGroupbyId.action",
				data: "expertGroupId ="+expertGroupId,
				dataType: "text",
				success:function(info){
					$.messager.alert("操作提示", "操作成功！");
					$('#ebeExpertGroup').datagrid('reload'); 
				}
			});
	}
  	</script>
	</head>
  
  <body>
  
  		<div id="ebeExpertGroupMenu" class="easyui-menu" style="width: 120px;">
			<div iconCls="icon-tip" id="forSetHeader">
				设置/取消组长
			</div>
			<div iconCls="icon-tip" id="forDelete">
				删除
			</div>
		</div>
		
    <div class="easyui-panel" title="" style="width:100%;height:100%;" fit="true">
		<div class="easyui-layout" data-options="fit:true">
			<div data-options="region:'west',split:true" style="width:200px;padding:10px" >
				<ul id="groupTree"></ul>
			</div>
			<div data-options="region:'center'" >
				<table id="ebeExpertGroup"></table>
			</div>
		</div>
	</div>
  </body>
</html>
