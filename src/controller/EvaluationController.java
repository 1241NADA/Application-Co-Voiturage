/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import model.Exception.AdresseInvalideException;
import model.pck1.Evaluation;
import model.pck1.Utilisateurs;

/**
 * FXML Controller class
 *
 * @author ajeln
 */
public class EvaluationController implements Initializable {
    LinkedList<Evaluation> list;
    @FXML
    private TextField tfu;
    @FXML
    private TextField tfc;
    @FXML
    private Slider Slider;
    @FXML
    private ProgressIndicator Indicateur;
    public EvaluationController(){
        list = new LinkedList();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Indicateur.progressProperty().bind(Slider.valueProperty().divide(100.0));
        // TODO
    }    

    @FXML
    private void ClickedEnregistrer(ActionEvent event) throws AdresseInvalideException {
        Evaluation E=new Evaluation();
        // Extraction des informations de l'utilisateur depuis tfu (nom et prénom uniquement)
        E.setUtilisateurEval(Utilisateurs.valueOf(tfu.getText()));
        E.setCommentaire(tfc.getText());
       

        list.add(E);
        System.out.println(" Evaluation effectuée");
    }

    private void ClickedSupprimer(ActionEvent event) {
         // Vider les TextFields
    tfu.setText("");  // Utilisateur (Nom et Prénom)
    tfc.setText("");  // Commentaire

    // Réinitialiser la valeur du Slider à 0
    Slider.setValue(0);

    // Réinitialiser l'indicateur de progression
    Indicateur.setProgress(0);

    // Si vous souhaitez supprimer la dernière évaluation de la liste
    if (!list.isEmpty()) {
        list.removeLast(); // Supprime le dernier élément ajouté à la liste
        System.out.println("Dernière évaluation supprimée");
    }

    // Optionnellement, vous pouvez afficher un message de confirmation
    System.out.println("Tous les champs ont été réinitialisés.");
}

    }
    

