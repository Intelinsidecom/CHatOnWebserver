package com.vlingo.sdk.internal.http.date;

import java.util.Calendar;
import java.util.TimeZone;

/* loaded from: classes.dex */
public class HttpDateParser {
    private static final String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

    public static long parse(String date) {
        int calMonth;
        if (date == null || date.length() < 26) {
            return 0L;
        }
        String day = date.substring(5, 7);
        String month = date.substring(8, 11);
        String year = date.substring(12, 16);
        String hour = date.substring(17, 19);
        String minute = date.substring(20, 22);
        String second = date.substring(23, 25);
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        try {
            cal.set(5, Integer.parseInt(day));
            cal.set(1, Integer.parseInt(year));
            cal.set(11, Integer.parseInt(hour));
            cal.set(12, Integer.parseInt(minute));
            cal.set(13, Integer.parseInt(second));
            int numMonth = -1;
            int i = 0;
            while (true) {
                if (i >= months.length) {
                    break;
                }
                if (!months[i].equalsIgnoreCase(month)) {
                    i++;
                } else {
                    numMonth = i;
                    break;
                }
            }
            switch (numMonth) {
                case 0:
                    calMonth = 0;
                    break;
                case 1:
                    calMonth = 1;
                    break;
                case 2:
                    calMonth = 2;
                    break;
                case 3:
                    calMonth = 3;
                    break;
                case 4:
                    calMonth = 4;
                    break;
                case 5:
                    calMonth = 5;
                    break;
                case 6:
                    calMonth = 6;
                    break;
                case 7:
                    calMonth = 7;
                    break;
                case 8:
                    calMonth = 8;
                    break;
                case 9:
                    calMonth = 9;
                    break;
                case 10:
                    calMonth = 10;
                    break;
                case 11:
                    calMonth = 11;
                    break;
                default:
                    return 0L;
            }
            cal.set(2, calMonth);
            long expires = cal.getTime().getTime();
            return expires;
        } catch (NumberFormatException e) {
            return 0L;
        }
    }
}
