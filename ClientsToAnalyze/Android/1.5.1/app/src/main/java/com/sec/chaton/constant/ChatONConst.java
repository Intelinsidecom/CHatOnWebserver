package com.sec.chaton.constant;

import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.ChatONLogWriter;

/* loaded from: classes.dex */
public class ChatONConst {

    /* renamed from: b */
    public static String f1338b;

    /* renamed from: e */
    public static String f1341e;

    /* renamed from: f */
    public static String f1342f;

    /* renamed from: g */
    public static int f1343g;

    /* renamed from: h */
    public static int f1344h;

    /* renamed from: i */
    public static final Uri f1345i;

    /* renamed from: j */
    private static boolean f1346j;

    /* renamed from: a */
    public static final int f1337a = Integer.parseInt(Build.VERSION.SDK);

    /* renamed from: c */
    public static String f1339c = "failed";

    /* renamed from: d */
    public static String f1340d = "com.sec.chaton.service.DELETE_DIR_ACTION";

    static {
        f1346j = true;
        try {
            Class.forName("com.google.android.maps.MapActivity");
        } catch (ClassNotFoundException e) {
            ChatONLogWriter.m3513g("ChatON", "Google MAP API NOT available");
            f1346j = false;
        }
        try {
            f1338b = GlobalApplication.m2387e().getPackageManager().getPackageInfo(GlobalApplication.m2387e().getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
        }
        f1341e = "IMAGE_PREVIEW_SAVE";
        f1342f = "IMAGE_PREVIEW_SEND";
        f1343g = 5;
        f1344h = 3;
        f1345i = Uri.parse("content://com.sec.badge/apps");
    }

    /* renamed from: a */
    public static boolean m1972a() {
        return f1346j;
    }
}
