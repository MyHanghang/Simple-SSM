package com.lzh.model;

public class CityProvince {

	private int cId;
	private int pId;
	private String cityName;
	private String provinceName;

	@Override
	public String toString() {
		return "CityProvince [cId=" + cId + ", pId=" + pId + ", cityName=" + cityName + ", provinceName=" + provinceName
				+ "]";
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

}