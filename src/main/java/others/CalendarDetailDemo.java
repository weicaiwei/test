package others;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: CalendarDetailDemo
 * @Description: TODO
 * @auther: caiwei
 * @date: 2019/6/25 00:06
 */
public class CalendarDetailDemo {

    public static void main(String[] args){
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(
                getAppointedDateTime(TimeUnit.SECONDS, 4)));
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(
                getAppointedDateTime(TimeUnit.SECONDS, -4)));

        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(
                getAppointedDateTime(TimeUnit.MINUTES, 4)));
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(
                getAppointedDateTime(TimeUnit.MINUTES, -4)));

        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(
                getAppointedDateTime(TimeUnit.HOURS, 4)));
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(
                getAppointedDateTime(TimeUnit.HOURS, -4)));

        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(
                getAppointedDateTime(TimeUnit.DAYS, 4)));
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(
                getAppointedDateTime(TimeUnit.DAYS, -4)));


    }

    public static Date getAppointedDateTime(TimeUnit timeUnit, Integer several){
        Calendar calendar = Calendar.getInstance();
        switch (timeUnit) {
            case SECONDS:
                calendar.add(Calendar.SECOND, several);
                return calendar.getTime();
            case MINUTES:
                calendar.add(Calendar.MINUTE, several);
                return calendar.getTime();
            case HOURS:
                calendar.add(Calendar.HOUR_OF_DAY, several);
                return calendar.getTime();
            case DAYS:
                calendar.add(Calendar.DAY_OF_MONTH, several);
                return calendar.getTime();
            default:
                return calendar.getTime();
        }
    }
}
