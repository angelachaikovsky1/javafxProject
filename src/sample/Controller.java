package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import javafx.event.ActionEvent;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class Controller {
    private Company company = new Company();

    final static int MANAGER = 1;
    final static int DHEAD = 2;
    final static int DIRECTOR = 3;
    final static int MAXHOURS = 100;
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
    private TextArea generalTextArea;


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
        generalTextArea.clear();

        RadioButton selectedRadioButton = (RadioButton) employeeGroup.getSelectedToggle();
        String employeeType = selectedRadioButton.getText();

        selectedRadioButton = (RadioButton) departmentAdd.getSelectedToggle();
        String departAdd = selectedRadioButton.getText();
        String date = dateAddText.getText();
        String name = nameAddText.getText();

        double hourly = 0.0;
        double annual = 0.0;
        int code = 0;

        if(employeeType.equals("Part time")){
            hourly = Double.parseDouble(hourlyAddText.getText());
        }else if(employeeType.equals("Full time")){
            annual = Double.parseDouble(annualAddText.getText());
        }else if(employeeType.equals("Management")){
            annual = Double.parseDouble(annualAddText.getText());
            code = Integer.parseInt(codeAddText.getText());
        }else{
            //fuck ?
        }
        

        if(employeeType.equals("Part time")){
            if(isValidPay(hourly, "AP") && isValidDate(date)){
                Profile newEmployeeProfile = profileData(name, departAdd, date);
                Employee newEmployee = new Parttime(newEmployeeProfile, hourly);
                boolean wasParttimeAdded = company.add(newEmployee);
                if(wasParttimeAdded){
                    generalTextArea.appendText("Employee added.");
                }else{
                    generalTextArea.appendText("Employee is already in the list.");
                }
            }
        }else if(employeeType.equals("Full time")){
            if(isValidPay(annual, "AF") && isValidDate(date)) {
                Profile newEmployeeProfile = profileData(name, departAdd, date);
                Employee newEmployee = new Fulltime(newEmployeeProfile, annual);
                boolean wasFulltimeAdded = company.add(newEmployee);
                if (wasFulltimeAdded) {
                    generalTextArea.appendText("Employee added.");
                } else {
                    generalTextArea.appendText("Employee is already in the list.");
                }
            }
        }else {
            if (isValidPay(annual, "AF") && isValidDate(date) && isValidRole(code)){
                Profile newEmployeeProfile = profileData(name, departAdd, date);
                Employee newEmployee = new Management(newEmployeeProfile, annual, code);
                boolean wasManagementAdded = company.add(newEmployee);
                if (wasManagementAdded) {
                    generalTextArea.appendText("Employee added.");
                } else {
                    generalTextArea.appendText("Employee is already in the list.");
                }
            }
        }
    }
    /**
     * The isValidRole method verifies that the management code is a valid number
     * @param number a management code (1-3 inclusive)
     * @return true if the code is one of the three
     */
    private boolean isValidRole(int number){
        boolean isValid = false;
        if(number == MANAGER || number == DHEAD || number == DIRECTOR){
            isValid = true;
        }else{
            generalTextArea.appendText("Invalid management code.");
        }
        return isValid;
    }

    /**
     * The isValidcode method takes in a department code and verifies that the code
     * is one of 3 possible strings
     * @param pay either the hourly wage or yearly salary
     * @param keyCommand determines if the person is full time or not
     * @return true if the command is one of the possible codes
     */
    private boolean isValidPay(double pay, String keyCommand){
        boolean isValid = false;
        if(pay >= 0){
            isValid = true;
        }else if(keyCommand.equals("AP")){
            generalTextArea.appendText("Pay rate cannot be negative.");
        }else{
            generalTextArea.appendText("Salary cannot be negative.");
        }
        return isValid;
    }

    /**
     * The isValidDate method makes sure the date is valid by creating a date object
     * to test the input string against.
     * @param date the input date by the user
     * @return true if the date is valid
     */
    private boolean isValidDate(String date){
        Date inputDate = new Date(date);
        boolean isValid = false;
        if(inputDate.isValid()){
            isValid = true;
        }else{
            generalTextArea.appendText(date + " is not a valid date!");
        }
        return isValid;
    }

    /**
     * The isValidHours makes sure that the hours inputted cannot be negative or over 100
     * @param hours the number of hours inputted by the user
     * @return true if the hours are not above 100 and are not negative
     */
    private boolean isValidHours(int hours){
        boolean isValid = false;
        if(hours < 0){
            generalTextArea.appendText("Working hours cannot be negative.");
        }else if(hours > MAXHOURS){
            generalTextArea.appendText("Invalid hours: over 100.");
        }else{
            isValid = true;
        }
        return isValid;
    }

    /**
     * Creates a profile object given the necessary input
     * @param name name of a person
     * @param department the department of a person
     * @param dateHired the date the person was hired
     * @return the object created
     */
    private Profile profileData(String name, String department, String dateHired){
        Date dateHiredObject = new Date(dateHired);
        Profile newEmployeeProfile = new Profile(name, department, dateHiredObject);
        return newEmployeeProfile;
    }

    @FXML
    void disableAnnualCode(ActionEvent event) {
        annualAddText.setDisable(true);
        codeAddText.setDisable(true);
        hourlyAddText.setDisable(false);
    }

    @FXML
    void disableHourly(ActionEvent event) {
        annualAddText.setDisable(false);
        codeAddText.setDisable(false);
        hourlyAddText.setDisable(true);
    }

    @FXML
    void disableHourlyCode(ActionEvent event) {
        annualAddText.setDisable(false);
        codeAddText.setDisable(true);
        hourlyAddText.setDisable(true);
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
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Open Target File for the Export");
        chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                new FileChooser.ExtensionFilter("All Files", "*.*"));
        Stage stage = new Stage();
        File targeFile = chooser.showSaveDialog(stage); //get the reference of the target file
        //write code to write to the file.
    }

    @FXML
    void importFromFile(ActionEvent event) {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Open Source File for the Import");
        chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                new FileChooser.ExtensionFilter("All Files", "*.*"));
        Stage stage = new Stage();
        File sourceFile = chooser.showOpenDialog(stage); //get the reference of the source file
        //write code to read from the file.
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
