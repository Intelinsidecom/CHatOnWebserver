package com.sec.common.util.log.collector;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.sec.common.C4996f;
import com.sec.common.CommonApplication;
import com.sec.spp.push.dlc.api.IDlcService;

/* compiled from: LogCollectorManager.java */
/* renamed from: com.sec.common.util.log.collector.d */
/* loaded from: classes.dex */
final class ServiceConnectionC5039d implements ServiceConnection {
    ServiceConnectionC5039d() {
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (C4996f.f18229a.f18172d) {
            C4996f.f18229a.m18893g("LogCollectorService is connected", C5038c.f18362a);
        }
        if (IDlcService.Stub.asInterface(iBinder) != null) {
            C5038c.m19144a((IDlcService) null);
            C5038c.m19144a(IDlcService.Stub.asInterface(iBinder));
            C5038c.m19146a(true);
            CommonApplication.m18732r().startService(new Intent(CommonApplication.m18732r(), (Class<?>) LogCollectorSender.class));
            return;
        }
        if (C4996f.f18229a.f18172d) {
            C4996f.f18229a.m18893g("LogCollectorService is connected Service IS Null", C5038c.f18362a);
        }
        C5038c.m19146a(false);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        if (C4996f.f18229a.f18172d) {
            C4996f.f18229a.m18893g("LogCollectorService is disconnected", C5038c.f18362a);
        }
    }
}
