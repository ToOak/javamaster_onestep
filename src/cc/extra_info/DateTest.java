package cc.extra_info;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static java.lang.System.out;

public class DateTest {
    public static void main(String[] args) {
        {
            String str_time = "2011/10/25";
            DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
            try {
                Date date = df.parse(str_time);
                out.println(str_time + " dateformat to: " + date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        {
            Date d = new Date();
            DateFormat df = DateFormat.getDateInstance(DateFormat.LONG);
            out.println(df.format(d));
            df = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
            out.println(df.format(d));
            df = new SimpleDateFormat("yyyy年 MM月 dd日 HH:mm:ss");
            out.println(df.format(d));

        }
        {
            Calendar calendar = Calendar.getInstance();
            out.println(calendar.get(Calendar.YEAR) + "年" + (calendar.get(Calendar.MONTH) + 1) + "月"
                    + getNum(calendar.get(Calendar.DAY_OF_MONTH)) + "日"
                    + "星期" + getWeek(calendar.get(Calendar.DAY_OF_WEEK)));
        }

    }

    static String getNum(int num) {
        return num > 9 ? num + "" : "0" + num;
    }

    static String getWeek(int weekIndex) {
        String[] weeks = {"", "日", "一", "二", "三", "四", "五", "六"};
        return weeks[weekIndex];
    }
}
