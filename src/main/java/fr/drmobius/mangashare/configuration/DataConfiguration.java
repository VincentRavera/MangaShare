package fr.drmobius.mangashare.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "fr.drmobius.mangashare.dao", entityManagerFactoryRef = "entityManagerFactory")
public class DataConfiguration {
	private Logger logger = LoggerFactory.getLogger(DataConfiguration.class);

	@Autowired
	private Environment environment;
	// autre façon de recuperer les properties mais on doit obligatoirement
	// declarer un PropertySourcesPlaceholderConfigurer
	@Value("${db.driverclassname}")
	private String driverClassName;

	@Bean(name = "dataSource")
	@Profile("tomcat")
	public DataSource dataSourceTomcat() {
		logger.info("chargement datasource profile tomcat");
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(environment.getProperty("db.driverclassname"));
		dataSource.setUrl(environment.getProperty("db.url"));
		dataSource.setUsername(environment.getProperty("db.username"));
		dataSource.setPassword(environment.getProperty("db.password"));

		return dataSource;
	}

	@Bean(name = "dataSource")
	@Profile("test")
	public DataSource dataSourceTest() {
		logger.info("chargement datasource profile test");
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(environment.getProperty("dbtest.driverclassname"));
		dataSource.setUrl("dbtest.url");
		dataSource.setUsername(environment.getProperty("dbtest.username"));
		dataSource.setPassword(environment.getProperty("dbtest.password"));
		return dataSource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();

		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		hibernateJpaVendorAdapter.setGenerateDdl(true);
		hibernateJpaVendorAdapter.setShowSql(true);
		hibernateJpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
		hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);

		localContainerEntityManagerFactoryBean.setJpaVendorAdapter(hibernateJpaVendorAdapter);

		localContainerEntityManagerFactoryBean.setDataSource(dataSource);

		Properties properties = new Properties();
		properties.put("hibernate.generate_statistics", true);

		localContainerEntityManagerFactoryBean.setJpaProperties(properties);
		localContainerEntityManagerFactoryBean.setPackagesToScan("fr.drmobius.mangashare.model");

		return localContainerEntityManagerFactoryBean;

	}

	@Bean
	public PlatformTransactionManager transactionManager(DataSource dataSource) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory(dataSource).getObject());
		return transactionManager;
	}

}
