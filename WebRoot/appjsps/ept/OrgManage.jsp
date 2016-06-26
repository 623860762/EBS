<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.ceit.common.util.StaticSource"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
  	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>组织机构管理页面</title>
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/easyui-1.3.6/themes/default/easyui.css"/>
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/easyui-1.3.6/themes/icon.css" />
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/css/default.css" />
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/css/common.css" />
	
	</head>
    <body class="easyui-layout" style="overflow-y: hidden"  scroll="no">
    
    <div id="treeTabsMenu" class="easyui-menu" style="width:120px;">  
		    <div iconCls="icon-tip" id="addChildNode">增加下级节点</div>  
		    <div iconCls="icon-tip" id="deleteNode">删除该节点</div>  
		    <div iconCls="icon-tip" id="upMove">上移</div>
		    <div iconCls="icon-tip" id="downMove">下移</div>
		</div>  
		
    	<div region="west" hide="true" split="true" style="width: 300px;" id="west">
    		<ul id="orgTree"></ul>
    	</div>
    	
    	<div region="center">
    		<iframe scrolling="auto" id="orgIFrame" name="orgIFrame" frameborder="0"  style="width:100%;height:100%;"></iframe>
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
	  $('#treeTabsMenu').menu({   
		onClick:function(item){  
			if(item.id=="addChildNode"){
				addChildNode(); 
			}else if(item.id=="deleteNode"){
				deleteNode();
			}else if(item.id=="upMove"){
				upMove();
			}else if(item.id=="upMove"){
				forProductConnect();
			}else if(item.id=="downMove"){
				downMove();
			}
		}
	  });
		
		  $("#orgTree").tree({ 
		  	animate : true,  
		    url : "getOrgForTree.action?parentId=" + id,
		    onContextMenu: function (e, title) {
                e.preventDefault();
                treeNode = title;
                $('#orgTree').tree('select', title.target);
                $("#treeTabsMenu").menu('show', {
                    left: e.pageX,
                    top: e.pageY
                });
            },
		    onBeforeExpand:function(node,param){ 
               $("#orgTree").tree('options').url = "getOrgForTree.action?parentId=" + node.id;
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
            	document.getElementById("orgIFrame").src = "getOrgById.action?id=" + node.id;
            }
		  });
	});
	
	function addChildNode(){
		document.getElementById("orgIFrame").src = "orgAdd.jsp?parentId=" + treeNode.id;
	}
	
	function deleteNode(){
		if(confirm("是否确定删除？")){
			$.ajax({
				type:'POST',
				url: "deleteOrg.action",
				data: "id="+treeNode.id,
				dataType: "json",
				success:function(info){
					if(eval(info)[0].result == 'true'){
						var parentNode = $('#orgTree').tree('getParent',treeNode.target);
						var ppNode = $('#orgTree').tree('getChildren',parentNode.target);
						if(ppNode.length=='1'){
							var grandpaNode = $('#orgTree').tree('getParent',parentNode.target);
							$('#orgTree').tree('reload',grandpaNode.target);
						}else{
							$('#orgTree').tree('reload',parentNode.target); 
						}
					}
					document.getElementById("orgIFrame").src = "";
				}
			});
		}
	}
	
	//刷新树节点
	function refreshNode(){
		if($('#orgTree').tree('isLeaf', treeNode.target)){
			var parentNode = $('#orgTree').tree('getParent',treeNode.target);
			$('#orgTree').tree('reload',parentNode.target); 
		}else{
			$('#orgTree').tree('reload',treeNode.target); 
		}
	}
	
	function upMove(){
		$.ajax({
			type:'POST',
			url: "upMoveOrg.action",
			data: "id="+treeNode.id,
			dataType: "json",
			success:function(info){
				if(eval(info)[0].result == 'true'){
					var parentNode = $('#orgTree').tree('getParent',treeNode.target);
					$('#orgTree').tree('reload',parentNode.target); 
				}
			}
		});
	}
	
	function downMove(){
		$.ajax({
			type:'POST',
			url: "downMoveOrg.action",
			data: "id="+treeNode.id,
			dataType: "json",
			success:function(info){
				if(eval(info)[0].result == 'true'){
					var parentNode = $('#orgTree').tree('getParent',treeNode.target);
					$('#orgTree').tree('reload',parentNode.target); 
				}
			}
		});
	}
	</script>
	</body>
</html>
