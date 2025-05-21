package com.humanbooster.exam.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Utilisateur {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @NotBlank
    private String email;

    @NotBlank
    private String motDePasse;

    @NotBlank
    private String codeValidation;

    private boolean valide;
    
    @NotBlank
    private RoleUtilisateur role;

    public Utilisateur() {}
    
    public Utilisateur(String email, String motDePasse, String codeValidation, RoleUtilisateur role){
        this.email = email;
        this.motDePasse = motDePasse;
        this.codeValidation = codeValidation;
        this.valide = false;
        this.role = role;
    }

    // GETTER
    public long getId() {
        return this.id;
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

    public boolean isValide() {
        return this.valide;
    }

    public RoleUtilisateur getRole() {
        return this.role;
    }

    // SETTER
    public void setId(long id) {
        this.id = id;
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

    public void setValide(boolean valide) {
        this.valide = valide;
    }

    public void setRole(RoleUtilisateur role) {
        this.role = role;
    }

    // METHODS
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("=== Utilisateur ").append(this.getId()).append(" ===").append("\n")
            .append("Email: ").append(this.getEmail()).append("\n")
            .append("Valide: ").append(this.isValide()).append("\n")
            .append("Role: ").append(this.getRole()).append("\n");
        return sb.toString();
    }
    
    public void whoAmI(){
        System.out.println(this.toString());
    }
}
