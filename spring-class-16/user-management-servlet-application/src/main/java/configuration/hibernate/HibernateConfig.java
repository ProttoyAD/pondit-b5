//package configuration.hibernate;
//
//
//import jakarta.enterprise.context.ApplicationScoped;
//import jakarta.persistence.EntityManagerFactory;
//
//import java.util.Properties;
//
//@ApplicationScoped
//public class HibernateConfig {
//
//    @Bean(name = "dataSource")
//    public static DriverManagerDataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(Properties.DB_DRIVER_CLASS);
//        dataSource.setUrl(Properties.DB_URL);     //MySQL Specific: +"?createDatabaseIfNotExist=true&autoReconnect=true&useSSL=false"
//        dataSource.setUsername(Properties.DB_USER);
//        dataSource.setPassword(Properties.DB_PASSWORD);
//        return dataSource;
//    }
//
//    @Bean
//    JdbcTemplate jdbcTemplate(){
//        return new JdbcTemplate(dataSource());
//    }
//
//    @Bean
//    @Primary
//    public LocalSessionFactoryBean sessionFactory() {
//        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
//        sessionFactoryBean.setDataSource(dataSource());
//        sessionFactoryBean.setPackagesToScan(ENTITY_MANAGER_PACKAGES_TO_SCAN);
//        Properties hibernateProperties = new Properties();
//        hibernateProperties.put("javax.persistence.jdbc.url", Properties.DB_URL);
//        hibernateProperties.put("hibernate.dialect", Properties.HIBERNATE_DIALECT);
//        hibernateProperties.put("hibernate.show_sql", Properties.HIBERNATE_SHOW_SQL);
//        hibernateProperties.put("hibernate.hbm2ddl.auto", Properties.HBM2DDL_AUTO);
//        hibernateProperties.put("hibernate.connection.autocommit", false);
//        hibernateProperties.put("hibernate.enable_lazy_load_no_trans", true);
//        sessionFactoryBean.setHibernateProperties(hibernateProperties);
//
//        return sessionFactoryBean;
//    }
//
//    @Bean
//    public PlatformTransactionManager transactionManager() {
//        final JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(entityManagerFactory());
//        return transactionManager;
//    }
//
//    @Bean
//    public EntityManagerFactory entityManagerFactory() {
//
//        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        vendorAdapter.setGenerateDdl(true);
//        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
//        factory.setJpaVendorAdapter(vendorAdapter);
//        factory.setPackagesToScan(ENTITY_MANAGER_PACKAGES_TO_SCAN);
//        factory.setDataSource(dataSource());
//        factory.afterPropertiesSet();
//
//        return factory.getObject();
//    }
//}
