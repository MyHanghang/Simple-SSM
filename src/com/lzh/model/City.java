package com.lzh.model;

public class City {

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Integer getProvinceId() {
		return ProvinceId;
	}

	public void setProvinceId(Integer provinceId) {
		ProvinceId = provinceId;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", cityName=" + cityName + ", ProvinceId=" + ProvinceId + "]";
	}

	private Integer id;
	private String cityName;
	private Integer ProvinceId;

}
