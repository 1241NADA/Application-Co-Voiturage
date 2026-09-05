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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Exception.AdresseInvalideException;
import model.pck1.Adresse;
import model.pck1.Passager;
import model.pck2.Trajet;

/**
 * FXML Controller class
 *
 * @author ajeln
 */
public class AjouterPassagerController implements Initializable {

    private ObservableList<Passager> passagers; // Liste observable pour la TableView

    @FXML
    private TextField tfn;
    @FXML
    private TextField tfp;
    @FXML
    private TextField tfam;
    @FXML
    private TextField tfa;
    @FXML
    private TextField tftr;

    @FXML
    private TableView<Passager> tablePassagers; // TableView pour afficher les passagers

    @FXML
    private TableColumn<Passager, String> colNom;
    @FXML
    private TableColumn<Passager, String> colPrenom;
    @FXML
    private TableColumn<Passager, String> colEmail;
    @FXML
    private TableColumn<Passager, String> colAdresse;
    @FXML
    private TableColumn<Passager, String> colTrajets;

    public AjouterPassagerController() {
        passagers = FXCollections.observableArrayList(); // Initialisation de la liste observable
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Liaison des colonnes aux propriétés du Passager
        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colAdresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        colTrajets.setCellValueFactory(new PropertyValueFactory<>("trajetReserves"));

        // Associer la liste observable à la TableView
        tablePassagers.setItems(passagers);
    }

    @FXML
    private void ClickedEnregistrer(ActionEvent event) throws AdresseInvalideException {
        // Création d'un nouveau passager
        Passager pa = new Passager();
        pa.setNom(tfn.getText());
        pa.setPrenom(tfp.getText());
        pa.setEmail(tfam.getText());
        pa.setAdresse(Adresse.valueOf(tfa.getText()));

        // Conversion des trajets réservés depuis le champ texte (séparateur ";")
        String trajetsText = tftr.getText();
        List<Trajet> trajets = new ArrayList<>();
        if (!trajetsText.isEmpty()) {
            String[] trajetsArray = trajetsText.split(";");
            for (String trajet : trajetsArray) {
                // Vous devez adapter cette ligne à votre classe `Trajet`
                
            }
        }
        pa.setTrajetReserves(trajets);

        // Ajouter le passager à la liste observable
        passagers.add(pa);

        // Réinitialiser les champs après ajout
        clearFields();

        System.out.println("Passager ajouté : " + pa.getNom());
    }

    @FXML
    private void ClickedSupprimer(ActionEvent event) {
        // Supprimer le passager sélectionné dans la TableView
        Passager selectedPassager = tablePassagers.getSelectionModel().getSelectedItem();
        if (selectedPassager != null) {
            passagers.remove(selectedPassager);
            System.out.println("Passager supprimé : " + selectedPassager.getNom());
        } else {
            System.out.println("Aucun passager sélectionné.");
        }
    }

    private void clearFields() {
        // Réinitialiser les champs de texte
        tfn.clear();
        tfp.clear();
        tfam.clear();
        tfa.clear();
        tftr.clear();
    }
}
