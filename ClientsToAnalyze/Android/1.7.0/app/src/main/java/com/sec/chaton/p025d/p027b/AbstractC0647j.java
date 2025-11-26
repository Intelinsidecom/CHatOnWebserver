package com.sec.chaton.p025d.p027b;

import android.os.Handler;
import com.sec.chaton.util.C1341p;

/* compiled from: AbstractQueryTask.java */
/* renamed from: com.sec.chaton.d.b.j */
/* loaded from: classes.dex */
public abstract class AbstractC0647j {

    /* renamed from: a */
    private InterfaceC0641d f2249a;

    /* renamed from: d */
    public Handler f2250d;

    /* renamed from: a */
    public abstract Object mo2950a();

    public AbstractC0647j(InterfaceC0641d interfaceC0641d, Handler handler) {
        this.f2249a = interfaceC0641d;
        this.f2250d = handler;
    }

    public AbstractC0647j(InterfaceC0641d interfaceC0641d) {
        this.f2249a = interfaceC0641d;
    }

    /* renamed from: a */
    public void m2973a(int i) {
        Object objMo2950a = mo2950a();
        if (this.f2249a != null) {
            try {
                if (this.f2250d != null) {
                    this.f2250d.post(new RunnableC0645h(this, i, objMo2950a));
                } else {
                    this.f2249a.mo2364a(i, true, objMo2950a);
                }
            } catch (Exception e) {
                C1341p.m4653a(e, getClass().getSimpleName());
                if (this.f2250d != null) {
                    this.f2250d.post(new RunnableC0644g(this, i, objMo2950a));
                } else {
                    this.f2249a.mo2364a(i, false, objMo2950a);
                }
            }
        }
    }
}
