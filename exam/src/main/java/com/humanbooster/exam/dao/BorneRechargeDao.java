package com.humanbooster.exam.dao;

import org.hibernate.SessionFactory;

import com.humanbooster.exam.model.BorneRecharge;

public class BorneRechargeDao extends GenericDaoImp<BorneRecharge, Long>{
    public BorneRechargeDao(SessionFactory sessionFactory){
        super(sessionFactory, BorneRecharge.class);
    }
}
