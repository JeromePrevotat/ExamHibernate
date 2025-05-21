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
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

@Entity
public class LieuRecharge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String nom;

    @NotBlank
    private String adresse; //Class ?

    @OneToMany(targetEntity=BorneRecharge.class, mappedBy="borne_id", cascade=CascadeType.ALL, orphanRemoval=true, fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<BorneRecharge> bornes;


    public LieuRecharge() {}

    public LieuRecharge(String nom, String adresse, List<BorneRecharge> bornes){
        this.nom = nom;
        this.adresse = adresse;
        this.bornes = bornes;
    }

    // GETTER
    public long getId() {
        return this.id;
    }

    public String getNom() {
        return this.nom;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public List<BorneRecharge> getBornes() {
        return this.bornes;
    }

    // SETTER
    public void setId(long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setBornes(List<BorneRecharge> bornes) {
        this.bornes = bornes;
    }

    // METHODS
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("=== Lieu de Recharge ").append(this.getId()).append(" ===").append("\n")
            .append("Nom: ").append(this.getNom()).append("\n")
            .append("Adresse: ").append(this.getAdresse()).append("\n")
            .append("Bornes: ").append(
                (this.getBornes() == null) ? null : this.getBornes().toString()
            ).append("\n");
        return sb.toString();
    }

}
