package com.ceit.ebs.md.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.util.PageInfo;
import com.ceit.ebs.md.entity.MdMaterial;
import com.ceit.ebs.md.service.IMdMaterialService;
import com.ceit.ebs.md.vo.MdMaterialVo;
/**
 * SysFunction entity. @author MyEclipse Persistence Tools
 * @author hgl
 * @version 2014.8.11
 */
public class MdMaterialService implements IMdMaterialService{


	private MdMaterial mdMaterial;
	private ITableDao tableDao;
	public MdMaterialService()
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
		sql="SELECT COUNT(d.id) FROM MdMaterial d "+"where '1'='1'";
		try {
			List<MdMaterial> list = tableDao.otherQuery(sql, true, true, null);
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
	 * @return 包含查询到的所有MdMaterialVo实例的List，若失败，返回null
	 */
	@SuppressWarnings("unchecked")
	public PageInfo<MdMaterialVo> querydata(int pageindex, int pagesize) {
		// TODO Auto-generated method stub
		List<MdMaterialVo> mdMaterialVoList = new ArrayList<MdMaterialVo>(); //VO集合
		//Map<String,Object> map = new HashMap<String,Object>();
		int count = 0;
		String sql = " FROM  MdMaterial d where '1' = '1'  ";
		//sql += " order by d.dispindex desc "; 
		try {
			//PO集合
			List<MdMaterial> mdMaterialList = tableDao.querydata(sql, true, pageindex, pagesize, null);
			if(mdMaterialList != null && mdMaterialList.size() > 0){
				for(int i = 0 ; i < mdMaterialList.size() ; i++){
					MdMaterialVo eov = new MdMaterialVo(mdMaterialList.get(i));//PO -> VO
					mdMaterialVoList.add(eov);
				}
			}
			count = this.getCount();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new PageInfo<MdMaterialVo>(mdMaterialVoList,count,pageindex,pagesize);
	}
	/**
	 * 根据项目下的分标的ID查找项目下的分标
	 * @param  mdMaterialId 要查询的项目下的分标ID值
	 * @return 查询到的MdMaterial实例
	 */
	public MdMaterialVo getMdMaterialbyId(Integer mdMaterialId) {
		// TODO Auto-generated method stub
		MdMaterialVo mdMaterialVo=null;
		try {
			mdMaterial = (MdMaterial)tableDao.getEntitybyId(mdMaterialId, MdMaterial.class);
			mdMaterialVo=new MdMaterialVo(mdMaterial);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return mdMaterialVo;	
	}
	/**
	 * 修改项目下的分标实例
	 * @param  mdMaterial 要修改的项目下的分标
	 * @return 修改成功，返回 true，若失败，返回 false
	 */
	public boolean modifyMdMaterial(MdMaterialVo mdMaterialVo) {
		// TODO Auto-generated method stub
		try {
			tableDao.update(mdMaterialVo.adapterToMdMaterial());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 根据项目下分标的ID删除项目下分标
	 * @param  mdMaterialId 要删除的项目下分标ID值
	 * @return 删除成功， 返回 true，若失败，返回 false
	 */
	public boolean deleteMdMaterialbyId(Integer mdMaterialId) {
		// TODO Auto-generated method stub
		try {
			tableDao.delete(mdMaterialId, MdMaterial.class);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 新增一个项目下的分标
	 * @param mdMaterialVo 要添加的MdMaterialVo实例
	 * @return 添加的招标项目划分包在数据库中的ID值，若失败返回-1
	 */
	public Integer insertMdMaterial(MdMaterialVo mdMaterialVo) {
		// TODO Auto-generated method stub
		try {
			MdMaterial eo = mdMaterialVo.adapterToMdMaterial();
			Integer mdMaterialId = tableDao.insert(eo);
			//sr.setId(sysRoleId);
			//sr.setDispindex(sysRoleId);
			tableDao.update(eo);
			return mdMaterialId;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	/**
	 * 根据分类Id(CategoryId)查看物料
	 * @param mdCategotyId 分类id(categoryId)
	 * @return 所有符合categoryId条件的物料
	*/	
	public PageInfo<MdMaterialVo> getMdMaterialbyCategoryId(int pageindex, int pagesize, Integer categoryId) {
		String sql = "from MdMaterial where categoryId=:categoryId";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("categoryId", categoryId);
		try {
				List<MdMaterial> list = this.tableDao.querydata(sql, true, pageindex, pagesize, params);
				List<MdMaterialVo> listVo = new ArrayList<MdMaterialVo>();
				for(int i = 0; i<list.size();i++){
					MdMaterialVo epv = new MdMaterialVo(list.get(i));
					listVo.add(epv);
				}
				int size = this.getListSizeByCategoryId(categoryId);
				return new PageInfo<MdMaterialVo>(listVo,size,pageindex,pagesize);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Integer getListSizeByCategoryId(Integer categoryId) {
		String sql = "select count(id) from MdMaterial where categoryId=:categoryId";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("categoryId", categoryId);
		Integer ListSize = -1;
		try {
			
			List list = this.tableDao.otherQuery(sql, true, true, params);
			Object o = list.get(0);
			ListSize =  Integer.valueOf(o.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ListSize;
	}
	
	/**
	 * 根据父节点id分页显示其子节点
	 * @param pageindex 分页起始页    pagesize 分页大小     parentId 父节点id
	 * @return 包含查询到的所有实例的List，若失败，返回null
	*/
	public PageInfo<MdMaterialVo> getObjList(int pageindex, int pagesize, Integer parentId) {
		String sql = "from MdMaterial where parentId=:parentId";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("parentId", parentId);
		try {
				List<MdMaterial> list = this.tableDao.querydata(sql, true, pageindex, pagesize, params);
				List<MdMaterialVo> listVo = new ArrayList<MdMaterialVo>();
				for(int i = 0; i<list.size();i++){
					MdMaterialVo epv = new MdMaterialVo(list.get(i));
					listVo.add(epv);
				}
				int size = this.getListSizeByParentId(parentId);
				return new PageInfo<MdMaterialVo>(listVo,size,pageindex,pagesize);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
		
	public Integer getListSizeByParentId(Integer parentId) {
		String sql = "select count(id) from MdMaterial where parentId=:parentId";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("parentId", parentId);
		Integer ListSize = -1;
		try {
			
			List list = this.tableDao.otherQuery(sql, true, true, params);
			Object o = list.get(0);
			ListSize =  Integer.valueOf(o.toString());
			System.out.println("查询到记录数:"+ListSize);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ListSize;
	}
	
	/**
	 * 根据多个id删除对应数据
	 * @param 待删除的id字符串
	 * @return 包含查询到的所有实例的，若失败，返回null
	*/	
	public boolean delObjsByIds(String ids) {
		String[] IdArray = ids.split(",");
		boolean b = true;
		try {
			for (int i = 0; i < IdArray.length; i++) {
				this.tableDao.delete(Integer.parseInt(IdArray[i]), MdMaterial.class);
			}
		} catch (Exception e) {
			b = false;
		}
		return true;
	}


	public void setMdMaterial(MdMaterial mdMaterial) {
		// TODO Auto-generated method stub
		this.mdMaterial=mdMaterial;
	}

	public void setTableDao(ITableDao tableDao) {
		// TODO Auto-generated method stub
		this.tableDao=tableDao;
	}
}
