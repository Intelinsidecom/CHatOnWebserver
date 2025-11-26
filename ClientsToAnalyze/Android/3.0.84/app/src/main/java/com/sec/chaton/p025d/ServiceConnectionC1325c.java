package com.sec.chaton.p025d;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.sec.chaton.util.C3250y;

/* compiled from: AbstractServiceWrapper.java */
/* renamed from: com.sec.chaton.d.c */
/* loaded from: classes.dex */
class ServiceConnectionC1325c implements ServiceConnection {

    /* renamed from: a */
    final /* synthetic */ AbstractC1314b f5003a;

    ServiceConnectionC1325c(AbstractC1314b abstractC1314b) {
        this.f5003a = abstractC1314b;
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f5003a.f4972b = null;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [T, java.lang.Object] */
    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        C3250y.m11450b("ServiceConnection.onServiceConnected", AbstractC1314b.f4970c);
        this.f5003a.f4972b = this.f5003a.mo5586a(iBinder);
        this.f5003a.f4974e = false;
        synchronized (this.f5003a) {
            this.f5003a.m5666a();
            this.f5003a.m5668b();
            for (Runnable runnable : this.f5003a.f4973d) {
                this.f5003a.m5668b();
                runnable.run();
            }
            this.f5003a.m5669c();
            this.f5003a.f4973d.clear();
        }
    }
}
