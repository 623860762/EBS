<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.ceit.ebs.cms.vo.CmsArticleTemplateVo"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"
	+request.getServerPort()+path+"/";
	
	CmsArticleTemplateVo cmsArticleTemplateVo = (CmsArticleTemplateVo)request.getAttribute("cmsArticleTemplateVo");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查看公告模板</title>
    
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
	<form id="articleTemplatePersist" method="post">
	<div align="center" class="w840">
		<table class="table_common">
	<tr>
    	<td colspan="2" class="head_padding_left">查看公告模板</td>
    </tr>
	<tr>
    	<td class="table_td1">模板名称:</td><td><input class="easyui-validatebox title_input" type="text" name="name" readonly="true" value="<%=cmsArticleTemplateVo.getName()==null?"":cmsArticleTemplateVo.getName()%>"></input><font class="need_color">*</font></td>
    </tr>
	<tr>
		<td class="table_td1">模板类型:</td><td>
    				<select id="seleTempId" class="easyui-combobox"  name="templateType" readonly="true" editable="false"  panelHeight="auto">
						<option value="公开招标">公开招标</option>
						<option value="邀请招标">邀请招标</option>
						<option value="澄清公告">澄清公告</option>
						<option value="澄清公告">中标通知书</option>
        			</select>
    	</td>
    </tr>
	<tr><td class="table_td1">模板内容：</td><td><div readonly="true" style="width:700px;height:300px;padding-left:8px;padding-right:8px;overflow:auto" id="articleTemplateText"></div></td></tr>
    	<td colspan="2">
    		<span class="button_span_location">
    		<a id="close" class="easyui-linkbutton icon_margin" data-options="toggle:true">关闭</a>
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
		$('#seleTempId').combobox('setValue',esourcing.util.TempStyleEdit(<%=cmsArticleTemplateVo.getTemplateType()%>));
		$("#articleTemplateText").html('<%=cmsArticleTemplateVo.getTemplateData()==null?"":cmsArticleTemplateVo.getTemplateData() %>');
	$("#close").click(
		function(){
			esourcing.util.goUrlCloself();
		}
	);
		
});
</script>

  </body>
</html>

