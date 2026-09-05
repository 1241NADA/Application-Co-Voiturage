/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.net.URL;
import java.util.LinkedList;
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
import model.pck1.Date;
import model.pck2.TrajetCourt;

/**
 * FXML Controller class
 *
 * @author ajeln
 */
public class AjouterTrajetCourtController implements Initializable {

    // Liste pour stocker les trajets
    private ObservableList<TrajetCourt> list;

    @FXML
    private TextField tfpd; // Point de départ
    @FXML
    private TextField tfd; // Destination
    @FXML
    private TextField tfdt; // Date
    @FXML
    private TextField tfh; // Heure
    @FXML
    private TextField tfnpd; // Nombre de places disponibles
    @FXML
    private TextField tfnc; // Nom du conducteur
    @FXML
    private TextField tfv; // Type de voiture

    @FXML
    private TableView<TrajetCourt> tableTrajets;
    @FXML
    private TableColumn<TrajetCourt, String> colDepart;
    @FXML
    private TableColumn<TrajetCourt, String> colDestination;
    @FXML
    private TableColumn<TrajetCourt, Date> colDate;
    @FXML
    private TableColumn<TrajetCourt, String> colHeure;
    @FXML
    private TableColumn<TrajetCourt, Integer> colPlaces;
    @FXML
    private TableColumn<TrajetCourt, String> colConducteur;
    @FXML
    private TableColumn<TrajetCourt, String> colVoiture;

    public AjouterTrajetCourtController() {
        list = FXCollections.observableArrayList();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialisation des colonnes avec les propriétés de TrajetCourt
        colDepart.setCellValueFactory(new PropertyValueFactory<>("pointDepart"));
        colDestination.setCellValueFactory(new PropertyValueFactory<>("destination"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colHeure.setCellValueFactory(new PropertyValueFactory<>("heure"));
        colPlaces.setCellValueFactory(new PropertyValueFactory<>("placesDisponibles"));
        colConducteur.setCellValueFactory(new PropertyValueFactory<>("nomConducteur"));
        colVoiture.setCellValueFactory(new PropertyValueFactory<>("typeDeVoiture"));

        // Lier la liste au TableView
        tableTrajets.setItems(list);
    }

    @FXML
    private void ClickedEnregistrer(ActionEvent event) {
        try {
            // Validation des champs
            if (tfpd.getText().isEmpty() || tfd.getText().isEmpty() || tfdt.getText().isEmpty() ||
                tfh.getText().isEmpty() || tfnpd.getText().isEmpty() || tfnc.getText().isEmpty() || tfv.getText().isEmpty()) {
                throw new IllegalArgumentException("Tous les champs doivent être remplis.");
            }

            // Création d'un nouveau trajet
            TrajetCourt TC = new TrajetCourt();
            TC.setPointDepart(tfpd.getText());
            TC.setDestination(tfd.getText());
            TC.setDate(Date.valueOf(tfdt.getText()));
            TC.setHeure(tfh.getText());
            TC.setPlacesDisponibles(Integer.parseInt(tfnpd.getText()));
            TC.setNomConducteur(tfnc.getText());
            TC.setTypeDeVoiture(tfv.getText());

            // Ajout à la liste
            list.add(TC);

            // Affichage d'un message de confirmation
            showAlert(AlertType.INFORMATION, "Succès", "Trajet ajouté avec succès !");

            // Réinitialiser les champs
            resetFields();

        } catch (NumberFormatException e) {
            showAlert(AlertType.ERROR, "Erreur", "Le nombre de places doit être un entier.");
        } catch (IllegalArgumentException e) {
            showAlert(AlertType.WARNING, "Attention", e.getMessage());
        } catch (Exception e) {
            showAlert(AlertType.ERROR, "Erreur", "Une erreur s'est produite : " + e.getMessage());
        }
    }

    @FXML
    private void ClickedSupprimer(ActionEvent event) {
        // Récupérer le trajet sélectionné
        TrajetCourt selectedTrajet = tableTrajets.getSelectionModel().getSelectedItem();

        if (selectedTrajet != null) {
            // Supprimer le trajet de la liste
            list.remove(selectedTrajet);
            showAlert(AlertType.INFORMATION, "Succès", "Trajet supprimé avec succès !");
        } else {
            showAlert(AlertType.WARNING, "Attention", "Aucun trajet sélectionné.");
        }
    }

    // Méthode pour réinitialiser les champs
    private void resetFields() {
        tfpd.clear();
        tfd.clear();
        tfdt.clear();
        tfh.clear();
        tfnpd.clear();
        tfnc.clear();
        tfv.clear();
    }

    // Méthode pour afficher une alerte
    private void showAlert(AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
