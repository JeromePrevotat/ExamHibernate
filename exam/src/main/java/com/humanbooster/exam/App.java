package com.humanbooster.exam;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.humanbooster.exam.dao.BorneRechargeDao;
import com.humanbooster.exam.dao.LieuRechargeDao;
import com.humanbooster.exam.dao.ReservationDao;
import com.humanbooster.exam.dao.UtilisateurDao;
import com.humanbooster.exam.model.BorneRecharge;
import com.humanbooster.exam.model.EtatBorne;
import com.humanbooster.exam.model.LieuRecharge;
import com.humanbooster.exam.model.Reservation;
import com.humanbooster.exam.model.RoleUtilisateur;
import com.humanbooster.exam.model.StatutReservation;
import com.humanbooster.exam.model.Utilisateur;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        // App Init
        System.out.println("Démarrage de l'application");
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure()
            .build();
        Metadata metadata = new MetadataSources(registry).buildMetadata();
        SessionFactory sessionFactory = metadata.buildSessionFactory();
        System.out.println("Connexion réussie !");
        
        UtilisateurDao utilisateurDao = new UtilisateurDao(sessionFactory);
        LieuRechargeDao lieuDao = new LieuRechargeDao(sessionFactory);
        BorneRechargeDao borneDao = new BorneRechargeDao(sessionFactory);
        ReservationDao reservationDao = new ReservationDao(sessionFactory);
        List<Utilisateur> utilisateurList;
        List<LieuRecharge> lieuList;
        List<BorneRecharge> borneList;
        List<Reservation> reservationList;
        
        // Utilisateurs
        Utilisateur utilisateurTmp;
        Utilisateur utilisateurAdmin = new Utilisateur("admin@mail.com", "admin", "0000", RoleUtilisateur.ADMIN);
        Utilisateur utilisateur0 = new Utilisateur("bob@mail.com", "password", "0001", RoleUtilisateur.REGISTERED);
        Utilisateur utilisateur1 = new Utilisateur("alice@mail.com", "password", "0002", RoleUtilisateur.GUEST);
        
        // Lieux
        LieuRecharge lieuTmp;
        LieuRecharge lieu0 = new LieuRecharge("HB", "222 Boulevard Gustave Flaubert", new ArrayList<>());
        LieuRecharge lieu1 = new LieuRecharge("Jaude", "Centre Jaude", new ArrayList<>());
        LieuRecharge lieu2 = new LieuRecharge("Gaillard", "Place Gaillard", new ArrayList<>());

        // Bornes
        BorneRecharge borneTmp;
        BorneRecharge borne0 = new BorneRecharge(1);
        BorneRecharge borne1 = new BorneRecharge(3);
        BorneRecharge borne2 = new BorneRecharge(2);
        BorneRecharge borne3 = new BorneRecharge(10);

        // Reservations
        Reservation reservationTmp;
        Reservation reservation0 = new Reservation(utilisateur1, borne0, Date.from(Instant.now()), Date.from(Instant.now().plusSeconds(3600 * 2)), StatutReservation.EN_ATTENTE);
        Reservation reservation1 = new Reservation(utilisateur1, borne1, Date.from(Instant.now().plusSeconds(3600 * 3)), Date.from(Instant.now().plusSeconds(3600 * 7)), StatutReservation.EN_ATTENTE);
        Reservation reservation2 = new Reservation(utilisateur1, borne1, Date.from(Instant.now().plusSeconds(3600 * 3)), Date.from(Instant.now().plusSeconds(3600 * 7)), StatutReservation.REFUSEE);

        // CREER
        System.out.println("===== CREATION UTILISATEUR =====\n");
        utilisateurDao.creer(utilisateurAdmin);
        utilisateurDao.creer(utilisateur0);
        utilisateurDao.creer(utilisateur1);
        System.out.println("===== CREATION LIEUX RECHARGE =====\n");
        lieuDao.creer(lieu0);
        lieuDao.creer(lieu1);
        lieuDao.creer(lieu2);
        System.out.println("===== CREATION BORNES RECHARGE =====\n");
        // AVOIDING DETACHED ENTITIES
        borne0.setLieu_id(lieu0);
        borne2.setLieu_id(lieu0);
        lieu0.getBornes().add(borne0);
        lieu0.getBornes().add(borne2);
        borne1.setLieu_id(lieu1);
        lieu1.getBornes().add(borne1);
        borne3.setLieu_id(lieu2);
        lieu2.getBornes().add(borne3);
        // CREATE
        borneDao.creer(borne0);
        borneDao.creer(borne1);
        borneDao.creer(borne2);
        borneDao.creer(borne3);
        System.out.println("===== CREATION RESERVATIONS =====\n");
        reservationDao.creer(reservation0);
        reservationDao.creer(reservation1);
        reservationDao.creer(reservation2);

        // LIRE
        utilisateurTmp = utilisateurDao.lire(utilisateur0.getId());
        System.out.println("LIRE UTILISATEUR TEST: " + utilisateurTmp.toString());
        lieuTmp = lieuDao.lire(lieu0.getId());
        System.out.println("LIRE LIEU TEST: " + lieuTmp.toString());
        borneTmp = borneDao.lire(borne0.getId());
        System.out.println("LIRE BORNE TEST: " + borneTmp.toString());
        reservationTmp = reservationDao.lire(reservation0.getId());
        System.out.println("LIRE RESERVATION TEST: " + reservationTmp.toString());

        // METTRE A JOUR
        // UPDATE UTILISATEUR
        utilisateur0.setEmail("bobibob@mail.com");
        utilisateurDao.mettreAJour(utilisateur0);
        utilisateurTmp = utilisateurDao.lire(utilisateur0.getId());
        System.out.println("METTRE A JOUR UTILISATEUR TEST: " + utilisateurTmp.toString());
        
        // UPDATE LIEU
        lieu0.setAdresse(lieu0.getAdresse() + " 63000 Clermont-Ferrand");
        lieuDao.mettreAJour(lieu0);
        lieuTmp = lieuDao.lire(lieu0.getId());
        System.out.println("METTRE A JOUR LIEU TEST: " + lieuTmp.toString());
        
        // UPDATE BORNE
        borne0.setEtat(EtatBorne.RESERVEE);
        borneDao.mettreAJour(borne0);
        borneTmp = borneDao.lire(borne0.getId());
        System.out.println("METTRE A JOUR BORNE TEST: " + borneTmp.toString());

        // UPDATE RESERVATION
        reservation0.setStatut(StatutReservation.ACCEPTEE);
        reservationDao.mettreAJour(reservation0);
        reservationTmp = reservationDao.lire(reservation0.getId());
        System.out.println("METTRE A JOUR RESERVATION TEST: " + reservationTmp.toString());
        

        // SUPPRIMER
        utilisateurDao.supprimer(utilisateur0.getId());
        lieuDao.supprimer(lieu2.getId());
        borneDao.supprimer(borne3.getId());
        reservationDao.supprimer(reservation2.getId());

        // LIRE TOUS
        System.out.println("LIRE TOUS LES UTILISATEURS:\n");
        utilisateurList = utilisateurDao.tout();
        for (Utilisateur u : utilisateurList) System.out.println(u.toString());
        System.out.println("LIRE TOUS LES LIEUX:\n");
        lieuList = lieuDao.tout();
        for (LieuRecharge l : lieuList) System.out.println(l.toString());
        System.out.println("LIRE TOUTES LES BORNES:\n");
        borneList = borneDao.tout();
        for (BorneRecharge b : borneList) System.out.println(b.toString());
        System.out.println("LIRE TOUTES LES RESERVATIONS:\n");
        reservationList = reservationDao.tout();
        for (Reservation r : reservationList) System.out.println(r.toString());
    }
}
