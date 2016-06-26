package com.ceit.ebs.ebp.service;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.util.PageInfo;
import com.ceit.ebs.ebp.entity.EbpFileUpload;
import com.ceit.ebs.ebp.vo.EbpFileUploadVo;

/**
 * IEbpFileUploadService 是为系统的上传文件提供服务的接口
 * @author czg
 * date 2014-8-15
 */

public interface IEbpFileUploadService {
	//获得数据的条数
	public Integer getCount();
	
	//通过页数和页面大小获得Vo
	public PageInfo<EbpFileUploadVo> querydata(int pageindex, int pagesize);
	
	//通过ID获得Vo
	public EbpFileUploadVo getEbpFileUploadbyId(Integer ebpFileUploadId);
	
	//通过Vo修改数据库
	public boolean modifyEbpFileUpload(EbpFileUploadVo ebpFileUploadVo);
	
	//通过ID删除一条数据
	public boolean deleteEbpFileUploadbyId(Integer ebpFileUploadId);
	
	//以Vo作为参数插入一条数据
	public Integer insertEbpFileUpload(EbpFileUploadVo ebpFileUploadVo);
	
	public void setEbpFileUpload(EbpFileUpload ebpFileUpload);
	
	public void setTableDao(ITableDao tableDao);
}
