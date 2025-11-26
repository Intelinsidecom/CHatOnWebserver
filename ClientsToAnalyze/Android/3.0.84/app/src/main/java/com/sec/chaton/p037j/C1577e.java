package com.sec.chaton.p037j;

import com.sec.chaton.util.C3250y;
import java.util.Timer;

/* compiled from: GarbageConnectionCollector.java */
/* renamed from: com.sec.chaton.j.e */
/* loaded from: classes.dex */
public class C1577e {

    /* renamed from: a */
    private static C1577e f5856a = null;

    /* renamed from: f */
    private Timer f5861f;

    /* renamed from: c */
    private int f5858c = 0;

    /* renamed from: d */
    private boolean f5859d = false;

    /* renamed from: e */
    private boolean f5860e = false;

    /* renamed from: b */
    private final Object f5857b = new Object();

    /* renamed from: a */
    public static synchronized C1577e m6684a() {
        if (f5856a == null) {
            f5856a = new C1577e();
        }
        return f5856a;
    }

    private C1577e() {
    }

    /* renamed from: b */
    public void m6690b() {
        synchronized (this.f5857b) {
            if (!this.f5859d) {
                if (!this.f5860e) {
                    C1578f c1578f = new C1578f(this);
                    this.f5860e = true;
                    if (this.f5861f == null) {
                        this.f5861f = new Timer();
                    }
                    this.f5861f.schedule(c1578f, 5000L, 5000L);
                    if (C3250y.f11734b) {
                        C3250y.m11450b("TimerTask was scheduled.", getClass().getSimpleName());
                    }
                }
                this.f5859d = true;
                if (C3250y.f11735c) {
                    C3250y.m11453c("StartCollector : true", getClass().getSimpleName());
                }
            }
            this.f5858c++;
        }
        if (C3250y.f11735c) {
            C3250y.m11453c("StartCollector : " + String.valueOf(this.f5858c), getClass().getSimpleName());
        }
    }

    /* renamed from: c */
    public void m6691c() {
        synchronized (this.f5857b) {
            if (this.f5858c > 0) {
                this.f5858c--;
            }
            if (C3250y.f11735c) {
                C3250y.m11453c("StopCollector : " + String.valueOf(this.f5858c), getClass().getSimpleName());
            }
            if (this.f5858c == 0) {
                this.f5859d = false;
                if (C3250y.f11735c) {
                    C3250y.m11453c("StopCollector : true", getClass().getSimpleName());
                }
            }
        }
    }
}
