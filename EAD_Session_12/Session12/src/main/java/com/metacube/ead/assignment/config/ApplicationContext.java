package com.metacube.ead.assignment.config;

import java.util.Properties;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * The Class ApplicationContext using Spring configuration using @configuration
 * annotation
 * 
 * @author Aman Gautam
 * 
 * Dated : 19/9/19
 */
@Configuration
@EnableTransactionManagement
public class ApplicationContext {

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
	 * Entity Manager Factory is made in order to set the packaging scanning
	 * 
	 * @return
	 */
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean LocalBean = new LocalContainerEntityManagerFactoryBean();
		LocalBean.setDataSource(getDataSource());
		LocalBean.setPackagesToScan(new String[] { "com.metacube.ead.assignment.entity" });

		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		LocalBean.setJpaVendorAdapter(vendorAdapter);
		LocalBean.setJpaProperties(getProperties());

		return LocalBean;
	}


	/**
	 * transactionManager() is needed in order to perform transaction to the Database
	 * 
	 * @return transactionManager
	 */
	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
	}

	/**
	 * Gets the properties such as hibernet dialect and show sql queries.
	 *
	 * @return properties
	 */
	@Bean
	public Properties getProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.show_sql", "true");
		return properties;
	}

}
