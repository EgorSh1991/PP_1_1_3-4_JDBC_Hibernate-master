package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.mapping.Property;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/new_schema?autoReconnect=true&useSSL=false";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "root";
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {

        Configuration config = new Configuration();
        Properties settings = new Properties();
        settings.setProperty(Environment.URL, URL);
        settings.setProperty(Environment.USER, USER_NAME);
        settings.setProperty(Environment.PASS, PASSWORD);
        settings.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
        settings.setProperty(Environment.SHOW_SQL, "true");
        settings.setProperty(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        config.addAnnotatedClass(User.class);
        config.setProperties(settings);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(config.getProperties()).build();
        sessionFactory = config.buildSessionFactory(serviceRegistry);
        return sessionFactory;
    }

    public static Connection getConnect() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }


}
