package sample;
/**
 * Embodies the structure of an fulltime employee object required for storing in the employee database which is initialized
 * by a profile, employee type, pay, and manager status. This class acts as a child class to the Employee
 * classes. It contains a toString() method for creating the string representation of a fulltime employee, a .equals() method
 * that can be used to compare two employees, methods to format the pay of an employee. The class reuses a lot of the
 * parent class functionality to reduce redundancy.
 * @author Angela Chaikovsky, Hemanthvarma Bhupatiraju
 */
public class Fulltime extends Employee{
    final static int PAYPERIOD = 26;

    /**
     * Initializes the global variables for the profile of the employee, the type of the employee, the pay of the
     * employee, the pay that is due for the employee, and also whether the employee is part of management or not
     * makes a call to the super class for initialization
     * @param profile the profile object of the employee which includes the name, department, and the date hired
     * @param pay the yearly pay of fulltime employees

     */
    public Fulltime(Profile profile, double pay){
        super(profile, pay);
    }

    /**
     * Method to calculate the payments of the employee which calculates the pay
     * specific to the fulltime employee status.
     */
    @Override
    public void calculatePayment() {
        String pay = super.getPay();
        pay = super.puncRemoved(pay);
        double doublePay = Double.parseDouble(pay);
        double payDue = doublePay / PAYPERIOD;
        String payDueString = super.payFormat(payDue);
        super.setPayDue(payDueString);
    }

    /**
     * Creates a string representation of the employee
     * by reusing the parent toString method and attaching
     * its own required output
     * @return the string representation of the full time employee
     */
    @Override
    public String toString(){
        String pay = super.getPay();
        String printString = super.toString();
        printString = printString + "::FULL TIME::Annual Salary $";
        printString = printString + pay;
        return printString;
    }

    /**
     * Checks whether two employees are equal to each other
     * @param obj will be overridden to be a employee object to be used for comparison
     * @return true if the employees have the same profiles and false otherwise, and are an employee
     */
    @Override
    public boolean equals(Object obj){
        boolean isEqual = false;
        if(super.equals(obj)){
            isEqual = true;
        }
        return isEqual;
    }
}
