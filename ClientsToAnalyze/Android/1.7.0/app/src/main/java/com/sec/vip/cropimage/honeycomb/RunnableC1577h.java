package com.sec.vip.cropimage.honeycomb;

import android.app.ProgressDialog;
import android.os.Handler;
import com.sec.vip.cropimage.C1562a;
import com.sec.vip.cropimage.MonitoredActivity;

/* compiled from: CropImage.java */
/* renamed from: com.sec.vip.cropimage.honeycomb.h */
/* loaded from: classes.dex */
class RunnableC1577h extends C1562a implements Runnable {

    /* renamed from: a */
    private final MonitoredActivity f5554a;

    /* renamed from: b */
    private final ProgressDialog f5555b;

    /* renamed from: c */
    private final Runnable f5556c;

    /* renamed from: d */
    private final Handler f5557d;

    /* renamed from: e */
    private final Runnable f5558e = new RunnableC1576g(this);

    public RunnableC1577h(MonitoredActivity monitoredActivity, Runnable runnable, ProgressDialog progressDialog, Handler handler) {
        this.f5554a = monitoredActivity;
        this.f5555b = progressDialog;
        this.f5556c = runnable;
        this.f5554a.m5726a(this);
        this.f5557d = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f5556c.run();
        } finally {
            this.f5557d.post(this.f5558e);
        }
    }

    @Override // com.sec.vip.cropimage.C1562a, com.sec.vip.cropimage.InterfaceC1601r
    /* renamed from: b */
    public void mo5729b(MonitoredActivity monitoredActivity) {
        this.f5558e.run();
        this.f5557d.removeCallbacks(this.f5558e);
    }

    @Override // com.sec.vip.cropimage.C1562a, com.sec.vip.cropimage.InterfaceC1601r
    /* renamed from: d */
    public void mo5731d(MonitoredActivity monitoredActivity) {
        if (this.f5555b != null) {
            this.f5555b.hide();
        }
    }

    @Override // com.sec.vip.cropimage.C1562a, com.sec.vip.cropimage.InterfaceC1601r
    /* renamed from: c */
    public void mo5730c(MonitoredActivity monitoredActivity) {
        if (this.f5555b != null) {
            this.f5555b.show();
        }
    }
}
