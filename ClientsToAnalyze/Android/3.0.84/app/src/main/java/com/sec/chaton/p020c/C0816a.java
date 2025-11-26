package com.sec.chaton.p020c;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.sec.chaton.R;
import com.sec.chaton.buddy.BuddyProfileActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;

/* compiled from: ChatONConst.java */
/* renamed from: com.sec.chaton.c.a */
/* loaded from: classes.dex */
public class C0816a {

    /* renamed from: a */
    public static String f3112a;

    /* renamed from: b */
    public static String f3113b = "failed";

    /* renamed from: c */
    public static String f3114c = "com.sec.chaton.service.DELETE_DIR_ACTION";

    /* renamed from: d */
    public static boolean f3115d = false;

    /* renamed from: e */
    public static String f3116e;

    /* renamed from: f */
    public static String f3117f;

    /* renamed from: g */
    public static int f3118g;

    /* renamed from: h */
    public static int f3119h;

    /* renamed from: i */
    public static final Uri f3120i;

    /* renamed from: j */
    public static int f3121j;

    /* renamed from: k */
    public static int f3122k;

    /* renamed from: l */
    public static int f3123l;

    /* renamed from: m */
    private static boolean f3124m;

    /* renamed from: n */
    private static boolean f3125n;

    /* renamed from: o */
    private static boolean f3126o;

    /* renamed from: p */
    private static CharSequence[] f3127p;

    /* renamed from: q */
    private static CharSequence[] f3128q;

    static {
        int width;
        int height;
        f3124m = true;
        try {
            Class.forName("com.google.android.maps.MapActivity");
        } catch (ClassNotFoundException e) {
            C3250y.m11459h("ChatON", "Google MAP API NOT available");
            f3124m = false;
        }
        f3125n = false;
        Intent intent = new Intent();
        intent.setAction("com.sec.android.app.myfiles.PICK_DATA");
        new ComponentName("com.sec.android.app.myfiles", "com.sec.android.app.myfiles.fileselector.SingleSelectorActivity");
        if (GlobalApplication.m6447a().getPackageManager().resolveActivity(intent, 0) != null) {
            f3125n = true;
        }
        f3126o = true;
        try {
            f3112a = CommonApplication.m11493l().getPackageManager().getPackageInfo(CommonApplication.m11493l().getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
        }
        f3116e = "IMAGE_PREVIEW_SAVE";
        f3117f = "IMAGE_PREVIEW_SEND";
        f3118g = 5;
        f3119h = 1;
        f3120i = Uri.parse("content://com.sec.badge/apps");
        f3121j = 800;
        f3122k = 600;
        f3123l = 512000;
        Display defaultDisplay = ((WindowManager) CommonApplication.m11493l().getSystemService("window")).getDefaultDisplay();
        if (defaultDisplay != null) {
            if (defaultDisplay.getHeight() > defaultDisplay.getWidth()) {
                width = defaultDisplay.getHeight();
                height = defaultDisplay.getWidth();
            } else {
                width = defaultDisplay.getWidth();
                height = defaultDisplay.getHeight();
            }
            if (width > 800 || height > 480) {
                f3121j = 1024;
                f3122k = 768;
            }
        }
    }

    /* renamed from: a */
    public static boolean m4365a() {
        return f3124m;
    }

    /* renamed from: b */
    public static boolean m4366b() {
        return f3125n;
    }

    /* renamed from: c */
    public static boolean m4367c() {
        return BuddyProfileActivity.m3573a(CommonApplication.m11493l(), new Intent("android.intent.action.SNOTE_PICK"));
    }

    /* renamed from: d */
    public static void m4368d() {
        f3126o = true;
        f3127p = CommonApplication.m11493l().getResources().getStringArray(R.array.facebook_except_country_code);
        f3128q = CommonApplication.m11493l().getResources().getStringArray(R.array.facebook_except_calling_code);
        String strM11082t = C3171am.m11082t();
        String strM11060d = null;
        if (C3171am.m11060d() != null) {
            strM11060d = C3171am.m11060d();
        }
        if (!TextUtils.isEmpty(strM11082t)) {
            int i = 0;
            while (true) {
                if (i >= f3127p.length) {
                    break;
                }
                if (strM11082t.equals(f3127p[i])) {
                    C3250y.m11456e("Facebook is not available : " + ((Object) f3127p[i]), "ChatONConst");
                    f3126o = false;
                    break;
                } else {
                    C3250y.m11456e("Facebook is not available : " + ((Object) f3127p[i]), "ChatONConst");
                    C3250y.m11456e("FacebookAvailableCheck() : " + strM11082t, "ChatONConst");
                    i++;
                }
            }
        }
        if (f3126o && !TextUtils.isEmpty(strM11060d)) {
            for (int i2 = 0; i2 < f3127p.length; i2++) {
                if (strM11060d.equals(f3127p[i2])) {
                    C3250y.m11456e("Facebook is not available : " + ((Object) f3127p[i2]), "ChatONConst");
                    f3126o = false;
                    return;
                } else {
                    C3250y.m11456e("Facebook is not available2 : " + ((Object) f3127p[i2]), "ChatONConst");
                    C3250y.m11456e("FacebookAvailableCheck() : " + strM11060d, "ChatONConst");
                }
            }
        }
    }

    /* renamed from: e */
    public static boolean m4369e() {
        return f3126o;
    }
}
