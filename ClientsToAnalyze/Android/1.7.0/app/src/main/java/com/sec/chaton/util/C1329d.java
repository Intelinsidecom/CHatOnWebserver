package com.sec.chaton.util;

import android.os.SystemClock;

/* compiled from: PollingScheduler.java */
/* renamed from: com.sec.chaton.util.d */
/* loaded from: classes.dex */
class C1329d {

    /* renamed from: a */
    private String f4551a;

    /* renamed from: b */
    private InterfaceC1288ak f4552b;

    /* renamed from: c */
    private long f4553c;

    /* renamed from: d */
    private String f4554d;

    private C1329d(String str, InterfaceC1288ak interfaceC1288ak, long j, String str2) {
        this.f4551a = str;
        this.f4552b = interfaceC1288ak;
        this.f4553c = j;
        this.f4554d = str2;
    }

    /* renamed from: a */
    private boolean m4601a() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = C1323bs.m4575a().getLong(this.f4554d, -1L);
        long j2 = jElapsedRealtime - j;
        if (j == -1 || j2 < 0 || j2 > this.f4553c) {
            C1341p.m4658b("Task " + this.f4551a + " interval is elapsed. " + j + ", " + jElapsedRealtime + ", " + j2 + ", " + this.f4553c, "PollingScheduler");
            return true;
        }
        C1341p.m4658b("Task " + this.f4551a + " interval is not elapsed. " + j + ", " + jElapsedRealtime + ", " + j2 + ", " + this.f4553c, "PollingScheduler");
        return false;
    }

    /* renamed from: b */
    private void m4602b() {
        C1341p.m4660c("Task " + this.f4551a + " run.", "PollingScheduler");
        if (this.f4552b.mo3044a()) {
            C1323bs.m4578a(this.f4554d, Long.valueOf(SystemClock.elapsedRealtime()));
            C1341p.m4660c("Task " + this.f4551a + " time updated.", "PollingScheduler");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m4604c() {
        if (m4601a()) {
            m4602b();
        }
    }
}
