package com.spring.demo.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = "com.spring.demo")
public class AppConfig {
	@Autowired
	private Environment environment;
	
	@Bean
	public DataSource dataSource() {
		ComboPooledDataSource dataSource = new  ComboPooledDataSource();
		try {
			dataSource.setDriverClass("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
		dataSource.setJdbcUrl("jdbc:sqlserver://localhost:1433;databaseName=web_customer_tracker");
		dataSource.setUser("sa");
		dataSource.setPassword("123456");
		dataSource.setInitialPoolSize(5);
		dataSource.setMinPoolSize(5);
		dataSource.setMaxPoolSize(20);
		dataSource.setMaxIdleTime(3000);		
		return dataSource;
	}
	
	public Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect","org.hibernate.dialect.SQLServer2012Dialect");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		return properties;
	}
	@Bean
	public LocalSessionFactoryBean localSessionFactoryBean () {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource());
		sessionFactoryBean.setPackagesToScan("com.spring.demo.entity");
		sessionFactoryBean.setHibernateProperties(getHibernateProperties());
		return sessionFactoryBean;
	}
	@Bean
	@Autowired
	public HibernateTransactionManager hibernateTransactionManager(SessionFactory factory) {
		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(factory);
		return hibernateTransactionManager;
	}
}
