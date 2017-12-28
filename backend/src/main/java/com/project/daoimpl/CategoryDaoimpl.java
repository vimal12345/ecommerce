package com.project.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.CategoryDao;
import com.project.model.Category;


@Repository("categoryDAO")
@Transactional
public class CategoryDaoimpl implements CategoryDao
{
	@Autowired
	SessionFactory sessionFactory;

	
	@Override
	public boolean addCategory(Category category) 
	{
		try
		{
		Session session=sessionFactory.getCurrentSession();
		session.save(category);
		return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}

	
	
	public List<Category> retrieveCategory() 
	{
		Session session=sessionFactory.openSession();
		
		List<Category> listCategory=session.createQuery("FROM Category", Category.class).list();
	
		return listCategory;
	}

	
	
	public boolean deleteCategory(Category category) 
	{	
		try
		{
		Session session=sessionFactory.getCurrentSession();
		System.out.println("delete" + category.getId());
		session.delete(category);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception Arised:"+e);	
		return false;
		}
	}

	
	public Category getCategory(int catId) 
	{
		Session session=sessionFactory.openSession();
		Category category=(Category)session.get(Category.class,catId);
		session.close();
		return category;
	}

	
	
	public boolean updateCategory(Category category) 
	{
		try
		{
		sessionFactory.getCurrentSession().saveOrUpdate(category);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception Arised:"+e);
		return false;
		}
	}
	
}
