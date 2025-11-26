package com.sec.chaton.facebook;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.Fragment;
import com.p001a.p002a.C0027b;
import com.p001a.p002a.C0036k;
import com.p001a.p002a.C0037l;
import com.sec.chaton.util.C1786r;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: FacebookManager.java */
/* renamed from: com.sec.chaton.facebook.f */
/* loaded from: classes.dex */
public class C0725f {

    /* renamed from: b */
    private static C0027b f2701b;

    /* renamed from: a */
    Handler f2702a;

    /* renamed from: c */
    private Activity f2703c;

    /* renamed from: d */
    private InterfaceC0736q f2704d;

    /* renamed from: e */
    private ArrayList f2705e;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static void m3213c(String str) {
        C1786r.m6061b(str, "FacebookManager");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static void m3214d(String str) {
        C1786r.m6054a(str, "FacebookManager");
    }

    public C0725f(Activity activity, InterfaceC0736q interfaceC0736q) {
        this.f2705e = new ArrayList();
        this.f2702a = new HandlerC0726g(this);
        if (f2701b == null) {
            f2701b = new C0027b("254066384616989");
        }
        this.f2703c = activity;
        C0036k.m34b(f2701b, activity);
        this.f2704d = interfaceC0736q;
    }

    public C0725f(Fragment fragment, InterfaceC0736q interfaceC0736q) {
        this(fragment.getActivity(), interfaceC0736q);
        f2701b.m13a(fragment);
    }

    /* renamed from: a */
    public void m3217a(int i) {
        m3210b(i, null);
    }

    /* renamed from: a */
    private void m3206a(int i, AbstractC0728i abstractC0728i) {
        if (m3224c()) {
            this.f2704d.mo3204a(i, false);
            new AsyncTaskC0729j(this, i, null).execute(abstractC0728i);
        } else {
            m3210b(i, abstractC0728i);
        }
    }

    /* renamed from: a */
    public String m3216a() {
        return C0036k.m32b(this.f2703c);
    }

    /* renamed from: b */
    public String m3221b() {
        return C0036k.m35c(this.f2703c);
    }

    /* renamed from: b */
    private void m3210b(int i, AbstractC0728i abstractC0728i) {
        f2701b.m11a(this.f2703c, new String[]{"user_photos", "publish_stream", "read_stream", "email"}, new C0731l(this, i, abstractC0728i, null));
    }

    /* renamed from: a */
    public void m3218a(int i, int i2, Intent intent) {
        m3213c("Login onActivityResult requstCode=" + i + ", resultCode=" + i2);
        f2701b.m8a(i, i2, intent);
    }

    /* renamed from: b */
    public void m3222b(int i) {
        HandlerC0726g handlerC0726g = null;
        new AsyncTaskC0729j(this, i, handlerC0726g).execute(new C0735p(this, handlerC0726g));
    }

    /* renamed from: c */
    public boolean m3224c() {
        return f2701b.m15a();
    }

    /* renamed from: a */
    public static void m3207a(Context context) {
        C0036k.m29a(context);
        C0037l.m41a(context);
    }

    /* renamed from: c */
    public void m3223c(int i) {
        m3206a(i, new C0733n(this, null));
    }

    /* renamed from: a */
    public void m3220a(int i, String str, String str2) {
        m3206a(i, new C0737r(this, str, str2, null));
    }

    /* renamed from: a */
    public void m3219a(int i, int i2, String str) {
        m3206a(i, new C0738s(this, i2, str, null, 0 == true ? 1 : 0));
    }

    /* renamed from: d */
    public void m3225d() {
        m3213c("killAllTask() \t- BlockingTaskListCount : " + this.f2705e.size() + "\tBlockingTaskList : " + this.f2705e);
        Iterator it = this.f2705e.iterator();
        while (it.hasNext()) {
            AsyncTaskC0729j asyncTaskC0729j = (AsyncTaskC0729j) it.next();
            if (asyncTaskC0729j != null) {
                asyncTaskC0729j.cancel(true);
            }
        }
        this.f2705e.clear();
    }
}
