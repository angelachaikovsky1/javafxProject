package sample;
import java.text.DecimalFormat;
/**
 * Embodies the structure of an employee object required for storing in the employee database which is initialized
 * by a profile, employee type, pay, and manager status. This class acts as a superclass to the Parttime and Fulltime
 * classes. It contains a toString() method for creating the string representation of an employee, a .equals() method
 * that can be used to compare two employees, methods to format the pay of an employee, and also various getters and
 * setters for ease of use and to give access to values of certain variables to outside classes.
 * @author Angela Chaikovsky, Hemanthvarma Bhupatiraju
 */
public class Employee {
    private Profile profile;
    private String pay;
    private String payDue;


    final static int STARTPAY = 0;

    /**
     * Initializes the global variables for the profile of the employee, the type of the employee, the pay of the
     * employee, the pay that is due for the employee, and also whether the employee is part of management or not
     * @param profile the profile object of the employee which includes the name, department, and the date hired
     * @param pay the yearly pay of fulltime employees or the hourly pay of parttime employees
     */
    public Employee(Profile profile, double pay){
        this.profile = profile;
        this.pay = payFormat(pay);
        this.payDue = payFormat(STARTPAY);

    }

    /**
     * Method to calculate the payments of the employee which is meant to be overridden
     */
    public void calculatePayment() {}

    /**
     * Removes the commas from the string representing the pay
     * @param payment the string representation of the pay
     * @return the string representation of the pay without the commas
     */
    public String puncRemoved(String payment){
        String result = "";
        for(int i = 0; i < payment.length(); i++){
            if(payment.charAt(i) != ','){
                result = result + payment.charAt(i);
            }
        }
        return result;
    }

    /**
     * Gets the pay that is due
     * @return the pay that is due
     */
    public String getPayDue(){
        return payDue;
    }

    /**
     * Gets the pay of the employee
     * @return the pay of the employee
     */
    public String getPay(){
        return pay;
    }

    /**
     * Sets the payment that is due
     * @param payDue the payment that is due which the global variable is set equal to
     */
    public void setPayDue(String payDue){
        this.payDue = payDue;
    }

    /**
     * Formats the double representation of the pay into the desired string format
     * @param pay the value of the pay due as a double
     * @return the pay due in the desired string format
     */
    public String payFormat(double pay){
        String pattern = "###,###,##0.00";
        DecimalFormat maxTwoDecimals = new DecimalFormat(pattern);
        return maxTwoDecimals.format(pay);
    }

    /**
     * Gets the department of the employee
     * @return the department of the employee
     */
    public String getEmployeeDepartment(){
        return profile.getDepartment();
    }

    /**
     * Gets the date the employee was hired
     * @return the date object representation of the date when the employee was hired
     */
    public Date getDateHired(){
        return profile.getDateHired();
    }

    /**
     * Creates a string representation of the employee
     * @return the string representation of the employee
     */
    @Override
    public String toString(){
        String printString = profile.toString();
        printString = printString + "Payment $";
        printString = printString + payDue;
        return printString;
    }

    /**
     * Checks whether two employees are equal to each other
     * @param obj will be overridden to be a employee object to be used for comparison
     * @return true if the employees have the same profiles and false otherwise and are an employee
     */
    @Override
    public boolean equals(Object obj){
        boolean isEqual = false;
        if(obj instanceof Employee){
            Employee person = (Employee)obj;
            if(this.profile.equals(person.profile)){
                isEqual = true;
            }
        }
        return isEqual;
    }
}