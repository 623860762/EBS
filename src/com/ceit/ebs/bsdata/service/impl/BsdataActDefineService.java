package com.ceit.ebs.bsdata.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.util.PageInfo;
import com.ceit.ebs.bsdata.entity.BsdataActDefine;
import com.ceit.ebs.bsdata.service.IBsdataActDefineService;
import com.ceit.ebs.bsdata.vo.BsdataActDefineVo;
import com.ceit.ebs.ebp.vo.EbpProjectVo;

/**
 * BsdataActDefineService
 * @author hgl
 * date 2014-8-10
 */
public class BsdataActDefineService implements IBsdataActDefineService{
	private BsdataActDefine bsdataActDefine;
	private ITableDao tableDao;

	public BsdataActDefineService(){
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
		sql="SELECT COUNT(d.id) FROM BsdataActDefine d "+"where '1'='1'";
		try {
			List<BsdataActDefine> list = tableDao.otherQuery(sql, true, true, null);
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
	 * @return 包含查询到的所有BsdataActDefineVo实例的List，若失败，返回null
	 */
	@SuppressWarnings("unchecked")
	public PageInfo<BsdataActDefineVo> querydata(int pageindex, int pagesize) {
		// TODO Auto-generated method stub
		List<BsdataActDefineVo> bsdataActDefineVoList = new ArrayList<BsdataActDefineVo>(); //VO集合
		int count =0;
		//Map<String,Object> map = new HashMap<String,Object>();
		String sql = " FROM  BsdataActDefine d where '1' = '1'  ";
		//sql += " order by d.dispindex desc "; 
		try {
			//PO集合
			List<BsdataActDefine> bsdataActDefineList = tableDao.querydata(sql, true, pageindex, pagesize, null);
			if(bsdataActDefineList != null && bsdataActDefineList.size() > 0){
				for(int i = 0 ; i < bsdataActDefineList.size() ; i++){
					BsdataActDefineVo eov = new BsdataActDefineVo(bsdataActDefineList.get(i));//PO -> VO
					bsdataActDefineVoList.add(eov);
				}
			}
			count = this.getCount();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new PageInfo<BsdataActDefineVo>(bsdataActDefineVoList,count,pageindex,pagesize);
	}
	/**
	 * 根据项目下的分标的ID查找项目下的分标
	 * @param  bsdataActDefineId 要查询的项目下的分标ID值
	 * @return 查询到的BsdataActDefine实例
	 */
	public BsdataActDefineVo getBsdataActDefinebyId(Integer bsdataActDefineId) {
		// TODO Auto-generated method stub
		BsdataActDefineVo bsdataActDefineVo=null;
		try {
			bsdataActDefine = (BsdataActDefine)tableDao.getEntitybyId(bsdataActDefineId, BsdataActDefine.class);
			bsdataActDefineVo=new BsdataActDefineVo(bsdataActDefine);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return bsdataActDefineVo;	
	}

	/**
	 * 修改项目下的分标实例
	 * @param  bsdataActDefine 要修改的项目下的分标
	 * @return 修改成功，返回 true，若失败，返回 false
	 */
	public boolean modifyBsdataActDefine(BsdataActDefineVo bsdataActDefineVo) {
		// TODO Auto-generated method stub
		try {
			tableDao.update(bsdataActDefineVo.adapterToBsdataActDefine());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 根据项目下分标的ID删除项目下分标
	 * @param  bsdataActDefineId 要删除的项目下分标ID值
	 * @return 删除成功， 返回 true，若失败，返回 false
	 */
	public boolean deleteBsdataActDefinebyId(Integer bsdataActDefineId) {
		// TODO Auto-generated method stub
		try {
			tableDao.delete(bsdataActDefineId, BsdataActDefine.class);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 新增一个项目下的分标
	 * @param bsdataActDefineVo 要添加的BsdataActDefineVo实例
	 * @return 添加的招标项目划分包在数据库中的ID值，若失败返回-1
	 */
	public Integer insertBsdataActDefine(BsdataActDefineVo bsdataActDefineVo) {
		// TODO Auto-generated method stub
		try {
			BsdataActDefine eo = bsdataActDefineVo.adapterToBsdataActDefine();
			Integer bsdataActDefineId = tableDao.insert(eo);
			//sr.setId(sysRoleId);
			//sr.setDispindex(sysRoleId);
			tableDao.update(eo);
			return bsdataActDefineId;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public void setBsdataActDefine(BsdataActDefine bsdataActDefine) {
		// TODO Auto-generated method stub
		this.bsdataActDefine=bsdataActDefine;
	}

	public void setTableDao(ITableDao tableDao) {
		// TODO Auto-generated method stub
		this.tableDao=tableDao;
	}

}