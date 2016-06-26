package com.ceit.servlet;

import javax.servlet.http.HttpServlet;

import org.springframework.web.context.WebApplicationContext;

import com.ceit.common.cache.ebp.EBPDictCache;

public class CacheServiceInitServlet extends HttpServlet {

	private static final long serialVersionUID = -888253215875738374L;
	public static WebApplicationContext springContext = null;

	public void init() {
		// springContext=(WebApplicationContext)getServletContext().getAttribute("org.springframework.web.servlet.FrameworkServlet.CONTEXT.dispatcher");
		springContext = (WebApplicationContext) getServletContext()
				.getAttribute(
						"org.springframework.web.context.WebApplicationContext.ROOT");
		
		// 国家，地市的数据字段
		//GBT2260Cache.init();
		// 数据字典配置（下拉值等）
		EBPDictCache.init();
		// 系统配置 （文件上传路径，接口地址等）
		//ECTConfSysCurrentCache.init();
		
		//  ----------------  招标 ---------------
		// 招标流程定义配置
		//ECTConfCurrentCache.init();
		// 招标页签功能配置
		//ECTMainCtrlCache.init();
		// 页面名词定义
		//ECTLocPageContentCache.init();
//		ECTCNProjectConfCache.init();
		// ------------------- 主数据 ----------------
		// 主数据
		//ECTMdCategoryCache.init();
		//ECTMdMaterialCache.init();
		
		//  ----------------------- 专家模块 ----------------------
		//专家专业数据字典初始化
		//EPTSpecialtyCache.init();
//		//专家组织机构数据字典初始化
		//EPTOrgCache.init();
		
		//freemarker模板文件缓存初始化
//		SMTModelInfoCache.init();

	}
}
