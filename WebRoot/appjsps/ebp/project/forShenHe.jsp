<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>审核项目列表</title>
    
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
    	<table id="ebpProjectforShenHe"></table>
	</div>
	<%--zb菜单--%>
    <div id="zbmenu" class="easyui-menu" style="width:120px;">  
    	<div iconCls="icon-tip" id="submitForAudit">提交审核</div>
	</div>
	<%--审核通过菜单--%>
	<div id="passmenu" class="easyui-menu" style="width:120px;">  
    	<div iconCls="icon-tip" id="sendObject">发标</div>
	</div>
	<%--审核未通过菜单--%>
	<div id="nopassmenu" class="easyui-menu" style="width:120px;">  
    	<div iconCls="icon-tip" id="returnToLXProject">重立项</div>
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
		
		$('#zbmenu').menu({   
			onClick:function(item){ 
				 if(item.id=="submitForAudit"){
					submitForAudit();
				}
			}
		});
		$('#passmenu').menu({   
			onClick:function(item){ 
				if(item.id=="sendObject"){
					sendObject(); 
				}
			}
		});
		$('#nopassmenu').menu({   
			onClick:function(item){ 
				if(item.id=="returnToLXProject"){
					returnToLXProject();
				}
			}
		});
	})

	
	$(function(){
		
		$('#ebpProjectforShenHe').datagrid({   
		    url:'getSHEbpProject.action',  
		    title:'审核项目管理>>' ,
		    rownumbers:true,
		    pagination:true,
			fitColumns: true,
			singleSelect: true,
			onLoadSuccess:function(){
				ebpproject = $('#ebpProjectforShenHe').data('datagrid').data;
			},
		    columns:[[
		        {field:'projectName',title:'名称',width:100},   
		        {field:'projectId',title:'项目 编号',width:100},
		        {field:'projectManagerId',title:'项目经理编号',width:100},
		        {field:'createTime',title:'创建时间',width:100},
		        {field:'projectAuditStatusName',title:'审核状态',width:100},
		    ]], 

		    onClickRow: function(rowIndex, rowData){
				$('#ebpProjectforShenHe').datagrid('selectRow', rowIndex);
				currentIndex = rowIndex;
				
				$('#pcmenu').menu('show', {
					left:event.clientX,
					top:event.clientY
				});
			},

			onRowContextMenu: function(e, rowIndex, rowData) { //右键时触发事件
                e.preventDefault(); //阻止浏览器捕获右键事件
                $('#ebpProjectforShenHe').datagrid("clearSelections"); //取消所有选中项
                $('#ebpProjectforShenHe').datagrid("selectRow", rowIndex); //根据索引选中该行
                currentIndex = rowIndex;
                if(rowData.projectAuditStatus=="SHPASS"){
					$('#passmenu').menu('show', {//显示右键菜单
	                    left: e.pageX,//在鼠标点击处显示菜单
	                    top: e.pageY
	                });
                }else if(rowData.projectAuditStatus=="SHNOPASS"){
                	$('#nopassmenu').menu('show', {//显示右键菜单
                        left: e.pageX,//在鼠标点击处显示菜单
                        top: e.pageY
                    });
                }else if(rowData.smallStatus=="ZB"){
					$('#zbmenu').menu('show', {//显示右键菜单
	                    left: e.pageX,//在鼠标点击处显示菜单
	                    top: e.pageY
	                });
                }
            }  
		});  
	});
	
	function dividePackage(){
		var projectId = ebpproject.rows[currentIndex].projectId;
		window.open('turnToDividePackage.action?projectid='+projectId);
	}

	function okDivideObject(){
		var projectId = ebpproject.rows[currentIndex].projectId;
		window.open('getEbpPackagebyProjectId.action?projectid='+projectId);
	}

	function dividePackageTree(){
		var projectId = ebpproject.rows[currentIndex].projectId;
		window.open('turnToDivideObjectTree.action?projectid='+projectId);
	}
	
	//发标操作
	function sendObject(){
		var projectId = ebpproject.rows[currentIndex].projectId;
		if(!confirm('确定要发标吗？')) {
			return false;
		}
		$.ajax({
			type:'POST',
			url: "sendObject.action",
			data: "projectid="+projectId,
			dataType: "text",
			success:function(info){
				var map=eval('('+info+')');//用eval函数将json转化为对象
				if(map.result == 'true'){
					$.messager.alert("操作提示", "操作成功！");
					$('#ebpProjectforShenHe').datagrid('reload'); 
				}
			}
		});
	}
	//提交审核
	function submitForAudit(){
		var projectId = ebpproject.rows[currentIndex].projectId;
		if(!confirm('确定要提交审核吗？')) {
			return false;
		}
		$.ajax({
			type:'POST',
			url: "submitForAudit.action",
			data: "projectid="+projectId,
			dataType: "text",
			success:function(info){
				var map=eval('('+info+')');//用eval函数将json转化为对象
				if(map.result == 'true'){
					$.messager.alert("操作提示", "操作成功！");
					$('#ebpProjectforShenHe').datagrid('reload'); 
				}
				
			}
		});
	}
	//重立项操作
	function returnToLXProject(){
		var projectId = ebpproject.rows[currentIndex].projectId;
		if(!confirm('确定要重立项吗？')) {
			return false;
		}
		$.ajax({
			type:'POST',
			url: "returnToLXProject.action",
			data: "projectid="+projectId,
			dataType: "text",
			success:function(info){
				$.messager.alert("操作提示", "操作成功！");
				$('#ebpProjectforShenHe').datagrid('reload'); 
			}
		});

	}
	</script>
	<!--脚本结束-->
  </body>
</html>
