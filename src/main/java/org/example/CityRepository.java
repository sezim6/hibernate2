package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class CityRepository {
    private  final SessionFactory sessionFactory = Dbconfig.getSessionFactory();
    public  void save (City city){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(city);
        transaction.commit();
        session.close();
    }
    public  City findById(Long id){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        City city = session.get(City.class, id);
        session.close();
        return city;
    }
    public List<City> findAll(){
        Session session = sessionFactory.openSession();
        Query<City > query= session.createQuery("select c from City c");
        List<City >list= query.getResultList();
        session.close();
        return list;
    }
    public void update(Long id,City city){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        City city1 = session.get(City.class, id);
        city1.setName(city1.getName());
        city1.setPopulation(city1.getPopulation());
        session.update(city1);
        System.out.println("updated!");
        transaction.commit();
        session.close();
    }
    public  void deleteById(Long id){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        City city = session.get(City.class, id);
        session.delete(city);
        transaction.commit();
        session.close();
    }
    public  void deleteAll(){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query <?>query = session.createQuery("delete  from City c");
        query.executeUpdate();
        transaction.commit();
        session.close();
    }
}
