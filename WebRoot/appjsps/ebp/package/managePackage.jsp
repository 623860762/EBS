<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>分包管理</title>
    
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
    <div id="searchpanel">
       <form id="search">
      	<table id="">
      		<tr>
      			<td>&nbsp;&nbsp;查询条件</td>
      			<td><input type="text"></td>
      			<td><input type="button" value="查询"></td>
      		</tr>
      	</table>
      </form>
      </div>
      <br>
      <br>
      
	  <div id="tools" style="height:auto" align="left"></div>
	  <div class="link_button_div">
	    	<table id="ebpPackage"></table>
	  </div>
    
     <script type="text/javascript" src="<%=path %>/resources/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/easyui-1.3.6/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/easyui-1.3.6/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/esourcing.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/esourcing.util.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/jquery.serializeJSON.js"></script>
	
	<script type="text/javascript">
	$(function(){
		//初始化查询面板
		$("#panel").panel({
			width:400,
			height:150,
			title:"分标管理",
			tools:{
			text: '添加',
            iconCls: 'icon-add',
            handler: function () {
				}
			}
			});

		$('#ebpPackage').datagrid({   
		    url:'queryAllEbpPackageData.action',  
		    title:'分标管理>>' ,
		    rownumbers:true,
		    pagination:true,
			fitColumns: true,
			singleSelect: true,
			onLoadSuccess:function(){
				ebpobject = $('#ebpPackage').data('datagrid').data;
			},
		    columns:[[
		        {field:'packageName',title:'名称',width:100},   
		        {field:'projectId',title:'项目 编号',width:100},
		        {field:'updateTime',title:'更新时间',width:100},
		        {field:'isValid',title:'是否有效',width:100},   
		    ]], 

		    //单击火狐浏览器不起作用
		    onClickRow: function(rowIndex, rowData){
				$('#ebpPackage').datagrid('selectRow', rowIndex);
				currentIndex = rowIndex;
				$('#tools').menu('show', {
					left:event.clientX,
					top:event.clientY
				});
			},

			onRowContextMenu: function(e, rowIndex, rowData) { //右键时触发事件
                e.preventDefault(); //阻止浏览器捕获右键事件
                $('#ebpPackage').datagrid("clearSelections"); //取消所有选中项
                $('#ebpPackage').datagrid("selectRow", rowIndex); //根据索引选中该行
                currentIndex = rowIndex;
                $('#tools').menu('show', {//显示右键菜单
                    left: e.pageX,//在鼠标点击处显示菜单
                    top: e.pageY
                });
            }  
		});  
		//提交form表单
		$('#search').form({
			url : 'dividePackageFromProject.action',
			onSubmit : function(){
			},
			success : function(data){
				if(eval(data)[0].result == 'true'){
					$("#ebpPackage").datagrid('reload');
				}
			}
		})
			

	});
	</script>
	
  </body>
</html>
