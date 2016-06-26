<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>待分标项目列表</title>
    
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
   
	  	<div id="tb" style="height:auto" align="left">
		</div>
		<div class="link_button_div">
		    <table id="ebpProjectforObject"></table>
		</div>
    
    <div id="obmenu" class="easyui-menu" style="width:120px;">  
    	<div iconCls="icon-tip" id="divideObject">分标</div>
    	<div iconCls="icon-tip" id="okDivideObject">确认分标</div> 
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
				
				$('#obmenu').menu({   
					onClick:function(item){ 
						if(item.id=="divideObject"){
							divideObject(); 
						}else if(item.id=="okDivideObject"){
							okDivideObject();
						}
					}
				});
			})

	
	$(function(){
		$('#ebpProjectforObject').datagrid({   
		    url:'getEbpProjectbyIsObject.action',  
		    title:'待分标项目管理>>' ,
		    rownumbers:true,
		    pagination:true,
			fitColumns: true,
			singleSelect: true,
			onLoadSuccess:function(){
				ebpproject = $('#ebpProjectforObject').data('datagrid').data;
			},
		    columns:[[
		        {field:'projectName',title:'名称',width:100},   
		        {field:'projectId',title:'项目 编号',width:100},
		        {field:'projectManagerId',title:'项目经理编号',width:100},
		        {field:'createTime',title:'创建时间',width:100},
		    ]], 
		    onClickRow: function(rowIndex, rowData){
				$('#ebpProjectforObject').datagrid('selectRow', rowIndex);
				currentIndex = rowIndex;
				$('#obmenu').menu('show', {
					left:event.clientX,
					top:event.clientY
				});
			},
			onRowContextMenu: function(e, rowIndex, rowData) { //右键时触发事件
                e.preventDefault(); //阻止浏览器捕获右键事件
                $('#ebpProjectforObject').datagrid("clearSelections"); //取消所有选中项
                $('#ebpProjectforObject').datagrid("selectRow", rowIndex); //根据索引选中该行
                currentIndex = rowIndex;
                $('#obmenu').menu('show', {//显示右键菜单
                    left: e.pageX,//在鼠标点击处显示菜单
                    top: e.pageY
                });
            }  
		});  
	});
	function divideObject(){
		var projectId = ebpproject.rows[currentIndex].projectId;
		window.open('turnToDivideObject.action?projectid='+projectId);
	}

	function okDivideObject(){
		var projectId = ebpproject.rows[currentIndex].projectId;
		window.open('getEbpObjectbyProjectId.action?projectid='+projectId);
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
				$('#ebpProjectforObject').datagrid('reload'); 
			}
		});
	}

	function okDivideObject(){
		if(!confirm('确定分标吗？')) {
			return false;
		}
		var projectId = ebpproject.rows[currentIndex].projectId;
		$.ajax({
			type:'POST',
			url: "nextFromObject.action",
			data: "projectid="+projectId,
			dataType: "text",
			success:function(info){
				$('#ebpProjectforObject').datagrid('reload'); 
			}
		});
	}
	</script>
	<!--脚本结束-->
  </body>
</html>
