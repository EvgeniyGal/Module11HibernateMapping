package edu.goit.service;

import edu.goit.entity.Planet;
import edu.goit.entity.Ticket;
import edu.goit.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Optional;

public class TicketCrudService {
    public final SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();

    public Optional<Ticket> get(long id) {
        try (Session session = sessionFactory.openSession()) {
            return Optional.of(session.byId(Ticket.class).load(id));
        }
    }

    public void delete(Ticket ticket) {
        try (Session session = sessionFactory.openSession()) {
            if (get(ticket.getId()).isPresent()) {
                Transaction transaction = session.beginTransaction();
                session.remove(ticket);
                transaction.commit();
            }
        }
    }

    public void create(Ticket ticket) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(ticket);
            transaction.commit();
        }
    }

    public void update(Ticket ticket) {
        try (Session session = sessionFactory.openSession()) {
            if (get(ticket.getId()).isPresent()) {
                Transaction transaction = session.beginTransaction();
                session.merge(ticket);
                transaction.commit();
            }
        }
    }
}
