package com.project.test;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.project.config.DBConfig;
import com.project.dao.CategoryDao;
import com.project.model.Category;

@SuppressWarnings("unused")
public class CategoryTest 
{
	static CategoryDao categoryDAO;
	
	@BeforeClass
	public static void initialize()
	{
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext configApplnContext=new AnnotationConfigApplicationContext();
		configApplnContext.scan("com.project");
		configApplnContext.refresh();
		
		//SessionFactory sessionFactory=(SessionFactory)configApplnContext.getBean("DBConfig.class");
		
		categoryDAO=(CategoryDao)configApplnContext.getBean("categoryDAO");
	}
	
	@Ignore
	@Test
	public void addCategoryTest()
	{
		Category category=new Category();
		category.setId(102);
		category.setCatName("Desktop");
		category.setCatDesc("all kinds of desktops ");
		
		assertTrue(categoryDAO.addCategory(category));
	}
	
	@Ignore
	@Test
	public void updateCategoryTest()
	{
		Category category=new Category();
		category.setId(1002);
		category.setCatName("SmartPhone");
		category.setCatDesc("SmartPhone with Best Price");
		
		assertTrue(categoryDAO.updateCategory(category));
	}
	@Ignore
	@Test
	public void deleteCategoryTest()
	{
		Category category=new Category();
		category.setId(1002);
		assertTrue(categoryDAO.deleteCategory(category));
	}
	@Ignore
	@Test
	public void retrieveCategoryTest()
	{
		List<Category> listCategory=categoryDAO.retrieveCategory();
		assertNotNull("Problem in Retriving ",listCategory);
		this.show(listCategory);
	}
	
	public void show(List<Category> listCategory)
	{
		for(Category category:listCategory)
		{
			System.out.println("Category ID:"+category.getId());
			System.out.println("Category Name:"+category.getCatName());
		}
	}
	
	
	@Test
	public void getCategoryTest()
	{
		Category category=categoryDAO.getCategory(101);
		assertNotNull("Problem in Getting:",category);
		System.out.println("Category ID:"+category.getId());
		System.out.println("Category Name:"+category.getCatName());
		System.out.println("Category Description  = "+category.getCatDesc());
	}

}







