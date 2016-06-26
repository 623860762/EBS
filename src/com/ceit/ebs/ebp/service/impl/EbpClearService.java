package com.ceit.ebs.ebp.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.util.PageInfo;
import com.ceit.ebs.ebp.entity.EbpClear;
import com.ceit.ebs.ebp.service.IEbpClearService;
import com.ceit.ebs.ebp.vo.EbpClearVo;
/**
 * EbpObjectService 是为系统的项目下的分标提供服务的类，包括所有相关操作的业务逻辑。
 * @author czg
 * date 2014-8-7
 */
public class EbpClearService implements IEbpClearService {
	private EbpClear ebpClear;
	private ITableDao iTableDao;
	
	
	public EbpClearService() {
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
		sql="SELECT COUNT(d.id) FROM EbpClear d "+"where '1'='1'";
		try {
			List<EbpClear> list = iTableDao.otherQuery(sql, true, true, null);
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
	 * @return 包含查询到的所有EbpClearVo实例的List，若失败，返回null
	 */
	@SuppressWarnings("unchecked")
	public PageInfo<EbpClearVo> querydata(int pageindex, int pagesize) {
		// TODO Auto-generated method stub
		List<EbpClearVo> ebpClearVoList = new ArrayList<EbpClearVo>(); //VO集合
		//Map<String,Object> map = new HashMap<String,Object>();
		String sql = " FROM  EbpClear d where '1' = '1'  ";
		int count = 0;
		//sql += " order by d.dispindex desc "; 
		try {
			//PO集合
			List<EbpClear> ebpClearList = iTableDao.querydata(sql, true, pageindex, pagesize, null);
			if(ebpClearList != null && ebpClearList.size() > 0){
				for(int i = 0 ; i < ebpClearList.size() ; i++){
					EbpClearVo eov = new EbpClearVo(ebpClearList.get(i));//PO -> VO
					ebpClearVoList.add(eov);
				}
			}
			count = this.getCount();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new PageInfo<EbpClearVo>(ebpClearVoList,count,pageindex,pagesize);
	}
	/**
	 * 根据项目下的分标的ID查找项目下的分标
	 * @param  ebpClearId 要查询的项目下的分标ID值
	 * @return 查询到的EbpClear实例
	 */
	public EbpClearVo getEbpClearbyId(Integer ebpClearId) {
		// TODO Auto-generated method stub
		EbpClearVo ebpClearVo=null;
		try {
			ebpClear = (EbpClear)iTableDao.getEntitybyId(ebpClearId, EbpClear.class);
			ebpClearVo=new EbpClearVo(ebpClear);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ebpClearVo;	
	}
	/**
	 * 修改项目下的分标实例
	 * @param  ebpClear 要修改的项目下的分标
	 * @return 修改成功，返回 true，若失败，返回 false
	 */
	public boolean modifyEbpClear(EbpClearVo ebpClearVo) {
		// TODO Auto-generated method stub
		try {
			iTableDao.update(ebpClearVo.adapterToEbpClear());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 根据项目下分标的ID删除项目下分标
	 * @param  ebpClearId 要删除的项目下分标ID值
	 * @return 删除成功， 返回 true，若失败，返回 false
	 */
	public boolean deleteEbpClearbyId(Integer ebpClearId) {
		// TODO Auto-generated method stub
		try {
			iTableDao.delete(ebpClearId, EbpClear.class);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 新增一个项目下的分标
	 * @param ebpClearVo 要添加的EbpClearVo实例
	 * @return 添加的招标项目划分包在数据库中的ID值，若失败返回-1
	 */
	public Integer insertEbpClear(EbpClearVo ebpClearVo) {
		// TODO Auto-generated method stub
		try {
			EbpClear eo = ebpClearVo.adapterToEbpClear();
			Integer ebpClearId = iTableDao.insert(eo);
			//sr.setId(sysRoleId);
			//sr.setDispindex(sysRoleId);
			iTableDao.update(eo);
			return ebpClearId;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public void setEbpClear(EbpClear ebpClear) {
		// TODO Auto-generated method stub
		this.ebpClear=ebpClear;
	}

	public void setTableDao(ITableDao tableDao) {
		// TODO Auto-generated method stub
		this.iTableDao=tableDao;
	}

}
