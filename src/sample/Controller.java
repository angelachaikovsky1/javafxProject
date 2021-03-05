package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import javafx.event.ActionEvent;
import javafx.scene.layout.HBox;

public class Controller {

    @FXML
    private Button addButton;

    @FXML
    private Button addSubmit;

    @FXML
    private RadioButton partTime;

    @FXML
    private ToggleGroup employeeGroup;

    @FXML
    private RadioButton fullTime;

    @FXML
    private RadioButton management;

    @FXML
    private RadioButton addIT;

    @FXML
    private ToggleGroup departmentAdd;

    @FXML
    private RadioButton addCS;

    @FXML
    private RadioButton addECE;

    @FXML
    private TextField dateAddText;

    @FXML
    private TextField nameAddText;

    @FXML
    private TextField hourlyAddText;

    @FXML
    private TextField annualAddText;

    @FXML
    private TextField codeAddText;

    @FXML
    private Button removeButton;

    @FXML
    private Button removeSubmit;

    @FXML
    private RadioButton removeIT;

    @FXML
    private ToggleGroup departmentRemove;

    @FXML
    private RadioButton removeCS;

    @FXML
    private RadioButton removeECE;

    @FXML
    private TextField dateRemoveText;

    @FXML
    private TextField nameRemoveText;

    @FXML
    private Button setButton;

    @FXML
    private Button setSubmit;

    @FXML
    private RadioButton setIT;

    @FXML
    private ToggleGroup departmentSet;

    @FXML
    private RadioButton setCS;

    @FXML
    private RadioButton setECE;

    @FXML
    private TextField dateSetText;

    @FXML
    private TextField nameSetText;

    @FXML
    private TextField hoursSetText;

    @FXML
    private Button computeButton;

    @FXML
    private Button phButton;

    @FXML
    private Button pdButton;

    @FXML
    private Button paButton;

    @FXML
    private Button importButton;

    @FXML
    private Button exportButton;

    @FXML
    private TextArea phpdpaTextArea;


    private void enableAdd(){
        addSubmit.setDisable(false);
        removeSubmit.setDisable(true);
        setSubmit.setDisable(true);
        addCS.setDisable(false);
        removeCS.setDisable(true);
        setCS.setDisable(true);
        addIT.setDisable(false);
        removeIT.setDisable(true);
        setIT.setDisable(true);
        addECE.setDisable(false);
        removeECE.setDisable(true);
        setECE.setDisable(true);
        partTime.setDisable(false);
        fullTime.setDisable(false);
        management.setDisable(false);
        dateAddText.setDisable(false);
        dateRemoveText.setDisable(true);
        dateSetText.setDisable(true);
        nameAddText.setDisable(false);
        nameRemoveText.setDisable(true);
        nameSetText.setDisable(true);
        hourlyAddText.setDisable(false);
        annualAddText.setDisable(false);
        codeAddText.setDisable(false);
        hoursSetText.setDisable(true);
    }
    private void enableRemove(){
        addSubmit.setDisable(true);
        removeSubmit.setDisable(false);
        setSubmit.setDisable(true);
        addCS.setDisable(true);
        removeCS.setDisable(false);
        setCS.setDisable(true);
        addIT.setDisable(true);
        removeIT.setDisable(false);
        setIT.setDisable(true);
        addECE.setDisable(true);
        removeECE.setDisable(false);
        setECE.setDisable(true);
        partTime.setDisable(true);
        fullTime.setDisable(true);
        management.setDisable(true);
        dateAddText.setDisable(true);
        dateRemoveText.setDisable(false);
        dateSetText.setDisable(true);
        nameAddText.setDisable(true);
        nameRemoveText.setDisable(false);
        nameSetText.setDisable(true);
        hourlyAddText.setDisable(true);
        annualAddText.setDisable(true);
        codeAddText.setDisable(true);
        hoursSetText.setDisable(true);
    }
    private void enableSet(){
        addSubmit.setDisable(true);
        removeSubmit.setDisable(true);
        setSubmit.setDisable(false);
        addCS.setDisable(true);
        removeCS.setDisable(true);
        setCS.setDisable(false);
        addIT.setDisable(true);
        removeIT.setDisable(true);
        setIT.setDisable(false);
        addECE.setDisable(true);
        removeECE.setDisable(true);
        setECE.setDisable(false);
        partTime.setDisable(true);
        fullTime.setDisable(true);
        management.setDisable(true);
        dateAddText.setDisable(true);
        dateRemoveText.setDisable(true);
        dateSetText.setDisable(false);
        nameAddText.setDisable(true);
        nameRemoveText.setDisable(true);
        nameSetText.setDisable(false);
        hourlyAddText.setDisable(true);
        annualAddText.setDisable(true);
        codeAddText.setDisable(true);
        hoursSetText.setDisable(false);
    }
    @FXML
    void addFreeze(ActionEvent event) {
        try {
            enableAdd();
        }
        //Show the error message with a pop-up window.
        catch (NumberFormatException e) {
            //SOMETIN
        }
    }

    @FXML
    void addSubmit(ActionEvent event) {

    }

    @FXML
    void displayPA(ActionEvent event) {

    }

    @FXML
    void displayPD(ActionEvent event) {

    }

    @FXML
    void displayPH(ActionEvent event) {

    }

    @FXML
    void exportToFile(ActionEvent event) {

    }

    @FXML
    void importFromFile(ActionEvent event) {

    }

    @FXML
    void removeFreeze(ActionEvent event) {
        try {
            enableRemove();
        }
        //Show the error message with a pop-up window.
        catch (NumberFormatException e) {
            //SOMETIN
        }
    }

    @FXML
    void removeSubmit(ActionEvent event) {

    }

    @FXML
    void setFreeze(ActionEvent event) {
        try {
            enableSet();
        }
        //Show the error message with a pop-up window.
        catch (NumberFormatException e) {
            //SOMETIN
        }
    }

    @FXML
    void setSubmit(ActionEvent event) {

    }

}
