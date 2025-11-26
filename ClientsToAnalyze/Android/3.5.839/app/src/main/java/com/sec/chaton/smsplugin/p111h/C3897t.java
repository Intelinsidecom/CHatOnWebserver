package com.sec.chaton.smsplugin.p111h;

import android.annotation.TargetApi;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.hardware.motion.MotionRecognitionManager;
import android.net.Uri;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;

/* compiled from: PackageInfo.java */
@TargetApi(14)
/* renamed from: com.sec.chaton.smsplugin.h.t */
/* loaded from: classes.dex */
public class C3897t {
    /* renamed from: a */
    public static boolean m15051a(Context context, String str) {
        boolean z = false;
        try {
            int applicationEnabledSetting = context.getPackageManager().getApplicationEnabledSetting(str);
            if (2 == applicationEnabledSetting || 3 == applicationEnabledSetting) {
                C3890m.m14994a("Mms/PackageInfo", str + " is diabled");
            } else {
                C3890m.m14994a("Mms/PackageInfo", str + " is enabled");
                z = true;
            }
        } catch (IllegalArgumentException e) {
            C3890m.m14994a("Mms/PackageInfo", str + " is not installed");
        }
        return z;
    }

    /* renamed from: a */
    public static boolean m15050a(Context context, Intent intent) {
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            C3890m.m14994a("Mms/PackageInfo", intent.getAction().toString() + " doesn't exist.");
            context.startActivity(Intent.createChooser(intent, context.getResources().getString(R.string.open_file)));
            return false;
        } catch (SecurityException e2) {
            if (intent.getAction() == "android.intent.action.CALL_PRIVILEGED") {
                C3890m.m14999e("Mms/PackageInfo", "Call privilige not permitted, use ACTION_CALL instead");
                intent.setAction("android.intent.action.CALL");
                m15050a(context, intent);
            }
        }
        return true;
    }

    /* renamed from: a */
    public static void m15049a(Context context, Uri uri, String str) {
        m15050a(context, m15047a(uri, str));
    }

    /* renamed from: b */
    public static void m15052b(Context context, Uri uri, String str) {
        Intent intentM15047a = m15047a(uri, str);
        if (m15051a(context, "com.sec.android.app.videoplayer")) {
            intentM15047a.setClassName("com.sec.android.app.videoplayer", "com.sec.android.app.videoplayer.activity.MoviePlayer");
        }
        m15050a(context, intentM15047a);
    }

    /* renamed from: c */
    public static void m15053c(Context context, Uri uri, String str) {
        Intent intentM15047a = m15047a(uri, str);
        if (m15051a(context, "com.android.calendar")) {
            intentM15047a.setClassName("com.android.calendar", "com.android.calendar.vcal.VCalListActivity");
        }
        m15050a(context, intentM15047a);
    }

    /* renamed from: d */
    public static void m15054d(Context context, Uri uri, String str) {
        Intent intentM15047a = m15047a(uri, str);
        if (m15051a(context, "com.sec.android.gallery3d")) {
            intentM15047a.setClassName("com.sec.android.gallery3d", "com.sec.android.gallery3d.app.Gallery");
        }
        intentM15047a.putExtra("android.intent.extra.showActionIcons", false);
        intentM15047a.putExtra("single_mode", true);
        m15050a(context, intentM15047a);
    }

    /* renamed from: a */
    public static Intent m15047a(Uri uri, String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(1);
        intent.setDataAndType(uri, str);
        return intent;
    }

    /* renamed from: e */
    public static void m15055e(Context context, Uri uri, String str) {
        m15056f(context, uri, str);
    }

    /* renamed from: f */
    public static void m15056f(Context context, Uri uri, String str) {
        Intent intentM15047a = m15047a(uri, str);
        intentM15047a.putExtra("showDetail", true);
        m15050a(context, intentM15047a);
    }

    /* renamed from: g */
    public static void m15057g(Context context, Uri uri, String str) {
        Intent intentM15047a = m15047a(uri, str);
        if (m15051a(context, "com.android.calendar")) {
            intentM15047a.setClassName("com.android.calendar", "com.android.calendar.vcal.VTaskListActivity");
        }
        m15050a(context, intentM15047a);
    }

    /* renamed from: a */
    public static Intent m15048a(String str) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.putExtra("com.android.browser.application_id", GlobalApplication.m10279a().getPackageName());
        intent.setFlags(MotionRecognitionManager.EVENT_SMART_SCROLL);
        return intent;
    }
}
