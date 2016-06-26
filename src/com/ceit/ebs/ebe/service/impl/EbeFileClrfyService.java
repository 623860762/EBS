package com.ceit.ebs.ebe.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.dao.impl.TableDao;
import com.ceit.common.util.PageInfo;
import com.ceit.ebs.ebe.entity.EbeFileClrfy;
import com.ceit.ebs.ebe.service.IEbeFileClrfyService;
import com.ceit.ebs.ebe.vo.EbeFileClrfyVo;

public class EbeFileClrfyService implements IEbeFileClrfyService {

	private EbeFileClrfy ebeFileClrfy;
	private ITableDao tableDao;

	// Constructors

	//测试用
	public EbeFileClrfyService(){
		
	}
	
	public EbeFileClrfyVo getEbeFileClrfybyId(int id){
		EbeFileClrfyVo ebeFileClrfyVo =null;
		try {
			ebeFileClrfy = (EbeFileClrfy)(tableDao.getEntitybyId(id, EbeFileClrfy.class));
			ebeFileClrfyVo = new EbeFileClrfyVo(ebeFileClrfy);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ebeFileClrfyVo;
	}
	
	public boolean modifyEbeFileClrfy(EbeFileClrfyVo s){
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			s.setOpTime(df.format(new Date()));
			tableDao.update(s.adapterToEbeFileClrfy());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteEbeFileClrfybyId(Integer id){
		try{
			tableDao.delete(id,EbeFileClrfy.class);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
	}
	
	public Integer insertEbeFileClrfy(EbeFileClrfyVo ebeFileClrfyVo){
		try {
			EbeFileClrfy sr = ebeFileClrfyVo.adapterToEbeFileClrfy();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			sr.setOpTime(df.format(new Date()));
			Integer ebeFileClrfyId = tableDao.insert(sr);
			sr.setId(ebeFileClrfyId);
			sr.setDispIndex(ebeFileClrfyId);
			tableDao.update(sr);
			return ebeFileClrfyId;
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
		//Map<String,Object> map = new HashMap<String,Object>();
		sql = "SELECT  COUNT(d.id) FROM  EbeFileClrfy d " +
		"where '1' = '1' ";
		//sql += " order by p.dispindex desc ";
		try {
			List<EbeFileClrfy> list = tableDao.otherQuery(sql, true, true, null);
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
	 * @return 包含查询到的所有EbeFileClrfyVo实例的List，若失败，返回null
	 */
	@SuppressWarnings("unchecked")
	public PageInfo<EbeFileClrfyVo> querydata(int pageindex, int pagesize) {
		List<EbeFileClrfyVo> ebeFileClrfyVoList = new ArrayList<EbeFileClrfyVo>(); //VO集合
		int count=0;
		//Map<String,Object> map = new HashMap<String,Object>();
		String sql = " FROM  EbeFileClrfy d where '1' = '1'  ";
		//sql += " order by d.dispindex desc "; 
		try {
			//PO集合
			List<EbeFileClrfy> ebeFileClrfyList = tableDao.querydata(sql, true, pageindex, pagesize, null);
			if(ebeFileClrfyList != null && ebeFileClrfyList.size() > 0){
				for(int i = 0 ; i < ebeFileClrfyList.size() ; i++){
					EbeFileClrfyVo srv = new EbeFileClrfyVo(ebeFileClrfyList.get(i));//PO -> VO
					ebeFileClrfyVoList.add(srv);
				}
			}
			count=this.getCount();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return  new PageInfo<EbeFileClrfyVo>(ebeFileClrfyVoList,count,pageindex,pagesize);
	}
	

	public void setEbeFileClrfy(EbeFileClrfy ebeFileClrfy) {
		this.ebeFileClrfy = ebeFileClrfy;
	}

	public void setTableDao(ITableDao tableDao) {
		this.tableDao = tableDao;
	}
	
	/**
	 * 批量删除澄清信息
	 * @param ids 澄清信息id集合
	 * @return 成功返回true，失败返回false
	 * @author hgl
	 * 2014/08/15
	 */
	public Boolean deleteEbeFileClrfybyIds(List<Integer> ids)
	{
		setTableDao(new TableDao());
		for(int i = 0; i < ids.size(); i++)	{
			if(deleteEbeFileClrfybyId(ids.get(i)) == false)	{
				return false;
			}
		}
		return true;	
	}
	/**
	 * 按包查看澄清信息
	 * @param packageId
	 * @return EbeFileClrfy对象列表
	 * @author hgl
	 * 2014/8/16
	 */
	public List<EbeFileClrfy> showClrfyByPackageId(Integer packageId){
		setTableDao(new TableDao());
		EbeFileClrfy ebeFileClrfy = new EbeFileClrfy();
		//判断是否已经加入过其他评审小组
		String sql=" FROM  EbeFileClrfy d where d.packageId = :packageId";
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("packageId", packageId);
			List list = tableDao.otherQuery(sql,true,true, params);
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return null;
	}
}
