package com.sec.chaton.coolots;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.coolots.sso.p003a.AbstractBinderC0050c;

/* compiled from: CommonBindService.java */
/* renamed from: com.sec.chaton.coolots.c */
/* loaded from: classes.dex */
class ServiceConnectionC0612c implements ServiceConnection {

    /* renamed from: a */
    final /* synthetic */ AbstractC0617h f2152a;

    ServiceConnectionC0612c(AbstractC0617h abstractC0617h) {
        this.f2152a = abstractC0617h;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Log.i(this.f2152a.f2165c, "Service Connected!");
        this.f2152a.f2168f = AbstractBinderC0050c.m60a(iBinder);
        Log.i(this.f2152a.f2165c, "Action Success=" + this.f2152a.mo2830a());
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Log.i(this.f2152a.f2165c, "Service Disconnected!");
        this.f2152a.m2834d();
    }
}
