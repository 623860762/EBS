<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.ceit.ebs.sup.vo.SupSupplierVo"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
SupSupplierVo supSupplierVo = new SupSupplierVo();
supSupplierVo = (SupSupplierVo)request.getAttribute("supSupplierVo");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>供应商详情</title>
    
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
    <form id="detailSupplier" method="post" >
		<table class="table_common"  align="center" width="800px">
	
			<tr height="15%">
    			<th class="table_head" colspan="4" style="text-align:center;" >供应商详情</th>  	
    		</tr>    		
    		<tr >
       		 	<td class="table_td1">供应商登录名称:</td><td><input value="<%=supSupplierVo.getUserName() %>" style="height: 20" maxlength="32" name="userName"  class="easyui-validatebox text w150" missingMessage="不能为空!"   validType="length[1,32]" invalidMessage="必须填写1-32个字符！" type="text" disabled/></td>
        		<td class="table_td1">供应商注册名称:</td><td><input value="<%=supSupplierVo.getSupplierName() %>" style="height: 20" maxlength="32" name="supplierName"  class="easyui-validatebox text w150" missingMessage="不能为空!"   validType="length[1,32]" invalidMessage="必须填写1-32个字符！" type="text" disabled/></td>
    		</tr>
    		<tr >
        		<td class="table_td1">机构类型:</td>
        		<td >
           			<select id="companyType" class="easyui-combobox h20_w160" name="companyType" editable="false"  panelHeight="auto"  disabled>
           			<option selected="selected"><%=supSupplierVo.getCompanyType() %></option>
           			<option value="1 ">企业单位</option>
           			<option value="2 ">事业单位</option>
           			<option value="3">自然人</option>
           			<option value="4">个体户</option>
           			<option value="5">社会团体</option>
           			<option value="6">其他组织机构</option>
					</select> 
        		</td>
        		<td class="table_td1">公司性质:</td>
    			<td >
           			<select id="companyProperty" class="easyui-combobox h20_w160" name="companyProperty" editable="false"  panelHeight="auto" disabled >
					<option value="1">国有企业</option>
           			<option value="2">民营企业</option>
           			<option value="3">外商独资（含港澳台）</option>
           			<option value="4">中外合资 </option>
           			<option value="5">境外企业</option>
           			<option value="6">集体所有制企业</option>
           			<option value="7">其他企业</option>
           			<%=supSupplierVo.getCompanyProperty() %>
					</select> 
        		</td>
    		</tr>
    		<tr >
    				<td class="table_td1">供应商类别编码:</td>
    				<td>
          				<select class="easyui-combobox h20_w160" id="supplierTypeCode"  name="supplierTypeCode" editable="false"  panelHeight="auto"  disabled >
							<option value="1">产品供应商</option>
							<option value="2">工程（劳务）分包商</option>
							<option value="3">服务供应商</option>
							<%=supSupplierVo.getSupplierTypeCode()%>
          				</select> 
        			</td>     
    				<td class="table_td1">单位划分:</td>
        			<td>
    					<select class="easyui-combobox h20_w160" name="unitDivide" editable="false" id="unitDivide" panelHeight="auto" disabled>
    					<option value="0">外部单位</option>
    					<option value="1">内部单位</option>
    					<%=supSupplierVo.getUnitDivide() %>
    					</select>
        			</td>
    		</tr>
    		<tr>
        			<td class="table_td1">企业英文名称:</td>
        			<td><input value="<%=supSupplierVo.getEnglishName()==null?"":supSupplierVo.getEnglishName() %>" onkeyup="value=value.replace(/[^\w\.\/]/ig,'')" style="height: 20" maxlength="32" name="englishName"  class="easyui-validatebox text w150"   validType="length[1,32]" invalidMessage="必须填写1-32个字符！" type="text" disabled/></td>
        			<td class="table_td1">企业简称:</td>
        			<td><input value="<%=supSupplierVo.getShortName()==null?"":supSupplierVo.getShortName() %>" style="height: 20" maxlength="32" name="shortName"  class="easyui-validatebox text w150"   validType="length[1,32]" invalidMessage="必须填写1-32个字符！" type="text" disabled/></td>
        	</tr>
    		<tr>
        			<td class="table_td1">企业网址:</td>
        			<td><input value="<%=supSupplierVo.getWebSite()==null?"":supSupplierVo.getWebSite() %>" onkeyup="value=value.replace(/[^\w\.\/]/ig,'')" style="height: 20" maxlength="32" name="webSite"  class="easyui-validatebox text w150"   validType="length[1,32]" invalidMessage="必须填写1-32个字符！" type="text" disabled/></td>
           			<td class="table_td1">法人姓名:</td>
    				<td><input value="<%=supSupplierVo.getCorporationName()==null?"":supSupplierVo.getCorporationName() %>" style="height: 20" maxlength="32" name="corporationName"  class="easyui-validatebox text w150"   validType="length[1,32]" invalidMessage="必须填写1-32个字符！" type="text" disabled/></td>
    		</tr>
		    <tr >
		        <td class="table_td1">法人证件类型:</td>
		        <td><input value="<%=supSupplierVo.getCertificateType() %>" style="height: 20" class="easyui-numberbox text w150"  name="certificateType" validType="length[1,32]" invalidMessage="必须填写1-32个字符！"  type="text" disabled/></td>
		        <td class="table_td1">法人证件号码:</td>
		        <td><input value="<%=supSupplierVo.getCertificateCode()==null?"":supSupplierVo.getCertificateCode() %>" onkeyup="value=value.replace(/[^\w\.\/]/ig,'')" style="height: 20" maxlength="32" name="certificateCode"  class="easyui-validatebox text w150"   validType="length[1,32]" invalidMessage="必须填写1-32个字符！" type="text" disabled/></td>
		    </tr>	    
	       <tr>
	    	<td class="table_td1">组织机构代码:</td>
	    	<td><input value="<%=supSupplierVo.getOrgNo() %>" style="height: 20" class="easyui-numberbox text w150"  name="orgNo" validType="length[1,32]" invalidMessage="必须填写1-32个字符！"  type="text" disabled/></td>
	        <td class="table_td1">营业执照注册号:</td>
	        <td><input value="<%=supSupplierVo.getLicenceNo() %>" style="height: 20" class="easyui-numberbox text w150"  name="licenceNo" validType="length[1,32]" invalidMessage="必须填写1-32个字符！"  type="text" disabled/></td>
	      </tr>
	    <tr >
	    	<td class="table_td1">营业执照签发日期:</td>
	        <td><input value="<%=supSupplierVo.getLicenceSignDate() %>" class="easyui-datebox  calender_h_w"  id="licenceSignDate" name="licenceSignDate"   editable="false"  panelHeight="auto"  type="text" disabled/></td>
	        <td class="table_td1">批准文号:</td>
	        <td><input value="<%=supSupplierVo.getRatifyNumber() %>" style="height: 20" class="easyui-numberbox text w150"  name="ratifyNumber" validType="length[1,32]" invalidMessage="必须填写1-32个字符！"  type="text" disabled/></td>
	      </tr>
	    <tr>    	
	        <td class="table_td1">工商登记号:</td>
	        <td><input value="<%=supSupplierVo.getBusinessNumber() %>" style="height: 20" class="easyui-numberbox text w150"  name="businessNumber" validType="length[1,32]" invalidMessage="必须填写1-32个字符！"  type="text" disabled/></td>
	        <td class="table_td1">国税税务号:</td>
	        <td><input value="<%=supSupplierVo.getNationalTax() %>" style="height: 20" class="easyui-numberbox text w150"  name="nationalTax" validType="length[1,32]" invalidMessage="必须填写1-32个字符！"  type="text" disabled/></td>
	      </tr>
	     <tr>
	    	<td class="table_td1">地税税务号:</td>
	    	<td><input value="<%=supSupplierVo.getDistrictTax() %>" style="height: 20" class="easyui-numberbox text w150"  name="districtTax" validType="length[1,32]" invalidMessage="必须填写1-32个字符！"  type="text" disabled/></td>
	        <td class="table_td1">公司组织结构图文件字典值:</td>
	        <td><input value="<%=supSupplierVo.getOrgStructFileCode() %>" style="height: 20" class="easyui-numberbox text w150"  name="orgStructFileCode" validType="length[1,32]" invalidMessage="必须填写1-32个字符！"  type="text" disabled/></td>
	      </tr>
	      <tr>
	    	<td class="table_td1">营业执照证扫描件字典值:</td>
	    	<td><input value="<%=supSupplierVo.getLicenceFileCode() %>" style="height: 20" class="easyui-numberbox text w150"  name="licenceFileCode" validType="length[1,32]" invalidMessage="必须填写1-32个字符！"  type="text" disabled/></td>
	        <td class="table_td1">营业执照最新年检时间:</td>
	        <td><input value="<%=supSupplierVo.getLicenceYearcheckDate() %>" class="easyui-datebox  calender_h_w"  id="licenceYearcheckDate" name="licenceYearcheckDate"   editable="false"  panelHeight="auto"  type="text" disabled/></td>
	        </tr>
	    <tr>
	    	<td class="table_td1">营业执照证（副本）到期时间:</td>
	    	<td><input value="<%=supSupplierVo.getLicenceFilePassdate() %>" class="easyui-datebox  calender_h_w"  id="licenceFilePassdate" name="licenceFilePassdate"   editable="false"  panelHeight="auto"  type="text" disabled/></td>
	        <td class="table_td1">组织机构代码证扫描件字典值:</td>
	        <td><input value="<%=supSupplierVo.getOrganFileCode() %>" style="height: 20" class="easyui-numberbox text w150"  name="organFileCode" validType="length[1,32]" invalidMessage="必须填写1-32个字符！"  type="text"  disabled/></td>
	    </tr>
	    <tr >
	        <td class="table_td1">组织机构代码证年检时间:</td>
	        <td><input value="<%=supSupplierVo.getOrganFilePassdate() %>" class="easyui-datebox  calender_h_w"  id="organFilePassdate" name="organFilePassdate"   editable="false"  panelHeight="auto"  type="text" disabled/></td>
	        <td class="table_td1">税务登记证（扫描件）字典值:</td>
	        <td><input value="<%=supSupplierVo.getTaxregFileCode()==null?"":supSupplierVo.getTaxregFileCode() %>" style="height: 20" maxlength="32" name="taxregFileCode"  type="text" class="easyui-validatebox text w150"  validType="length[0,32]" invalidMessage="请填写0-32个字符！" disabled/></td>
	    </tr>
	    <tr >
	        <td class="table_td1">税务登记证(正本)到期时间:</td>
	        <td><input value="<%=supSupplierVo.getTaxregFilePassdate() %>" class="easyui-datebox  calender_h_w"  id="taxregFilePassdate" name="taxregFilePassdate"   editable="false"  panelHeight="auto"  type="text" disabled/></td>
	        <td class="table_td1">联系人:</td>
	        <td><input value="<%=supSupplierVo.getContactMan()==null?"":supSupplierVo.getContactMan() %>" style="height: 20" maxlength="32" name="contactMan"  type="text" class="easyui-validatebox text w150"  validType="length[0,32]" invalidMessage="请填写0-32个字符！" disabled/></td>
	    </tr>
	    <tr>    	
	        <td class="table_td1">联系人电话:</td>
	        <td><input value="<%=supSupplierVo.getContactManTel() %>" onkeyup="value=value.replace(/[^\d]/g,'') "onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" 
	        style="height: 20" class="easyui-numberbox text w150"  name="contactManTel" validType="length[1,32]" invalidMessage="必须填写1-32个字符！"  type="text" disabled/></td>
	        <td class="table_td1">联系人邮箱:</td>
	        <td><input value="<%=supSupplierVo.getContactManEmail()==null?"":supSupplierVo.getContactManEmail() %>" onkeyup="value=value.replace(/[^\w\.\/]/ig,'')" style="height: 20" maxlength="32" name="contactManEmail"  class="easyui-validatebox text w150"   validType="length[1,32]" invalidMessage="必须填写1-32个字符！" type="text" disabled/></td>
		 </tr>
	     <tr>    	
	        <td class="table_td1">注册资金（单位：万元）:</td>
	        <td><input value="<%=supSupplierVo.getRegCapital() %>" style="height: 20" class="easyui-numberbox text w150"  name="regCapital" validType="length[1,32]" invalidMessage="必须填写1-32个字符！"  type="text" disabled/></td>
	        <td class="table_td1">是否是代理商:</td>
	        <td><input value="<%=supSupplierVo.getIsAgent() %>" style="height: 20" class="easyui-numberbox text w150"  name="isAgent" validType="length[1,32]" invalidMessage="必须填写1-32个字符！"  type="text" disabled/></td>
	      </tr>
	      <tr>
	    	<td class="table_td1">营业期限时间:</td>
	    	<td><input value="<%=supSupplierVo.getBuinessLimitDate() %>" class="easyui-datebox  calender_h_w"  id="buinessLimitDate" name="buinessLimitDate"   editable="false"  panelHeight="auto"  type="text" disabled/></td>
	        <td class="table_td1">主营业务:</td>
	        <td><input value="<%=supSupplierVo.getMainBusinessName() %>" style="height: 20" class="easyui-numberbox text w150"  name="mainBusinessName" validType="length[1,32]" invalidMessage="必须填写1-32个字符！"  type="text" disabled/></td>
	    </tr>
	     <tr>    	
	        <td class="table_td1">注册省:</td>
	        <td><input value="<%=supSupplierVo.getRegProvince() %>" style="height: 20" class="easyui-numberbox text w150"  name="regProvince" validType="length[1,32]" invalidMessage="必须填写1-32个字符！"  type="text" disabled/></td>
	        <td class="table_td1">注册市:</td>
	        <td><input value="<%=supSupplierVo.getRegCity() %>" style="height: 20" class="easyui-numberbox text w150"  name="regCity" validType="length[1,32]" invalidMessage="必须填写1-32个字符！"  type="text" disabled/></td>
	      </tr>
	     <tr>    	
	        <td class="table_td1">注册区:</td>
	        <td><input value="<%=supSupplierVo.getRegArea() %>" style="height: 20" class="easyui-numberbox text w150"  name="regArea" validType="length[1,32]" invalidMessage="必须填写1-32个字符！"  type="text" disabled/></td>
	        <td class="table_td1">注册地址:</td>
	        <td><input value="<%=supSupplierVo.getRegAddress() %>" style="height: 20" class="easyui-numberbox text w150"  name="regAddress" validType="length[1,32]" invalidMessage="必须填写1-32个字符！"  type="text" disabled/></td>
	    </tr>
	     <tr>    	
	        <td class="table_td1">注册地址区邮编:</td>
	        <td><input value="<%=supSupplierVo.getRegAddressPostcode() %>" onkeyup="value=value.replace(/[^\d]/g,'') "onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" 
	        style="height: 20" class="easyui-numberbox text w150"  name="regAddressPostcode" validType="length[1,32]" invalidMessage="必须填写1-32个字符！"  type="text" disabled/></td>
	        <td class="table_td1">注册地址区号:</td>
	        <td><input value="<%=supSupplierVo.getRegAddressNo() %>" onkeyup="value=value.replace(/[^\d]/g,'') "onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" 
	        style="height: 20" class="easyui-numberbox text w150"  name="regAddressNo" validType="length[1,32]" invalidMessage="必须填写1-32个字符！"  type="text" disabled/></td>
	     </tr>
	     <tr>    	
	        <td class="table_td1">成立时间:</td>
	        <td><input value="<%=supSupplierVo.getFundationDate() %>" class="easyui-datebox  calender_h_w"  id="fundationDate" name="fundationDate"   editable="false"  panelHeight="auto"  type="text" disabled/></td>
	        <td class="table_td1">固定电话:</td>
	        <td><input value="<%=supSupplierVo.getTelPhone() %>" onkeyup="value=value.replace(/[^\d]/g,'') "onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" 
	        style="height: 20" class="easyui-numberbox text w150"  name="telPhone" validType="length[11]" invalidMessage="必须填写11个数字！"  type="text" disabled/></td>
	     </tr>    
	     <tr>
	        <td class="table_td1">传真:</td>
	        <td><input value="<%=supSupplierVo.getTelFax() %>" onkeyup="value=value.replace(/[^\d]/g,'') "onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" 
	        style="height: 20" class="easyui-numberbox text w150"  name="telFax" validType="length[1,20]" invalidMessage="必须填写1-20个字符！"  type="text" disabled/></td>
	        <td class="table_td1">审核状态:</td>
	        <td>
    			<select class="easyui-combobox h20_w160" name="auditStatus" editable="false" id="unitDivide" panelHeight="auto" disabled>
                <option value="0">待审核</option>
    			<option value="1">审核不通过</option>
    			<option value="2">审核通过</option>
    			<%=supSupplierVo.getAuditStatus() %>
    		    </select>
        	</td>
	     </tr>
	      <tr>
	    	<td class="table_td1">审核备注:</td><td colspan="3"><textarea  maxlength="1000" onkeypress="" onblur="ismaxlength(this)" name="auditTips" id="auditTips" style="height:30px;width:550px;" class="easyui-validatebox text w150" disabled><%=supSupplierVo.getAuditTips() %></textarea></td>
	    </tr>
	    <tr>
	    	<td class="table_td1">经营范围:</td><td colspan="3"><textarea  maxlength="1000" onkeypress="" onblur="ismaxlength(this)" name="businessScope" id="businessScope" style="height:30px;width:550px;" class="easyui-validatebox text w150" disabled><%=supSupplierVo.getBusinessScope() %></textarea></td>
	    </tr>
	     <tr>
	    	<td class="table_td1">备注:</td><td colspan="3"><textarea maxlength="1000" onkeypress="" onblur="ismaxlength(this)" name="remarks" id="remarks" style="height:70px;width:550px;" class="easyui-validatebox text w150" disabled><%=supSupplierVo.getRemarks() %></textarea></td>
	    </tr>
	     
	    <tr style="height:30px;"><td colspan="4" style="text-align:center;">
	    	<input  type="button" value="返回"  onclick="javascript:top.close();" /></td></tr>
</table>
</form>

	<script type="text/javascript" src="<%=path %>/resources/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/easyui-1.3.6/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/easyui-1.3.6/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/esourcing.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/esourcing.util.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/jquery.serializeJSON.js"></script>


  </body>
</html>
