package sample;
/**
 * The Profile class is used to store important data about each employee. This data includes the name of the employee,
 * the department the employee works in, and also the date they were hired. The class includes a toString() method to be
 * able to express an employees profile as a String and a .equals() method to compare the profiles of two employees.
 * Getter methods are also included to allow access to certain values from other classes.
 * @author Angela Chaikovsky, Hemanthvarma Bhupatiraju
 */
public class Profile {
    private String name;
    private String department;
    private Date dateHired;

    /**
     * Initializes the global variables for the name of the employee, the department the employee works in, and also
     * the date that the employee was hired.
     * @param name is the name of the employee
     * @param department is the department the employee works in
     * @param dateHired is the date object of the date that the employee was hired
     */
    public Profile(String name, String department, Date dateHired){
        this.name = name;
        this.department = department;
        this.dateHired = dateHired;
    }

    /**
     * Creates the string representation of a employee's profile.
     * @return the string representation of the employee's profile
     */
    @Override
    public String toString() {
        String printString = "";
        printString = printString + this.name + "::";
        printString = printString + this.department + "::";
        printString = printString + this.dateHired.getMonth() + "/";
        printString = printString + this.dateHired.getDay() + "/";
        printString = printString + this.dateHired.getYear() + "::";
        return printString;
    }

    /**
     * Checks whether the profile of two employees are equal to each other.
     * @param obj will be overridden to be a Profile object so the two employee Profiles can be compared
     * @return isEqual as true if the profiles are the same and false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        boolean isEqual = false;
        if(obj instanceof Profile){
            Profile profile = (Profile)obj;
            if(this.name.equals(profile.name) && this.department.equals(profile.department)
                    && this.dateHired.compareTo(profile.dateHired) == 0){
                isEqual = true;
            }
        }
        return isEqual;
    }

    /**
     * Gets the department that the employee works in.
     * @return the department that the employee works in
     */
    public String getDepartment(){
        return department;
    }

    /**
     * Gets the date the employee was hired.
     * @return the date object representation of when the employee was hired
     */
    public Date getDateHired(){
        return dateHired;
    }
}
