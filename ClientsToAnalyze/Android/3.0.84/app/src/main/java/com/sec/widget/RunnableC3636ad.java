package com.sec.widget;

import android.os.SystemClock;

/* compiled from: FastScrollableExpandableListView.java */
/* renamed from: com.sec.widget.ad */
/* loaded from: classes.dex */
public class RunnableC3636ad implements Runnable {

    /* renamed from: a */
    long f13489a;

    /* renamed from: b */
    long f13490b;

    /* renamed from: c */
    final /* synthetic */ C3635ac f13491c;

    public RunnableC3636ad(C3635ac c3635ac) {
        this.f13491c = c3635ac;
    }

    /* renamed from: a */
    void m13187a() {
        this.f13490b = 200L;
        this.f13489a = SystemClock.uptimeMillis();
        this.f13491c.m13178a(4);
    }

    /* renamed from: b */
    int m13188b() {
        if (this.f13491c.m13177a() != 4) {
            return 208;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (jUptimeMillis > this.f13489a + this.f13490b) {
            return 0;
        }
        return (int) (208 - (((jUptimeMillis - this.f13489a) * 208) / this.f13490b));
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f13491c.m13177a() != 4) {
            m13187a();
        } else if (m13188b() > 0) {
            this.f13491c.f13473i.invalidate();
        } else {
            this.f13491c.m13178a(0);
        }
    }
}
