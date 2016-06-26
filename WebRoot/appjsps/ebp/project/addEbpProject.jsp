<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>新增项目</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/css/common.css" />
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/easyui-1.3.6/themes/default/easyui.css"/>
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/easyui-1.3.6/themes/icon.css" />

  </head>
  
  <body>
    <form id="insertEbpProject" method="post" action="">
		<table class="table_common"  align="center" width="800px">
	
			<tr height="15%">
    			<th class="table_head" colspan="4" style="text-align:center;">新增采购项目信息</th>  	
    		</tr>
    		<tr >
       		 	<td class="table_td1">项目名称:</td><td><input style="height: 20" maxlength="32" name="projectName"  class="easyui-validatebox text w150" missingMessage="不能为空!"   validType="length[1,32]" invalidMessage="必须填写1-32个字符！" type="text" /></td>
        		<td class="table_td1">编码方式:</td>
        		<td>
        			<select class="easyui-combobox h20_w160" name="projectCode" editable="false"  panelHeight="auto"  >
        			</select>
        		</td>
    		</tr>
    		<tr >
        		<td class="table_td1">预算金额:</td><td><input style="height: 20" maxlength="32" class="easyui-validatebox text w150" missingMessage="不能为空!"  validType="length[1,32]" invalidMessage="必须填写1-32个字符！"  size="22" name="budgetMoney"  type="text"/></td>
        		<td class="table_td1">需求部门:</td>
    			<td >
           			<select id="isSelf" class="easyui-combobox h20_w160" name="needDepartmentId" editable="false"  panelHeight="auto"  >
					</select> 
        		</td>
    		</tr>
    		<tr >
   				<td class="table_td1">项目经理:</td>
   				<td>
         			<select class="easyui-combobox h20_w160" id="procurementMode"  name="projectManagerId" editable="false"  panelHeight="auto"   >
						<option value=""></option>
         			</select> 
       			</td>     
   				<td class="table_td1">项目描述:</td>
       			<td>
   					<select class="easyui-combobox h20_w160" name="projectRemark" editable="false" id="requesterUnitId" panelHeight="auto">
   					</select>
       			</td>
    		</tr>
    		<tr>
       			<td class="table_td1">招标年份:</td>
       			<td class="alt">
          				<select  class="easyui-combobox h20_w160" name="projectYear" editable="false"  panelHeight="auto"  >
						<option value=""></option>
         				</select> 
       			</td>
       			<td class="table_td1">公开/邀请:</td>
       			<td>
   					<select class="easyui-combobox h20_w160" name="isPublic" editable="false" id="requesterUnitManagerId" panelHeight="auto">
       				</select>
       			</td>
    		</tr>
    		<tr>
       			<td class="table_td1">中标规则:</td>
       			<td>
   					<select class="easyui-combobox h20_w160" name="winRule" editable="false"  panelHeight="auto"  >
              				<option value=""></option>
       				</select>
       			</td>
        			<td class="table_td1">招标项目创建人:</td>
   				<td class="alt">
          			<select class="easyui-combobox h20_w160"  name="creatorId" editable="false"  panelHeight="auto"  >
						<option value=""></option>
         			</select> 
       			</td>
    		</tr>
		    <tr >
		        <td class="table_td1">标书开始购买时间:</td><td><input id="budgetMoney" style="height: 20" class="easyui-datetimebox  calender_h_w"  name="startBuyTime" invalidMessage="只能输入数字!"  type="text" /></td>
		         <td class="table_td1">标书购买截至时间:</td>
		         <td class="alt">
		            <input class="easyui-datetimebox  calender_h_w" name="endBuyTime" value="" />
		         </td>
		    </tr>
		    
		     <tr>
		    	<td class="table_td1">截标时间:</td>
		    	<td>
		    		<input class="easyui-datetimebox  calender_h_w"  id="startTime" name="openBidTime"  editable="false"  panelHeight="auto"  type="text"/>
		        </td>
		        <td class="table_td1">开标时间:</td><td><input class="easyui-datetimebox  calender_h_w"  id="startTime" name="openBidTime"  editable="false"  panelHeight="auto"  type="text"/></td>
		    </tr>
		    <tr >
		    	<td class="table_td1">唱标时间:</td>
		        <td>
		    		<input class="easyui-datetimebox  calender_h_w"  id="startTime" name="openBidTime"  editable="false"  panelHeight="auto"  type="text"/>
		        </td>
		        <td class="table_td1">定标时间:</td><td><input class="easyui-datetimebox  calender_h_w"  id="stopTime" name="sureBidTime"  editable="false"  panelHeight="auto"  type="text" /></td>
		    </tr>
		    <tr>    	
		        <td class="table_td1">应答开始时间:</td><td class="alt"><input style="height: 20" maxlength="100"  name="replyStartTime" class="easyui-datetimebox  calender_h_w"  type="text" class="easyui-validatebox text w150"  validType="length[0,100]" invalidMessage="必须填写1-32个字符！"/></td>
		         <td class="table_td1">应答结束时间:</td><td><input style="height: 20" maxlength="100" name="replyStopTime"  type="text" class="easyui-datetimebox  calender_h_w"  validType="length[0,100]" invalidMessage="必须填写1-100个字符！"/></td>
		    </tr>
		     <tr id="time2">
		    	<td class="table_td1">预计截标时间:</td><td><input class="easyui-datebox  calender_h_w"  id="closeBidTime"  name="closeBidTime"  editable="false"  panelHeight="auto"     type="text"/></td>
		        <td class="table_td1">预计开始解密时间:</td><td><input class="easyui-datebox  calender_h_w"  id="startDecryptTime"  name="startDecryptTime"  editable="false"  panelHeight="auto"    type="text"/></td>
		    </tr>
		    <tr id="time3" >
		    	<td class="table_td1">预计开标时间:</td><td><input class="easyui-datebox  calender_h_w"  id="openBidTime" name="openBidTime"   editable="false"  panelHeight="auto"  type="text"/></td>
		        <td class="table_td1">预计定标时间:</td><td><input class="easyui-datebox  calender_h_w"  id="bidTime" name="bidTime"   editable="false"  panelHeight="auto"   type="text"/></td>
		    </tr>
		    <tr >
		        <td class="table_td1">预计标书购买截至时间:</td><td><input class="easyui-datebox  calender_h_w"   id="endBuyTime" name="endBuyTime" editable="false"  panelHeight="auto"  type="text"/></td>
		        <td class="table_td1">决策纪要下达时间:</td><td><input class="easyui-datebox  calender_h_w" id="decisionDownTime" name="decisionDownTime"   type="text" editable="false"  panelHeight="auto" /></td>
		    </tr>
		    <tr >
		        <td class="table_td1">是否需要资格认证:</td><td><input style="height: 20" maxlength="32"  name="isPrequalification"  type="text" class="easyui-validatebox text w150"   validType="length[0,32]" invalidMessage="请填写0-32个字符！"/></td>
		        <td class="table_td1">项目审核状态:</td><td><input style="height: 20" maxlength="32" name="projectAuditStatus"  type="text" class="easyui-validatebox text w150"  validType="length[0,32]" invalidMessage="请填写0-32个字符！"/></td>
		    </tr>
		    <tr id="time1">  	
		        <td class="table_td1">审核人编号:</td>
		        <td>
		    	<select class="easyui-combobox h20_w160" name="projectAuditId" editable="false"  panelHeight="auto"  >
		               <option value="" ></option>
		        </select>
		        </td>
		        <td class="table_td1">是否分标:</td><td><input  id="pubTime" name="备注"  editable="false"  panelHeight="auto"   type="text" /></td>
		    </tr>
		    <tr>
		    	<td class="table_td1">报价单位:</td><td colspan="3"><textarea maxlength="1000" onkeypress="" onblur="ismaxlength(this)" name="priceUnit" id="chooseBased" style="height:30px;width:550px;" class="easyui-validatebox text w150"></textarea></td>
		    </tr>
		     <tr>
		    	<td class="table_td1">备注:</td><td colspan="3"><textarea maxlength="1000" onkeypress="" onblur="ismaxlength(this)" name="isObject" id="remarkProject" style="height:70px;width:550px;" class="easyui-validatebox text w150"></textarea></td>
		    </tr>
		    <tr style="height:30px;"><td colspan="4" style="text-align:center;"><input id="subEbpProjectForm" class="easyui-linkbutton"  type="button" value="完成设置"/>
		    	<input  type="button" value="关闭" class="easyui-linkbutton" onclick="javascript:top.close();" /></td></tr>
</table>
</form>

	<script type="text/javascript" src="<%=path %>/resources/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/easyui-1.3.6/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/easyui-1.3.6/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/esourcing.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/esourcing.util.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/jquery.serializeJSON.js"></script>

<script type="text/javascript">
//<!--js书写区域	-->
	$(function(){

		$("#subEbpProjectForm").click(
				function(){
					$("#insertEbpProject").submit();
				}
			);
		$('#insertEbpProject').form({
			url : 'insertProject.action',
			onSubmit : function(){
			},
			success : function(data){
				var map=eval('('+data+')');//用eval函数将json转化为对象
				if(map.result == 'true'){
					alert("成功新增一个项目！");
					window.opener.location.href=window.opener.location.href;
					$("#subEbpProjectForm").attr({"disabled":"disabled"});
				}
			}
		});
		
	});
//<!--end	-->
</script>
  </body>
</html>
