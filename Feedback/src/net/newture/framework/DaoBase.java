package net.newture.framework;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

public class DaoBase extends HibernateDaoSupport {
	/** hibernateTemplate在继承类中使用 */
	protected HibernateTemplate hibernateTemplate;

	@Resource
	public void setFeedbackSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
		this.hibernateTemplate = getHibernateTemplate();
	}

	/**
	 * 查询时返回单个结果
	 * @param queryString HQL查询语句
	 * @return Object
	 * @throws DataAccessException
	 */
	public Object getSingleResult(String queryString) throws DataAccessException {
		return hibernateTemplate.find(queryString).iterator().next();
	}

	/**
	 * 查询时返回单个结果
	 * @param queryString HQL查询语句
	 * @param value 查询参数值
	 * @return Object
	 * @throws DataAccessException
	 */
	public Object getSingleResult(String queryString, Object value) throws DataAccessException {
		return hibernateTemplate.find(queryString, value).iterator().next();
	}
	
	/**
	 * 查询时返回单个结果
	 * @param queryString HQL查询语句
	 * @param values 查询参数值（多个）
	 * @return Object
	 * @throws DataAccessException
	 */
	public Object getSingleResult(String queryString, Object... values) throws DataAccessException {
		return hibernateTemplate.find(queryString, values).iterator().next();
	}
	
	/**
	 * 执行原生SQL语句查询
	 * @param sql 待执行的SQL语句
	 * @return 结果集
	 */
	public List queryBySql(final String sql) {
		return hibernateTemplate.executeFind(new HibernateCallback() {  
	        @Override 
	        public List doInHibernate(Session session) throws HibernateException, SQLException {  
	            Query query = session.createSQLQuery(sql);  
	            return query.list();  
	        }  
	    });
	}
	
	/**
	 * 执行原生SQL语句查询
	 * @param sql 待执行的SQL语句
	 * @param params 参数对象数组
	 * @return 结果集
	 */
	public List queryBySql(final String sql, final Object[] params) {
		return hibernateTemplate.executeFind(new HibernateCallback() {  
	        @Override 
	        public List doInHibernate(Session session) throws HibernateException, SQLException {  
	            Query query = session.createSQLQuery(sql);
	            for (int i = 0; i < params.length; i++) {
					query.setParameter(i, params[i]);
				}
	            return query.list();  
	        }  
	    });
	}
	
	/** 
	* 使用hql 语句进行分页操作 
	* @param hql HSQL 查询语句 
	* @param offset开始取数据的下标 
	* @param length 读取数据记录数 
	* @return List 结果集 
	*/ 
	public List<Object[]> getListForPage(final Object object,final int offset, 
	final int length) { 
		List list = getHibernateTemplate().executeFind(new HibernateCallback() { 
			public Object doInHibernate(Session session) 
			throws HibernateException, SQLException { 
				Criteria criteria = session.createCriteria(object.getClass()); 
				criteria.setFirstResult(offset); 
				criteria.setMaxResults(length); 
				List list = criteria.list(); 
				return list; 
			} 
		}); 
		return list; 
	}
}
