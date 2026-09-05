/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.pck1;

import java.util.ArrayList;
import java.util.List;
import model.pck2.Trajet;

/**
 * Classe représentant l'historique des trajets.
 * Elle stocke et affiche les trajets enregistrés.
 */
public class HistoriqueTrajet {
    private List<Trajet> trajets; // Liste pour stocker les trajets

    // Constructeur
    public HistoriqueTrajet() {
        this.trajets = new ArrayList<>();
    }

    // Méthode pour ajouter un trajet à l'historique
    public void ajouterTrajet(Trajet trajet) {
        if (trajet != null) {
            trajets.add(trajet);
            System.out.println("Trajet ajouté à l'historique : " + trajet.afficherDetails());
        } else {
            System.out.println("Le trajet est invalide et ne peut pas être ajouté.");
        }
    }

    // Méthode pour afficher l'historique des trajets
    public void afficherHistorique() {
        if (trajets.isEmpty()) {
            System.out.println("Aucun trajet dans l'historique.");
        } else {
            System.out.println("Historique des trajets :");
            for (Trajet trajet : trajets) {
                System.out.println(trajet.afficherDetails()); // Utilisation de la méthode afficherDetails
            }
        }
    }
}



