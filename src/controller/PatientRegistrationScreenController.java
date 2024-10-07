package controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import model.Patient;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class PatientRegistrationScreenController implements Initializable {

    @FXML
    private TextField firstnamefield;

    @FXML
    private TextField lastnameField;

    @FXML
    private TextField agefField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField messageField;

    @FXML
    private ComboBox patientTypeComboBox;

    @FXML
    private ImageView photoImageView;

    @FXML
    private Button summmitButton;

    private String photoPath;

    /**
     * Initializes the controller class.
     */
    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        //initialize comobox
        patientTypeComboBox.getItems().addAll("Inpatient", "outpatient", "Emergency");

        //set default value
        firstnamefield.setText("");
        lastnameField.setText("");
        agefField.setText("");
        emailField.setText("");
        messageField.setText("");
        photoPath = "";

        UploadImage();
    }

    // the picture upload
    private void UploadImage() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("*.png", "*.jpg", "*.jpeg")
        );
        File selectFile = fileChooser.showOpenDialog(null);

        if (selectFile != null) {
            Image image = new Image(selectFile.toURI().toString());
            photoImageView.setImage(image);
            photoPath = selectFile.getAbsolutePath();
        }
    }

    @FXML
    private void SubmitButtonAction(ActionEvent event) {

        String firstName = firstnamefield.getText();
        String lastName = lastnameField.getText();
        int age = Integer.parseInt(agefField.getText());
        String email = emailField.getText();
        String message = messageField.getText();
        String patientType = (String) patientTypeComboBox.getValue();

        Patient newPatient = new Patient(firstName, lastName, age, email, message, patientType, photoPath);

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/patient_review_screen.fxml"));
            Parent root = loader.load();

            PatientReviewScreenController reviewController = loader.getController();
            reviewController.setPatientDetails(newPatient);

            NewFXMain mainApp = new NewFXMain();
            mainApp.showReviewDetailsScreen();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
