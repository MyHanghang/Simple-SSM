package com.lzh.model;

public class Employee {

	private Integer id;
	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getEmpName() {
		return empName;
	}



	public void setEmpName(String empName) {
		this.empName = empName;
	}



	public String getEmpAge() {
		return empAge;
	}



	public void setEmpAge(String empAge) {
		this.empAge = empAge;
	}



	public String getEmpSex() {
		return empSex;
	}



	public void setEmpSex(String empSex) {
		this.empSex = empSex;
	}



	public String getEmpHeadPortrait() {
		return empHeadPortrait;
	}



	public void setEmpHeadPortrait(String empHeadPortrait) {
		this.empHeadPortrait = empHeadPortrait;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getProvince() {
		return province;
	}



	public void setProvince(String province) {
		this.province = province;
	}



	private String empName;
	private String empAge;
	private String empSex;
	private String empHeadPortrait;
	private String city;
	private String province;

	

	@Override
	public String toString() {
		return "Employee [id=" + id + ", empName=" + empName + ", empAge=" + empAge + ", empSex=" + empSex
				+ ", empHeadPortrait=" + empHeadPortrait + ", city=" + city + ", province=" + province + "]";
	}

}
