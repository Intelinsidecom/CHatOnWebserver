package com.sec.chaton.service;

import android.app.Service;
import android.content.Intent;
import android.os.HandlerThread;
import android.os.IBinder;
import com.sec.chaton.p025d.C1302ao;
import com.sec.chaton.p025d.C1324bj;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;

/* loaded from: classes.dex */
public class PushRegistrationService extends Service {

    /* renamed from: a */
    private static final String f8895a = PushRegistrationService.class.getSimpleName();

    /* renamed from: b */
    private boolean f8896b = false;

    /* renamed from: c */
    private HandlerThread f8897c;

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f8896b = false;
        this.f8897c = new HandlerThread(f8895a);
        this.f8897c.start();
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        if (this.f8896b) {
            C3250y.m11450b("Push registration is processing.", f8895a);
            stopSelf();
        } else if (!C3159aa.m10962a().m10987b("uid")) {
            C3250y.m11450b("Couldn't find ChatON user.", f8895a);
            stopSelf();
        } else {
            this.f8896b = true;
            C1302ao.m5594a().mo5483d(new HandlerC2392g(this, this.f8897c.getLooper()));
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m8906b() {
        C1302ao.m5594a().mo5479a(new HandlerC2393h(this, this.f8897c.getLooper()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m8908c() {
        new C1324bj(new HandlerC2394i(this, this.f8897c.getLooper())).m5692a();
    }
}
