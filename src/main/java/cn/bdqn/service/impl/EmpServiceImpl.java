package cn.bdqn.service.impl;

import java.util.List;

import javax.annotation.Resource;

import cn.bdqn.dao.EmpDao;
import cn.bdqn.pojo.Emp;
import cn.bdqn.service.EmpService;
import org.springframework.stereotype.Service;

@Service("empService")
public class EmpServiceImpl implements EmpService {
	@Resource(name="empDao")
	private EmpDao empDao;
	@Override
	public List<Emp> findEmps() {
		return empDao.findEmps();
	}
	public void setEmpDao(EmpDao empDao) {
		this.empDao = empDao;
	}
	@Override
	public List<Emp> findEmpsByPage(Emp emp, Integer currno, Integer pageSize) {
		return empDao.findEmpsByPage(emp, (currno-1)*pageSize, pageSize);
	}
	
	

}
