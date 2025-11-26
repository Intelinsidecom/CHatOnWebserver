package com.sec.widget;

import android.os.SystemClock;

/* compiled from: FastScrollableListView.java */
/* renamed from: com.sec.widget.ah */
/* loaded from: classes.dex */
public class RunnableC3640ah implements Runnable {

    /* renamed from: a */
    long f13517a;

    /* renamed from: b */
    long f13518b;

    /* renamed from: c */
    final /* synthetic */ C3639ag f13519c;

    public RunnableC3640ah(C3639ag c3639ag) {
        this.f13519c = c3639ag;
    }

    /* renamed from: a */
    void m13208a() {
        this.f13518b = 200L;
        this.f13517a = SystemClock.uptimeMillis();
        this.f13519c.m13199a(4);
    }

    /* renamed from: b */
    int m13209b() {
        if (this.f13519c.m13198a() != 4) {
            return 208;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (jUptimeMillis > this.f13517a + this.f13518b) {
            return 0;
        }
        return (int) (208 - (((jUptimeMillis - this.f13517a) * 208) / this.f13518b));
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f13519c.m13198a() != 4) {
            m13208a();
        } else if (m13209b() > 0) {
            this.f13519c.f13501i.invalidate();
        } else {
            this.f13519c.m13199a(0);
        }
    }
}
