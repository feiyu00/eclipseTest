package org.yxyy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.yxyy.pojo.Employee;

public interface EmployeeMapper {

	//登录验证
	@Select("select * from employee where uname=#{uname} and upass=#{upass}")
	Employee getEmp(@Param("uname")String uname,@Param("upass")String upass);
	
	//查询所有用户信息
	@Select("select * from employee")
	List<Employee> getEmps();
	
	//插入数据
	@Insert("insert into employee(uname,upass,age,phone,address) values(#{uname},#{upass},#{age},#{phone},#{address})")
	void insertEmp(Employee employee);
	
	@Update("update employee set uname=#{uname},upass=#{upass},age=#{age},phone=#{phone},address=#{address} where id=#{id}")
	void updateEmp(Employee employee);
	
	@Select("select * from employee where id=#{id}")
	Employee getEmp1(int id);
	
	@Delete("delete from employee where id=#{id}")
	void deleteEmp(int id);
}
