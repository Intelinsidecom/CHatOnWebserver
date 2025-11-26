package com.sec.vip.cropimage.honeycomb;

import android.app.ProgressDialog;
import android.os.Handler;
import com.sec.vip.cropimage.C2117n;
import com.sec.vip.cropimage.MonitoredActivity;

/* compiled from: CropImage.java */
/* renamed from: com.sec.vip.cropimage.honeycomb.m */
/* loaded from: classes.dex */
class RunnableC2097m extends C2117n implements Runnable {

    /* renamed from: a */
    private final MonitoredActivity f7621a;

    /* renamed from: b */
    private final ProgressDialog f7622b;

    /* renamed from: c */
    private final Runnable f7623c;

    /* renamed from: d */
    private final Handler f7624d;

    /* renamed from: e */
    private final Runnable f7625e = new RunnableC2098n(this);

    public RunnableC2097m(MonitoredActivity monitoredActivity, Runnable runnable, ProgressDialog progressDialog, Handler handler) {
        this.f7621a = monitoredActivity;
        this.f7622b = progressDialog;
        this.f7623c = runnable;
        this.f7621a.m7316a(this);
        this.f7624d = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f7623c.run();
        } finally {
            this.f7624d.post(this.f7625e);
        }
    }

    @Override // com.sec.vip.cropimage.C2117n, com.sec.vip.cropimage.InterfaceC2118o
    /* renamed from: a */
    public void mo7383a(MonitoredActivity monitoredActivity) {
        this.f7625e.run();
        this.f7624d.removeCallbacks(this.f7625e);
    }

    @Override // com.sec.vip.cropimage.C2117n, com.sec.vip.cropimage.InterfaceC2118o
    /* renamed from: d */
    public void mo7385d(MonitoredActivity monitoredActivity) {
        if (this.f7622b != null) {
            this.f7622b.hide();
        }
    }

    @Override // com.sec.vip.cropimage.C2117n, com.sec.vip.cropimage.InterfaceC2118o
    /* renamed from: c */
    public void mo7384c(MonitoredActivity monitoredActivity) {
        if (this.f7622b != null) {
            this.f7622b.show();
        }
    }
}
