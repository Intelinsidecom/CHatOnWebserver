package com.sec.chaton.p029f;

import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1341p;
import java.util.Calendar;

/* compiled from: ChatONConst.java */
/* renamed from: com.sec.chaton.f.a */
/* loaded from: classes.dex */
public class C0684a {

    /* renamed from: b */
    public static String f2331b;

    /* renamed from: f */
    public static String f2335f;

    /* renamed from: g */
    public static String f2336g;

    /* renamed from: h */
    public static int f2337h;

    /* renamed from: i */
    public static int f2338i;

    /* renamed from: j */
    public static final Uri f2339j;

    /* renamed from: k */
    private static boolean f2340k;

    /* renamed from: l */
    private static boolean f2341l;

    /* renamed from: m */
    private static CharSequence[] f2342m;

    /* renamed from: a */
    public static final int f2330a = Integer.parseInt(Build.VERSION.SDK);

    /* renamed from: c */
    public static String f2332c = "failed";

    /* renamed from: d */
    public static String f2333d = "com.sec.chaton.service.DELETE_DIR_ACTION";

    /* renamed from: e */
    public static boolean f2334e = false;

    static {
        f2340k = true;
        try {
            Class.forName("com.google.android.maps.MapActivity");
        } catch (ClassNotFoundException e) {
            C1341p.m4664g("ChatON", "Google MAP API NOT available");
            f2340k = false;
        }
        f2341l = true;
        try {
            f2331b = GlobalApplication.m3100a().getPackageManager().getPackageInfo(GlobalApplication.m3100a().getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
        }
        f2335f = "IMAGE_PREVIEW_SAVE";
        f2336g = "IMAGE_PREVIEW_SEND";
        f2337h = 5;
        f2338i = 3;
        f2339j = Uri.parse("content://com.sec.badge/apps");
    }

    /* renamed from: a */
    public static boolean m3049a() {
        return f2340k;
    }

    /* renamed from: b */
    public static void m3050b() {
        f2341l = true;
        f2342m = GlobalApplication.m3100a().getResources().getStringArray(R.array.facebook_except_country_code);
        String string = C1323bs.m4575a().getString("country_ISO", "");
        for (int i = 0; i < f2342m.length; i++) {
            if (string.equals(f2342m[i])) {
                C1341p.m4662e("Facebook is not available : " + ((Object) f2342m[i]), "ChatONConst");
                f2341l = false;
            }
            C1341p.m4662e("Facebook is not available : " + ((Object) f2342m[i]), "ChatONConst");
        }
        C1341p.m4662e("FacebookAvailableCheck() : " + string, "ChatONConst");
    }

    /* renamed from: c */
    public static boolean m3051c() {
        return f2341l;
    }

    /* renamed from: d */
    public static Calendar m3052d() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2012, 4, 15);
        return calendar;
    }
}
