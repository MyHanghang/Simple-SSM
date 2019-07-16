package com.lzh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzh.mapper.ProvinceMapper;
import com.lzh.model.Province;
import com.lzh.service.ProvinceService;

@Service
public class ProvinceServiceImpl implements ProvinceService {

	@Autowired
	ProvinceMapper provinceMapper;

	@Override
	public List<Province> provinceList() {
		return provinceMapper.provinceList();
	}

}
