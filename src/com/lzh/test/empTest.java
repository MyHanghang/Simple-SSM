package com.lzh.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lzh.mapper.EmployeeMapper;
import com.lzh.model.Employee;
import com.lzh.model.EmployeeCustomer;
import com.lzh.service.CityService;
import com.lzh.service.EmployeeService;
import com.lzh.service.ProvinceService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class empTest {
	@Autowired
	private EmployeeMapper employeeMapper;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private ProvinceService provinceService;

	@Autowired
	private CityService cityService;

	/**
	 * 
	 * 
	 * @Ignore
	 * @Test public void test() { int i = 0; for (EmployeeCustomer e :
	 *       employeeService.employeeList()) { System.out.println(i + "��" + e); i++;
	 *       }
	 * 
	 *       }
	 * 
	 * @Ignore
	 * @Test public void test1() { int i = 0; for (Province e :
	 *       provinceService.provinceList()) { System.out.println(i + "��" + e); i++;
	 *       }
	 * 
	 *       }
	 * 
	 * @Test public void test2() { int i = 0; for (City c : cityService.cityList(3))
	 *       { System.out.println(i + "��" + c); i++; }
	 * 
	 *       }
	 * 
	 * @Test public void test3() { Employee employee = new Employee();
	 *       employee.setEmpName("С����"); employee.setEmpAge(22);
	 *       employee.setEmpSex("Ů"); employee.setEmpHeadPortrait("dsds");
	 *       employee.setCity(1001); employee.setProvince(1); int i =
	 *       employeeService.addEmp(employee); if ("".equals(i)) {
	 *       System.out.println("����"); } else { System.out.println("��ȷ���أ�" + i); }
	 * 
	 *       }
	 * 
	 * @Test public void test3() { EmployeeCustomer emp =
	 *       employeeMapper.findEmployeeById(33); System.out.println("��ѯ�ɹ���" + emp);
	 *       }
	 * 
	 * 
	 * @Test public void test4() { CityProvince cp =
	 *       employeeMapper.findProCityById(1); System.out.println("��ѯ�ɹ���" + cp); }
	 * 
	 * 
	 * @Test public void test4() { Employee employee = new Employee();
	 *       employee.setId(33); employee.setEmpName("����ɭ");
	 *       employee.setEmpAge("40"); employee.setEmpSex("��");
	 *       employee.setEmpHeadPortrait("dadsadas/dsdddddddddddddddd");
	 *       employee.setCity("2001"); employee.setProvince("2"); int a =
	 *       employeeService.saveEditEmp(employee); System.out.println("�޸ĳɹ���" + a);
	 *       }
	 * 
	 */

	@Test
	public void test5() {
		List<Employee> employee = employeeService.SearchEmployee("ף");
		System.out.println("��ѯ�ɹ��ɹ���" + employee);
	}

}
