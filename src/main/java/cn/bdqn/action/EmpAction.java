package cn.bdqn.action;

import java.util.List;

import javax.annotation.Resource;

import cn.bdqn.pojo.Emp;
import cn.bdqn.service.EmpService;
import org.springframework.stereotype.Controller;


import com.opensymphony.xwork2.ActionSupport;



//@Controller("empAction")
public class EmpAction extends ActionSupport{
	
	private List<Emp> emps; 

	@Resource(name="empService")
	private EmpService empService;

	public void setEmpService(EmpService empService) {
		this.empService = empService;
	}
	
	@Override
	public String execute() throws Exception {
		Emp emp=new Emp();
		emp.setEname("%��%");
		emps=empService.findEmpsByPage(emp, 1, 2);
		return SUCCESS;
	}

	public List<Emp> getEmps() {
		return emps;
	}

	public void setEmps(List<Emp> emps) {
		this.emps = emps;
	}
	
	
	
	
}
