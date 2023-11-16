package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class RegionRepository {
    private final SessionFactory sessionFactory = Dbconfig.getSessionFactory();

    public void save(Region region) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(region);
        transaction.commit();
        session.close();
    }

    public Region findById(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Region region = session.get(Region.class, id);
        session.close();
        return region;
    }

    public List<Region> findAll() {
        Session session = sessionFactory.openSession();
        Query<Region> query = session.createQuery("select r from Region r ");
        List<Region> list = query.getResultList();
        session.close();
        return list;
    }

    public void deleteById(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Region region = session.get(Region.class, id);
        session.delete(region);
        transaction.commit();
        session.close();
    }
}
