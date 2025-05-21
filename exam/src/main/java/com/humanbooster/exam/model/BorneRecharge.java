package com.humanbooster.exam.model;

public class BorneRecharge {
    private static int idTotal = 0;
    private int id;
    private EtatBorne etat;
    private double tarifHoraire;

    public BorneRecharge() { idTotal++; }

    public BorneRecharge(double tarifHoraire){
        this.id = idTotal;
        this.etat = EtatBorne.DISPONIBLE;
        this.tarifHoraire = tarifHoraire;
        idTotal++;
    }

    // GETTER
    public int getId() {
        return this.id;
    }

    public EtatBorne getEtat() {
        return this.etat;
    }

    public double getTarifHoraire() {
        return this.tarifHoraire;
    }
    
    // SETTER
    public void setId(int id) {
        this.id = id;
    }

    public void setEtat(EtatBorne etat) {
        this.etat = etat;
    }

    public void setTarifHoraire(double tarifHoraire) {
        this.tarifHoraire = tarifHoraire;
    }

    // METHODS
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("=== Borne ").append(this.id).append(" ===").append("\n")
            .append("Etat: ").append(this.etat).append("\n")
            .append("Tarif Horaire: ").append(this.tarifHoraire).append("\n");
        return sb.toString();
    }

    

    
}
