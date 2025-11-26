package com.sec.chaton.service;

import android.app.Service;
import android.content.Intent;
import android.os.HandlerThread;
import android.os.IBinder;
import com.sec.chaton.p013a.C0192ae;
import com.sec.chaton.p013a.C0218q;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1341p;

/* loaded from: classes.dex */
public class PushRegistrationService extends Service {

    /* renamed from: a */
    private static final String f3396a = PushRegistrationService.class.getSimpleName();

    /* renamed from: b */
    private boolean f3397b = false;

    /* renamed from: c */
    private HandlerThread f3398c;

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f3397b = false;
        this.f3398c = new HandlerThread(f3396a);
        this.f3398c.start();
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        if (this.f3397b) {
            C1341p.m4658b("Push registration is processing.", f3396a);
            stopSelf();
        } else if (!C1323bs.m4575a().contains("uid")) {
            C1341p.m4658b("Couldn't find ChatON user.", f3396a);
            stopSelf();
        } else {
            this.f3397b = true;
            C0192ae.m739a().mo745d(new HandlerC0998c(this, this.f3398c.getLooper()));
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m3772b() {
        C0192ae.m739a().mo741a(new HandlerC0999d(this, this.f3398c.getLooper()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m3774c() {
        new C0218q(new HandlerC1000e(this, this.f3398c.getLooper())).m799a();
    }
}
