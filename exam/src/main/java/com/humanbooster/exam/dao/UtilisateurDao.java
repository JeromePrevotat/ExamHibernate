package com.humanbooster.exam.dao;

import org.hibernate.SessionFactory;

import com.humanbooster.exam.model.Utilisateur;

public class UtilisateurDao extends GenericDaoImp<Utilisateur, Long>{
    
    public UtilisateurDao(SessionFactory sessionFactory){
        super(sessionFactory, Utilisateur.class);
    }
}