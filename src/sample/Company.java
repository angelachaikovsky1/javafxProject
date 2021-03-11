package sample;
/**
 * The Company class acts like a employee database and management system for all the Employee objects. It is responsible
 * for allocating more space as more employees are added, removing employees, setting the hours of part time Employees,
 * and also processing the payments of all the Employees. It also has the ability of displaying the Employees in the
 * order that they are currently stored and also sorting and displaying Employees by the date they were hired and the
 * department they work in.
 * @author Hemanthvarma Bhupatiraju, Angela Chaikovsky
 */
public class Company {
    private Employee[] emplist;
    private int numEmployee;

    /**
     * Initializes the employee database with an initial size of 4 and sets the initial number of employees in the
     * database to 0.
     */
    public Company(){
        this.numEmployee = 0;
        emplist = new Employee[4];
    }

    /**
     * Gets the number of employees currently in the database
     * @return the number of employees currently in the database
     */
    public int getNumEmployee() {
        return this.numEmployee;
    }

    /**
     * Tries to find the inputted employee and checks to see if it exists in the database already
     * @param employee an employee compromised of just a Profile to be compared
     * @return the index of the desired Employee, otherwise if not found, the length of emplist[]
     */
    private int find(Employee employee) {
        int i;
        for (i = 0; i < emplist.length; i++) {
            if(emplist[i] == null){
                continue;
            }
            if (emplist[i].equals(employee)) {
                break;
            }
        }
        return i;
    }

    /**
     * Increases the capacity of the database by 4
     */
    private void grow() {
        Employee[] expandedBooks  = new Employee[emplist.length+4];
        for(int i = 0; i < emplist.length; i++){
            expandedBooks[i] = emplist[i];
        }
        emplist = expandedBooks;
    }

    /**
     * Adds the new Employee to the first available spot in the database. If the database is full, then increase the
     * capacity of the database and add the new Employee to the first of 4 newly created spots.
     * @param employee the Employee object that needs to be added to the database
     * @return true if the employee was successfully added or false otherwise
     */
    public boolean add(Employee employee) {
        int alreadyExistsIndex = find(employee);
        if(alreadyExistsIndex < emplist.length){
            return false;
        }
        int i;
        for(i = 0; i < emplist.length; i++){
            if(emplist[i] == null){
                emplist[i] = employee;
                break;
            }
        }
        if(i == emplist.length){
            grow();
            emplist[i] = employee;
        }
        numEmployee++;
        return true;
    } //check the profile before adding

    /**
     * Removes the desired employee from the database if they are found.
     * @param employee the Employee object consisting of just a profile to be removed
     * @return true if the employee was successfully removed or false otherwise
     */
    public boolean remove(Employee employee) {
        int employeeToBeRemovedIndex = find(employee);
        if(employeeToBeRemovedIndex == emplist.length){
            return false;
        }else{
            emplist[employeeToBeRemovedIndex] = null;
            numEmployee--;
            return true;
        }
    } //maintain the original sequence

    /**
     * Sets the working hours for a part time employee
     * @param employee the Employee object consisting of just a profile to be used to find within the database so the
     *                 hours can be set
     * @return true if the hours of the desired employee was successfully set and false otherwise
     */
    public boolean setHours(Employee employee) {
        int employeeToSetHoursIndex = find(employee);
        if(employeeToSetHoursIndex == emplist.length){
            return false;
        }else{
            if(emplist[employeeToSetHoursIndex] instanceof Parttime && employee instanceof Parttime){
                Parttime tempEmployee = (Parttime)emplist[employeeToSetHoursIndex];
                Parttime tempEmployee2 = (Parttime)employee;
                tempEmployee.setHours(tempEmployee2.getHours());
                return true;
            }else{
                return false;
            }
        }
    }

    /**
     * Processes the payments of all the employees
     */
    public void processPayments() {
        for(Employee employee : emplist){
            if(employee != null){
                employee.calculatePayment();
            }
       }
        return;
    }

    /**
     * Prints the string representation of the employees in the database
     * @param printString the String that holds the string representations of all the employees
     * @return a string containing the string representations of the all the employees in the database
     */
    private String printEmployees(String printString){
        for(Employee employee : emplist){
            if(employee != null){
                printString += employee.toString() + "\n";
            }
        }
        return printString;
    }

    /**
     * Returns a list of the employees in the database. If the database is empty, returns a statement acknowledging that.
     * @return a String containing a list of all the employees in the database or a statement acknowledging that it is
     * empty
     */
    public String print() {
        String printString = "";
       if(numEmployee == 0){
            printString = "Employee database is empty.";
            return printString;
        }
       printString = "--Printing earning statements for all employees--\n";
       printString = printEmployees(printString);
       return printString;
    }

    /**
     * Returns a list of the employees in the database sorted by department. If the database is empty, returns a statement
     * acknowledging that.
     * @return a String containing a list of all the employees in the database sorted by department or a statement
     * acknowledging that it is empty
     */
    public String printByDepartment() {
        String printStringDep = "";
        if(numEmployee == 0){
            printStringDep = "Employee database is empty.";
            return printStringDep;
        }

        printStringDep = "--Printing earning statements by department--\n";
        sortDepartment();
        printStringDep = printEmployees(printStringDep);
        return printStringDep;
    }

    /**
     * Returns a list of the employees in the database sorted by the date. If the database is empty, a returns statement
     * acknowledging that.
     * @return a String containing a list of all the employees in the database sorted by date or a statement
     * acknowledging that it is empty
     */
    public String printByDate() {
        String printStringDate = "";
        if(numEmployee == 0){
            printStringDate = "Employee database is empty.";
            return printStringDate;
        }

        printStringDate = "--Printing earning statements by date hired--\n";
        sortDate();
        printStringDate = printEmployees(printStringDate);
        return printStringDate;
    }

    /**
     * Sorts the employee database by the departments alphabetically
     */
    private void sortDepartment() {
        int employeeListLength = emplist.length;
        for (int i = 0; i < employeeListLength - 1; i++) {
            int minimumIndex = i;
            for (int j = i + 1; j < employeeListLength; j++) {
                Employee earlierDepartmentEmployee = earlierDepartment(emplist[j], emplist[minimumIndex]);
                if (emplist[j] == earlierDepartmentEmployee) {
                    minimumIndex = j;
                }
            }
            // Swap the found minimum element with the first
            // element
            Employee temp = emplist[minimumIndex];
            emplist[minimumIndex] = emplist[i];
            emplist[i] = temp;
        }
    }

    /**
     * Compares the departments of two employees and returns the employee whose department is earlier alphabetically
     * @param employeeOne one of the two employees to be compared
     * @param employeeTwo second of the two employees to be compared
     * @return the employee whose department is earlier alphabetically
     */
    private Employee earlierDepartment(Employee employeeOne, Employee employeeTwo) {
        if (employeeOne == null) {
            return employeeOne;
        } else if (employeeTwo == null) {
            return employeeTwo;
        }
        String employeeOneDepartment = employeeOne.getEmployeeDepartment();
        String employeeTwoDepartment = employeeTwo.getEmployeeDepartment();
        if (employeeOneDepartment.compareTo(employeeTwoDepartment) <= 0) {
            return employeeOne;
        } else {
            return employeeTwo;
        }
    }

    /**
     * Sorts the employees by their date hired ascending
     */
    private void sortDate() {
        int libraryLength = emplist.length;
        for (int i = 0; i < libraryLength - 1; i++) {
            int minimumIndex = i;
            for (int j = i + 1; j < libraryLength; j++) {
                Employee earliestBook = earlierHiredEmployee(emplist[j], emplist[minimumIndex]);
                if (emplist[j] == earliestBook) {
                    minimumIndex = j;
                }
            }
            Employee temp = emplist[minimumIndex];
            emplist[minimumIndex] = emplist[i];
            emplist[i] = temp;
        }
    }

    /**
     * Compares two employees and returns the employee with the earlier date hired
     * @param employeeOne One of two employees to be compared
     * @param employeeTwo Second of two employees to be compared
     * @return the employee who had the earlier start date
     */
    private Employee earlierHiredEmployee(Employee employeeOne, Employee employeeTwo){
        if(employeeOne == null){
            return employeeOne;
        }else if(employeeTwo == null){
            return employeeTwo;
        }
        Date employeeOneDate = employeeOne.getDateHired();
        Date employeeTwoDate = employeeTwo.getDateHired();
        int comparedDateResult = employeeOneDate.compareTo(employeeTwoDate);
        if(comparedDateResult == 1){
            return employeeOne;
        }else{
            return employeeTwo;
        }
    }
}
