package com.ceit.ebs.sup.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.dao.impl.TableDao;
import com.ceit.common.util.PageInfo;
import com.ceit.ebs.ebp.entity.EbpFileUpload;
import com.ceit.ebs.ebp.service.impl.EbpObjectService;
import com.ceit.ebs.ebp.service.impl.EbpPackageService;
import com.ceit.ebs.ebp.service.impl.EbpProjectService;
import com.ceit.ebs.ebp.vo.EbpObjectVo;
import com.ceit.ebs.ebp.vo.EbpPackageVo;
import com.ceit.ebs.ebp.vo.EbpProjectVo;
import com.ceit.ebs.sup.entity.SupProjectSupplier;
import com.ceit.ebs.sup.service.ISupProjectSupplierService;
import com.ceit.ebs.sup.vo.SupProjectSupplierVo;
import com.ceit.ebs.sup.vo.SupSupplierVo;

/**
 * SupProjectSupplierService 是为系统的附件提供服务的类，包括所有相关操作的业务逻辑。
 * @author czg
 * date 2014-8-15
 */
public class SupProjectSupplierService implements ISupProjectSupplierService{
	private SupProjectSupplier supProjectSupplier;
	private ITableDao tableDao;
	
	
	
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
		sql="SELECT COUNT(d.id) FROM SupProjectSupplier d "+"where '1'='1'";
		try {
			List<SupProjectSupplier> list = tableDao.otherQuery(sql, true, true, null);
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
	 * @return 包含查询到的所有SupProjectSupplierVo实例的PageInfo，若失败，返回null
	 */
	@SuppressWarnings("unchecked")
	public PageInfo<SupProjectSupplierVo> querydata(int pageindex, int pagesize) {
		// TODO Auto-generated method stub
		List<SupProjectSupplierVo> supProjectSupplierVoList = new ArrayList<SupProjectSupplierVo>(); //VO集合
		int count=0;
		//Map<String,Object> map = new HashMap<String,Object>();
		String sql = " FROM  SupProjectSupplier d where '1' = '1'  ";
		//sql += " order by d.dispindex desc "; 
		try {
			//PO集合
			List<SupProjectSupplier> supProjectSupplierList = tableDao.querydata(sql, true, pageindex, pagesize, null);
			if(supProjectSupplierList != null && supProjectSupplierList.size() > 0){
				for(int i = 0 ; i < supProjectSupplierList.size() ; i++){
					SupProjectSupplierVo efuv = new SupProjectSupplierVo(supProjectSupplierList.get(i));//PO -> VO
					supProjectSupplierVoList.add(efuv);
				}
			}
			count=this.getCount();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return  new PageInfo<SupProjectSupplierVo>(supProjectSupplierVoList,count,pageindex,pagesize);
		
	}
	/**
	 * 根据定标的ID查找定标
	 * @param  supProjectSupplierId 要查询的上传文件ID值
	 * @return 查询到的SupProjectSupplier实例
	 */
	public SupProjectSupplierVo getSupProjectSupplierbyId(Integer supProjectSupplierId) {
		// TODO Auto-generated method stub
		SupProjectSupplierVo supProjectSupplierVo=null;
		try {
			supProjectSupplier = (SupProjectSupplier)tableDao.getEntitybyId(supProjectSupplierId, SupProjectSupplier.class);
			supProjectSupplierVo=new SupProjectSupplierVo(supProjectSupplier);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return supProjectSupplierVo;	
	}
	/**
	 * 修改定标实例
	 * @param  supProjectSupplierVo 要修改的定标Vo
	 * @return 修改成功，返回 true，若失败，返回 false
	 */
	public boolean modifySupProjectSupplier(SupProjectSupplierVo supProjectSupplierVo) {
		// TODO Auto-generated method stub
		try {
			tableDao.update(supProjectSupplierVo.adapterToSupProjectSupplier());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 根据定标的ID删除定标
	 * @param  supProjectSupplierId 要删除的定标ID值
	 * @return 删除成功， 返回 true，若失败，返回 false
	 */
	public boolean deleteSupProjectSupplierbyId(Integer supProjectSupplierId) {
		// TODO Auto-generated method stub
		try {
			tableDao.delete(supProjectSupplierId, SupProjectSupplier.class);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 新增一个定标
	 * @param supProjectSupplierVo 要添加的SupProjectSupplierVo实例
	 * @return 添加的定标在数据库中的ID值，若失败返回-1
	 */
	public Integer insertSupProjectSupplier(SupProjectSupplierVo supProjectSupplierVo) {
		// TODO Auto-generated method stub
		try {
			SupProjectSupplier ew = supProjectSupplierVo.adapterToSupProjectSupplier();
			Integer supProjectSupplierId = tableDao.insert(ew);
			ew.setId(supProjectSupplierId);
			ew.setDispIndex(supProjectSupplierId);
			tableDao.update(ew);
			return supProjectSupplierId;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public void setSupProjectSupplier(SupProjectSupplier supProjectSupplier) {
		// TODO Auto-generated method stub
		this.supProjectSupplier=supProjectSupplier;
	}

	public void setTableDao(ITableDao tableDao) {
		// TODO Auto-generated method stub
		this.tableDao=tableDao;
	}
	
	/**
	 * 确认购买招标文件
	 * @author czg
	 * @param supId 供应商ID
	 * @param packageId 购买的标包ID
	 * @return 标识成功返回true，失败返回false
	 * date 2014-8-17  已测试
	 */
	
	@SuppressWarnings("unchecked")
	public Boolean buyObjectFiles(Integer supId,Integer packageId){
		SupProjectSupplierVo ssv = new SupProjectSupplierVo();
		SupSupplierService sss = new SupSupplierService();
		sss.setTableDao(tableDao);
		SupSupplierVo ss = sss.getSupSupplierbyId(supId);//查找到供应商
//		System.out.println(ss.getId());
		try{
			if(ss != null && ss.getAuditStatus().equals("2")){//供应商审核通过
				ssv.setPackageId(packageId);
				EbpPackageService eos = new EbpPackageService();
				eos.setTableDao(tableDao);
				EbpPackageVo ep = eos.getEbpPackagebyId(packageId);
				if(ep != null){
					ssv.setObjectId(ep.getObjectId());
					ssv.setProjectId(ep.getProjectId());
				}
				ssv.setSupId(supId);
				ssv.setPayStatus(1);
				ssv.setOpTime(getTime());
				//在sup_project_supplier中插入一条新纪录
				if(insertSupProjectSupplier(ssv) == -1){
					return false;
				}
				return true;
			}
			return false;
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
				
	}
	
	
	/**
	 * 根据项目ID、包ID供应商取得招标文件的路径
	 * @author czg
	 * @param  supId 供应商ID
	 * @param  projectId 文件对应的项目ID
	 * @param  packageId 文件对应的包ID
	 * @return 取到文件路径，返回 true，若失败，返回 false
	 * date 2014-8-17  已测试
	 */
	@SuppressWarnings("unchecked")
	public List<String> getFilePath(Integer supId,Integer projectId,Integer packageId){
		List<EbpFileUpload> ebpFileUploadlList=new ArrayList<EbpFileUpload>();
		String sql = null;
		Map<String,Object> map = new HashMap<String,Object>();
		List<String> filePath = new ArrayList<String>();//保存标中所有文件的路径
		List<SupProjectSupplier> spsv = new ArrayList<SupProjectSupplier>();
		try{
			sql="from SupProjectSupplier d where d.packageId = :packageId and d.projectId = :projectId and d.supId = :supId";
			map.put("packageId", packageId);
			map.put("projectId", projectId);
			map.put("supId", supId); 
			spsv = tableDao.querydata(sql, true, 1, 10, map);
			
			if(spsv != null && spsv.size()>0 && spsv.get(0).getPayStatus()==1){//供应商已经支付该包的费用时才可下载文件
				sql = " from EbpFileUpload d where d.packageId=:packageId and d.projectId = :projectId ";				
				map.clear();
				map.put("packageId", packageId);
				map.put("projectId", projectId);				
				ebpFileUploadlList = tableDao.querydata(sql, true, 1, 50, map);
				
				for(int i=0;i<ebpFileUploadlList.size();i++){
					filePath.add(ebpFileUploadlList.get(i).getFilePath());//获取标下所有文件的路径
				}
				spsv.get(0).setIsLoad(1);//设置下载文件标识为1
				spsv.get(0).setOpTime(getTime());
				SupProjectSupplierVo sv = new SupProjectSupplierVo(spsv.get(0));
				this.modifySupProjectSupplier(sv);//写入数据库
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return filePath;			
	}	
	
	/**
	 * 根据项目ID、包ID获得投该标的供应商的个数
	 * @author czg
	 * @param  packageId 文件对应的包ID
	 * @return 返回投标的供应商个数
	 * date 2014-8-21  已测试
	 */
	@SuppressWarnings("unchecked")
	public Integer getSupNum(Integer packageId){
		int count=0;
		String sql=null;
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			sql="from SupProjectSupplier d where d.packageId = :packageId";
			map.put("packageId", packageId);
			List<SupProjectSupplier> spsv = new ArrayList<SupProjectSupplier>(); 
			spsv = tableDao.querydata(sql, true, 1, 50, map); 
			count=spsv.size();
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
	}
	
	
	/**
	 * 根据供应商ID、项目ID、包ID取得SupProjectSupplierVo
	 * @author czg
	 * @param  supId 供应商ID
	 * @param  projectId 文件对应的项目ID
	 * @param  packageId 文件对应的包ID
	 * @return 返回SupProjectSupplierVo
	 * date 2014-8-17  已测试
	 */
	@SuppressWarnings("unchecked")
	public SupProjectSupplierVo getVoByOtherId(Integer supId,Integer projectId,Integer packageId){
		SupProjectSupplierVo spsv = new SupProjectSupplierVo();
		String sql=null;
		Map<String,Object> map = new HashMap<String,Object>();
		List<SupProjectSupplier> sps = new ArrayList<SupProjectSupplier>();
		try{
			sql="from SupProjectSupplier d where d.packageId = :packageId and d.projectId = :projectId and d.supId = :supId";
			map.put("packageId", packageId);
			map.put("projectId", projectId);
			map.put("supId", supId); 
			sps = tableDao.querydata(sql, true, 1, 10, map);
			if(sps.size()>0){
				spsv = new SupProjectSupplierVo(sps.get(0));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return spsv;
	}
	
	
	
	
	/**
	 * 获取系统时间
	 * @author czg
	 * @return 返回时间字符串
	 * date 2014-8-17  已测试
	 */
	public String getTime(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		return df.format(new Date());
	}

}
