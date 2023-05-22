package edu.goit.service;

import edu.goit.entity.Planet;
import edu.goit.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Optional;

public class PlanetCrudService {

    public final SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();

    public Optional<Planet> get(String id) {
        try (Session session = sessionFactory.openSession()) {
            return Optional.of(session.byId(Planet.class).load(id));
        }
    }

    public void delete(Planet planet) {
        try (Session session = sessionFactory.openSession()) {
            if (get(planet.getId()).isPresent()) {
                Transaction transaction = session.beginTransaction();
                session.remove(planet);
                transaction.commit();
            }
        }
    }

    public void create(Planet planet) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(planet);
            transaction.commit();
        }
    }

    public void update(Planet planet) {
        try (Session session = sessionFactory.openSession()) {
            if (get(planet.getId()).isPresent()) {
                Transaction transaction = session.beginTransaction();
                session.merge(planet);
                transaction.commit();
            }
        }
    }
}
