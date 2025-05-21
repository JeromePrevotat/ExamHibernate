package com.humanbooster.exam.model;

import java.util.Scanner;

public class Utilisateur {
    private static int idTotal = 0;
    private final Scanner scan = new Scanner(System.in);
    private int id;
    private String username;
    private String email;
    private String motDePasse;
    private String codeValidation;
    private boolean estValide;
    private boolean isLogged;

    public Utilisateur() { idTotal++; }
    
    public Utilisateur(String username, String email, String motDePasse, String codeValidation){
        this.id = idTotal;
        this.username = username;
        this.email = email;
        this.motDePasse = motDePasse;
        this.codeValidation = codeValidation;
        this.estValide = false;
        this.isLogged = false;
        idTotal++;
    }

    // GETTER
    public int getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public String getEmail() {
        return this.email;
    }

    public String getMotDePasse() {
        return this.motDePasse;
    }

    public String getCodeValidation() {
        return this.codeValidation;
    }

    public boolean isEstValide() {
        return this.estValide;
    }

    public boolean isLogged() {
        return this.isLogged;
    }

    // SETTER
    public void setId(int id) {
        this.id = id;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public void setCodeValidation(String codeValidation) {
        this.codeValidation = codeValidation;
    }

    public void setEstValide(boolean estValide) {
        this.estValide = estValide;
    }

    public void setLogged(boolean isLogged) {
        this.isLogged = isLogged;
    }

    // METHODS
    

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("=== Utilisateur ").append(this.id).append(" ===").append("\n")
            .append("Username: ").append(this.username).append("\n")
            .append("Email: ").append(this.email).append("\n");
        return sb.toString();
    }
    
    public void whoAmI(){
        System.out.println(this.toString());
    }
}
