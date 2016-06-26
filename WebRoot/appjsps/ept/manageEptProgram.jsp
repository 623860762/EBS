<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String projectid = (String)request.getParameter("projectid");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>抽取方案列表</title>
    
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
    <table id="eptprograminfo"></table>
    
</div>
    
    <div id="eptprogramInfomm" class="easyui-menu" style="width:120px;">  
    	<div iconCls="icon-tip" id="forManageNameList">查看专家名单</div>
    	<div iconCls="icon-tip" id="ExtractionExpert">抽取专家</div> 
<%--    	<div iconCls="icon-tip" id="forDelete">删除</div>--%>
<%--		<div iconCls="icon-tip" id="forProductConnect">关联标的物</div> --%>
<%--		<div iconCls="icon-tip" id="forDistribute">下发</div> --%>
<%--		<div iconCls="icon-tip" id="forVerify">提交审核(工作流)</div> --%>
	</div>
    
    
	<script type="text/javascript" src="<%=path %>/resources/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/easyui-1.3.6/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/easyui-1.3.6/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/esourcing.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/esourcing.util.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/jquery.serializeJSON.js"></script>
	<!--js脚本区-->
	<script type="text/javascript">


		
	var eptprograminfo;
	var currentIndex;
	$(window).ready(function(){
		
		$('#eptprogramInfomm').menu({   
			onClick:function(item){ 
				//alert(item.id); 
				if(item.id=="forManageNameList"){
					forManageNameList(); 
				}else if(item.id=="ExtractionExpert"){
					ExtractionExpert();
				}
				else if(item.id=="forDelete"){
					forDelete();
				}
				//	else if(item.id=="forProductConnect"){
				//	forProductConnect();
				//}else if(item.id=="forVerify"){
				//	forVerify();
				//}
				//else if(item.id=="forDistribute"){
				//	forDistribute();
				//}
			}
		});
	});
	
	
	$(function(){
		$('#eptprograminfo').datagrid({   
		    url:'getProgramByProjectId.action?projectid=<%=projectid%>',  
		    title:'抽取方案列表>>' ,
		    rownumbers:true,
		    pagination:true,
			fitColumns: true,
			singleSelect: true,
			toolbar: '#tb',
			
			
			onLoadSuccess:function(){
				eptprograminfo = $('#eptprograminfo').data('datagrid').data;
			},
		    columns:[[
		        {field:'id',title:'抽取方案id',width:100,hidden:true},   
		        {field:'extractionUnit',title:'抽取单位',width:100},   
		        {field:'produceMethod',title:'抽取方式',width:100},
		        {field:'isExtraction;',title:'是否已抽取',width:100},
		        {field:'totalUserNumber',title:'需求人数',width:100},   
		       // {field:'selectProportion',title:'正备选比例',width:100},   
		        {field:'extractionArea',title:'抽取组织单位',width:100},   
		        {field:'orgAvoid',title:'回避组织单位',width:100},   
		        {field:'expertArea',title:'抽取区域',width:100}  
		    ]], 

		    //单击的时候不起作用
		    onClickRow: function(rowIndex, rowData){
				$('#eptprograminfo').datagrid('selectRow', rowIndex);
				//var row = $('#eptprograminfo').dataGrid('getSelected');
				currentIndex = rowIndex;
				$('#eptprogramInfomm').menu('show', {
					left:event.clientX,
					top:event.clientY
				});
			},

			onRowContextMenu: function(e, rowIndex, rowData) { //右键时触发事件
                //三个参数：e里面的内容很多，真心不明白，rowIndex就是当前点击时所在行的索引，rowData当前行的数据
                e.preventDefault(); //阻止浏览器捕获右键事件
                $('#eptprograminfo').datagrid("clearSelections"); //取消所有选中项
                $('#eptprograminfo').datagrid("selectRow", rowIndex); //根据索引选中该行
                currentIndex = rowIndex;
                $('#eptprogramInfomm').menu('show', {
//显示右键菜单
                    left: e.pageX,//在鼠标点击处显示菜单
                    top: e.pageY
                });
            }  
		});  
		

		
	});
	
	function ExtractionExpert(){
		var programId = eptprograminfo.rows[currentIndex].id;
		var isExtraction = eptprograminfo.rows[currentIndex].isExtraction;
		if(isExtraction == 'Y') {
			$.messager.alert("操作提示", "该方法已经抽取!");
			return false;
		}
		$.ajax({
			type:'POST',
			url: "autoExtractExpert.action",
			data: "programid="+programId,
			dataType: "json",
			success:function(info){
				if(eval(info)[0].result == 'true'){
					$.messager.alert("操作提示", "抽取成功！请点击查看菜单查看");
				}
				else {
					$.messager.alert("操作提示", "操作失败！");
				}
			}
		});
	};

	function forManageNameList(){
		var projectId = <%=projectid%>;
		window.open('appjsps/ept/manageEptNameList.jsp?projectid='+projectId);
	}
	
	function forDelete(){
		var projectId = eptprojectinfo.rows[currentIndex].projectId;
		if(!confirm('确定要删除此条数据吗？')) {
			return false;
		}
		//var projectId = dataListOneselfNoDown.rows[currentIndex].projectId;
		$.ajax({
			type:'POST',
			url: "deleteEbpProjectbyId.action",
			data: "projectid="+projectId,
			dataType: "text",
			success:function(info){
				//alert(info);
				 $.messager.alert("操作提示", "操作成功！");
				$('#eptprojectinfo').datagrid('reload'); 
			}
		});
	}
	
	

	</script>
	<!--脚本结束-->
  </body>
</html>
