package com.ceit.ebs.ebp.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.util.PageInfo;
import com.ceit.ebs.ebp.entity.EbpFileUpload;
import com.ceit.ebs.ebp.service.IEbpFileUploadService;
import com.ceit.ebs.ebp.vo.EbpFileUploadVo;

/**
 * EbpFileUploadService 是为系统的上传文件提供服务的类，包括所有相关操作的业务逻辑。
 * @author czg
 * date 2014-8-15
 */

public class EbpFileUploadService implements IEbpFileUploadService{
	private EbpFileUpload ebpFileUpload;
	private ITableDao tableDao;
	
	
	public EbpFileUploadService(){
		
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
		sql="SELECT COUNT(d.id) FROM EbpFileUpload d "+"where '1'='1'";
		try {
			List<EbpFileUpload> list = tableDao.otherQuery(sql, true, true, null);
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
	 * @return 包含查询到的所有EbpFileUploadVo实例的PageInfo，若失败，返回null
	 */
	@SuppressWarnings("unchecked")
	public PageInfo<EbpFileUploadVo> querydata(int pageindex, int pagesize) {
		// TODO Auto-generated method stub
		List<EbpFileUploadVo> ebpFileUploadVoList = new ArrayList<EbpFileUploadVo>(); //VO集合
		int count=0;
		//Map<String,Object> map = new HashMap<String,Object>();
		String sql = " FROM  EbpFileUpload d where '1' = '1'  ";
		//sql += " order by d.dispindex desc "; 
		try {
			//PO集合
			List<EbpFileUpload> ebpFileUploadList = tableDao.querydata(sql, true, pageindex, pagesize, null);
			if(ebpFileUploadList != null && ebpFileUploadList.size() > 0){
				for(int i = 0 ; i < ebpFileUploadList.size() ; i++){
					EbpFileUploadVo efuv = new EbpFileUploadVo(ebpFileUploadList.get(i));//PO -> VO
					ebpFileUploadVoList.add(efuv);
				}
			}
			count=this.getCount();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return  new PageInfo<EbpFileUploadVo>(ebpFileUploadVoList,count,pageindex,pagesize);
		
	}
	/**
	 * 根据定标的ID查找定标
	 * @param  ebpFileUploadId 要查询的上传文件ID值
	 * @return 查询到的EbpFileUpload实例
	 */
	public EbpFileUploadVo getEbpFileUploadbyId(Integer ebpFileUploadId) {
		// TODO Auto-generated method stub
		EbpFileUploadVo ebpFileUploadVo=null;
		try {
			ebpFileUpload = (EbpFileUpload)tableDao.getEntitybyId(ebpFileUploadId, EbpFileUpload.class);
			ebpFileUploadVo=new EbpFileUploadVo(ebpFileUpload);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ebpFileUploadVo;	
	}
	/**
	 * 修改定标实例
	 * @param  ebpFileUploadVo 要修改的定标Vo
	 * @return 修改成功，返回 true，若失败，返回 false
	 */
	public boolean modifyEbpFileUpload(EbpFileUploadVo ebpFileUploadVo) {
		// TODO Auto-generated method stub
		try {
			tableDao.update(ebpFileUploadVo.adapterToEbpFileUpload());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 根据定标的ID删除定标
	 * @param  ebpFileUploadId 要删除的定标ID值
	 * @return 删除成功， 返回 true，若失败，返回 false
	 */
	public boolean deleteEbpFileUploadbyId(Integer ebpFileUploadId) {
		// TODO Auto-generated method stub
		try {
			tableDao.delete(ebpFileUploadId, EbpFileUpload.class);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 新增一个定标
	 * @param ebpFileUploadVo 要添加的EbpFileUploadVo实例
	 * @return 添加的定标在数据库中的ID值，若失败返回-1
	 */
	public Integer insertEbpFileUpload(EbpFileUploadVo ebpFileUploadVo) {
		// TODO Auto-generated method stub
		try {
			EbpFileUpload ew = ebpFileUploadVo.adapterToEbpFileUpload();
			Integer ebpFileUploadId = tableDao.insert(ew);
			ew.setId(ebpFileUploadId);
			ew.setDispIndex(ebpFileUploadId);
			tableDao.update(ew);
			return ebpFileUploadId;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public void setEbpFileUpload(EbpFileUpload ebpFileUpload) {
		// TODO Auto-generated method stub
		this.ebpFileUpload=ebpFileUpload;
	}

	public void setTableDao(ITableDao tableDao) {
		// TODO Auto-generated method stub
		this.tableDao=tableDao;
	}

}
