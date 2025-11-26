package com.sds.coolots.common.util;

import com.coolots.sso.util.ChatONVAPII;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes.dex */
public final class DateTimeUtil {
    public static final String FORMAT_HHMMSS = "HH:mm:ss.S";
    public static final String FORMAT_STANDARD = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMAT_STANDARD_EXTEND = "yyyy-MM-dd HH:mm:ss.S";
    public static final String FORMAT_STANDARD_EXTEND2 = "yyyy.MM.dd. HH:mm:ss.S";
    public static final String FORMAT_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    public static final int SERVER_TIMEZONE_OFFSET = 540;
    public static final int TYPE_DAYS = 86400000;
    public static final int TYPE_HOURS = 3600000;
    public static final int TYPE_MINUTES = 60000;

    private DateTimeUtil() {
    }

    public static String changeFormat(Date date, String str) {
        if (date == null) {
            return null;
        }
        return new SimpleDateFormat(str).format(date);
    }

    public static Date changeFormat(String str, String str2) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        return new SimpleDateFormat(str2).parse(str);
    }

    public static Date changeToMidnight(Timestamp timestamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(timestamp);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTime();
    }

    public static String convertTime(int i) {
        if (i < 1) {
            return "00:00:00";
        }
        long j = i / 1000;
        long j2 = j / 60;
        long j3 = j % 60;
        long j4 = j2 % 60;
        long j5 = (j2 / 60) % 60;
        String strValueOf = String.valueOf(j3);
        String strValueOf2 = String.valueOf(j4);
        String strValueOf3 = String.valueOf(j5);
        if (j3 < 10) {
            strValueOf = "0" + j3;
        }
        if (j4 < 10) {
            strValueOf2 = "0" + j4;
        }
        if (j5 < 10) {
            strValueOf3 = "0" + j5;
        }
        return String.valueOf(strValueOf3) + ChatONVAPII.USERID_DELEMETER + strValueOf2 + ChatONVAPII.USERID_DELEMETER + strValueOf;
    }

    public static String getCurrentTime(String str) {
        return toString(new Date(), str);
    }

    public static int getDiff(Date date, Date date2, int i) {
        long time = date.getTime() - date2.getTime();
        int i2 = ((int) time) / i;
        return time % ((long) i) > 0 ? i2 + 1 : i2;
    }

    public static Date getTargetDate(int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, i);
        return calendar.getTime();
    }

    public static String getTargetDay(int i) {
        return getTargetDay(i, "yyyy.MM.dd.");
    }

    public static String getTargetDay(int i, String str) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, i);
        return new SimpleDateFormat(str, Locale.getDefault()).format(calendar.getTime());
    }

    public static String getWeek(String[] strArr, String str) throws NumberFormatException {
        if (strArr == null || strArr.length != 7) {
            strArr = new String[]{"일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일"};
        }
        int i = Integer.parseInt(str.substring(0, 4).trim());
        int i2 = Integer.parseInt(str.substring(4, 6).trim()) - 1;
        int i3 = Integer.parseInt(str.substring(6, 8).trim());
        Calendar.getInstance().set(i, i2, i3);
        return strArr[r3.get(7) - 1];
    }

    public static Calendar toCalendar(String str, String str2) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2, Locale.getDefault());
        simpleDateFormat.parse(str);
        return simpleDateFormat.getCalendar();
    }

    public static Date toDate(String str, String str2) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        try {
            return new SimpleDateFormat(str2, Locale.getDefault()).parse(str);
        } catch (ParseException e) {
            return null;
        }
    }

    public static Date toLocalTime(String str, String str2) {
        Calendar calendar = toCalendar(str, str2);
        if (calendar == null) {
            return new Date();
        }
        calendar.add(12, ((calendar.get(15) + calendar.get(16)) / 60000) - 540);
        return calendar.getTime();
    }

    public static String toLocalTimeString(String str, String str2) {
        return toString(toLocalTime(str, str2), str2);
    }

    public static String toString(Date date, String str) {
        if (date == null) {
            return null;
        }
        return new SimpleDateFormat(str, Locale.getDefault()).format(date);
    }
}
