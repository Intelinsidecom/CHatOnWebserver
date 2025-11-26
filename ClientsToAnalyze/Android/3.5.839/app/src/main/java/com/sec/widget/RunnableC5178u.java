package com.sec.widget;

import android.os.SystemClock;

/* compiled from: FastScrollableListView.java */
/* renamed from: com.sec.widget.u */
/* loaded from: classes.dex */
public class RunnableC5178u implements Runnable {

    /* renamed from: a */
    long f18967a;

    /* renamed from: b */
    long f18968b;

    /* renamed from: c */
    final /* synthetic */ C5177t f18969c;

    public RunnableC5178u(C5177t c5177t) {
        this.f18969c = c5177t;
    }

    /* renamed from: a */
    void m19808a() {
        this.f18968b = 200L;
        this.f18967a = SystemClock.uptimeMillis();
        this.f18969c.m19799a(4);
    }

    /* renamed from: b */
    int m19809b() {
        if (this.f18969c.m19798a() != 4) {
            return 208;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (jUptimeMillis > this.f18967a + this.f18968b) {
            return 0;
        }
        return (int) (208 - (((jUptimeMillis - this.f18967a) * 208) / this.f18968b));
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f18969c.m19798a() != 4) {
            m19808a();
        } else if (m19809b() > 0) {
            this.f18969c.f18951i.invalidate();
        } else {
            this.f18969c.m19799a(0);
        }
    }
}
