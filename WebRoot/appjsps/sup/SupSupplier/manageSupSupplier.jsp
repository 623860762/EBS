<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>供应商管理</title>
    
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
         <table id="supSupplier"></table>    
    </div>
      <div id="mm" class="easyui-menu" style="width:120px;">  
        <div iconCls="icon-tip" id="forAudit">审核</div>
    	<div iconCls="icon-tip" id="forDetails">查看</div>
    	<div iconCls="icon-tip" id="forMerge">修改</div> 
    	<div iconCls="icon-tip" id="forDelete">删除</div>
    	<div iconCls="icon-tip" id="forBLFile">投标阶段</div>
	</div>

	<script type="text/javascript" src="<%=path %>/resources/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/easyui-1.3.6/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/easyui-1.3.6/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/esourcing.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/esourcing.util.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/jquery.serializeJSON.js"></script>

<!-- js脚本区 -->
<script type="text/javascript">
	var supsupplier;
	var currentIndex;
	$(window).ready(function(){  
		
		$('#mm').menu({   
			onClick:function(item){ 
				if(item.id=="forAudit"){
					forAudit();
				}else if(item.id=="forDetails"){
					forDetails(); 
				}else if(item.id=="forMerge"){
					forMerge();
				}
				else if(item.id=="forDelete"){
					forDelete();
				}
				else if(item.id=="forBLFile"){
					forBLFile();
				}
				else if(item.id=="forUploadFile"){
					forUploadFile();
				}
			}
		});
	});
	
	
	$(function(){
		//alert();
		$('#supSupplier').datagrid({   
		    url:'querySupplier.action',  
		    title:'供应商管理>>' ,
		    rownumbers:true,
		    pagination:true,
			fitColumns: true,
			singleSelect: true,
			toolbar: '#tb',
			
			tools: [{   
	    		   iconCls:'icon-add', 
	    		   text: '添加|', 
	   		   	   handler:function(){
	   		   		   window.open('appjsps/sup/SupSupplier/addSupSupplier.jsp');
	   		   	   }   
	  		    }],
			onLoadSuccess:function(){
				supsupplier = $('#supSupplier').data('datagrid').data; 
			},
		    columns:[[
		        {field:'supplierName',width:80,title:'供应商名称'},
		        {field:'auditStatus',width:100,title:'审核状态'},
		        {field:'isAgent',width:80,title:'是否是代理商'},
		        {field:'supplierTypeCode',width:80,title:'供应商类别'},
		        {field:'companyType',width:80,title:'机构类型'},
		        {field:'regProvince',width:100,title:'所在省'},
		        {field:'regCity',width:110,title:'所在市'}
		    ]], 	    
	
		    //单击的时候不起作用
		    onClickRow: function(rowIndex, rowData){
				$('#supSupplier').datagrid('selectRow', rowIndex); //得到数据
				currentIndex = rowIndex;
				$('#mm').menu('show', {
					left:event.clientX,
					top:event.clientY
				});
			},
	
			onRowContextMenu: function(e, rowIndex, rowData) { //右键时触发事件
	            //三个参数：e里面的内容很多，真心不明白，rowIndex就是当前点击时所在行的索引，rowData当前行的数据
	            e.preventDefault(); //阻止浏览器捕获右键事件
	            $('#supSupplier').datagrid("clearSelections"); //取消所有选中项
	            $('#supSupplier').datagrid("selectRow", rowIndex); //根据索引选中该行
	            currentIndex = rowIndex;
	            $('#mm').menu('show', {
	             //显示右键菜单
	                left: e.pageX,//在鼠标点击处显示菜单
	                top: e.pageY
	            });
	        }  
		});  
		
	
		
	});
	function forAudit(){
		var id = supsupplier.rows[currentIndex].id;
		window.open('getSupplierVobyId.action?supId='+id);
	}
	
	function forMerge(){
		var id = supsupplier.rows[currentIndex].id;
		window.open('getSupSupplierVobyId.action?supId='+id);
	};
	
	function forDetails(){
		var id = supsupplier.rows[currentIndex].id;
		window.open('getSupSupplierVoDetailbyId.action?supId='+id);
	}
	
	function forDelete(){
		var id = supsupplier.rows[currentIndex].id;
		if(!confirm('确定要删除此条数据吗？')) {
			return false;
		}
		//var projectId = dataListOneselfNoDown.rows[currentIndex].projectId;
		$.ajax({
			type:'POST',
			url: "deleteSupSupplierbyId.action",
			data: "supId="+id,
			dataType: "text",
			success:function(info){
				//alert(info);
				 $.messager.alert("操作提示", "操作成功！");
				$('#supSupplier').datagrid('reload'); 
			}
		});
	}
	function forBLFile(){
		var id = supsupplier.rows[currentIndex].id;
		window.open('getSupVobyId.action?supId='+id);
	}
</script>

  </body>
</html>
