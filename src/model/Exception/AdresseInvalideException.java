/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package model.Exception;

import model.pck1.Adresse;




public class AdresseInvalideException extends Exception {
   
    // Constructeur sans message
    public AdresseInvalideException() {
        super("Adresse invalide");  // Message par défaut
    }

    // Constructeur avec message personnalisé
    public AdresseInvalideException(String message) {
        super(message);  // Utilisation du constructeur de la classe mère
    }

    // Constructeur avec message et cause
    public AdresseInvalideException(String message, Throwable cause) {
        super(message, cause);  // Utilisation du constructeur de la classe mère
    }

    // Constructeur avec cause
    public AdresseInvalideException(Throwable cause) {
        super(cause);  // Utilisation du constructeur de la classe mère
    }
}