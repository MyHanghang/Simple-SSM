package com.lzh.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lzh.model.City;

public interface CityService {

	List<City> cityList(Integer id);
}
