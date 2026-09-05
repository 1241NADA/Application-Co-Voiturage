/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package model.Exception;

import model.pck1.Date;


// Exception personnalisée pour les dates invalides
public class DateInvalideException extends IllegalArgumentException {
   
    // Constructeur qui prend un message d'erreur comme paramètre
    public DateInvalideException(String message) {
        super(message);  // Appel du constructeur de la classe parente (IllegalArgumentException)
    }
}

