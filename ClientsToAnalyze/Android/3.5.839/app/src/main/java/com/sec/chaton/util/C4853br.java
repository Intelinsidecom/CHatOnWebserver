package com.sec.chaton.util;

import android.os.SystemClock;

/* compiled from: PollingScheduler.java */
/* renamed from: com.sec.chaton.util.br */
/* loaded from: classes.dex */
class C4853br {

    /* renamed from: a */
    private String f17671a;

    /* renamed from: b */
    private InterfaceC4854bs f17672b;

    /* renamed from: c */
    private long f17673c;

    /* renamed from: d */
    private String f17674d;

    private C4853br(String str, InterfaceC4854bs interfaceC4854bs, long j, String str2) {
        this.f17671a = str;
        this.f17672b = interfaceC4854bs;
        this.f17673c = j;
        this.f17674d = str2;
    }

    /* renamed from: a */
    private boolean m18345a() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long jM18118a = C4809aa.m18104a().m18118a(this.f17674d, -1L);
        long j = jElapsedRealtime - jM18118a;
        if (jM18118a == -1 || j < 0 || j > this.f17673c) {
            C4904y.m18639b("Task " + this.f17671a + " interval is elapsed. " + jM18118a + ", " + jElapsedRealtime + ", " + j + ", " + this.f17673c, "PollingScheduler");
            return true;
        }
        C4904y.m18639b("Task " + this.f17671a + " interval is not elapsed. " + jM18118a + ", " + jElapsedRealtime + ", " + j + ", " + this.f17673c, "PollingScheduler");
        return false;
    }

    /* renamed from: b */
    private void m18346b() {
        C4904y.m18641c("Task " + this.f17671a + " run.", "PollingScheduler");
        if (this.f17672b.mo7135a()) {
            C4809aa.m18107a(this.f17674d, Long.valueOf(SystemClock.elapsedRealtime()));
            C4904y.m18641c("Task " + this.f17671a + " time updated.", "PollingScheduler");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m18348c() {
        if (m18345a()) {
            m18346b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public boolean m18350d() {
        return m18345a();
    }
}
