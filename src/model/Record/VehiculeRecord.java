/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package model.Record;

/**
 * Représentation d'un véhicule sous forme de record
 */
public record VehiculeRecord(String modele, String marque, String immatriculation, int capacite) {
    // Méthode pour afficher les détails du véhicule
    public String afficherDetails() {
        return "Véhicule [Marque : " + marque + ", Modèle : " + modele + 
               ", Immatriculation : " + immatriculation + ", Capacite : " + capacite + " places]";
    }

    // Méthode pour vérifier si le véhicule peut accueillir un certain nombre de passagers
    public boolean peutAccueillir(int nbPassagers) {
        return nbPassagers <= capacite;
    }
}
