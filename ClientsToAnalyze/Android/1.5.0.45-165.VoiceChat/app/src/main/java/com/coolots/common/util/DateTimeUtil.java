package com.coolots.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;

/* loaded from: classes.dex */
public final class DateTimeUtil {
    public static final String FORMAT_CUSTOM = "MM/dd/yyyy hh:mm:ss a 'GMT'";
    public static final String FORMAT_MMDDHHMMSS = "MMddHHmmss";
    public static final String FORMAT_STANDARD = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMAT_STANDARD_EXTEND = "yyyy-MM-dd HH:mm:ss.S";
    public static final String FORMAT_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    public static final int TYPE_DAYS = 86400000;
    public static final int TYPE_HOURS = 3600000;
    public static final int TYPE_MILLISECONDS = 1;
    public static final int TYPE_MINUTES = 60000;
    public static final int TYPE_SECONDS = 1000;

    private DateTimeUtil() {
    }

    public static Date getGMT00() throws ParseException {
        return changeFormat(getGMT(new Date()), "yyyy-MM-dd HH:mm:ss");
    }

    public static String getGMT() {
        return getGMT(new Date());
    }

    public static Date getGMT00(Date currentDate) throws ParseException {
        return changeFormat(getGMT(currentDate), "yyyy-MM-dd HH:mm:ss");
    }

    public static String getGMT(Date currentDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
        dateFormat.setCalendar(Calendar.getInstance(new SimpleTimeZone(0, "GMT")));
        return dateFormat.format(currentDate);
    }

    public static String getGMT(Date currentDate, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        dateFormat.setCalendar(Calendar.getInstance(new SimpleTimeZone(0, "GMT")));
        return dateFormat.format(currentDate);
    }

    public static Date changeToMidnight(Date originalTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(originalTime);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTime();
    }

    public static String changeFormat(Date date, String format) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(format, Locale.US);
        return dateFormat.format(date);
    }

    public static Date changeFormat(String dateStr, String format) throws ParseException {
        if (dateStr == null || dateStr.length() == 0) {
            return null;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(format, Locale.US);
        return dateFormat.parse(dateStr);
    }

    public static Date addDate(Date originalDate, int type, int addValue) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(originalDate);
        cal.add(type, addValue);
        return cal.getTime();
    }

    public static int getDiff2(Date first, Date second, int type) {
        long diff = first.getTime() - second.getTime();
        int days = ((int) diff) / type;
        if (diff % type > 0) {
            return days + 1;
        }
        return days;
    }

    public static long getDiff(Date first, Date second, int type) {
        long diff = first.getTime() - second.getTime();
        return diff / type;
    }
}
