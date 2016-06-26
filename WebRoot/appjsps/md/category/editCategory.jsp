<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.ceit.ebs.md.vo.MdCategoryVo"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	MdCategoryVo categoryVo = (MdCategoryVo)request.getAttribute("mdCategoryVo");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>新增分类</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/easyui-1.3.6/themes/default/easyui.css"/>
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/easyui-1.3.6/themes/icon.css" />
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/css/common.css" />
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/css/ebs.css" />
	
  </head>
  
  <body>
	<form id="Persist" method="post">
	<div align="center" class="w840">
		<table class="table_common">
	<tr>
    	<td colspan="2" class="head_padding_left">物料分类新增</td>
    </tr>
	<tr>
    	<td class="table_td1">分类名称:</td><td><input class="easyui-validatebox title_input" type="text" name="name" value="<%=categoryVo.getName()==null?"":categoryVo.getName()%>"></input><font class="need_color">*</font></td>
    </tr>
	<tr>
    	<td class="table_td1">分类Code:</td><td><input class="easyui-validatebox title_input" type="text" name="code" value="<%=categoryVo.getCode()==null?"":categoryVo.getCode()%>"></input><font class="need_color">*</font></td>
    </tr>
	<tr>
    	<td class="table_td1">分类别名:</td><td><input class="easyui-validatebox title_input" type="text" name="aliasName" value="<%=categoryVo.getAliasName()==null?"":categoryVo.getAliasName()%>"></input><font class="need_color">*</font></td>
    </tr>
    	<td colspan="2">
    		<span class="button_span_location">
    		<a id="save" class="easyui-linkbutton icon_margin" data-options="toggle:true">确定</a>&nbsp;
			<a id="back" class="easyui-linkbutton icon_margin" data-options="toggle:true">重置</a>
    		</span>
    	</td>
    </tr>
		</table>
	</div>
	</form>
	
	<script type="text/javascript" src="<%=path %>/resources/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/easyui-1.3.6/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/easyui-1.3.6/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/esourcing.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/esourcing.util.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/jquery.serializeJSON.js"></script>	

<script>
	$(function(){
	
		$('#Persist').form({
		url:'mergeCat.action',
		dataType:"json",
		onSubmit:function(){
	    	var formJson = $('#Persist').serializeJSON();
			if(formJson.name==""){
				alert("分类名称不能为空");
				return false;
				}
		},
		success:function(data){
				parent.returnValue=data;
				window.close();
		}
	});
	
	$("#back").click(
		function(){
			$('#Persist')[0].reset();
		}
	);
		
	$("#save").click(
		function(){
			$("#Persist").submit();
		}
	);
		
});
</script>

  </body>
</html>
