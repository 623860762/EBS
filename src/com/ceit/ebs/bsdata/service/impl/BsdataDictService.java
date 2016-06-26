package com.ceit.ebs.bsdata.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.util.PageInfo;
import com.ceit.ebs.bsdata.entity.BsdataDict;
import com.ceit.ebs.bsdata.service.IBsdataDictService;
import com.ceit.ebs.bsdata.vo.BsdataDictVo;

/**
 * BsdataDictService 是为系统的基础数据数据字典提供服务的类，包括所有相关操作的业务逻辑。
 * @author hgl
 * date 2014-8-7
 */
public class BsdataDictService implements IBsdataDictService{
	private BsdataDict bsdataDict;
	private ITableDao tableDao;
	
	public BsdataDictService()
	{
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
		sql="SELECT COUNT(d.id) FROM BsdataDict d "+"where '1'='1'";
		try {
			List<BsdataDict> list = tableDao.otherQuery(sql, true, true, null);
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
	 * @return 包含查询到的所有BsdataDictVo实例的List，若失败，返回null
	 */
	@SuppressWarnings("unchecked")
	public PageInfo<BsdataDictVo> querydata(int pageindex, int pagesize) {
		// TODO Auto-generated method stub
		List<BsdataDictVo> bsdataDictVoList = new ArrayList<BsdataDictVo>(); //VO集合
		int count = 0;
		//Map<String,Object> map = new HashMap<String,Object>();
		String sql = " FROM  BsdataDict d where '1' = '1'  ";
		//sql += " order by d.dispindex desc "; 
		try {
			//PO集合
			List<BsdataDict> bsdataDictList = tableDao.querydata(sql, true, pageindex, pagesize, null);
			if(bsdataDictList != null && bsdataDictList.size() > 0){
				for(int i = 0 ; i < bsdataDictList.size() ; i++){
					BsdataDictVo eov = new BsdataDictVo(bsdataDictList.get(i));//PO -> VO
					bsdataDictVoList.add(eov);
				}
			}
			count = this.getCount();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new PageInfo<BsdataDictVo>(bsdataDictVoList,count,pageindex,pagesize);
	}
	/**
	 * 根据项目下的分标的ID查找项目下的分标
	 * @param  bsdataDictId 要查询的项目下的分标ID值
	 * @return 查询到的BsdataDict实例
	 */
	public BsdataDictVo getBsdataDictbyId(Integer bsdataDictId) {
		// TODO Auto-generated method stub
		BsdataDictVo bsdataDictVo=null;
		try {
			bsdataDict = (BsdataDict)tableDao.getEntitybyId(bsdataDictId, BsdataDict.class);
			bsdataDictVo=new BsdataDictVo(bsdataDict);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return bsdataDictVo;	
	}
	/**
	 * 修改项目下的分标实例
	 * @param  bsdataDict 要修改的项目下的分标
	 * @return 修改成功，返回 true，若失败，返回 false
	 */
	public boolean modifyBsdataDict(BsdataDictVo bsdataDictVo) {
		// TODO Auto-generated method stub
		try {
			tableDao.update(bsdataDictVo.adapterToBsdataDict());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 根据项目下分标的ID删除项目下分标
	 * @param  bsdataDictId 要删除的项目下分标ID值
	 * @return 删除成功， 返回 true，若失败，返回 false
	 */
	public boolean deleteBsdataDictbyId(Integer bsdataDictId) {
		// TODO Auto-generated method stub
		try {
			tableDao.delete(bsdataDictId, BsdataDict.class);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 新增一个项目下的分标
	 * @param bsdataDictVo 要添加的BsdataDictVo实例
	 * @return 添加的招标项目划分包在数据库中的ID值，若失败返回-1
	 */
	public Integer insertBsdataDict(BsdataDictVo bsdataDictVo) {
		// TODO Auto-generated method stub
		try {
			BsdataDict eo = bsdataDictVo.adapterToBsdataDict();
			Integer bsdataDictId = tableDao.insert(eo);
			//sr.setId(sysRoleId);
			//sr.setDispindex(sysRoleId);
			tableDao.update(eo);
			return bsdataDictId;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public void setBsdataDict(BsdataDict bsdataDict) {
		// TODO Auto-generated method stub
		this.bsdataDict=bsdataDict;
	}

	public void setTableDao(ITableDao tableDao) {
		// TODO Auto-generated method stub
		this.tableDao=tableDao;
	}
}
