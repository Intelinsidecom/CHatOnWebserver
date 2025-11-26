package com.sec.chaton.util;

import android.os.SystemClock;

/* compiled from: PollingScheduler.java */
/* renamed from: com.sec.chaton.util.br */
/* loaded from: classes.dex */
class C3203br {

    /* renamed from: a */
    private String f11556a;

    /* renamed from: b */
    private InterfaceC3204bs f11557b;

    /* renamed from: c */
    private long f11558c;

    /* renamed from: d */
    private String f11559d;

    private C3203br(String str, InterfaceC3204bs interfaceC3204bs, long j, String str2) {
        this.f11556a = str;
        this.f11557b = interfaceC3204bs;
        this.f11558c = j;
        this.f11559d = str2;
    }

    /* renamed from: a */
    private boolean m11170a() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long jM10976a = C3159aa.m10962a().m10976a(this.f11559d, -1L);
        long j = jElapsedRealtime - jM10976a;
        if (jM10976a == -1 || j < 0 || j > this.f11558c) {
            C3250y.m11450b("Task " + this.f11556a + " interval is elapsed. " + jM10976a + ", " + jElapsedRealtime + ", " + j + ", " + this.f11558c, "PollingScheduler");
            return true;
        }
        C3250y.m11450b("Task " + this.f11556a + " interval is not elapsed. " + jM10976a + ", " + jElapsedRealtime + ", " + j + ", " + this.f11558c, "PollingScheduler");
        return false;
    }

    /* renamed from: b */
    private void m11171b() {
        C3250y.m11453c("Task " + this.f11556a + " run.", "PollingScheduler");
        if (this.f11557b.mo3063a()) {
            C3159aa.m10965a(this.f11559d, Long.valueOf(SystemClock.elapsedRealtime()));
            C3250y.m11453c("Task " + this.f11556a + " time updated.", "PollingScheduler");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m11173c() {
        if (m11170a()) {
            m11171b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public boolean m11175d() {
        return m11170a();
    }
}
