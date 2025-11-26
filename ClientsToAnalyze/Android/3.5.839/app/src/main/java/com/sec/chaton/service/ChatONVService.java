package com.sec.chaton.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.coolots.sso.p030a.C0416a;
import com.coolots.sso.p030a.InterfaceC0418c;
import com.sec.chaton.p055d.C2075ah;
import com.sec.chaton.p055d.C2128i;
import com.sec.chaton.util.C4904y;

/* loaded from: classes.dex */
public class ChatONVService extends Service implements InterfaceC0418c {

    /* renamed from: a */
    private static final String f12415a = ChatONVService.class.getSimpleName();

    /* renamed from: b */
    private Context f12416b;

    /* renamed from: c */
    private C0416a f12417c;

    /* renamed from: d */
    private C2128i f12418d;

    /* renamed from: e */
    private C2075ah f12419e;

    /* renamed from: f */
    private boolean f12420f;

    /* renamed from: g */
    private int f12421g;

    /* renamed from: h */
    private boolean f12422h;

    /* renamed from: i */
    private Handler f12423i = new HandlerC3418e(this);

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        stopSelf();
        return 2;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (C4904y.f17873c) {
            C4904y.m18641c("onCreate ", f12415a);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        if (C4904y.f17873c) {
            C4904y.m18641c("onDestroy ", f12415a);
        }
        if (this.f12417c != null) {
            this.f12417c.m1491a(this, (InterfaceC0418c) null);
        }
    }

    /* renamed from: a */
    public void m13288a(int i) throws Throwable {
        if (i == 0) {
            this.f12418d.m9499a("voip", 0, false);
            return;
        }
        if (i == 1) {
            if (!this.f12417c.m1495d(this.f12416b)) {
                this.f12419e.m9312c(null);
                return;
            } else {
                this.f12418d.m9499a("voip", 1, false);
                return;
            }
        }
        if (C4904y.f17872b) {
            C4904y.m18639b("type is not valid", f12415a);
            stopSelf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m13286b() throws Throwable {
        if (!this.f12422h) {
            stopSelf();
            this.f12420f = false;
            if (C4904y.f17872b) {
                C4904y.m18639b("ChatONV result : no pendding task", f12415a);
                return;
            }
            return;
        }
        m13288a(this.f12421g);
        if (C4904y.f17872b) {
            C4904y.m18639b("checkTaskFinish : task is pendding", f12415a);
        }
    }

    @Override // com.coolots.sso.p030a.InterfaceC0418c
    /* renamed from: a */
    public void mo1508a(boolean z, String str) throws Throwable {
        if (C4904y.f17872b) {
            C4904y.m18639b("onReceiveCreateAccount : " + z + " msg : " + str, f12415a);
        }
        if (z) {
            this.f12418d.m9499a("voip", 1, false);
        } else {
            m13286b();
        }
    }

    @Override // com.coolots.sso.p030a.InterfaceC0418c
    /* renamed from: a_ */
    public void mo1509a_(boolean z) {
    }
}
