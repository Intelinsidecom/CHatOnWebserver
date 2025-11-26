package com.sec.chaton.coolots;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.coolots.sso.p003a.AbstractBinderC0039b;

/* compiled from: CommonBindService.java */
/* renamed from: com.sec.chaton.coolots.b */
/* loaded from: classes.dex */
class ServiceConnectionC0522b implements ServiceConnection {

    /* renamed from: a */
    final /* synthetic */ AbstractC0521a f2139a;

    ServiceConnectionC0522b(AbstractC0521a abstractC0521a) {
        this.f2139a = abstractC0521a;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Log.i(this.f2139a.f2134a, "Service Connected!");
        this.f2139a.f2137d = AbstractBinderC0039b.m60a(iBinder);
        Log.i(this.f2139a.f2134a, "Action Success=" + this.f2139a.mo2700c());
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Log.i(this.f2139a.f2134a, "Service Disconnected!");
        this.f2139a.m2701d();
    }
}
