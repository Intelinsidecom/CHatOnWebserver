package com.sec.vip.cropimage.ics;

import android.app.ProgressDialog;
import android.os.Handler;
import com.sec.vip.cropimage.C2117n;
import com.sec.vip.cropimage.MonitoredActivity;

/* compiled from: CropImage.java */
/* renamed from: com.sec.vip.cropimage.ics.l */
/* loaded from: classes.dex */
class RunnableC2111l extends C2117n implements Runnable {

    /* renamed from: a */
    private final MonitoredActivity f7677a;

    /* renamed from: b */
    private final ProgressDialog f7678b;

    /* renamed from: c */
    private final Runnable f7679c;

    /* renamed from: d */
    private final Handler f7680d;

    /* renamed from: e */
    private final Runnable f7681e = new RunnableC2112m(this);

    public RunnableC2111l(MonitoredActivity monitoredActivity, Runnable runnable, ProgressDialog progressDialog, Handler handler) {
        this.f7677a = monitoredActivity;
        this.f7678b = progressDialog;
        this.f7679c = runnable;
        this.f7677a.m7316a(this);
        this.f7680d = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f7679c.run();
        } finally {
            this.f7680d.post(this.f7681e);
        }
    }

    @Override // com.sec.vip.cropimage.C2117n, com.sec.vip.cropimage.InterfaceC2118o
    /* renamed from: a */
    public void mo7383a(MonitoredActivity monitoredActivity) {
        this.f7681e.run();
        this.f7680d.removeCallbacks(this.f7681e);
    }

    @Override // com.sec.vip.cropimage.C2117n, com.sec.vip.cropimage.InterfaceC2118o
    /* renamed from: d */
    public void mo7385d(MonitoredActivity monitoredActivity) {
        if (this.f7678b != null) {
            this.f7678b.hide();
        }
    }

    @Override // com.sec.vip.cropimage.C2117n, com.sec.vip.cropimage.InterfaceC2118o
    /* renamed from: c */
    public void mo7384c(MonitoredActivity monitoredActivity) {
        if (this.f7678b != null) {
            this.f7678b.show();
        }
    }
}
