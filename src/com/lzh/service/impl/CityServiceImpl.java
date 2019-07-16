package com.lzh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzh.mapper.CityMapper;
import com.lzh.mapper.ProvinceMapper;
import com.lzh.model.City;
import com.lzh.model.Province;
import com.lzh.service.CityService;
import com.lzh.service.ProvinceService;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private CityMapper cityMapper;

	@Override
	public List<City> cityList(Integer id) {
		return cityMapper.cityList(id);
	}

}
