package com.offcn.dao;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.offcn.pojo.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Resource
	SessionFactory sessionFactory;
	
	/*public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}*/


	@Override
	public User Login(User user) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		//Session session=sessionFactory.openSession();
		if(session==null){
			session=sessionFactory.openSession();
		}
		/*Query q=session.createQuery(" from User where username='"+user.getUsername()+"' and password='"+user.getPassword()+"'");
		User loginuser=(User) q.uniqueResult();*/
		/*Query q=session.createQuery(" from User where username=:name and password=:pwd");
		q.setParameter("name", user.getUsername());
		q.setParameter("pwd", user.getPassword());*/
		Query q=session.createQuery(" from User where username=? and password=?");
		q.setParameter(0, user.getUsername());
		q.setParameter(1, user.getPassword());
		User loginuser=(User) q.uniqueResult();
		return loginuser;
	}

	@Override
	public void insertUser(User user) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		//Session session=sessionFactory.openSession();
		session.save(user);
	}

}
