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
    
    <title>专家名单信息</title>
    
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
    <table id="eptnamelist"></table>
    
</div>
    
    <div id="eptnamelistmm" class="easyui-menu" style="width:120px;">  
    	<div iconCls="icon-tip" id="forDetails">查看</div>
<%--    	<div iconCls="icon-tip" id="forMerge">修改</div> --%>
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


		
	var eptnamelist;
	var currentIndex;
	$(window).ready(function(){
		
		$('#eptnamelistmm').menu({   
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
		$('#eptnamelist').datagrid({   
		    url:'getNameListByProjectId.action?projectid=<%=projectid%>',  
		    title:'专家名单信息>>' ,
		    rownumbers:true,
		    pagination:true,
			fitColumns: true,
			singleSelect: true,
			toolbar: '#tb',
			
			
			onLoadSuccess:function(){
				eptnamelist = $('#eptnamelist').data('datagrid').data;
			},
		    columns:[[
		        {field:'id',title:'专家名单id',width:100,hidden:true},   
		        {field:'idNumber',title:'证件号码',width:100},   
		        {field:'expertName',title:'姓名',width:100},
		        {field:'genderCode',title:'性别',width:100},   
		        {field:'expertNationlity',title:'民族',width:100},   
		        {field:'politicalStatus',title:'政治面貌',width:100},   
		        {field:'communicationCity',title:'居住地',width:100},   
		        {field:'specialtyId',title:'专业',width:100},   
		        {field:'workUnits',title:'工作单位',width:100},   
		        {field:'workPhone',title:'办公电话',width:100}   
		    ]], 

		    //单击的时候不起作用
		    onClickRow: function(rowIndex, rowData){
				$('#eptnamelist').datagrid('selectRow', rowIndex);
				//var row = $('#eptnamelist').dataGrid('getSelected');
				currentIndex = rowIndex;
				$('#eptnamelistmm').menu('show', {
					left:event.clientX,
					top:event.clientY
				});
			},

			onRowContextMenu: function(e, rowIndex, rowData) { //右键时触发事件
                //三个参数：e里面的内容很多，真心不明白，rowIndex就是当前点击时所在行的索引，rowData当前行的数据
                e.preventDefault(); //阻止浏览器捕获右键事件
                $('#eptnamelist').datagrid("clearSelections"); //取消所有选中项
                $('#eptnamelist').datagrid("selectRow", rowIndex); //根据索引选中该行
                currentIndex = rowIndex;
                $('#eptnamelistmm').menu('show', {
//显示右键菜单
                    left: e.pageX,//在鼠标点击处显示菜单
                    top: e.pageY
                });
            }  
		});  
		

		
	});
	
	function forMerge(){
		//alert("adb");
		var projectId = eptnamelist.rows[currentIndex].projectId;
		//var projectId = 2;
		//alert(projectId);
		window.open('getEbpProjectVobyId.action?projectid='+projectId);
		//goto("getEbpProjectVobyId.action?projectid="+projectId);
	};

	function forDetails(){
		var projectId = eptprojectinfo.rows[currentIndex].projectId;
		window.open('getEbpProjectVoDetailbyId.action?projectid='+projectId);
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
