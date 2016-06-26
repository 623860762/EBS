<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>立项项目管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/easyui-1.3.6/themes/default/easyui.css"/>
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/easyui-1.3.6/themes/icon.css" />
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/css/common.css" />

  </head>
  
  <body>
  <div id="tb" style="height:auto" align="left">
	</div>
  <div class="link_button_div">
    <table id="ebpProject"></table>
    
</div>
    
    <div id="mm" class="easyui-menu" style="width:120px;">  
    	<div iconCls="icon-tip" id="forDetails">查看</div>
    	<div iconCls="icon-tip" id="forModify">修改</div> 
    	<div iconCls="icon-tip" id="forDelete">删除</div>
		<div iconCls="icon-tip" id="forProductConnect">关联标的物</div> 
		<div iconCls="icon-tip" id="forDistribute">下发</div> 
	</div>
    
    
	<script type="text/javascript" src="<%=path %>/resources/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/easyui-1.3.6/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/easyui-1.3.6/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/esourcing.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/esourcing.util.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/jquery.serializeJSON.js"></script>
	<!--js脚本区-->
	<script type="text/javascript">


		
	var ebpproject;
	var currentIndex;
	$(window).ready(function(){
		
		$('#mm').menu({   
			onClick:function(item){ 
				if(item.id=="forDetails"){
					forDetails(); 
				}else if(item.id=="forModify"){
					forModify();
				}
				else if(item.id=="forDelete"){
					forDelete();
				}
				else if(item.id=="forDistribute"){
					forDistribute();
				}
			}
		});
	});
	
	
	$(function(){
		$('#ebpProject').datagrid({   
		    url:'queryEbpProjectData.action',  
		    title:'项目管理>>' ,
		    rownumbers:true,
		    pagination:true,
			fitColumns: true,
			singleSelect: true,
			toolbar: '#tb',
			
			tools: [{   
	    		   iconCls:'icon-add', 
	    		   text: '添加|', 
	   		   	   handler:function(){
	   		   	window.open('appjsps/ebp/project/addEbpProject.jsp');
	   		   	   }   
	  		    }],
			onLoadSuccess:function(){
				ebpproject = $('#ebpProject').data('datagrid').data;
			},
		    columns:[[
		        {field:'projectName',title:'名称',width:100},   
		        {field:'projectId',title:'项目编号',width:100},
		        {field:'projectManagerId',title:'项目经理编号',width:100},
		        {field:'createTime',title:'创建时间',width:100},   
		    ]], 

		    onClickRow: function(rowIndex, rowData){
				$('#ebpProject').datagrid('selectRow', rowIndex);
				currentIndex = rowIndex;
				$('#mm').menu('show', {
					left:event.clientX,
					top:event.clientY
				});
			},

			onRowContextMenu: function(e, rowIndex, rowData) { //右键时触发事件
                e.preventDefault(); //阻止浏览器捕获右键事件
                $('#ebpProject').datagrid("clearSelections"); //取消所有选中项
                $('#ebpProject').datagrid("selectRow", rowIndex); //根据索引选中该行
                currentIndex = rowIndex;
                $('#mm').menu('show', {
					//显示右键菜单
                    left: e.pageX,//在鼠标点击处显示菜单
                    top: e.pageY
                });
            }  
		});  
		

		
	});
	
	function forModify(){
		var projectId = ebpproject.rows[currentIndex].projectId;
		window.open('getEbpProjectVobyId.action?projectid='+projectId);
	};

	function forDetails(){
		var projectId = ebpproject.rows[currentIndex].projectId;
		window.open('getEbpProjectVoDetailbyId.action?projectid='+projectId);
	}
	
	function forDelete(){
		var projectId = ebpproject.rows[currentIndex].projectId;
		if(!confirm('确定要删除此条数据吗？')) {
			return false;
		}
		$.ajax({
			type:'POST',
			url: "deleteEbpProjectbyId.action",
			data: "projectid="+projectId,
			dataType: "text",
			success:function(info){
				$.messager.alert("操作提示", "操作成功！");
				$('#ebpProject').datagrid('reload'); 
			}
		});
	}

	function forDistribute(){
		
	}

	function forDistribute(){
		if(!confirm('确定要下发此条数据吗？')) {
			return false;
		}
		var projectId = ebpproject.rows[currentIndex].projectId;
		$.ajax({
			type:'POST',
			url: "nextFromProject.action",
			data: "projectid="+projectId,
			dataType: "text",
			success:function(info){
				$('#ebpProject').datagrid('reload'); 
			}
		});
		//window.location.href("ectCNProjectController.cmd?method=changeDown&projectId="+projectId);
	}
	
	

	</script>
	<!--脚本结束-->
  </body>
</html>
