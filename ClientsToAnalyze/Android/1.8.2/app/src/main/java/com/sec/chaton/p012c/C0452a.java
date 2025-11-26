package com.sec.chaton.p012c;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.multimedia.doc.FileExplorerActivity;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;

/* compiled from: ChatONConst.java */
/* renamed from: com.sec.chaton.c.a */
/* loaded from: classes.dex */
public class C0452a {

    /* renamed from: b */
    public static String f1723b;

    /* renamed from: f */
    public static String f1727f;

    /* renamed from: g */
    public static String f1728g;

    /* renamed from: h */
    public static String f1729h;

    /* renamed from: i */
    public static String f1730i;

    /* renamed from: j */
    public static int f1731j;

    /* renamed from: k */
    public static int f1732k;

    /* renamed from: l */
    public static final Uri f1733l;

    /* renamed from: m */
    private static boolean f1734m;

    /* renamed from: n */
    private static boolean f1735n;

    /* renamed from: o */
    private static boolean f1736o;

    /* renamed from: p */
    private static CharSequence[] f1737p;

    /* renamed from: q */
    private static CharSequence[] f1738q;

    /* renamed from: a */
    public static final int f1722a = Integer.parseInt(Build.VERSION.SDK);

    /* renamed from: c */
    public static String f1724c = "failed";

    /* renamed from: d */
    public static String f1725d = "com.sec.chaton.service.DELETE_DIR_ACTION";

    /* renamed from: e */
    public static boolean f1726e = false;

    static {
        f1734m = true;
        try {
            Class.forName("com.google.android.maps.MapActivity");
        } catch (ClassNotFoundException e) {
            C1786r.m6068g("ChatON", "Google MAP API NOT available");
            f1734m = false;
        }
        f1735n = false;
        Intent intent = new Intent();
        intent.setAction("com.sec.android.app.myfiles.PICK_DATA");
        intent.setComponent(new ComponentName("com.sec.android.app.myfiles", "com.sec.android.app.myfiles.fileselector.SingleSelectorActivity"));
        intent.putExtra("CONTENT_TYPE", FileExplorerActivity.m3626a());
        if (GlobalApplication.m3256a().getPackageManager().resolveActivity(intent, 0) != null) {
            f1735n = true;
        }
        f1736o = true;
        try {
            f1723b = GlobalApplication.m3260b().getPackageManager().getPackageInfo(GlobalApplication.m3260b().getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
        }
        f1727f = "IMAGE_PREVIEW_SAVE";
        f1728g = "IMAGE_PREVIEW_SEND";
        f1729h = "ORIGINAL_IMAGE_PREVIEW";
        f1730i = "TRUNK_ITEM_ID";
        f1731j = 5;
        f1732k = 3;
        f1733l = Uri.parse("content://com.sec.badge/apps");
    }

    /* renamed from: a */
    public static boolean m2468a() {
        return f1734m;
    }

    /* renamed from: b */
    public static boolean m2469b() {
        return f1735n;
    }

    /* renamed from: c */
    public static void m2470c() {
        f1736o = true;
        f1737p = GlobalApplication.m3260b().getResources().getStringArray(R.array.facebook_except_country_code);
        f1738q = GlobalApplication.m3260b().getResources().getStringArray(R.array.facebook_except_calling_code);
        String string = C1789u.m6075a().getString("country_ISO", "");
        String string2 = C1789u.m6075a().getString("country_code", "");
        for (int i = 0; i < f1737p.length; i++) {
            if (TextUtils.isEmpty(string)) {
                if (string2.equals(f1738q[i])) {
                    C1786r.m6066e("Facebook is not available : " + ((Object) f1738q[i]), "ChatONConst");
                    f1736o = false;
                }
            } else {
                if (string.equals(f1737p[i])) {
                    C1786r.m6066e("Facebook is not available : " + ((Object) f1737p[i]), "ChatONConst");
                    f1736o = false;
                }
                C1786r.m6066e("Facebook is not available : " + ((Object) f1737p[i]), "ChatONConst");
            }
        }
        C1786r.m6066e("FacebookAvailableCheck() : " + string, "ChatONConst");
    }

    /* renamed from: d */
    public static boolean m2471d() {
        return f1736o;
    }
}
