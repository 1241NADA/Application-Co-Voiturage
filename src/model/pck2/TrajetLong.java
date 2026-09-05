/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.pck2;
import model.pck1.Conducteur;
import model.pck1.Date;
import model.pck2.Trajet;

public final class TrajetLong extends Trajet {
    private int distance;

    // Constructeur principal
    public TrajetLong(String pointDepart, String destination, Date date, String heure, int placesDisponibles, String nomConducteur, int distance) {
        super(pointDepart, destination, date, heure, placesDisponibles, new Conducteur(nomConducteur)); // Crée un objet Conducteur
        this.distance = distance;
    }

    // Constructeur vide avec valeurs par défaut
    public TrajetLong() {
        super("Inconnu", "Inconnu", new Date(1, 1, 2000), "00:00", 0, new Conducteur("Inconnu"));
        this.distance = 0; // Valeur par défaut pour la distance
    }

    // Getter pour la distance
    public int getDistance() {
        return distance;
    }

    // Setter pour la distance
    public void setDistance(int distance) {
        if (distance < 0) {
            throw new IllegalArgumentException("La distance ne peut pas être négative.");
        }
        this.distance = distance;
    }

    @Override
    public String afficherDetails() {
        return super.afficherDetails() + ", Distance : " + distance + " km";
    }
}
