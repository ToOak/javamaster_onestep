package cc.j8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static java.lang.System.out;

public class LocalDataAndTime {
    public static void main(String[] args) {
        {
            LocalDate localData = LocalDate.now();
            out.println(localData.getYear() + "年" + localData.getMonthValue() + "月" + localData.getDayOfMonth() + "日");
            out.println(localData.toString());
        }
        {
            LocalTime localTime = LocalTime.now();
            out.println(localTime.getHour() + "时" + localTime.getMinute() + "分" + localTime.getSecond() + "秒");
            out.println(localTime.toString());
        }
        {
            LocalDateTime localDateTime = LocalDateTime.now();
            out.println(localDateTime.getYear() + "年" + localDateTime.getMonth() + "月" + localDateTime.getDayOfMonth() + "日"
                    + localDateTime.getHour() + "时" + localDateTime.getMinute() + "分" + localDateTime.getSecond() + "秒");
            out.println(localDateTime.toString());
        }
        {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime date = LocalDateTime.parse("2011-09-10 08:08:08", formatter);
            out.println(date);
        }
        {
            ZonedDateTime zonedDateTime = ZonedDateTime.now();
            out.println(zonedDateTime);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy:HH:mm:ss");
            String strDate = zonedDateTime.format(formatter);
            out.println(strDate);
        }
    }
}
