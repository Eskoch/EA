package edu.miu.cs.cs544.examples;

import java.util.List;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtils {
    private static SessionFactory sessionFactory;
    
    private static Configuration configuration = new Configuration();
    
    @SuppressWarnings({ "rawtypes" })
    public static SessionFactory getSessionFactory(List<Class> entityClasses) {
        if (sessionFactory == null) {
            try {
                Properties settings = new Properties();
                
//                settings.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
//                settings.put(Environment.URL, "jdbc:sqlserver://cs544.cs.miu.edu:1433"); //10.10.10.15
//                settings.put(Environment.USER, "612345");
//                settings.put(Environment.PASS, "612345");
//                settings.put(Environment.DIALECT, "org.hibernate.dialect.SQLServer2008Dialect");
                
                // MySQL
                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver"); 
                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/exercise07"); 
                settings.put(Environment.USER, "root"); 
                settings.put(Environment.PASS, "changed to new"); 
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");

                settings.put(Environment.SHOW_SQL, "true");

                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

//                settings.put(Environment.HBM2DDL_AUTO, "create-drop");
//                settings.put(Environment.HBM2DDL_AUTO, "validate");
                settings.put(Environment.HBM2DDL_AUTO, "create");

                configuration.setProperties(settings);
                
                entityClasses.forEach(entityClass -> configuration.addAnnotatedClass(entityClass));

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        return sessionFactory;
    }
    
}
