package com.ceit.ebs.ebe.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.registry.infomodel.User;

import org.hibernate.Query;
import org.hibernate.Session;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.dao.impl.TableDao;
import com.ceit.common.util.PageInfo;
import com.ceit.ebs.HibernateUtils;
import com.ceit.ebs.ebe.entity.EbeExpertReply;
import com.ceit.ebs.ebe.entity.EbeProviderPackage;
import com.ceit.ebs.ebe.service.IEbeProviderPackageService;
import com.ceit.ebs.ebe.vo.EbeProviderPackageVo;
import com.ceit.ebs.ebp.service.impl.EbpPackageService;
import com.ceit.ebs.ebp.vo.EbpPackageVo;
/**
 * EbeProviderPackageService 是为系统的评标中包与供应商关系提供服务的类，包括所有相关操作的业务逻辑。
 * @author czg
 * date 2014-8-7
 */
public class EbeProviderPackageService implements IEbeProviderPackageService{
	private EbeProviderPackage ebeProviderPackage;
	private ITableDao tableDao;
	
	

	public EbeProviderPackageService(){
		
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
		sql="SELECT COUNT(d.id) FROM EbeProviderPackage d "+"where '1'='1'";
		try {
			List<EbeProviderPackage> list = tableDao.otherQuery(sql, true, true, null);
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
	 * @return 包含查询到的所有EbeProviderPackageVo实例的List，若失败，返回null
	 */
	@SuppressWarnings("unchecked")
	public PageInfo<EbeProviderPackageVo> querydata(int pageindex, int pagesize) {
		// TODO Auto-generated method stub
		List<EbeProviderPackageVo> ebeProviderPackageVoList = new ArrayList<EbeProviderPackageVo>(); //VO集合
		int count=0;
		//Map<String,Object> map = new HashMap<String,Object>();
		String sql = " FROM  EbeProviderPackage d where '1' = '1'  ";
		//sql += " order by d.dispindex desc "; 
		try {
			//PO集合
			List<EbeProviderPackage> ebeProviderPackageList = tableDao.querydata(sql, true, pageindex, pagesize, null);
			if(ebeProviderPackageList != null && ebeProviderPackageList.size() > 0){
				for(int i = 0 ; i < ebeProviderPackageList.size() ; i++){
					EbeProviderPackageVo eppv = new EbeProviderPackageVo(ebeProviderPackageList.get(i));//PO -> VO
					ebeProviderPackageVoList.add(eppv);
				}
			}
			count=this.getCount();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return  new PageInfo<EbeProviderPackageVo>(ebeProviderPackageVoList,count,pageindex,pagesize);
	}
	/**
	 * 根据评标中包与供应商关系ID查找评标中包与供应商关系
	 * @param  ebeProviderPackageId 要查询的评标中包与供应商关系ID值
	 * @return 查询到的EbeProviderPackage实例
	 */
	public EbeProviderPackageVo getEbeProviderPackagebyId(Integer ebeProviderPackageId) {
		// TODO Auto-generated method stub
		EbeProviderPackageVo ebeProviderPackageVo=null;
		try {
			ebeProviderPackage = (EbeProviderPackage)tableDao.getEntitybyId(ebeProviderPackageId, EbeProviderPackage.class);
			ebeProviderPackageVo=new EbeProviderPackageVo(ebeProviderPackage);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ebeProviderPackageVo;	
	}
	/**
	 * 修改评标中包与供应商关系实例
	 * @param  ebeProviderPackage 要修改的评标中包与供应商关系
	 * @return 修改成功，返回 true，若失败，返回 false
	 */
	public boolean modifyEbeProviderPackage(EbeProviderPackageVo ebeProviderPackageVo) {
		// TODO Auto-generated method stub
		try {
			tableDao.update(ebeProviderPackageVo.adapterToEbeProviderPackage());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 根据评标中包与供应商关系的ID删除评标中包与供应商关系
	 * @param  ebeProviderPackageId 要删除的评标中包与供应商关系ID值
	 * @return 删除成功， 返回 true，若失败，返回 false
	 */
	public boolean deleteEbeProviderPackagebyId(Integer ebeProviderPackageId) {
		// TODO Auto-generated method stub
		try {
			tableDao.delete(ebeProviderPackageId, EbeProviderPackage.class);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 新增一个评标中包与供应商关系
	 * @param ebeProviderPackageVo 要添加的EbeProviderPackageVo实例
	 * @return 添加的评标中包与供应商关系在数据库中的ID值，若失败返回-1
	 */
	public Integer insertEbeProviderPackage(EbeProviderPackageVo ebeProviderPackageVo) {
		// TODO Auto-generated method stub
		try {
			EbeProviderPackage epp = ebeProviderPackageVo.adapterToEbeProviderPackage();
			Integer ebeProviderPackageId = tableDao.insert(epp);
			epp.setId(ebeProviderPackageId);
			epp.setDispIndex(ebeProviderPackageId);
			tableDao.update(epp);
			return ebeProviderPackageId;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public void setEbeProviderPackage(EbeProviderPackage ebeProviderPackage) {
		// TODO Auto-generated method stub
		this.ebeProviderPackage=ebeProviderPackage;
	}

	public void setTableDao(ITableDao tableDao) {
		// TODO Auto-generated method stub
		this.tableDao=tableDao;
	}

	/**
	 * 计算某供应商对某包的加权平均分，并写入数据库
	 * @param packageId 包的主键编号 supplierId 供应商的主键编号
	 * @return 加权平均分
	 * @author hgl
	 * date 2014/08/16
	 */
	public Integer calculateAverageScore(Integer packageId, Integer supplierId){
		//TODO action调用多个service，此函数需要修改
		setTableDao(new TableDao());
		Integer averageScore = 0;
		Integer busiScore=0, busiAverageScore=0 ,busiCount=0, busiWeight;
		Integer priceScore=0, priceAverageScore=0,priceCount=0, priceWeight;
		Integer techScore=0, techAverageScore=0,techCount=0, techWeight;
		try {
			//遍历专家打分表,获取指定包和指定供应商的记录
			String sql=" FROM  EbeExpertReply d where d.packageId = :packageId and d.supplierId = :supplierId";
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("packageId", packageId);
			params.put("supplierId", supplierId);
			List<EbeExpertReply> list = tableDao.otherQuery(sql, true, true, params);
			//遍历结果集，计算各项得分总和
			for(int i = 0; i < list.size(); i++){
				busiScore += list.get(i).getBusinessScore();
				priceScore += list.get(i).getPriceScore();
				techScore += list.get(i).getTechnicalScore();
				if(list.get(i).getBusinessScore() != -1){
					busiCount++;
				}
				else if(list.get(i).getPriceScore() != -1){
					priceCount++;
				}
				else if(list.get(i).getTechnicalScore() != -1){
					techCount++;
				}
			}
			//计算平均分
			if(busiCount == 0) busiAverageScore = 0;
			else  busiAverageScore = busiScore / busiCount;
			if (techCount ==0) techAverageScore = 0;
			else techAverageScore = techScore / techCount;
			if(priceCount == 0) priceAverageScore = 0;
			else priceAverageScore = priceScore / priceCount;
			
			//获取包中各项分数的权重
			EbpPackageService ebpPackageService = new EbpPackageService();
			ebpPackageService.setTableDao(new TableDao());
			EbpPackageVo ebpPackageVo =ebpPackageService.getEbpPackagebyId(packageId);
			busiWeight = ebpPackageVo.getBusinessWeight();
			techWeight = ebpPackageVo.getTechnicalWeight();
			priceWeight = ebpPackageVo.getPriceWeight();
			
 			//初始化vo对像，写入数据库
			EbeProviderPackageVo ebeProviderPackageVo=initScore(packageId,supplierId);
			//平均分
			ebeProviderPackageVo.setBusiAvgScore(busiAverageScore);
			ebeProviderPackageVo.setPriceAvgScore(priceAverageScore);
			ebeProviderPackageVo.setTechAvgScore(techAverageScore);
			//加权平均分
			ebeProviderPackageVo.setBusiJqScore(busiAverageScore * busiWeight / 100);
			ebeProviderPackageVo.setTechJqScore(techAverageScore * techWeight / 100);
			ebeProviderPackageVo.setPriceJqScore(priceAverageScore * priceWeight / 100);
			//加权平均分之和
			averageScore = busiAverageScore * busiWeight / 100 + techAverageScore * techWeight / 100
			+ priceAverageScore * priceWeight / 100;
			ebeProviderPackageVo.setFinishScore(averageScore);
			//其他属性（可能不全）
			ebeProviderPackageVo.setPackageId(packageId);
			ebeProviderPackageVo.setSupplierId(supplierId);
			ebeProviderPackageVo.setPackageName(ebpPackageVo.getPackageName());
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			ebeProviderPackageVo.setOpTime(df.format(new Date()));
			modifyEbeProviderPackage(ebeProviderPackageVo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return averageScore;
	}
	
	/**
	 * 查看某供应商对某包的加权平均分
	 * @param packageId 包的主键编号 supplierId 供应商的主键编号
	 * @return EbeProviderPackage对象
	 * @author hgl
	 * date 2014/08/16
	 */
	public EbeProviderPackage showScore(Integer packageId, Integer supplierId){
		setTableDao(new TableDao());
		EbeProviderPackage ebeProviderPackage =new EbeProviderPackage();
		ebeProviderPackage.setOpTime("1000-08-16 10:38:13");
		try {
			//遍历专家打分表,获取指定包和指定供应商的记录
			String sql=" FROM  EbeProviderPackage d where d.packageId = :packageId and d.supplierId = :supplierId";
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("packageId", packageId);
			params.put("supplierId", supplierId);
			List<EbeProviderPackage> list = tableDao.otherQuery(sql, true,true , params);
			//通过比对optime选择最新的打分记录
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			for(int i = 0; i < list.size(); i++){
				Date d1= sf.parse(list.get(i).getOpTime());//把时间格式化
				Date d2 = sf.parse(ebeProviderPackage.getOpTime());//把时间格式化
				if(d1.getTime() >= d2.getTime()){  //比较大小；
					ebeProviderPackage = list.get(i);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ebeProviderPackage;
	}
	
	/**
	 * 生成加权平均分的名次
	 * @param packageId 包的主键编号 supplierIds 要参与排名的供应商的主键编号
	 * @return 成功/失败
	 * @author hgl
	 * date 2014/08/16
	 */
	public Boolean calculateScoreRanking(Integer packageId, List<Integer> supplierIds){
		Integer ranking=0;	
		setTableDao(new TableDao());
		EbeProviderPackage ebeProviderPackage =new EbeProviderPackage();
		try {
			//查询对于某包的供应商们的list对象
			String sql=" FROM  EbeProviderPackage d where d.packageId = :packageId and d.supplierId in (:supplierIds)";
			//Session session = HibernateUtils.getSession();
			//session.beginTransaction();
			//Query query = session.createQuery(sql);
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("packageId", packageId);
			params.put("supplierIds", supplierIds);
			//params.setParameter("packageId", packageId); 
			//params.setParameterList("supplierIds", supplierIds); 
			List<EbeProviderPackage> list=tableDao.otherQuery(sql, true, true, params);
		
			//List<EbeProviderPackage> list= query.list();
			//session.close();
			//排序
			Collections.sort(list,new Comparator<EbeProviderPackage>(){
				//内部类
	            public int compare(EbeProviderPackage arg0, EbeProviderPackage arg1) {
	            	if(arg0.getFinishScore() < arg1.getFinishScore()){//>则从大到小排列
	            		return 1;
	            	}else{
	            		return -1;
	            	}
	                //return arg0.getFinishScore().compareTo(arg1.getFinishScore());
	            }
	        });
	        for(int i=0; i < list.size(); i++){
	            list.get(i).setSumSeq(i+1);
	            //修改数据库
	            modifyEbeProviderPackage(new EbeProviderPackageVo(list.get(i)));
	        }
	    }catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return true;
	}
	
	/**
	 * 打分清成-1,完成初始化（未调用重新计算排名函数）
	 * @param packageId 包的主键编号 supplierIds 供应商的主键编号
	 * @return EbeProviderPackageVo对象
	 * @author hgl
	 * date 2014/08/16
	 */
	public EbeProviderPackageVo initScore(Integer packageId, Integer supplierId){
		setTableDao(new TableDao());
		try {	
			String sql=" FROM  EbeProviderPackage d where d.packageId = :packageId and d.supplierId = :supplierId";
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("packageId", packageId);
			params.put("supplierId", supplierId);
			List<EbeProviderPackage> list = tableDao.otherQuery(sql, true,true , params);
			if(list == null || list.size() == 0){
				EbeProviderPackageVo ebeProviderPackageVo =new EbeProviderPackageVo();
				ebeProviderPackageVo.setBusiAvgScore(0);
				ebeProviderPackageVo.setPriceAvgScore(0);
				ebeProviderPackageVo.setTechAvgScore(0);
				//加权平均分
				ebeProviderPackageVo.setBusiJqScore(0);
				ebeProviderPackageVo.setTechJqScore(0);
				ebeProviderPackageVo.setPriceJqScore(0);
				//加权平均分之和
				ebeProviderPackageVo.setFinishScore(0);
				//其他属性（可能不全）
				ebeProviderPackageVo.setPackageId(packageId);
				ebeProviderPackageVo.setSupplierId(supplierId);
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
				ebeProviderPackageVo.setOpTime(df.format(new Date()));
				insertEbeProviderPackage(ebeProviderPackageVo);
				return ebeProviderPackageVo;
			}else{
				EbeProviderPackageVo ebeProviderPackageVo =new EbeProviderPackageVo(list.get(0));
				ebeProviderPackageVo.setBusiAvgScore(0);
				ebeProviderPackageVo.setPriceAvgScore(0);
				ebeProviderPackageVo.setTechAvgScore(0);
				//加权平均分
				ebeProviderPackageVo.setBusiJqScore(0);
				ebeProviderPackageVo.setTechJqScore(0);
				ebeProviderPackageVo.setPriceJqScore(0);
				//加权平均分之和
				ebeProviderPackageVo.setFinishScore(0);
				//其他属性（可能不全）
				ebeProviderPackageVo.setPackageId(packageId);
				ebeProviderPackageVo.setSupplierId(supplierId);
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
				ebeProviderPackageVo.setOpTime(df.format(new Date()));
				modifyEbeProviderPackage(ebeProviderPackageVo);
				return ebeProviderPackageVo;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
