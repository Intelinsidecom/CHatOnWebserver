package com.sec.vip.cropimage;

import android.app.ProgressDialog;
import android.os.Handler;

/* compiled from: CropImage.java */
/* renamed from: com.sec.vip.cropimage.l */
/* loaded from: classes.dex */
class RunnableC3616l extends C3603ai implements Runnable {

    /* renamed from: a */
    private final MonitoredActivity f13290a;

    /* renamed from: b */
    private final ProgressDialog f13291b;

    /* renamed from: c */
    private final Runnable f13292c;

    /* renamed from: d */
    private final Handler f13293d;

    /* renamed from: e */
    private final Runnable f13294e = new RunnableC3617m(this);

    public RunnableC3616l(MonitoredActivity monitoredActivity, Runnable runnable, ProgressDialog progressDialog, Handler handler) {
        this.f13290a = monitoredActivity;
        this.f13291b = progressDialog;
        this.f13292c = runnable;
        this.f13290a.m12975a(this);
        this.f13293d = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f13292c.run();
        } finally {
            this.f13293d.post(this.f13294e);
        }
    }

    @Override // com.sec.vip.cropimage.C3603ai, com.sec.vip.cropimage.InterfaceC3604aj
    /* renamed from: a */
    public void mo12978a(MonitoredActivity monitoredActivity) {
        this.f13294e.run();
        this.f13293d.removeCallbacks(this.f13294e);
    }

    @Override // com.sec.vip.cropimage.C3603ai, com.sec.vip.cropimage.InterfaceC3604aj
    /* renamed from: b */
    public void mo12981b(MonitoredActivity monitoredActivity) {
        if (this.f13291b != null) {
            this.f13291b.hide();
        }
    }

    @Override // com.sec.vip.cropimage.C3603ai, com.sec.vip.cropimage.InterfaceC3604aj
    /* renamed from: c */
    public void mo12982c(MonitoredActivity monitoredActivity) {
        if (this.f13291b != null) {
            this.f13291b.show();
        }
    }
}
