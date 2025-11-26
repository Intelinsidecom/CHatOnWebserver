package com.sec.chaton.p022h;

import android.os.Handler;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C1786r;

/* compiled from: GarbageConnectionCollector.java */
/* renamed from: com.sec.chaton.h.e */
/* loaded from: classes.dex */
public class C0795e {

    /* renamed from: a */
    private static C0795e f2923a = null;

    /* renamed from: c */
    private int f2925c = 0;

    /* renamed from: d */
    private boolean f2926d = false;

    /* renamed from: e */
    private boolean f2927e = false;

    /* renamed from: b */
    private final Object f2924b = new Object();

    /* renamed from: a */
    public static synchronized C0795e m3383a() {
        if (f2923a == null) {
            f2923a = new C0795e();
        }
        return f2923a;
    }

    private C0795e() {
    }

    /* renamed from: b */
    public void m3387b() {
        synchronized (this.f2924b) {
            if (!this.f2926d) {
                if (!this.f2927e) {
                    Handler handler = new Handler(GlobalApplication.m3260b().getMainLooper());
                    handler.post(new RunnableC0796f(this, handler));
                    this.f2927e = true;
                }
                this.f2926d = true;
                C1786r.m6063c("StartCollector : true", getClass().getSimpleName());
            }
            this.f2925c++;
        }
        C1786r.m6063c("StartCollector : " + String.valueOf(this.f2925c), getClass().getSimpleName());
    }

    /* renamed from: c */
    public void m3388c() {
        synchronized (this.f2924b) {
            if (this.f2925c > 0) {
                this.f2925c--;
            }
            C1786r.m6063c("StopCollector : " + String.valueOf(this.f2925c), getClass().getSimpleName());
            if (this.f2925c == 0) {
                this.f2926d = false;
                C1786r.m6063c("StopCollector : true", getClass().getSimpleName());
            }
        }
    }
}
