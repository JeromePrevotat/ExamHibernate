package com.humanbooster.exam.dao;

import org.hibernate.SessionFactory;

import com.humanbooster.exam.model.LieuRecharge;

public class LieuRechargeDao extends GenericDaoImp<LieuRecharge, Long>{
    
    public LieuRechargeDao(SessionFactory sessionFactory){
        super(sessionFactory, LieuRecharge.class);
    }
}
