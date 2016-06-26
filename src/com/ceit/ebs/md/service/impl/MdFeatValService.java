package com.ceit.ebs.md.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.util.PageInfo;
import com.ceit.ebs.md.entity.MdFeat;
import com.ceit.ebs.md.entity.MdFeatVal;
import com.ceit.ebs.md.service.IMdFeatValService;
import com.ceit.ebs.md.vo.MdFeatValVo;
import com.ceit.ebs.md.vo.MdFeatVo;
/**
 * SysFunction entity. @author MyEclipse Persistence Tools
 * @author hgl
 * @version 2014.8.11
 */
public class MdFeatValService implements IMdFeatValService{

	private MdFeatValVo mdFeatValVo;
	private ITableDao tableDao;
	public MdFeatValService()
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
		sql="SELECT COUNT(d.id) FROM MdFeatVal d "+"where '1'='1'";
		try {
			List<MdFeatVal> list = tableDao.otherQuery(sql, true, true, null);
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
	 * @return 包含查询到的所有MdFeatValVo实例的List，若失败，返回null
	 */
	@SuppressWarnings("unchecked")
	public PageInfo<MdFeatValVo> querydata(int pageindex, int pagesize) {
		// TODO Auto-generated method stub
		List<MdFeatValVo> mdFeatValVoList = new ArrayList<MdFeatValVo>(); //VO集合
		//Map<String,Object> map = new HashMap<String,Object>();
		int count = 0;
		String sql = " FROM  MdFeatVal d where '1' = '1'  ";
		//sql += " order by d.dispindex desc "; 
		try {
			//PO集合
			List<MdFeatVal> mdFeatValList = tableDao.querydata(sql, true, pageindex, pagesize, null);
			if(mdFeatValList != null && mdFeatValList.size() > 0){
				for(int i = 0 ; i < mdFeatValList.size() ; i++){
					MdFeatValVo eov = new MdFeatValVo(mdFeatValList.get(i));//PO -> VO
					mdFeatValVoList.add(eov);
				}
			}
			count = this.getCount();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new PageInfo<MdFeatValVo>(mdFeatValVoList,count,pageindex,pagesize);
	}
	/**
	 * 根据项目下的分标的ID查找项目下的分标
	 * @param  mdFeatValId 要查询的项目下的分标ID值
	 * @return 查询到的MdFeatVal实例
	 */
	public MdFeatValVo getMdFeatValbyId(Integer mdFeatValId) {
		// TODO Auto-generated method stub
		MdFeatVal mdFeatVal=null;
		try {
			mdFeatVal=(MdFeatVal)tableDao.getEntitybyId(mdFeatValId, MdFeatVal.class);
			mdFeatValVo=new MdFeatValVo(mdFeatVal);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return mdFeatValVo;	
	}
	/**
	 * 修改项目下的分标实例
	 * @param  mdFeatVal 要修改的项目下的分标
	 * @return 修改成功，返回 true，若失败，返回 false
	 */
	public boolean modifyMdFeatVal(MdFeatValVo mdFeatValVo) {
		// TODO Auto-generated method stub
		try {
			tableDao.update(mdFeatValVo.adapterToMdFeatVal());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 根据项目下分标的ID删除项目下分标
	 * @param  mdFeatValId 要删除的项目下分标ID值
	 * @return 删除成功， 返回 true，若失败，返回 false
	 */
	public boolean deleteMdFeatValbyId(Integer mdFeatValId) {
		// TODO Auto-generated method stub
		try {
			tableDao.delete(mdFeatValId, MdFeatVal.class);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 新增一个项目下的分标
	 * @param mdFeatValVo 要添加的MdFeatValVo实例
	 * @return 添加的招标项目划分包在数据库中的ID值，若失败返回-1
	 */
	public Integer insertMdFeatVal(MdFeatValVo mdFeatValVo) {
		// TODO Auto-generated method stub
		try {
			MdFeatVal eo = mdFeatValVo.adapterToMdFeatVal();
			Integer mdFeatValId = tableDao.insert(eo);
			//sr.setId(sysRoleId);
			//sr.setDispindex(sysRoleId);
			//tableDao.update(eo);
			return mdFeatValId;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	/**
	 * 根据物料获取属性list
	 * @param materialId 物料ID
	 * @return 包含查询到的所有MdFeatVo实例的List，若失败，返回null
	*/	
	public List<MdFeatValVo> getListByMatId(Integer materialId) {
		String sql = "from MdFeatVal where materialId=:materialId order by id asc";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("materialId", materialId);
		try {
			
			List<MdFeatVal> list = this.tableDao.otherQuery(sql, true, true, params);
			List<MdFeatValVo> listVo = new ArrayList<MdFeatValVo>();
			for(int i = 0; i<list.size();i++){
				MdFeatValVo epv = new MdFeatValVo(list.get(i));
				listVo.add(epv);
			}
			return listVo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void setMdFeatValVo(MdFeatValVo mdFeatValVo) {
		// TODO Auto-generated method stub
		this.mdFeatValVo=mdFeatValVo;
	}

	public void setTableDao(ITableDao tableDao) {
		// TODO Auto-generated method stub
		this.tableDao=tableDao;
	}

}
