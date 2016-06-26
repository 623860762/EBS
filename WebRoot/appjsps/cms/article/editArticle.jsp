<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.ceit.ebs.cms.vo.CmsArticleVo"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"
	+request.getServerPort()+path+"/";
	
	CmsArticleVo cmsArticleVo = (CmsArticleVo)request.getAttribute("cmsArticleVo");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改公告</title>
    
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
	<form id="articlePersist" method="post">
	<div align="center" class="w840">
		<table class="table_common">
	<tr>
				<td colspan="2" align="center">
					<span class="span_icon_head">
					<span class="column_head_word" >修改信息</span>
					</span>
				</td>
			</tr>	
	<tr>
    	<td class="table_td1">公告名称:</td><td><input class="easyui-validatebox title_input" type="text" name="name" value="<%=cmsArticleVo.getName()==null?"":cmsArticleVo.getName()%>"></input><font class="need_color">*</font></td>
    </tr>
	<tr>
		<td class="table_td1">公告类型:</td><td>
    				<select id="seleArticleId" class="easyui-combobox"  name="type" editable="false"  panelHeight="auto">
						<option value="公开招标">公开招标</option>
						<option value="邀请招标">邀请招标</option>
						<option value="澄清公告">澄清公告</option>
        			</select>
    	</td>
    </tr>
	<tr><td class="table_td1">内容：</td><td><div><textarea id="remark" name="remark" style="width:700px;height:300px;visibility:hidden;"   ></textarea></div></td></tr>
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
	<script charset="utf-8" type="text/javascript" src="<%=path %>/resources/kindeditor/kindeditor-min.js"></script>
	<script charset="utf-8" type="text/javascript" src="<%=path %>/resources/kindeditor/lang/zh_CN.js"></script>

<script>

	$(function(){
		$('#seleArticleId').combobox('setValue', "<%=cmsArticleVo.getType()%>");
		var editor;
			KindEditor.ready(
			function(K){
				editor = K.create('textarea[name="remark"]', {
				allowFileManager : true
			});
		});
		$("#remark").html('<%=cmsArticleVo.getRemark()==null?"":cmsArticleVo.getRemark() %>');
		$('#articlePersist').form({
		url:'mergeArticle.action',
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
					alert("修改公告成功！");
					esourcing.util.goUrlCloself();
				}else{
					alert("修改公告失败！");
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

