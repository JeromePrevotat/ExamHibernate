package com.humanbooster.exam.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @ManyToOne
    @JoinColumn(name="utilisateur_id")
    private Utilisateur utilisateur_id;

    @ManyToOne
    @JoinColumn(name="borne_id")
    private BorneRecharge borne;

    @NotBlank
    private Date dateDebut;
    private Date dateFin;
    @NotBlank
    private StatutReservation statut = StatutReservation.EN_ATTENTE;

    public Reservation() {}
    
    public Reservation(Utilisateur utilisateur_id, BorneRecharge borne, Date dateDebut, Date dateFin, StatutReservation statut){
        this.utilisateur_id = utilisateur_id;
        this.borne = borne;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.statut = statut;
    }
    
    
    // GETTER
    public long getId() {
        return id;
    }

    public Utilisateur getUtilisateur_id() {
        return utilisateur_id;
    }

    public BorneRecharge getBorne() {
        return borne;
    }
    
    public Date getDateDebut() {
        return dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public StatutReservation getStatut() {
        return statut;
    }

    // SETTER
    public void setId(long id) {
        this.id = id;
    }

    public void setUtilisateur_id(Utilisateur utilisateur_id) {
        this.utilisateur_id = utilisateur_id;
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
        sb.append("=== Reservation ").append(this.getId()).append(" ===").append("\n")
            .append("Utilisateur: ").append(this.getUtilisateur_id()).append("\n")
            .append("Borne: ").append(this.getBorne()).append("\n")
            .append("Debut: ").append(this.getDateDebut()).append("\n")
            .append("Fin: ").append(this.getDateFin()).append("\n")
            .append("Statut: ").append(this.getStatut()).append("\n");
        return sb.toString();
    }
    
}
