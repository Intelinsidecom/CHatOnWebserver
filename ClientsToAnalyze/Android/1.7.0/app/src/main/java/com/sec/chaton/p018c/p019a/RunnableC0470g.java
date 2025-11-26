package com.sec.chaton.p018c.p019a;

import com.sec.chaton.util.C1341p;

/* compiled from: FileDownloadTask2.java */
/* renamed from: com.sec.chaton.c.a.g */
/* loaded from: classes.dex */
class RunnableC0470g implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AsyncTaskC0466c f1504a;

    RunnableC0470g(AsyncTaskC0466c asyncTaskC0466c) {
        this.f1504a = asyncTaskC0466c;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (C0473j.m2410a().m2416d(this.f1504a.f1468f)) {
            C1341p.m4658b("Successfully removed from hashmap after down-load", getClass().getName());
        }
    }
}
