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
import model.pck1.Date;
import model.pck2.Paiement;

/**
 * FXML Controller class
 *
 * @author ajeln
 */
public class PaiementTrajetController implements Initializable {

    LinkedList<Paiement> list;
    
    @FXML
    private TextField tfm;
    @FXML
    private TextField tfmp;
    @FXML
    private TextField tfdp;
    
    @FXML
    private TableView<Paiement> tablePaiements;
    @FXML
    private TableColumn<Paiement, Integer> colMontant;
    @FXML
    private TableColumn<Paiement, String> colModePaiement;
    @FXML
    private TableColumn<Paiement, Date> colDatePaiement;

    // Liste observable pour la TableView
    private ObservableList<Paiement> paiementsList;

    public PaiementTrajetController() {
        list = new LinkedList<>();
        paiementsList = FXCollections.observableArrayList();
    }

    @Override
public void initialize(URL url, ResourceBundle rb) {
    // Configuration des colonnes de la TableView
    colMontant.setCellValueFactory(new PropertyValueFactory<>("montant"));
    colModePaiement.setCellValueFactory(new PropertyValueFactory<>("modePaiement"));
    colDatePaiement.setCellValueFactory(new PropertyValueFactory<>("datePaiement"));

    // Liaison de la liste observable avec la TableView
    tablePaiements.setItems(paiementsList);  // Utilisation de la liste observable existante
}

@FXML
private void ClickedEnregistre(ActionEvent event) {
    // Création d'un nouvel objet Paiement avec les valeurs des TextFields
    Paiement p = new Paiement();
    p.setMontant(Integer.valueOf(tfm.getText()));
    p.setModePaiement(tfmp.getText());
    p.setDatePaiement(Date.valueOf(tfdp.getText()));

    // Ajouter le paiement à la liste de Paiements
    list.add(p);
    
    // Ajouter le paiement à l'ObservableList pour que la TableView se mette à jour
    paiementsList.add(p);

    System.out.println("Paiement effectué");
}

@FXML
private void ClickedSupprimer(ActionEvent event) {
    // Réinitialisation des champs de texte
    tfm.setText("");   // Réinitialise le champ "Montant"
    tfmp.setText("");  // Réinitialise le champ "Mode de paiement"
    tfdp.setText("");  // Réinitialise le champ "Date de paiement"
    
    // Suppression du dernier paiement ajouté dans la liste
    if (!list.isEmpty()) {
        Paiement lastPaiement = list.removeLast();
        paiementsList.remove(lastPaiement);  // Met à jour la TableView
        System.out.println("Dernier paiement supprimé");
    }
    
    System.out.println("Les champs ont été réinitialisés.");
}
}