package com.sds.coolots.login;

import com.sds.coolots.common.util.Log;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.sds.coolots.login.e */
/* loaded from: classes.dex */
public class C1279e {

    /* renamed from: a */
    public static final String f3210a = "[LoginReplyTimerC]";

    /* renamed from: b */
    private TimerTask f3211b;

    /* renamed from: c */
    private Timer f3212c;

    public C1279e() {
        this.f3211b = null;
        this.f3212c = null;
        this.f3211b = null;
        this.f3212c = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3074a(String str) {
        Log.m2958e(f3210a + str);
    }

    /* renamed from: a */
    public void m3075a() {
        if (this.f3211b != null) {
            this.f3211b.cancel();
            this.f3211b = null;
        }
        this.f3211b = new C1280f(this);
    }

    /* renamed from: b */
    public void m3076b() {
        this.f3212c = new Timer();
        this.f3212c.schedule(this.f3211b, 15000L);
    }

    /* renamed from: c */
    public void m3077c() {
        if (this.f3212c != null) {
            this.f3212c.cancel();
        }
        if (this.f3211b != null) {
            this.f3211b.cancel();
        }
        this.f3212c = null;
        this.f3211b = null;
    }
}
