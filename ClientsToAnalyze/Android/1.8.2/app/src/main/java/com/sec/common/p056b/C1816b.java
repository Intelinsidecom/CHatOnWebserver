package com.sec.common.p056b;

import android.content.Intent;
import android.net.Uri;
import android.os.Debug;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.sec.chaton.global.GlobalApplication;
import java.lang.reflect.InvocationTargetException;
import java.util.TimeZone;

/* compiled from: CommonUtils.java */
/* renamed from: com.sec.common.b.b */
/* loaded from: classes.dex */
public class C1816b {

    /* renamed from: a */
    private static final String f6510a = C1816b.class.getSimpleName();

    /* renamed from: b */
    private static int f6511b;

    /* renamed from: c */
    private static int f6512c;

    /* renamed from: a */
    public static long m6156a() {
        return System.currentTimeMillis() - TimeZone.getDefault().getOffset(r0);
    }

    /* renamed from: b */
    public static int m6159b() {
        return ((WindowManager) GlobalApplication.m3260b().getSystemService("window")).getDefaultDisplay().getWidth();
    }

    /* renamed from: c */
    public static int m6160c() {
        return ((WindowManager) GlobalApplication.m3260b().getSystemService("window")).getDefaultDisplay().getHeight();
    }

    /* renamed from: d */
    public static int m6161d() {
        if (f6511b == 0 || f6512c == 0) {
            m6164g();
        }
        return f6511b;
    }

    /* renamed from: e */
    public static int m6162e() {
        if (f6511b == 0 || f6512c == 0) {
            m6164g();
        }
        return f6512c;
    }

    /* renamed from: g */
    private static void m6164g() {
        Display defaultDisplay = ((WindowManager) GlobalApplication.m3260b().getSystemService("window")).getDefaultDisplay();
        try {
            f6511b = ((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
            f6512c = ((Integer) Display.class.getMethod("getRawHeight", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
        } catch (IllegalAccessException e) {
        } catch (IllegalArgumentException e2) {
        } catch (NoSuchMethodException e3) {
        } catch (InvocationTargetException e4) {
        }
        if (f6511b == 0 || f6512c == 0) {
            f6511b = defaultDisplay.getWidth();
            f6512c = defaultDisplay.getHeight();
        }
        switch (defaultDisplay.getRotation()) {
            case 1:
            case 3:
                int i = f6511b;
                f6511b = f6512c;
                f6512c = i;
                break;
        }
    }

    /* renamed from: f */
    public static boolean m6163f() {
        try {
            return ((Integer) Debug.class.getMethod("isProductShip", null).invoke(null, null)).intValue() == 1;
        } catch (Throwable th) {
            if (!C1825d.f6539a.f6544e) {
                return false;
            }
            C1825d.f6539a.m6201a(f6510a, th.toString(), th);
            return false;
        }
    }

    /* renamed from: a */
    public static Intent m6157a(String str, String str2) {
        Intent intent = new Intent();
        if (TextUtils.isEmpty(str)) {
            intent.setAction("android.intent.action.SEND").setType("text/plain");
        } else {
            intent.setAction("android.intent.action.SENDTO").setData(Uri.parse("smsto:" + str));
        }
        if (!TextUtils.isEmpty(str2)) {
            intent.putExtra("sms_body", str2);
        }
        return intent;
    }

    /* renamed from: a */
    public static String m6158a(String str) {
        String[] strArrSplit;
        return (TextUtils.isEmpty(str) || (strArrSplit = str.split("\\.")) == null || strArrSplit.length == 0) ? str : strArrSplit[0];
    }
}
