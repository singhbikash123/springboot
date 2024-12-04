package com.java.codeganges.jpa.configuration;

import org.springframework.stereotype.Component;

//@Configuration
//@EnableJpaRepositories( basePackages = {"com.java.codeganges.jpa.dao"} )
//@EnableTransactionManagement
public class PersistenceJPAConfig {
	
	@Bean
	@Component
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("system");
		dataSource.setPassword("admin");
		return dataSource;
		
	}
	
	/*@Bean
	  public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

	    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	    vendorAdapter.setGenerateDdl(true);

	    LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
	    factory.setJpaVendorAdapter(vendorAdapter);
	    factory.setPackagesToScan("com.java.codeganges.jpa.entity");
	    factory.setDataSource(getDataSource());
	    factory.setJpaProperties(additionalProperties());
	    return factory;
	  }

	
	 @Bean
	  public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
	    JpaTransactionManager txManager = new JpaTransactionManager();
	    txManager.setEntityManagerFactory(entityManagerFactory().getObject());
	    return txManager;
	  }
	
	 
	 Properties additionalProperties() {
		    Properties properties = new Properties();
		    properties.setProperty("hibernate.hbm2ddl.auto", "none");
		    //properties.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracledialect");
		    properties.setProperty("spring.jpa.show-sql", "true");
		       
		    return properties;
		}
	   */
}
