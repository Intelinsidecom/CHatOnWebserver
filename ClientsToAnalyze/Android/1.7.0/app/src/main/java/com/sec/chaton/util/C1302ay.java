package com.sec.chaton.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* compiled from: TimeAdapter.java */
/* renamed from: com.sec.chaton.util.ay */
/* loaded from: classes.dex */
public class C1302ay {
    /* renamed from: a */
    public static String m4546a() {
        Calendar calendar = Calendar.getInstance();
        return new String(calendar.get(1) + String.format("%02d", Integer.valueOf(calendar.get(2))) + String.format("%02d", Integer.valueOf(calendar.get(5))) + String.format("%02d", Integer.valueOf(calendar.get(10))) + String.format("%02d", Integer.valueOf(calendar.get(12))) + String.format("%02d", Integer.valueOf(calendar.get(13))));
    }

    /* renamed from: a */
    public static String m4548a(Date date) {
        return new SimpleDateFormat("yyyyMMdd'T'HHmmss").format(date) + "Z";
    }

    /* renamed from: a */
    public static String m4547a(long j, String str) {
        return new SimpleDateFormat(str, Locale.ENGLISH).format(new Date(j));
    }
}
