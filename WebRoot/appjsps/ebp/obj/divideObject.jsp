<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String projectid = request.getAttribute("projectid").toString();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>项目分标</title>
    
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
   		<div id="panel">
   			<form id="divideobjectform" method="post">
   				<table align="left">
   					<tr align="center">
   						<td>请输入分标数：</td>
   						<td><input id="num" name="num" type="text"></td>
   						<td><input id="projectid" name="projectid" value=<%=projectid %>  style="display:none;" type="text"></td>
   						<td><input type="button" id="subform" value="分标"/></td>
   					</tr>
   				</table>
   			</form>
   			<input id="batchdelete" type="button" onclick="dropoff();" value="批量删除"/>
   		</div>
  		<div id="tb" style="height:auto" align="left">
		</div>
  		<div class="link_button_div">
    		<table id="object"></table>
		</div>
		
		 <div id="gr" class="easyui-menu" style="width:120px;">  
    	<div iconCls="icon-tip" id="details">查看详情</div>
    	<div iconCls="icon-tip" id="modify">修改</div> 
    	<div iconCls="icon-tip" id="dropoff">删除</div>
		</div>
    
    
	<script type="text/javascript" src="<%=path %>/resources/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/easyui-1.3.6/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/easyui-1.3.6/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/esourcing.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/esourcing.util.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/jquery.serializeJSON.js"></script>
	<!--js脚本区-->
	<script type="text/javascript">


	$(window).ready(function(){
		
		$('#gr').menu({   
			onClick:function(item){ 
				if(item.id=="details"){
					details(); 
				}else if(item.id=="modify"){
					modify();
				}
				else if(item.id=="dropoff"){
					dropoff();
				}
			}
		});
	});

	var pid=<%=projectid %>;	
	var ebpobject;
	var currentIndex;
	
	$(function(){

		$("#subform").click(
			function(){
				if(confirm("是否确定分标？")){
					$("#divideobjectform").submit();
				}
			}
		);
		$('#divideobjectform').form({
			url : 'divideObjectFromProject.action',
			onSubmit : function(){
			},
			success : function(data){
				if(eval(data)[0].result == 'true'){
					$("#object").datagrid('reload');
				}
			}
		});
		$('#object').datagrid({   
		    url:'getEbpObjectbyProjectId.action?projectid='+pid,  
		    title:'项目分标管理>>' ,
		    rownumbers:true,
		    pagination:true,
			fitColumns: true,
			singleSelect: false,
			onLoadSuccess:function(){
		    	ebpobject = $('#object').data('datagrid').data;
			},
		    columns:[[
				{field:'ck',checkbox:true,width:80},
		        {field:'objectName',title:'名称',width:100},   
		        {field:'projectStatus',title:'大状态',width:100},
		        {field:'smallStatus',title:'小状态',width:100},   
		    ]], 

		    onClickRow: function(rowIndex, rowData){
				$('#object').datagrid('selectRow', rowIndex);
				currentIndex = rowIndex;
				$('#gr').menu('show', {
					left:event.clientX,
					top:event.clientY
				});
			},

			onRowContextMenu: function(e, rowIndex, rowData) { //右键时触发事件
                e.preventDefault(); //阻止浏览器捕获右键事件
                $('#object').datagrid("clearSelections"); //取消所有选中项
                $('#object').datagrid("selectRow", rowIndex); //根据索引选中该行
                currentIndex = rowIndex;
                $('#gr').menu('show', {//显示右键菜单
                    left: e.pageX,//在鼠标点击处显示菜单
                    top: e.pageY
                });
            }  
		});  

		$("#panel").panel({
			width:1080,
			height:150,
			title:"分包操作",
			tools:{
			text: '添加',
            iconCls: 'icon-add',
            handler: function () {
				}
			}
			});
	
	});

	function details(){
		var objectId = ebpobject.rows[currentIndex].id;
		window.open('getEbpObjectbyId.action?objectid='+objectId);
	}

	function modify(){
		var objectId = ebpobject.rows[currentIndex].id;
		window.open('turnToModifyObject.action?objectid='+objectId);
	}
	
	//批量删除操作，以上为可以运行的单个删除
	function dropoff(){
		var rows=$('#object').datagrid('getChecked');
		if(!confirm('确定要删除此条数据吗？')) {
			return false;
		}
		var objectidString="";
		for(var i=0;i<rows.length;i++){
			if(i!=(rows.length-1)){
				objectidString=objectidString+rows[i].id+",";
			}else{
				objectidString=objectidString+rows[i].id;
			}
		}

		//批量删除操作
		$.ajax({
			type:'POST',
			url: "deleteEbpObjectbyId.action",
			data: "objectid="+objectidString,
			dataType: "text",
			success:function(info){
				//alert(info);
				 $.messager.alert("操作提示", "操作成功！");
				$('#object').datagrid('reload'); 
			}
		});
	}
	

	</script>
	<!--脚本结束-->
   
  </body>
</html>
