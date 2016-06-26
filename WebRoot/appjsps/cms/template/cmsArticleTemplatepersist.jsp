<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String projectId = request.getParameter("projectId");
String templateType = request.getParameter("templateType");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>新增公告模板</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/easyui-1.3.6/themes/default/easyui.css"/>
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/easyui-1.3.6/themes/icon.css" />
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/css/common.css" />
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/css/ebs.css" />	
	<link rel="stylesheet" href="<%=path %>/resources/kindeditor/themes/default/default.css"/>
	
  </head>
  
  <body>
	<form id="articleTemplatePersist" method="post">
	<input type="hidden"  name ="id"  "/>
	<div align="center" class="w840">
		<table class="table_common" >
			<tr>
				<td colspan="2" align="center">
					<span class="span_icon_head">
					<span class="column_head_word">新增模板</span>
					</span>
				</td>
			</tr>	
			<tr><td class="table_td1">模板名称：</td><td><input name="name"  type="text"/></td></tr>
			<tr><td class="table_td1">模板类型：</td><td>
					<select  id="seleTempId" class="easyui-combobox" name="templateType" editable="false"  panelHeight="auto"  >
						<option value="0">公开招标</option>
						<option value="1">中标公示</option>
						<option value="2">澄清公告</option>
						<option value="3">中标通知书</option>
        			</select>
        	</td></tr>
			<tr><td class="table_td1">模板内容：</td><td><div><textarea id="templateData" name="templateData" style="width:700px;height:300px;visibility:hidden;" ></textarea></div></td></tr>
					<td colspan="2">
			    		<span class="button_span_location">
			    		<a id="save" class="easyui-linkbutton icon_margin" data-options="toggle:true">确定</a>&nbsp;
						<a id="back" class="easyui-linkbutton icon_margin" data-options="toggle:true">重置</a>
	    				</span>
    				</td>
		</table>
	</div>
	</form>
	
	<script type="text/javascript" src="<%=path %>/resources/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/easyui-1.3.6/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/easyui-1.3.6/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/esourcing.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/esourcing.util.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/jquery.serializeJSON.js"></script>	
	<script type="text/javascript" src="<%=path %>/resources/kindeditor/kindeditor.js"></script>
	<script charset="utf-8" src="<%=path %>/resources/kindeditor/lang/zh_CN.js"></script>

<script>
var editor;
KindEditor.ready(function(K) {
editor = K.create('textarea[name="templateData"]', {
			allowFileManager : true
	});
});
	$(function(){
		$('#seleTempId').combobox('setValue','<%=templateType%>');
		$('#articleTemplatePersist').form({
		url:'persistArticleTemplate.action',
		dataType:"json",
		onSubmit:function(){
			$("#templateData").val(editor.html());
	    	var formJson = $('#articleTemplatePersist').serializeJSON();
			if(formJson.name==""){
				alert("模板名称不能为空！");
				return false;
				}
		},
		success:function(data){
			if(jsonData = esourcing.util.strToJson(data)){
				if(jsonData.result=='true'){
					alert("新增模板成功！");
					esourcing.util.goUrlCloself();
				}else{
					alert("新增模板失败！");
					esourcing.util.goUrlCloself();
					return false;
				}
			}else{
			
			}
		}
	});
	
	$("#back").click(
		function(){
			$('#articleTemplatePersist')[0].reset();
		}
	);
		
	$("#save").click(
		function(){
			$("#articleTemplatePersist").submit();
		}
	);
		
});
</script>

  </body>
</html>

