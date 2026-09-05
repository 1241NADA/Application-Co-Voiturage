/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.pck1;

import model.Exception.AdresseInvalideException;

public abstract sealed class Utilisateurs permits Passager, Conducteur {
    private String nom;
    private String email;
    private String prenom;
    private Adresse adresse;

    // Constructeur principal
    public Utilisateurs(String nom, String email, String prenom, Adresse adresse) {
        this.nom = nom;
        this.email = email;
        this.prenom = prenom;
        this.adresse = adresse;
    }

    // Constructeur vide avec valeurs par défaut
    public Utilisateurs() {
        this.nom = "Inconnu";
        this.email = "inconnu@email.com";
        this.prenom = "Inconnu";
        this.adresse = new Adresse(); // Initialisation d'une adresse par défaut
    }

    // Getters
    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    public String getPrenom() {
        return prenom;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    // Setters
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    // Méthodes communes à tous les utilisateurs
    public abstract void afficherDetails();

    public abstract String obtenirRole();

    // Méthode statique valueOf
    public static Utilisateurs valueOf(String utilisateurString) throws AdresseInvalideException {
    if (utilisateurString == null || utilisateurString.isBlank()) {
        throw new IllegalArgumentException("La chaîne d'entrée est invalide.");
    }

    String[] parts = utilisateurString.split(";");
    if (parts.length == 2) { // Format simplifié : nom;prenom
        String nom = parts[0].trim();
        String prenom = parts[1].trim();
        if (nom.isEmpty() || prenom.isEmpty()) {
            throw new IllegalArgumentException("Le nom et le prénom ne doivent pas être vides.");
        }
        return new Passager(nom, "default.email@example.com", prenom, new Adresse()); // Valeurs par défaut
    }

    if (parts.length != 5) { 
        throw new IllegalArgumentException("Format invalide. Format attendu : nom;email;prenom;adresse;role ou nom;prenom.");
    }

    // Format complet
    String nom = parts[0].trim();
    String email = parts[1].trim();
    String prenom = parts[2].trim();
    Adresse adresse = Adresse.valueOf(parts[3].trim());
    String role = parts[4].trim();

    // Créer l'utilisateur selon le rôle
    return switch (role.toLowerCase()) {
        case "passager" -> new Passager(nom, email, prenom, adresse);
        case "conducteur" -> new Conducteur(nom, email, prenom, adresse);
        default -> throw new IllegalArgumentException("Rôle invalide : " + role);
    };
}
}