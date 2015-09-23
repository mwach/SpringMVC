package mawa.com.pl.springmvc.config;

import javax.validation.Validator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Import(RepositoryRestMvcConfiguration.class)
@Configuration
@ComponentScan({"mawa.com.pl.springmvc.controller", "mawa.com.pl.springmvc.dao", "mawa.com.pl.springmvc.service"})
@EnableWebMvc
@EnableJpaRepositories("mawa.com.pl.springmvc.dao")
@EnableTransactionManagement
public class WebAppConfig {

	@Bean
	public UrlBasedViewResolver setupViewResolver() {
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setPrefix("/WEB-INF/pages/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		return resolver;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	    LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
	    em.setPackagesToScan("mawa.com.pl.springmvc.bean");
	    em.setPersistenceXmlLocation("classpath:META-INF/persistence.xml");
	    em.setPersistenceUnitName("projectPersistence");
	    return em;
	}

	@Bean
	public Validator validator(){
		return new LocalValidatorFactoryBean();
	}
	@Bean(name="transactionManager")
	public JpaTransactionManager getTransactionManager(){
		JpaTransactionManager mgr = new JpaTransactionManager();
		return mgr;
	}
}
