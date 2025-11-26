package com.sec.chaton.p015d;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.sec.chaton.util.C1786r;

/* compiled from: AbstractServiceWrapper.java */
/* renamed from: com.sec.chaton.d.c */
/* loaded from: classes.dex */
class ServiceConnectionC0631c implements ServiceConnection {

    /* renamed from: a */
    final /* synthetic */ AbstractC0630b f2469a;

    ServiceConnectionC0631c(AbstractC0630b abstractC0630b) {
        this.f2469a = abstractC0630b;
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f2469a.f2464b = null;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        C1786r.m6061b("ServiceConnection.onServiceConnected", AbstractC0630b.f2462c);
        this.f2469a.f2464b = this.f2469a.mo2796a(iBinder);
        this.f2469a.f2466e = false;
        synchronized (this.f2469a) {
            this.f2469a.m2840a();
            this.f2469a.m2842b();
            for (Runnable runnable : this.f2469a.f2465d) {
                this.f2469a.m2842b();
                runnable.run();
            }
            this.f2469a.m2843c();
            this.f2469a.f2465d.clear();
        }
    }
}
