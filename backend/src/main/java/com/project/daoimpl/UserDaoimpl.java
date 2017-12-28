package com.project.daoimpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.UserDao;
import com.project.model.User;

@Repository("UserDao")
@Transactional
public class UserDaoimpl implements UserDao {
	@Autowired
	SessionFactory sessionFactory;

	public boolean addUser(User user) {
		try {
			System.out.println(user.getUserName());
			sessionFactory.getCurrentSession().save(user);
			sessionFactory.getCurrentSession().flush();
			System.out.println(user.getUserName());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return true;
	}

	public User getUser(int userId) {
		User user = (User) sessionFactory.getCurrentSession().createQuery("FROM User WHERE user = '" + userId + "'")
				.uniqueResult();

		return user;
	}

	@Override
	public User getUserByUsername(String username) {
		
		return sessionFactory.getCurrentSession().createQuery("FROM User WHERE username = '"+username+"'",User.class).getSingleResult();
	}

}
