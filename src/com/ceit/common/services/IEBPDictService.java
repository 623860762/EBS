package com.ceit.common.services;

import java.util.List;

import com.ceit.common.entity.EBPDict;

/**
 * 字典数据配置业务逻辑接口
 * @author wujinshui
 *
 */

public interface IEBPDictService {
	
	/**
	 * 保存字典数据
	 * @param dic 字典表实体类实例
	 * @author wujinshui
	 */
    public Integer persist(EBPDict dic);
	
    /**
     * 修改字典表数据
     * @param dic 字典表实体类实例
     * @author wujinshui
     */
	public boolean merge(EBPDict dic);
	

	/**
	 * 根据id物理真删除字典数据项
	 * @param dicId 字典数据项id
	 * @author wujinshui
	 */
	public boolean removeByIdREAL(String dicId);
	
	/**
	 * 根据id获取字典数据项
	 * @param dicId 字典数据项id
	 * @author wujinshui
	 */
	public EBPDict getById(String dicId); 
	
	/**
	 * 获取所有字典数据项
	 * @author wujinshui
	 */
	public List<EBPDict> getAll();
	
	/**
	 * 根据父id获取所有子项数据
	 * @param parentId
	 * @author wujinshui
	 */
	public List<EBPDict> getByParentId(String parentId);
	

}
