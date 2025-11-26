package com.sec.vip.cropimage;

import android.app.ProgressDialog;
import android.os.Handler;

/* compiled from: ImageModify.java */
/* renamed from: com.sec.vip.cropimage.ab */
/* loaded from: classes.dex */
class RunnableC3596ab extends C3603ai implements Runnable {

    /* renamed from: a */
    private final MonitoredActivity f13251a;

    /* renamed from: b */
    private final Runnable f13252b;

    /* renamed from: c */
    private final Handler f13253c;

    /* renamed from: d */
    private final Runnable f13254d = new RunnableC3597ac(this);

    public RunnableC3596ab(MonitoredActivity monitoredActivity, Runnable runnable, ProgressDialog progressDialog, Handler handler) {
        this.f13251a = monitoredActivity;
        this.f13252b = runnable;
        this.f13251a.m12975a(this);
        this.f13253c = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f13252b.run();
        } finally {
            this.f13253c.post(this.f13254d);
        }
    }

    @Override // com.sec.vip.cropimage.C3603ai, com.sec.vip.cropimage.InterfaceC3604aj
    /* renamed from: a */
    public void mo12978a(MonitoredActivity monitoredActivity) {
        this.f13254d.run();
        this.f13253c.removeCallbacks(this.f13254d);
    }
}
