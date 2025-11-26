package com.sec.chaton.global;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.sec.chaton.push.AbstractBinderC1119e;
import com.sec.chaton.util.C1786r;

/* compiled from: GlobalApplication.java */
/* renamed from: com.sec.chaton.global.a */
/* loaded from: classes.dex */
class ServiceConnectionC0761a implements ServiceConnection {

    /* renamed from: a */
    final /* synthetic */ GlobalApplication f2792a;

    ServiceConnectionC0761a(GlobalApplication globalApplication) {
        this.f2792a = globalApplication;
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        C1786r.m6063c("OnServiceDisConnected : SPP", getClass().getSimpleName());
        this.f2792a.f2787m = 0;
        this.f2792a.f2788n = null;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        C1786r.m6063c("onServiceConnected : SPP", getClass().getSimpleName());
        this.f2792a.f2788n = AbstractBinderC1119e.m4212a(iBinder);
        this.f2792a.f2787m = 2;
    }
}
