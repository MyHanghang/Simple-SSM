package com.lzh.mapper;

import java.util.List;

import com.lzh.model.CityProvince;
import com.lzh.model.Employee;
import com.lzh.model.EmployeeCustomer;

public interface EmployeeMapper {

	List<EmployeeCustomer> employeeList();

	int addEmp(Employee employee);

	EmployeeCustomer findEmployeeById(Integer id);

	CityProvince findProCityById(Integer id);

	int saveEditEmp(Employee employee);

	List<Employee> SearchEmployee(String empName);
}
