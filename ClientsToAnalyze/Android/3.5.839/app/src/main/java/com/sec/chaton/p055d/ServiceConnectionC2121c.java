package com.sec.chaton.p055d;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.sec.chaton.util.C4904y;

/* compiled from: AbstractServiceWrapper.java */
/* renamed from: com.sec.chaton.d.c */
/* loaded from: classes.dex */
class ServiceConnectionC2121c implements ServiceConnection {

    /* renamed from: a */
    final /* synthetic */ AbstractC2094b f7698a;

    ServiceConnectionC2121c(AbstractC2094b abstractC2094b) {
        this.f7698a = abstractC2094b;
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f7698a.f7608b = null;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [T, java.lang.Object] */
    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        C4904y.m18639b("ServiceConnection.onServiceConnected", AbstractC2094b.f7606c);
        this.f7698a.f7608b = this.f7698a.mo9327a(iBinder);
        this.f7698a.f7610e = false;
        synchronized (this.f7698a) {
            this.f7698a.m9344a();
            this.f7698a.m9346b();
            for (Runnable runnable : this.f7698a.f7609d) {
                this.f7698a.m9346b();
                runnable.run();
            }
            this.f7698a.m9347c();
            this.f7698a.f7609d.clear();
        }
    }
}
