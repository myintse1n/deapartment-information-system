package mm.edu.ec.mtu.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mysql.cj.jdbc.Driver;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("mm.edu.ec.mtu.model.repo")
public class DatabaseConfig {
	@Bean
	DataSource dataSource() {
		var ds = new BasicDataSource();
		ds.setDriverClassName(Driver.class.getName());
		ds.setUrl("jdbc:mysql://localhost:3306/ec_db");
		ds.setUsername("ecusr");
		ds.setPassword("ecpwd");
		return ds;
	}
	
	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) throws Exception {
		var bean =new LocalContainerEntityManagerFactoryBean();
		bean.setDataSource(dataSource);
		bean.setPackagesToScan("mm.edu.ec.mtu.model.entity");
		bean.setJpaProperties(jpaProperties());
		bean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		return bean;
	}
	
	@Bean
	JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
	
	private Properties jpaProperties() throws Exception {
		var prop = new Properties();
		prop.load(getClass().getResourceAsStream("/jpa.properties"));
		return prop;
	}
}
