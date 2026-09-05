/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.pck1;

import model.Exception.DateInvalideException;

public class Date {
    private int jour;
    private int mois;
    private int annee;

    // Constructeur qui initialise la date avec jour, mois, et année
    public Date(int jour, int mois, int annee) {
        this.jour = jour;
        this.mois = mois;
        this.annee = annee;
    }

    // Méthode pour créer une date après validation
    public static Date creerDate(int jour, int mois, int annee) {
        try {
            // Validation du mois
            if (mois < 1 || mois > 12) {
                throw new DateInvalideException("Mois invalide : " + mois + ". Il doit être entre 1 et 12.");
            }
           
            // Validation de l'année
            if (annee < 0) {
                throw new DateInvalideException("L'année ne peut pas être négative.");
            }
           
            // Validation du jour selon le mois et l'année
            if (!estJourValide(jour, mois, annee)) {
                throw new DateInvalideException("Jour invalide : " + jour + " pour le mois " + mois + " de l'année " + annee);
            }

            // Si la date est valide, création et retour de l'objet Date
            return new Date(jour, mois, annee);
        } catch (DateInvalideException e) {
            // Gestion de l'exception, affichage du message d'erreur
            System.out.println("Erreur : " + e.getMessage());
            return null;  // Retourne null si la date est invalide
        }
    }

    // Méthode pour vérifier si le jour est valide pour un mois et une année donnés
    private static boolean estJourValide(int jour, int mois, int annee) {
        // Nombre de jours par mois (indexé de 0 à 11 pour janvier à décembre)
        int[] joursParMois = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
       
        // Si l'année est bissextile, on ajuste le nombre de jours de février
        if (mois == 2 && estBissextile(annee)) {
            joursParMois[1] = 29; // Février a 29 jours en année bissextile
        }

        // Vérification si le jour est dans les limites du mois
        return jour >= 1 && jour <= joursParMois[mois - 1];
    }

    // Méthode pour vérifier si une année est bissextile
    private static boolean estBissextile(int annee) {
        return (annee % 4 == 0 && (annee % 100 != 0 || annee % 400 == 0));
    }

    // Méthode pour afficher la date complète
    public void afficherDate() {
        System.out.println(this.jour + "/" + this.mois + "/" + this.annee);
    }

    // Retourne la date complète sous forme de chaîne
    public String obtenirDateComplete() {
        return this.jour + "/" + this.mois + "/" + this.annee;
    }

    // Méthode pour comparer si deux dates sont égales
    public boolean estEgale(Date autreDate) {
        if (autreDate == null) {
            return false;
        }
        return this.jour == autreDate.jour &&
               this.mois == autreDate.mois &&
               this.annee == autreDate.annee;
    }

    // Getter pour l'objet Date
    public Date getDate() {
        return new Date(this.jour, this.mois, this.annee);
    }

    // Setter pour l'objet Date
    public void setDate(Date date) {
        if (date != null) {
            this.jour = date.jour;
            this.mois = date.mois;
            this.annee = date.annee;
        }
    }
    
    public static Date valueOf(String dateString) {
    String[] parts = dateString.split("/"); // Divise la chaîne par "/"
    if (parts.length != 3) {
        throw new IllegalArgumentException("Format de date invalide. Utilisez JJ/MM/AAAA.");
    }
    int jour = Integer.parseInt(parts[0]);
    int mois = Integer.parseInt(parts[1]);
    int annee = Integer.parseInt(parts[2]);
    return creerDate(jour, mois, annee); // Utilise la méthode existante pour valider et créer une date
}

}
