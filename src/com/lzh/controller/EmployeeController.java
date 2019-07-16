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
		System.out.println("进入查询...,接收查询参数为：" + empName);

		ModelAndView modelAndView = new ModelAndView();

		if (empName == null || empName.equals("")) {
			List<EmployeeCustomer> emplist = employeeService.employeeList();
			modelAndView.addObject("emplist", emplist);
			modelAndView.setViewName("listEmployee");
		} else {
			System.out.println("输入查询的名字为：" + empName);
			attr.addFlashAttribute("empName", empName);
			return new ModelAndView("redirect:/listEmployee2" + empName);
		}

		return modelAndView;
	}

	@RequestMapping(value = "/listEmployee2")
	public ModelAndView SearchEmployee(String empName) {
		System.out.println("准备查询,接收：" + empName);
		ModelAndView modelAndView = new ModelAndView();
		List<Employee> emplist = employeeService.SearchEmployee(empName);
		System.out.println("返回查询的结果：" + emplist);
		modelAndView.addObject("emplist", emplist);
		modelAndView.setViewName("listEmployee2");
		return modelAndView;
	}

	@ResponseBody
	@RequestMapping(value = "editEmployee")
	public Map editEmployee(Integer empId) {
		Logger.getLogger(getClass());
		System.out.println("【进入编辑查询后台，传入的员工Id为：】" + empId);
		EmployeeCustomer emp = employeeService.findEmployeeById(empId);
		CityProvince cProvince = employeeService.findProCityById(emp.getId());
		System.out.println("【查询单个员工成功，返回整条数据：】" + emp + "【省份信息：】" + cProvince);
		Map map = new HashMap();
		map.put("list", emp);
		map.put("cityProvince", cProvince);
		return map;
	}

	@ResponseBody
	@RequestMapping(value = "listProvince")
	public Map listProvince() {
		System.out.println("进入省份列表");
		Map map = new HashMap();
		List<Province> prolist = provinceService.provinceList();
		map.put("list", prolist);
		System.out.println(prolist);
		return map;
	}

	@ResponseBody
	@RequestMapping(value = "listCity", method = RequestMethod.POST)
	public Map listCity(Integer id) {
		System.out.println("进入城市列表,接受到省份参数：【" + id + "】");
		Map map = new HashMap();
		List<City> citylist = cityService.cityList(id);
		map.put("list", citylist);
		System.out.println(citylist);
		return map;
	}

	@ResponseBody
	@RequestMapping(value = "upPic", method = RequestMethod.POST)
	public Map upPic(MultipartFile file, HttpServletRequest request) {
		System.out.println("进入图片上传,上传文件名为:" + file.getOriginalFilename());
		String path = request.getSession().getServletContext().getRealPath("upload/");
		System.out.println("------->" + path);
		String fileName = file.getOriginalFilename();
		String newFileName = UUID.randomUUID() + fileName.substring(fileName.lastIndexOf("."));
		String filePath = "upload/" + newFileName;
		System.out.println("新文件名：" + newFileName);
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
		System.out.println("进入添加员工接口...");
		Employee employee = new Employee();
		employee.setEmpName(empName);
		employee.setEmpAge(empAge);
		employee.setEmpSex(empSex);
		employee.setEmpHeadPortrait(empHeadPortrait);
		employee.setCity(city);
		employee.setProvince(province);
		System.out.println("添加的员工信息：" + employee);
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
		System.out.println("进入保存修改员工接口111..." + empId + "," + empName + "," + empAge + "," + empSex + ","
				+ empHeadPortrait + "," + city + "," + province);
		Employee employee = new Employee();
		employee.setId(empId);
		employee.setEmpName(empName);
		employee.setEmpAge(empAge);
		employee.setEmpSex(empSex);
		employee.setEmpHeadPortrait(empHeadPortrait);
		employee.setCity(city);
		employee.setProvince(province);
		System.out.println("修改的员工信息：" + employee);
		int i = employeeService.saveEditEmp(employee);
		map.put("list", i);
		return map;
	}
}
