package com.sec.chaton.global;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.sec.chaton.push.AbstractBinderC2093f;
import com.sec.chaton.util.C3250y;

/* compiled from: GlobalApplication.java */
/* renamed from: com.sec.chaton.global.b */
/* loaded from: classes.dex */
class ServiceConnectionC1494b implements ServiceConnection {

    /* renamed from: a */
    final /* synthetic */ GlobalApplication f5529a;

    ServiceConnectionC1494b(GlobalApplication globalApplication) {
        this.f5529a = globalApplication;
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        C3250y.m11453c("OnServiceDisConnected : SPP", getClass().getSimpleName());
        this.f5529a.f5523l = 0;
        this.f5529a.f5524m = null;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        C3250y.m11453c("onServiceConnected : SPP", getClass().getSimpleName());
        this.f5529a.f5524m = AbstractBinderC2093f.m8258a(iBinder);
        this.f5529a.f5523l = 2;
    }
}
