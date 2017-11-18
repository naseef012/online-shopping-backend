package com.naseef.shoppingbackend.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;


/**
 * Created By Naseef M Abdus Sattar on 10/9/2017 at 8:39 PM
 */
@Configuration
@ComponentScan(basePackages ={"com.naseef.shoppingbackend.dto"})
@EnableTransactionManagement
public class HibernateConfig
{
    //The code below will change depending on the database engine used in the project

    private static final String DATABASE_URL = "jdbc:h2:tcp://localhost/~/onlineshoppingwebsite";
    private static final String DATABASE_DRIVER = "org.h2.Driver";
    private static final String DATABASE_DIALECT = "org.hibernate.dialect.H2Dialect";
    private static final String DATABASE_USERNAME = "sa";
    private static final String DATABASE_PASSWORD = "";

    @Bean
    protected DataSource getDataSource()
    {
        BasicDataSource basicDataSource = new BasicDataSource();

        //Providing Data connection information
        basicDataSource.setDriverClassName(DATABASE_DRIVER);
        basicDataSource.setUrl(DATABASE_URL);
        basicDataSource.setUsername(DATABASE_USERNAME);
        basicDataSource.setPassword(DATABASE_PASSWORD);

        return basicDataSource;
    }

    //sessionFactory bean will be created
    @Bean
    public SessionFactory getSessionFactory (DataSource dataSource)
    {
        LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
        builder.addProperties(getHibernateProperties());
        builder.scanPackages("com.naseef.shoppingbackend.dto");
        return builder.buildSessionFactory();
    }

    //All the Hibernate Properties will be returned in this method
    private Properties getHibernateProperties()
    {
        Properties properties = new Properties();
        properties.put("hibernate.dialect",DATABASE_DIALECT);
        properties.put("hibernate.show_sql","true");
        properties.put("hibernate.format_sql","true");
        return properties;
    }
    //Transaction Manager Bean
    @Bean
    public HibernateTransactionManager getTransactionManager (SessionFactory sessionFactory)
    {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
        return transactionManager;
    }
}
