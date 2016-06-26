<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>澄清汇总</title>
    
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
		<div id="ebeFileClrfyTB" style="height: auto" align="left">
		</div>
		<div class="link_button_div">
			<table id="ebeFileClrfy"></table>
		</div>

		<div id="ebeFileClrfyMenu" class="easyui-menu" style="width: 120px;">
			<div iconCls="icon-tip" id="forDetails">
				查看
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
	var ebeFileClrfy;
	var currentIndex;
	$(window).ready(function(){
		
		$('#ebeFileClrfyMenu').menu({   
			onClick:function(item){ 
				//alert(item.id); 
				if(item.id=="forDetails"){
					forDetails(); 
				}else if(item.id=="forMerge"){
					forMerge();
				}
				else if(item.id=="forDelete"){
					forDelete();
				}
		}});
	});
	
	
	$(function(){
		$('#ebeFileClrfy').datagrid({   
		    url:'queryEbeFileClrfyData.action',  
		    title:'澄清汇总>>' ,
		    rownumbers:true,
		    pagination:true,
			fitColumns: true,
			singleSelect: true,
			toolbar: '#ebeFileClrfyTB',
			onLoadSuccess:function(){
				ebeFileClrfy = $('#ebeFileClrfy').data('datagrid').data;
			},
		    columns:[[
		    	  {field:'id',title:'澄清编号',width:100,hidden:false},   
		       	  {field:'packageName',title:'包名称',width:100},    
		          {field:'providerName',title:'供应商名称',width:100},
		          {field:'content',title:'澄清内容',width:100},
		          {field:'createUser',title:'填写人',width:100},  
		          {field:'createDate',title:'填写时间',width:100},    
		    ]], 

		    //单击的时候不起作用
		    onClickRow: function(rowIndex, rowData){
				$('#ebpRepeal').datagrid('selectRow', rowIndex);
				currentIndex = rowIndex;
				$('#ebeFileClrfyMenu').menu('show', {
					left:event.clientX,
					top:event.clientY
				});
			},

			onRowContextMenu: function(e, rowIndex, rowData) { //右键时触发事件
                e.preventDefault(); //阻止浏览器捕获右键事件
                $('#ebeFileClrfy').datagrid("clearSelections"); //取消所有选中项
                $('#ebeFileClrfy').datagrid("selectRow", rowIndex); //根据索引选中该行
                currentIndex = rowIndex;
                $('#ebeFileClrfyMenu').menu('show', {
					//显示右键菜单
                    left: e.pageX,//在鼠标点击处显示菜单
                    top: e.pageY
                });
            }  
		});  	
	});
	function forMerge(){
		var supplierName= encodeURI(encodeURI(ebeFileClrfy.rows[currentIndex].providerName));
		var ebeFileClrfyId = ebeFileClrfy.rows[currentIndex].id;
		window.open('showEbeFileClrfyInModifyPage.action?id='+ebeFileClrfyId+'&mySupplierName='+supplierName);
	};

	function forDetails(){
		var supplierName= encodeURI(encodeURI(ebeFileClrfy.rows[currentIndex].providerName));
		var ebeFileClrfyId = ebeFileClrfy.rows[currentIndex].id;
		window.open('showEbeFileClrfy.action?id='+ebeFileClrfyId+'&mySupplierName='+supplierName);
	}
	
	function forDelete(){
		var ebeFileClrfyId = ebeFileClrfy.rows[currentIndex].id;
		if(!confirm('确定要删除此条数据吗？')) {
			return false;
		}
		$.ajax({
			type:'POST',
			url: "deleteEbeFileClrfybyId.action",
			data: "ebeFileClrfyId ="+ebeFileClrfyId,
			dataType: "text",
			success:function(info){
				$.messager.alert("操作提示", "操作成功！");
				$('#ebeFileClrfy').datagrid('reload'); 
			}
		});
	}
	
	

	</script>
	<!--脚本结束-->
  </body>
</html>
