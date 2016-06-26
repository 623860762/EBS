<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.ceit.common.util.StaticSource"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
  	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>招标投标交易平台</title>
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/easyui-1.3.6/themes/default/easyui.css"/>
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/easyui-1.3.6/themes/icon.css" />
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/css/default.css" />
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/css/common.css" />
	
	</head>
    <body class="easyui-layout" style="overflow-y: hidden"  scroll="no">
    	<noscript>
			<div style=" position:absolute; z-index:100000; height:2046px;top:0px;left:0px; width:100%; background:white; text-align:center;">
    			<img src="resources/images/noscript.gif" alt='抱歉，请开启脚本支持！' />
			</div>
		</noscript>
		<div region="north" split="true" border="false"
			style="overflow: hidden; height: 30px; background: url(resources/images/layout-browser-hd-bg.gif) #7f99be repeat-x center 50%; line-height: 20px; color: #fff; font-family: Verdana, 微软雅黑, 黑体">
			<span style="float: right; padding-right: 20px;" class="head">欢迎
				招标投标交易平台 <a href="#" id="editpass">修改密码</a> <a href="#" id="loginOut">安全退出</a>
			</span>

			<span style="padding-left: 10px; font-size: 16px; float: left;"><img
					src="resources/images/blocks.gif" width="20" height="20" align="absmiddle" />
				CEIT</span>
			<div id="menu_div" style="width:100%;"></div>
		</div>
		<div region="south" split="true"
			style="height: 30px; background: #D2E0F2;">
			<div class="footer">
				Copyright&copy;&nbsp;2014 CEIT.&nbsp;All Rights Reserved.
			</div>
		</div>
		<div region="west" hide="true" split="true" title="导航菜单"
			style="width: 200px;" id="west">
			<div id='wnav' class="easyui-accordion" fit="true" border="false">
			</div>
			
		</div>
		<div id="mainPanle" region="center"
			style="background: #eee; overflow-y: hidden">
			<div id="tabs" class="easyui-tabs" fit="true" border="false">
				<div title="欢迎使用" style="padding: 20px; overflow: hidden;" id="home">

					<h1>
						Welcome to using The jQuery EasyUI!
					</h1>

				</div>
			</div>
		</div>
		
		<div id="mm" class="easyui-menu" style="width:150px;">
		<div id="mm-tabupdate">刷新</div>
		<div class="menu-sep"></div>
		<div id="mm-tabclose">关闭</div>
		<div id="mm-tabcloseall">全部关闭</div>
		<div id="mm-tabcloseother">除此之外全部关闭</div>
		<div class="menu-sep"></div>
		<div id="mm-tabcloseright">当前页右侧全部关闭</div>
		<div id="mm-tabcloseleft">当前页左侧全部关闭</div>
		<div class="menu-sep"></div>
		<div id="mm-exit">退出</div>
	</div>
	
	<script type="text/javascript" src="<%=path %>/resources/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/easyui-1.3.6/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/easyui-1.3.6/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/esourcing.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/esourcing.util.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/jquery.serializeJSON.js"></script>
	<script type="text/javascript">
		$(function(){
			var mainMenu;
			var parentId = 1;
			$.ajax({
				type:'POST',
				url: "getMenuData.action",
				data: "parentId=" + parentId,
				dataType: "json",
				success:function(data){
					mainMenu = eval(data);
					for(var i=0; i<mainMenu.length; i++){
						$("#menu_div").append("<a onclick='toolMenu(" + mainMenu[i].id + ");return false' style='margin-left:13px;'>"+mainMenu[i].name+"</a>");
					}
					addMenu(2);
					var panel = $('#wnav').accordion("panels");
				}
			});
			tabClose()
			tabCloseEven()
		});
		
		function addMenu(parentId){
			$.ajax({
				type:'POST',
				url: "getMenuData.action",
				data: "parentId="+parentId,
				dataType: "json",
				success:function(data){
					$.each(eval(data),function(i,item){
						var id = item.id;
						$('#wnav').accordion('add',{
							title : item.name,
							selected : true,
							content : "<ul id='tree"+id+"' ></ul>"
						});
						$.parser.parse();
						$.ajax({
							type:'POST',
							async:false,
							url: "getMenuForTree.action",
							data: "parentId="+id,
							dataType: "json",
							success:function(data){
								$("#tree" + id).tree({
								data: eval(data),
								onBeforeExpand:function(node,param){ 
				                   $("#tree" + id).tree('options').url = "getMenuForTree.action?parentId=" + node.id;
				                },
				                onClick : function(node){ 
				                	if (node.state == 'closed'){
				                     	$(this).tree('expand', node.target);  
				                    }else if (node.state == 'open'){  
				                     	$(this).tree('collapse', node.target);  
				                    }
				                    if($(this).tree('isLeaf', node.target)){
				                    	if(node.attributes.url !== null && node.attributes.url !== undefined && node.attributes.url !== '' ){
				                    		addTab(node.text, node.attributes.url, node.attributes.icon, node.id);
				                    	}else{
				                    		alert("尚未配置菜单路径!");
				                    	}
				                    }
				                }
							});
							}
						});
					});
				}
			});
		}
			
		
	    function toolMenu(menuId){
			Clearnav();
			addMenu(menuId);
		};
		
		function Clearnav() {
			var pp = $('#wnav').accordion('panels');
			var length = pp.length;
			for(var i=0; i< length; i++){
				t = pp[0].panel('options').title;
				$('#wnav').accordion('remove', t);
			}
		};
		
		function addTab(subtitle, url, icon, id) {
			if (!$('#tabs').tabs('exists', subtitle)) {
				$('#tabs').tabs('add', {
					title : subtitle,
					content : createFrame(url),
					closable : true,
					icon : icon
				});
			} else {
				$('#tabs').tabs('select', subtitle);
				$('#mm-tabupdate').click();
			}
			tabClose();
		}
		
		function createFrame(url) {
			var s = '<iframe scrolling="auto" frameborder="0"  src="' + url + '" style="width:100%;height:100%;"></iframe>';
			return s;
		}
		
		function tabClose() {
			/* 双击关闭TAB选项卡 */
			$(".tabs-inner").dblclick(function() {
				var subtitle = $(this).children(".tabs-closable").text();
				$('#tabs').tabs('close', subtitle);
			});
			/* 为选项卡绑定右键 */
			$(".tabs-inner").bind('contextmenu', function(e) {
				$('#mm').menu('show', {
					left : e.pageX,
					top : e.pageY
				});
				var subtitle = $(this).children(".tabs-closable").text();
		
				$('#mm').data("currtab", subtitle);
				$('#tabs').tabs('select', subtitle);
				return false;
			});
		}
		
		// 绑定右键菜单事件
		function tabCloseEven() {
			// 刷新
			$('#mm-tabupdate').click(function() {
				var currTab = $('#tabs').tabs('getSelected');
				var url = $(currTab.panel('options').content).attr('src');
				$('#tabs').tabs('update', {
					tab : currTab,
					options : {
						content : createFrame(url)
					}
				});
			});
			// 关闭当前
			$('#mm-tabclose').click(function() {
				var currtab_title = $('#mm').data("currtab");
				$('#tabs').tabs('close', currtab_title);
			});
			// 全部关闭
			$('#mm-tabcloseall').click(function() {
				$('.tabs-inner span').each(function(i, n) {
					var t = $(n).text();
					$('#tabs').tabs('close', t);
				});
			});
			// 关闭除当前之外的TAB
			$('#mm-tabcloseother').click(function() {
				$('#mm-tabcloseright').click();
				$('#mm-tabcloseleft').click();
			});
			// 关闭当前右侧的TAB
			$('#mm-tabcloseright').click(function() {
				var nextall = $('.tabs-selected').nextAll();
				if (nextall.length == 0) {
					return false;
				}
				nextall.each(function(i, n) {
					var t = $('a:eq(0) span', $(n)).text();
					$('#tabs').tabs('close', t);
				});
				return false;
			});
			// 关闭当前左侧的TAB
			$('#mm-tabcloseleft').click(function() {
				var prevall = $('.tabs-selected').prevAll();
				if (prevall.length == 0) {
					return false;
				}
				prevall.each(function(i, n) {
					var t = $('a:eq(0) span', $(n)).text();
					$('#tabs').tabs('close', t);
				});
				return false;
			});
		
			// 退出
			$("#mm-exit").click(function() {
				$('#mm').menu('hide');
			});
		}
		
	  </script>
	</body>
</html>
