package com.ceit.ebs.ept.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.dao.ITreeDao;
import com.ceit.common.util.PageInfo;
import com.ceit.ebs.ept.entity.EptSpecialty;
import com.ceit.ebs.ept.service.IEptSpecialtyService;
import com.ceit.ebs.ept.vo.EptSpecialtyVo;

/**
 * EptSpecialty entity. @author MyEclipse Persistence Tools
 */

public class EptSpecialtyService implements IEptSpecialtyService {
	
	static Logger logger = Logger.getLogger(EptSpecialtyService.class.getName());

	// Fields

	private EptSpecialty eptSpecialty;
	private ITableDao tableDao;
	private ITreeDao treeDao;
	private List<EptSpecialty> l;

	//测试用
	public EptSpecialtyService(){
	}
	public EptSpecialtyService(ITreeDao itreeDao){
		this.treeDao=itreeDao;
	}
	// Constructors

	
	
	public EptSpecialtyVo getEptSpecialtybyId(int id){
		EptSpecialtyVo eptSpecialtyVo = null;
		try {
			eptSpecialty = (EptSpecialty)(treeDao.getEntitybyId(id, EptSpecialty.class));
			eptSpecialtyVo = new EptSpecialtyVo(eptSpecialty);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.toString());
		}
		return eptSpecialtyVo;
	}
	
	/**
	 * 
	 */
	public List<EptSpecialty> getEptSpecialtybyParentId(int id){
		try {
			l = treeDao.getEntitybyParentId(id, EptSpecialty.class);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.toString());
		}
		return l;
	}
	
	public boolean modifyEptSpecialty(EptSpecialtyVo sv){
		try {
			treeDao.update(sv.adapterToEptSpecialty());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteEptSpecialtybyId(Integer id){
		try{
			treeDao.delete(id,EptSpecialty.class);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
	}
	
	public Integer insertEptSpecialty(EptSpecialtyVo eptSpecialtyVo){
		try {
			EptSpecialty sr = eptSpecialtyVo.adapterToEptSpecialty();
			Integer eptSpecialtyId = treeDao.insert(sr);
			sr.setId(eptSpecialtyId);
			sr.setDispIndex(eptSpecialtyId);
			treeDao.update(sr);
			return eptSpecialtyId;
		}catch(Exception e) {
			e.printStackTrace();
			return -1;
		}
		
		
	}

	public void setEptSpecialty(EptSpecialty eptSpecialty) {
		this.eptSpecialty = eptSpecialty;
	}

	public void setTableDao(ITableDao tableDao) {
		this.tableDao = tableDao;
	}
	
	public void setTreeDao(ITreeDao treeDao) {
		this.treeDao = treeDao;
	}
	/**
	 * 根据ID,获得数据总数
	 * @param id 
	 * @return 查询到的数据总数，若失败，返回-1
	 */
	@SuppressWarnings("unchecked")
	public Integer getCount(){
		Integer count = 0;  //记录总数
		String sql = null;
		//Map<String,Object> map = new HashMap<String,Object>();
		sql = "SELECT  COUNT(d.id) FROM  EptSpecialty d " +
		"where '1' = '1' ";
		//sql += " order by p.dispindex desc ";
		try {
			List<EptSpecialty> list = tableDao.otherQuery(sql, true, true, null);
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
	 * @return 包含查询到的所有EptSpecialtyVo实例的List，若失败，返回null
	 */
	@SuppressWarnings("unchecked")
	public PageInfo<EptSpecialtyVo> querydata(int pageindex, int pagesize) {
		List<EptSpecialtyVo> eptSpecialtyVoList = new ArrayList<EptSpecialtyVo>(); //VO集合
		int count =0;
		//Map<String,Object> map = new HashMap<String,Object>();
		String sql = " FROM  EptSpecialty d where '1' = '1'  ";
		//sql += " order by d.dispindex desc "; 
		try {
			//PO集合
			List<EptSpecialty> eptSpecialtyList = tableDao.querydata(sql, true, pageindex, pagesize, null);
			if(eptSpecialtyList != null && eptSpecialtyList.size() > 0){
				for(int i = 0 ; i < eptSpecialtyList.size() ; i++){
					EptSpecialtyVo srv = new EptSpecialtyVo(eptSpecialtyList.get(i));//PO -> VO
					eptSpecialtyVoList.add(srv);
				}
			}
			count = this.getCount();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new PageInfo<EptSpecialtyVo>(eptSpecialtyVoList,count,pageindex,pagesize);
	}
	/**
	 * 
	 * @Title: getSpecialtyListByParentId
	 * @Description: 获取以此ID为ParentId的子节点
	 * @param @param parentId
	 * @param @return    
	 * @return List<EptSpecialtyVo> 
	 * @author ly
	 * @date 2014-8-19 下午08:42:53
	 * @throws
	 */
	public List<EptSpecialtyVo> getSpecialtyListByParentId(int parentId) {
		
		List<EptSpecialtyVo> eptSpecialtyVoList = new ArrayList<EptSpecialtyVo>();
		try {
			List<EptSpecialty> eptSpecialtyList = this.treeDao.getEntitybyParentId(parentId, EptSpecialty.class);
			if(eptSpecialtyList != null && eptSpecialtyList.size() > 0){
				for(int i = 0 ; i < eptSpecialtyList.size() ; i++){
					EptSpecialtyVo spe = new EptSpecialtyVo(eptSpecialtyList.get(i));//PO -> VO
					eptSpecialtyVoList.add(spe);
				}
			}
			return eptSpecialtyVoList;
		} catch (Exception e) {
			logger.info("通过父节点获取所有菜单出现异常!");
		}
		return null;
	}
	
	/**
	 * 
	 * @Title: moveMenu
	 * @Description: 根据flag移动节点
	 * @param @param id
	 * @param @param flag    
	 * @return void 
	 * @author ly
	 * @date 2014-8-21 上午11:28:44
	 * @throws
	 */
	public void moveMenu(int id, int flag) {
		try {
			if(flag == 0){
				this.tableDao.up(id, EptSpecialty.class);
			}else{
				this.tableDao.down(id, EptSpecialty.class);
			}
		} catch (Exception e) {
			logger.info("上移下移菜单出现异常");
		}
	}

}