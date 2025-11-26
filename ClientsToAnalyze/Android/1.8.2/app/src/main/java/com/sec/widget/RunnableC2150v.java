package com.sec.widget;

import android.os.SystemClock;

/* compiled from: FastScrollableExpandableListView.java */
/* renamed from: com.sec.widget.v */
/* loaded from: classes.dex */
public class RunnableC2150v implements Runnable {

    /* renamed from: a */
    long f7841a;

    /* renamed from: b */
    long f7842b;

    /* renamed from: c */
    final /* synthetic */ C2149u f7843c;

    public RunnableC2150v(C2149u c2149u) {
        this.f7843c = c2149u;
    }

    /* renamed from: a */
    void m7533a() {
        this.f7842b = 200L;
        this.f7841a = SystemClock.uptimeMillis();
        this.f7843c.m7524a(4);
    }

    /* renamed from: b */
    int m7534b() {
        if (this.f7843c.m7523a() != 4) {
            return 208;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (jUptimeMillis > this.f7841a + this.f7842b) {
            return 0;
        }
        return (int) (208 - (((jUptimeMillis - this.f7841a) * 208) / this.f7842b));
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f7843c.m7523a() != 4) {
            m7533a();
        } else if (m7534b() > 0) {
            this.f7843c.f7825i.invalidate();
        } else {
            this.f7843c.m7524a(0);
        }
    }
}
