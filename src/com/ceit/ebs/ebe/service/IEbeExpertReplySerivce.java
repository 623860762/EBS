package com.ceit.ebs.ebe.service;

import com.ceit.common.util.PageInfo;
import com.ceit.ebs.ebe.vo.EbeExpertReplyVo;

/*
 * @author lcy date : 2014.8.7
 */

public interface IEbeExpertReplySerivce {

	//获得数据的条数
	public Integer getCount();

	//通过页数和页面大小获得vo
	public PageInfo<EbeExpertReplyVo> querydata(int pageindex, int pagesize);

	//通过id获得实体
	public EbeExpertReplyVo getEbeExpertReplybyId(int id);

	//通过实体修改数据库
	public boolean modifyEbeExpertReply(EbeExpertReplyVo s);

	//通过id删除一条数据
	public boolean deleteEbeExpertReplybyId(Integer id);

	//以Vo作为参数插入一条数据
	public Integer insertEbeExpertReply(EbeExpertReplyVo role);

}
