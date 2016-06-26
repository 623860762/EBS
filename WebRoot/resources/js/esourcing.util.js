var esourcing   = esourcing || {};
esourcing.util  = esourcing.util || {};

$.extend(esourcing.util, {
  checkTime: function(time1){
    if(typeof time1 !== 'string')
      return time1;
    var str1 = time1.replace(/-/g,"/");
    return new Date(str1).getTime();
  },
//传入毫秒值，转成：2013-07-28
  formatD: function(date){
    return date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate();
  },
//传入毫秒值，转成：2013-07-28 12:21:20
  formatLongD: function(date) {
    return date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
  },
  isJqueryImported: function(){
	if(typeof(jQuery)=="undefined"){
		return "jQuery is not imported";
	}else{
		return "jQuery is imported";
	}
  },
//从新窗口打开页面
  goUrl: function(url){
	  window.open(url);
  },
//在父页面打开新页面
  goUrlSelf: function(url){
	  window.open(url,"_self");
  },
//关闭子页面，跳到父页面
  goUrlCloself: function(){
		window.opener.location.href=window.opener.location.href;
    	self.opener=null;
        self.close();
  },
  timeFormatter:function(val,row){
	  var date=new Date(val);
	  return date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate();
  },
//重载当前页面
  freshCurPage:function(){
	  window.location.reload();
  },
//0,1枚举类型
  yesNoFormatter:function(val,row){
	if(val== 0){
		return "否";
	}else if(val== 1){
		return "是";
	}else{
		return "";
	}
  },
//0,1,2枚举(公开招标0,中标公示1,澄清公告2,中标通知书3)
  TempStyleFormatter:function(val,row){
	if(val== 0){
		return "公开招标";
	}else if(val== 1){
		return "中标公示";
	}else if(val== 2){
		return "澄清公告";
	}else if(val== 3){
		return "中标通知书";
	}else{
		return "";
	}
  },
  //0,1,2枚举(公开招标0,中标公示1,澄清公告2,中标通知书3)
  TempStyleEdit:function(val){
	if(val== 0){
		return "公开招标";
	}else if(val== 1){
		return "中标公示";
	}else if(val== 2){
		return "澄清公告";
	}else if(val== 3){
		return "中标通知书";
	}else{
		return "";
	}
  },
  getSelected:function(datagridId,jsonId){
	  	var row = $('#'+datagridId).datagrid('getSelected');
	if (row){
		return row[jsonId];
	}
  },
  //datagridId:表格ID,jsonId:数据主键ID,获取选中行id,多个为id数组[]
  getSelections:function(datagridId,jsonId){
	var ss = [];
	var rows = $('#'+datagridId).datagrid('getSelections');
	for(var i=0; i<rows.length; i++){
		var row = rows[i];
		ss.push(row[jsonId]);
	}
	if (ss){
		return ss;
	}
  },
  isModalDialog:function(Obj){
	  	if(Obj && "yes"==Obj.isModalDialog){
			return true;
		}else{
			return false;
		}
  },
//又下角提示窗口，参数：标题、提示信息
  rightMessage:function(titleVal,msgVal){
		$.messager.show({
			title:titleVal,
			msg:msgVal,
			timeout:3000,
			showType:'slide'
		});
  },
  testAlert:function(){
	  alert("测试失败")
  },
//表单提交
  formSubmit: function(formId){
	  $("#"+formId).submit();
  },
  strToJson: function(str){
	  var json = eval('(' + str + ')'); 
	  return json; 
  }
});