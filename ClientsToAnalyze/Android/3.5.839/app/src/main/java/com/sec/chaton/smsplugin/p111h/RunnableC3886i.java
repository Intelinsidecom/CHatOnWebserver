package com.sec.chaton.smsplugin.p111h;

import android.widget.Toast;

/* compiled from: DownloadManager.java */
/* renamed from: com.sec.chaton.smsplugin.h.i */
/* loaded from: classes.dex */
class RunnableC3886i implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f13983a;

    /* renamed from: b */
    final /* synthetic */ C3881d f13984b;

    RunnableC3886i(C3881d c3881d, int i) {
        this.f13984b = c3881d;
        this.f13983a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            C3881d.m14973d();
            Toast.makeText(this.f13984b.f13972a, this.f13983a, 1).show();
        } catch (Exception e) {
            C3890m.m14999e("DownloadManager", "Caught an exception in showErrorCodeToast");
        }
    }
}
