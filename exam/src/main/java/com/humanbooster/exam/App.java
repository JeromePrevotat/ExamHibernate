package com.humanbooster.exam;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.humanbooster.exam.dao.UtilisateurDao;
import com.humanbooster.exam.model.BorneRecharge;
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
        LieuRecharge lieu0 = new LieuRecharge("HB", "222 Boulevard Gustave Flaubert", null);
        LieuRecharge lieu1 = new LieuRecharge("Jaude", "Centre Jaude", null);

        // Bornes
        BorneRecharge borneTmp;
        BorneRecharge borne0 = new BorneRecharge(1);
        borne0.setLieu_id(lieu0);
        BorneRecharge borne1 = new BorneRecharge(3);
        borne1.setLieu_id(lieu1);
        BorneRecharge borne2 = new BorneRecharge(2);
        borne2.setLieu_id(lieu0);

        // Reservations
        Reservation reservationTmp;
        Reservation reservation0 = new Reservation(utilisateur1, borne0, Date.from(Instant.now()), Date.from(Instant.now().plusSeconds(3600 * 2)), StatutReservation.EN_ATTENTE);
        Reservation reservation1 = new Reservation(utilisateur1, borne1, Date.from(Instant.now().plusSeconds(3600 * 3)), Date.from(Instant.now().plusSeconds(3600 * 7)), StatutReservation.EN_ATTENTE);

        // CREER
        utilisateurDao.creer(utilisateurAdmin);
        utilisateurDao.creer(utilisateur0);
        utilisateurDao.creer(utilisateur1);
        // LIRE
        utilisateurTmp = utilisateurDao.lire(utilisateur0.getId());
        System.out.println("LIRE TEST: " + utilisateurTmp.toString());
        // METTRE A JOUR
        utilisateur0.setEmail("bobibob@mail.com");
        utilisateurDao.mettreAJour(utilisateur0);
        utilisateurTmp = utilisateurDao.lire(utilisateur0.getId());
        System.out.println("METTRE A JOUR TEST: " + utilisateurTmp.toString());
        // SUPPRIMER
        utilisateurDao.supprimer(utilisateur0.getId());
        // LIRE TOUS
        utilisateurList = utilisateurDao.tout();
        for (Utilisateur u : utilisateurList) System.out.println(u.toString());

    }
}
