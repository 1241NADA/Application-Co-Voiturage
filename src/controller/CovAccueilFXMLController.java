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
 */
public class CovAccueilFXMLController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialisation (si nécessaire)
    }

    @FXML
    private void ClickedAjouterTrajet(ActionEvent event) {
        try {
            Stage st = new Stage();
            // Chargement du fichier FXML
            Parent root = FXMLLoader.load(getClass().getResource("/view/AjouterTrajet.fxml"));

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
    private void ClickedReserverTrajet(ActionEvent event) {
        try {
            Stage st = new Stage();
            // Chargement du fichier FXML
            Parent root = FXMLLoader.load(getClass().getResource("/view/ReserverTrajet.fxml"));

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

    /////////

    @FXML
    private void ClickedProfilUtilisateur(ActionEvent event) {
        try {
            Stage st = new Stage();
            // Chargement du fichier FXML
            Parent root = FXMLLoader.load(getClass().getResource("/view/AjouterUtilisateur.fxml"));

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
    private void ClickedEvaluation(ActionEvent event) {
        try {
            Stage st = new Stage();
            // Chargement du fichier FXML
            Parent root = FXMLLoader.load(getClass().getResource("/view/Evaluation.fxml"));

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
    private void ClickedAjouterVehicule(ActionEvent event) {
try {
            Stage st = new Stage();
            // Chargement du fichier FXML
            Parent root = FXMLLoader.load(getClass().getResource("/view/AjouterVehicule.fxml"));

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
    private void ClickedPayerTrajet(ActionEvent event) {
        try {
            Stage st = new Stage();
            // Chargement du fichier FXML
            Parent root = FXMLLoader.load(getClass().getResource("/view/PaiementTrajet.fxml"));

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