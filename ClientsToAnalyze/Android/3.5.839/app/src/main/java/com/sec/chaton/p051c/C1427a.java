package com.sec.chaton.p051c;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.p137vk.sdk.VKSdkVersion;
import com.sec.chaton.R;
import com.sec.chaton.buddy.BuddyProfileActivity;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;

/* compiled from: ChatONConst.java */
/* renamed from: com.sec.chaton.c.a */
/* loaded from: classes.dex */
public class C1427a {

    /* renamed from: a */
    public static String f5063a;

    /* renamed from: b */
    public static String f5064b;

    /* renamed from: c */
    public static int f5065c;

    /* renamed from: d */
    public static String f5066d = "failed";

    /* renamed from: e */
    public static String f5067e = "com.sec.chaton.service.DELETE_DIR_ACTION";

    /* renamed from: f */
    public static int f5068f = 200;

    /* renamed from: g */
    public static int f5069g = 199;

    /* renamed from: h */
    public static boolean f5070h = false;

    /* renamed from: i */
    public static boolean f5071i = false;

    /* renamed from: j */
    public static String f5072j;

    /* renamed from: k */
    public static String f5073k;

    /* renamed from: l */
    public static int f5074l;

    /* renamed from: m */
    public static int f5075m;

    /* renamed from: n */
    public static final Uri f5076n;

    /* renamed from: o */
    public static int f5077o;

    /* renamed from: p */
    public static int f5078p;

    /* renamed from: q */
    public static int f5079q;

    /* renamed from: r */
    private static boolean f5080r;

    /* renamed from: s */
    private static boolean f5081s;

    /* renamed from: t */
    private static boolean f5082t;

    /* renamed from: u */
    private static CharSequence[] f5083u;

    /* renamed from: v */
    private static CharSequence[] f5084v;

    static {
        f5080r = true;
        try {
            Class.forName("com.google.android.maps.MapActivity");
        } catch (ClassNotFoundException e) {
            C4904y.m18639b("ChatON", "Google MAP API NOT available");
            f5080r = false;
        }
        f5081s = false;
        Intent intent = new Intent();
        intent.setAction("com.sec.android.app.myfiles.PICK_DATA");
        new ComponentName("com.sec.android.app.myfiles", "com.sec.android.app.myfiles.fileselector.SingleSelectorActivity");
        if (GlobalApplication.m10279a().getPackageManager().resolveActivity(intent, 0) != null) {
            f5081s = true;
        }
        f5082t = true;
        try {
            PackageInfo packageInfo = CommonApplication.m18732r().getPackageManager().getPackageInfo(CommonApplication.m18732r().getPackageName(), 0);
            String str = packageInfo.versionName;
            f5063a = str;
            f5064b = str;
            String[] strArrSplit = str.split("[.]");
            if (CommonApplication.m18732r().getApplicationContext().getApplicationInfo().icon == R.drawable.icon_white) {
                if (str.contains("s") || str.contains("S") || str.contains("l") || str.contains("L")) {
                    f5063a = str.substring(0, str.length() - 1);
                }
            } else if (strArrSplit.length == 3 && (str.contains("l") || str.contains("L"))) {
                f5063a = str.substring(0, str.length() - 1);
            }
            f5065c = packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            f5063a = VKSdkVersion.SDK_VERSION;
            f5064b = VKSdkVersion.SDK_VERSION;
        }
        f5072j = "IMAGE_PREVIEW_SAVE";
        f5073k = "IMAGE_PREVIEW_SEND";
        f5074l = 5;
        f5075m = 1;
        f5076n = Uri.parse("content://com.sec.badge/apps");
        f5077o = 800;
        f5078p = 600;
        f5079q = 512000;
    }

    /* renamed from: a */
    public static boolean m7518a() {
        return f5080r;
    }

    /* renamed from: b */
    public static boolean m7519b() {
        return f5081s;
    }

    /* renamed from: c */
    public static boolean m7520c() {
        return BuddyProfileActivity.m6743a(CommonApplication.m18732r(), new Intent("android.intent.action.SNOTE_PICK"));
    }

    /* renamed from: d */
    public static void m7521d() {
        f5082t = true;
        f5083u = CommonApplication.m18732r().getResources().getStringArray(R.array.facebook_except_country_code);
        f5084v = CommonApplication.m18732r().getResources().getStringArray(R.array.facebook_except_calling_code);
        String strM18257y = C4822an.m18257y();
        String strM18236g = null;
        if (C4822an.m18236g() != null) {
            strM18236g = C4822an.m18236g();
        }
        if (!TextUtils.isEmpty(strM18257y)) {
            int i = 0;
            while (true) {
                if (i >= f5083u.length) {
                    break;
                }
                if (strM18257y.equals(f5083u[i])) {
                    C4904y.m18646e("Facebook is not available : " + ((Object) f5083u[i]), "ChatONConst");
                    f5082t = false;
                    break;
                } else {
                    C4904y.m18646e("Facebook is not available : " + ((Object) f5083u[i]), "ChatONConst");
                    C4904y.m18646e("FacebookAvailableCheck() : " + strM18257y, "ChatONConst");
                    i++;
                }
            }
        }
        if (f5082t && !TextUtils.isEmpty(strM18236g)) {
            for (int i2 = 0; i2 < f5083u.length; i2++) {
                if (strM18236g.equals(f5083u[i2])) {
                    C4904y.m18646e("Facebook is not available : " + ((Object) f5083u[i2]), "ChatONConst");
                    f5082t = false;
                    return;
                } else {
                    C4904y.m18646e("Facebook is not available2 : " + ((Object) f5083u[i2]), "ChatONConst");
                    C4904y.m18646e("FacebookAvailableCheck() : " + strM18236g, "ChatONConst");
                }
            }
        }
    }

    /* renamed from: e */
    public static boolean m7522e() {
        return f5082t;
    }

    /* renamed from: f */
    public static int m7523f() {
        if (C2349a.m10301a("chat_receiver_1000")) {
            f5068f = 1000;
            f5069g = 1000;
        }
        if (C4904y.f17873c) {
            C4904y.m18641c("MAXIMUM_BROADCAST_RECEIVER - " + f5068f, "ChatON");
            C4904y.m18641c("MAXIMUM_GROUPCHAT_RECEIVER - " + f5069g, "ChatON");
        }
        return f5068f;
    }

    /* renamed from: g */
    public static int m7524g() {
        if (C2349a.m10301a("chat_receiver_1000")) {
            f5068f = 1000;
            f5069g = 1000;
        }
        if (C4904y.f17873c) {
            C4904y.m18641c("MAXIMUM_BROADCAST_RECEIVER - " + f5068f, "ChatON");
            C4904y.m18641c("MAXIMUM_GROUPCHAT_RECEIVER - " + f5069g, "ChatON");
        }
        return f5069g;
    }
}
