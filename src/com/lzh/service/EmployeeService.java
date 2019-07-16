package com.lzh.service;

import java.util.List;

import com.lzh.model.CityProvince;
import com.lzh.model.Employee;
import com.lzh.model.EmployeeCustomer;

public interface EmployeeService {

	/**
	 * ��ѯ����Ա����Ϣ
	 * 
	 * @return
	 */
	List<EmployeeCustomer> employeeList();

	/**
	 * �������Ա����Ϣ
	 * 
	 * @param employee
	 * @return
	 */
	int addEmp(Employee employee);

	/**
	 * ͨ��Id����Ա����Ϣ
	 * 
	 * @param id
	 * @return
	 */
	EmployeeCustomer findEmployeeById(Integer id);

	/**
	 * ͨ��id����Ա��ʡ�ݳ�����Ϣ
	 * 
	 * @param id
	 * @return
	 */
	CityProvince findProCityById(Integer id);

	/**
	 * �����޸ĺ��Ա����Ϣ
	 * 
	 * @param employee
	 * @return
	 */
	int saveEditEmp(Employee employee);

	/**
	 * ����Ա����������Ա����Ϣ
	 * 
	 * @param empName
	 * @return
	 */
	List<Employee> SearchEmployee(String empName);
}
