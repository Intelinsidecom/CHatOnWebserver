package com.sec.vip.cropimage.ics;

import android.app.ProgressDialog;
import android.os.Handler;
import com.sec.vip.cropimage.C1562a;
import com.sec.vip.cropimage.MonitoredActivity;

/* compiled from: CropImage.java */
/* renamed from: com.sec.vip.cropimage.ics.a */
/* loaded from: classes.dex */
class RunnableC1579a extends C1562a implements Runnable {

    /* renamed from: a */
    private final MonitoredActivity f5589a;

    /* renamed from: b */
    private final ProgressDialog f5590b;

    /* renamed from: c */
    private final Runnable f5591c;

    /* renamed from: d */
    private final Handler f5592d;

    /* renamed from: e */
    private final Runnable f5593e = new RunnableC1592n(this);

    public RunnableC1579a(MonitoredActivity monitoredActivity, Runnable runnable, ProgressDialog progressDialog, Handler handler) {
        this.f5589a = monitoredActivity;
        this.f5590b = progressDialog;
        this.f5591c = runnable;
        this.f5589a.m5726a(this);
        this.f5592d = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f5591c.run();
        } finally {
            this.f5592d.post(this.f5593e);
        }
    }

    @Override // com.sec.vip.cropimage.C1562a, com.sec.vip.cropimage.InterfaceC1601r
    /* renamed from: b */
    public void mo5729b(MonitoredActivity monitoredActivity) {
        this.f5593e.run();
        this.f5592d.removeCallbacks(this.f5593e);
    }

    @Override // com.sec.vip.cropimage.C1562a, com.sec.vip.cropimage.InterfaceC1601r
    /* renamed from: d */
    public void mo5731d(MonitoredActivity monitoredActivity) {
        if (this.f5590b != null) {
            this.f5590b.hide();
        }
    }

    @Override // com.sec.vip.cropimage.C1562a, com.sec.vip.cropimage.InterfaceC1601r
    /* renamed from: c */
    public void mo5730c(MonitoredActivity monitoredActivity) {
        if (this.f5590b != null) {
            this.f5590b.show();
        }
    }
}
