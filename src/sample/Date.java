package sample;
import java.util.Calendar;
/**
 * Embodies the structure of a date object with a publish date stored as a
 * day, month and year property. The class has two separate constructors, one
 * for adding a new book to the library and one for creating a date with
 * the current date. The .isValid() method verifies the validity of a publish
 * date against certain parameters. The date class has getter methods for
 * ease of use as well as some private methods for modularity. A main
 * function is used for testbed main testing.
 * @author Angela Chaikovsky, Hemanthvarma Bhupatiraju
 */
public class Date implements Comparable<Date> {

    private int year;
    private int month;
    private int day;

    final static int FIRSTDAY = 1;
    final static int LASTDAY = 31;
    final static int EARLIESTVALIDYEAR = 1900;
    final static int JANUARY = 1;
    final static int DECEMBER = 12;
    final static int MONTHENDLONGEST = 31;
    final static int MONTHENDSHORTEST = 30;
    final static int MARCH = 3;
    final static int MAY = 5;
    final static int JULY = 7;
    final static int AUGUST = 8;
    final static int OCTOBER = 10;
    final static int DENOMFOUR = 4;
    final static int DENOMHUNDRED = 100;
    final static int DENOMFOURHUNDRED = 400;
    final static int LEAPYEARDAYS = 29;
    final static int NONLEAPYEARDAYS = 28;
    final static int NUMBERFEBRUARY = 2;
    final static int AFTER = 1;
    final static int BEFORE = -1;
    final static int EQUALS = 0;


    /**
     *The constructor takes in a string date in the form of MM/DD/YYYY and parses
     * each field into the three instance variable fields.
     * @param date publish date of a book
     */
    public Date(String date) {
        String [] parsedDate = date.split("/");
        this.month = Integer.parseInt(parsedDate[0]);
        this.day = Integer.parseInt(parsedDate[1]);
        this.year = Integer.parseInt(parsedDate[2]);
    }

    /**
     *The constructor creates a date object based on today's date and fills the
     * date, month and year information into the three instance variables.
     */
    public Date() {//return today’s date CHECK THAT THE IMPORT IS VALID
        int[] dateArray = todayDate();
        this.month = dateArray[0];
        this.day = dateArray[1];
        this.year = dateArray[2];
    }

    /**
     * The compareTo method compares two dates and returns 1 if parameter comes after callee
     * or -1 if the parameter comes before
     * @param date the parameter's date
     * @return 1, 0, or -1 depending on the order of the dates
     */
    @Override
    public int compareTo(Date date) {
        if(date.year > this.year){
            return AFTER;
        }else if(date.year < this.year){
            return BEFORE;
        }else{
            if(date.month > this.month){
                return AFTER;
            }else if(date.month < this.month){
                return BEFORE;
            }else{
                if(date.day > this.day){
                    return AFTER;
                }else if(date.day < this.day){
                    return BEFORE;
                }else{
                    return EQUALS;
                }
            }
        }
    }

    /**
     * The .isValid() function verifies if the publish date is valid against multiple
     * requirements.
     * @return True if the publish date is valid to be added to the library
     */
    public boolean isValid( ) {
        boolean validDateStatus = isValidDate();

        if(validDateStatus == false){
            return false;
        }

        boolean validMonthStatus = isValidMonth();

        if(validMonthStatus == false){
            return false;
        }

        boolean leapYearStatus = isLeapYear();

        if(this.month == NUMBERFEBRUARY && leapYearStatus == true && this.day > LEAPYEARDAYS){
            return false;
        }else if(this.month == NUMBERFEBRUARY && leapYearStatus == false && this.day > NONLEAPYEARDAYS){
            return false;
        }

        return true;
    }

    /**
     * The isValiddate() function checks date validation against the current day as well as
     * verifying that the publish date does not predate the year 1900. It verifies that
     * the publish date is not a date later than today's date
     * @return True only if the date does not predate year 1900 and the date does not exceed
     * todays date
     */
    private boolean isValidDate(){

        if(this.day < FIRSTDAY || this.day > LASTDAY){
            return false;
        }

        boolean result = true;
        Date currentDate = new Date();

        //check the date for validity
        if(this.year >= EARLIESTVALIDYEAR){
            //valid
            //check against current date
            if(this.year > currentDate.year){
                //invalid
                result = false;
            }else if(this.year == currentDate.year){
                if(this.month > currentDate.month){
                    //check for the month then
                    //invalid
                    result = false;
                }else if(this.month == currentDate.month){
                    if(this.day > currentDate.day) {
                        //check for the day then
                        //invalid
                        result = false;
                    }
                }
            }
        }else{
            result = false;
        }

        return result;
    }

    /**
     * The isValidMonth() method does date verification based on the days each month should have.
     * January, March, May, July, August, October and December should all have at most 31 days and
     * at least start on day 1 (not anything before 1).
     * All other months should have at most 30 days except february (this is dealt with later)
     * @return True if the day within publish date is valid for the given month.
     */
    private boolean isValidMonth(){
        //check that the days of the month line up

        if(this.month < JANUARY || this.month > DECEMBER){
            return false;
        }
        if(this.month == JANUARY || this.month == MARCH || this.month == MAY || this.month == JULY || this.month == AUGUST
                || this.month == OCTOBER || this.month == DECEMBER){
            if(this.day > MONTHENDLONGEST){
                return false;
            }
        }else{
            //all the other months which do not have 31 days
            if(this.day > MONTHENDSHORTEST){
                return false;
            }
        }
        return true;
    }

    /**
     * The isLeapYear() method verifies that every year is either a leap year or not
     * according to leap year rules outlined in the Project 1 document.
     * @return True only if the year given is a leap year.
     */
    private boolean isLeapYear(){
        // lastly do a check to make sure about february leap years
        boolean result = false;

        if(this.year % DENOMFOUR == 0){
            //go to step 2
            if(this.year % DENOMHUNDRED == 0){
                //go to step 3
                if(this.year % DENOMFOURHUNDRED == 0){
                    //go to step 4
                    result = true;
                }else{
                    //go to step 5
                    result = false;
                }
            }else{
                //go to step 4
                result = true;
            }
        }else{
            //go to step 5
            result = false;
        }

        return result;
    }

    /**
     * The todaydate() function produces an array consisting of three elements. The
     * elements consist of today's day, month and year.
     * @return an array with index 0 containing the current month, index 1 containing
     * the day and index 2 containing the year.
     */
    private int [] todayDate(){
        Calendar calendar = Calendar.getInstance();

        int currentMonth = calendar.get(Calendar.MONTH);
        currentMonth++;
        int currentDay  = calendar.get(Calendar.DATE);
        int currentYear = calendar.get(Calendar.YEAR);

        int[] dateArray = new int[3];

        dateArray[0] = currentMonth;
        dateArray[1] = currentDay;
        dateArray[2] = currentYear;

        return dateArray;
    }

    /**
     * This method returns the year which was stored in the date object
     * @return the year in String format
     */
    public String getYear(){
        return Integer.toString(this.year);
    }

    /**
     * This method returns the month which was stored in the date object
     * @return the month in String format
     */
    public String getMonth(){
        return Integer.toString(this.month);
    }

    /**
     * This method returns the day which was stored in the date object
     * @return the day in String format
     */
    public String getDay(){
        return Integer.toString(this.day);
    }
}
