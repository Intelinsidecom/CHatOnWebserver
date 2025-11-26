package com.sec.chaton.p013a.p014a;

import android.os.AsyncTask;
import android.os.Build;
import com.sec.chaton.p025d.EnumC0665r;
import com.sec.chaton.util.C1341p;

/* compiled from: DeliveryChatTask.java */
/* renamed from: com.sec.chaton.a.a.z */
/* loaded from: classes.dex */
class RunnableC0187z implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f463a;

    /* renamed from: b */
    final /* synthetic */ String f464b;

    /* renamed from: c */
    final /* synthetic */ String f465c;

    /* renamed from: d */
    final /* synthetic */ String f466d;

    /* renamed from: e */
    final /* synthetic */ long f467e;

    /* renamed from: f */
    final /* synthetic */ EnumC0665r f468f;

    /* renamed from: g */
    final /* synthetic */ String f469g;

    /* renamed from: h */
    final /* synthetic */ C0182u f470h;

    RunnableC0187z(C0182u c0182u, String str, String str2, String str3, String str4, long j, EnumC0665r enumC0665r, String str5) {
        this.f470h = c0182u;
        this.f463a = str;
        this.f464b = str2;
        this.f465c = str3;
        this.f466d = str4;
        this.f467e = j;
        this.f468f = enumC0665r;
        this.f469g = str5;
    }

    @Override // java.lang.Runnable
    public void run() {
        AsyncTaskC0140ap asyncTaskC0140ap = new AsyncTaskC0140ap(this.f463a, this.f464b, this.f465c, true, this.f466d, this.f467e, this.f468f, this.f469g);
        if (Build.VERSION.SDK_INT < 11) {
            asyncTaskC0140ap.execute(new String[0]);
        } else {
            asyncTaskC0140ap.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
        }
        C1341p.m4658b("[Download (URL)] " + this.f463a, getClass().getName());
        C1341p.m4658b("[Download (FileName)] " + this.f465c, getClass().getName());
    }
}
