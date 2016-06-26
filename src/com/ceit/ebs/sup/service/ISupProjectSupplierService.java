package com.ceit.ebs.sup.service;

import java.util.List;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.util.PageInfo;
import com.ceit.ebs.sup.entity.SupProjectSupplier;
import com.ceit.ebs.sup.vo.SupProjectSupplierVo;
/**
 * SupProjectSupplierService 是为系统的供应商与标关系提供服务的接口
 * @author czg
 * date 2014-8-16
 */
public interface ISupProjectSupplierService {
	//获得数据的条数
	public Integer getCount();
	
	//通过页数和页面大小获得Vo
	public PageInfo<SupProjectSupplierVo> querydata(int pageindex, int pagesize);
	
	//通过ID获得Vo
	public SupProjectSupplierVo getSupProjectSupplierbyId(Integer supProjectSupplierId);
	
	//通过Vo修改数据库
	public boolean modifySupProjectSupplier(SupProjectSupplierVo supProjectSupplierVo);
	
	//通过ID删除一条数据
	public boolean deleteSupProjectSupplierbyId(Integer supProjectSupplierId);
	
	//以Vo作为参数插入一条数据
	public Integer insertSupProjectSupplier(SupProjectSupplierVo supProjectSupplierVo);
	
	public void setSupProjectSupplier(SupProjectSupplier supProjectSupplier);
	
	public void setTableDao(ITableDao tableDao);
	
	//购买文件后保存支付状态
	public Boolean buyObjectFiles(Integer supId,Integer packageId);
		
	//得到包下所有招标文件
	public List<String> getFilePath(Integer supId,Integer projectId,Integer packageId);
	
	//投标的供应商个数
	public Integer getSupNum(Integer packageId);
	
	//根据供应商Id、项目id、包Id找到SupProjectSupplierVo
	public SupProjectSupplierVo getVoByOtherId(Integer supId,Integer projectId,Integer packageId);
	
	
	//获取系统当前时间
	public String getTime();
}
