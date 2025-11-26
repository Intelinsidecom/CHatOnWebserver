package com.sec.chaton.push;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.sec.chaton.push.heartbeat.HeartBeat;
import com.sec.chaton.push.p038b.C0872e;
import com.sec.chaton.push.p038b.C0879l;
import com.sec.chaton.push.p039c.C0893e;
import com.sec.chaton.push.p039c.C0896h;
import com.sec.chaton.push.p039c.InterfaceC0892d;
import com.sec.chaton.push.p039c.p040a.C0888g;
import com.sec.chaton.push.util.C0920f;
import com.sec.chaton.push.util.C0921g;
import com.sec.chaton.push.util.EnumC0918d;

/* loaded from: classes.dex */
public class PushClientService extends Service {

    /* renamed from: a */
    private final String f2960a = PushClientService.class.getSimpleName();

    /* renamed from: b */
    private AbstractBinderC0908j f2961b = new BinderC0900d(this);

    @Override // android.app.Service
    public void onCreate() {
        if (C0921g.f3116a) {
            C0921g.m3637a(this.f2960a, "PushClientService.onCreate()");
        }
        super.onCreate();
        getApplicationContext().startService(new Intent("com.sec.chaton.push.PUSH_CLIENT_SERVICE_ACTION"));
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (C0921g.f3116a) {
            C0921g.m3637a(this.f2960a, "PushClientService.onStartCommand()");
        }
        super.onStartCommand(intent, i, i2);
        ((PushClientApplication) getApplication()).m3438a(true);
        if (C0904h.m3560e((String) null) == null) {
            if (C0921g.f3118c) {
                C0921g.m3641c(this.f2960a, "The registered application doesn't exist in push module. Don't try to execute initalize.");
            }
            stopSelf();
            return 2;
        }
        if (C0920f.m3634a() == EnumC0918d.NoActive) {
            if (C0921g.f3118c) {
                C0921g.m3641c(this.f2960a, "The network isn't available. Don't try to execute initialize.");
            }
            stopSelf();
            return 2;
        }
        try {
            if (!C0888g.m3496a()) {
                if (C0921g.f3116a) {
                    C0921g.m3637a(this.f2960a, "PushModule hasn't been initialized. Execute initialize.");
                }
                C0896h.m3520a().m3527a(new C0888g(PushClientApplication.m3436a()));
            } else if (C0921g.f3116a) {
                C0921g.m3637a(this.f2960a, "PushModule has been initialized.");
            }
        } catch (InterruptedException e) {
            if (C0921g.f3119d) {
                C0921g.m3638a(this.f2960a, e.getMessage(), e);
            }
        }
        return 1;
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (C0921g.f3116a) {
            C0921g.m3637a(this.f2960a, "PushClientService.onDestroy()");
        }
        super.onDestroy();
        PushClientApplication pushClientApplication = (PushClientApplication) getApplication();
        pushClientApplication.m3438a(false);
        if (C0921g.f3116a) {
            C0921g.m3637a(this.f2960a, "Stop HeartBeat.");
        }
        HeartBeat.m3576d();
        if (C0921g.f3116a) {
            C0921g.m3637a(this.f2960a, "Cancel retry provisioning and initialize.");
        }
        C0879l.m3463a().m3469c();
        C0879l.m3463a().m3472f();
        C0896h.m3520a().m3524a(getApplicationContext(), (InterfaceC0892d) null);
        C0893e.m3502a().m3512a(-2);
        try {
            if (C0921g.f3116a) {
                C0921g.m3637a(this.f2960a, "Close provisioning connection.");
            }
            pushClientApplication.m3441e().mo3457b();
        } catch (C0872e e) {
        }
        try {
            if (C0921g.f3116a) {
                C0921g.m3637a(this.f2960a, "Close push connection.");
            }
            pushClientApplication.m3440d().mo3457b();
        } catch (C0872e e2) {
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (C0921g.f3116a) {
            C0921g.m3637a(this.f2960a, "PushClientService.onBind()");
        }
        return this.f2961b;
    }
}
