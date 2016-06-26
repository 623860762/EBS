<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.ceit.ebs.ebp.vo.EbpProjectVo"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
EbpProjectVo ebpProjectVo = new EbpProjectVo();
ebpProjectVo = (EbpProjectVo)request.getAttribute("ebpProjectVo");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
   <title>项目详情</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/easyui-1.3.6/themes/default/easyui.css"/>
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/easyui-1.3.6/themes/icon.css" />
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/css/common.css" />

  </head>
  
  <body>
    	<form id="updateEbpProject" method="post" action="updateEbpProject.action">
    		<table class="table_common"  align="center" width="800px">
    			
    			<tr height="15%">
    			<th class="table_head" colspan="4" style="text-align:center;">修改采购项目信息</th>  	
    		</tr>
    		<tr >
       		 	<td class="table_td1">项目名称:</td><td><input value="<%=ebpProjectVo.getProjectName()==null?"":ebpProjectVo.getProjectName() %>" name="projectName"   type="text" disabled/></td>
        		<td class="table_td1">编码方式:</td>
        		<td>
        			<input value="<%=ebpProjectVo.getProjectCode()==null?"":ebpProjectVo.getProjectCode() %>" name="projectCode"   type="text" disabled/>
        		</td>
    		</tr>
    		<tr >
        		<td class="table_td1">预算金额:</td><td><input value="<%=ebpProjectVo.getBudgetMoney()==null?"":ebpProjectVo.getBudgetMoney() %>" name="budgetMoney"   type="text" disabled/></td>
        		<td class="table_td1">需求部门:</td>
    			<td >
    				<input value="<%=ebpProjectVo.getNeedDepartmentId()==null?"":ebpProjectVo.getNeedDepartmentId() %>" name="needDepartmentId"   type="text" disabled/>
        		</td>
    		</tr>
    		<tr >
    				<td class="table_td1">项目经理:</td>
    				<td>
    					<input value="<%=ebpProjectVo.getProjectManagerId()==null?"":ebpProjectVo.getProjectManagerId() %>" name="projectManagerId"   type="text" disabled/>
        			</td>     
    				<td class="table_td1">项目描述:</td>
        			<td>
        				<input value="<%=ebpProjectVo.getProjectRemark()==null?"":ebpProjectVo.getProjectRemark() %>" name="projectRemark"   type="text" disabled/>
        			</td>
    		</tr>
    		<tr>
        			<td class="table_td1">招标年份:</td>
        			<td class="alt">
        				<input value="<%=ebpProjectVo.getProjectYear()==null?"":ebpProjectVo.getProjectYear() %>" name="projectYear"   type="text" disabled/>
        			</td>
        			<td class="table_td1">公开/邀请:</td>
        			<td>
        				<input value="<%=ebpProjectVo.getIsPublic()==null?"":ebpProjectVo.getIsPublic() %>" name="isPublic"   type="text" disabled/>
        			</td>
    		</tr>
    		<tr>
        			<td class="table_td1">中标规则:</td>
        			<td>
        				<input value="<%=ebpProjectVo.getWinRule()==null?"":ebpProjectVo.getWinRule() %>" name="winRule"   type="text" disabled/>
        			</td>
         			<td class="table_td1">招标项目创建人:</td>
    				<td class="alt">
    					<input value="<%=ebpProjectVo.getCreatorId()==null?"":ebpProjectVo.getCreatorId() %>" name="creatorId"   type="text" disabled/>
        			</td>
    		</tr>
    <tr >
        <td class="table_td1">标书开始购买时间:</td><td><input value="<%=ebpProjectVo.getStartBuyTime()==null?"":ebpProjectVo.getStartBuyTime() %>" id="startBuyTime" style="height: 20" class="easyui-numberbox text w150"  name="startBuyTime"  type="text" disabled/></td>
         <td class="table_td1">标书购买截至时间:</td>
         <td class="alt">
            <input type="text" name="endBuyTime" value="<%=ebpProjectVo.getEndBuyTime()==null?"":ebpProjectVo.getEndBuyTime() %>" disabled/>
         </td>
    </tr>
    
     <tr>
    	<td class="table_td1">截标时间:</td>
    	<td>
    		<input value="<%=ebpProjectVo.getCloseBidTime()==null?"":ebpProjectVo.getCloseBidTime() %>" name="closeBidTime"   type="text" disabled/>
        </td>
        <td class="table_td1">开标时间:</td><td><input value="<%=ebpProjectVo.getOpenBidTime()==null?"":ebpProjectVo.getOpenBidTime() %>" id="openBidTime" name="openBidTime" type="text" disabled/></td>
    </tr>
    <tr >
    	<td class="table_td1">唱标时间:</td>
        <td>
        	<input value="<%=ebpProjectVo.getSingBidTime()==null?"":ebpProjectVo.getSingBidTime() %>" name="singBidTime"   type="text" disabled/>
        </td>
        <td class="table_td1">定标时间:</td><td><input value="<%=ebpProjectVo.getSureBidTime()==null?"":ebpProjectVo.getSureBidTime() %>" class="easyui-datetimebox  calender_h_w"  id="sureBidTime" name="sureBidTime"  type="text" disabled/></td>
    </tr>
    <tr>    	
        <td class="table_td1">应答开始时间:</td><td class="alt"><input value="<%=ebpProjectVo.getReplyStartTime()==null?"":ebpProjectVo.getReplyStartTime() %>" name="replyStartTime" class="text w150"  type="text" class="easyui-validatebox text w150"  disabled/></td>
         <td class="table_td1">应答结束时间:</td><td><input style="height: 20" maxlength="100" name="replyStopTime"  type="text" class="easyui-validatebox text w150"  disabled/></td>
    </tr>
    <tr id="time1">  	
        
        <td class="table_td1">预计标书购买截至时间:</td><td><input class="easyui-datebox  calender_h_w"   id="endBuyTime" name="endBuyTime" type="text" disabled/></td>
    
        <td class="table_td1">决策纪要下达时间:</td><td><input class="easyui-datebox  calender_h_w" id="decisionDownTime" name="decisionDownTime"   type="text" disabled /></td>
    </tr>
    <tr >
        <td class="table_td1">是否需要资格认证:</td><td><input value="<%=ebpProjectVo.getIsPrequalification()==null?"":ebpProjectVo.getIsPrequalification() %>" style="height: 20" maxlength="32"  name="isPrequalification"  type="text" class="easyui-validatebox text w150"   disabled/></td>
        <td class="table_td1">项目审核状态:</td><td><input value="<%=ebpProjectVo.getProjectAuditStatus()==null?"":ebpProjectVo.getProjectAuditStatus() %>" name="projectAuditStatus"  type="text" class="easyui-validatebox text w150" disabled/></td>
    </tr>
        
    <tr >
        <td class="table_td1">是否分标:</td><td><input value="<%=ebpProjectVo.getIsObject()==null?"":ebpProjectVo.getIsObject() %>"  id="isObject" name="isObject"    type="text" disabled/></td>
         <td class="table_td1">审核人编号:</td>
        <td>
        	<input value="<%=ebpProjectVo.getProjectAuditId()==null?"":ebpProjectVo.getProjectAuditId() %>" name="projectRemark"   type="text" disabled/>
        </td>
    </tr>
    <tr>
    	<td class="table_td1">报价单位:</td><td colspan="3"><textarea onblur="ismaxlength(this)" name="priceUnit" id="priceUnit" style="height:30px;width:550px;" class="easyui-validatebox text w150" disabled><%=ebpProjectVo.getPriceUnit()==null?"":ebpProjectVo.getPriceUnit() %></textarea></td>
    </tr>
     <tr>
    	<td class="table_td1">备注:</td><td colspan="3"><textarea onkeypress="" onblur="ismaxlength(this)" name="comments" id="comments" style="height:70px;width:550px;" class="easyui-validatebox text w150" disabled><%=ebpProjectVo.getComments()==null?"":ebpProjectVo.getComments() %></textarea></td>
    </tr>
    <tr>
    	<td><input name="projectId" style="display:none;" value="<%=ebpProjectVo.getProjectId() %>" /></td>
    	<td><input  type="button" value="返回" onclick="javascript:top.close();" align="middle"/></td>
    </tr>
   </table>
    		
   </form>
    	

		<!-- 引入js包 -->
		<script type="text/javascript" src="<%=path %>/resources/js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript" src="<%=path %>/resources/easyui-1.3.6/locale/easyui-lang-zh_CN.js"></script>
		<script type="text/javascript" src="<%=path %>/resources/easyui-1.3.6/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="<%=path %>/resources/js/esourcing.js"></script>
		<script type="text/javascript" src="<%=path %>/resources/js/esourcing.util.js"></script>
		<script type="text/javascript" src="<%=path %>/resources/js/jquery.serializeJSON.js"></script>
		
		<!-- js脚本区 -->
		<script type="text/javascript">
		$(function(){	
			//var id=1;
			//alert(id);
			
			$("#subForm").click(function(){
		    console.log("test");
			esourcing.util.formSubmit("updateEbpProject");
			});
			
		});	
			
			
		</script>
		
  </body>
</html>
