package com.sec.chaton.push;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.sec.chaton.push.heartbeat.HeartBeat;
import com.sec.chaton.push.p040a.C1071a;
import com.sec.chaton.push.p040a.C1072b;
import com.sec.chaton.push.p044c.C1111e;
import com.sec.chaton.push.p044c.C1115i;
import com.sec.chaton.push.p044c.InterfaceC1117k;
import com.sec.chaton.push.p044c.p045a.C1101b;
import com.sec.chaton.push.util.C1137e;
import com.sec.chaton.push.util.C1139g;
import com.sec.chaton.push.util.EnumC1138f;

/* loaded from: classes.dex */
public class PushClientService extends Service {

    /* renamed from: a */
    private final String f3982a = PushClientService.class.getSimpleName();

    /* renamed from: b */
    private AbstractBinderC1119e f3983b = new BinderC1127k(this);

    @Override // android.app.Service
    public void onCreate() {
        if (C1139g.f4142a) {
            C1139g.m4308a(this.f3982a, "PushClientService.onCreate()");
        }
        super.onCreate();
        getApplicationContext().startService(new Intent("com.sec.chaton.push.PUSH_CLIENT_SERVICE_ACTION"));
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (C1139g.f4142a) {
            C1139g.m4308a(this.f3982a, "PushClientService.onStartCommand()");
        }
        super.onStartCommand(intent, i, i2);
        ((PushClientApplication) getApplication()).m4113a(true);
        if (C1126j.m4262e((String) null) == null) {
            if (C1139g.f4144c) {
                C1139g.m4312c(this.f3982a, "The registered application doesn't exist in push module. Don't try to execute initalize.");
            }
            stopSelf();
            return 2;
        }
        if (C1137e.m4304a() == EnumC1138f.NoActive) {
            if (C1139g.f4144c) {
                C1139g.m4312c(this.f3982a, "The network isn't available. Don't try to execute initialize.");
            }
            stopSelf();
            return 2;
        }
        try {
            if (!C1101b.m4155d()) {
                if (C1139g.f4142a) {
                    C1139g.m4308a(this.f3982a, "PushModule hasn't been initialized. Execute initialize.");
                }
                C1115i.m4196a().m4203a(new C1101b(PushClientApplication.m4111g()));
            } else if (C1139g.f4142a) {
                C1139g.m4308a(this.f3982a, "PushModule has been initialized.");
            }
        } catch (InterruptedException e) {
            if (C1139g.f4145d) {
                C1139g.m4309a(this.f3982a, e.getMessage(), e);
            }
        }
        return 1;
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (C1139g.f4142a) {
            C1139g.m4308a(this.f3982a, "PushClientService.onDestroy()");
        }
        super.onDestroy();
        PushClientApplication pushClientApplication = (PushClientApplication) getApplication();
        pushClientApplication.m4113a(false);
        if (C1139g.f4142a) {
            C1139g.m4308a(this.f3982a, "Stop HeartBeat.");
        }
        HeartBeat.m4220b();
        if (C1139g.f4142a) {
            C1139g.m4308a(this.f3982a, "Cancel retry provisioning and initialize.");
        }
        C1072b.m4118a().m4124c();
        C1072b.m4118a().m4127f();
        C1115i.m4196a().m4200a(getApplicationContext(), (InterfaceC1117k) null);
        C1111e.m4174a().m4184a(-2);
        try {
            if (C1139g.f4142a) {
                C1139g.m4308a(this.f3982a, "Close provisioning connection.");
            }
            pushClientApplication.m4116k().mo4140b();
        } catch (C1071a e) {
        }
        try {
            if (C1139g.f4142a) {
                C1139g.m4308a(this.f3982a, "Close push connection.");
            }
            pushClientApplication.m4115j().mo4140b();
        } catch (C1071a e2) {
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (C1139g.f4142a) {
            C1139g.m4308a(this.f3982a, "PushClientService.onBind()");
        }
        return this.f3983b;
    }
}
