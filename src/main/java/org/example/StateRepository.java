package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class StateRepository {
    private final SessionFactory sessionFactory = Dbconfig.getSessionFactory();

    public void save(State state) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(state);
        transaction.commit();
        session.close();
    }

    public void update(Long id, State state) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        State state1 = session.get(State.class, id);
        state1.setName(state1.getName());
        state1.setPopulation(state.getPopulation());
        state1.setGovernor(state.getGovernor());
        session.update(state1);

    }

    public void deleteAll() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<?> query = session.createQuery("delete  from State s ");
        query.executeUpdate();
        transaction.commit();
        session.close();
    }
}
