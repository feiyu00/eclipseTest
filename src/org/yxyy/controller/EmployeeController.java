package org.yxyy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.yxyy.pojo.Employee;
import org.yxyy.service.EmployeeService;
import org.yxyy.service.impl.EmployeeServiceImpl;

@Controller
public class EmployeeController{

	@Autowired
	private EmployeeService eService;
	//登录方法
	@RequestMapping("login.do")
	public String login(Employee employee,Model model,HttpSession session){
		boolean result = eService.login(employee.getUname(), employee.getUpass());
		if(result){//如果为true验证成功，跳转到主页面
			//获取所有用户信息
			List<Employee> emps = eService.getEmps();
			model.addAttribute("emps", emps);
			session.setAttribute("emp", employee);
			return "/index.jsp";
		}else{//如果为false验证失败，跳转到登录界面，提示错误信息
			model.addAttribute("msg", "用户名或密码错误！");
			return "/login.jsp";
		}
	}
	
	//新增方法
	@RequestMapping("/add.do")
	public String add(Employee employee,Model model){
		eService.insertEmp(employee);
		List<Employee> emps = eService.getEmps();
		model.addAttribute("result", "add");
		model.addAttribute("emps", emps);
		return "/index.jsp";
	}
	//通过id获取employee表的数据
	@RequestMapping("/getempbyid.do")
	public String getEmpById(int id,Model model){
		Employee emp1 = eService.getEmp1(id);
		model.addAttribute("emp", emp1);
		return "/update.jsp";
	}
	
	//更新的方法
	@RequestMapping("/update.do")
	public String update(Employee employee,Model model){		
		eService.updateEmp(employee);
		List<Employee> emps = eService.getEmps();
		model.addAttribute("emps", emps);
		model.addAttribute("result", "update");
		return "/index.jsp";
	}
	
	//删除方法
	@RequestMapping("/delete.do")
	public String delete(int id,Model model){
		eService.deleteEmp(id);
		List<Employee> emps = eService.getEmps();
		model.addAttribute("emps", emps);
		model.addAttribute("result", "delete");
		return "/index.jsp";
	}
	
	
}
