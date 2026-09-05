/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.pck1;
import model.pck1.Utilisateurs;

public class Evaluation {

    private String commentaire;  // Le commentaire de l'évaluation
    private Utilisateurs utilisateurEval;  // L'utilisateur qui a fait l'évaluation

    // Constructeur principal
    public Evaluation(String commentaire, Utilisateurs utilisateurEval) {
        this.commentaire = commentaire;
        this.utilisateurEval = utilisateurEval;
    }

    // Constructeur vide
    public Evaluation() {
        this.commentaire = "";  // Initialisation du commentaire à une chaîne vide
        this.utilisateurEval = null;  // L'utilisateur n'est pas initialisé
    }

    // Méthode pour afficher l'évaluation
    public void afficherEvaluation() {
        System.out.println("Évaluation par : " + utilisateurEval.getPrenom() + " " + utilisateurEval.getNom());
        System.out.println("Commentaire : " + commentaire);
    }

    // Getters et setters

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Utilisateurs getUtilisateurEval() {
        return utilisateurEval;
    }

    public void setUtilisateurEval(Utilisateurs utilisateurEval) {
        this.utilisateurEval = utilisateurEval;
    }
}
