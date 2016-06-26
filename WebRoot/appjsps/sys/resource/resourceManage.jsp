<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.ceit.common.util.StaticSource"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
  	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>资源管理页面</title>
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/easyui-1.3.6/themes/default/easyui.css"/>
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/easyui-1.3.6/themes/icon.css" />
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/css/default.css" />
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/css/common.css" />
	
	</head>
    <body class="easyui-layout" style="overflow-y: hidden"  scroll="no">
    	<div id="treeTabsRootModule" class="easyui-menu" style="width:120px;">  
		    <div iconCls="icon-tip" id="addModule">增加模块</div>
		</div> 
    	<div id="treeTabsModule" class="easyui-menu" style="width:120px;">  
		    <div iconCls="icon-tip" id="addModule">增加模块</div>
		    <div iconCls="icon-tip" id="editModule">修改模块</div> 
		    <div iconCls="icon-tip" id="deleteModule">删除模块</div> 
		    <div iconCls="icon-tip" id="upModule">上移模块</div> 
		    <div iconCls="icon-tip" id="downModule">下移模块</div>   
		</div>  
		<div id="treeTabsModuleFunction" class="easyui-menu" style="width:120px;">  
		    <div iconCls="icon-tip" id="addFunction">增加功能</div>
		    <div iconCls="icon-tip" id="editModule">修改模块</div> 
		    <div iconCls="icon-tip" id="deleteModule">删除模块</div> 
		    <div iconCls="icon-tip" id="upModule">上移模块</div> 
		    <div iconCls="icon-tip" id="downModule">下移模块</div>   
		</div>
		<div id="treeTabsFunctionResource" class="easyui-menu" style="width:120px;">  
		    <div iconCls="icon-tip" id="addResource">增加资源</div>
		    <div iconCls="icon-tip" id="editFunction">修改功能</div>
		    <div iconCls="icon-tip" id="deleteFunction">删除功能</div> 
		    <div iconCls="icon-tip" id="upFunction">上移功能</div> 
		    <div iconCls="icon-tip" id="downFunction">下移功能</div>   
		</div>
		<div id="treeTabsResource" class="easyui-menu" style="width:120px;">  
		    <div iconCls="icon-tip" id="editResource">修改资源</div>
		    <div iconCls="icon-tip" id="deleteResource">删除资源</div>  
		    <div iconCls="icon-tip" id="upResource">上移资源</div>
		    <div iconCls="icon-tip" id="downResource">下移资源</div>
		</div>  
    	<div region="west" hide="true" split="true" style="width: 300px;" id="west">
    		<ul id="resourceTree"></ul>
    	</div>
    	
    	<div region="center">
    		<iframe scrolling="auto" id="resourceIFrame" name="resourceIFrame" frameborder="0"  style="width:100%;height:100%;"></iframe>
    	</div>
	
	<script type="text/javascript" src="<%=path %>/resources/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/easyui-1.3.6/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/easyui-1.3.6/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/esourcing.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/esourcing.util.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/jquery.serializeJSON.js"></script>
	<script type="text/javascript">
		var treeNode;
		$(function(){
		  var id = 0;
		  $('#treeTabsRootModule').menu({   
			onClick:function(item){  
				if(item.id=="addModule"){
					addModule(); 
				}
			}
		  });
		  $('#treeTabsModule').menu({   
			onClick:function(item){  
				if(item.id=="addModule"){
					addModule();
				}else if(item.id=="editModule"){
					editModule();
				}else if(item.id=="deleteModule"){
					deleteModule();
				}else if(item.id=="upModule"){
					upModule();
				}else if(item.id=="downModule"){
					downModule();
				}
			}
		  });
		  $('#treeTabsModuleFunction').menu({   
			onClick:function(item){  
				if(item.id=="addFunction"){
					addFunction();
				}else if(item.id=="editModule"){
					editModule();
				}else if(item.id=="deleteModule"){
					deleteModule();
				}else if(item.id=="upModule"){
					upModule();
				}else if(item.id=="downModule"){
					downModule();
				}
			}
		  });
		  $('#treeTabsFunctionResource').menu({   
			onClick:function(item){  
				if(item.id=="addResource"){
					addResource();
				}else if(item.id=="editFunction"){
					editFunction();
				}else if(item.id=="deleteFunction"){
					deleteFunction();
				}else if(item.id=="upFunction"){
					upFunction();
				}else if(item.id=="downFunction"){
					downFunction();
				}
			}
		  });
		  $('#treeTabsResource').menu({   
			onClick:function(item){  
				if(item.id=="editResource"){
					editResource();
				}else if(item.id=="deleteResource"){
					deleteResource();
				}else if(item.id=="upResource"){
					upResource();
				}else if(item.id=="downResource"){
					downResource();
				}
			}
		  });
		  $('#resourceTree').tree({ 
		  	animate : true,  
		    url : "getModuleForTree.action?parentId=" + id,
		    onContextMenu: function (e, title) {
                e.preventDefault();
                treeNode = title;
                $('#resourceTree').tree('select', title.target);
                if(title.attributes.flag == 0 && title.id == 1){
                	$("#treeTabsRootModule").menu('show', {
	                    left: e.pageX,
	                    top: e.pageY
	                });
                }else if(title.attributes.flag == 0 && title.attributes.isLeaf == 'N'){
                	$("#treeTabsModule").menu('show', {
	                    left: e.pageX,
	                    top: e.pageY
	                });
                }else if(title.attributes.flag == 0 && title.attributes.isLeaf == 'Y'){
                	$("#treeTabsModuleFunction").menu('show', {
	                    left: e.pageX,
	                    top: e.pageY
	                });
                }else if(title.attributes.flag == 1){
                	$("#treeTabsFunctionResource").menu('show', {
	                    left: e.pageX,
	                    top: e.pageY
	                });
                }else if(title.attributes.flag == 2){
                	$("#treeTabsResource").menu('show', {
	                    left: e.pageX,
	                    top: e.pageY
	                });
                }
            },
		    onBeforeExpand:function(node,param){ 
		    	if(node.attributes.flag == 0 && node.attributes.isLeaf == 'N'){
		    		$("#resourceTree").tree('options').url = "getModuleForTree.action?parentId=" + node.id;
		    	}else if(node.attributes.flag == 0 && node.attributes.isLeaf == 'Y'){
		    		$("#resourceTree").tree('options').url = "getFunctionForTree.action?parentId=" + node.id;
		    	}else if(node.attributes.flag == 1){
		    		$("#resourceTree").tree('options').url = "getResourceForTree.action?parentId=" + node.id;
		    	}
            },
            onDblClick : function(node){ 
            	if (node.state == 'closed'){
                 	$(this).tree('expand', node.target);  
                }else if (node.state == 'open'){  
                 	$(this).tree('collapse', node.target);  
                }
            },
            onSelect : function(node){
            	treeNode = node;
            	if(node.attributes.flag == 0){
            		document.getElementById("resourceIFrame").src = "getModuleById.action?id=" + node.id;
            	}else if(node.attributes.flag == 1){
            		document.getElementById("resourceIFrame").src = "getFunctionById.action?id=" + node.id;
            	}else{
            		document.getElementById("resourceIFrame").src = "getResourceById.action?id=" + node.id;
            	}
            }
		  });
		});
		
		//模块区
		function addModule(){
			document.getElementById("resourceIFrame").src = "<%=path %>/appjsps/sys/module/moduleAdd.jsp?parentId=" + treeNode.id;
		}
		
		function deleteModule(){
			if(confirm("是否确定删除？")){
				$.ajax({
					type:'POST',
					url: "deleteModule.action",
					data: "id="+treeNode.id,
					dataType: "json",
					success:function(info){
						if(eval(info)[0].result == 'true'){
							var parentNode = $('#resourceTree').tree('getParent',treeNode.target);
							var ppNode = $('#resourceTree').tree('getChildren',parentNode.target);
							if(ppNode.length=='1'){
								var grandpaNode = $('#resourceTree').tree('getParent',parentNode.target);
								$('#resourceTree').tree('reload',grandpaNode.target);
							}else{
								$('#resourceTree').tree('reload',parentNode.target); 
							}
							document.getElementById("resourceIFrame").src = "";
						}
					}
				});
			}
		}
		
		function editModule(){
			document.getElementById("resourceIFrame").src = "<%=path %>/appjsps/sys/module/modifyModuleById.action?id=" + treeNode.id;
		}
		
		function upModule(){
			$.ajax({
				type:'POST',
				url: "upMoveModule.action",
				data: "id="+treeNode.id,
				dataType: "json",
				success:function(info){
					if(eval(info)[0].result == 'true'){
						var parentNode = $('#resourceTree').tree('getParent',treeNode.target);
						$('#resourceTree').tree('reload',parentNode.target); 
					}
				}
			});
		}
		
		function downModule(){
			$.ajax({
				type:'POST',
				url: "downMoveModule.action",
				data: "id="+treeNode.id,
				dataType: "json",
				success:function(info){
					if(eval(info)[0].result == 'true'){
						var parentNode = $('#resourceTree').tree('getParent',treeNode.target);
						$('#resourceTree').tree('reload',parentNode.target); 
					}
				}
			});
		}
		
		//功能区
		function addFunction(){
			document.getElementById("resourceIFrame").src = "<%=path %>/appjsps/sys/function/functionAdd.jsp?parentId=" + treeNode.id;
		}
		
		function deleteFunction(){
			if(confirm("是否确定删除？")){
				$.ajax({
					type:'POST',
					url: "deleteFunction.action",
					data: "id="+treeNode.id,
					dataType: "json",
					success:function(info){
						if(eval(info)[0].result == 'true'){
							var parentNode = $('#resourceTree').tree('getParent',treeNode.target);
							var ppNode = $('#resourceTree').tree('getChildren',parentNode.target);
							if(ppNode.length=='1'){
								var grandpaNode = $('#resourceTree').tree('getParent',parentNode.target);
								$('#resourceTree').tree('reload',grandpaNode.target);
							}else{
								$('#resourceTree').tree('reload',parentNode.target); 
							}
							document.getElementById("resourceIFrame").src = "";
						}
					}
				});
			}
		}
		
		function editFunction(){
			document.getElementById("resourceIFrame").src = "<%=path %>/appjsps/sys/function/modifyFunctionById.action?id=" + treeNode.id;
		}
		
		function upFunction(){
			$.ajax({
				type:'POST',
				url: "upMoveFunction.action",
				data: "id="+treeNode.id,
				dataType: "json",
				success:function(info){
					if(eval(info)[0].result == 'true'){
						var parentNode = $('#resourceTree').tree('getParent',treeNode.target);
						$('#resourceTree').tree('reload',parentNode.target); 
					}
				}
			});
		}
		
		function downFunction(){
			$.ajax({
				type:'POST',
				url: "downMoveFunction.action",
				data: "id="+treeNode.id,
				dataType: "json",
				success:function(info){
					if(eval(info)[0].result == 'true'){
						var parentNode = $('#resourceTree').tree('getParent',treeNode.target);
						$('#resourceTree').tree('reload',parentNode.target); 
					}
				}
			});
		}
		
		//资源区
		function addResource(){
			document.getElementById("resourceIFrame").src = "resourceAdd.jsp?parentId=" + treeNode.id;
		}
		
		function deleteResource(){
			if(confirm("是否确定删除？")){
				$.ajax({
					type:'POST',
					url: "deleteResource.action",
					data: "id="+treeNode.id,
					dataType: "json",
					success:function(info){
						if(eval(info)[0].result == 'true'){
							var parentNode = $('#resourceTree').tree('getParent',treeNode.target);
							var ppNode = $('#resourceTree').tree('getChildren',parentNode.target);
							if(ppNode.length=='1'){
								var grandpaNode = $('#resourceTree').tree('getParent',parentNode.target);
								$('#resourceTree').tree('reload',grandpaNode.target);
							}else{
								$('#resourceTree').tree('reload',parentNode.target); 
							}
							document.getElementById("resourceIFrame").src = "";
						}
					}
				});
			}
		}
		
		function editResource(){
			document.getElementById("resourceIFrame").src = "modifyResourceById.action?id=" + treeNode.id;
		}
		
		function upResource(){
			$.ajax({
				type:'POST',
				url: "upMoveResource.action",
				data: "id="+treeNode.id,
				dataType: "json",
				success:function(info){
					if(eval(info)[0].result == 'true'){
						var parentNode = $('#resourceTree').tree('getParent',treeNode.target);
						$('#resourceTree').tree('reload',parentNode.target); 
					}
				}
			});
		}
		
		function downResource(){
			$.ajax({
				type:'POST',
				url: "downMoveResource.action",
				data: "id="+treeNode.id,
				dataType: "json",
				success:function(info){
					if(eval(info)[0].result == 'true'){
						var parentNode = $('#resourceTree').tree('getParent',treeNode.target);
						$('#resourceTree').tree('reload',parentNode.target); 
					}
				}
			});
		}
		
		//刷新树父节点
		function refreshParentNode(){
			var parentNode = $('#resourceTree').tree('getParent',treeNode.target);
			if(parentNode != null && parentNode != undefined){
				$('#resourceTree').tree('reload',parentNode.target);
			}else{
				$('#resourceTree').tree('reload',treeNode.target);
			}
		}
		
		//刷新树节点
		function refreshNode(){
			if($('#resourceTree').tree('isLeaf', treeNode.target)){
				var parentNode = $('#resourceTree').tree('getParent',treeNode.target);
				if(parentNode !== null && parentNode !== undefined){
					$('#resourceTree').tree('reload',parentNode.target);
				}else{
					$('#resourceTree').tree('reload');
				} 
			}else{
				$('#resourceTree').tree('reload',treeNode.target); 
			}
		}
	</script>
	</body>
</html>
