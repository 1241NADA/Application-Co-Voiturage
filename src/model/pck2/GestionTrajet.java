/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.pck2;

import model.pck1.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GestionTrajet {
    private List<Trajet> trajets; // Liste des trajets
    private String destination; // Destination du trajet
    private Date date; // Date du trajet
    private Trajet trajet; // Un trajet spécifique

    // Constructeur avec paramètres
    public GestionTrajet(String destination, Date date, Trajet trajet) {
        this.destination = destination;
        this.date = date;
        this.trajet = trajet;
        this.trajets = new ArrayList<>();
    }

    // Constructeur vide avec initialisation par défaut
    public GestionTrajet() {
        this.destination = "Destination inconnue";
        this.date = new Date(1, 1, 2000); // Date par défaut
        this.trajet = null; // Pas de trajet par défaut
        this.trajets = new ArrayList<>();
    }

    // Getter pour destination
    public String getDestination() {
        return destination;
    }

    // Setter pour destination
    public void setDestination(String destination) {
        this.destination = destination;
    }

    // Getter pour date
    public Date getDate() {
        return date;
    }

    // Setter pour date
    public void setDate(Date date) {
        this.date = date;
    }

    // Getter pour trajet
    public Trajet getTrajet() {
        return trajet;
    }

    // Setter pour trajet
    public void setTrajet(Trajet trajet) {
        this.trajet = trajet;
    }

    // Getter pour trajets
    public List<Trajet> getTrajets() {
        return trajets;
    }

    // Setter pour trajets
    public void setTrajets(List<Trajet> trajets) {
        this.trajets = trajets;
    }

    // Ajouter un trajet
    public void ajouterTrajet(Trajet trajet) {
        trajets.add(trajet);
    }

    // Rechercher un trajet par destination et date
    public List<Trajet> rechercherTrajet(String destination, Date date) {
        return trajets.stream()
            .filter(t -> t.getDestination().equals(destination) && t.getDate().estEgale(date))
            .collect(Collectors.toList());
    }

    // Trier les trajets par nombre de places disponibles
    public List<Trajet> trierParNombreDePlaces() {
        return trajets.stream()
            .sorted((t1, t2) -> Integer.compare(t1.getPlacesDisponibles(), t2.getPlacesDisponibles()))
            .collect(Collectors.toList());
    }

    // Afficher tous les trajets
    public void afficherTousLesTrajets() {
        if (trajets.isEmpty()) {
            System.out.println("Aucun trajet disponible.");
        } else {
            for (Trajet trajet : trajets) {
                System.out.println(trajet.afficherDetails());
            }
        }
    }
}
