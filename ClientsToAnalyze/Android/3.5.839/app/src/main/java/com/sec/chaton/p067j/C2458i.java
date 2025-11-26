package com.sec.chaton.p067j;

import com.sec.chaton.util.C4904y;
import java.util.Timer;

/* compiled from: GarbageConnectionCollector.java */
/* renamed from: com.sec.chaton.j.i */
/* loaded from: classes.dex */
public class C2458i {

    /* renamed from: a */
    private static C2458i f8824a = null;

    /* renamed from: f */
    private Timer f8829f;

    /* renamed from: c */
    private int f8826c = 0;

    /* renamed from: d */
    private boolean f8827d = false;

    /* renamed from: e */
    private boolean f8828e = false;

    /* renamed from: b */
    private final Object f8825b = new Object();

    /* renamed from: a */
    public static synchronized C2458i m10646a() {
        if (f8824a == null) {
            f8824a = new C2458i();
        }
        return f8824a;
    }

    private C2458i() {
    }

    /* renamed from: b */
    public void m10652b() {
        synchronized (this.f8825b) {
            if (!this.f8827d) {
                if (!this.f8828e) {
                    C2459j c2459j = new C2459j(this);
                    this.f8828e = true;
                    if (this.f8829f == null) {
                        this.f8829f = new Timer();
                    }
                    this.f8829f.schedule(c2459j, 5000L, 5000L);
                    if (C4904y.f17872b) {
                        C4904y.m18639b("TimerTask was scheduled.", getClass().getSimpleName());
                    }
                }
                this.f8827d = true;
                if (C4904y.f17873c) {
                    C4904y.m18641c("StartCollector : true", getClass().getSimpleName());
                }
            }
            this.f8826c++;
        }
        if (C4904y.f17873c) {
            C4904y.m18641c("StartCollector : " + String.valueOf(this.f8826c), getClass().getSimpleName());
        }
    }

    /* renamed from: c */
    public void m10653c() {
        synchronized (this.f8825b) {
            if (this.f8826c > 0) {
                this.f8826c--;
            }
            if (C4904y.f17873c) {
                C4904y.m18641c("StopCollector : " + String.valueOf(this.f8826c), getClass().getSimpleName());
            }
            if (this.f8826c == 0) {
                this.f8827d = false;
                if (C4904y.f17873c) {
                    C4904y.m18641c("StopCollector : true", getClass().getSimpleName());
                }
            }
        }
    }
}
