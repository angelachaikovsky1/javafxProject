package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

/**
 * Handles all the user input from the interface and acts as the backend for the interface the user is interacting with.
 * The class performs input validation to make sure the commands are properly formatted and complete. After
 * preprocessing, the Controller class funnels the input into corresponding blocks of logic.
 * @author Angela Chaikovsky, Hemanthvarma Bhupatiraju
 */
public class Controller {
    private Company company = new Company();

    final static int ADDMANAGECOMMANDS = 6;
    final static int ADDPARTFULLCOMMANDS = 5;
    final static int OTHEREXPECTEDCOMMANDS = 4;
    final static int MANAGER = 1;
    final static int DHEAD = 2;
    final static int DIRECTOR = 3;
    final static int MAXHOURS = 100;

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
    private RadioButton managerRadio;

    @FXML
    private ToggleGroup codeGroup;

    @FXML
    private RadioButton dHeadRadio;

    @FXML
    private RadioButton directorRadio;

    //@FXML
    //private TextField codeAddText;

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
    private TextArea generalTextArea;

    /**
     * Enables all fields necessary for adding an employee and disables all the other fields.
     */
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
        managerRadio.setDisable(false);
        dHeadRadio.setDisable(false);
        directorRadio.setDisable(false);
        //codeAddText.setDisable(false);
        hoursSetText.setDisable(true);
    }

    /**
     * Enables all fields necessary for removing an employee and disables all other fields.
     */
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
        managerRadio.setDisable(true);
        dHeadRadio.setDisable(true);
        directorRadio.setDisable(true);
        //codeAddText.setDisable(true);
        hoursSetText.setDisable(true);
    }

    /**
     * Enables all fields necessary for removing an employee and disables all other fields.
     */
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
        managerRadio.setDisable(true);
        dHeadRadio.setDisable(true);
        directorRadio.setDisable(true);
        //codeAddText.setDisable(true);
        hoursSetText.setDisable(false);
    }

    /**
     * Clears the text area and all the fields and enables the fields necessary for adding while disabling all others.
     */
    @FXML
    void addFreeze() {
        generalTextArea.clear();
        clearEverything();
        enableAdd();
    }

    /**
     * Clears the text area and attempts to add a new employee using the data inputted from the interface. Outputs
     * a descriptive error message if there is anything wrong with the input. Otherwise, a message indicating that
     * adding the employee to the database was successful is show in the text area.
     */
    @FXML
    void addSubmit() {
        generalTextArea.clear();
        RadioButton selectedRadioButton;
        String employeeType;
        String departAdd;

        try{
            selectedRadioButton = (RadioButton) employeeGroup.getSelectedToggle();
            employeeType = selectedRadioButton.getText();
        }catch(NullPointerException e){
            generalTextArea.appendText("Please select an employee type.");
            return;
        }
        try{
            selectedRadioButton = (RadioButton) departmentAdd.getSelectedToggle();
            departAdd = selectedRadioButton.getText();
        }catch(NullPointerException e){
            generalTextArea.appendText("Please select a department.");
            return;
        }


        String date = dateAddText.getText();
        String name = nameAddText.getText();
        if(name.length() == 0){
            generalTextArea.appendText("The name field was left blank. Please enter a name! \n");
            return;
        }
        if(!isParse(date)){
            return;
        }

        double hourly = 0.0;
        double annual = 0.0;
        int code = 0;

        if(employeeType.equals("Part time")){
            try{
                hourly = Double.parseDouble(hourlyAddText.getText());
            }catch(NumberFormatException e){
                generalTextArea.appendText("Please enter a valid number for the hourly pay.\n");
                hourlyAddText.clear();
                return;
            }

        }else if(employeeType.equals("Full time")){
            try{
                annual = Double.parseDouble(annualAddText.getText());
            }catch(NumberFormatException e){
                generalTextArea.appendText("Please enter a valid number for the annual pay.\n");
                annualAddText.clear();
                return;
            }
        }else {
            try{
                annual = Double.parseDouble(annualAddText.getText());
            }catch(NumberFormatException e){
                generalTextArea.appendText("Please enter a valid number for the annual pay.\n");
                annualAddText.clear();
                return;
            }

            String codeString;
            try{
                selectedRadioButton = (RadioButton) codeGroup.getSelectedToggle();
                codeString = selectedRadioButton.getText();
            }catch(NullPointerException e){
                generalTextArea.appendText("Please select a management code");
                return;
            }

            if(codeString.equals("Manager(1)")){
                code = 1;
            }else if(codeString.equals("Dep. Head(2)")){
                code = 2;
            }else{
                code = 3;
            }
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
        clearEverything();
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
            generalTextArea.appendText("Invalid management code.\n");
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
            generalTextArea.appendText("Pay rate cannot be negative.\n");
        }else{
            generalTextArea.appendText("Salary cannot be negative.\n");
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

        if (inputDate.isValid()) {
             isValid = true;
        }else{
            generalTextArea.appendText(date + " is not a valid date!\n");
        }
        return isValid;
    }

    /**
     * Checks if the Date class can parse through the input for the Date field. Any exceptions that may be caused by that
     * are handled here and an appropriate message is outputted if an exception thrown. Otherwise, if the date can be
     * parsed, true is returned.
     * @param date the string representation of the date input
     * @return true if the Date class can parsed the date input and false otherwise
     */
    private boolean isParse(String date){
        boolean isParseble = false;
        try{
            String[] parsedDate = date.split("/");
            Integer.parseInt(parsedDate[0]);
            Integer.parseInt(parsedDate[1]);
            Integer.parseInt(parsedDate[2]);
            isParseble = true;
        }catch(NumberFormatException | ArrayIndexOutOfBoundsException e){
            generalTextArea.appendText("Please enter a valid date! Use the following format: mm/dd/yyyy. \n");
            dateRemoveText.clear();
            dateAddText.clear();
            dateSetText.clear();
        }
        return isParseble;
    }

    /**
     * The isValidHours makes sure that the hours inputted cannot be negative or over 100
     * @param hours the number of hours inputted by the user
     * @return true if the hours are not above 100 and are not negative
     */
    private boolean isValidHours(int hours){
        boolean isValid = false;
        if(hours < 0){
            generalTextArea.appendText("Working hours cannot be negative.\n");
        }else if(hours > MAXHOURS){
            generalTextArea.appendText("Invalid hours: over 100.\n");
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

    /**
     * Disables the Management Code options and also the Annual Salary field.
     */
    @FXML
    void disableAnnualCode() {
        annualAddText.setDisable(true);
        managerRadio.setDisable(true);
        dHeadRadio.setDisable(true);
        directorRadio.setDisable(true);
        hourlyAddText.setDisable(false);
    }

    /**
     * the disableHourly() function is responsible for disabling the appropriate fields upon
     * a "management" employee being selected.
     */
    @FXML
    void disableHourly() {
        annualAddText.setDisable(false);
        managerRadio.setDisable(false);
        dHeadRadio.setDisable(false);
        directorRadio.setDisable(false);
        hourlyAddText.setDisable(true);
    }

    /**
     * the disableHourlyCode() function is responsible for disabling the appropriate fields
     * upon a "full time" employee being selected
     */
    @FXML
    void disableHourlyCode() {
        annualAddText.setDisable(false);
        managerRadio.setDisable(true);
        dHeadRadio.setDisable(true);
        directorRadio.setDisable(true);
        hourlyAddText.setDisable(true);
    }

    /**
     * The displayPH() function will display the company employees in particular order
     */
    @FXML
    void displayPA() {
        generalTextArea.clear();
        clearEverything();
        String employeeListPA = company.print();
        generalTextArea.appendText(employeeListPA);

    }

    /**
     * The displayPD() function will display the company employees in order of department sorting
     */
    @FXML
    void displayPD() {
        generalTextArea.clear();
        clearEverything();
        String employeeListPD = company.printByDepartment();
        generalTextArea.appendText(employeeListPD);
    }

    /**
     * The displayPH() function will display the company employees in order of date sorting
     */
    @FXML
    void displayPH() {
        generalTextArea.clear();
        clearEverything();
        String employeeListPH = company.printByDate();
        generalTextArea.appendText(employeeListPH);

    }

    /**
     * The exportToFile() function is executed upon the user clicking the "export" button on the UI. The
     * function will manage the exportation of the entire company database into a file of the user's choice and if
     * the database is empty it will output a corresponding message into the text area.
     */
    @FXML
    void exportToFile() {
        generalTextArea.clear();
        clearEverything();

        try{
            FileChooser chooser = new FileChooser();
            chooser.setTitle("Open Target File for the Export");
            chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
            Stage stage = new Stage();
            File targetFile = chooser.showSaveDialog(stage); //get the reference of the target file

            Writer wr = new FileWriter(targetFile);
            String exportDatabaseResult = company.exportDataBase();
            if(exportDatabaseResult.equals("Employee database is empty.")){
                generalTextArea.appendText("Employee database is empty. Export did not occur.");
                wr.flush();
                wr.close();
                return;
            }
            wr.write(exportDatabaseResult);
            wr.flush();
            wr.close();
        }catch (IOException | NullPointerException e) {
            generalTextArea.appendText("There was an error with accessing your export file. Please try with a valid file. \n");
            return;
        }
    }

    /**
     * The importFromFile() function is executed upon the user clicking "import" on the UI. The function will
     * prompt the user to select a file for import into the project and will output a corresponding success or failure message.
     */
    @FXML
    void importFromFile() {
        generalTextArea.clear();
        clearEverything();

        try {
            FileChooser chooser = new FileChooser();
            chooser.setTitle("Open Source File for the Import");
            chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
            Stage stage = new Stage();
            File sourceFile = chooser.showOpenDialog(stage); //get the reference of the source file
            Scanner input = new Scanner(sourceFile);

            while (input.hasNextLine()) {
                String line = input.nextLine();
                handleImportLines(line);
            }
            input.close();

        } catch (IOException | NullPointerException ex) {
            generalTextArea.appendText("There was an error with accessing your imported file. Please try with a valid file. \n");
            return;
        }
        generalTextArea.appendText("Successfully imported database");
    }

    /**
     * the removeFreeze() function is responsible for freezing "add" and "set" functionalities
     * if a user clicks "remove"
     */
    @FXML
    void removeFreeze() {
        generalTextArea.clear();
        clearEverything();
        enableRemove();
    }

    /**
     * The removeSubmit() method executes when a user clicks "submit" under the "remove" button
     * it is responsible for taking in the user selections and outputting a success or failure message
     * depending on the inputs.
     */
    @FXML
    void removeSubmit() {
        generalTextArea.clear();

        RadioButton selectedRadioButton;
        String departRemove;
        try{
            selectedRadioButton = (RadioButton) departmentRemove.getSelectedToggle();
            departRemove = selectedRadioButton.getText();
        }catch(NullPointerException e){
            generalTextArea.appendText("Please select a department.");
            return;
        }

        String date = dateRemoveText.getText();
        if(!isParse(date)){
            return;
        }
        String name = nameRemoveText.getText();
        if(name.length() == 0){
            generalTextArea.appendText("The name field was left blank. Please enter a name! \n");
            return;
        }
        int tempPay = 0;
        Profile newEmployeeProfile = profileData(name, departRemove, date);
        Employee employeeToBeRemoved = new Fulltime(newEmployeeProfile, tempPay);
        boolean wasEmployeeRemoved = company.remove(employeeToBeRemoved);
        if (wasEmployeeRemoved) {
            generalTextArea.appendText("Employee removed.");
        }else if (company.getNumEmployee() == 0){
            generalTextArea.appendText("Employee database is empty.");
        }else{
            generalTextArea.appendText("Employee does not exist.");
        }
        clearEverything();
    }

    /**
     * the computePayment() function is executed when a user clicks on the "compute payment" button
     * and outputs a success message or states that the database is empty
     */
    @FXML
    void computePayment() {
        generalTextArea.clear();
        clearEverything();
        if(company.getNumEmployee()==0){
            generalTextArea.appendText("Employee database is empty.");
        }else {
            company.processPayments();
            generalTextArea.appendText("Calculation of employee payments is done.");
        }
    }

    /**
     * The setFreeze() function executes when someone clicks the "set" button
     * to ensure that "add" and "remove" functionalities are disabled
     */
    @FXML
    void setFreeze() {
        generalTextArea.clear();
        clearEverything();
        enableSet();

    }

    /**
     * The clearEverything() function is called at multiple places
     * throughout the program to ensure that on certain clicks, that the
     * entire form is cleared (except the text area)
     */
    private void clearEverything(){
        partTime.setSelected(false);
        fullTime.setSelected(false);
        management.setSelected(false);
        addIT.setSelected(false);
        addCS.setSelected(false);
        addECE.setSelected(false);
        dateAddText.clear();
        nameAddText.clear();
        hourlyAddText.clear();
        annualAddText.clear();
        managerRadio.setSelected(false);
        dHeadRadio.setSelected(false);
        directorRadio.setSelected(false);

        removeCS.setSelected(false);
        removeECE.setSelected(false);
        removeIT.setSelected(false);
        dateRemoveText.clear();
        nameRemoveText.clear();

        setCS.setSelected(false);
        setECE.setSelected(false);
        setIT.setSelected(false);
        dateSetText.clear();
        nameSetText.clear();
        hoursSetText.clear();

    }

    /**
     * Upon a use pressing "submit" under "set" the program will try to set the hours
     * listed by the user after finding a corresponding employee.
     */
    @FXML
    void setSubmit() {
        generalTextArea.clear();

        RadioButton selectedRadioButton;
        String departSet;
        try{
            selectedRadioButton = (RadioButton) departmentSet.getSelectedToggle();
            departSet = selectedRadioButton.getText();
        }catch(NullPointerException e){
            generalTextArea.appendText("Please select a department.");
            return;
        }

        String date = dateSetText.getText();
        if(!isParse(date)){
            return;
        }
        String name = nameSetText.getText();
        if(name.length() == 0){
            generalTextArea.appendText("The name field was left blank. Please enter a name! \n");
            return;
        }
        int hours = 0;
        try {
            hours = Integer.parseInt(hoursSetText.getText());
        }catch(NumberFormatException e){
            generalTextArea.appendText("Please enter a valid number for the hours! \n");
            hoursSetText.clear();
            return;
        }
        int tempPay = 0;
        if(isValidHours(hours) && isValidDate(date)){
            Profile newEmployeeProfile = profileData(name, departSet, date);
            Employee employeeHoursSet = new Parttime(newEmployeeProfile, tempPay);
            Parttime tempEmployee = (Parttime)employeeHoursSet;
            tempEmployee.setHours(hours);
            boolean wasEmployeeHoursSet = company.setHours(employeeHoursSet);
            if(wasEmployeeHoursSet){
                generalTextArea.appendText("Working hours set.");
            }else if (company.getNumEmployee() == 0){
                generalTextArea.appendText("Employee database is empty.");
            }else{
                generalTextArea.appendText("Employee does not exist.");
            }


        }
        clearEverything();

    }

    /**
     * The handleImportLines function is responsible for the payroll processing
     * type functionality upon importing a valid database .txt file.
     * @param inputLineString represents each line of the .txt file to be processed
     */
    private void handleImportLines(String inputLineString ){
        String [] splitInputLine = inputLineString.split(",");
        String command = splitInputLine[0];
        String name = "";
        String date = "";
        String department = "";

        double pay = 0;
        int role = 0;

        if(splitInputLine.length == ADDPARTFULLCOMMANDS){
            name = splitInputLine[1];
            department = splitInputLine[2];
            date = splitInputLine[3];
            pay = Double.parseDouble(splitInputLine[4]);

        }else if(splitInputLine.length == ADDMANAGECOMMANDS){
            name = splitInputLine[1];
            department = splitInputLine[2];
            date = splitInputLine[3];
            pay = Double.parseDouble(splitInputLine[4]);
            role = Integer.parseInt(splitInputLine[5]);
        }else if(splitInputLine.length == OTHEREXPECTEDCOMMANDS){
            name = splitInputLine[1];
            department = splitInputLine[2];
            date = splitInputLine[3];
        }

        if(command.equals("P")){
            Profile newEmployeeProfile = profileData(name, department, date);
            Employee newEmployee = new Parttime(newEmployeeProfile, pay);
            company.add(newEmployee);
        }else if(command.equals("F")){
            Profile newEmployeeProfile = profileData(name, department, date);
            Employee newEmployee = new Fulltime(newEmployeeProfile, pay);
            company.add(newEmployee);
        }else if(command.equals("M")){
            Profile newEmployeeProfile = profileData(name, department, date);
            Employee newEmployee = new Management(newEmployeeProfile, pay, role);
            company.add(newEmployee);
        }
    }
}
