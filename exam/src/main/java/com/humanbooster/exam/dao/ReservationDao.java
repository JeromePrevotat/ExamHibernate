package com.humanbooster.exam.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.humanbooster.exam.model.Reservation;

public class ReservationDao extends GenericDaoImp<Reservation, Long>{
    public ReservationDao(SessionFactory sessionFactory){
        super(sessionFactory, Reservation.class);
    }

    // Lister toutes les réservations faites par un utilisateur donné, triées par date.
    public List<Reservation> chercherReservationTriParDate(long id){
        try(Session session = sessionFactory.openSession()){
            String hql = "FROM Reservation r WHERE r.utilisateur_id = :id ORDER BY dateDebut ASC";
            return session.createQuery(hql, Reservation.class)
                            .setParameter("id", id)
                            .getResultList();
        }
    }
}
