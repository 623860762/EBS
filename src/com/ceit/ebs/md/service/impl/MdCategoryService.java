package com.ceit.ebs.md.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.util.PageInfo;
import com.ceit.ebs.md.entity.MdCategory;
import com.ceit.ebs.md.service.IMdCategoryService;
import com.ceit.ebs.md.vo.MdCategoryVo;

/**
 * SysFunction entity. @author MyEclipse Persistence Tools
 * @author lcy
 * @version 2014.8.16
 */
public class MdCategoryService implements IMdCategoryService{

	private MdCategoryVo mdCategoryVo;
	private ITableDao tableDao;
	public MdCategoryService()
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
		sql="SELECT COUNT(d.id) FROM MdCategory d "+"where '1'='1'";
		try {
			List<MdCategory> list = tableDao.otherQuery(sql, true, true, null);
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
	 * @return 包含查询到的所有MdCategoryVo实例的List，若失败，返回null
	 */
	@SuppressWarnings("unchecked")
	public PageInfo<MdCategoryVo> querydata(int pageindex, int pagesize) {
		// TODO Auto-generated method stub
		List<MdCategoryVo> mdCategoryVoList = new ArrayList<MdCategoryVo>(); //VO集合
		int count = 0;
		//Map<String,Object> map = new HashMap<String,Object>();
		String sql = " FROM  MdCategory d where '1' = '1'  ";
		//sql += " order by d.dispindex desc "; 
		try {
			//PO集合
			List<MdCategory> mdCategoryList = tableDao.querydata(sql, true, pageindex, pagesize, null);
			if(mdCategoryList != null && mdCategoryList.size() > 0){
				for(int i = 0 ; i < mdCategoryList.size() ; i++){
					MdCategoryVo eov = new MdCategoryVo(mdCategoryList.get(i));//PO -> VO
					mdCategoryVoList.add(eov);
				}
			}
			count = this.getCount();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new PageInfo<MdCategoryVo>(mdCategoryVoList,count,pageindex,pagesize);
	}
	/**
	 * 根据项目下的分标的ID查找项目下的分标
	 * @param  mdCategoryId 要查询的项目下的分标ID值
	 * @return 查询到的MdCategory实例
	 */
	public MdCategoryVo getMdCategorybyId(Integer mdCategoryId) {
		// TODO Auto-generated method stub
		MdCategory mdCategory=null;
		try {
			mdCategory = (MdCategory)tableDao.getEntitybyId(mdCategoryId, MdCategory.class);
			mdCategoryVo=new MdCategoryVo(mdCategory);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return mdCategoryVo;	
	}
	/**
	 * 修改项目下的分标实例
	 * @param  mdCategory 要修改的项目下的分标
	 * @return 修改成功，返回 true，若失败，返回 false
	 */
	public boolean modifyMdCategory(MdCategoryVo mdCategoryVo) {
		// TODO Auto-generated method stub
		try {
			tableDao.update(mdCategoryVo.adapterToMdCategory());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 根据项目下分标的ID删除项目下分标
	 * @param  mdCategoryId 要删除的项目下分标ID值
	 * @return 删除成功， 返回 true，若失败，返回 false
	 */
	public boolean deleteMdCategorybyId(Integer mdCategoryId) {
		// TODO Auto-generated method stub
		try {
			tableDao.delete(mdCategoryId, MdCategory.class);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 新增一个项目下的分标
	 * @param mdCategoryVo 要添加的MdCategoryVo实例
	 * @return 添加的招标项目划分包在数据库中的ID值，若失败返回-1
	 */
	public Integer insertMdCategory(MdCategoryVo mdCategoryVo) {
		// TODO Auto-generated method stub
		try {
			MdCategory eo = mdCategoryVo.adapterToMdCategory();
			Integer mdCategoryId = tableDao.insert(eo);
			//sr.setId(sysRoleId);
			//sr.setDispindex(sysRoleId);
			tableDao.update(eo);
			return mdCategoryId;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	/**
	 * 根据父节点id查询其子节点的数量
	 * @param parentId 父节点id
	 * @return 子节点的个数
	 */
	public Integer getListSizeByParentId(Integer parentId) {
		String sql = "select count(id) from MdCategory where parentId=:parentId";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("parentId", parentId);
		Integer ListSize = -1;
		try {
			
			List list = this.tableDao.otherQuery(sql, true, true, params);
			Object o = list.get(0);
			ListSize =  Integer.valueOf(o.toString());
			System.out.println("查询到记录数:"+ListSize);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ListSize;
	}
	/**
	 * 根据父节点id查询其子节点数据
	 * @param parentId 父节点id
	 * @return 所有子节点的id
	 */
	 @SuppressWarnings("unchecked")
	public List<MdCategoryVo> getListByParentId(Integer parentId) {
		String sql = "from MdCategory where parentId=:parentId";
		Map<String, Object> params = new HashMap<String, Object>();
		MdCategoryVo cm = null;
		List<MdCategory> mclist = new ArrayList<MdCategory>();
		List<MdCategoryVo> mcvlist = new ArrayList<MdCategoryVo>();
		params.put("parentId", parentId);
		try {
			mclist = tableDao.otherQuery(sql, true, true, params);
			for(int i=0;i<mclist.size();i++){
				cm = new MdCategoryVo(mclist.get(i));
				mcvlist.add(cm);
			}
			
			return mcvlist;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return null;
	}
	
	/**
	 * 根据父节点id分页显示其子节点
	 * @param pageindex 分页起始页    pagesize 分页大小     parentId 父节点id
	 * @return 包含查询到的所有MdCategoryVo实例的List，若失败，返回null
	*/
		public PageInfo<MdCategoryVo> getObjList(int pageindex, int pagesize, Integer parentId) {
		String sql = "from MdCategory where parentId=:parentId";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("parentId", parentId);
		try {
				List<MdCategory> list = this.tableDao.querydata(sql, true, pageindex, pagesize, params);
				List<MdCategoryVo> listVo = new ArrayList<MdCategoryVo>();
				for(int i = 0; i<list.size();i++){
					MdCategoryVo epv = new MdCategoryVo(list.get(i));
					listVo.add(epv);
				}
				int size = this.getListSizeByParentId(parentId);
				return new PageInfo<MdCategoryVo>(listVo,size,pageindex,pagesize);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 根据多个id删除对应数据
	 * @param mdCategoryIds 待删除的id字符串
	 * @return 包含查询到的所有MdCategoryVo实例的List，若失败，返回null
	*/	
	public boolean delObjsByIds(String mdCategoryIds) {
		String[] IdArray = mdCategoryIds.split(",");
		boolean b = true;
		try {
			for (int i = 0; i < IdArray.length; i++) {
				this.tableDao.delete(Integer.parseInt(IdArray[i]), MdCategory.class);
			}
		} catch (Exception e) {
			b = false;
		}
		return true;
	}
	
	/**
	 * 增加同级分类
	 * @param CategoryId 待插入分类同级分类的id,mdCategoryVo 待插入的分类
	 * @return 插入分类的id
	*/	
	public Integer insertByParentId(Integer CategoryId, MdCategoryVo mdCategoryVo) {
		try {
			MdCategory eo = mdCategoryVo.adapterToMdCategory();
			eo.setParentId(getParentIdbyId(CategoryId));
			Integer mdCategoryId = tableDao.insert(eo);
			tableDao.update(eo);
			return mdCategoryId;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	/**
	 * 增加子级分类
	 * @param CategoryId 待插入分类的parentId,mdCategoryVo 待插入的分类
	 * @return 插入分类的id
	*/	
	public Integer insertChildById(Integer CategoryId, MdCategoryVo mdCategoryVo) {
		try {
			MdCategory eo = mdCategoryVo.adapterToMdCategory();
			eo.setParentId(CategoryId);
			Integer mdCategoryId = tableDao.insert(eo);
			tableDao.update(eo);
			return mdCategoryId;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	/**
	 * 获取父节点id
	 * @param id 分类id
	 * @return 父节点id
	*/	
	public Integer getParentIdbyId(Integer id) {
		MdCategoryVo mdCategoryVo=getMdCategorybyId(id);
		return mdCategoryVo.getParentId();
	}
	
	/**
	 * 根据code获得分类
	 * @param mdCategotyCode 查询分类code
	 * @return 所有符合code条件的分类
	*/	
	public List<MdCategoryVo> getMdCategorybyCode(String mdCategoryCode){
		List<MdCategoryVo> list= new ArrayList<MdCategoryVo>();
		String sql = "FROM  MdCategory d where '1' = '1' and code=:code";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", mdCategoryCode);
		try {
			//PO集合
			List<MdCategory> mdCategoryList =tableDao.otherQuery(sql, true,true, map);
			if(mdCategoryList != null && mdCategoryList.size() > 0){
				for(int i = 0 ; i < mdCategoryList.size() ; i++){
					MdCategoryVo epv = new MdCategoryVo(mdCategoryList.get(i));//PO -> VO
					list.add(epv);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public void setMdCategoryVo(MdCategoryVo mdCategoryVo) {
		// TODO Auto-generated method stub
		this.mdCategoryVo=mdCategoryVo;
	}

	public void setTableDao(ITableDao tableDao) {
		// TODO Auto-generated method stub
		this.tableDao=tableDao;
	}
	
	

}
