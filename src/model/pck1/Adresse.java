/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.pck1;

import model.Exception.AdresseInvalideException;  // Importer l'exception personnalisée

public class Adresse {
    private String rue;
    private String ville;
    private int codePostale;

    // Constructeur avec validation
    public Adresse(String rue, String ville, int codePostale) throws AdresseInvalideException {
        if (rue == null || rue.trim().isEmpty()) {
            throw new AdresseInvalideException("La rue ne peut pas être vide.");
        }
        if (ville == null || ville.trim().isEmpty()) {
            throw new AdresseInvalideException("La ville ne peut pas être vide.");
        }
        if (codePostale <= 0) {
            throw new AdresseInvalideException("Le code postal doit être positif.");
        }

        this.rue = rue;
        this.ville = ville;
        this.codePostale = codePostale;
    }

    // Constructeur vide avec valeurs par défaut
    public Adresse() {
        this.rue = "Inconnue";
        this.ville = "Inconnue";
        this.codePostale = 0;
    }

    // Méthode pour obtenir l'adresse complète
    public String obtenirAdresseComplete() {
        return rue + ", " + ville + " - " + codePostale;
    }

    // Méthode pour afficher l'adresse
    public void afficherAdresse() {
        System.out.println(obtenirAdresseComplete());
    }

    // Getters
    public String getRue() {
        return rue;
    }

    public String getVille() {
        return ville;
    }

    public int getCodePostale() {
        return codePostale;
    }

    // Setters
    public void setRue(String rue) throws AdresseInvalideException {
        if (rue == null || rue.trim().isEmpty()) {
            throw new AdresseInvalideException("La rue ne peut pas être vide.");
        }
        this.rue = rue;
    }

    public void setVille(String ville) throws AdresseInvalideException {
        if (ville == null || ville.trim().isEmpty()) {
            throw new AdresseInvalideException("La ville ne peut pas être vide.");
        }
        this.ville = ville;
    }

    public void setCodePostale(int codePostale) throws AdresseInvalideException {
        if (codePostale <= 0) {
            throw new AdresseInvalideException("Le code postal doit être positif.");
        }
        this.codePostale = codePostale;
    }

    // Méthode valueOf : conversion d'une chaîne en instance d'Adresse
    public static Adresse valueOf(String adresseString) throws AdresseInvalideException {
        if (adresseString == null || adresseString.trim().isEmpty()) {
            throw new AdresseInvalideException("L'adresse ne peut pas être vide.");
        }

        String[] parts = adresseString.split(",\\s*|\\s*-\\s*"); // Séparation par ", " ou " - "
        if (parts.length != 3) {
            throw new AdresseInvalideException("Le format de l'adresse est incorrect. Attendu : 'rue, ville - codePostale'.");
        }

        String rue = parts[0].trim();
        String ville = parts[1].trim();
        int codePostale;
        try {
            codePostale = Integer.parseInt(parts[2].trim());
        } catch (NumberFormatException e) {
            throw new AdresseInvalideException("Le code postal doit être un entier valide.");
        }

        return new Adresse(rue, ville, codePostale);
    }
}




    

