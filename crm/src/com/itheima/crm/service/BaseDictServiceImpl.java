package com.itheima.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.crm.mapper.BaseDictMapper;
import com.itheima.crm.pojo.BaseDict;

@Service
public class BaseDictServiceImpl implements BaseDictService {

	@Autowired
	private BaseDictMapper baseDictMapper;

	public List<BaseDict> findBaseDictByTypeCode(String typeCode) {
		List<BaseDict> list = baseDictMapper.findBaseDictByTypeCode(typeCode);
		return list;
	}

}
