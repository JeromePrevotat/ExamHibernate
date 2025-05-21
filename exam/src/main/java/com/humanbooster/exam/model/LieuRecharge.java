package com.humanbooster.exam.model;

import java.util.List;

public class LieuRecharge {
    private static int idTotal = 0;
    private int id;
    private String nom;
    private String adresse; //Class ?
    private List<BorneRecharge> bornes;


    public LieuRecharge() { idTotal++; }

    public LieuRecharge(String nom, String adresse, List<BorneRecharge> bornes){
        this.id = idTotal;
        this.nom = nom;
        this.adresse = adresse;
        this.bornes = bornes;
        idTotal++;
    }

    // GETTER
    public int getId() {
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
    public void setId(int id) {
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
        sb.append("=== Lieu de Recharge ").append(this.id).append(" ===").append("\n")
            .append("Nom: ").append(this.nom).append("\n")
            .append("Adresse: ").append(this.adresse).append("\n")
            .append("Bornes: ").append(
                (this.bornes == null) ? null : this.bornes.toString()
            ).append("\n");
        return sb.toString();
    }

}
