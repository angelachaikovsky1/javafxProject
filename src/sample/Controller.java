package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;

public class Controller {


    @FXML
    private Pane paneTest;

    @FXML
    private RadioButton partTime;

    @FXML
    private ToggleGroup test;

    @FXML
    private RadioButton fullTIme;

    @FXML
    private RadioButton management;

    @FXML
    private ToggleGroup dep;

    @FXML
    private Button submit;

    @FXML
    void setEmployeeType(ActionEvent event) {
        //messageArea.clear(); //clear the TextArea.
        try {
            RadioButton selectedRadioButton = (RadioButton) test.getSelectedToggle();
            String toggleGroupValue = selectedRadioButton.getText();
            fullTIme.setDisable(true);
            if(toggleGroupValue.equals("management")){
                submit.setDisable(true);
            }
        }
        //Show the error message with a pop-up window.
        catch (NumberFormatException e) {
            //error idk waht yet
        }
    }

}
