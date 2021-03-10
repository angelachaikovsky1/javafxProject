package sample;
/**
 * Embodies the structure of an fulltime management employee object required for storing in the employee database which
 * is initialized by a profile, employee type, pay, and manager status as well as the specific management role.
 * This class acts as a child class to the Fulltime and Employee classes. It contains a toString() method for creating the
 * string representation of a management employee, a .equals() method that can be used to compare two employees, methods
 * to format the pay of an employee. The class reuses a lot of the
 * parent class functionality to reduce redundancy.
 * @author Angela Chaikovsky, Hemanthvarma Bhupatiraju
 */
public class Management extends Fulltime{
    private int manageRole;
    private double compensation;

    final static int MANAGER = 1;
    final static int DHEAD = 2;

    //payment during each pay period, there is 26 per year
    final static double MANAGERPAY = 192.31;
    final static double DHEADPAY = 365.38;
    final static double DIRECTORPAY = 461.54;

    /**
     * Initializes the global variables for the profile of the employee, the type of the employee, the pay of the
     * employee, the pay that is due for the employee, and also whether the employee is part of management or not,
     * it also declares which role the management employee has.
     * makes a call to the super class for initialization
     * @param profile the profile object of the employee which includes the name, department, and the date hired
     * @param pay the yearly pay of fulltime employees
     * @param manageRole should be 1, 2, or 3 depending on what the role of the employee is
     */
    public Management(Profile profile,  double pay, int manageRole){
        super(profile,  pay);
        this.manageRole = manageRole;
        this.compensation = roleCompensation();
    }

    /**
     * Method to calculate the payments of the employee which calculates the pay
     * specific to the management fulltime employee status. It reuses some of the full time
     * calculatePayment() functionality but then adds additional pay due according to the
     * management position.
     */
    @Override
    public void calculatePayment() {
        super.calculatePayment();
        String payDueS = super.getPayDue();
        payDueS = super.puncRemoved(payDueS);
        double payDue = Double.parseDouble(payDueS) + this.compensation;
        String payDueString = super.payFormat(payDue);
        super.setPayDue(payDueString);
    }

    /**
     * Method to calculate the additional management compensation that is due according to the
     * management role.
     * @return the value of the additional compensation
     */
    private double roleCompensation(){
        double addPay;
        if(manageRole == MANAGER){
            addPay = MANAGERPAY;
        }else if(manageRole == DHEAD){
            addPay = DHEADPAY;
        }else{
            addPay = DIRECTORPAY;
        }
        return addPay;
    }

    /**
     * Creates a string representation of the employee
     * by reusing the parents' toString methods and attaching
     * its own additional required output
     * @return the string representation of the management full time employee
     */
    @Override
    public String toString(){
        String printString = super.toString();

        if(this.manageRole == MANAGER){
            printString = printString + "::Manager Compensation $" + MANAGERPAY;
        }else if(this.manageRole == DHEAD){
            printString = printString + "::DepartmentHead Compensation $" + DHEADPAY;
        }else{
            printString = printString + "::Director Compensation $" + DIRECTORPAY;
        }
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
