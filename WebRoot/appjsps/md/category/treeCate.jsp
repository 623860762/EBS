<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>物料分类新增</title>
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/easyui-1.3.6/themes/default/easyui.css"/>
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/easyui-1.3.6/themes/icon.css" />
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/css/common.css" />
</head>
<body>
	<div class="easyui-layout" style="width:100%;height:600px;">
		<div data-options="region:'west',title:'物料分类',split:true" style="width:250px;">
			<div><ul id="catLeftTree"></ul></div>
			<div id="catMM" class="easyui-menu" style="width:120px;">
				<div id="catForAdd" data-options="iconCls:'icon-add'">增加子分类</div>
				<div id="catRemove" data-options="iconCls:'icon-remove'">删除分类</div>
				<div id="catEdit" data-options="iconCls:'icon-edit'">修改分类</div>
				<div id="initFeat" data-options="iconCls:'icon-search'">初始化属性</div>
			</div>
		</div>
		<div data-options="region:'center',title:'属性列表',iconCls:'icon-ok'">
			<iframe id = 'cateFrame' width='100%' height='100%' frameborder='0' scrolling='yes' src=''></iframe>		
		</div>
	</div>
	<script type="text/javascript" src="<%=path %>/resources/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/easyui-1.3.6/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/easyui-1.3.6/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/esourcing.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/esourcing.util.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/jquery.serializeJSON.js"></script>	
<script>
$(function(){
	var nodeId = -1;
	var CurrNode;

	$('#catLeftTree').tree({
		onContextMenu: function(e, node){
		e.preventDefault();
		// select the node
		$('#catLeftTree').tree('select', node.target);
		CurrNode = node;
		nodeId = node.id;
		// display context menu
		$('#catMM').menu('show', {
			left: e.pageX,
			top: e.pageY
		});
	},
		url:'getCateForTree.action?parentId='+nodeId,
		method:'get',
		animate:true,
		onBeforeExpand:function(node){
			nodeId = node.id;
            $("#catLeftTree").tree('options').url = "getCateForTree.action?parentId="+nodeId;
        },
		onClick: function(node){
            	if (node.state == 'closed'){
                 	$(this).tree('expand', node.target);  
                }else if (node.state == 'open'){  
                 	$(this).tree('collapse', node.target);  
                }
                if($("#catLeftTree").tree('isLeaf',node.target)){
					$("#cateFrame").attr("src","../feat/featList.jsp?categoryId="+node.id);
                }
                
		},
		onLoadSuccess:function(){
			}
	});
	
	$("#catForAdd").click(function(){
		var chidDiaVal = window.showModalDialog('addCategory.jsp?parentId='+nodeId,'','dialogWidth:400px;dialogHeight=165px;center=yes;border=thick;status=no;help=no;scrollbars=no');
		var jsonData = esourcing.util.strToJson(chidDiaVal);
		if(jsonData.result=='true'){
			esourcing.util.rightMessage("新增提示","新增物料分类成功");
			if($("#catLeftTree").tree('isLeaf',CurrNode.target)){
	 			var parentNode = $('#catLeftTree').tree('getParent',CurrNode.target);
				$('#catLeftTree').tree('reload',parentNode.target);               
            }else{
				$('#catLeftTree').tree('reload',CurrNode.target);               
            }

		}else if(typeof(chidDiaVal)=='undefined'){
			return false;
		}else{
			esourcing.util.rightMessage("新增提示","新增物料分类失败");
			return false;
		}
	});
	
	$("#initFeat").click(function(){
	   alert(CurrNode.text);
	});
	
	$("#catEdit").click(function(){
		var chidDiaVal = window.showModalDialog('editCatPage.action?id='+nodeId,'','dialogWidth:400px;dialogHeight=165px;center=yes;border=thick;status=no;help=no;scrollbars=no');
		var jsonData = esourcing.util.strToJson(chidDiaVal);
		if(jsonData.result=='true'){
			esourcing.util.rightMessage("修改提示","修改物料分类成功");
	 		freshParentNode();               

		}else if(typeof(chidDiaVal)=='undefined'){
			return false;
		}else{
			esourcing.util.rightMessage("修改提示","修改物料分类失败");
			return false;
		}
	});
	
	$("#catRemove").click(function(){
        if($("#catLeftTree").tree('isLeaf',CurrNode.target)){
		$.messager.confirm('', '确定删除'+CurrNode.text, function(del){
		if (del){
			$.ajax({
					type: "POST",
					url: "delCategory.action?id="+nodeId,
					success: function(data){
					if(data.result=='true'){
						esourcing.util.rightMessage("删除提示","删除分类成功");
						var parentNode = $('#catLeftTree').tree('getParent',CurrNode.target);
						var ppNode = $('#catLeftTree').tree('getChildren',parentNode.target);
						if(ppNode.length=='1'){
							var parentNode = $('#catLeftTree').tree('getParent',parentNode.target);
							$('#catLeftTree').tree('reload',parentNode.target);     
						}else{
						$('#catLeftTree').tree('reload',parentNode.target); 
						}
					}else{
						esourcing.util.rightMessage("删除提示","删除分类失败");
						return false;
				}
			}
		});
	}
});	
        }else{
        	alert("该分类下有数据不允许删除");
        	return false;
        }	
});
	function freshCurrNode(){
		
	}	
	function freshParentNode(){
	 	var parentNode = $('#catLeftTree').tree('getParent',CurrNode.target);
		$('#catLeftTree').tree('reload',parentNode.target); 
	}	
});
</script>
</body>
</html>
	