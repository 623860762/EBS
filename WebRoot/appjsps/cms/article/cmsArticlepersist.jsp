<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String projectId = request.getParameter("projectId");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>新增公告</title>
    
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
	<form id="articlePersist" method="post">
	<input type="hidden"  name ="id"  "/>
	<div align="center" class="w840">
		<table class="table_common" >
			<tr>
				<td colspan="2" align="center">
					<span class="span_icon_head">
					<span class="column_head_word" >新增信息</span>
					</span>
				</td>
			</tr>	
			<tr><td class="table_td1">公告名称：</td><td><input name="name"  type="text"/></td></tr>
			<tr><td class="table_td1">公告类型：</td><td>
					<select class="easyui-combobox h20_w160" name="type" editable="false"  panelHeight="auto"  >
						<option value="公开招标">公开招标</option>
						<option value="邀请招标">邀请招标</option>
						<option value="澄清公告">澄清公告</option>
        			</select>
        			<a style="float:right;margin-right: 15px;" onclick= "topwin()"  class="easyui-linkbutton" >选择模版</a>
        	</td></tr>
			<tr><td class="table_td1">公告内容：</td><td><div><textarea id="remark" name="remark" style="width:700px;height:300px;visibility:hidden;" ></textarea></div></td></tr>
			<td colspan="5">
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
	<script charset="utf-8" type="text/javascript" src="<%=path %>/resources/kindeditor/kindeditor-min.js"></script>
	<script charset="utf-8" src="<%=path %>/resources/kindeditor/lang/zh_CN.js"></script>

<script>
	var editor;
	KindEditor.ready(function(K) {
		editor = K.create('textarea[name="remark"]', {
				allowFileManager : true
		});
	});
	function topwin(){   
	  	var tempData=window.showModalDialog("appjsps/cms/template/seleTemplateList.jsp",window,"dialogWidth:850px;dialogHeight:400px;scroll:auto;status:no");
	  	console.log(tempData);
	  	editor.html(tempData);
	   }




	$(function(){
	
		$('#articlePersist').form({
		url:'persistArticle.action',
		dataType:"json",
		
		onSubmit:function(){
			$("#remark").val(editor.html());
	    	var formJson = $('#articlePersist').serializeJSON();
			if(formJson.name==""){
				alert("公告名称不能为空！");
				return false;
				}
		},
		success:function(data){
			if(jsonData = esourcing.util.strToJson(data)){
				if(jsonData.result=='true'){
					alert("新增公告成功！");
					esourcing.util.goUrlCloself();
				}else{
					alert("新增公告失败！");
					return false;
				}
			}else{
			
			}
		}
	});
		
	
	
	$("#back").click(
		function(){
			$('#articlePersist')[0].reset();
		}
	);
		
	$("#save").click(
		function(){
			$("#articlePersist").submit();
		}
	);
		
});
</script>

  </body>
</html>

