package com.sec.chaton.global;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.sec.chaton.push.AbstractBinderC3093f;
import com.sec.chaton.util.C4904y;

/* compiled from: GlobalApplication.java */
/* renamed from: com.sec.chaton.global.b */
/* loaded from: classes.dex */
class ServiceConnectionC2350b implements ServiceConnection {

    /* renamed from: a */
    final /* synthetic */ GlobalApplication f8382a;

    ServiceConnectionC2350b(GlobalApplication globalApplication) {
        this.f8382a = globalApplication;
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        C4904y.m18641c("OnServiceDisConnected : SPP", getClass().getSimpleName());
        this.f8382a.f8368m = 0;
        this.f8382a.f8369n = null;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        C4904y.m18641c("onServiceConnected : SPP", getClass().getSimpleName());
        this.f8382a.f8369n = AbstractBinderC3093f.m12601a(iBinder);
        this.f8382a.f8368m = 2;
    }
}
