package com.ceit.ebs.sup.service;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.util.PageInfo;
import com.ceit.ebs.sup.entity.SupAttachment;
import com.ceit.ebs.sup.vo.SupAttachmentVo;

/**
 * ISupAttachmentService 是为系统的附件提供服务的接口
 * @author czg
 * date 2014-8-15
 */

public interface ISupAttachmentService {

	//获得数据的条数
	public Integer getCount();
	
	//通过页数和页面大小获得Vo
	public PageInfo<SupAttachmentVo> querydata(int pageindex, int pagesize);
	
	//通过ID获得Vo
	public SupAttachmentVo getSupAttachmentbyId(Integer supAttachmentId);
	
	//通过Vo修改数据库
	public boolean modifySupAttachment(SupAttachmentVo supAttachmentVo);
	
	//通过ID删除一条数据
	public boolean deleteSupAttachmentbyId(Integer supAttachmentId);
	
	//以Vo作为参数插入一条数据
	public Integer insertSupAttachment(SupAttachmentVo supAttachmentVo);
	
	public void setSupAttachment(SupAttachment supAttachment);
	
	public void setTableDao(ITableDao tableDao);
	
}
