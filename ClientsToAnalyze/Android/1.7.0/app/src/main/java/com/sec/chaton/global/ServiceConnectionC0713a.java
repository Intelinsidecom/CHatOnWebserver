package com.sec.chaton.global;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.sec.chaton.push.AbstractBinderC0908j;
import com.sec.chaton.util.C1341p;

/* compiled from: GlobalApplication.java */
/* renamed from: com.sec.chaton.global.a */
/* loaded from: classes.dex */
class ServiceConnectionC0713a implements ServiceConnection {

    /* renamed from: a */
    final /* synthetic */ GlobalApplication f2426a;

    ServiceConnectionC0713a(GlobalApplication globalApplication) {
        this.f2426a = globalApplication;
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        C1341p.m4660c("OnServiceDisConnected : SPP", getClass().getSimpleName());
        this.f2426a.f2421o = 0;
        this.f2426a.f2422p = null;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        C1341p.m4660c("onServiceConnected : SPP", getClass().getSimpleName());
        this.f2426a.f2422p = AbstractBinderC0908j.m3596a(iBinder);
        this.f2426a.f2421o = 2;
    }
}
