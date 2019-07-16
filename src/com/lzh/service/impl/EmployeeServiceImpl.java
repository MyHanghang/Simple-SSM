package com.lzh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzh.mapper.EmployeeMapper;
import com.lzh.model.CityProvince;
import com.lzh.model.Employee;
import com.lzh.model.EmployeeCustomer;
import com.lzh.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeMapper employeeMapper;

	public List<EmployeeCustomer> employeeList() {
		return employeeMapper.employeeList();
	}

	@Override
	public int addEmp(Employee employee) {
		int i = employeeMapper.addEmp(employee);
		return i;
	}

	@Override
	public EmployeeCustomer findEmployeeById(Integer id) {
		return employeeMapper.findEmployeeById(id);
	}

	@Override
	public CityProvince findProCityById(Integer id) {
		return employeeMapper.findProCityById(id);
	}

	@Override
	public int saveEditEmp(Employee employee) {
		return employeeMapper.saveEditEmp(employee);
	}

	@Override
	public List<Employee> SearchEmployee(String empName) {
		return employeeMapper.SearchEmployee(empName);
	}

}
