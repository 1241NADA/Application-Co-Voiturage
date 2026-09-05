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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.pck2.Vehicule;

/**
 * FXML Controller class
 *
 * @author ajeln
 */
public class AjouterVehiculeController implements Initializable {
    LinkedList<Vehicule> list;

    @FXML
    private TextField tfm;
    @FXML
    private TextField tfma;
    @FXML
    private TextField tfim;
    @FXML
    private TextField tfc;
    @FXML
    private TableView<Vehicule> tableVehicules;
    @FXML
    private TableColumn<Vehicule, String> colModele;
    @FXML
    private TableColumn<Vehicule, String> colMarque;
    @FXML
    private TableColumn<Vehicule, String> colImmatriculation;
    @FXML
    private TableColumn<Vehicule, Integer> colCapacite;

    private ObservableList<Vehicule> vehiculeList;

    public AjouterVehiculeController() {
        list = new LinkedList<>();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialisation de la liste observable
        vehiculeList = FXCollections.observableArrayList();

        // Configuration des colonnes
        colModele.setCellValueFactory(new PropertyValueFactory<>("modele"));
        colMarque.setCellValueFactory(new PropertyValueFactory<>("marque"));
        colImmatriculation.setCellValueFactory(new PropertyValueFactory<>("immatriculation"));
        colCapacite.setCellValueFactory(new PropertyValueFactory<>("capacite"));

        // Liaison de la liste observable avec la TableView
        tableVehicules.setItems(vehiculeList);
    }

    @FXML
    private void ClickedEnregistrer(ActionEvent event) {
        // Création d'un nouveau véhicule
        Vehicule V = new Vehicule();
        V.setModele(tfm.getText());
        V.setMarque(tfma.getText());
        V.setImmatriculation(tfim.getText());
        V.setCapacite(Integer.valueOf(tfc.getText()));

        // Ajout à la liste et à la TableView
        list.add(V);
        vehiculeList.add(V);

        System.out.println("Véhicule ajouté : " + V);
        
        // Optionnel : vider les champs après ajout
        tfm.clear();
        tfma.clear();
        tfim.clear();
        tfc.clear();
    }

    @FXML
    private void ClickedSupprimer(ActionEvent event) {
        // Supprime l'élément sélectionné dans la TableView
        Vehicule selectedVehicule = tableVehicules.getSelectionModel().getSelectedItem();
        if (selectedVehicule != null) {
            list.remove(selectedVehicule);
            vehiculeList.remove(selectedVehicule);
            System.out.println("Véhicule supprimé : " + selectedVehicule);
        } else {
            System.out.println("Aucun véhicule sélectionné.");
        }

        // Optionnel : vider les champs après suppression
        tfm.clear();
        tfma.clear();
        tfim.clear();
        tfc.clear();
    }
}

