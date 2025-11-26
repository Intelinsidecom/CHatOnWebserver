package com.sec.vip.cropimage;

import android.app.ProgressDialog;
import android.os.Handler;

/* compiled from: ImageModify.java */
/* renamed from: com.sec.vip.cropimage.p */
/* loaded from: classes.dex */
class RunnableC1599p extends C1562a implements Runnable {

    /* renamed from: a */
    private final MonitoredActivity f5644a;

    /* renamed from: b */
    private final Runnable f5645b;

    /* renamed from: c */
    private final Handler f5646c;

    /* renamed from: d */
    private final Runnable f5647d = new RunnableC1602s(this);

    public RunnableC1599p(MonitoredActivity monitoredActivity, Runnable runnable, ProgressDialog progressDialog, Handler handler) {
        this.f5644a = monitoredActivity;
        this.f5645b = runnable;
        this.f5644a.m5726a(this);
        this.f5646c = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f5645b.run();
        } finally {
            this.f5646c.post(this.f5647d);
        }
    }

    @Override // com.sec.vip.cropimage.C1562a, com.sec.vip.cropimage.InterfaceC1601r
    /* renamed from: b */
    public void mo5729b(MonitoredActivity monitoredActivity) {
        this.f5647d.run();
        this.f5646c.removeCallbacks(this.f5647d);
    }
}
