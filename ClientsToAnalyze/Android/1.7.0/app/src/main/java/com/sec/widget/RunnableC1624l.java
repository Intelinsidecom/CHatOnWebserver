package com.sec.widget;

import android.os.SystemClock;

/* compiled from: FastScrollableListView.java */
/* renamed from: com.sec.widget.l */
/* loaded from: classes.dex */
public class RunnableC1624l implements Runnable {

    /* renamed from: a */
    long f5741a;

    /* renamed from: b */
    long f5742b;

    /* renamed from: c */
    final /* synthetic */ C1636x f5743c;

    public RunnableC1624l(C1636x c1636x) {
        this.f5743c = c1636x;
    }

    /* renamed from: a */
    void m5909a() {
        this.f5742b = 200L;
        this.f5741a = SystemClock.uptimeMillis();
        this.f5743c.m5932a(4);
    }

    /* renamed from: b */
    int m5910b() {
        if (this.f5743c.m5931a() != 4) {
            return 208;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (jUptimeMillis > this.f5741a + this.f5742b) {
            return 0;
        }
        return (int) (208 - (((jUptimeMillis - this.f5741a) * 208) / this.f5742b));
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f5743c.m5931a() != 4) {
            m5909a();
        } else if (m5910b() > 0) {
            this.f5743c.f5768i.invalidate();
        } else {
            this.f5743c.m5932a(0);
        }
    }
}
