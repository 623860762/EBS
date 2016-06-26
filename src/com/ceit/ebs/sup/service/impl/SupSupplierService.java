package com.ceit.ebs.sup.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.util.PageInfo;
import com.ceit.ebs.sup.entity.SupSupplier;
import com.ceit.ebs.sup.service.ISupSupplierService;
import com.ceit.ebs.sup.vo.SupSupplierVo;

/**
 * SupSupplierService 是为系统的供应商基本信息提供服务的类，包括所有相关操作的业务逻辑。
 * @author czg
 * date 2014-8-15
 */
public class SupSupplierService implements ISupSupplierService {
	private SupSupplier supSupplier;
	private ITableDao tableDao;
	
	
	public SupSupplierService(){
		
	}
	
	/**
	 * 供应商审核不通过
	 * @author czg
	 * @param supId 供应商ID
	 * @return 标识成功返回true，失败返回false
	 * date 2014-8-21  已测试
	 */
	public Boolean failAudit(Integer supId){
		try{
			SupSupplierVo ssv=new SupSupplierVo();
			ssv=this.getSupSupplierbyId(supId);
			ssv.setAuditStatus("1");
			this.modifySupSupplier(ssv);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}		
	}
	/**
	 * 供应商审核通过
	 * @author czg
	 * @param supId 供应商ID
	 * @return 标识成功返回true，失败返回false
	 * date 2014-8-21  已测试
	 */
	public Boolean passAudit(Integer supId){
		try{
			SupSupplierVo ssv=new SupSupplierVo();
			ssv=this.getSupSupplierbyId(supId);
			ssv.setAuditStatus("2");
			this.modifySupSupplier(ssv);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}		
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
		sql="SELECT COUNT(d.id) FROM SupSupplier d "+"where '1'='1'";
		try {
			List<SupSupplier> list = tableDao.otherQuery(sql, true, true, null);
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
	 * @return 包含查询到的所有SupSupplierVo实例的PageInfo，若失败，返回null
	 */
	@SuppressWarnings("unchecked")
	public PageInfo<SupSupplierVo> querydata(int pageindex, int pagesize) {
		// TODO Auto-generated method stub
		List<SupSupplierVo> supSupplierVoList = new ArrayList<SupSupplierVo>(); //VO集合
		int count=0;
		//Map<String,Object> map = new HashMap<String,Object>();
		String sql = " FROM  SupSupplier d where '1' = '1'  ";
		//sql += " order by d.dispindex desc "; 
		try {
			//PO集合
			List<SupSupplier> supSupplierList = tableDao.querydata(sql, true, pageindex, pagesize, null);
			if(supSupplierList != null && supSupplierList.size() > 0){
				for(int i = 0 ; i < supSupplierList.size() ; i++){
					SupSupplierVo efuv = new SupSupplierVo(supSupplierList.get(i));//PO -> VO
					supSupplierVoList.add(efuv);
				}
			}
			count=this.getCount();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return  new PageInfo<SupSupplierVo>(supSupplierVoList,count,pageindex,pagesize);
		
	}
	/**
	 * 根据定标的ID查找定标
	 * @param  supSupplierId 要查询的上传文件ID值
	 * @return 查询到的SupSupplier实例
	 */
	public SupSupplierVo getSupSupplierbyId(Integer supSupplierId) {
		// TODO Auto-generated method stub
		SupSupplierVo supSupplierVo=null;
		try {
			supSupplier = (SupSupplier)tableDao.getEntitybyId(supSupplierId, SupSupplier.class);			
			if(supSupplier!=null&&!(("").equals(supSupplier))){
				supSupplierVo=new SupSupplierVo(supSupplier);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return supSupplierVo;	
	}
	/**
	 * 修改定标实例
	 * @param  supSupplierVo 要修改的定标Vo
	 * @return 修改成功，返回 true，若失败，返回 false
	 */
	public boolean modifySupSupplier(SupSupplierVo supSupplierVo) {
		// TODO Auto-generated method stub
		try {
			tableDao.update(supSupplierVo.adapterToSupSupplier());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 根据定标的ID删除定标
	 * @param  supSupplierId 要删除的定标ID值
	 * @return 删除成功， 返回 true，若失败，返回 false
	 */
	public boolean deleteSupSupplierbyId(Integer supSupplierId) {
		// TODO Auto-generated method stub
		try {
			tableDao.delete(supSupplierId, SupSupplier.class);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 新增一个定标
	 * @param supSupplierVo 要添加的SupSupplierVo实例
	 * @return 添加的定标在数据库中的ID值，若失败返回-1
	 */
	public Integer insertSupSupplier(SupSupplierVo supSupplierVo) {
		// TODO Auto-generated method stub
		try {
			SupSupplier ew = supSupplierVo.adapterToSupSupplier();
			Integer supSupplierId = tableDao.insert(ew);
			//sr.setId(sysRoleId);
			//sr.setDispindex(sysRoleId);
			tableDao.update(ew);
			return supSupplierId;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public void setSupSupplier(SupSupplier supSupplier) {
		// TODO Auto-generated method stub
		this.supSupplier=supSupplier;
	}

	public void setTableDao(ITableDao tableDao) {
		// TODO Auto-generated method stub
		this.tableDao=tableDao;
	}
	
	
}
