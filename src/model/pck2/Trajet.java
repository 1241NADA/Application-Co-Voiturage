/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.pck2;

import model.pck1.Date;
import model.pck1.Conducteur;

// Classe abstraite scellée
public abstract sealed class Trajet permits TrajetCourt, TrajetLong {
    private String pointDepart;
    private String destination;
    private Date date;
    private String heure;
    private int placesDisponibles;
    private Conducteur conducteur; // Utilisation de la classe Conducteur

    // Constructeur principal
    public Trajet(String pointDepart, String destination, Date date, String heure, int placesDisponibles, Conducteur conducteur) {
        if (placesDisponibles < 0) {
            throw new IllegalArgumentException("Le nombre de places disponibles ne peut pas être négatif.");
        }
        this.pointDepart = pointDepart;
        this.destination = destination;
        this.date = date;
        this.heure = heure;
        this.placesDisponibles = placesDisponibles;
        this.conducteur = conducteur;
    }
    
    // Constructeur à partir d'une chaîne de description
public Trajet(String trajet) {
    Trajet parsedTrajet = valueOf(trajet);
    this.pointDepart = parsedTrajet.pointDepart;
    this.destination = parsedTrajet.destination;
    this.date = parsedTrajet.date;
    this.heure = parsedTrajet.heure;
    this.placesDisponibles = parsedTrajet.placesDisponibles;
    this.conducteur = parsedTrajet.conducteur;
}


    // Constructeur vide avec valeurs par défaut
    public Trajet() {
        this.pointDepart = "Inconnu";
        this.destination = "Inconnu";
        this.date = new Date(1, 1, 2000);
        this.heure = "00:00";
        this.placesDisponibles = 0;
        this.conducteur = new Conducteur("Inconnu");
    }

    // Getters
    public String getPointDepart() {
        return pointDepart;
    }

    public String getDestination() {
        return destination;
    }

    public Date getDate() {
        return date;
    }

    public String getHeure() {
        return heure;
    }

    public int getPlacesDisponibles() {
        return placesDisponibles;
    }

    // Retourner uniquement le nom du conducteur
    public String getNomConducteur() {
        return conducteur.getNom();
    }

    // Setters
    public void setPointDepart(String pointDepart) {
        this.pointDepart = pointDepart;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public void setPlacesDisponibles(int placesDisponibles) {
        if (placesDisponibles < 0) {
            throw new IllegalArgumentException("Le nombre de places disponibles ne peut pas être négatif.");
        }
        this.placesDisponibles = placesDisponibles;
    }

    // Permet de mettre à jour le conducteur uniquement via son nom
    public void setNomConducteur(String nomConducteur) {
        if (this.conducteur == null) {
            this.conducteur = new Conducteur(nomConducteur);
        } else {
            this.conducteur.setNom(nomConducteur);
        }
    }

    // Méthode d'affichage des détails du trajet
    public String afficherDetails() {
        return "Trajet de " + pointDepart + " à " + destination + " le " + date.obtenirDateComplete() + " à " + heure +
               ", places disponibles : " + placesDisponibles + ", Conducteur : " + getNomConducteur();
    }
    
    
    
    
    
    //valueOf
    public static Trajet valueOf(String trajetString) {
    if (trajetString == null || trajetString.trim().isEmpty()) {
        throw new IllegalArgumentException("La chaîne de trajet ne peut pas être vide.");
    }

    try {
        // Découper la chaîne en éléments individuels
        String[] parts = trajetString.split(",");
        if (parts.length < 6) {
            throw new IllegalArgumentException("Le format de la chaîne de trajet est invalide.");
        }

        // Extraire et nettoyer les valeurs communes
        String pointDepart = parts[0].trim();
        String destination = parts[1].trim();
        String dateString = parts[2].trim();
        String heure = parts[3].trim();
        int placesDisponibles = Integer.parseInt(parts[4].trim());
        String nomConducteur = parts[5].trim();

        // Convertir la date
        String[] dateParts = dateString.split("/");
        if (dateParts.length != 3) {
            throw new IllegalArgumentException("Le format de la date est invalide.");
        }
        int jour = Integer.parseInt(dateParts[0].trim());
        int mois = Integer.parseInt(dateParts[1].trim());
        int annee = Integer.parseInt(dateParts[2].trim());
        Date date = new Date(jour, mois, annee);

        // Déterminer le type de trajet (Court ou Long)
        if (parts.length == 7) { // Supposons que l'identifiant soit à la fin
            String typeSpecific = parts[6].trim();

            if (typeSpecific.startsWith("TypeVoiture:")) {
                String typeDeVoiture = typeSpecific.replace("TypeVoiture:", "").trim();
                return new TrajetCourt(pointDepart, destination, date, heure, placesDisponibles, nomConducteur, typeDeVoiture);
            } else if (typeSpecific.startsWith("Distance:")) {
                int distance = Integer.parseInt(typeSpecific.replace("Distance:", "").trim());
                return new TrajetLong(pointDepart, destination, date, heure, placesDisponibles, nomConducteur, distance);
            } else {
                throw new IllegalArgumentException("Identifiant de type de trajet invalide : " + typeSpecific);
            }
        } else {
            throw new IllegalArgumentException("Le format de la chaîne ne permet pas d'identifier le type de trajet.");
        }

    } catch (Exception e) {
        throw new IllegalArgumentException("Erreur lors de l'analyse de la chaîne de trajet : " + e.getMessage());
    }
}


    
    
}
