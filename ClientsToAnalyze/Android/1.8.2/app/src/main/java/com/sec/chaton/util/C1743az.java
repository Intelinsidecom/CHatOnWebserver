package com.sec.chaton.util;

import android.os.SystemClock;

/* compiled from: PollingScheduler.java */
/* renamed from: com.sec.chaton.util.az */
/* loaded from: classes.dex */
class C1743az {

    /* renamed from: a */
    private String f6354a;

    /* renamed from: b */
    private InterfaceC1745ba f6355b;

    /* renamed from: c */
    private long f6356c;

    /* renamed from: d */
    private String f6357d;

    private C1743az(String str, InterfaceC1745ba interfaceC1745ba, long j, String str2) {
        this.f6354a = str;
        this.f6355b = interfaceC1745ba;
        this.f6356c = j;
        this.f6357d = str2;
    }

    /* renamed from: a */
    private boolean m5935a() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = C1789u.m6075a().getLong(this.f6357d, -1L);
        long j2 = jElapsedRealtime - j;
        if (j == -1 || j2 < 0 || j2 > this.f6356c) {
            C1786r.m6061b("Task " + this.f6354a + " interval is elapsed. " + j + ", " + jElapsedRealtime + ", " + j2 + ", " + this.f6356c, "PollingScheduler");
            return true;
        }
        C1786r.m6061b("Task " + this.f6354a + " interval is not elapsed. " + j + ", " + jElapsedRealtime + ", " + j2 + ", " + this.f6356c, "PollingScheduler");
        return false;
    }

    /* renamed from: b */
    private void m5936b() {
        C1786r.m6063c("Task " + this.f6354a + " run.", "PollingScheduler");
        if (this.f6355b.mo1790a()) {
            C1789u.m6078a(this.f6357d, Long.valueOf(SystemClock.elapsedRealtime()));
            C1786r.m6063c("Task " + this.f6354a + " time updated.", "PollingScheduler");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m5938c() {
        if (m5935a()) {
            m5936b();
        }
    }
}
