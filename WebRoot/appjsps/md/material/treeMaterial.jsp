<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>物料管理</title>
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/easyui-1.3.6/themes/default/easyui.css"/>
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/easyui-1.3.6/themes/icon.css" />
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/css/common.css" />
</head>
<body>
	<div class="easyui-layout" style="width:100%;height:600px;">
		<div data-options="region:'west',title:'物料分类',split:true" style="width:250px;">
			<div><ul id="catLeftTree"></ul></div>
		</div>
		<div data-options="region:'center',title:'物料列表',iconCls:'icon-ok'">
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
					$("#cateFrame").attr("src","materialList.jsp?categoryId="+node.id);
                }
                
		},
		onLoadSuccess:function(){
			}
	});
	
});
</script>
</body>
</html>
	