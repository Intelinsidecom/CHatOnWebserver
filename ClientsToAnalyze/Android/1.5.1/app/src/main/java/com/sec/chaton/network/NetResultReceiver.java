package com.sec.chaton.network;

import android.os.Handler;

/* loaded from: classes.dex */
public class NetResultReceiver {

    /* renamed from: a */
    final Handler f2459a;

    /* renamed from: b */
    private Receiver f2460b;

    public interface Receiver {
        /* renamed from: a */
        void mo2027a(int i, Object obj);

        /* renamed from: a */
        void mo2028a(int i, Object obj, Object obj2);
    }

    public NetResultReceiver(Handler handler, Receiver receiver) {
        this.f2459a = handler;
        m2750a(receiver);
    }

    /* renamed from: a */
    public void m2748a(int i, Object obj) {
        this.f2459a.post(new RunnableC0339a(this, i, obj));
    }

    /* renamed from: a */
    public void m2749a(int i, Object obj, Object obj2) {
        this.f2459a.post(new RunnableC0341c(this, i, obj, obj2));
    }

    /* renamed from: a */
    public void m2750a(Receiver receiver) {
        this.f2460b = receiver;
    }

    /* renamed from: b */
    protected void m2751b(int i, Object obj) {
        if (this.f2460b != null) {
            this.f2460b.mo2027a(i, obj);
        }
    }

    /* renamed from: b */
    protected void m2752b(int i, Object obj, Object obj2) {
        if (this.f2460b != null) {
            this.f2460b.mo2028a(i, obj, obj2);
        }
    }
}
