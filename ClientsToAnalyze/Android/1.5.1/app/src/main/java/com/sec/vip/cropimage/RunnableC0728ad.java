package com.sec.vip.cropimage;

import android.app.ProgressDialog;
import android.os.Handler;
import com.sec.vip.cropimage.MonitoredActivity;

/* renamed from: com.sec.vip.cropimage.ad */
/* loaded from: classes.dex */
class RunnableC0728ad extends MonitoredActivity.LifeCycleAdapter implements Runnable {

    /* renamed from: a */
    private final MonitoredActivity f4451a;

    /* renamed from: b */
    private final ProgressDialog f4452b;

    /* renamed from: c */
    private final Runnable f4453c;

    /* renamed from: d */
    private final Handler f4454d;

    /* renamed from: e */
    private final Runnable f4455e = new RunnableC0725aa(this);

    public RunnableC0728ad(MonitoredActivity monitoredActivity, Runnable runnable, ProgressDialog progressDialog, Handler handler) {
        this.f4451a = monitoredActivity;
        this.f4452b = progressDialog;
        this.f4453c = runnable;
        this.f4451a.m4330a(this);
        this.f4454d = handler;
    }

    @Override // com.sec.vip.cropimage.MonitoredActivity.LifeCycleAdapter, com.sec.vip.cropimage.MonitoredActivity.LifeCycleListener
    /* renamed from: b */
    public void mo4333b(MonitoredActivity monitoredActivity) {
        this.f4455e.run();
        this.f4454d.removeCallbacks(this.f4455e);
    }

    @Override // com.sec.vip.cropimage.MonitoredActivity.LifeCycleAdapter, com.sec.vip.cropimage.MonitoredActivity.LifeCycleListener
    /* renamed from: c */
    public void mo4334c(MonitoredActivity monitoredActivity) {
        this.f4452b.show();
    }

    @Override // com.sec.vip.cropimage.MonitoredActivity.LifeCycleAdapter, com.sec.vip.cropimage.MonitoredActivity.LifeCycleListener
    /* renamed from: d */
    public void mo4335d(MonitoredActivity monitoredActivity) {
        this.f4452b.hide();
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f4453c.run();
        } finally {
            this.f4454d.post(this.f4455e);
        }
    }
}
