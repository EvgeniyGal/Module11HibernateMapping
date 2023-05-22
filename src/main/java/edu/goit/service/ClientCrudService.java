package edu.goit.service;

import edu.goit.entity.Client;
import edu.goit.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Optional;

public class ClientCrudService {

    private final SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();

    public Optional<Client> get(long id) {
        try (Session session = sessionFactory.openSession()) {
            return Optional.ofNullable(session.byId(Client.class).load(id));
        }
    }

    public void delete(Client client) {
        try (Session session = sessionFactory.openSession()) {
            if (get(client.getId()).isPresent()) {
                Transaction transaction = session.beginTransaction();
                session.remove(client);
                transaction.commit();
            }
        }
    }

    public void create(Client client) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(client);
            transaction.commit();
        }
    }

    public void update(Client client) {
        try (Session session = sessionFactory.openSession()) {
            if (get(client.getId()).isPresent()) {
                Transaction transaction = session.beginTransaction();
                session.merge(client);
                transaction.commit();
            }
        }
    }
}
