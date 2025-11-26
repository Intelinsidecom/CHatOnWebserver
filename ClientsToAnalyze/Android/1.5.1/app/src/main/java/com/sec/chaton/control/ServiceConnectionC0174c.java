package com.sec.chaton.control;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.sec.chaton.util.ChatONLogWriter;

/* renamed from: com.sec.chaton.control.c */
/* loaded from: classes.dex */
class ServiceConnectionC0174c implements ServiceConnection {

    /* renamed from: a */
    final /* synthetic */ AbstractServiceWrapper f1409a;

    ServiceConnectionC0174c(AbstractServiceWrapper abstractServiceWrapper) {
        this.f1409a = abstractServiceWrapper;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        ChatONLogWriter.m3506b("ServiceConnection.onServiceConnected", AbstractServiceWrapper.f1350c);
        this.f1409a.f1352b = this.f1409a.mo1985b(iBinder);
        this.f1409a.f1354e = false;
        synchronized (this.f1409a) {
            this.f1409a.m1986c();
            this.f1409a.m1987d();
            for (Runnable runnable : this.f1409a.f1353d) {
                this.f1409a.m1987d();
                runnable.run();
            }
            this.f1409a.m1988e();
            this.f1409a.f1353d.clear();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f1409a.f1352b = null;
    }
}
