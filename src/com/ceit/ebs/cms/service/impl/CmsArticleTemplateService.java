package com.ceit.ebs.cms.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.util.PageInfo;
import com.ceit.ebs.cms.entity.CmsArticle;
import com.ceit.ebs.cms.entity.CmsArticleTemplate;
import com.ceit.ebs.cms.service.ICmsArticleTemplateService;
import com.ceit.ebs.cms.vo.CmsArticleTemplateVo;
import com.ceit.ebs.cms.vo.CmsArticleVo;
/**
 * SysFunction entity. @author MyEclipse Persistence Tools
 * @author lcy
 * @version 2014.8.19
 */
public class CmsArticleTemplateService implements ICmsArticleTemplateService{

	private CmsArticleTemplate cmsArticleTemplate;
	private ITableDao tableDao;
	public CmsArticleTemplateService()
	{
	}
	/**
	 * 根据主键ID,获得数据总数
	 * @return 查询到的数据总数，若失败，返回-1
	 */
	@SuppressWarnings("unchecked")
	public Integer getCount() {
		// TODO Auto-generated method stub
		Integer count = 0;//记录总数
		String sql = null;
		//Map<String,Object> map = new HashMap<String,Object>();
		sql="SELECT COUNT(d.id) FROM CmsArticleTemplate d "+"where '1'='1'";
		try {
			List<CmsArticleTemplate> list = tableDao.otherQuery(sql, true, true, null);
			if(list != null && list.size() > 0){
				count = Integer.parseInt((list.get(0)+""));
			}
		}catch(Exception e) {
			count = -1;
			e.printStackTrace();
		}
		return count;
	}
	/**
	 * 分页显示数据
	 * @param pageindex 当前页码
	 * @param pagesize 每页显示条数
	 * @return 包含查询到的所有CmsArticleTemplateVo实例的List，若失败，返回null
	 */
	@SuppressWarnings("unchecked")
	public PageInfo<CmsArticleTemplateVo> querydata(int pageindex, int pagesize) {
		// TODO Auto-generated method stub
		List<CmsArticleTemplateVo> cmsArticleTemplateVoList = new ArrayList<CmsArticleTemplateVo>(); //VO集合
		int count = 0;
		//Map<String,Object> map = new HashMap<String,Object>();
		String sql = " FROM  CmsArticleTemplate d where '1' = '1'  ";
		//sql += " order by d.dispindex desc "; 
		try {
			//PO集合
			List<CmsArticleTemplate> cmsArticleTemplateList = tableDao.querydata(sql, true, pageindex, pagesize, null);
			if(cmsArticleTemplateList != null && cmsArticleTemplateList.size() > 0){
				for(int i = 0 ; i < cmsArticleTemplateList.size() ; i++){
					CmsArticleTemplateVo eov = new CmsArticleTemplateVo(cmsArticleTemplateList.get(i));//PO -> VO
					cmsArticleTemplateVoList.add(eov);
				}
			}
			count = this.getCount();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new PageInfo<CmsArticleTemplateVo>(cmsArticleTemplateVoList,count,pageindex,pagesize);
	}
	/**
	 * 根据项目下的分标的ID查找项目下的分标
	 * @param  cmsArticleTemplateId 要查询的项目下的分标ID值
	 * @return 查询到的CmsArticleTemplate实例
	 */
	public CmsArticleTemplateVo getCmsArticleTemplatebyId(Integer cmsArticleTemplateId) {
		// TODO Auto-generated method stub
		CmsArticleTemplateVo cmsArticleTemplateVo=null;
		try {
			cmsArticleTemplate = (CmsArticleTemplate)tableDao.getEntitybyId(cmsArticleTemplateId, CmsArticleTemplate.class);
			cmsArticleTemplateVo=new CmsArticleTemplateVo(cmsArticleTemplate);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return cmsArticleTemplateVo;	
	}
	/**
	 * 修改项目下的分标实例
	 * @param  cmsArticleTemplate 要修改的项目下的分标
	 * @return 修改成功，返回 true，若失败，返回 false
	 */
	public boolean modifyCmsArticleTemplate(CmsArticleTemplateVo cmsArticleTemplateVo) {
		// TODO Auto-generated method stub
		try {
			tableDao.update(cmsArticleTemplateVo.adapterToCmsArticleTemplate());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 根据项目下分标的ID删除项目下分标
	 * @param  cmsArticleTemplateId 要删除的项目下分标ID值
	 * @return 删除成功， 返回 true，若失败，返回 false
	 */
	public boolean deleteCmsArticleTemplatebyId(Integer cmsArticleTemplateId) {
		// TODO Auto-generated method stub
		try {
			tableDao.delete(cmsArticleTemplateId, CmsArticleTemplate.class);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 新增一个项目下的分标
	 * @param cmsArticleTemplateVo 要添加的CmsArticleTemplateVo实例
	 * @return 添加的招标项目划分包在数据库中的ID值，若失败返回-1
	 */
	public Integer insertCmsArticleTemplate(CmsArticleTemplateVo cmsArticleTemplateVo) {
		// TODO Auto-generated method stub
		try {
			CmsArticleTemplate eo = cmsArticleTemplateVo.adapterToCmsArticleTemplate();
			Integer cmsArticleTemplateId = tableDao.insert(eo);
			//sr.setId(sysRoleId);
			//sr.setDispindex(sysRoleId);
			tableDao.update(eo);
			return cmsArticleTemplateId;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	/**
	 * 根据项目Id(ProjectId)查看属性列表
	 * @param projectId 分类id(projectId)
	 * @return 所有符合projectId条件的属性
	*/	
	public PageInfo<CmsArticleTemplateVo> getCmsArticleTemplatebyTemplateType(int pageindex, int pagesize, String templateType) {
		String sql = "from CmsArticleTemplate where templateType=:templateType";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("templateType", templateType);
		try {
				List<CmsArticleTemplate> list = this.tableDao.querydata(sql, true, pageindex, pagesize, params);
				List<CmsArticleTemplateVo> listVo = new ArrayList<CmsArticleTemplateVo>();
				for(int i = 0; i<list.size();i++){
					CmsArticleTemplateVo epv = new CmsArticleTemplateVo(list.get(i));
					listVo.add(epv);
				}
				int size = this.getListSizeByTemplateType(templateType);
				return new PageInfo<CmsArticleTemplateVo>(listVo,size,pageindex,pagesize);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Integer getListSizeByTemplateType(String templateType) {
		String sql = "select count(id) from CmsArticleTemplate where templateType=:templateType";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("templateType", templateType);
		Integer ListSize = -1;
		try {
			List list = this.tableDao.otherQuery(sql, true, true, params);
			Object o = list.get(0);
			ListSize =  Integer.valueOf(o.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ListSize;
	}
	/**
	 * 根据多个id删除对应数据
	 * @param  待删除的字符串id
	 * @return 包含查询到的所有实例，若失败，返回null
	*/	
	public boolean delObjsByIds(String ids) {
		String[] IdArray = ids.split(",");
		boolean b = true;
		try {
			for (int i = 0; i < IdArray.length; i++) {
				this.tableDao.delete(Integer.parseInt(IdArray[i]), CmsArticleTemplate.class);
			}
		} catch (Exception e) {
			b = false;
		}
		return true;
	}

	public void setCmsArticleTemplate(CmsArticleTemplate cmsArticleTemplate) {
		// TODO Auto-generated method stub
		this.cmsArticleTemplate=cmsArticleTemplate;
	}

	public void setTableDao(ITableDao tableDao) {
		// TODO Auto-generated method stub
		this.tableDao=tableDao;
	}

}
