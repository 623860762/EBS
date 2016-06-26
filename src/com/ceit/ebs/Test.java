package com.ceit.ebs;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.dao.impl.TableDao;
import com.ceit.ebs.md.service.impl.MdFeatService;
import com.ceit.ebs.md.vo.MdFeatVo;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ITableDao td = new TableDao();
		
		/*
		 * 其它测试用例
		 * 以测试MdFeatService为例
		 * @author lcy
		 */
		MdFeatService mdFeatService = new MdFeatService();//要在MdFeatService中加入一个构造方法
		mdFeatService.setTableDao(td);
		MdFeatVo srv = new MdFeatVo();
		srv.setAliasName("sa");
		srv.setCategoryId("321");
		mdFeatService.insertMdFeat(srv);//插入数据
		System.out.println(mdFeatService.getMdFeatbyCategoryId("321").get(1).getAliasName());//根据Code查找分类
		
		
		
		/*
		 * 其它测试用例
		 * 以测试MdCategoryService为例
		 * @author lcy
		 */
		
//		MdCategoryService mdCategoryService = new MdCategoryService();//要在MdCategoryService中加入一个构造方法
//		mdCategoryService.setTableDao(td);
//		MdCategoryVo srv = new MdCategoryVo();
//		srv.setId(2);
//		srv.setCode("321");
//		srv.setParentId(123);
//		mdCategoryService.insertMdCategory(srv);//插入数据
//		System.out.println(mdCategoryService.getCount());
//		System.out.println(mdCategoryService.querydata(0, 3).get(0).getAttachmentId());
//		srv.setUserName("654");
//		System.out.println("MdCategoryService.modify="+mdCategoryService.modifyMdCategory(srv));//修改数据
		
//		System.out.println("MdCategoryService.getList="+mdCategoryService.getListByParentId(123).getClass());//查询数据
//		System.out.println("MdCategoryService.getListSize="+mdCategoryService.getListSizeByParentId(123));//查询对应id的数据数目
		
//		System.out.println("MdCategoryService.delete="+mdCategoryService.deleteMdCategorybyId(1));//删除数据
		
//		System.out.println("MdCategoryService.delete="+mdCategoryService.delObjsByIds("7"));//根据多个id删除数据
		
//		System.out.println("MdCategoryService.getList="+mdCategoryService.getObjList(0, 2, 123));//分页查找
		
//		List<MdCategory> md=mdCategoryService.getObjList(0, 3, 123).getEntityList();
//		System.out.println("MdCategoryService.getList="+md.get(1).getParentId());//根据parentId分页查找
		
//		System.out.println(mdCategoryService.getMdCategorybyCode("321").get(0).getId());//根据Code查找分类
		
		
		
		
		
		
		
		
		
		/*
		 * 其它测试用例
		 * 以测试EbpClearReplyService为例
		 * @author gr
		 */
		
//		EbpClearReplyService ebpClearReplyService = new EbpClearReplyService(td);//要在EbpClearReplyService中加入一个构造方法
//		EbpClearReplyVo srv = new EbpClearReplyVo();
//		srv.setId(1);
//		srv.setAttachmentId(12345);
//		ebpClearReplyService.insertEbpClearReply(srv);
//		System.out.println(ebpClearReplyService.getCount());
//		System.out.println(ebpClearReplyService.querydata(0, 3).get(0).getAttachmentId());
//		srv.setClearId(654);
//		System.out.println("EbpClearReplyService.modify="+ebpClearReplyService.modifyEbpClearReply(srv));
//		System.out.println("EbpClearReplyService.delete="+ebpClearReplyService.deleteEbpClearReplybyId(1));
		
		
//		/*
//		 * 其它测试用例
//		 * 以测试EbpClearService为例
//		 * @author gr
//		 */
//		
//		EbpClearService ebpClearService = new EbpClearService(td);//要在EbpClearService中加入一个构造方法
//		EbpClearVo srv = new EbpClearVo();
//		srv.setId(1);
//		srv.setApprovalContent("sa");
//		ebpClearService.insertEbpClear(srv);
//		System.out.println(ebpClearService.getCount());
//		System.out.println(ebpClearService.querydata(0, 3).get(0).getApprovalContent());
//		srv.setApprovalMan("sani");
//		System.out.println("EbpClearService.modify="+ebpClearService.modifyEbpClear(srv));
//		System.out.println("EbpClearService.delete="+ebpClearService.deleteEbpClearbyId(1));
		
//		/*
//		 * 其它测试用例
//		 * 以测试SysUserService为例
//		 * @author gr
//		 */
//		
//		SysUserService sysUserService = new SysUserService(td);//要在SysUserService中加入一个构造方法
//		SysUserVo srv = new SysUserVo();
//		srv.setId(1);
//		srv.setAccountStatus("sa");
//		sysUserService.insertSysUser(srv);
//		System.out.println(sysUserService.getCount());
//		System.out.println(sysUserService.querydata(0, 3).get(0).getAccountStatus());
//		srv.setComment("12345");
//		System.out.println("SysUserService.modify="+sysUserService.modifySysUser(srv));
////		System.out.println("SysUserService.delete="+sysUserService.deleteSysUserbyId(2));
		
//		/*
//		 * 其它测试用例
//		 * 以测试SysRoleResourceService为例
//		 * @author gr
//		 */
//		
//		SysRoleResourceService sysRoleResourceService = new SysRoleResourceService(td);//要在SysRoleResourceService中加入一个构造方法
//		SysRoleResourceVo srv = new SysRoleResourceVo();
//		srv.setId(1);
//		srv.setResourceId(123456);
//		sysRoleResourceService.insertSysRoleResource(srv);
//		System.out.println(sysRoleResourceService.getCount());
//		System.out.println(sysRoleResourceService.querydata(0, 3).get(0).getResourceId());
//		srv.setRoleId(12345);
//		System.out.println("SysRoleResourceService.modify="+sysRoleResourceService.modifySysRoleResource(srv));
////		System.out.println("SysRoleResourceService.delete="+sysRoleResourceService.deleteSysRoleResourcebyId(2));
		
//		/*
//		 * 其它测试用例
//		 * 以测试EptExtractionProgramService为例
//		 * @author gr
//		 */
//		
//		EptExtractionProgramService eptExtractionProgramService = new EptExtractionProgramService(td);//要在EptExtractionProgramService中加入一个构造方法
//		EptExtractionProgramVo srv = new EptExtractionProgramVo();
//		srv.setId(1);
//		srv.setExpertArea("EptEoService");
//		eptExtractionProgramService.insertEptExtractionProgram(srv);
//		System.out.println(eptExtractionProgramService.getCount());
//		System.out.println(eptExtractionProgramService.querydata(0, 3).get(0).getExpertArea());
//		srv.setActualExtractionNum("12345");
//		srv.setExpertAvoidArea("1");
//		System.out.println("EptExtractionProgramService.modify="+eptExtractionProgramService.modifyEptExtractionProgram(srv));
////		System.out.println("EptExtractionProgramService.delete="+eptExtractionProgramService.deleteEptExtractionProgrambyId(2));

		
//		/*
//		 * 其它测试用例
//		 * 以测试EptExtractionNameListService为例
//		 * @author gr
//		 */
//		
//		EptExtractionNameListService eptExtractionNameListService = new EptExtractionNameListService(td);//要在EptExtractionNameListService中加入一个构造方法
//		EptExtractionNameListVo srv = new EptExtractionNameListVo();
//		srv.setId(1);
//		srv.setExpertNotify("EptEoService");
//		eptExtractionNameListService.insertEptExtractionNameList(srv);
//		System.out.println(eptExtractionNameListService.getCount());
//		System.out.println(eptExtractionNameListService.querydata(0, 3).get(0).getExpertNotify());
//		srv.setEptExpertBaseinfo(12345);
//		srv.setExpertUnit("1");
//		System.out.println("EptExtractionNameListService.modify="+eptExtractionNameListService.modifyEptExtractionNameList(srv));
////		System.out.println("EptExtractionNameListService.delete="+eptExtractionNameListService.deleteEptExtractionNameListbyId(3));

		
		/*
		 * 其它测试用例
		 * 以测试ebeGroupPackageService为例
		 * @author gr
		 */

//		EbePackageInfoService ebePackageInfoService = new EbePackageInfoService(td);//要在EbePackageInfoService中加入一个构造方法
//		EbePackageInfoVo egv = new EbePackageInfoVo();
//		egv.setPackageName("EbePackageInfoService");
//		System.out.println(ebePackageInfoService.insertEbePackageInfo(egv));
//		System.out.println(ebePackageInfoService.getCount());
//		System.out.println(ebePackageInfoService.querydata(0, 3).get(0).getPackageName());
//		egv.setPackageId(4);
//		egv.setId(2);
//		System.out.println("EbePackageInfoService.modife="+ebePackageInfoService.modifyEbePackageInfo(egv));
//		System.out.println("EbePackageInfoService.delete="+ebePackageInfoService.deleteEbePackageInfobyId(1));
		

//		/*
//		 * 其它测试用例
//		 * 以测试EbeProviderPackageService为例
//		 * @author czg
//		 */
//		EbeProviderPackageService ebeProviderPackageService = new EbeProviderPackageService(td);//要在EbeProviderPackageService中加入一个构造方法
//		EbeProviderPackageVo eppv = new EbeProviderPackageVo();
//		eppv.setPackageName("EbeProviderPackageService");
//		System.out.println(ebeProviderPackageService.insertEbeProviderPackage(eppv));
//		System.out.println(ebeProviderPackageService.getCount());
//		System.out.println(ebeProviderPackageService.querydata(0, 3).get(0).getPackageName());
//		eppv.setPackageId(4);
//		eppv.setId(2);
//		System.out.println("EbeProviderPackageService.modife="+ebeProviderPackageService.modifyEbeProviderPackage(eppv));
//		System.out.println("EbeProviderPackageService.delete="+ebeProviderPackageService.deleteEbeProviderPackagebyId(1));
		

		/*
		 * 其它测试用例
		 * 以测试EbeRepealService为例
		 * @author czg
		 */
//		EbeRepealService ebeRepealService = new EbeRepealService(td);//要在EbeRepealService中加入一个构造方法
//		EbeRepealVo epv = new EbeRepealVo();
//		epv.setRepealResoun("EbeRepealService");
//		System.out.println(ebeRepealService.insertEbeRepeal(epv));
//		System.out.println(ebeRepealService.getCount());
//		System.out.println(ebeRepealService.querydata(0, 3).get(0).getRepealResoun());
//		epv.setPackageId(4);
//		epv.setId(3);
//		System.out.println("EbeRepealService.modife="+ebeRepealService.modifyEbeRepeal(epv));
//		System.out.println("EbeRepealService.delete="+ebeRepealService.deleteEbeRepealbyId(2));
		
		/*
		 * 其它测试用例
		 * 以测试EbeScoreBaisisService为例
		 * @author czg
		 */
//		EbeScoreBaisisService ebeScoreBaisisService = new EbeScoreBaisisService(td);//要在EbeScoreBaisisService中加入一个构造方法
//		EbeScoreBaisisVo esbv = new EbeScoreBaisisVo();
//		esbv.setGroupId(2);
//		System.out.println(ebeScoreBaisisService.insertEbeScoreBaisis(esbv));
//		System.out.println(ebeScoreBaisisService.getCount());
//		System.out.println(ebeScoreBaisisService.querydata(0, 3).get(0).getGroupId());
//		esbv.setProjectId(3);
//		esbv.setId(3);
//		System.out.println("EbeScoreBaisisService.modife="+ebeScoreBaisisService.modifyEbeScoreBaisis(esbv));
//		System.out.println("EbeScoreBaisisService.delete="+ebeScoreBaisisService.deleteEbeScoreBaisisbyId(1));
		
		/*
		 * 其它测试用例
		 * 以测试EbeWinService为例
		 * @author czg
		 */
//		EbeWinService ebeWinService = new EbeWinService(td);//要在EbeWinService中加入一个构造方法
//		EbeWinVo ewv = new EbeWinVo();
//		ewv.setProjectId(2);
//		System.out.println(ebeWinService.insertEbeWin(ewv));
//		System.out.println(ebeWinService.getCount());
//		System.out.println(ebeWinService.querydata(0, 3).get(0).getProjectId());
//		ewv.setWinProportion(3);
//		ewv.setId(2);
//		System.out.println("EbeWinService.modife="+ebeWinService.modifyEbeWin(ewv));
//		System.out.println("EbeWinService.delete="+ebeWinService.deleteEbeWinbyId(1));
		
		/*
		 * 其它测试用例
		 * 以测试EptImportTemplateService为例
		 * @author czg
		 */
//		EptImportTemplateService eptImportTemplateService = new EptImportTemplateService(td);//要在EptImportTemplateService中加入一个构造方法
//		EptImportTemplateVo eitv = new EptImportTemplateVo();
//		eitv.setTemplateName("name");
//		System.out.println(eptImportTemplateService.insertEptImportTemplate(eitv));
//		System.out.println(eptImportTemplateService.getCount());
//		System.out.println(eptImportTemplateService.querydata(0, 3).get(0).getTemplateName());
//		eitv.setTemplateType("type");
//		eitv.setId(2);
//		System.out.println("EptImportTemplateService.modife="+eptImportTemplateService.modifyEptImportTemplate(eitv));
//		System.out.println("EptImportTemplateService.delete="+eptImportTemplateService.deleteEptImportTemplatebyId(1));
		
		
		
		/*
		 * 其它测试用例
		 * 以测试EptMessageSupplierService为例
		 * @author czg
		 */
//		EptMessageSupplierService eptMessageSupplierService = new EptMessageSupplierService(td);//要在EptMessageSupplierService中加入一个构造方法
//		EptMessageSupplierVo emsv = new EptMessageSupplierVo();
//		emsv.setMessageName("name");
//		System.out.println(eptMessageSupplierService.insertEptMessageSupplier(emsv));
//		System.out.println(eptMessageSupplierService.getCount());
//		System.out.println(eptMessageSupplierService.querydata(0, 3).get(0).getMessageName());
//		emsv.setMessageType("type");
//		emsv.setId(2);
//		System.out.println("EptMessageSupplierService.modife="+eptMessageSupplierService.modifyEptMessageSupplier(emsv));
//		System.out.println("EptMessageSupplierService.delete="+eptMessageSupplierService.deleteEptMessageSupplierbyId(1));
		
		
		
		/*
		 * 其它测试用例
		 * 以测试EptMessageTemplateService为例
		 * @author czg
		 */
//		EptMessageTemplateService eptMessageTemplateService = new EptMessageTemplateService(td);//要在EptMessageTemplateService中加入一个构造方法
//		EptMessageTemplateVo emtv = new EptMessageTemplateVo();
//		emtv.setMessageTemplateName("name");
//		System.out.println(eptMessageTemplateService.insertEptMessageTemplate(emtv));
//		System.out.println(eptMessageTemplateService.getCount());
//		System.out.println(eptMessageTemplateService.querydata(0, 3).get(0).getMessageTemplateName());
//		emtv.setMessageTemplateType("type");
//		emtv.setId(2);
//		System.out.println("EptMessageTemplateService.modife="+eptMessageTemplateService.modifyEptMessageTemplate(emtv));
//		System.out.println("EptMessageTemplateService.delete="+eptMessageTemplateService.deleteEptMessageTemplatebyId(1));
			
		
		/*
		 * 其它测试用例
		 * 以测试EptOrgService为例
		 * @author czg
		 */
//		EptOrgService eptOrgService = new EptOrgService(td);//要在EptOrgService中加入一个构造方法
//		EptOrgVo eov = new EptOrgVo();
//		eov.setOrgName("name");
//		System.out.println(eptOrgService.insertEptOrg(eov));
//		System.out.println(eptOrgService.getCount());
//		System.out.println(eptOrgService.querydata(0, 3).get(0).getOrgName());
//		eov.setOrgCode("code");
//		eov.setId(2);
//		System.out.println("EptOrgService.modife="+eptOrgService.modifyEptOrg(eov));
//		System.out.println("EptOrgService.delete="+eptOrgService.deleteEptOrgbyId(1));
			
		
		/*
		 * 其它测试用例
		 * 以测试EptRepealTemplateService为例
		 * @author czg
		 */
//		EptRepealTemplateService eptRepealTemplateService = new EptRepealTemplateService(td);//要在EptRepealTemplateService中加入一个构造方法
//		EptRepealTemplateVo ertv = new EptRepealTemplateVo();
//		ertv.setRepealTemplateName("name");
//		System.out.println(eptRepealTemplateService.insertEptRepealTemplate(ertv));
//		System.out.println(eptRepealTemplateService.getCount());
//		System.out.println(eptRepealTemplateService.querydata(0, 3).get(0).getRepealTemplateName());
//		ertv.setRepealTemplateType("type");
//		ertv.setId(2);
//		System.out.println("EptRepealTemplateService.modife="+eptRepealTemplateService.modifyEptRepealTemplate(ertv));
//		System.out.println("EptRepealTemplateService.delete="+eptRepealTemplateService.deleteEptRepealTemplatebyId(1));
			
		
		
		/*
		 * 其它测试用例
		 * 以测试EptSpecialtyService为例
		 * @author czg
		 */
//		EptSpecialtyService eptSpecialtyService = new EptSpecialtyService(td);//要在EptSpecialtyService中加入一个构造方法
//		EptSpecialtyVo esv = new EptSpecialtyVo();
//		esv.setSpecialtyCode("code");
//		System.out.println(eptSpecialtyService.insertEptSpecialty(esv));
//		System.out.println(eptSpecialtyService.getCount());
//		System.out.println(eptSpecialtyService.querydata(0, 3).get(0).getSpecialtyCode());
//		esv.setSpecialtyName("name");
//		esv.setId(2);
//		System.out.println("EptSpecialtyService.modife="+eptSpecialtyService.modifyEptSpecialty(esv));
//		System.out.println("EptSpecialtyService.delete="+eptSpecialtyService.deleteEptSpecialtybyId(1));
		
		
		
		
		
		/*
		 * 其它测试用例
		 * 以测试SysFunctionService为例
		 * @author gr
		 */
//		SysFunctionService sysFunctionService = new SysFunctionService(td);//要在SysFunctionService中加入一个构造方法
//		SysFunctionVo sfv = new SysFunctionVo();
//		sfv.setFunctionName("SysFunctionService");
//		System.out.println(sysFunctionService.insertSysFunction(sfv));
//		System.out.println(sysFunctionService.getCount());
//		System.out.println(sysFunctionService.querydata(0, 3).get(0).getFunctionName());
//		sfv.setModuleId(2);
//		sfv.setId(3);
//		System.out.println("SysFunctionService.modife="+sysFunctionService.modifySysFunction(sfv));
//		System.out.println("SysFunctionService.delete="+sysFunctionService.deleteSysFunctionbyId(1));
		
		/*
		 * 其它测试用例
		 * 以测试SysFunctionService为例
		 * @author gr
		 */
//		SysFunctionService sysFunctionService = new SysFunctionService(td);//要在SysFunctionService中加入一个构造方法
//		SysFunctionVo sfv = new SysFunctionVo();
//		sfv.setFunctionName("SysFunctionService");
//		System.out.println(sysFunctionService.insertSysFunction(sfv));
//		System.out.println(sysFunctionService.getCount());
//		System.out.println(sysFunctionService.querydata(0, 3).get(0).getFunctionName());
//		sfv.setModuleId(2);
//		sfv.setId(3);
//		System.out.println("SysFunctionService.modife="+sysFunctionService.modifySysFunction(sfv));
//		System.out.println("SysFunctionService.delete="+sysFunctionService.deleteSysFunctionbyId(1));
		
		
		/*
		 * 其它测试用例
		 * 以测试SysMenuService为例
		 * @author gr
		 */
//		SysMenuService sysMenuService = new SysMenuService(td);//要在SysMenuService中加入一个构造方法
//		SysMenuVo smv = new SysMenuVo();
//		smv.setComment("cbsdjkb");
//		System.out.println(sysMenuService.insertSysMenu(smv));
//		System.out.println(sysMenuService.getCount());
//		System.out.println(sysMenuService.querydata(0, 3).get(0).getComment());
//		smv.setIcon("icoc");
//		smv.setId(1);
//		System.out.println("SysMenuService.modife="+sysMenuService.modifySysMenu(smv));
//		System.out.println("SysMenuService.delete="+sysMenuService.deleteSysMenubyId(1));
	}

}
