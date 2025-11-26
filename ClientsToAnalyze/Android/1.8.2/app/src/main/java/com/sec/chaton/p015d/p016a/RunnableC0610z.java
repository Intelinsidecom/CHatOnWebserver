package com.sec.chaton.p015d.p016a;

import android.app.ProgressDialog;
import com.sec.chaton.chat.ViewOnClickListenerC0477as;
import com.sec.chaton.p022h.p025c.C0777a;
import com.sec.chaton.util.C1786r;

/* compiled from: FileDownloadTask2.java */
/* renamed from: com.sec.chaton.d.a.z */
/* loaded from: classes.dex */
class RunnableC0610z implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f2421a;

    /* renamed from: b */
    final /* synthetic */ AsyncTaskC0608x f2422b;

    RunnableC0610z(AsyncTaskC0608x asyncTaskC0608x, String str) {
        this.f2422b = asyncTaskC0608x;
        this.f2421a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (C0777a.m3326a().m3332d(this.f2422b.f2400f)) {
            C1786r.m6061b("Successfully removed from hashmap after down-load", getClass().getName());
        }
        if (this.f2422b.f2419z != null) {
            this.f2422b.f2419z.hide();
            ViewOnClickListenerC0477as.m2630a(this.f2422b.f2414t, this.f2422b.f2410p, this.f2421a, (ProgressDialog) null, this.f2422b.f2400f);
        }
    }
}
