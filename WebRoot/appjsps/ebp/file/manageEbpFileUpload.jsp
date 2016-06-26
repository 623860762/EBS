<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.ceit.ebs.sup.vo.SupSupplierVo"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
SupSupplierVo supSupplierVo = new SupSupplierVo();
supSupplierVo = (SupSupplierVo)request.getAttribute("supSupplierVo");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>招标文件管理</title>
    
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
    <div id="tb" style="height:auto" align="left">   <!-- id:定义的名字  -->
	</div>
    <div class="link_button_div">              <!-- class:采用的css样式 -->
         <table id="fileUpload"></table>    
    </div>
      <div id="mm" class="easyui-menu" style="width:120px;">  
        <div iconCls="icon-tip" id="forBuy">购买招标文件</div>
    	<div iconCls="icon-tip" id="forLoad">下载招标文件</div>    	
    	<div iconCls="icon-tip" id="forUpLoad">上传报价及投标文件</div>
	</div>

	<script type="text/javascript" src="<%=path %>/resources/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/easyui-1.3.6/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/easyui-1.3.6/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/esourcing.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/esourcing.util.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/jquery.serializeJSON.js"></script>

<!-- js脚本区 -->
<script type="text/javascript">
	var fileupload;
	var currentIndex;
	$(window).ready(function(){  
		
		$('#mm').menu({   
			onClick:function(item){ 
				if(item.id=="forBuy"){
					forBuy();
				}else if(item.id=="forLoad"){
					forLoad(); 
				}else if(item.id=="forUpLoad"){
					forUpLoad(); 
				}
			}
		});
	});
	
	
	$(function(){
		//alert();
		$('#fileUpload').datagrid({   
		    url:'queryEbpFileUploadData.action',  
		    title:'招标文件管理>>' ,
		    rownumbers:true,
		    pagination:true,
			fitColumns: true,
			singleSelect: true,
			toolbar: '#tb',
			onLoadSuccess:function(){
				fileupload = $('#fileUpload').data('datagrid').data; 
			},
		    columns:[[
		        {field:'fileName',width:80,title:'文件名称'},
		        {field:'projectId',width:100,title:'项目 ID'},
		        {field:'packageId',width:80,title:'包ID'}
		    ]], 	    
	
		    //单击的时候不起作用
		    onClickRow: function(rowIndex, rowData){
				$('#fileUpload').datagrid('selectRow', rowIndex); //得到数据
				currentIndex = rowIndex;
				$('#mm').menu('show', {
					left:event.clientX,
					top:event.clientY
				});
			},
	
			onRowContextMenu: function(e, rowIndex, rowData) { //右键时触发事件
	            //三个参数：e里面的内容很多，真心不明白，rowIndex就是当前点击时所在行的索引，rowData当前行的数据
	            e.preventDefault(); //阻止浏览器捕获右键事件
	            $('#fileUpload').datagrid("clearSelections"); //取消所有选中项
	            $('#fileUpload').datagrid("selectRow", rowIndex); //根据索引选中该行
	            currentIndex = rowIndex;
	            $('#mm').menu('show', {
	             //显示右键菜单
	                left: e.pageX,//在鼠标点击处显示菜单
	                top: e.pageY
	            });
	        }  
		});  
		
	
		
	});
	function forBuy(){
		var id = fileupload.rows[currentIndex].packageId;
		if(!confirm('确定供应商已付款吗？')) {
			return false;
		}
		$.ajax({
			type:'POST',
			url: "buyFiles.action?supplierId="+<%=supSupplierVo.getId()%>+"&pacId="+id,
			dataType: "text",
			success:function(info){
				 $.messager.alert("操作提示", "文件购买成功！");
			},
			error:function(XMLHttpRequest, textStatus, errorThrown){
				$.messager.alert("操作提示","供应商审核不通过，不能购买文件！");
			}
		});
	}
	
	function forLoad(){
		var pacid = fileupload.rows[currentIndex].packageId;
		var proid = fileupload.rows[currentIndex].projectId;
		$.ajax({
			type:'POST',
			url: "loadFiles.action?supplierId="+<%=supSupplierVo.getId()%>+"&pacId="+pacid+"&proId="+proid,
			dataType: "text",
			success:function(info){
				 $.messager.alert("操作提示", "文件下载成功！");
			},
			error:function(XMLHttpRequest, textStatus, errorThrown){
				$.messager.alert("操作提示","商家尚未付款，不能下载文件！");
			}
		});	
	}
	
	function forUpLoad(){
		var pacid = fileupload.rows[currentIndex].packageId;
		var proid = fileupload.rows[currentIndex].projectId;
		window.open('getPriId.action?supplierId='+<%=supSupplierVo.getId()%>+'&pacId='+pacid+'&proId='+proid);
	}
</script>

  </body>
</html>
