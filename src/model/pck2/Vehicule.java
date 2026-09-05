/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.pck2;

/**
 *
 * @author ajeln
 */
public class Vehicule {
    // Attributs
    private String modele;
    private String marque;
    private String immatriculation;
    private int capacite;  // Nombre de places dans le véhicule

    // Constructeur principal
    public Vehicule(String modele, String marque, String immatriculation, int capacite) {
        this.modele = modele;
        this.marque = marque;
        this.immatriculation = immatriculation;
        this.capacite = capacite;
    }

    // Constructeur vide
    public Vehicule() {
        this.modele = "Modèle inconnu";
        this.marque = "Marque inconnue";
        this.immatriculation = "Immatriculation inconnue";
        this.capacite = 0; // Capacite par défaut
    }

    // Getters
    public String getModele() {
        return modele;
    }

    public String getMarque() {
        return marque;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public int getCapacite() {
        return capacite;
    }

    // Setters
    public void setModele(String modele) {
        this.modele = modele;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    // Méthode pour afficher les détails du véhicule
    public String afficherDetails() {
        return "Véhicule [Marque : " + marque + ", Modèle : " + modele + ", Immatriculation : " + immatriculation + ", Capacite : " + capacite + " places]";
    }

    // Méthode pour vérifier si le véhicule peut accueillir un certain nombre de passagers
    public boolean peutAccueillir(int nbPassagers) {
        return nbPassagers <= capacite;
    }

    // Méthode toString pour une représentation textuelle du véhicule
    @Override
    public String toString() {
        return "Véhicule " + marque + " " + modele + " (" + immatriculation + ") - Capacite : " + capacite + " places";
    }
}
