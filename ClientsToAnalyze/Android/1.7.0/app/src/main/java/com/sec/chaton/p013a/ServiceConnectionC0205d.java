package com.sec.chaton.p013a;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.sec.chaton.util.C1341p;

/* compiled from: AbstractServiceWrapper.java */
/* renamed from: com.sec.chaton.a.d */
/* loaded from: classes.dex */
class ServiceConnectionC0205d implements ServiceConnection {

    /* renamed from: a */
    final /* synthetic */ AbstractC0191ad f503a;

    ServiceConnectionC0205d(AbstractC0191ad abstractC0191ad) {
        this.f503a = abstractC0191ad;
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f503a.f477b = null;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        C1341p.m4658b("ServiceConnection.onServiceConnected", AbstractC0191ad.f475c);
        this.f503a.f477b = this.f503a.mo735b(iBinder);
        this.f503a.f479e = false;
        synchronized (this.f503a) {
            this.f503a.m736c();
            this.f503a.m737d();
            for (Runnable runnable : this.f503a.f478d) {
                this.f503a.m737d();
                runnable.run();
            }
            this.f503a.m738e();
            this.f503a.f478d.clear();
        }
    }
}
