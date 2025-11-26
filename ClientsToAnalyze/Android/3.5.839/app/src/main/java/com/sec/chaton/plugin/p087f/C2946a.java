package com.sec.chaton.plugin.p087f;

import android.text.format.DateFormat;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* compiled from: PLog.java */
/* renamed from: com.sec.chaton.plugin.f.a */
/* loaded from: classes.dex */
public class C2946a {

    /* renamed from: a */
    private static final String f10838a = C2946a.class.getSimpleName();

    /* renamed from: b */
    private static boolean f10839b = true;

    /* renamed from: c */
    private static boolean f10840c = true;

    /* renamed from: d */
    private static boolean f10841d = true;

    /* renamed from: e */
    private static boolean f10842e = true;

    /* renamed from: f */
    private static boolean f10843f = true;

    /* renamed from: a */
    public static String m12184a(Throwable th) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        th.printStackTrace(new PrintStream(byteArrayOutputStream));
        return byteArrayOutputStream.toString();
    }

    /* renamed from: a */
    public static void m12187a(Throwable th, String str) {
        String strM12184a = m12184a(th);
        if (f10839b) {
            m12185a(1, strM12184a, str);
            m12188b(1, strM12184a, str);
        }
    }

    /* renamed from: a */
    public static void m12186a(String str, String str2) {
        if (f10839b) {
            m12185a(1, str, str2);
            m12188b(1, str, str2);
        }
    }

    /* renamed from: b */
    public static void m12189b(String str, String str2) {
        if (f10840c) {
            m12185a(4, str, str2);
            m12188b(4, str, str2);
        }
    }

    /* renamed from: a */
    private static void m12185a(int i, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("[" + str2 + "] ");
        sb.append(str);
        switch (i) {
            case 1:
                Log.e(f10838a, sb.toString());
                break;
            case 2:
                Log.w(f10838a, sb.toString());
                break;
            case 3:
                Log.i(f10838a, sb.toString());
                break;
            case 4:
                Log.d(f10838a, sb.toString());
                break;
            case 5:
                Log.v(f10838a, sb.toString());
                break;
        }
    }

    /* renamed from: b */
    private static void m12188b(int i, String str, String str2) {
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
