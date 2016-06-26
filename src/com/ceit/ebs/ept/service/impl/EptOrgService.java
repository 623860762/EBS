package com.ceit.ebs.ept.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.dao.ITreeDao;
import com.ceit.common.util.PageInfo;
import com.ceit.ebs.ept.entity.EptOrg;
import com.ceit.ebs.ept.entity.EptSpecialty;
import com.ceit.ebs.ept.service.IEptOrgService;
import com.ceit.ebs.ept.vo.EptOrgVo;
import com.ceit.ebs.ept.vo.EptSpecialtyVo;


public class EptOrgService implements IEptOrgService {

	// Fields
	static Logger logger = Logger.getLogger(EptSpecialtyService.class.getName());
	private EptOrg eptOrg;
	private ITableDao tableDao;
	private ITreeDao treeDao;
	private List<EptOrg> l;

	//测试用
	public EptOrgService(){
	}
	public EptOrgService(ITreeDao itreeDao){
		this.treeDao=itreeDao;
	
	}
	// Constructors

	
	
	public EptOrgVo getEptOrgbyId(int id){
		EptOrgVo eptOrgVo = null;
		try {
			eptOrg = (EptOrg)(treeDao.getEntitybyId(id, EptOrg.class));
			eptOrgVo = new EptOrgVo(eptOrg);
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.toString());
		}
		return eptOrgVo;
	}
	/**
	 * 
	 */
	public List<EptOrg> getEptOrgbyParentId(int id){
		try {
			l = treeDao.getEntitybyParentId(id, EptOrg.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}
	
	public boolean modifyEptOrg(EptOrgVo sv){
		try {
			treeDao.update(sv.adapterToEptOrg());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteEptOrgbyId(Integer id){
		try{
			treeDao.delete(id,EptOrg.class);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
	}
	
	public Integer insertEptOrg(EptOrgVo eptOrgVo){
		try {
			EptOrg sr = eptOrgVo.adapterToEptOrg();
			Integer eptOrgId = treeDao.insert(sr);
			sr.setId(eptOrgId);
			sr.setDispIndex(eptOrgId);
			treeDao.update(sr);
			return eptOrgId;
		}catch(Exception e) {
			e.printStackTrace();
			return -1;
		}
		
		
	}

	public void setEptOrg(EptOrg eptOrg) {
		this.eptOrg = eptOrg;
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
		sql = "SELECT  COUNT(d.id) FROM  EptOrg d " +
		"where '1' = '1' ";
		//sql += " order by p.dispindex desc ";
		try {
			List<EptOrg> list = tableDao.otherQuery(sql, true, true, null);
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
	 * @return 包含查询到的所有EptOrgVo实例的List，若失败，返回null
	 */
	@SuppressWarnings("unchecked")
	public PageInfo<EptOrgVo> querydata(int pageindex, int pagesize) {
		List<EptOrgVo> eptOrgVoList = new ArrayList<EptOrgVo>(); //VO集合
		int count =0;
		//Map<String,Object> map = new HashMap<String,Object>();
		String sql = " FROM  EptOrg d where '1' = '1'  ";
		//sql += " order by d.dispindex desc "; 
		try {
			//PO集合
			List<EptOrg> eptOrgList = tableDao.querydata(sql, true, pageindex, pagesize, null);
			if(eptOrgList != null && eptOrgList.size() > 0){
				for(int i = 0 ; i < eptOrgList.size() ; i++){
					EptOrgVo srv = new EptOrgVo(eptOrgList.get(i));//PO -> VO
					eptOrgVoList.add(srv);
				}
			}
			count = this.getCount();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new PageInfo<EptOrgVo>(eptOrgVoList,count,pageindex,pagesize);
	}
	/* (non-Javadoc)
	 * @see com.ceit.ebs.ept.service.IEptOrgService#moveMenu(int, int)
	 */
	public void moveMenu(int id, int flag) {
		try {
			if(flag == 0){
				this.tableDao.up(id, EptOrg.class);
			}else{
				this.tableDao.down(id, EptOrg.class);
			}
		} catch (Exception e) {
			logger.info("上移下移菜单出现异常");
		}
		
	}
	/* (non-Javadoc)
	 * @see com.ceit.ebs.ept.service.IEptOrgService#getOrgListByParentId(int)
	 */
	public List<EptOrgVo> getOrgListByParentId(int parentId) {
		List<EptOrgVo> eptOrgVoList = new ArrayList<EptOrgVo>();
		try {
			List<EptOrg> eptOrgList = this.treeDao.getEntitybyParentId(parentId, EptOrg.class);
			if(eptOrgList != null && eptOrgList.size() > 0){
				for(int i = 0 ; i < eptOrgList.size() ; i++){
					EptOrgVo org = new EptOrgVo(eptOrgList.get(i));//PO -> VO
					eptOrgVoList.add(org);
				}
			}
			return eptOrgVoList;
		} catch (Exception e) {
			logger.info("通过父节点获取所有菜单出现异常!");
		}
		return null;
	}
	
	

}