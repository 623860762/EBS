package com.ceit.ebs.sup.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.util.PageInfo;
import com.ceit.ebs.sup.entity.SupAttachment;
import com.ceit.ebs.sup.service.ISupAttachmentService;
import com.ceit.ebs.sup.vo.SupAttachmentVo;

/**
 * SupAttachmentService 是为系统的附件提供服务的类，包括所有相关操作的业务逻辑。
 * @author czg
 * date 2014-8-15
 */

public class SupAttachmentService implements ISupAttachmentService {
	private SupAttachment supAttachment;
	private ITableDao tableDao;
	
	
	public SupAttachmentService(){
		
	}
	
	/**
	 * 根据主键ID,获得数据总数
	 * @return 查询到的数据总数，若失败，返回-1
	 */
	public Integer getCount() {
		// TODO Auto-generated method stub
		Integer count = 0;//记录总数
		String sql = null;
		//Map<String,Object> map = new HashMap<String,Object>();
		sql="SELECT COUNT(d.id) FROM SupAttachment d "+"where '1'='1'";
		try {
			List<SupAttachment> list = tableDao.otherQuery(sql, true, true, null);
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
	 * @return 包含查询到的所有SupAttachmentVo实例的PageInfo，若失败，返回null
	 */
	public PageInfo<SupAttachmentVo> querydata(int pageindex, int pagesize) {
		// TODO Auto-generated method stub
		List<SupAttachmentVo> supAttachmentVoList = new ArrayList<SupAttachmentVo>(); //VO集合
		int count=0;
		//Map<String,Object> map = new HashMap<String,Object>();
		String sql = " FROM  SupAttachment d where '1' = '1'  ";
		//sql += " order by d.dispindex desc "; 
		try {
			//PO集合
			List<SupAttachment> supAttachmentList = tableDao.querydata(sql, true, pageindex, pagesize, null);
			if(supAttachmentList != null && supAttachmentList.size() > 0){
				for(int i = 0 ; i < supAttachmentList.size() ; i++){
					SupAttachmentVo efuv = new SupAttachmentVo(supAttachmentList.get(i));//PO -> VO
					supAttachmentVoList.add(efuv);
				}
			}
			count=this.getCount();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return  new PageInfo<SupAttachmentVo>(supAttachmentVoList,count,pageindex,pagesize);
		
	}
	/**
	 * 根据定标的ID查找定标
	 * @param  supAttachmentId 要查询的上传文件ID值
	 * @return 查询到的SupAttachment实例
	 */
	public SupAttachmentVo getSupAttachmentbyId(Integer supAttachmentId) {
		// TODO Auto-generated method stub
		SupAttachmentVo supAttachmentVo=null;
		try {
			supAttachment = (SupAttachment)tableDao.getEntitybyId(supAttachmentId, SupAttachment.class);
			supAttachmentVo=new SupAttachmentVo(supAttachment);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return supAttachmentVo;	
	}
	/**
	 * 修改定标实例
	 * @param  supAttachmentVo 要修改的定标Vo
	 * @return 修改成功，返回 true，若失败，返回 false
	 */
	public boolean modifySupAttachment(SupAttachmentVo supAttachmentVo) {
		// TODO Auto-generated method stub
		try {
			tableDao.update(supAttachmentVo.adapterToSupAttachment());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 根据定标的ID删除定标
	 * @param  supAttachmentId 要删除的定标ID值
	 * @return 删除成功， 返回 true，若失败，返回 false
	 */
	public boolean deleteSupAttachmentbyId(Integer supAttachmentId) {
		// TODO Auto-generated method stub
		try {
			tableDao.delete(supAttachmentId, SupAttachment.class);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 新增一个定标
	 * @param supAttachmentVo 要添加的SupAttachmentVo实例
	 * @return 添加的定标在数据库中的ID值，若失败返回-1
	 */
	public Integer insertSupAttachment(SupAttachmentVo supAttachmentVo) {
		// TODO Auto-generated method stub
		try {
			SupAttachment ew = supAttachmentVo.adapterToSupAttachment();
			Integer supAttachmentId = tableDao.insert(ew);
			ew.setId(supAttachmentId);
			ew.setDispIndex(supAttachmentId);
			tableDao.update(ew);
			return supAttachmentId;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public void setSupAttachment(SupAttachment supAttachment) {
		// TODO Auto-generated method stub
		this.supAttachment=supAttachment;
	}

	public void setTableDao(ITableDao tableDao) {
		// TODO Auto-generated method stub
		this.tableDao=tableDao;
	}

}
