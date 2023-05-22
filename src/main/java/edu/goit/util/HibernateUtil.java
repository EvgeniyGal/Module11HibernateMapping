package edu.goit.util;

import jakarta.persistence.Entity;
import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.reflections.Reflections;

import java.util.Set;

public class HibernateUtil {
    private static final HibernateUtil INSTANCE;

    @Getter
    private SessionFactory sessionFactory;

    static {
        INSTANCE = new HibernateUtil();
    }

    private HibernateUtil() {
        Configuration configuration = new Configuration();

        Reflections reflections = new Reflections("edu.goit.entity");
        Set<Class<?>> annotatedClasses = reflections.getTypesAnnotatedWith(Entity.class);

        annotatedClasses.forEach(configuration::addAnnotatedClass);

        sessionFactory = configuration.buildSessionFactory();
    }

    public static HibernateUtil getInstance() {
        return INSTANCE;
    }

    public void close() {
        sessionFactory.close();
    }
}