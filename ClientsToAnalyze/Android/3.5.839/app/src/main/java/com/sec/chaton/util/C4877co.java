package com.sec.chaton.util;

import com.sec.chaton.R;
import com.sec.common.CommonApplication;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/* compiled from: TimeAdapter.java */
/* renamed from: com.sec.chaton.util.co */
/* loaded from: classes.dex */
public class C4877co {
    /* renamed from: a */
    public static String m18512a() {
        Calendar calendar = Calendar.getInstance();
        return new String(calendar.get(1) + String.format("%02d", Integer.valueOf(calendar.get(2))) + String.format("%02d", Integer.valueOf(calendar.get(5))) + String.format("%02d", Integer.valueOf(calendar.get(10))) + String.format("%02d", Integer.valueOf(calendar.get(12))) + String.format("%02d", Integer.valueOf(calendar.get(13))));
    }

    /* renamed from: a */
    public static String m18513a(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd'T'HHmmss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat.format(date) + "Z";
    }

    /* renamed from: a */
    public static int[] m18514a(int i) {
        int i2 = i / 3600;
        int i3 = i - (i2 * 3600);
        int i4 = i3 / 60;
        return new int[]{i2, i4, i3 - (i4 * 60)};
    }

    /* renamed from: b */
    public static String m18515b(int i) {
        int[] iArrM18514a = m18514a(i);
        StringBuilder sb = new StringBuilder();
        if (iArrM18514a[0] != 0) {
            sb.append(iArrM18514a[0]).append(CommonApplication.m18732r().getResources().getString(R.string.chat_call_duration_h)).append(" ");
        }
        sb.append(iArrM18514a[1]).append(CommonApplication.m18732r().getResources().getString(R.string.chat_call_duration_m)).append(" ");
        sb.append(iArrM18514a[2]).append(CommonApplication.m18732r().getResources().getString(R.string.chat_call_duration_s));
        return sb.toString();
    }
}
