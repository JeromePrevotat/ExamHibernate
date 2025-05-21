package com.humanbooster.exam.model;

import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

@Entity
public class BorneRecharge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @NotBlank
    private EtatBorne etat;
    
    @NotBlank
    private double tarifHoraire;
    
    @ManyToOne
    @JoinColumn(name="lieu_id")
    private LieuRecharge lieu_id;

    @OneToMany(targetEntity=Reservation.class, mappedBy="borne", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Reservation> reservations;

    public BorneRecharge() {}

    public BorneRecharge(double tarifHoraire){
        this.etat = EtatBorne.DISPONIBLE;
        this.tarifHoraire = tarifHoraire;
    }

    // GETTER
    public long getId() {
        return this.id;
    }

    public EtatBorne getEtat() {
        return this.etat;
    }

    public double getTarifHoraire() {
        return this.tarifHoraire;
    }
    
    public LieuRecharge getLieu_id() {
        return lieu_id;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    // SETTER
    public void setId(long id) {
        this.id = id;
    }

    public void setEtat(EtatBorne etat) {
        this.etat = etat;
    }

    public void setTarifHoraire(double tarifHoraire) {
        this.tarifHoraire = tarifHoraire;
    }

    public void setLieu_id(LieuRecharge lieu_id) {
        this.lieu_id = lieu_id;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    // METHODS
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("=== Borne ").append(this.getId()).append(" ===").append("\n")
            .append("Etat: ").append(this.getEtat()).append("\n")
            .append("Tarif Horaire: ").append(this.getTarifHoraire()).append("\n");
        return sb.toString();
    }
    
}
