package com.sec.widget;

import android.os.SystemClock;

/* compiled from: FastScrollableExpandableListView.java */
/* renamed from: com.sec.widget.q */
/* loaded from: classes.dex */
public class RunnableC5174q implements Runnable {

    /* renamed from: a */
    long f18939a;

    /* renamed from: b */
    long f18940b;

    /* renamed from: c */
    final /* synthetic */ C5173p f18941c;

    public RunnableC5174q(C5173p c5173p) {
        this.f18941c = c5173p;
    }

    /* renamed from: a */
    void m19787a() {
        this.f18940b = 200L;
        this.f18939a = SystemClock.uptimeMillis();
        this.f18941c.m19778a(4);
    }

    /* renamed from: b */
    int m19788b() {
        if (this.f18941c.m19777a() != 4) {
            return 208;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (jUptimeMillis > this.f18939a + this.f18940b) {
            return 0;
        }
        return (int) (208 - (((jUptimeMillis - this.f18939a) * 208) / this.f18940b));
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f18941c.m19777a() != 4) {
            m19787a();
        } else if (m19788b() > 0) {
            this.f18941c.f18923i.invalidate();
        } else {
            this.f18941c.m19778a(0);
        }
    }
}
