package com.ceit.ebs.cms.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.util.PageInfo;
import com.ceit.ebs.cms.entity.CmsArticle;
import com.ceit.ebs.cms.service.ICmsArticleService;
import com.ceit.ebs.cms.vo.CmsArticleVo;
import com.ceit.ebs.md.entity.MdFeat;
import com.ceit.ebs.md.vo.MdFeatVo;
/**
 * SysFunction entity. @author MyEclipse Persistence Tools
 * @author lcy
 * @version 2014.8.19
 */
public class CmsArticleService implements ICmsArticleService{

	private CmsArticleVo cmsArticleVo;
	private ITableDao tableDao;
	public CmsArticleService()
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
		sql="SELECT COUNT(d.id) FROM CmsArticle d "+"where '1'='1'";
		try {
			List<CmsArticle> list = tableDao.otherQuery(sql, true, true, null);
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
	 * @return 包含查询到的所有CmsArticleVo实例的List，若失败，返回null
	 */
	@SuppressWarnings("unchecked")
	public PageInfo<CmsArticleVo> querydata(int pageindex, int pagesize) {
		// TODO Auto-generated method stub
		List<CmsArticleVo> cmsArticleVoList = new ArrayList<CmsArticleVo>(); //VO集合
		int count = 0;
		//Map<String,Object> map = new HashMap<String,Object>();
		String sql = " FROM  CmsArticle d where '1' = '1'  ";
		//sql += " order by d.dispindex desc "; 
		try {
			//PO集合
			List<CmsArticle> cmsArticleList = tableDao.querydata(sql, true, pageindex, pagesize, null);
			if(cmsArticleList != null && cmsArticleList.size() > 0){
				for(int i = 0 ; i < cmsArticleList.size() ; i++){
					CmsArticleVo eov = new CmsArticleVo(cmsArticleList.get(i));//PO -> VO
					cmsArticleVoList.add(eov);
				}
			}
			count = this.getCount();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new PageInfo<CmsArticleVo>(cmsArticleVoList,count,pageindex,pagesize);
	}
	/**
	 * 根据项目下的分标的ID查找项目下的分标
	 * @param  cmsArticleId 要查询的项目下的分标ID值
	 * @return 查询到的CmsArticle实例
	 */
	public CmsArticleVo getCmsArticlebyId(Integer cmsArticleId) {
		CmsArticle cmsArticle=new CmsArticle();
		try {
			cmsArticle = (CmsArticle)tableDao.getEntitybyId(cmsArticleId, CmsArticle.class);
			cmsArticleVo=new CmsArticleVo(cmsArticle);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return cmsArticleVo;	
	}
	/**
	 * 修改项目下的分标实例
	 * @param  cmsArticle 要修改的项目下的分标
	 * @return 修改成功，返回 true，若失败，返回 false
	 */
	public boolean modifyCmsArticle(CmsArticleVo cmsArticleVo) {
		// TODO Auto-generated method stub
		try {
			tableDao.update(cmsArticleVo.adapterToCmsArticle());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 根据项目下分标的ID删除项目下分标
	 * @param  cmsArticleId 要删除的项目下分标ID值
	 * @return 删除成功， 返回 true，若失败，返回 false
	 */
	public boolean deleteCmsArticlebyId(Integer cmsArticleId) {
		// TODO Auto-generated method stub
		try {
			tableDao.delete(cmsArticleId, CmsArticle.class);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 新增一个项目下的分标
	 * @param cmsArticleVo 要添加的CmsArticleVo实例
	 * @return 添加的招标项目划分包在数据库中的ID值，若失败返回-1
	 */
	public Integer insertCmsArticle(CmsArticleVo cmsArticleVo) {
		// TODO Auto-generated method stub
		try {
			CmsArticle eo = cmsArticleVo.adapterToCmsArticle();
			Integer cmsArticleId = tableDao.insert(eo);
//			sr.setId(sysRoleId);
			//sr.setDispindex(sysRoleId);
//			tableDao.update(eo);
			return cmsArticleId;
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
	public PageInfo<CmsArticleVo> getCmsArticlebyProjectId(int pageindex, int pagesize, Integer projectId) {
		String sql = "from CmsArticle where projectId=:projectId";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("projectId", projectId);
		try {
				List<CmsArticle> list = this.tableDao.querydata(sql, true, pageindex, pagesize, params);
				List<CmsArticleVo> listVo = new ArrayList<CmsArticleVo>();
				for(int i = 0; i<list.size();i++){
					CmsArticleVo epv = new CmsArticleVo(list.get(i));
					listVo.add(epv);
				}
				int size = this.getListSizeByProjectId(projectId);
				return new PageInfo<CmsArticleVo>(listVo,size,pageindex,pagesize);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Integer getListSizeByProjectId(Integer projectId) {
		String sql = "select count(id) from CmsArticle where projectId=:projectId";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("projectId", projectId);
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
				this.tableDao.delete(Integer.parseInt(IdArray[i]), CmsArticle.class);
			}
		} catch (Exception e) {
			b = false;
		}
		return true;
	}

	public void setCmsArticleVo(CmsArticleVo cmsArticleVo) {
		// TODO Auto-generated method stub
		this.cmsArticleVo=cmsArticleVo;
	}
	public void setTableDao(ITableDao tableDao) {
		this.tableDao = tableDao;
	}


	
	

}
