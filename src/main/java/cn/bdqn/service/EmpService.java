package cn.bdqn.service;

import java.util.List;

import cn.bdqn.pojo.Emp;

public interface EmpService {
	/**
	 *
	 * @return
	 */
	public List<Emp> findEmps();

	/**
	 *
	 * @param emp
	 * @param currno
	 * @param pageSize
	 * @return
	 */
	public List<Emp> findEmpsByPage(Emp emp, Integer currno, Integer pageSize);


}
