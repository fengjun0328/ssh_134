package cn.bdqn.dao;

import cn.bdqn.pojo.Dept;

import java.util.List;

public interface DeptDao {
    /**
     * 查找所有的部门信息
     * @return
     */
    public List<Dept> findDepts();
}
