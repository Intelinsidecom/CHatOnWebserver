package com.sec.chaton.smsplugin.p102b;

import android.os.Handler;
import com.sec.chaton.msgbox.C2654bs;
import com.sec.chaton.smsplugin.C3811d;
import com.sec.chaton.smsplugin.p111h.C3887j;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.google.android.p134a.p135a.C5097t;
import com.sec.google.android.p134a.p135a.C5103z;

/* compiled from: WorkingMessage.java */
/* renamed from: com.sec.chaton.smsplugin.b.u */
/* loaded from: classes.dex */
class RunnableC3802u implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C3790i f13658a;

    /* renamed from: b */
    final /* synthetic */ boolean f13659b;

    /* renamed from: c */
    final /* synthetic */ C3799r f13660c;

    RunnableC3802u(C3799r c3799r, C3790i c3790i, boolean z) {
        this.f13660c = c3799r;
        this.f13658a = c3790i;
        this.f13659b = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            C3887j.m14982c().m14987a(true);
            C5097t c5097tM19426a = C5097t.m19426a(this.f13660c.f13631a);
            C5103z c5103zM14413b = C3799r.m14413b(this.f13658a, this.f13660c.f13639i);
            if (this.f13660c.f13638h != null) {
                C3799r.m14417b(this.f13660c.f13638h, c5097tM19426a, this.f13660c.f13637g, c5103zM14413b);
            } else {
                this.f13660c.f13638h = C3799r.m14412b(c5097tM19426a, c5103zM14413b, this.f13660c.f13637g);
            }
            if (this.f13659b && this.f13658a.m14365j() == 0) {
                this.f13658a.m14361f();
            }
            this.f13658a.m14360e();
            this.f13658a.m14356b(true);
            if (C3890m.m15000f("Mms:app", C3890m.f13993b)) {
                C3811d.m14485a("asyncUpdateDraftMmsMessage conv: " + this.f13658a + " uri: " + this.f13660c.f13638h, new Object[0]);
            }
            this.f13660c.m14446b(this.f13658a);
            C3887j.m14982c().m14987a(false);
            if (this.f13659b) {
                C3811d.m14485a("asyncUpdateDraftMmsMessage MsgboxSync.SYNC_SMS_VIA_BYPASS", new Object[0]);
                C2654bs.m11169a().m11187a(3, (Handler) null);
            }
        } catch (Throwable th) {
            C3887j.m14982c().m14987a(false);
            throw th;
        }
    }
}
