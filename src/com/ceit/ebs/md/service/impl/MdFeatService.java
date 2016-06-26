package com.ceit.ebs.md.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.util.PageInfo;
import com.ceit.ebs.md.entity.MdCategory;
import com.ceit.ebs.md.entity.MdFeat;
import com.ceit.ebs.md.service.IMdFeatService;
import com.ceit.ebs.md.vo.MdCategoryVo;
import com.ceit.ebs.md.vo.MdFeatVo;
/**
 * SysFunction entity. @author MyEclipse Persistence Tools
 * @author hgl
 * @version 2014.8.11
 */
public class MdFeatService implements IMdFeatService{
	private MdFeatVo mdFeatVo;
	private ITableDao tableDao;
	
	public MdFeatService()
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
		sql="SELECT COUNT(d.id) FROM MdFeat d "+"where '1'='1'";
		try {
			List<MdFeat> list = tableDao.otherQuery(sql, true, true, null);
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
	 * @return 包含查询到的所有MdFeatVo实例的List，若失败，返回null
	 */
	@SuppressWarnings("unchecked")
	public PageInfo<MdFeatVo> querydata(int pageindex, int pagesize) {
		// TODO Auto-generated method stub
		List<MdFeatVo> mdFeatVoList = new ArrayList<MdFeatVo>(); //VO集合
		int count = 0;
		//Map<String,Object> map = new HashMap<String,Object>();
		String sql = " FROM  MdFeat d where '1' = '1'  ";
		//sql += " order by d.dispindex desc "; 
		try {
			//PO集合
			List<MdFeat> mdFeatList = tableDao.querydata(sql, true, pageindex, pagesize, null);
			if(mdFeatList != null && mdFeatList.size() > 0){
				for(int i = 0 ; i < mdFeatList.size() ; i++){
					MdFeatVo eov = new MdFeatVo(mdFeatList.get(i));//PO -> VO
					mdFeatVoList.add(eov);
				}
			}
			count = this.getCount();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new PageInfo<MdFeatVo>(mdFeatVoList,count,pageindex,pagesize);
	}
	/**
	 * 根据项目下的分标的ID查找项目下的分标
	 * @param  mdFeatId 要查询的项目下的分标ID值
	 * @return 查询到的MdFeat实例
	 */
	public MdFeatVo getMdFeatbyId(Integer mdFeatId) {
		// TODO Auto-generated method stub
		MdFeat mdFeat=null;
		try {
			mdFeat = (MdFeat)tableDao.getEntitybyId(mdFeatId, MdFeat.class);
			mdFeatVo=new MdFeatVo(mdFeat);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return mdFeatVo;	
	}
	/**
	 * 修改项目下的分标实例
	 * @param  mdFeat 要修改的项目下的分标
	 * @return 修改成功，返回 true，若失败，返回 false
	 */
	public boolean modifyMdFeat(MdFeatVo mdFeatVo) {
		// TODO Auto-generated method stub
		try {
			tableDao.update(mdFeatVo.adapterToMdFeat());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 根据项目下分标的ID删除项目下分标
	 * @param  mdFeatId 要删除的项目下分标ID值
	 * @return 删除成功， 返回 true，若失败，返回 false
	 */
	public boolean deleteMdFeatbyId(Integer mdFeatId) {
		// TODO Auto-generated method stub
		try {
			tableDao.delete(mdFeatId, MdFeat.class);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 新增一个项目下的分标
	 * @param mdFeatVo 要添加的MdFeatVo实例
	 * @return 添加的招标项目划分包在数据库中的ID值，若失败返回-1
	 */
	public Integer insertMdFeat(MdFeatVo mdFeatVo) {
		// TODO Auto-generated method stub
		try {
			MdFeat eo = mdFeatVo.adapterToMdFeat();
			Integer mdFeatId = tableDao.insert(eo);
			//sr.setId(sysRoleId);
			//sr.setDispindex(sysRoleId);
			tableDao.update(eo);
			return mdFeatId;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	/**
	 * 根据分类Id(CategoryId)查看属性列表
	 * @param mdCategotyId 分类id(categoryId)
	 * @return 所有符合categoryId条件的属性
	*/	
	public PageInfo<MdFeatVo> getMdFeatbyCategoryId(int pageindex, int pagesize, Integer categoryId) {
		String sql = "from MdFeat where categoryId=:categoryId";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("categoryId", categoryId);
		try {
				List<MdFeat> list = this.tableDao.querydata(sql, true, pageindex, pagesize, params);
				List<MdFeatVo> listVo = new ArrayList<MdFeatVo>();
				for(int i = 0; i<list.size();i++){
					MdFeatVo epv = new MdFeatVo(list.get(i));
					listVo.add(epv);
				}
				int size = this.getListSizeByCategoryId(categoryId);
				return new PageInfo<MdFeatVo>(listVo,size,pageindex,pagesize);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Integer getListSizeByCategoryId(Integer categoryId) {
		String sql = "select count(id) from MdFeat where categoryId=:categoryId";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("categoryId", categoryId);
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
	 * 根据categoryId获取属性list
	 * @param categoryId 物料分类ID
	 * @return 包含查询到的所有MdFeatVo实例的List，若失败，返回null
	*/	
	public List<MdFeatVo> getListByCategoryId(Integer categoryId) {
		String sql = "from MdFeat where categoryId=:categoryId";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("categoryId", categoryId);
		try {
			
			List<MdFeat> list = this.tableDao.otherQuery(sql, true, true, params);
			List<MdFeatVo> listVo = new ArrayList<MdFeatVo>();
			for(int i = 0; i<list.size();i++){
				MdFeatVo epv = new MdFeatVo(list.get(i));
				listVo.add(epv);
			}
			return listVo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 根据多个id删除对应数据
	 * @param mdFeatIds 待删除的id字符串
	 * @return 包含查询到的所有MdFeatVo实例的List，若失败，返回null
	*/	
	public boolean delObjsByIds(String mdFeatIds) {
		String[] IdArray = mdFeatIds.split(",");
		boolean b = true;
		try {
			for (int i = 0; i < IdArray.length; i++) {
				this.tableDao.delete(Integer.parseInt(IdArray[i]), MdFeat.class);
			}
		} catch (Exception e) {
			b = false;
		}
		return true;
	}

	public void setMdFeatVo(MdFeatVo mdFeatVo) {
		// TODO Auto-generated method stub
		this.mdFeatVo=mdFeatVo;
	}

	public void setTableDao(ITableDao tableDao) {
		// TODO Auto-generated method stub
		this.tableDao=tableDao;
	}

}
