package com.sec.chaton.service;

import android.app.Service;
import android.content.Intent;
import android.os.HandlerThread;
import android.os.IBinder;
import com.sec.chaton.p055d.C2093az;
import com.sec.chaton.p055d.C2122ca;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;

/* loaded from: classes.dex */
public class PushRegistrationService extends Service {

    /* renamed from: a */
    private static final String f12425a = PushRegistrationService.class.getSimpleName();

    /* renamed from: b */
    private boolean f12426b = false;

    /* renamed from: c */
    private HandlerThread f12427c;

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f12426b = false;
        this.f12427c = new HandlerThread(f12425a);
        this.f12427c.start();
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        if (this.f12426b) {
            C4904y.m18639b("Push registration is processing.", f12425a);
            stopSelf();
        } else if (!C4809aa.m18104a().m18129b("uid")) {
            C4904y.m18639b("Couldn't find ChatON user.", f12425a);
            stopSelf();
        } else {
            this.f12426b = true;
            C2093az.m9337a().mo9081d(new HandlerC3420g(this, this.f12427c.getLooper()));
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m13292b() {
        C2093az.m9337a().mo9077a(new HandlerC3421h(this, this.f12427c.getLooper()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m13294c() {
        new C2122ca(new HandlerC3422i(this, this.f12427c.getLooper())).m9469a();
    }
}
