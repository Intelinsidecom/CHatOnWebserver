package com.sec.vip.cropimage;

import android.app.ProgressDialog;
import android.os.Handler;

/* compiled from: ImageModify.java */
/* renamed from: com.sec.vip.cropimage.n */
/* loaded from: classes.dex */
class RunnableC5127n extends C5133t implements Runnable {

    /* renamed from: a */
    private final MonitoredActivity f18700a;

    /* renamed from: b */
    private final Runnable f18701b;

    /* renamed from: c */
    private final Handler f18702c;

    /* renamed from: d */
    private final Runnable f18703d;

    /* synthetic */ RunnableC5127n(MonitoredActivity monitoredActivity, Runnable runnable, ProgressDialog progressDialog, Handler handler, ViewOnClickListenerC5116c viewOnClickListenerC5116c) {
        this(monitoredActivity, runnable, progressDialog, handler);
    }

    private RunnableC5127n(MonitoredActivity monitoredActivity, Runnable runnable, ProgressDialog progressDialog, Handler handler) {
        this.f18703d = new RunnableC5128o(this);
        this.f18700a = monitoredActivity;
        this.f18701b = runnable;
        this.f18700a.m19566a(this);
        this.f18702c = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f18701b.run();
        } finally {
            this.f18702c.post(this.f18703d);
        }
    }

    @Override // com.sec.vip.cropimage.C5133t, com.sec.vip.cropimage.InterfaceC5134u
    /* renamed from: a */
    public void mo19587a(MonitoredActivity monitoredActivity) {
        this.f18703d.run();
        this.f18702c.removeCallbacks(this.f18703d);
    }
}
