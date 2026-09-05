package controller;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.pck1.Date;
import model.pck2.Reservation;

/**
 * FXML Controller class
 *
 * @author ajeln
 */
public class ReserverTrajetController implements Initializable {
    LinkedList<Reservation> list;

    @FXML
    private TextField tfdt;
    @FXML
    private TextField tfdr;
    @FXML
    private TextField tfs;
    @FXML
    private TextField tfnp;
    @FXML
    private TableView<Reservation> tableReservations;
    @FXML
    private TableColumn<Reservation, String> colDestination;
    @FXML
    private TableColumn<Reservation, Date> colDateReservation;
    @FXML
    private TableColumn<Reservation, String> colStatut;
    @FXML
    private TableColumn<Reservation, String> colNomPassager;

    public ReserverTrajetController(){
        list = new LinkedList<>();
    }

    /**
     * Initializes the controller class.
     */
    @Override
public void initialize(URL url, ResourceBundle rb) {
    // Initialisation des colonnes de la TableView en utilisant les getters de la classe Reservation
    colDestination.setCellValueFactory(new PropertyValueFactory<>("destinationTrajet"));
    colDateReservation.setCellValueFactory(new PropertyValueFactory<>("dateReservation"));
    colStatut.setCellValueFactory(new PropertyValueFactory<>("statut"));
    colNomPassager.setCellValueFactory(new PropertyValueFactory<>("nomPassager"));

    // Affecter directement la liste sans utiliser observableList
    tableReservations.getItems().setAll(list); // Remplace le contenu actuel de la table
}

@FXML
private void clickedEnregistrer(ActionEvent event) {
    Reservation R = new Reservation();
    R.setDestinationTrajet(tfdt.getText());
    R.setDateReservation(Date.valueOf(tfdr.getText()));  // Assurez-vous que la date est correctement formatée
    R.setStatut(tfs.getText());
    R.setNomPassager(tfnp.getText());

    // Ajouter la réservation à la liste
    list.add(R);

    // Mettre à jour la TableView en réaffectant les éléments
    tableReservations.getItems().setAll(list);

    System.out.println("Réservation effectuée");
}

@FXML
private void ClickedSupprimer(ActionEvent event) {
    // Vider les TextFields
    tfdt.setText("");  // Destination du trajet
    tfdr.setText("");  // Date de réservation
    tfs.setText("");   // Statut de la réservation
    tfnp.setText("");  // Nom du passager

    // Optionnellement, vous pouvez supprimer la dernière réservation de la liste
    if (!list.isEmpty()) {
        list.removeLast(); // Supprime la dernière réservation ajoutée
        // Mettre à jour la TableView après la suppression
        tableReservations.getItems().setAll(list);
        System.out.println("Dernière réservation supprimée");
    }

    // Afficher un message de confirmation (facultatif)
    System.out.println("Tous les champs ont été réinitialisés.");
}
}