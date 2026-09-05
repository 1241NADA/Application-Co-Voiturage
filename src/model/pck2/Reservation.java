/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.pck2;

import model.pck1.Date;
import model.pck1.Passager;
import java.util.ArrayList;

public class Reservation {
    private GestionTrajet trajet;
    private Date dateReservation;
    private String statut;
    private Passager passager;

    private static ArrayList<Reservation> reservations = new ArrayList<>(); // Liste statique pour stocker les réservations

    // Constructeur principal
    public Reservation(GestionTrajet trajet, Passager passager) {
        this.trajet = trajet;
        this.dateReservation = new Date(22, 11, 2024); // Initialisation par défaut à la date actuelle
        this.statut = "en attente"; // Statut initial
        this.passager = passager;
        reservations.add(this); // Ajouter la réservation à la liste dès sa création
    }

    // Constructeur vide avec valeurs par défaut
    public Reservation() {
        this.trajet = null; // Valeur par défaut pour le trajet
        this.dateReservation = new Date(1, 1, 2000); // Valeur par défaut pour la date
        this.statut = "en attente"; // Valeur par défaut pour le statut
        this.passager = null; // Valeur par défaut pour le passager
    }

    // Méthode pour afficher les réservations
    public static void afficherToutesLesReservations() {
        for (Reservation reservation : reservations) {
            System.out.println(reservation.afficherDetailsReservation());
        }
    }

    // Méthode pour confirmer la réservation
    public void confirmerReservation() {
        if (!"confirmée".equals(statut)) {
            this.statut = "confirmée";
            System.out.println("Réservation confirmée.");
        } else {
            System.out.println("Réservation déjà confirmée.");
        }
    }

    // Méthode pour annuler la réservation
    public void annulerReservation() {
        if (!"annulée".equals(statut)) {
            this.statut = "annulée";
            System.out.println("Réservation annulée.");
        } else {
            System.out.println("Réservation déjà annulée.");
        }
    }

    // Getter et Setter pour la destination du trajet
    public String getDestinationTrajet() {
        return trajet != null ? trajet.getDestination() : "Destination inconnue";
    }

    public void setDestinationTrajet(String destination) {
        if (trajet != null) {
            trajet.setDestination(destination);
        }
    }

    // Getter et Setter pour le nom du passager
    public String getNomPassager() {
        return passager != null ? passager.getNom() : "Nom inconnu";
    }

    public void setNomPassager(String nom) {
        if (passager != null) {
            passager.setNom(nom);
        }
    }

    // Méthode pour afficher les détails de la réservation
    public String afficherDetailsReservation() {
        return "Réservation:\n" +
               "Trajet: " + getDestinationTrajet() + "\n" +
               "Date de Réservation: " + dateReservation.obtenirDateComplete() + "\n" +
               "Statut: " + statut + "\n" +
               "Passager: " + getNomPassager() + " " + passager.getPrenom();
    }

    // Getters et setters pour les autres attributs
    public Date getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(Date dateReservation) {
        this.dateReservation = dateReservation;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }
}
