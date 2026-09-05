/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ajeln
 */
public class AjouterUtilisateurController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ClickedAjouterConducteur(ActionEvent event) {
                try {
            Stage st = new Stage();
            // Chargement du fichier FXML
            Parent root = FXMLLoader.load(getClass().getResource("/view/AjouterConducteur.fxml"));

            // Création de la scène
            Scene scene = new Scene(root);

            // Configuration et affichage du stage
            st.setTitle("Application de Covoiturage");
            st.setScene(scene);
            st.show();
        } catch (IOException ex) {
            // Gestion des exceptions avec Logger et message d'erreur détaillé
            Logger.getLogger(ApplicationCoVoiturage.class.getName()).log(Level.SEVERE,
                    "Erreur lors du chargement du fichier FXML", ex);
        }
    }

    @FXML
    private void ClickedAjouterPassager(ActionEvent event) {
                try {
            Stage st = new Stage();
            // Chargement du fichier FXML
            Parent root = FXMLLoader.load(getClass().getResource("/view/AjouterPassager.fxml"));

            // Création de la scène
            Scene scene = new Scene(root);

            // Configuration et affichage du stage
            st.setTitle("Application de Covoiturage");
            st.setScene(scene);
            st.show();
        } catch (IOException ex) {
            // Gestion des exceptions avec Logger et message d'erreur détaillé
            Logger.getLogger(ApplicationCoVoiturage.class.getName()).log(Level.SEVERE,
                    "Erreur lors du chargement du fichier FXML", ex);
        }
    }
    
}
