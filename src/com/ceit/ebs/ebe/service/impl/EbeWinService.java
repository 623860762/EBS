package com.ceit.ebs.ebe.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.dao.impl.TableDao;
import com.ceit.common.util.PageInfo;
import com.ceit.ebs.cnt.vo.CntContractPurchaserVo;
import com.ceit.ebs.ebe.entity.EbeRepeal;
import com.ceit.ebs.ebe.entity.EbeWin;
import com.ceit.ebs.ebe.service.IEbeWinService;
import com.ceit.ebs.ebe.vo.EbeWinVo;
/**
 * EbeWinService 是为系统的定标提供服务的类，包括所有相关操作的业务逻辑。
 * @author czg
 * date 2014-8-7
 */
public class EbeWinService implements IEbeWinService{
	private EbeWin ebeWin;
	private ITableDao tableDao;
	
	
	public EbeWinService(){
		
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
		sql="SELECT COUNT(d.id) FROM EbeWin d "+"where '1'='1'";
		try {
			List<EbeWin> list = tableDao.otherQuery(sql, true, true, null);
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
	 * @return 包含查询到的所有EbeWinVo实例的PageInfo，若失败，返回null
	 */
	@SuppressWarnings("unchecked")
	public PageInfo<EbeWinVo> querydata(int pageindex, int pagesize) {
		// TODO Auto-generated method stub
		List<EbeWinVo> ebeWinVoList = new ArrayList<EbeWinVo>(); //VO集合
		int count=0;
		//Map<String,Object> map = new HashMap<String,Object>();
		String sql = " FROM  EbeWin d where '1' = '1'  ";
		//sql += " order by d.dispindex desc "; 
		try {
			//PO集合
			List<EbeWin> ebeWinList = tableDao.querydata(sql, true, pageindex, pagesize, null);
			if(ebeWinList != null && ebeWinList.size() > 0){
				for(int i = 0 ; i < ebeWinList.size() ; i++){
					EbeWinVo ewv = new EbeWinVo(ebeWinList.get(i));//PO -> VO
					ebeWinVoList.add(ewv);
				}
			}
			count=this.getCount();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return  new PageInfo<EbeWinVo>(ebeWinVoList,count,pageindex,pagesize);
		
	}
	/**
	 * 根据定标的ID查找定标
	 * @param  ebeWinId 要查询的定标ID值
	 * @return 查询到的EbeWin实例
	 */
	public EbeWinVo getEbeWinbyId(Integer ebeWinId) {
		// TODO Auto-generated method stub
		EbeWinVo ebeWinVo=null;
		try {
			ebeWin = (EbeWin)tableDao.getEntitybyId(ebeWinId, EbeWin.class);
			ebeWinVo=new EbeWinVo(ebeWin);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ebeWinVo;		
	}
	/**
	 * 修改定标实例
	 * @param  ebeWinVo 要修改的定标Vo
	 * @return 修改成功，返回 true，若失败，返回 false
	 */
	public boolean modifyEbeWin(EbeWinVo ebeWinVo) {
		// TODO Auto-generated method stub
		try {
			tableDao.update(ebeWinVo.adapterToEbeWin());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 根据定标的ID删除定标
	 * @param  ebeWinId 要删除的定标ID值
	 * @return 删除成功， 返回 true，若失败，返回 false
	 */
	public boolean deleteEbeWinbyId(Integer ebeWinId) {
		// TODO Auto-generated method stub
		try {
			tableDao.delete(ebeWinId, EbeWin.class);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 新增一个定标
	 * @param ebeWinVo 要添加的EbeWinVo实例
	 * @return 添加的定标在数据库中的ID值，若失败返回-1
	 */
	public Integer insertEbeWin(EbeWinVo ebeWinVo) {
		// TODO Auto-generated method stub
		try {
			EbeWin ew = ebeWinVo.adapterToEbeWin();
			Integer ebeWinId = tableDao.insert(ew);
			ew.setId(ebeWinId);
			ew.setDispIndex(ebeWinId);
			tableDao.update(ew);
			return ebeWinId;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public void setEbeWin(EbeWin ebeWin) {
		// TODO Auto-generated method stub
		this.ebeWin=ebeWin;
	}

	public void setTableDao(ITableDao tableDao) {
		// TODO Auto-generated method stub
		this.tableDao=tableDao;
	}
	/**
	 * 按包查看中标信息
	 * @param packageId
	 * @return EbeWin对象列表
	 * @author hgl
	 * 2014/08/16
	 */
	public List<EbeWin> showWinByPackageId(Integer packageId){
		setTableDao(new TableDao());
		EbeWin ebeRepeal = new EbeWin();
		//判断是否已经加入过其他评审小组
		String sql=" FROM  EbeWin d where d.packageId = :packageId";
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("packageId", packageId);
			List list = tableDao.otherQuery(sql,true,true, params);
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return null;
	}
}
