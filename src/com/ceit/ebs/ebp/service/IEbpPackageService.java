package com.ceit.ebs.ebp.service;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.util.PageInfo;
import com.ceit.ebs.ebp.entity.EbpPackage;
import com.ceit.ebs.ebp.vo.EbpPackageVo;
/**
 * IEbpPackageService 是为系统的招标项目划分包构件提供服务的接口
 * @author czg
 * date 2014-8-7
 */
public interface IEbpPackageService {
	
	//标下分包
	public boolean dividePackageInObject(Integer projectId,Integer objectId, Integer num);
	//批量删除分包
	public boolean deleteEbpPackageBatch(String packageId);
	//获得数据的条数
	public Integer getCount();
	
	//通过页数和页面大小获得Vo
	public PageInfo<EbpPackageVo> querydata(int pageindex, int pagesize);
	
	//通过ID获得Vo
	public EbpPackageVo getEbpPackagebyId(Integer ebpPackageId);
	
	//通过Vo修改数据库
	public boolean modifyEbpPackage(EbpPackageVo ebpPackageVo);
	
	//通过ID删除一条数据
	public boolean deleteEbpPackagebyId(Integer ebpPackageId);
	
	//以Vo作为参数插入一条数据
	public Integer insertEbpPackage(EbpPackageVo ebpPackageVo);
	
	public void setEbpPackage(EbpPackage ebpPackage);
	
	public void setTableDao(ITableDao tableDao);
	
	//不开标设置
	public boolean noOpenBid(Integer packageId);
	
	//项目状态开标时，把项目下所有包设为开标
	public boolean openPacBid(Integer projectId);
	
	public PageInfo<EbpPackageVo> getEbpPackagebyProjectId(Integer parseInt,
			Integer parseInt2, Integer parseInt3);
	/**
	 * 项目下分包
	 * @param a
	 * @param b
	 * @return
	 */
	public boolean dividePackageInProject(Integer a, Integer b);
	/**
	 * 根据objectid获取所有包
	 * @param ebpObjectId
	 * @param pageindex
	 * @param pagesize
	 * @return
	 */
	public PageInfo<EbpPackageVo> getEbpPackagebyObjectId(Integer ebpObjectId,Integer pageindex, Integer pagesize);
}
