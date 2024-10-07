package controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Patient;


/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class PatientReviewScreenController implements Initializable {

    @FXML
    private Label ageLable;

    @FXML
    private Label FirstnameLable;

    @FXML
    private Label LastnameLable;

    @FXML
    private Label MessageLabel;

    @FXML
    private Label PatientTypeLabel;

    @FXML
    private ImageView PhotoImageView;

    public void setPatientDetails(Patient patient) {

        FirstnameLable.setText(patient.getFirstName());
        LastnameLable.setText(patient.getLastName());
        MessageLabel.setText(patient.getMessage());
        PatientTypeLabel.setText(patient.getPatientType());

        Image image = new Image(patient.getPhotoPath());
        PhotoImageView.setImage(image);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
