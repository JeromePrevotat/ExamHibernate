package com.humanbooster.exam.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public abstract class GenericDaoImp<T, ID>{
    private final Class<T> tType;
    protected SessionFactory sessionFactory;


    public GenericDaoImp(SessionFactory sessionFactory, Class<T> tType) {
        this.sessionFactory = sessionFactory;
        this.tType = tType;
    }
    
    public void creer(T entity) {
        if (entity != null){
            try(Session session = sessionFactory.openSession()){
                session.beginTransaction();
                session.persist(entity);
                session.getTransaction().commit();
            }
        }
    }

    public void mettreAJour(T entity) {
        if (entity != null){
            try (Session session = sessionFactory.openSession()){
                session.beginTransaction();
                session.merge(entity);
                session.getTransaction().commit();
            }
        }
    }

    public T lire(ID id) {
        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            T o = session.get(tType, id);
            session.getTransaction().commit();
            if (o != null) return o;
        }
        return null;
    }

    public void supprimer(ID id) {
        Object o;
        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            o = lire(id);
            if (o != null){
                session.remove(o);
            }
            session.getTransaction().commit();
        }
    }

    public List<T> tout() {
        List<T> tList;
        try(Session session = sessionFactory.openSession()){
                session.beginTransaction();
                tList = session.createQuery("FROM " + tType.getName(), tType).list();
                session.getTransaction().commit();
            }
            return tList;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}