package cn.bdqn.dao.impl;

import java.sql.SQLException;
import java.util.List;

import cn.bdqn.dao.EmpDao;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import cn.bdqn.dao.EmpDao;
import cn.bdqn.pojo.Emp;

@Repository("empDao")
public class EmpDaoImpl extends HibernateDaoSupport implements EmpDao {
	@Autowired
	public EmpDaoImpl(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}

	@Override
	public List<Emp> findEmps() {
		return this.getHibernateTemplate().find("from cn.bdqn.pojo.Emp");
	}

	@Override
	public List<Emp> findEmpsByPage(final Emp emp, final Integer from, final Integer pageSize) {
		return this.getHibernateTemplate().execute(new HibernateCallback<List<Emp>>() {
			@Override
			public List<Emp> doInHibernate(Session session) throws HibernateException,
					SQLException {
//				String hql="from Emp where 1=1 ";
				StringBuilder hql = new StringBuilder("from Emp as e where 1=1 ");
				if (emp.getEname() != null) {
					hql.append(" and  e.ename like :ename");
				}
				Query query = session.createQuery(hql.toString()).setProperties(emp).setFirstResult(from).setMaxResults(pageSize);
				return query.list();
			}
		});
	}
}




