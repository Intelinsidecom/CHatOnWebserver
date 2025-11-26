package com.sec.chaton.p018c;

import android.os.Handler;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C1341p;

/* compiled from: GarbageConnectionCollector.java */
/* renamed from: com.sec.chaton.c.aa */
/* loaded from: classes.dex */
public class C0476aa {

    /* renamed from: a */
    private static C0476aa f1530a = null;

    /* renamed from: c */
    private int f1532c = 0;

    /* renamed from: d */
    private boolean f1533d = false;

    /* renamed from: e */
    private boolean f1534e = false;

    /* renamed from: b */
    private final Object f1531b = new Object();

    /* renamed from: a */
    public static synchronized C0476aa m2436a() {
        if (f1530a == null) {
            f1530a = new C0476aa();
        }
        return f1530a;
    }

    private C0476aa() {
    }

    /* renamed from: b */
    public void m2440b() {
        synchronized (this.f1531b) {
            if (!this.f1533d) {
                if (!this.f1534e) {
                    Handler handler = new Handler(GlobalApplication.m3100a().getMainLooper());
                    handler.post(new RunnableC0506m(this, handler));
                    this.f1534e = true;
                }
                this.f1533d = true;
                C1341p.m4660c("StartCollector : true", getClass().getSimpleName());
            }
            this.f1532c++;
        }
        C1341p.m4660c("StartCollector : " + String.valueOf(this.f1532c), getClass().getSimpleName());
    }

    /* renamed from: c */
    public void m2441c() {
        synchronized (this.f1531b) {
            if (this.f1532c > 0) {
                this.f1532c--;
            }
            C1341p.m4660c("StopCollector : " + String.valueOf(this.f1532c), getClass().getSimpleName());
            if (this.f1532c == 0) {
                this.f1533d = false;
                C1341p.m4660c("StopCollector : true", getClass().getSimpleName());
            }
        }
    }
}
