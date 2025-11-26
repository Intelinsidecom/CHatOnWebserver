package com.sec.chaton.base;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.receiver.ScreenReceiver;
import com.sec.chaton.util.C4875cm;
import com.sec.chaton.util.C4892m;
import com.sec.chaton.util.C4904y;

/* compiled from: ActivityHelper.java */
/* renamed from: com.sec.chaton.base.a */
/* loaded from: classes.dex */
public class C1059a {

    /* renamed from: a */
    public static boolean f3350a;

    /* renamed from: b */
    private static boolean f3351b;

    /* renamed from: c */
    private static final String f3352c = C1059a.class.getSimpleName();

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public static void m6164a(Activity activity, Bundle bundle) {
        if (C4904y.f17872b) {
            C4904y.m18639b(activity.getClass().getSimpleName() + " ,onCreate : " + activity.isTaskRoot(), f3352c);
        }
        C4875cm.m18511a(activity);
        if (!f3350a) {
            m6165a(false);
        }
        if (Build.VERSION.SDK_INT >= 11) {
            LayoutInflater.from(activity).setFactory2(new LayoutInflaterFactory2C1060b());
        }
    }

    /* renamed from: a */
    public static void m6163a(Activity activity) {
        Intent intentM18566a;
        boolean booleanExtra = activity.getIntent().getBooleanExtra(C4892m.f17834a, false);
        if (C4904y.f17872b) {
            C4904y.m18639b(activity.getClass().getSimpleName() + " ,onStart, fromMe :" + booleanExtra, f3352c);
        }
        if (!booleanExtra) {
            C4892m.m18572b(activity, f3351b);
            if (C4892m.m18575b(activity) && (intentM18566a = C4892m.m18566a((Context) activity)) != null) {
                activity.startActivity(intentM18566a);
            }
        }
        f3351b = false;
    }

    /* renamed from: b */
    public static void m6166b(Activity activity) {
        Intent intentM18566a;
        if (C4904y.f17872b) {
            C4904y.m18639b(activity.getClass().getSimpleName() + " ,onResume", f3352c);
        }
        if (C4892m.m18579c(activity) && (intentM18566a = C4892m.m18566a((Context) activity)) != null) {
            activity.startActivity(intentM18566a);
        }
    }

    /* renamed from: c */
    public static void m6167c(Activity activity) {
        boolean zIsFinishing = activity.isFinishing();
        if (C4904y.f17872b) {
            C4904y.m18639b(activity.getClass().getSimpleName() + " ,onPause, isFinish :" + zIsFinishing, f3352c);
        }
        C4892m.m18569a(activity, zIsFinishing);
    }

    /* renamed from: d */
    public static void m6168d(Activity activity) {
        if (C4904y.f17872b) {
            C4904y.m18639b(activity.getClass().getSimpleName() + " ,onUserLeaveHint", f3352c);
        }
        C4892m.m18589h(true);
    }

    /* renamed from: e */
    public static void m6169e(Activity activity) {
        if (C4904y.f17872b) {
            C4904y.m18639b(activity.getClass().getSimpleName() + " ,onActivityResult", f3352c);
        }
        f3351b = true;
    }

    /* renamed from: f */
    public static void m6170f(Activity activity) {
        if (C4904y.f17872b) {
            C4904y.m18639b(activity.getClass().getSimpleName() + " ,onStop", f3352c);
        }
        C4892m.m18568a(activity);
    }

    /* renamed from: g */
    public static void m6171g(Activity activity) {
        boolean zIsTaskRoot = activity.isTaskRoot();
        if (C4904y.f17872b) {
            C4904y.m18639b(activity.getClass().getSimpleName() + " ,onDestroy, isTaskRoot : " + zIsTaskRoot, f3352c);
        }
        if (zIsTaskRoot) {
            C4892m.m18570a(false);
            C4892m.m18593l();
        }
    }

    /* renamed from: a */
    public static void m6165a(boolean z) {
        Context contextR = GlobalApplication.m18732r();
        String string = contextR.getSharedPreferences("PASSWORD_LOCK", 0).getString("LOCK_STATE", C4892m.m18588h());
        if (z || !string.equals(C4892m.m18588h())) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            contextR.registerReceiver(new ScreenReceiver(), intentFilter);
            f3350a = true;
        }
        if (C4904y.f17872b) {
            C4904y.m18639b("registerScreenReciever : " + f3350a, f3352c);
        }
    }
}
