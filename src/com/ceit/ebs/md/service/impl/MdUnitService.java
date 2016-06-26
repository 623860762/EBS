package com.ceit.ebs.md.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.util.PageInfo;
import com.ceit.ebs.md.entity.MdUnit;
import com.ceit.ebs.md.service.IMdUnitService;
import com.ceit.ebs.md.vo.MdUnitVo;
/**
 * SysFunction entity. @author MyEclipse Persistence Tools
 * @author hgl
 * @version 2014.8.11
 */
public class MdUnitService implements IMdUnitService{

	private MdUnit mdUnit;
	private ITableDao tableDao;
	public MdUnitService()
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
		sql="SELECT COUNT(d.id) FROM MdUnit d "+"where '1'='1'";
		try {
			List<MdUnit> list = tableDao.otherQuery(sql, true, true, null);
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
	 * @return 包含查询到的所有MdUnitVo实例的List，若失败，返回null
	 */
	@SuppressWarnings("unchecked")
	public PageInfo<MdUnitVo> querydata(int pageindex, int pagesize) {
		// TODO Auto-generated method stub
		List<MdUnitVo> mdUnitVoList = new ArrayList<MdUnitVo>(); //VO集合
		int count = 0;
		//Map<String,Object> map = new HashMap<String,Object>();
		String sql = " FROM  MdUnit d where '1' = '1'  ";
		//sql += " order by d.dispindex desc "; 
		try {
			//PO集合
			List<MdUnit> mdUnitList = tableDao.querydata(sql, true, pageindex, pagesize, null);
			if(mdUnitList != null && mdUnitList.size() > 0){
				for(int i = 0 ; i < mdUnitList.size() ; i++){
					MdUnitVo eov = new MdUnitVo(mdUnitList.get(i));//PO -> VO
					mdUnitVoList.add(eov);
				}
			}
			count = this.getCount();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new PageInfo<MdUnitVo>(mdUnitVoList,count,pageindex,pagesize);
	}
	/**
	 * 根据项目下的分标的ID查找项目下的分标
	 * @param  mdUnitId 要查询的项目下的分标ID值
	 * @return 查询到的MdUnit实例
	 */
	public MdUnitVo getMdUnitbyId(Integer mdUnitId) {
		// TODO Auto-generated method stub
		MdUnitVo mdUnitVo=null;
		try {
			mdUnit = (MdUnit)tableDao.getEntitybyId(mdUnitId, MdUnit.class);
			mdUnitVo=new MdUnitVo(mdUnit);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return mdUnitVo;	
	}
	/**
	 * 修改项目下的分标实例
	 * @param  mdUnit 要修改的项目下的分标
	 * @return 修改成功，返回 true，若失败，返回 false
	 */
	public boolean modifyMdUnit(MdUnitVo mdUnitVo) {
		// TODO Auto-generated method stub
		try {
			tableDao.update(mdUnitVo.adapterToMdUnit());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 根据项目下分标的ID删除项目下分标
	 * @param  mdUnitId 要删除的项目下分标ID值
	 * @return 删除成功， 返回 true，若失败，返回 false
	 */
	public boolean deleteMdUnitbyId(Integer mdUnitId) {
		// TODO Auto-generated method stub
		try {
			tableDao.delete(mdUnitId, MdUnit.class);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 新增一个项目下的分标
	 * @param mdUnitVo 要添加的MdUnitVo实例
	 * @return 添加的招标项目划分包在数据库中的ID值，若失败返回-1
	 */
	public Integer insertMdUnit(MdUnitVo mdUnitVo) {
		// TODO Auto-generated method stub
		try {
			MdUnit eo = mdUnitVo.adapterToMdUnit();
			Integer mdUnitId = tableDao.insert(eo);
			//sr.setId(sysRoleId);
			//sr.setDispindex(sysRoleId);
			tableDao.update(eo);
			return mdUnitId;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public void setMdUnit(MdUnit mdUnit) {
		// TODO Auto-generated method stub
		this.mdUnit=mdUnit;
	}

	public void setTableDao(ITableDao tableDao) {
		// TODO Auto-generated method stub
		this.tableDao=tableDao;
	}

}
