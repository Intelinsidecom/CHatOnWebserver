package com.sec.chaton.util;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes.dex */
public class TimeAdapter {
    /* renamed from: a */
    public static String m3678a() {
        Calendar calendar = Calendar.getInstance();
        return new String(calendar.get(1) + String.format("%02d", Integer.valueOf(calendar.get(2))) + String.format("%02d", Integer.valueOf(calendar.get(5))) + String.format("%02d", Integer.valueOf(calendar.get(10))) + String.format("%02d", Integer.valueOf(calendar.get(12))) + String.format("%02d", Integer.valueOf(calendar.get(13))));
    }

    /* renamed from: a */
    public static String m3679a(long j, String str) {
        System.currentTimeMillis();
        return new SimpleDateFormat(str, Locale.ENGLISH).format(new Date(j)).toLowerCase();
    }

    /* renamed from: a */
    public static String m3680a(Date date) {
        return new SimpleDateFormat("yyyyMMdd'T'HHmmss").format(date) + "Z";
    }

    /* renamed from: a */
    public static String m3681a(Date date, String str) {
        return new SimpleDateFormat(str).format(date);
    }

    /* renamed from: a */
    public static Date m3682a(String str) {
        if (str.length() == 6) {
        }
        String strSubstring = str.length() == 8 ? "yyyyMMdd" : str.length() == 12 ? "yyyyMMddHHmm" : str.length() == 13 ? "yyyyMMdd'T'HHmm" : str.length() == 14 ? "yyyyMMddHHmmss" : str.length() == 15 ? "yyyyMMdd'T'HHmmss" : "yyyyMMdd'T'HHmmssZ";
        if (str.indexOf(45) > -1) {
            strSubstring = "yyyy-MM-dd'T'HH:mm:ssZ";
            if (str.length() <= 10) {
                strSubstring = "yyyy-MM-dd'T'HH:mm:ssZ".substring(0, str.length() - 1);
            } else if (str.length() > 11) {
                strSubstring = "yyyy-MM-dd'T'HH:mm:ssZ".substring(0, Math.min("yyyy-MM-dd'T'HH:mm:ssZ".length() - 1, str.length() + 1));
            }
        }
        try {
            return new SimpleDateFormat(strSubstring).parse(str, new ParsePosition(0));
        } catch (NullPointerException e) {
            return null;
        }
    }
}
