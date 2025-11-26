package com.sec.widget;

import android.os.SystemClock;

/* compiled from: FastScrollableExpandableListView.java */
/* renamed from: com.sec.widget.a */
/* loaded from: classes.dex */
public class RunnableC1603a implements Runnable {

    /* renamed from: a */
    long f5691a;

    /* renamed from: b */
    long f5692b;

    /* renamed from: c */
    final /* synthetic */ C1621i f5693c;

    public RunnableC1603a(C1621i c1621i) {
        this.f5693c = c1621i;
    }

    /* renamed from: a */
    void m5874a() {
        this.f5692b = 200L;
        this.f5691a = SystemClock.uptimeMillis();
        this.f5693c.m5900a(4);
    }

    /* renamed from: b */
    int m5875b() {
        if (this.f5693c.m5899a() != 4) {
            return 208;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (jUptimeMillis > this.f5691a + this.f5692b) {
            return 0;
        }
        return (int) (208 - (((jUptimeMillis - this.f5691a) * 208) / this.f5692b));
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f5693c.m5899a() != 4) {
            m5874a();
        } else if (m5875b() > 0) {
            this.f5693c.f5721i.invalidate();
        } else {
            this.f5693c.m5900a(0);
        }
    }
}
