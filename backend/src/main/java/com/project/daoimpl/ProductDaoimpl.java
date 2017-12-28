package com.project.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.ProductDao;
import com.project.model.Product;
@SuppressWarnings("deprecation")
@Repository("ProductDao")
@Transactional
public class ProductDaoimpl implements ProductDao {
	@Autowired
	SessionFactory sessionFactory;
    
	@Override
	public boolean addProduct(Product product) {

		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(product);
			return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Product> retrieveProducts() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Product");
		List<Product> listProduct=query.list();
		session.close();
		return listProduct;
	}

	@Override
	public boolean deleteProduct(Product product) {
		try
		{
			sessionFactory.getCurrentSession().delete(product);
			return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}

	@Override
	public Product getProduct(int productId) {
		Session session=sessionFactory.openSession();
		Product product=(Product)session.get(Product.class,productId);
		session.close();
		return product;
	}

	@Override
	public boolean updateProduct(Product product) {
		try
		{
		sessionFactory.getCurrentSession().saveOrUpdate(product);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception Arised:"+e);

		return false;
	}

}

	@Override
	public List<Product> getProductByCategory(int id) {
		
		return sessionFactory.getCurrentSession().createQuery("FROM Product WHERE CATEGORY_ID = '"+id+"'",Product.class).getResultList();
	}
}
