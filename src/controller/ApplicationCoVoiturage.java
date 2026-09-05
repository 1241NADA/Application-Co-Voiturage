/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.pck1.Evaluation;
import model.pck1.Utilisateurs;
import model.pck2.Reservation;
import model.pck2.Trajet;
import model.pck2.Vehicule;

public class ApplicationCoVoiturage extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            
            // Chargement du fichier FXML
            Parent root = FXMLLoader.load(getClass().getResource("/view/CovAccueilFXML.fxml"));
            //construction
            Slider Slider=new Slider(0,1000,50);
            ProgressIndicator Indicateur=new ProgressIndicator(0.0);
            HBox root1=new HBox(2);
            root1.getChildren().addAll(Slider,Indicateur);
            //binding
            Indicateur.progressProperty().bind(Slider.valueProperty().divide(1000.0));
          
            
            // Création de la scène
            Scene scene = new Scene(root);

            // Configuration et affichage du stage 
            primaryStage.setTitle("AjouterTrajet");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            // Gestion des exceptions avec Logger et message d'erreur détaillé
            Logger.getLogger(ApplicationCoVoiturage.class.getName()).log(Level.SEVERE, 
                    "Erreur lors du chargement du fichier FXML", ex);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
