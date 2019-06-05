package Hackerrank;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DayOfWeek {

    public static void main(String[] args) {
        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("d-MMMM-yyyy");
        try {
            System.out.println(sdf.parse("1-January-2000"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 7; i++){
            System.out.println(calendar.get(Calendar.DAY_OF_WEEK) +" " + sdf.format(currentDate));
            currentDate.setTime(currentDate.getTime()+86400000);
            calendar.setTime(currentDate);
        }
    }
}
