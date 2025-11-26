package com.sec.chaton.service;

import android.app.Service;
import android.content.Intent;
import android.os.HandlerThread;
import android.os.IBinder;
import com.sec.chaton.p015d.C0620aj;
import com.sec.chaton.p015d.C0629as;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;

/* loaded from: classes.dex */
public class PushRegistrationService extends Service {

    /* renamed from: a */
    private static final String f4435a = PushRegistrationService.class.getSimpleName();

    /* renamed from: b */
    private boolean f4436b = false;

    /* renamed from: c */
    private HandlerThread f4437c;

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f4436b = false;
        this.f4437c = new HandlerThread(f4435a);
        this.f4437c.start();
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        if (this.f4436b) {
            C1786r.m6061b("Push registration is processing.", f4435a);
            stopSelf();
        } else if (!C1789u.m6075a().contains("uid")) {
            C1786r.m6061b("Couldn't find ChatON user.", f4435a);
            stopSelf();
        } else {
            this.f4436b = true;
            C0620aj.m2804a().mo2706d(new HandlerC1217c(this, this.f4437c.getLooper()));
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m4471b() {
        C0620aj.m2804a().mo2702a(new HandlerC1218d(this, this.f4437c.getLooper()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m4473c() {
        new C0629as(new HandlerC1219e(this, this.f4437c.getLooper())).m2832a();
    }
}
