package com.ceit.ebs.ebp.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.dao.impl.TableDao;
import com.ceit.common.util.PageInfo;
import com.ceit.ebs.ebp.entity.EbpClearReply;
import com.ceit.ebs.ebp.service.IEbpClearReplyService;
import com.ceit.ebs.ebp.vo.EbpClearReplyVo;
/**
 * EbpObjectService 是为系统的项目下的分标提供服务的类，包括所有相关操作的业务逻辑。
 * @author czg
 * date 2014-8-7
 */
public class EbpClearReplyService implements IEbpClearReplyService {
	private EbpClearReply ebpClearReply;
	private ITableDao iTableDao;
	
	public EbpClearReplyService() {
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
		sql="SELECT COUNT(d.id) FROM EbpClearReply d "+"where '1'='1'";
		try {
			List<EbpClearReply> list = iTableDao.otherQuery(sql, true, true, null);
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
	 * @return 包含查询到的所有EbpClearReplyVo实例的List，若失败，返回null
	 */
	@SuppressWarnings("unchecked")
	public PageInfo<EbpClearReplyVo> querydata(int pageindex, int pagesize) {
		// TODO Auto-generated method stub
		List<EbpClearReplyVo> ebpClearReplyVoList = new ArrayList<EbpClearReplyVo>(); //VO集合
		//Map<String,Object> map = new HashMap<String,Object>();
		String sql = " FROM  EbpClearReply d where '1' = '1'  ";
		//sql += " order by d.dispindex desc "; 
		int count = 0;
		try {
			//PO集合
			List<EbpClearReply> ebpClearReplyList = iTableDao.querydata(sql, true, pageindex, pagesize, null);
			if(ebpClearReplyList != null && ebpClearReplyList.size() > 0){
				for(int i = 0 ; i < ebpClearReplyList.size() ; i++){
					EbpClearReplyVo eov = new EbpClearReplyVo(ebpClearReplyList.get(i));//PO -> VO
					ebpClearReplyVoList.add(eov);
				}
			}
			count = this.getCount();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new PageInfo<EbpClearReplyVo>(ebpClearReplyVoList,count,pageindex,pagesize);
	}
	/**
	 * 根据项目下的分标的ID查找项目下的分标
	 * @param  ebpClearReplyId 要查询的项目下的分标ID值
	 * @return 查询到的EbpClearReply实例
	 */
	public EbpClearReplyVo getEbpClearReplybyId(Integer ebpClearReplyId) {
		// TODO Auto-generated method stub
		EbpClearReplyVo ebpClearReplyVo=null;
		try {
			ebpClearReply = (EbpClearReply)iTableDao.getEntitybyId(ebpClearReplyId, EbpClearReply.class);
			ebpClearReplyVo=new EbpClearReplyVo(ebpClearReply);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ebpClearReplyVo;	
	}
	/**
	 * 修改项目下的分标实例
	 * @param  ebpClearReply 要修改的项目下的分标
	 * @return 修改成功，返回 true，若失败，返回 false
	 */
	public boolean modifyEbpClearReply(EbpClearReplyVo ebpClearReplyVo) {
		// TODO Auto-generated method stub
		try {
			iTableDao.update(ebpClearReplyVo.adapterToEbpClearReply());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 根据项目下分标的ID删除项目下分标
	 * @param  ebpClearReplyId 要删除的项目下分标ID值
	 * @return 删除成功， 返回 true，若失败，返回 false
	 */
	public boolean deleteEbpClearReplybyId(Integer ebpClearReplyId) {
		// TODO Auto-generated method stub
		try {
			iTableDao.delete(ebpClearReplyId, EbpClearReply.class);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 新增一个项目下的分标
	 * @param ebpClearReplyVo 要添加的EbpClearReplyVo实例
	 * @return 添加的招标项目划分包在数据库中的ID值，若失败返回-1
	 */
	public Integer insertEbpClearReply(EbpClearReplyVo ebpClearReplyVo) {
		// TODO Auto-generated method stub
		try {
			EbpClearReply eo = ebpClearReplyVo.adapterToEbpClearReply();
			Integer ebpClearReplyId = iTableDao.insert(eo);
			//sr.setId(sysRoleId);
			//sr.setDispindex(sysRoleId);
			iTableDao.update(eo);
			return ebpClearReplyId;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public void setEbpClearReply(EbpClearReply ebpClearReply) {
		// TODO Auto-generated method stub
		this.ebpClearReply=ebpClearReply;
	}

	public void setTableDao(TableDao tableDao) {
		// TODO Auto-generated method stub
		this.iTableDao=tableDao;
	}

}
