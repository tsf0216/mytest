package com.itheima.crm.mapper;

import java.util.List;

import com.itheima.crm.pojo.BaseDict;

public interface BaseDictMapper {

	public List<BaseDict> findBaseDictByTypeCode(String typeCode);

}
