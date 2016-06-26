package com.ceit.ebs.sup.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.util.PageInfo;
import com.ceit.ebs.ebp.service.impl.EbpPackageService;
import com.ceit.ebs.ebp.vo.EbpPackageVo;
import com.ceit.ebs.sup.entity.SupReplyVal;
import com.ceit.ebs.sup.service.ISupReplyValService;
import com.ceit.ebs.sup.vo.SupAttachmentVo;
import com.ceit.ebs.sup.vo.SupReplyValVo;
/**
 * SupReplyValService 是为系统的供应商应答值提供服务的类，包括所有相关操作的业务逻辑。
 * @author czg
 * date 2014-8-15
 */
public class SupReplyValService implements ISupReplyValService{

	private SupReplyVal supReplyVal;
	private ITableDao tableDao;
	
	public SupReplyValService(){
		
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
		sql="SELECT COUNT(d.id) FROM SupReplyVal d "+"where '1'='1'";
		try {
			List<SupReplyVal> list = tableDao.otherQuery(sql, true, true, null);
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
	 * @return 包含查询到的所有SupReplyValVo实例的PageInfo，若失败，返回null
	 */
	@SuppressWarnings("unchecked")
	public PageInfo<SupReplyValVo> querydata(int pageindex, int pagesize) {
		// TODO Auto-generated method stub
		List<SupReplyValVo> supReplyValVoList = new ArrayList<SupReplyValVo>(); //VO集合
		int count=0;
		//Map<String,Object> map = new HashMap<String,Object>();
		String sql = " FROM  SupReplyVal d where '1' = '1'  ";
		//sql += " order by d.dispindex desc "; 
		try {
			//PO集合
			List<SupReplyVal> supReplyValList = tableDao.querydata(sql, true, pageindex, pagesize, null);
			if(supReplyValList != null && supReplyValList.size() > 0){
				for(int i = 0 ; i < supReplyValList.size() ; i++){
					SupReplyValVo efuv = new SupReplyValVo(supReplyValList.get(i));//PO -> VO
					supReplyValVoList.add(efuv);
				}
			}
			count=this.getCount();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return  new PageInfo<SupReplyValVo>(supReplyValVoList,count,pageindex,pagesize);
		
	}
	/**
	 * 根据定标的ID查找定标
	 * @param  supReplyValId 要查询的上传文件ID值
	 * @return 查询到的SupReplyVal实例
	 */
	public SupReplyValVo getSupReplyValbyId(Integer supReplyValId) {
		// TODO Auto-generated method stub
		SupReplyValVo supReplyValVo=null;
		try {
			supReplyVal = (SupReplyVal)tableDao.getEntitybyId(supReplyValId, SupReplyVal.class);
			supReplyValVo=new SupReplyValVo(supReplyVal);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return supReplyValVo;	
	}
	/**
	 * 修改定标实例
	 * @param  supReplyValVo 要修改的定标Vo
	 * @return 修改成功，返回 true，若失败，返回 false
	 */
	public boolean modifySupReplyVal(SupReplyValVo supReplyValVo) {
		// TODO Auto-generated method stub
		try {
			tableDao.update(supReplyValVo.adapterToSupReplyVal());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 根据定标的ID删除定标
	 * @param  supReplyValId 要删除的定标ID值
	 * @return 删除成功， 返回 true，若失败，返回 false
	 */
	public boolean deleteSupReplyValbyId(Integer supReplyValId) {
		// TODO Auto-generated method stub
		try {
			tableDao.delete(supReplyValId, SupReplyVal.class);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 新增一个定标
	 * @param supReplyValVo 要添加的SupReplyValVo实例
	 * @return 添加的定标在数据库中的ID值，若失败返回-1
	 */
	public Integer insertSupReplyVal(SupReplyValVo supReplyValVo) {
		// TODO Auto-generated method stub
		try {
			SupReplyVal ew = supReplyValVo.adapterToSupReplyVal();
			Integer supReplyValId = tableDao.insert(ew);
			ew.setId(supReplyValId);
			ew.setDispIndex(supReplyValId);
			tableDao.update(ew);
			return supReplyValId;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public void setSupReplyVal(SupReplyVal supReplyVal) {
		// TODO Auto-generated method stub
		this.supReplyVal=supReplyVal;
	}

	public void setTableDao(ITableDao tableDao) {
		// TODO Auto-generated method stub
		this.tableDao=tableDao;
	}
	
	/**
	 * 供应商上传报价
	 * @author czg
	 * @param supId 供应商ID
	 * @param projectId 项目Id
	 * @param packageId 包Id
	 * @param price 报价
	 * @return 保存成功返回true，失败返回false
	 * date 2014-8-21  已测试
	 */
	public Boolean uploadPrice(Integer supId,Integer projectId,Integer packageId,Integer price){

		try{
			SupReplyValVo srvv=new SupReplyValVo();
			srvv.setProjectId(projectId);
			srvv.setPackageId(packageId);
			srvv.setSupplierId(supId);
			srvv.setTermValueEnc(price);
			srvv.setTermName("4");
			srvv.setIsMust("Y");
			srvv.setTermType("num");
			srvv.setTermOrder(4);
			srvv.setOpTime(getTime());
			srvv.setCreateTime(getTime());
			if(this.insertSupReplyVal(srvv)!=-1){
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 获取供应商上传的报价
	 * @author czg
	 * @param supId 供应商ID
	 * @param projectId 项目Id
	 * @param packageId 包Id
	 * @return 获取成功返回报价，失败返回-1
	 * date 2014-8-21  已测试
	 */
	@SuppressWarnings("unchecked")
	public Integer getPrice(Integer supId,Integer projectId,Integer packageId){

		String sql=null;
		Map<String,Object> map=new HashMap<String,Object>();
		Integer price=-1;
		try{
			List<SupReplyVal> srv=new ArrayList<SupReplyVal>();
			sql="from SupReplyVal d where d.projectId=:projectId and d.packageId=:packageId and d.supplierId=:supId";
			map.put("projectId", projectId);
			map.put("packageId", packageId);
			map.put("supId", supId);
			srv=tableDao.querydata(sql, true, 0, 2, map);
			if(srv.get(0)!=null && srv.size()>0){
				price=srv.get(0).getTermValueEnc();
				return price;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return price;
	}
	
	/**
	 * 供应商上传文件
	 * @author czg
	 * @param supId 供应商ID
	 * @param projectId 项目Id
	 * @param packageId 包Id
	 * @param fileName 文件名
	 * @param termName 应答项名称1、价格文件2、商务文件、3技术文件
	 * @return 保存成功返回true，失败返回false
	 * date 2014-8-21  已测试
	 */
	public Boolean uploadFile(Integer supId,Integer projectId,Integer packageId,String fileName,Integer termName){

		try{  
			//在SupAttachment中保存
		    String a[] = fileName.split("\\.");  
		    System.out.println(fileName);
		    System.out.println(a[0]);
			SupAttachmentService sas = new SupAttachmentService();
			sas.setTableDao(tableDao);
			SupAttachmentVo sav = new SupAttachmentVo();
			sav.setProjectId(projectId);
			sav.setPackageId(packageId);
			sav.setAttachmentName(a[0]);
			sav.setAttchmentType(a[1]);
			sav.setAttachmentPath("D:\\"+projectId+"\\"+packageId+"\\"+fileName);
			sav.setOpTime(getTime());
			Integer attachId = sas.insertSupAttachment(sav);
			if(attachId!=-1){//插入附件成功
				SupReplyValVo srvv = new SupReplyValVo();
				srvv.setProjectId(projectId);
				srvv.setPackageId(packageId);
				EbpPackageService eps = new EbpPackageService();
				eps.setTableDao(tableDao);
				EbpPackageVo epv= new EbpPackageVo();
				epv=eps.getEbpPackagebyId(packageId);
				if(!epv.getObjectId().equals("")){
					srvv.setObjectId(epv.getObjectId());
				}
				srvv.setTermName(termName+"");
				srvv.setTermValueEnc(attachId);
				srvv.setIsMust("Y");
				srvv.setTermType("file");
				srvv.setTermOrder(termName);
				srvv.setOpTime(getTime());
				srvv.setSupplierId(supId);
				srvv.setCreateTime(getTime());
				if(this.insertSupReplyVal(srvv)!=-1){
					return true;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 获取投标文件地址
	 * @author czg
	 * @param supId 供应商ID
	 * @param projectId 项目Id
	 * @param packageId 包Id
	 * @return 保存成功返回true，失败返回false
	 * date 2014-8-21  已测试
	 */
	@SuppressWarnings("unchecked")
	public List<String> getFilePath(Integer supId,Integer projectId,Integer packageId){
		String sql=null;
		Map<String,Object> map = new HashMap<String,Object>();
		List<String> filePath = new ArrayList<String>();
		Integer attchId;
		try{
			sql = "from SupReplyVal d where d.projectId=:projectId and d.packageId=:packageId and d.supplierId=:supId";
	        map.put("projectId", projectId);
	        map.put("packageId", packageId);
	        map.put("supId", supId);
	        List<SupReplyVal>  srv = new ArrayList<SupReplyVal>();
	        srv=tableDao.querydata(sql, true, 0, 5, map);
	        SupAttachmentService sas = new SupAttachmentService();		        
	        sas.setTableDao(tableDao);
	        SupAttachmentVo sav = new SupAttachmentVo();
	        for(int i=0;i<srv.size();i++){
	        	attchId=srv.get(i).getTermValueEnc();
	        	System.out.println(attchId);
		        sav=sas.getSupAttachmentbyId(attchId);
		        filePath.add(sav.getAttachmentPath());
	        }	        
		}catch(Exception e){
			e.printStackTrace();
		}
		return filePath;
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
