package com.lzh.service;

import java.util.List;

import com.lzh.model.CityProvince;
import com.lzh.model.Employee;
import com.lzh.model.EmployeeCustomer;

public interface EmployeeService {

	/**
	 * 查询所有员工信息
	 * 
	 * @return
	 */
	List<EmployeeCustomer> employeeList();

	/**
	 * 单个添加员工信息
	 * 
	 * @param employee
	 * @return
	 */
	int addEmp(Employee employee);

	/**
	 * 通过Id查找员工信息
	 * 
	 * @param id
	 * @return
	 */
	EmployeeCustomer findEmployeeById(Integer id);

	/**
	 * 通过id查找员工省份城市信息
	 * 
	 * @param id
	 * @return
	 */
	CityProvince findProCityById(Integer id);

	/**
	 * 保存修改后的员工信息
	 * 
	 * @param employee
	 * @return
	 */
	int saveEditEmp(Employee employee);

	/**
	 * 根据员工姓名搜索员工信息
	 * 
	 * @param empName
	 * @return
	 */
	List<Employee> SearchEmployee(String empName);
}
