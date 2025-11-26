package com.sec.chaton.smsplugin.p111h;

import android.text.format.DateFormat;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* compiled from: PLog.java */
/* renamed from: com.sec.chaton.smsplugin.h.s */
/* loaded from: classes.dex */
public class C3896s {

    /* renamed from: a */
    private static final String f14002a = C3896s.class.getSimpleName();

    /* renamed from: b */
    private static boolean f14003b = true;

    /* renamed from: c */
    private static boolean f14004c = true;

    /* renamed from: d */
    private static boolean f14005d = true;

    /* renamed from: e */
    private static boolean f14006e = true;

    /* renamed from: f */
    private static boolean f14007f = true;

    /* renamed from: a */
    public static String m15039a(Throwable th) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        th.printStackTrace(new PrintStream(byteArrayOutputStream));
        return byteArrayOutputStream.toString();
    }

    /* renamed from: a */
    public static void m15042a(Throwable th, String str) {
        String strM15039a = m15039a(th);
        if (f14003b) {
            m15040a(1, strM15039a, str);
            m15043b(1, strM15039a, str);
        }
    }

    /* renamed from: a */
    public static void m15041a(String str, String str2) {
        if (f14003b) {
            m15040a(1, str, str2);
            m15043b(1, str, str2);
        }
    }

    /* renamed from: b */
    public static void m15044b(String str, String str2) {
        if (f14004c) {
            m15040a(4, str, str2);
            m15043b(4, str, str2);
        }
    }

    /* renamed from: c */
    public static void m15045c(String str, String str2) {
        if (f14005d) {
            m15040a(3, str, str2);
            m15043b(3, str, str2);
        }
    }

    /* renamed from: d */
    public static void m15046d(String str, String str2) {
        if (f14007f) {
            m15040a(5, str, str2);
            m15043b(5, str, str2);
        }
    }

    /* renamed from: a */
    private static void m15040a(int i, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("[" + str2 + "] ");
        sb.append(str);
        switch (i) {
            case 1:
                C3890m.m14999e(f14002a, sb.toString());
                break;
            case 2:
                C3890m.m14997c(f14002a, sb.toString());
                break;
            case 3:
                C3890m.m14997c(f14002a, sb.toString());
                break;
            case 4:
                C3890m.m14996b(f14002a, sb.toString());
                break;
            case 5:
                C3890m.m14994a(f14002a, sb.toString());
                break;
        }
    }

    /* renamed from: b */
    private static void m15043b(int i, String str, String str2) {
        char c2;
        StringBuilder sb = new StringBuilder();
        sb.append(DateFormat.format("MM/dd/yy hh:mm:ss", System.currentTimeMillis()));
        switch (i) {
            case 1:
                c2 = 'E';
                break;
            case 2:
                c2 = 'W';
                break;
            case 3:
                c2 = 'I';
                break;
            case 4:
                c2 = 'D';
                break;
            default:
                c2 = 'V';
                break;
        }
        sb.append(' ');
        sb.append(c2);
        sb.append(' ');
        sb.append("[" + str2 + "] ");
        sb.append(str);
        sb.append('\n');
    }
}
