package com.sec.chaton.p057e.p059b;

import android.os.Handler;
import com.sec.chaton.util.C4904y;

/* compiled from: AbstractQueryTask.java */
/* renamed from: com.sec.chaton.e.b.a */
/* loaded from: classes.dex */
public abstract class AbstractC2240a {

    /* renamed from: a */
    public Handler f7981a;

    /* renamed from: b */
    protected boolean f7982b = true;

    /* renamed from: c */
    private InterfaceC2243d f7983c;

    /* renamed from: a */
    public abstract Object mo8896a();

    public AbstractC2240a(InterfaceC2243d interfaceC2243d, Handler handler) {
        this.f7983c = interfaceC2243d;
        this.f7981a = handler;
    }

    public AbstractC2240a(InterfaceC2243d interfaceC2243d) {
        this.f7983c = interfaceC2243d;
    }

    /* renamed from: a */
    public void m10102a(int i) {
        Object objMo8896a = mo8896a();
        if (this.f7983c != null && objMo8896a != null) {
            try {
                if (this.f7981a != null) {
                    this.f7981a.post(new RunnableC2241b(this, i, objMo8896a));
                } else {
                    this.f7983c.mo7130a(i, this.f7982b, objMo8896a);
                }
            } catch (Exception e) {
                C4904y.m18635a(e, getClass().getSimpleName());
                if (this.f7981a != null) {
                    this.f7981a.post(new RunnableC2242c(this, i, objMo8896a));
                } else {
                    this.f7983c.mo7130a(i, false, objMo8896a);
                }
            }
        }
    }
}
