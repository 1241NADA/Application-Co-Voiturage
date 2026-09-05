/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package model.Record;
import java.util.List;
import java.util.ArrayList;
import model.pck2.Trajet;


public record HistoriqueTrajetRecord(List<Trajet> trajets) {

    // Constructeur pour initialiser la liste de trajets si elle est nulle
    public HistoriqueTrajetRecord {
        if (trajets == null) {
            trajets = new ArrayList<>();  // Initialiser la liste si elle est null
        }
    }

    // Méthode pour ajouter un trajet à l'historique
    public void ajouterTrajet(Trajet trajet) {
        trajets.add(trajet);  // Ajoute un trajet à la liste modifiable
    }

    // Méthode pour afficher tous les trajets de l'historique
    public void afficherHistorique() {
        if (trajets.isEmpty()) {
            System.out.println("Aucun trajet dans l'historique.");
        } else {
            for (Trajet trajet : trajets) {
                System.out.println(trajet);  // Utilise toString() de ClassTrajet
            }
        }
    }
}
