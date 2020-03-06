package utils;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateLib {

    Calendar cal = Calendar.getInstance();
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    /**+
     * It will calculate the Check In Date
     * @return Check In Date
     */
    public String calculateCheckInDate(){
        cal.add(Calendar.MONTH, 3);
        System.out.println("calculateCheckInDate : " + dateFormat.format(cal.getTime()));
        return dateFormat.format(cal.getTime());
    }

    /**+
     * It will calculate the Check Out Date
     * @return Check Out Date
     */
    public String calculateCheckOutDate()
    {
        cal.add(Calendar.DATE, 2);
        System.out.println("calculateCheckOutDate : " + dateFormat.format(cal.getTime()));
        return dateFormat.format(cal.getTime());
    }





}
