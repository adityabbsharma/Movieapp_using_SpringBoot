package com.upgrad.movieapp.dao;

import com.upgrad.movieapp.entities.City;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManagerFactory;

@Repository
public class CityDaoImpl implements CityDaoWithoutJPA{
    private SessionFactory sessionFactory;
    @Autowired
    public CityDaoImpl(EntityManagerFactory entityManagerFactory){
        this.sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
    }
    @Override
    public City save(City city) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(city);
        transaction.commit();
        session.close();
        return city;
    }

    @Override
    public City findByCityId(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        City city = session.get(City.class,id);
        transaction.commit();;
        session.close();;
        return city;
    }

    @Override
    public City update(City city) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(city);
        transaction.commit();
        session.close();
        return city;
    }

    @Override
    public void delete(City city) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        City mergedCity = (City)session.merge(city);
        session.delete(mergedCity);
        transaction.commit();
        session.close();
    }
}
