package com.humanbooster.exam.dao;

import org.hibernate.SessionFactory;

import com.humanbooster.exam.model.Reservation;

public class ReservationDao extends GenericDaoImp<Reservation, Long>{
    public ReservationDao(SessionFactory sessionFactory){
        super(sessionFactory, Reservation.class);
    }
}
