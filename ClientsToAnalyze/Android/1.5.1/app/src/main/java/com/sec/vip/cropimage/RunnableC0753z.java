package com.sec.vip.cropimage;

import android.app.ProgressDialog;
import android.os.Handler;
import com.sec.vip.cropimage.MonitoredActivity;

/* renamed from: com.sec.vip.cropimage.z */
/* loaded from: classes.dex */
class RunnableC0753z extends MonitoredActivity.LifeCycleAdapter implements Runnable {

    /* renamed from: a */
    private final MonitoredActivity f4522a;

    /* renamed from: b */
    private final ProgressDialog f4523b;

    /* renamed from: c */
    private final Runnable f4524c;

    /* renamed from: d */
    private final Handler f4525d;

    /* renamed from: e */
    private final Runnable f4526e = new RunnableC0727ac(this);

    public RunnableC0753z(MonitoredActivity monitoredActivity, Runnable runnable, ProgressDialog progressDialog, Handler handler) {
        this.f4522a = monitoredActivity;
        this.f4523b = progressDialog;
        this.f4524c = runnable;
        this.f4522a.m4330a(this);
        this.f4525d = handler;
    }

    @Override // com.sec.vip.cropimage.MonitoredActivity.LifeCycleAdapter, com.sec.vip.cropimage.MonitoredActivity.LifeCycleListener
    /* renamed from: b */
    public void mo4333b(MonitoredActivity monitoredActivity) {
        this.f4526e.run();
        this.f4525d.removeCallbacks(this.f4526e);
    }

    @Override // com.sec.vip.cropimage.MonitoredActivity.LifeCycleAdapter, com.sec.vip.cropimage.MonitoredActivity.LifeCycleListener
    /* renamed from: c */
    public void mo4334c(MonitoredActivity monitoredActivity) {
        this.f4523b.show();
    }

    @Override // com.sec.vip.cropimage.MonitoredActivity.LifeCycleAdapter, com.sec.vip.cropimage.MonitoredActivity.LifeCycleListener
    /* renamed from: d */
    public void mo4335d(MonitoredActivity monitoredActivity) {
        this.f4523b.hide();
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f4524c.run();
        } finally {
            this.f4525d.post(this.f4526e);
        }
    }
}
