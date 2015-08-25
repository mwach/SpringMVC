package mawa.com.pl.springmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

//@Import(RepositoryRestMvcConfiguration.class)
@Configuration
@ComponentScan({"mawa.com.pl.springmvc.controller", "mawa.com.pl.springmvc.dao"})
@EnableWebMvc
@EnableJpaRepositories("mawa.com.pl.springmvc.dao")
public class WebAppConfig {

	@Bean
	public UrlBasedViewResolver setupViewResolver() {
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setPrefix("/WEB-INF/pages/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		return resolver;
	}

//	@Bean
//	public DataSource dataSource() {
//	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
//	    dataSource.setDriverClassName("org.hsqldb.jdbc.JDBCDriver");
//	    dataSource.setUrl("jdbc:hsqldb:mem:testdb");
//	    dataSource.setUsername("sa");
//	    dataSource.setPassword("");
//	    return dataSource;
//	}
//
//	@Bean
//	public EntityManager entityManager() {
//	    return entityManagerFactory().getObject().createEntityManager();
//	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	    LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//	    em.setDataSource(dataSource());
	    em.setPackagesToScan("mawa.com.pl.springmvc.bean");
//	    em.setPersistenceProviderClass(org.hibernate.ejb.HibernatePersistence.class);
	    em.setPersistenceXmlLocation("classpath:META-INF/persistence.xml");
	    em.setPersistenceUnitName("projectPersistence");
//	    em.setJpaVendorAdapter(jpaVendorAdapter);
	    return em;
	}

	@Bean(name="transactionManager")
	public JpaTransactionManager getTransactionManager(){
		JpaTransactionManager mgr = new JpaTransactionManager();
		return mgr;
	}

}
