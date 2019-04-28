package others;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class CalendarDemo {

    public static void main(String[] args) {

        Date date = new Date();
        Calendar calendar1 = Calendar.getInstance();
        calendar1.add(Calendar.HOUR_OF_DAY, -3);

        System.out.println((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(calendar1.getTime()));
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(Calendar.DAY_OF_MONTH, 31);
        System.out.println((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(calendar2.getTime()));
        Calendar calendar3 = Calendar.getInstance();
        calendar3.roll(Calendar.DAY_OF_MONTH, 35);
        System.out.println((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(calendar3.getTime()));
    }
}
