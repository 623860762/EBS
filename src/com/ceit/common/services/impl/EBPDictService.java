package com.ceit.common.services.impl;

import java.util.List;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.entity.EBPDict;
import com.ceit.common.services.IEBPDictService;

public class EBPDictService implements IEBPDictService {
	private ITableDao tableDao;
	
	public void setTableDao(ITableDao tableDao) {
		this.tableDao = tableDao;
	}

	public Integer persist(EBPDict dic) {
		try{
			Integer fieldId = tableDao.insert(dic);
			return fieldId;
		}catch(Exception e){
			e.printStackTrace();
		}
		return -1;
	}
	
	public boolean merge(EBPDict dic) {
        try {
			boolean bool = tableDao.update(dic);
			return bool;
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return false;
	}

	public boolean removeByIdREAL(String dicId) {
        try {
        	boolean bool = tableDao.delete(Integer.valueOf(dicId), EBPDict.class);
        	return bool;
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return false;
	}
	
	public EBPDict getById(String dicId) {
		try {
			EBPDict EBPDict = (EBPDict)tableDao.getEntitybyId(Integer.valueOf(dicId), EBPDict.class);
			return EBPDict;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<EBPDict> getAll() {
		String hql = "from EBPDict";
		try {
			List<EBPDict> list = tableDao.otherQuery(hql, true, true, null);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<EBPDict> getByParentId(String parentId) {
		String hql = "from EBPDict t where";
		try {
			if(!"".equals(parentId) && parentId != null){
				hql += " t.dicParentId=" + parentId;
				List<EBPDict> list = tableDao.otherQuery(hql, true, true, null); 
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
