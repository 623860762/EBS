<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.ceit.common.util.StaticSource"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
  	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>用户管理页面</title>
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/easyui-1.3.6/themes/default/easyui.css"/>
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/easyui-1.3.6/themes/icon.css" />
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/css/default.css" />
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/css/common.css" />
	
	</head>
    <body class="easyui-layout" style="overflow-y: hidden"  scroll="no">
    	<div id="treeTabsUser" class="easyui-menu" style="width:120px;">  
		    <div iconCls="icon-tip" id="addChildNode">增加用户</div>  
		</div>  
		<div id="treeTabsUserLeaf" class="easyui-menu" style="width:120px;">  
		    <div iconCls="icon-tip" id="modifyUser">修改用户</div>
		    <div iconCls="icon-tip" id="distributeRoles">分配角色</div>
		    <div iconCls="icon-tip" id="deleteNode">删除用户</div>  
		    <div iconCls="icon-tip" id="upMove">上移</div>
		    <div iconCls="icon-tip" id="downMove">下移</div>
		</div>  
    	<div region="west" hide="true" split="true" style="width: 300px;" id="west">
    		<ul id="userTree"></ul>
    	</div>
    	
    	<div region="center">
    		<iframe scrolling="auto" id="userIFrame" name="userIFrame" frameborder="0"  style="width:100%;height:100%;"></iframe>
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
		  $('#treeTabsUser').menu({   
			onClick:function(item){  
				if(item.id=="addChildNode"){
					addChildNode(); 
				}
			}
		  });
		  $('#treeTabsUserLeaf').menu({   
			onClick:function(item){  
				if(item.id=="distributeRoles"){
					distributeRoles();
				}else if(item.id=="deleteNode"){
					deleteNode();
				}else if(item.id=="upMove"){
					upMove();
				}else if(item.id=="upMove"){
					forProductConnect();
				}else if(item.id=="downMove"){
					downMove();
				}else if(item.id=="modifyUser"){
					modifyUser();
				}
			}
		  });
		  $('#userTree').tree({ 
		  	animate : true,  
		    url : "getUserForTree.action?parentId=" + id,
		    onContextMenu: function (e, title) {
                e.preventDefault();
                treeNode = title;
                $('#userTree').tree('select', title.target);
                if(title.attributes.flag == 0){
                	$("#treeTabsUser").menu('show', {
	                    left: e.pageX,
	                    top: e.pageY
	                });
                }else{
                	$("#treeTabsUserLeaf").menu('show', {
	                    left: e.pageX,
	                    top: e.pageY
	                });
                }
            },
		    onBeforeExpand:function(node,param){ 
               $("#userTree").tree('options').url = "getUserForTree.action?parentId=" + node.id;
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
            	if(node.attributes.flag == 1){
            		document.getElementById("userIFrame").src = "getUserById.action?id=" + node.id;
            	}else{
            		document.getElementById("userIFrame").src = "";
            	}
            }
		  });
		});
		
		function addChildNode(){
			document.getElementById("userIFrame").src = "userAdd.jsp?parentId=" + treeNode.id;
		}
		
		function deleteNode(){
			if(confirm("是否确定删除？")){
				$.ajax({
					type:'POST',
					url: "deleteUser.action",
					data: "id="+treeNode.id,
					dataType: "json",
					success:function(info){
						if(eval(info)[0].result == 'true'){
							var parentNode = $('#userTree').tree('getParent',treeNode.target);
							var ppNode = $('#userTree').tree('getChildren',parentNode.target);
							if(ppNode.length=='1'){
								var grandpaNode = $('#userTree').tree('getParent',parentNode.target);
								$('#userTree').tree('reload',grandpaNode.target);
							}else{
								$('#userTree').tree('reload',parentNode.target); 
							}
							document.getElementById("userIFrame").src = "";
						}
					}
				});
			}
		}
		
		function upMove(){
			$.ajax({
				type:'POST',
				url: "upMoveUser.action",
				data: "id="+treeNode.id,
				dataType: "json",
				success:function(info){
					if(eval(info)[0].result == 'true'){
						var parentNode = $('#userTree').tree('getParent',treeNode.target);
						$('#userTree').tree('reload',parentNode.target); 
					}
				}
			});
		}
		
		function downMove(){
			$.ajax({
				type:'POST',
				url: "downMoveUser.action",
				data: "id="+treeNode.id,
				dataType: "json",
				success:function(info){
					if(eval(info)[0].result == 'true'){
						var parentNode = $('#userTree').tree('getParent',treeNode.target);
						$('#userTree').tree('reload',parentNode.target); 
					}
				}
			});
		}
		
		//刷新树父节点
		function refreshParentNode(){
			var parentNode = $('#userTree').tree('getParent',treeNode.target);
			if(parentNode != null && parentNode != undefined){
				$('#userTree').tree('reload',parentNode.target);
			}else{
				$('#userTree').tree('reload',treeNode.target);
			}
		}
		
		//刷新树节点
		function refreshNode(){
			if($('#userTree').tree('isLeaf', treeNode.target)){
				var parentNode = $('#userTree').tree('getParent',treeNode.target);
				if(parentNode !== null && parentNode !== undefined){
					$('#userTree').tree('reload',parentNode.target);
				}else{
					$('#userTree').tree('reload');
				} 
			}else{
				$('#userTree').tree('reload',treeNode.target); 
			}
		}
		
		//分配角色
		function distributeRoles(){
			alert("分配角色");
		}
		
		//修改用户
		function modifyUser(){
			if(treeNode.attributes.flag == 1){
           		document.getElementById("userIFrame").src = "modifyUserById.action?id=" + treeNode.id;
           	}
		}
	</script>
	</body>
</html>
