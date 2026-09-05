/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package model.Exception;

/**
 * Exception personnalisée pour les paiements invalides
 */
public class PaiementInvalidException extends Exception {
    public PaiementInvalidException(String message) {
        super(message);
    }
}
