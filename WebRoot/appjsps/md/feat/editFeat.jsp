<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.ceit.ebs.md.vo.MdFeatVo"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"
	+request.getServerPort()+path+"/";
	
	MdFeatVo mdFeatVo = (MdFeatVo)request.getAttribute("mdFeatVo");
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
	<form id="featPersist" method="post">
	<div align="center" class="w840">
		<table class="table_common">
	<tr>
    	<td colspan="2" class="head_padding_left">新增属性</td>
    </tr>
	<tr>
    	<td class="table_td1">属性编码:</td><td><input class="easyui-validatebox title_input" type="text" name="code" value="<%=mdFeatVo.getCode()==null?"":mdFeatVo.getCode()%>"></input><font class="need_color">*</font></td>
    </tr>
	<tr>
    	<td class="table_td1">属性名称:</td><td><input class="easyui-validatebox title_input" type="text" name="name" value="<%=mdFeatVo.getName()==null?"":mdFeatVo.getName()%>"></input><font class="need_color">*</font></td>
    </tr>
	<tr>
    	<td class="table_td1">属性别名:</td><td><input class="easyui-validatebox title_input" type="text" name="aliasName" value="<%=mdFeatVo.getAliasName()==null?"":mdFeatVo.getAliasName()%>"></input><font class="need_color">*</font></td>
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
	
		$('#featPersist').form({
		url:'mergeFeat.action',
		dataType:"json",
		onSubmit:function(){
	    	var formJson = $('#featPersist').serializeJSON();
			if(formJson.code==""){
				alert("属性编码不能为空！");
				return false;
				}
		},
		success:function(data){
			if(jsonData = esourcing.util.strToJson(data)){
				if(jsonData.result=='true'){
					alert("修改属性成功！");
					esourcing.util.goUrlCloself();
				}else{
					alert("修改属性失败！");
					return false;
				}
			}else{
			
			}
		}
	});
	
	$("#back").click(
		function(){
			$('#featPersist')[0].reset();
		}
	);
		
	$("#save").click(
		function(){
			$("#featPersist").submit();
		}
	);
		
});
</script>

  </body>
</html>

