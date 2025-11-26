package com.sec.chaton.push;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.sec.chaton.push.heartbeat.HeartBeat;
import com.sec.chaton.push.p054c.C2084e;
import com.sec.chaton.push.util.C2113e;
import com.sec.chaton.push.util.C2115g;
import com.sec.chaton.push.util.EnumC2114f;

/* loaded from: classes.dex */
public class PushClientService extends Service {

    /* renamed from: a */
    private final String f7884a = PushClientService.class.getSimpleName();

    /* renamed from: b */
    private final AbstractBinderC2093f f7885b = new BinderC2102n(this);

    @Override // android.app.Service
    public void onCreate() {
        if (C2115g.f8048a) {
            C2115g.m8359a(this.f7884a, "PushClientService.onCreate()");
        }
        super.onCreate();
        getApplicationContext().startService(new Intent("com.sec.chaton.push.PUSH_CLIENT_SERVICE_ACTION"));
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (C2115g.f8048a) {
            C2115g.m8359a(this.f7884a, "PushClientService.onStartCommand()");
        }
        super.onStartCommand(intent, i, i2);
        ((PushClientApplication) getApplication()).m8157a(true);
        if (C2099k.m8306e((String) null) == null) {
            if (C2115g.f8050c) {
                C2115g.m8363c(this.f7884a, "The registered application doesn't exist in push module. Don't try to execute initalize.");
            }
            stopSelf();
            return 2;
        }
        if (C2113e.m8355a() == EnumC2114f.NoActive) {
            if (C2115g.f8050c) {
                C2115g.m8363c(this.f7884a, "The network isn't available. Don't try to execute initialize.");
            }
            stopSelf();
            return 2;
        }
        C2084e.m8219a().m8232b().post(new RunnableC2100l(this));
        return 1;
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (C2115g.f8048a) {
            C2115g.m8359a(this.f7884a, "PushClientService.onDestroy()");
        }
        super.onDestroy();
        ((PushClientApplication) getApplication()).m8157a(false);
        if (C2115g.f8048a) {
            C2115g.m8359a(this.f7884a, "Stop HeartBeat.");
        }
        HeartBeat.m8266d();
        C2084e.m8219a().m8232b().postAtFrontOfQueue(new RunnableC2101m(this));
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (C2115g.f8048a) {
            C2115g.m8359a(this.f7884a, "PushClientService.onBind()");
        }
        return this.f7885b;
    }
}
