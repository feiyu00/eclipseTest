package org.yxyy.service;

import java.util.List;

import org.yxyy.pojo.Employee;

public interface EmployeeService {

	//登录验证
	boolean login(String uname,String upass);
	
	//查询所有用户信息
	List<Employee> getEmps();
	
	void insertEmp(Employee employee);
	
	void updateEmp(Employee employee);
	
	Employee getEmp1(int id);
	void deleteEmp(int id);
}
