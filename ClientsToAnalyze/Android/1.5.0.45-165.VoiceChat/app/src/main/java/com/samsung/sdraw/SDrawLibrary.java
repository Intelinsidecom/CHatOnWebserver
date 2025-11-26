package com.samsung.sdraw;

import android.os.Build;
import android.util.Log;
import com.sds.coolots.common.model.EventCode;

/* loaded from: classes.dex */
public class SDrawLibrary {

    /* renamed from: a */
    private static int[] f1159a = {2, 2, 0};

    /* renamed from: b */
    private static int[] f1160b = {EventCode.EVENT_CONTACT_UPDATE_UI_LOGIN, 8, 29};

    public static final boolean isSupportedModel() {
        boolean z = m1056b() || m1055a();
        if (!z) {
            m1057c();
        }
        return z;
    }

    /* renamed from: a */
    private static boolean m1055a() {
        return Build.MODEL.compareToIgnoreCase("google_sdk") == 0 || Build.MODEL.compareToIgnoreCase("sdk") == 0;
    }

    /* renamed from: b */
    private static boolean m1056b() {
        return Build.MANUFACTURER.compareToIgnoreCase("samsung") == 0 || Build.BRAND.compareToIgnoreCase("samsung") == 0;
    }

    /* renamed from: c */
    private static void m1057c() {
        Log.e("SDraw", String.format("This engine isn't supported to run on this device. (brand : %s, manufacturer : %s)", Build.BRAND, Build.MANUFACTURER));
    }

    /* renamed from: d */
    private static String m1058d() {
        if (f1159a.length == 3) {
            return String.format("%d.%d.%d", Integer.valueOf(f1159a[0]), Integer.valueOf(f1159a[1]), Integer.valueOf(f1159a[2]));
        }
        if (f1159a.length == 2) {
            return String.format("%d.%d", Integer.valueOf(f1159a[0]), Integer.valueOf(f1159a[1]));
        }
        return "";
    }

    /* renamed from: e */
    private static String m1059e() {
        return String.format("%d/%02d/%02d", Integer.valueOf(f1160b[0]), Integer.valueOf(f1160b[1]), Integer.valueOf(f1160b[2]));
    }

    public static final void printReleaseInfo() {
        Log.e("SDraw", String.format("Version : %s.\nRelease Date : %s.", m1058d(), m1059e()));
    }
}
