package com.sec.common.util.log.collector;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.sec.common.C3330f;
import com.sec.spp.push.dlc.api.IDlcService;

/* compiled from: LogCollectorSender.java */
/* renamed from: com.sec.common.util.log.collector.d */
/* loaded from: classes.dex */
class ServiceConnectionC3354d implements ServiceConnection {

    /* renamed from: a */
    final /* synthetic */ LogCollectorSender f12101a;

    ServiceConnectionC3354d(LogCollectorSender logCollectorSender) {
        this.f12101a = logCollectorSender;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) throws Throwable {
        this.f12101a.f12086b = IDlcService.Stub.asInterface(iBinder);
        if (C3330f.f12033a.f11973c) {
            C3330f.f12033a.m11654b("LogCollectorService is connected", LogCollectorSender.f12085a);
        }
        if (this.f12101a.f12087c) {
            this.f12101a.m11814b(this.f12101a.f12086b);
        } else {
            this.f12101a.m11809a(this.f12101a.f12086b);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f12101a.f12086b = null;
        if (C3330f.f12033a.f11973c) {
            C3330f.f12033a.m11654b("LogCollectorService is disconnected", LogCollectorSender.f12085a);
        }
    }
}
