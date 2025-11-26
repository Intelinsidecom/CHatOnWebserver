package com.sec.chaton.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.coolots.sso.p006a.C0045a;
import com.coolots.sso.p006a.InterfaceC0047c;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p025d.C1330h;
import com.sec.chaton.plugin.C1948a;
import com.sec.chaton.util.C3214cb;
import com.sec.chaton.util.C3250y;

/* loaded from: classes.dex */
public class ChatONVService extends Service implements InterfaceC0047c {

    /* renamed from: a */
    private static final String f8887a = ChatONVService.class.getSimpleName();

    /* renamed from: b */
    private Context f8888b;

    /* renamed from: c */
    private C0045a f8889c;

    /* renamed from: d */
    private C1330h f8890d;

    /* renamed from: e */
    private boolean f8891e;

    /* renamed from: f */
    private int f8892f;

    /* renamed from: g */
    private Handler f8893g = new HandlerC2390e(this);

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null) {
            return 2;
        }
        if (!C1948a.m7903a(GlobalApplication.m11493l())) {
            if (!C3250y.f11734b) {
                return 2;
            }
            C3250y.m11450b("This deivce is NOT supported", f8887a);
            return 2;
        }
        this.f8892f = intent.getIntExtra("request_type", -1);
        if (C3250y.f11735c) {
            C3250y.m11453c("onStartCommand, startId : " + i2 + " type : " + this.f8892f + " runningTask : " + this.f8891e, f8887a);
        }
        if (!this.f8891e) {
            this.f8891e = true;
            m8902a(this.f8892f);
            this.f8892f = -1;
        }
        return 1;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (C3250y.f11735c) {
            C3250y.m11453c("onCreate ", f8887a);
        }
        this.f8888b = GlobalApplication.m11493l();
        this.f8889c = new C0045a();
        this.f8889c.m51a(this, this);
        this.f8890d = new C1330h(this.f8893g);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        if (C3250y.f11735c) {
            C3250y.m11453c("onDestroy ", f8887a);
        }
        if (this.f8889c != null) {
            this.f8889c.m51a(this, (InterfaceC0047c) null);
        }
    }

    /* renamed from: a */
    public void m8902a(int i) {
        if (i == -1) {
            if (C3250y.f11734b) {
                C3250y.m11450b("type is not valid", f8887a);
            }
        } else if (i == 0) {
            this.f8890d.m5723a("voip", 0, false);
        } else if (i == 1) {
            if (!this.f8889c.m55d(this.f8888b)) {
                C3214cb.m11245a(this.f8888b, this.f8889c);
            } else {
                this.f8890d.m5723a("voip", 1, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m8901b() {
        if (this.f8892f == -1) {
            this.f8891e = false;
            stopSelf();
            if (C3250y.f11734b) {
                C3250y.m11450b("ChatONV result : no pendding task", f8887a);
                return;
            }
            return;
        }
        m8902a(this.f8892f);
        this.f8892f = -1;
        if (C3250y.f11734b) {
            C3250y.m11450b("checkTaskFinish : task is pendding", f8887a);
        }
    }

    @Override // com.coolots.sso.p006a.InterfaceC0047c
    public void onReceiveCreateAccount(boolean z, String str) {
        if (C3250y.f11734b) {
            C3250y.m11450b("onReceiveCreateAccount : " + z, f8887a);
        }
        if (z) {
            this.f8890d.m5723a("voip", 1, false);
        } else {
            m8901b();
        }
    }

    @Override // com.coolots.sso.p006a.InterfaceC0047c
    public void onReceiveRemoveAccount(boolean z) {
    }
}
