package sample;
/**
 * Represents a part-time employee and extends the Employee class and is initialized by a profile, employee type, pay,
 * and manager status. It contains a toString() method for creating the string representation of a part-time employee,
 * a .equals() method that can be used to compare two part-time employees, a method to calculate the total payments of
 * part-time employees, and also getters and setters for ease of use
 * @author Angela Chaikovsky, Hemanthvarma Bhupatiraju
 */
public class Parttime extends Employee{
    private int hours;
    private String hourlyPay;
    final static int MAXHOURS = 80;
    final static double OVERTIME = 1.5;

    /**
     * Inherits the constructor of the Employee class and initializes the parameters the same way
     * @param profile the profile object of the employee which includes the name, department, and the date hired
     * @param pay the hourly pay
     */
    public Parttime(Profile profile, double pay){
        super(profile);
        hourlyPay = super.payFormat(pay);
    }

    /**
     * Calculates the total payment due for the part-time employee
     */
    @Override
    public void calculatePayment() {
        String pay = hourlyPay;
        pay = super.puncRemoved(pay);
        double doublePay = Double.parseDouble(pay);
        double additionalPay = 0;
        int additionalhours = 0;
        int temphours = 0;
        if(this.hours > MAXHOURS){
           additionalhours = this.hours - MAXHOURS;
           temphours = this.hours - additionalhours;
        }else{
            temphours = this.hours;
        }
        additionalPay = additionalhours * doublePay * OVERTIME;
        double payDue = doublePay * temphours + additionalPay;
        String payDueString = super.payFormat(payDue);
        super.setPayDue(payDueString);
    }

    /**
     * Creates a string representation of the part-time employee
     * @return the string representation of the part-time employee
     */
    @Override
    public String toString(){
        String pay = hourlyPay;
        String printString = super.toString();
        printString = printString + "::PART TIME::Hourly Rate $";
        printString = printString + pay;
        printString = printString + "::Hours worked this period: " + this.hours;
        return printString;
    }

    /**
     * Checks if part-time employee has the same profile as another employee
     * @param obj will be overridden to be a employee object to be used for comparison
     * @return true if the they have the same profile and false otherwise
     */
    @Override
    public boolean equals(Object obj){
        boolean isEqual = false;
        if(super.equals(obj)){
            isEqual = true;
        }
        return isEqual;
    }

    /**
     * Gets the hours that the part-time employee worked
     * @return the hours the part-time employee worked
     */
    public int getHours(){
        return hours;
    }

    /**
     * Set the hours that part-time employee worked
     * @param hours the hours the part-time employee worked
     */
    public void setHours(int hours){
        this.hours = hours;
    }
}
