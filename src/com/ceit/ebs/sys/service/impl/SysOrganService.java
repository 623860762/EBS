package com.ceit.ebs.sys.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.util.PageInfo;
import com.ceit.ebs.sys.entity.SysOrgan;
import com.ceit.ebs.sys.service.ISysOrganService;
import com.ceit.ebs.sys.vo.SysOrganVo;



/**
 * SysOrgan service
 * @author gr
 */

public class SysOrganService implements ISysOrganService {
	static Log log=LogFactory.getLog(SysOrganService.class);
	private SysOrgan sysOrgan;
	private ITableDao tableDao;
	
	public SysOrganVo getSysOrganbyId(int id){
		SysOrganVo sysOrganVo = null;
		try {
			sysOrgan = (SysOrgan)(tableDao.getEntitybyId(id, SysOrgan.class));
			sysOrganVo = new SysOrganVo(sysOrgan);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sysOrganVo;
	}
	
	public boolean modifySysOrgan(SysOrganVo so){
		try {
			SysOrgan s = so.adapterToSysOrgan();
			tableDao.update(s);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteSysOrganbyId(int id){
		try{
			tableDao.delete(id,SysOrgan.class);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
	}
	
	public Integer insertSysOrgan(SysOrganVo sysOrganVo){
		try {
			SysOrgan sr = sysOrganVo.adapterToSysOrgan();
			Integer sysOrganId = tableDao.insert(sr);
			sr.setId(sysOrganId);
			sr.setDispIndex(sysOrganId);
			tableDao.update(sr);
			return sysOrganId;
		}catch(Exception e) {
			e.printStackTrace();
			return -1;
		}
		
		
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
		sql = "SELECT  COUNT(id) FROM  SysOrgan " +
		"where '1' = '1' ";
		try {
			List<SysOrgan> list = tableDao.otherQuery(sql, true, true, null);
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
	 * @return 包含查询到的所有SysOrganVo实例的List，若失败，返回null
	 */
	@SuppressWarnings("unchecked")
	public PageInfo<SysOrganVo> querydata(int pageindex, int pagesize) {
		List<SysOrganVo> sysOrganVoList = new ArrayList<SysOrganVo>(); //VO集合
		String sql = " FROM  SysOrgan d where '1' = '1'  ";
		int count = 0;
		try {
			//PO集合
			List<SysOrgan> sysOrganList = tableDao.querydata(sql, true, pageindex, pagesize, null);
			if(sysOrganList != null && sysOrganList.size() > 0){
				for(int i = 0 ; i < sysOrganList.size() ; i++){
					SysOrganVo srv = new SysOrganVo(sysOrganList.get(i));//PO -> VO
					sysOrganVoList.add(srv);
				}
			}
			count = this.getCount();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new PageInfo<SysOrganVo>(sysOrganVoList,count,pageindex,pagesize);
	}

	public void setSysOrgan(SysOrgan sysOrgan) {
		this.sysOrgan = sysOrgan;
	}

	public void setTableDao(ITableDao tableDao) {
		this.tableDao = tableDao;
	}

	/**
	 * 通过parentId获取组织机构子节点
	 * @author wujinshui
	 */
	@SuppressWarnings("unchecked")
	public List<SysOrganVo> getOrganListByParentId(int parentId) {
		List<SysOrganVo> sysOrganVoList = new ArrayList<SysOrganVo>();
		String hql = "FROM SysOrgan t where t.parentId=:parentId order by t.dispIndex";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("parentId", parentId);
		try {
			List<SysOrgan> sysOrganList = this.tableDao.otherQuery(hql, true, true, map);
			if(sysOrganList != null && sysOrganList.size() > 0){
				for(int i = 0 ; i < sysOrganList.size() ; i++){
					SysOrganVo srv = new SysOrganVo(sysOrganList.get(i));//PO -> VO
					sysOrganVoList.add(srv);
				}
			}
			return sysOrganVoList;
		} catch (Exception e) {
			log.info("通过父节点获取所有子级组织机构出现异常!");
		}
		return null;
	}

	/**
	 * 上移下移菜单
	 */
	public void moveOrgan(int id, int flag) {
		try {
			if(flag == 0){
				this.tableDao.up(id, SysOrgan.class);
			}else{
				this.tableDao.down(id, SysOrgan.class);
			}
		} catch (Exception e) {
			log.info("上移下移菜单出现异常");
		}
	}

}