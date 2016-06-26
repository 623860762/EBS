<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.ceit.ebs.ebp.vo.EbpObjectVo"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
EbpObjectVo ebpObjectVo = (EbpObjectVo)request.getAttribute("ebpObjectVo");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改分标页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/easyui-1.3.6/themes/default/easyui.css"/>
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/easyui-1.3.6/themes/icon.css" />
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/css/common.css" />

  </head>
  
  <body>
    <br>
    <br/>
    <form id="modifyObject">
	   <table class="table_common"  align="center" width="800px">
			
				<tr height="15%">
					<th class="table_head" colspan="4" style="text-align:center;">分标信息信息详情</th>  	
				</tr>
				<tr >
			  		 	<td class="table_td1">标名称:</td><td><input value="<%=ebpObjectVo.getObjectName()==null?"":ebpObjectVo.getObjectName() %>" name="objectName"   type="text" /></td>
			   		
				</tr>
				<tr>
					<td class="table_td1">项目编号:</td>
			   		<td>
			   			<input value="<%=ebpObjectVo.getProjectId()==null?"":ebpObjectVo.getProjectId() %>" name="projectId"   type="text" />
			   		</td>
				</tr>
				<tr >
			   		<td class="table_td1">创始人代号:</td><td><input value="<%=ebpObjectVo.getCreatorId()==null?"":ebpObjectVo.getCreatorId() %>" name="creatorId"   type="text" /></td>
			   		
				</tr>
				<tr>
					<td class="table_td1">是否有效:</td>
					<td >
						<input value="<%=ebpObjectVo.getIsValid()==null?"":ebpObjectVo.getIsValid() %>" name="isValid"   type="text" />
			   		</td>
				</tr>
			    <tr>
			    	<td>
			    	</td>
			    	<td>
			    		<input name="id" style="display:none;" value="<%=ebpObjectVo.getId() %>" />
			    		&nbsp;&nbsp;<input id="modify" name="modify" value="修改" type="button"/>
			    		&nbsp;&nbsp;<input  type="button" value="返回" onclick="javascript:top.close();" align="middle"/>
			    	</td>
			    	
			    </tr>
	   </table>
    </form>
    
    <script type="text/javascript" src="<%=path %>/resources/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/easyui-1.3.6/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/easyui-1.3.6/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/esourcing.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/esourcing.util.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/jquery.serializeJSON.js"></script>
	
	<script type="text/javascript">

		$(function(){
			$("#modify").click(
				function(){
					if(confirm("是否确定修改？")){
						$("#modifyObject").submit();
					}
				}
			);
			$('#modifyObject').form({
				url : 'modifyObject.action',
				onSubmit : function(){
				},
				success : function(data){
					var map=eval('('+data+')');//用eval函数将json转化为对象
					if(map.result == 'true'){
						window.opener.location.href=window.opener.location.href;
						window.close();
					}
				}
			});
		});
	
	</script>
	
	
  </body>
</html>
