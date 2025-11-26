package com.sec.chaton.p017e.p019b;

import android.os.Handler;
import com.sec.chaton.util.C1786r;

/* compiled from: AbstractQueryTask.java */
/* renamed from: com.sec.chaton.e.b.a */
/* loaded from: classes.dex */
public abstract class AbstractC0674a {

    /* renamed from: a */
    public Handler f2560a;

    /* renamed from: b */
    private InterfaceC0677d f2561b;

    /* renamed from: a */
    public abstract Object mo3098a();

    public AbstractC0674a(InterfaceC0677d interfaceC0677d, Handler handler) {
        this.f2561b = interfaceC0677d;
        this.f2560a = handler;
    }

    public AbstractC0674a(InterfaceC0677d interfaceC0677d) {
        this.f2561b = interfaceC0677d;
    }

    /* renamed from: a */
    public void m3099a(int i) {
        Object objMo3098a = mo3098a();
        if (this.f2561b != null) {
            try {
                if (this.f2560a != null) {
                    this.f2560a.post(new RunnableC0675b(this, i, objMo3098a));
                } else {
                    this.f2561b.mo2365a(i, true, objMo3098a);
                }
            } catch (Exception e) {
                C1786r.m6056a(e, getClass().getSimpleName());
                if (this.f2560a != null) {
                    this.f2560a.post(new RunnableC0676c(this, i, objMo3098a));
                } else {
                    this.f2561b.mo2365a(i, false, objMo3098a);
                }
            }
        }
    }
}
