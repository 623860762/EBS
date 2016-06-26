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
    
    <title>分包操作</title>
    
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
    <div id="panel">
   			<form id="dividepackageform" method="post">
   				<table align="left">
   					<tr align="center">
   						<td>请输入分包数：</td>
   						<td><input id="num" name="num" type="text"></td>
   						<td><input id="projectid" name="projectid" value=<%=projectid %>  style="display:none;" type="text"></td>
   						<td><input type="button" id="subform" value="分包"/></td>
   					</tr>
   				</table>
   			</form>
   			<input id="batchdelete" type="button" onclick="dropoff();" value="批量删除"/>
   		</div>
  		<div id="tb" style="height:auto" align="left">
		</div>
  		<div class="link_button_div">
    		<table id="package"></table>
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
							$("#dividepackageform").submit();
						}
					}
				);
				$('#dividepackageform').form({
					url : 'dividePackageInProject.action',
					onSubmit : function(){
					},
					success : function(data){
						var map=eval('('+data+')');//用eval函数将json转化为对象
						if(map.result == 'true'){
							$("#package").datagrid('reload');
						}
					}
				});
				$('#package').datagrid({ 
				    url:'getEbpPackagebyProjectId.action?projectid='+pid,  
				    title:'项目分包管理>>' ,
				    rownumbers:true,
				    pagination:true,
					fitColumns: true,
					singleSelect: false,
					onLoadSuccess:function(){
				    	ebppackage = $('#package').data('datagrid').data;
					},
				    columns:[[
						{field:'ck',checkbox:true,width:80},
				        {field:'packageName',title:'分包名称',width:100},   
				        {field:'projectId',title:'所属项目编号 ',width:100},
				        {field:'projectStatus',title:'大状态',width:100},
				        {field:'updateTime',title:'更新时间',width:100},   
				    ]], 

				    onClickRow: function(rowIndex, rowData){
						$('#package').datagrid('selectRow', rowIndex);
						currentIndex = rowIndex;
						$('#gr').menu('show', {
							left:event.clientX,
							top:event.clientY
						});
					},

					onRowContextMenu: function(e, rowIndex, rowData) { //右键时触发事件
		                e.preventDefault(); //阻止浏览器捕获右键事件
		                $('#package').datagrid("clearSelections"); //取消所有选中项
		                $('#package').datagrid("selectRow", rowIndex); //根据索引选中该行
		                currentIndex = rowIndex;
		                $('#gr').menu('show', {//显示右键菜单
		                    left: e.pageX,//在鼠标点击处显示菜单
		                    top: e.pageY
		                });
		            }  
				});  

				$("#panel").panel({
					width:1050,
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
				var packageId = ebppackage.rows[currentIndex].id;
				window.open('getPackagebyId.action?packageid='+packageId);
			}
	
			function modify(){
				var packageId = ebppackage.rows[currentIndex].id;
				window.open('turnToModifyPackage.action?packageid='+packageId);
			}
			
			//删除操作，包括单个删除和批量删除操作，以上为可以运行的单个删除
			function dropoff(){
				var rows=$('#package').datagrid('getChecked');
				if(!confirm('确定要删除此条数据吗？')) {
					return false;
				}
				var packageidString="";
				for(var i=0;i<rows.length;i++){
					if(i!=(rows.length-1)){
						packageidString=packageidString+rows[i].id+",";
					}else{
						packageidString=packageidString+rows[i].id;
					}
				}
	
				//批量删除操作
				$.ajax({
					type:'POST',
					url: "deletePackagebyId.action",
					data: "packageid="+packageidString,
					dataType: "text",
					success:function(info){
						//alert(info);
						 $.messager.alert("操作提示", "操作成功！");
						$('#package').datagrid('reload'); 
					}
				});
			}
	</script>
  </body>
</html>
