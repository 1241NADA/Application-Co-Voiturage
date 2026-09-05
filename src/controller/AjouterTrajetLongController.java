package controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.pck1.Date;
import model.pck2.TrajetLong;

import java.net.URL;
import java.util.ResourceBundle;

public class AjouterTrajetLongController implements Initializable {
    ObservableList<TrajetLong> list;
    
    @FXML
    private TextField tfpd;
    @FXML
    private TextField tfd;
    @FXML
    private TextField tfdt;
    @FXML
    private TextField tfh;
    @FXML
    private TextField tfnpd;
    @FXML
    private TextField tfnc;
    @FXML
    private TextField tfdis;
    @FXML
    private TableView<TrajetLong> tableTrajets;
    @FXML
    private TableColumn<TrajetLong, String> colDepart;
    @FXML
    private TableColumn<TrajetLong, String> colDestination;
    @FXML
    private TableColumn<TrajetLong, String> colDate;
    @FXML
    private TableColumn<TrajetLong, String> colHeure;
    @FXML
    private TableColumn<TrajetLong, String> colPlaces;
    @FXML
    private TableColumn<TrajetLong, String> colConducteur;
    @FXML
    private TableColumn<TrajetLong, String> colDistance;

    public AjouterTrajetLongController() {
        list = FXCollections.observableArrayList();  // Initialisation de la liste observable
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialisation des colonnes de la TableView
        colDepart.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPointDepart()));
        colDestination.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDestination()));
        colDate.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDate().toString()));  // Assurez-vous que la classe Date a une méthode toString()
        colHeure.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getHeure()));
        colPlaces.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getPlacesDisponibles())));
        colConducteur.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNomConducteur()));
        colDistance.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getDistance())));
        
        // Remplir la table avec la liste observable
        tableTrajets.setItems(list);
    }

    @FXML
    private void ClickedEnregistrer(ActionEvent event) {
        // Créer un nouvel objet TrajetLong avec les données du formulaire
        TrajetLong TL = new TrajetLong();
        TL.setPointDepart(tfpd.getText());
        TL.setDestination(tfd.getText());
        TL.setDate(Date.valueOf(tfdt.getText()));  // Assurez-vous que la classe Date gère bien ce format
        TL.setHeure(tfh.getText());
        TL.setPlacesDisponibles(Integer.valueOf(tfnpd.getText()));
        TL.setNomConducteur(tfnc.getText());
        TL.setDistance(Integer.valueOf(tfdis.getText()));

        // Ajouter le trajet à la liste
        list.add(TL);
        System.out.println("Trajet Long Ajouté");
    }

    @FXML
    private void ClickedSupprimer(ActionEvent event) {
        // Vider les TextFields
        tfpd.setText("");  // Point de départ
        tfd.setText("");   // Destination
        tfdt.setText("");  // Date
        tfh.setText("");   // Heure
        tfnpd.setText(""); // Nombre de places disponibles
        tfnc.setText("");  // Nom conducteur
        tfdis.setText(""); // Distance

        // Supprimer le dernier trajet de la liste si elle n'est pas vide
        if (!list.isEmpty()) {
            list.removeLast(); // Supprime le dernier trajet ajouté
            System.out.println("Dernier trajet supprimé");
        }

        // Afficher un message de confirmation
        System.out.println("Tous les champs ont été réinitialisés.");
    }
}
