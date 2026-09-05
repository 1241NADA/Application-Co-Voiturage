package model.pck1;

import model.pck2.Trajet;

import java.util.ArrayList;
import java.util.List;

public final class Conducteur extends Utilisateurs {
    private List<Trajet> trajetsProposes; // Liste des trajets proposés

    // Constructeur principal
    public Conducteur(String nom, String email, String prenom, Adresse adresse) {
        super(nom, email, prenom, adresse);
        this.trajetsProposes = new ArrayList<>(); // Initialisation
    }

    // Constructeur vide
    public Conducteur() {
        super("Inconnu", "inconnu@email.com", "Inconnu", new Adresse());
        this.trajetsProposes = new ArrayList<>(); // Initialisation
    }

    // Constructeur avec uniquement le nom
    public Conducteur(String nom) {
        super(nom, "inconnu@email.com", "Inconnu", new Adresse());
        this.trajetsProposes = new ArrayList<>(); // Initialisation
    }

    // Getter pour la liste des trajets proposés
    public List<Trajet> getTrajetsProposes() {
        return trajetsProposes;
    }

    // Setter pour la liste des trajets proposés
    public void setTrajetsProposes(List<Trajet> trajetsProposes) {
        this.trajetsProposes = trajetsProposes;
    }

    // Méthode pour ajouter un trajet à la liste des trajets proposés
    public void proposerTrajet(Trajet trajet) {
        trajetsProposes.add(trajet);
    }

    // Méthode pour supprimer un trajet de la liste des trajets proposés
    public void annulerTrajet(Trajet trajet) {
        trajetsProposes.remove(trajet);
    }

    // Méthode pour afficher tous les trajets proposés
    public void afficherTrajetsProposes() {
        if (trajetsProposes.isEmpty()) {
            System.out.println("Aucun trajet proposé.");
        } else {
            System.out.println("Liste des trajets proposés :");
            for (Trajet trajet : trajetsProposes) {
                System.out.println(trajet.afficherDetails()); // Appel à afficherDetails() pour afficher les trajets
            }
        }
    }

    // Getters et setters supplémentaires
    public String getNomConducteur() {
        return getNom();
    }

    public void setNomConducteur(String nom) {
        setNom(nom);
    }

    public String getEmailConducteur() {
        return getEmail();
    }

    public void setEmailConducteur(String email) {
        setEmail(email);
    }

    public String getPrenomConducteur() {
        return getPrenom();
    }

    public void setPrenomConducteur(String prenom) {
        setPrenom(prenom);
    }

    public Adresse getAdresseConducteur() {
        return getAdresse();
    }

    public void setAdresseConducteur(Adresse adresse) {
        setAdresse(adresse);
    }

    @Override
    public void afficherDetails() {
        System.out.println("Nom: " + getNom() + ", Prénom: " + getPrenom() +
                ", Email: " + getEmail() + ", Adresse: " + getAdresse().obtenirAdresseComplete());
    }

    @Override
    public String obtenirRole() {
        return "conducteur";
    }
}
