package com.sec.chaton.facebook;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import com.facebook.android.Facebook;
import com.facebook.android.SessionStore;
import com.facebook.android.Util;
import com.sec.chaton.util.ChatONLogWriter;

/* loaded from: classes.dex */
public class FacebookManager {

    /* renamed from: a */
    private static Facebook f1836a;

    /* renamed from: b */
    private Activity f1837b;

    /* renamed from: c */
    private OnResultListener f1838c;

    public interface OnResultListener {
        void onReady(int i, boolean z);

        void onResult(int i, int i2, String str);
    }

    public FacebookManager(Activity activity, OnResultListener onResultListener) {
        if (f1836a == null) {
            f1836a = new Facebook("254066384616989");
        }
        this.f1837b = activity;
        SessionStore.m258b(f1836a, activity);
        this.f1838c = onResultListener;
    }

    /* renamed from: a */
    private void m2341a(int i, AbstractC0231m abstractC0231m) {
        if (!m2356b()) {
            m2345b(i, abstractC0231m);
        } else {
            this.f1838c.onReady(i, false);
            new AsyncTaskC0230l(this, i).execute(abstractC0231m);
        }
    }

    /* renamed from: a */
    public static void m2342a(Context context) {
        SessionStore.m254a(context);
        Util.m264a(context);
    }

    /* renamed from: b */
    private void m2345b(int i, AbstractC0231m abstractC0231m) {
        f1836a.m237a(this.f1837b, new String[]{"user_photos", "publish_stream", "read_stream", "email"}, new C0226h(this, i, abstractC0231m));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static void m2348c(String str) {
        ChatONLogWriter.m3506b(str, "FacebookManager");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static void m2349d(String str) {
        ChatONLogWriter.m3499a(str, "FacebookManager");
    }

    /* renamed from: a */
    public String m2350a() {
        return SessionStore.m257b(this.f1837b);
    }

    /* renamed from: a */
    public void m2351a(int i) {
        m2345b(i, null);
    }

    /* renamed from: a */
    public void m2352a(int i, int i2, Intent intent) {
        m2348c("Login onActivityResult requstCode=" + i + ", resultCode=" + i2);
        f1836a.m234a(i, i2, intent);
    }

    /* renamed from: a */
    public void m2353a(int i, int i2, String str) {
        m2341a(i, new C0232n(this, i2, str, (String[]) null));
    }

    /* renamed from: a */
    public void m2354a(int i, Bitmap bitmap, String str) {
        m2341a(i, new C0232n(this, bitmap, str, (String[]) null));
    }

    /* renamed from: b */
    public void m2355b(int i) {
        C0227i c0227i = null;
        new AsyncTaskC0230l(this, i).execute(new C0219a(this));
    }

    /* renamed from: b */
    public boolean m2356b() {
        return f1836a.m240a();
    }
}
