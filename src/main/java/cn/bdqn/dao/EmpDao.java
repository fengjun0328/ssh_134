package cn.bdqn.dao;

import cn.bdqn.pojo.Emp;

import java.util.List;
public interface EmpDao {
	/**
	 * 查询所有的员工信息
	 * @return
	 */
	public List<Emp> findEmps();

	/**
	 * 分页显示
	 * @param from
	 * @param pageSize
	 * @return
	 */
	public List<Emp> findEmpsByPage(Emp emp,Integer from,Integer pageSize);

}
