package com.sec.chaton.push;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.sec.chaton.push.heartbeat.HeartBeat;
import com.sec.chaton.push.p094c.C3084e;
import com.sec.chaton.push.util.C3113e;
import com.sec.chaton.push.util.C3115g;
import com.sec.chaton.push.util.EnumC3114f;

/* loaded from: classes.dex */
public class PushClientService extends Service {

    /* renamed from: a */
    private final String f11294a = PushClientService.class.getSimpleName();

    /* renamed from: b */
    private final AbstractBinderC3093f f11295b = new BinderC3102n(this);

    @Override // android.app.Service
    public void onCreate() {
        if (C3115g.f11458a) {
            C3115g.m12701a(this.f11294a, "PushClientService.onCreate()");
        }
        super.onCreate();
        getApplicationContext().startService(new Intent("com.sec.chaton.push.PUSH_CLIENT_SERVICE_ACTION"));
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (C3115g.f11458a) {
            C3115g.m12701a(this.f11294a, "PushClientService.onStartCommand()");
        }
        super.onStartCommand(intent, i, i2);
        ((PushClientApplication) getApplication()).m12500a(true);
        if (C3099k.m12648e((String) null) == null) {
            if (C3115g.f11460c) {
                C3115g.m12705c(this.f11294a, "The registered application doesn't exist in push module. Don't try to execute initalize.");
            }
            stopSelf();
            return 2;
        }
        if (C3113e.m12697a() == EnumC3114f.NoActive) {
            if (C3115g.f11460c) {
                C3115g.m12705c(this.f11294a, "The network isn't available. Don't try to execute initialize.");
            }
            stopSelf();
            return 2;
        }
        C3084e.m12562a().m12575b().post(new RunnableC3100l(this));
        return 1;
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (C3115g.f11458a) {
            C3115g.m12701a(this.f11294a, "PushClientService.onDestroy()");
        }
        super.onDestroy();
        ((PushClientApplication) getApplication()).m12500a(false);
        if (C3115g.f11458a) {
            C3115g.m12701a(this.f11294a, "Stop HeartBeat.");
        }
        HeartBeat.m12609d();
        C3084e.m12562a().m12575b().postAtFrontOfQueue(new RunnableC3101m(this));
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (C3115g.f11458a) {
            C3115g.m12701a(this.f11294a, "PushClientService.onBind()");
        }
        return this.f11295b;
    }
}
