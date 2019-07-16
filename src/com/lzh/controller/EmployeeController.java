package com.lzh.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lzh.model.City;
import com.lzh.model.CityProvince;
import com.lzh.model.Employee;
import com.lzh.model.EmployeeCustomer;
import com.lzh.model.Province;
import com.lzh.service.CityService;
import com.lzh.service.EmployeeService;
import com.lzh.service.ProvinceService;
import com.sun.istack.internal.logging.Logger;

@Controller
@RequestMapping("")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private ProvinceService provinceService;

	@Autowired
	private CityService cityService;

	@RequestMapping(value = "listEmployee")
	public ModelAndView listEmployee(String empName, RedirectAttributes attr) {
		System.out.println("�����ѯ...,���ղ�ѯ����Ϊ��" + empName);

		ModelAndView modelAndView = new ModelAndView();

		if (empName == null || empName.equals("")) {
			List<EmployeeCustomer> emplist = employeeService.employeeList();
			modelAndView.addObject("emplist", emplist);
			modelAndView.setViewName("listEmployee");
		} else {
			System.out.println("�����ѯ������Ϊ��" + empName);
			attr.addFlashAttribute("empName", empName);
			return new ModelAndView("redirect:/listEmployee2" + empName);
		}

		return modelAndView;
	}

	@RequestMapping(value = "/listEmployee2")
	public ModelAndView SearchEmployee(String empName) {
		System.out.println("׼����ѯ,���գ�" + empName);
		ModelAndView modelAndView = new ModelAndView();
		List<Employee> emplist = employeeService.SearchEmployee(empName);
		System.out.println("���ز�ѯ�Ľ����" + emplist);
		modelAndView.addObject("emplist", emplist);
		modelAndView.setViewName("listEmployee2");
		return modelAndView;
	}

	@ResponseBody
	@RequestMapping(value = "editEmployee")
	public Map editEmployee(Integer empId) {
		Logger.getLogger(getClass());
		System.out.println("������༭��ѯ��̨�������Ա��IdΪ����" + empId);
		EmployeeCustomer emp = employeeService.findEmployeeById(empId);
		CityProvince cProvince = employeeService.findProCityById(emp.getId());
		System.out.println("����ѯ����Ա���ɹ��������������ݣ���" + emp + "��ʡ����Ϣ����" + cProvince);
		Map map = new HashMap();
		map.put("list", emp);
		map.put("cityProvince", cProvince);
		return map;
	}

	@ResponseBody
	@RequestMapping(value = "listProvince")
	public Map listProvince() {
		System.out.println("����ʡ���б�");
		Map map = new HashMap();
		List<Province> prolist = provinceService.provinceList();
		map.put("list", prolist);
		System.out.println(prolist);
		return map;
	}

	@ResponseBody
	@RequestMapping(value = "listCity", method = RequestMethod.POST)
	public Map listCity(Integer id) {
		System.out.println("��������б�,���ܵ�ʡ�ݲ�������" + id + "��");
		Map map = new HashMap();
		List<City> citylist = cityService.cityList(id);
		map.put("list", citylist);
		System.out.println(citylist);
		return map;
	}

	@ResponseBody
	@RequestMapping(value = "upPic", method = RequestMethod.POST)
	public Map upPic(MultipartFile file, HttpServletRequest request) {
		System.out.println("����ͼƬ�ϴ�,�ϴ��ļ���Ϊ:" + file.getOriginalFilename());
		String path = request.getSession().getServletContext().getRealPath("upload/");
		System.out.println("------->" + path);
		String fileName = file.getOriginalFilename();
		String newFileName = UUID.randomUUID() + fileName.substring(fileName.lastIndexOf("."));
		String filePath = "upload/" + newFileName;
		System.out.println("���ļ�����" + newFileName);
		File f = new File(path, newFileName);
		try {
			if (!f.exists()) {
				file.transferTo(f);
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Map map = new HashMap();
		map.put("list", filePath);
		return map;
	}

	@ResponseBody
	@RequestMapping(value = "addEmp", method = RequestMethod.POST)
	public Map addEmp(String empName, String empAge, String empSex, String empHeadPortrait, String city,
			String province) {
		System.out.println("�������Ա���ӿ�...");
		Employee employee = new Employee();
		employee.setEmpName(empName);
		employee.setEmpAge(empAge);
		employee.setEmpSex(empSex);
		employee.setEmpHeadPortrait(empHeadPortrait);
		employee.setCity(city);
		employee.setProvince(province);
		System.out.println("��ӵ�Ա����Ϣ��" + employee);
		Map map = new HashMap();
		int i = employeeService.addEmp(employee);
		map.put("list", i);
		return map;
	}

	@ResponseBody
	@RequestMapping(value = "seveEditEmp", method = RequestMethod.PUT)
	public Map seveEditEmp(Integer empId, String empName, String empAge, String empSex, String empHeadPortrait,
			String city, String province) {
		Map map = new HashMap();
		System.out.println("���뱣���޸�Ա���ӿ�111..." + empId + "," + empName + "," + empAge + "," + empSex + ","
				+ empHeadPortrait + "," + city + "," + province);
		Employee employee = new Employee();
		employee.setId(empId);
		employee.setEmpName(empName);
		employee.setEmpAge(empAge);
		employee.setEmpSex(empSex);
		employee.setEmpHeadPortrait(empHeadPortrait);
		employee.setCity(city);
		employee.setProvince(province);
		System.out.println("�޸ĵ�Ա����Ϣ��" + employee);
		int i = employeeService.saveEditEmp(employee);
		map.put("list", i);
		return map;
	}
}
