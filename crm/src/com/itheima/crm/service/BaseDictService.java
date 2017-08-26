package com.itheima.crm.service;

import java.util.List;

import com.itheima.crm.pojo.BaseDict;

public interface BaseDictService {
	/**
	 * 根据类别代码号查询字典列表
	 * 
	 * @return
	 */
	public List<BaseDict> findBaseDictByTypeCode(String typeCode);
}
