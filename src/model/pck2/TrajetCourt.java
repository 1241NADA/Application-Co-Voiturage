/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.pck2;
import model.pck1.Conducteur;
import model.pck1.Date;

public final class TrajetCourt extends Trajet {
    private String typeDeVoiture;

    // Constructeur principal
    public TrajetCourt(String pointDepart, String destination, Date date, String heure, int placesDisponibles, String nomConducteur, String typeDeVoiture) {
        super(pointDepart, destination, date, heure, placesDisponibles, new Conducteur(nomConducteur)); // Crée un objet Conducteur
        this.typeDeVoiture = typeDeVoiture;
    }
    
    // Constructeur vide avec valeurs par défaut
    public TrajetCourt() {
        super("Inconnu", "Inconnu", new Date(1, 1, 2000), "00:00", 0, new Conducteur("Inconnu"));
        this.typeDeVoiture = "Standard";
    }

    // Getter
    public String getTypeDeVoiture() {
        return typeDeVoiture;
    }

    // Setter
    public void setTypeDeVoiture(String typeDeVoiture) {
        this.typeDeVoiture = typeDeVoiture;
    }

    @Override
    public String afficherDetails() {
        return super.afficherDetails() + ", Type de voiture : " + typeDeVoiture;
    }
}
