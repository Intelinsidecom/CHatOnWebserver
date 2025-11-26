package com.sec.chaton.p027e.p029b;

import android.os.Handler;
import com.sec.chaton.util.C3250y;

/* compiled from: AbstractQueryTask.java */
/* renamed from: com.sec.chaton.e.b.a */
/* loaded from: classes.dex */
public abstract class AbstractC1410a {

    /* renamed from: a */
    public Handler f5241a;

    /* renamed from: b */
    protected boolean f5242b = true;

    /* renamed from: c */
    private InterfaceC1413d f5243c;

    /* renamed from: a */
    public abstract Object mo6263a();

    public AbstractC1410a(InterfaceC1413d interfaceC1413d, Handler handler) {
        this.f5243c = interfaceC1413d;
        this.f5241a = handler;
    }

    public AbstractC1410a(InterfaceC1413d interfaceC1413d) {
        this.f5243c = interfaceC1413d;
    }

    /* renamed from: a */
    public void m6264a(int i) {
        Object objMo6263a = mo6263a();
        if (this.f5243c != null) {
            try {
                if (this.f5241a != null) {
                    this.f5241a.post(new RunnableC1411b(this, i, objMo6263a));
                } else {
                    this.f5243c.mo4048a(i, this.f5242b, objMo6263a);
                }
            } catch (Exception e) {
                C3250y.m11443a(e, getClass().getSimpleName());
                if (this.f5241a != null) {
                    this.f5241a.post(new RunnableC1412c(this, i, objMo6263a));
                } else {
                    this.f5243c.mo4048a(i, false, objMo6263a);
                }
            }
        }
    }
}
