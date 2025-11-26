package com.sec.chaton.facebook;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.p001a.p002a.C0036a;
import com.p001a.p002a.C0037b;
import com.p001a.p002a.C0043h;
import com.sec.chaton.util.C1341p;

/* compiled from: FacebookManager.java */
/* renamed from: com.sec.chaton.facebook.o */
/* loaded from: classes.dex */
public class C0700o {

    /* renamed from: a */
    private static C0043h f2375a;

    /* renamed from: b */
    private Activity f2376b;

    /* renamed from: c */
    private InterfaceC0698m f2377c;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static void m3078c(String str) {
        C1341p.m4658b(str, "FacebookManager");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static void m3079d(String str) {
        C1341p.m4651a(str, "FacebookManager");
    }

    public C0700o(Activity activity, InterfaceC0698m interfaceC0698m) {
        if (f2375a == null) {
            f2375a = new C0043h("254066384616989");
        }
        this.f2376b = activity;
        C0037b.m14b(f2375a, activity);
        this.f2377c = interfaceC0698m;
    }

    /* renamed from: a */
    public void m3081a(int i) {
        m3075b(i, null);
    }

    /* renamed from: a */
    private void m3071a(int i, AbstractC0701p abstractC0701p) {
        if (m3085b()) {
            this.f2377c.mo3067a(i, false);
            new AsyncTaskC0699n(this, i).execute(abstractC0701p);
        } else {
            m3075b(i, abstractC0701p);
        }
    }

    /* renamed from: a */
    public String m3080a() {
        return C0037b.m13b(this.f2376b);
    }

    /* renamed from: b */
    private void m3075b(int i, AbstractC0701p abstractC0701p) {
        f2375a.m29a(this.f2376b, new String[]{"user_photos", "publish_stream", "read_stream", "email"}, new C0694i(this, i, abstractC0701p));
    }

    /* renamed from: a */
    public void m3082a(int i, int i2, Intent intent) {
        m3078c("Login onActivityResult requstCode=" + i + ", resultCode=" + i2);
        f2375a.m26a(i, i2, intent);
    }

    /* renamed from: b */
    public void m3084b(int i) {
        C0695j c0695j = null;
        new AsyncTaskC0699n(this, i).execute(new C0686a(this));
    }

    /* renamed from: b */
    public boolean m3085b() {
        return f2375a.m32a();
    }

    /* renamed from: a */
    public static void m3072a(Context context) {
        C0037b.m10a(context);
        C0036a.m6a(context);
    }

    /* renamed from: a */
    public void m3083a(int i, int i2, String str) {
        m3071a(i, new C0702q(this, i2, str, null));
    }
}
