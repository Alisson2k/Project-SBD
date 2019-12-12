//package br.com.store.config;
//
//import com.zaxxer.hikari.HikariConfig;
//import com.zaxxer.hikari.HikariDataSource;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.persistence.EntityManagerFactory;
//import javax.sql.DataSource;
//import java.util.Properties;
//
//
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(basePackages = {"br.com.store.repository", "br.com.store.domain"})
//public class PersistenceContext {
//
//    @Bean
//    DataSource dataSource(Environment env) {
//        HikariConfig dataSourceConfig = new HikariConfig();
//        dataSourceConfig.setDriverClassName(env.getRequiredProperty("com.mysql.jdbc.Driver"));
//        dataSourceConfig.setJdbcUrl(env.getRequiredProperty("spring.datasource.url"));
//        dataSourceConfig.setUsername(env.getRequiredProperty("spring.datasource.username"));
//        dataSourceConfig.setPassword(env.getRequiredProperty(""));
//
//        return new HikariDataSource(dataSourceConfig);
//    }
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource,
//                                                                Environment env) {
//        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
//        entityManagerFactoryBean.setDataSource(dataSource);
//        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
//        entityManagerFactoryBean.setPackagesToScan("br.com.store");
//
//        Properties jpaProperties = new Properties();
//
//        jpaProperties.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
//
//        jpaProperties.put("hibernate.hbm2ddl.auto",
//                env.getRequiredProperty("hibernate.hbm2ddl.auto")
//        );
//
//        jpaProperties.put("hibernate.ejb.naming_strategy",
//                env.getRequiredProperty("hibernate.ejb.naming_strategy")
//        );
//
//        jpaProperties.put("hibernate.show_sql",
//                env.getRequiredProperty("hibernate.show_sql")
//        );
//
//        jpaProperties.put("hibernate.format_sql",
//                env.getRequiredProperty("hibernate.format_sql")
//        );
//
//        entityManagerFactoryBean.setJpaProperties(jpaProperties);
//
//        return entityManagerFactoryBean;
//    }
//
//    @Bean
//    JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(entityManagerFactory);
//        return transactionManager;
//    }
//
//
//}
