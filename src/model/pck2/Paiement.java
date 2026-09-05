

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model.pck2;

import model.Exception.PaiementInvalidException;
import model.pck1.Date;

public class Paiement {
    private double montant;
    private String modePaiement;
    private Date datePaiement;

    // Constructeur principal
    public Paiement(double montant, String modePaiement, Date datePaiement) {
        this.montant = montant;
        this.modePaiement = modePaiement;
        this.datePaiement = datePaiement;
    }

    // Constructeur vide avec valeurs par défaut
    public Paiement() {
        this.montant = 0.0;
        this.modePaiement = "Non défini";
        this.datePaiement = new Date(1, 1, 2000); // Valeur par défaut pour la date
    }

    // Getters
    public double getMontant() {
        return montant;
    }

    public String getModePaiement() {
        return modePaiement;
    }

    public Date getDatePaiement() {
        return datePaiement;
    }

    // Setters
    public void setMontant(double montant) {
        this.montant = montant;
    }

    public void setModePaiement(String modePaiement) {
        this.modePaiement = modePaiement;
    }

    public void setDatePaiement(Date datePaiement) {
        this.datePaiement = datePaiement;
    }

    // Méthode pour afficher les détails du paiement
    public String afficherDetails() {
        return "Montant : " + montant + " DT, Mode de paiement : " + modePaiement + ", Date du paiement : " + datePaiement.toString();
    }

    // Méthode pour effectuer un paiement
    public boolean effectuerPaiement() throws PaiementInvalidException {
        if (!estValide()) {
            throw new PaiementInvalidException("Le paiement est invalide : vérifiez le montant ou le mode de paiement.");
        }
        System.out.println("Paiement de " + montant + " DT effectué via " + modePaiement + " le " + datePaiement.toString());
        return true; // Retourner true pour indiquer que le paiement a été effectué avec succès
    }

    // Méthode pour vérifier si le paiement est valide
    public boolean estValide() {
        // Vérifier si le montant est positif et si le mode de paiement est non vide
        return montant > 0 && modePaiement != null && !modePaiement.isEmpty();
    }
}
