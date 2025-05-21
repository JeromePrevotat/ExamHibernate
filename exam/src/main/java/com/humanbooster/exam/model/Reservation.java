package com.humanbooster.exam.model;

import java.util.Date;

public class Reservation {
    private int id;
    private Utilisateur utilisateur;
    private BorneRecharge borne;
    private Date dateDebut;
    private Date dateFin;
    private StatutReservation statut = StatutReservation.EN_ATTENTE;

    public Reservation() {}
    
    public Reservation(int id, Utilisateur utilisateur, BorneRecharge borne, Date dateDebut, Date dateFin, StatutReservation statut){
        this.id = id;
        this.utilisateur = utilisateur;
        this.borne = borne;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.statut = statut;
    }

    // GETTER
    public int getId() {
        return this.id;
    }

    public Utilisateur getUtilisateur() {
        return this.utilisateur;
    }

    public BorneRecharge getBorne() {
        return this.borne;
    }

    public Date getDateDebut() {
        return this.dateDebut;
    }

    public Date getDateFin() {
        return this.dateFin;
    }

    public StatutReservation getStatut() {
        return this.statut;
    }
    
    // SETTER
    public void setId(int id) {
        this.id = id;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public void setBorne(BorneRecharge borne) {
        this.borne = borne;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public void setStatut(StatutReservation statut) {
        this.statut = statut;
    }
    
    // METHODS
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("=== Reservation ").append(this.id).append(" ===").append("\n")
            .append("Utilisateur: ").append(this.utilisateur).append("\n")
            .append("Borne: ").append(this.borne).append("\n")
            .append("Debut: ").append(this.dateDebut).append("\n")
            .append("Fin: ").append(this.dateFin).append("\n")
            .append("Statut: ").append(this.statut).append("\n");
        return sb.toString();
    }

    

    
}
