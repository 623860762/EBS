package com.ceit.ebs.bsdata.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.util.PageInfo;
import com.ceit.ebs.bsdata.entity.BsdataWorkFlow;
import com.ceit.ebs.bsdata.vo.BsdataWorkFlowVo;

public class BsdataWorkFlowService {
	private BsdataWorkFlow bsdataWorkFlow;
	private ITableDao tableDao;
	
	public BsdataWorkFlowService()
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
		sql="SELECT COUNT(d.id) FROM BsdataWorkFlow d "+"where '1'='1'";
		try {
			List<BsdataWorkFlow> list = tableDao.otherQuery(sql, true, true, null);
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
	 * @return 包含查询到的所有BsdataWorkFlowVo实例的List，若失败，返回null
	 */
	@SuppressWarnings("unchecked")
	public PageInfo<BsdataWorkFlowVo> querydata(int pageindex, int pagesize) {
		// TODO Auto-generated method stub
		List<BsdataWorkFlowVo> bsdataWorkFlowVoList = new ArrayList<BsdataWorkFlowVo>(); //VO集合
		int count = 0;
		//Map<String,Object> map = new HashMap<String,Object>();
		String sql = " FROM  BsdataWorkFlow d where '1' = '1'  ";
		//sql += " order by d.dispindex desc "; 
		try {
			//PO集合
			List<BsdataWorkFlow> bsdataWorkFlowList = tableDao.querydata(sql, true, pageindex, pagesize, null);
			if(bsdataWorkFlowList != null && bsdataWorkFlowList.size() > 0){
				for(int i = 0 ; i < bsdataWorkFlowList.size() ; i++){
					BsdataWorkFlowVo eov = new BsdataWorkFlowVo(bsdataWorkFlowList.get(i));//PO -> VO
					bsdataWorkFlowVoList.add(eov);
				}
			}
			count = this.getCount();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new PageInfo<BsdataWorkFlowVo>(bsdataWorkFlowVoList,count,pageindex,pagesize);
	}
	/**
	 * 根据项目下的分标的ID查找项目下的分标
	 * @param  bsdataWorkFlowId 要查询的项目下的分标ID值
	 * @return 查询到的BsdataWorkFlow实例
	 */
	public BsdataWorkFlowVo getBsdataWorkFlowbyId(Integer bsdataWorkFlowId) {
		// TODO Auto-generated method stub
		BsdataWorkFlowVo bsdataWorkFlowVo=null;
		try {
			bsdataWorkFlow = (BsdataWorkFlow)tableDao.getEntitybyId(bsdataWorkFlowId, BsdataWorkFlow.class);
			bsdataWorkFlowVo=new BsdataWorkFlowVo(bsdataWorkFlow);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return bsdataWorkFlowVo;	
	}
	/**
	 * 修改项目下的分标实例
	 * @param  bsdataWorkFlow 要修改的项目下的分标
	 * @return 修改成功，返回 true，若失败，返回 false
	 */
	public boolean modifyBsdataWorkFlow(BsdataWorkFlowVo bsdataWorkFlowVo) {
		// TODO Auto-generated method stub
		try {
			tableDao.update(bsdataWorkFlowVo.adapterToBsdataWorkFlow());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 根据项目下分标的ID删除项目下分标
	 * @param  bsdataWorkFlowId 要删除的项目下分标ID值
	 * @return 删除成功， 返回 true，若失败，返回 false
	 */
	public boolean deleteBsdataWorkFlowbyId(Integer bsdataWorkFlowId) {
		// TODO Auto-generated method stub
		try {
			tableDao.delete(bsdataWorkFlowId, BsdataWorkFlow.class);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 新增一个项目下的分标
	 * @param bsdataWorkFlowVo 要添加的BsdataWorkFlowVo实例
	 * @return 添加的招标项目划分包在数据库中的ID值，若失败返回-1
	 */
	public Integer insertBsdataWorkFlow(BsdataWorkFlowVo bsdataWorkFlowVo) {
		// TODO Auto-generated method stub
		try {
			BsdataWorkFlow eo = bsdataWorkFlowVo.adapterToBsdataWorkFlow();
			Integer bsdataWorkFlowId = tableDao.insert(eo);
			//sr.setId(sysRoleId);
			//sr.setDispindex(sysRoleId);
			tableDao.update(eo);
			return bsdataWorkFlowId;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public void setBsdataWorkFlow(BsdataWorkFlow bsdataWorkFlow) {
		// TODO Auto-generated method stub
		this.bsdataWorkFlow=bsdataWorkFlow;
	}

	public void setTableDao(ITableDao tableDao) {
		// TODO Auto-generated method stub
		this.tableDao=tableDao;
	}
}
