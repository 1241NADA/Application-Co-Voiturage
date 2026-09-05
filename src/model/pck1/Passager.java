/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.pck1;

import model.pck2.GestionTrajet;
import model.pck2.Reservation;
import model.pck2.Trajet;

import java.util.ArrayList;
import java.util.List;

public final class Passager extends Utilisateurs {
    private List<Trajet> trajetReserves; // Changement de l'attribut

    // Constructeur principal avec paramètres
    public Passager(String nom, String email, String prenom, Adresse adresse) {
        super(nom, email, prenom, adresse);
        this.trajetReserves = new ArrayList<>();
    }

    // Constructeur vide
    public Passager() {
        super("Inconnu", "inconnu@email.com", "Inconnu", new Adresse());
        this.trajetReserves = new ArrayList<>();
    }

    // Getters et Setters
    public List<Trajet> getTrajetReserves() {
        return trajetReserves;
    }

    public void setTrajetReserves(List<Trajet> trajetReserves) {
        this.trajetReserves = trajetReserves;
    }

    // Méthode pour rechercher un trajet
    public List<Trajet> rechercherTrajet(String destination, Date date, List<GestionTrajet> trajetsDisponibles) {
        List<Trajet> trajetsTrouves = new ArrayList<>();
        for (GestionTrajet gestionTrajet : trajetsDisponibles) {
            if (gestionTrajet.getDestination().equalsIgnoreCase(destination) && gestionTrajet.getDate().estEgale(date)) {
                trajetsTrouves.add(gestionTrajet.getTrajet());
            }
        }
        return trajetsTrouves;
    }

    // Méthode pour réserver un trajet
    public void reserverTrajet(GestionTrajet gestionTrajet) {
        if (gestionTrajet != null) {
            trajetReserves.add(gestionTrajet.getTrajet());  // Ajouter directement le trajet réservé
            System.out.println("Trajet réservé avec succès : " + gestionTrajet.getTrajet().afficherDetails());
        } else {
            System.out.println("Le trajet est invalide.");
        }
    }

    // Méthode pour annuler une réservation
    public void annulerReservation(Trajet trajet) {
        if (trajetReserves.remove(trajet)) {
            System.out.println("Réservation annulée : " + trajet.afficherDetails());
        } else {
            System.out.println("Trajet non trouvé dans les réservations.");
        }
    }

    // Méthode pour afficher les réservations
    public void afficherReservations() {
        if (trajetReserves.isEmpty()) {
            System.out.println("Aucune réservation effectuée.");
        } else {
            System.out.println("Liste des trajets réservés :");
            for (Trajet trajet : trajetReserves) {
                System.out.println(trajet.afficherDetails());
            }
        }
    }

    // Getters et Setters pour nom, prénom, email, adresse
    public String getNom() {
        return super.getNom();
    }

    public void setNom(String nom) {
        super.setNom(nom);
    }

    public String getPrenom() {
        return super.getPrenom();
    }

    public void setPrenom(String prenom) {
        super.setPrenom(prenom);
    }

    public String getEmail() {
        return super.getEmail();
    }

    public void setEmail(String email) {
        super.setEmail(email);
    }

    public Adresse getAdresse() {
        return super.getAdresse();
    }

    public void setAdresse(Adresse adresse) {
        super.setAdresse(adresse);
    }

    @Override
    public void afficherDetails() {
        System.out.println("Nom: " + getNom() + ", Prénom: " + getPrenom() +
                           ", Email: " + getEmail() + ", Adresse: " + getAdresse().obtenirAdresseComplete());
    }

    @Override
    public String obtenirRole() {
        return "Passager";
    }
}
