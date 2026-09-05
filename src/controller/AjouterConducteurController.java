/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Exception.AdresseInvalideException;
import model.pck1.Adresse;
import model.pck1.Conducteur;
import model.pck2.Trajet;

public class AjouterConducteurController implements Initializable {
    private ObservableList<Conducteur> list; // Utilisation d'une ObservableList pour la TableView

    @FXML
    private TextField tfn;
    @FXML
    private TextField tfp;
    @FXML
    private TextField tfam;
    @FXML
    private TextField tfad;
    @FXML
    private TextField tftp;
    @FXML
    private TableView<Conducteur> tableConducteurs;
    @FXML
    private TableColumn<Conducteur, String> colNom;
    @FXML
    private TableColumn<Conducteur, String> colPrenom;
    @FXML
    private TableColumn<Conducteur, String> colEmail;
    @FXML
    private TableColumn<Conducteur, String> colAdresse;
    @FXML
    private TableColumn<Conducteur, List<Trajet>> colTrajets;

    public AjouterConducteurController() {
        list = FXCollections.observableArrayList();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Liaison des colonnes aux propriétés de Conducteur
        colNom.setCellValueFactory(new PropertyValueFactory<>("nomConducteur"));
        colPrenom.setCellValueFactory(new PropertyValueFactory<>("prenomConducteur"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("emailConducteur"));
        colAdresse.setCellValueFactory(new PropertyValueFactory<>("adresseConducteur"));
        colTrajets.setCellValueFactory(new PropertyValueFactory<>("trajetsProposes"));

        tableConducteurs.setItems(list); // Liaison de la liste à la TableView
    }

    @FXML
    private void ClickedEnregistrer(ActionEvent event) {
        try {
            // Validation des champs
            if (tfn.getText().isEmpty() || tfp.getText().isEmpty() || tfam.getText().isEmpty()
                    || tfad.getText().isEmpty() || tftp.getText().isEmpty()) {
                showAlert(AlertType.ERROR, "Erreur", "Veuillez remplir tous les champs !");
                return;
            }

            // Création d'un nouveau conducteur
            Conducteur C = new Conducteur();
            C.setNomConducteur(tfn.getText());
            C.setPrenomConducteur(tfp.getText());
            C.setEmailConducteur(tfam.getText());

            // Validation de l'adresse
            Adresse adresse = Adresse.valueOf(tfad.getText());
            C.setAdresseConducteur(adresse);

            // Conversion des trajets
            String[] trajetsArray = tftp.getText().split(";");
            List<Trajet> trajetsProposes = new ArrayList<>();
            for (String trajetString : trajetsArray) {
                Trajet trajet = Trajet.valueOf(trajetString.trim()); // Ajout de trim pour supprimer les espaces inutiles
                trajetsProposes.add(trajet);
            }
            C.setTrajetsProposes(trajetsProposes);

            // Ajout à la liste et mise à jour de la table
            list.add(C);
            tableConducteurs.refresh();
            showAlert(AlertType.INFORMATION, "Succès", "Conducteur ajouté avec succès !");
            clearFields();

        } catch (AdresseInvalideException ex) {
            showAlert(AlertType.ERROR, "Erreur", "Adresse invalide !");
        } catch (Exception ex) {
            showAlert(AlertType.ERROR, "Erreur", "Une erreur est survenue : " + ex.getMessage());
        }
    }

    @FXML
    private void ClickedSupprimer(ActionEvent event) {
        Conducteur selectedConducteur = tableConducteurs.getSelectionModel().getSelectedItem();
        if (selectedConducteur != null) {
            list.remove(selectedConducteur);
            tableConducteurs.refresh();
            showAlert(AlertType.INFORMATION, "Succès", "Conducteur supprimé !");
        } else {
            showAlert(AlertType.WARNING, "Attention", "Veuillez sélectionner un conducteur à supprimer !");
        }
    }

    private void clearFields() {
        tfn.clear();
        tfp.clear();
        tfam.clear();
        tfad.clear();
        tftp.clear();
    }

    private void showAlert(AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
