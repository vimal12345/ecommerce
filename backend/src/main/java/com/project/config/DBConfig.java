package com.project.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.project")
public class DBConfig {

	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource driverMgrDataSource = new DriverManagerDataSource();
		driverMgrDataSource.setDriverClassName("org.h2.Driver");
		driverMgrDataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
		driverMgrDataSource.setUsername("sa");
		driverMgrDataSource.setPassword("");
		return driverMgrDataSource;
	}

	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory() {
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		hibernateProperties.put("hibernate.show_sql", "true");
		hibernateProperties.put("hibernate.format_sql", "true");

		LocalSessionFactoryBuilder localSessionFacBuilder = new LocalSessionFactoryBuilder(getDataSource());
		localSessionFacBuilder.addProperties(hibernateProperties);
		localSessionFacBuilder.scanPackages("com.project");
		SessionFactory sessionFactory = localSessionFacBuilder.buildSessionFactory();
		
		System.out.println("Session Factory Object Created");
		return sessionFactory;
	}

	@Bean(name = "transactionManager")
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager hibernateTranMgr = new HibernateTransactionManager(sessionFactory);
		return hibernateTranMgr;
	}
	
	/*
	 * Multipart Resolver configuration.
	 * */
	@Bean (name="multipartResolver")
	public CommonsMultipartResolver getMultipartResolver(){
		
		long maxUploadSize = 1000000;
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(maxUploadSize);
		
		return multipartResolver;
	}


}
