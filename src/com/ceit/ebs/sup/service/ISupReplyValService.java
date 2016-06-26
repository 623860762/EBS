package com.ceit.ebs.sup.service;

import java.util.List;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.util.PageInfo;
import com.ceit.ebs.sup.entity.SupReplyVal;
import com.ceit.ebs.sup.vo.SupReplyValVo;

/**
 * ISupReplyValService 是为系统的供应商应答值提供服务的接口
 * @author czg
 * date 2014-8-15
 */
public interface ISupReplyValService {
	//获得数据的条数
	public Integer getCount();
	
	//通过页数和页面大小获得Vo
	public PageInfo<SupReplyValVo> querydata(int pageindex, int pagesize);
	
	//通过ID获得Vo
	public SupReplyValVo getSupReplyValbyId(Integer supReplyValId);
	
	//通过Vo修改数据库
	public boolean modifySupReplyVal(SupReplyValVo supReplyValVo);
	
	//通过ID删除一条数据
	public boolean deleteSupReplyValbyId(Integer supReplyValId);
	
	//以Vo作为参数插入一条数据
	public Integer insertSupReplyVal(SupReplyValVo supReplyValVo);
	
	public void setSupReplyVal(SupReplyVal supReplyVal);
	
	public void setTableDao(ITableDao tableDao);
	
	//供应商上传报价
	public Boolean uploadPrice(Integer supId,Integer projectId,Integer packageId,Integer price);
	
	//取得报价
	public Integer getPrice(Integer supId,Integer projectId,Integer packageId);
	
	//上传投标文件
	public Boolean uploadFile(Integer supId,Integer projectId,Integer packageId,String fileName,Integer termName);
	
	//取得投标文件地址
	public List<String> getFilePath(Integer supId,Integer projectId,Integer packageId);
}
