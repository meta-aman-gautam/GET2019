package com.metacube.ead.assignment.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * The Class ApplicationContext using Spring configuration using @configuration annotation
 * 
 * @author Aman Gautam
 * 
 * Dated : 18/9/19
 */
@Configuration
@EnableTransactionManagement
public class ApplicationContext {
	

	/**
	 * Gets the hibernate template.
	 *
	 * @return the hibernate template
	 */
	@Bean
	public HibernateTemplate getHibernateTemplate(){
		return new HibernateTemplate(getSessionFactory());
	}
	
	
	/**
	 * Gets the data source. for the initialization of the database connection 
	 *
	 * @return the data source
	 */
	@Bean
	public DataSource getDataSource() {
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
	  
	    dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
	    dataSource.setUrl("jdbc:mysql://localhost:3306/student");
	    dataSource.setUsername("root");
	    dataSource.setPassword("1083543569");
	 
	    return dataSource;
	}
	
	/**
	 * Gets the session factory.
	 *
	 * @return the session factory
	 */
	//Session Factory
	@Bean
	public SessionFactory getSessionFactory(){
	LocalSessionFactoryBean objBean = new LocalSessionFactoryBean();
	objBean.setDataSource(getDataSource());
	objBean.setPackagesToScan("com.metacube.ead.assignment.entity");
	objBean.setHibernateProperties(getProperties());
	try{
		objBean.afterPropertiesSet();
	}
	catch(Exception e){
		System.out.println(e.getMessage());
	}
	return objBean.getObject();
	}
	

	/**
	 * Gets the Hibernate Transaction Manager object (using session factory).
	 *
	 * @return the Hibernate Transaction Manager object
	 */
	@Bean
	public HibernateTransactionManager getHTM(){
		return  new HibernateTransactionManager(getSessionFactory());
	}
	

	/**
	 * Gets the properties.
	 *
	 * @return properties
	 */
	@Bean
	public Properties getProperties(){
		Properties properties = new Properties();
		properties.put("hibernate.dialect","org.hibernate.dialect.MySQL5Dialect");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.show_sql", "true");
		return properties;
	}
	
}
