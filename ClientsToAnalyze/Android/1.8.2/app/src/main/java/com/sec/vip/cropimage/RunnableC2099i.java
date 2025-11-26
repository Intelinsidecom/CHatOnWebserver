package com.sec.vip.cropimage;

import android.app.ProgressDialog;
import android.os.Handler;

/* compiled from: ImageModify.java */
/* renamed from: com.sec.vip.cropimage.i */
/* loaded from: classes.dex */
class RunnableC2099i extends C2117n implements Runnable {

    /* renamed from: a */
    private final MonitoredActivity f7627a;

    /* renamed from: b */
    private final Runnable f7628b;

    /* renamed from: c */
    private final Handler f7629c;

    /* renamed from: d */
    private final Runnable f7630d = new RunnableC2113j(this);

    public RunnableC2099i(MonitoredActivity monitoredActivity, Runnable runnable, ProgressDialog progressDialog, Handler handler) {
        this.f7627a = monitoredActivity;
        this.f7628b = runnable;
        this.f7627a.m7316a(this);
        this.f7629c = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f7628b.run();
        } finally {
            this.f7629c.post(this.f7630d);
        }
    }

    @Override // com.sec.vip.cropimage.C2117n, com.sec.vip.cropimage.InterfaceC2118o
    /* renamed from: a */
    public void mo7383a(MonitoredActivity monitoredActivity) {
        this.f7630d.run();
        this.f7629c.removeCallbacks(this.f7630d);
    }
}
