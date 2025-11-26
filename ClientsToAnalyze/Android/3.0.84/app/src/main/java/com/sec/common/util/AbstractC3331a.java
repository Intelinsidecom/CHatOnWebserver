package com.sec.common.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;

/* compiled from: AsyncWorker.java */
/* renamed from: com.sec.common.util.a */
/* loaded from: classes.dex */
public abstract class AbstractC3331a<Params, Progress, Result> {

    /* renamed from: b */
    private static final String f12034b = AbstractC3331a.class.getSimpleName();

    /* renamed from: c */
    private static final HandlerC3344f f12035c = new HandlerC3344f(null);

    /* renamed from: a */
    protected Progress f12036a;

    /* renamed from: f */
    private ExecutorService f12039f;

    /* renamed from: d */
    private AbstractCallableC3346h<Params, Result> f12037d = new C3340b(this);

    /* renamed from: e */
    private FutureTask<Result> f12038e = new C3341c(this, this.f12037d);

    /* renamed from: g */
    private EnumC3345g f12040g = EnumC3345g.PENDING;

    /* renamed from: c */
    protected abstract Result mo9453c(Params... paramsArr);

    public AbstractC3331a(ExecutorService executorService) {
        this.f12039f = executorService;
    }

    /* renamed from: g */
    public final Progress m11747g() {
        return this.f12036a;
    }

    /* renamed from: h */
    public final EnumC3345g m11748h() {
        return this.f12040g;
    }

    /* renamed from: i */
    public boolean m11749i() {
        return this.f12038e.isCancelled();
    }

    /* renamed from: a */
    public boolean m11744a(boolean z) {
        return this.f12038e.cancel(z);
    }

    /* renamed from: d */
    public final AbstractC3331a<Params, Progress, Result> m11745d(Params... paramsArr) {
        if (this.f12040g != EnumC3345g.PENDING) {
            switch (C3342d.f12072a[this.f12040g.ordinal()]) {
                case 1:
                    throw new IllegalStateException("Cannot execute task: the task is already running.");
                case 2:
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.f12040g = EnumC3345g.RUNNING;
        mo9456e();
        this.f12037d.f12079b = paramsArr;
        this.f12039f.execute(this.f12038e);
        return this;
    }

    /* renamed from: e */
    protected void mo9456e() {
    }

    /* renamed from: b */
    protected void mo9452b(Result result) {
    }

    /* renamed from: f */
    protected void mo9457f() {
    }

    /* renamed from: a */
    protected void mo9448a(Progress progress) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m11741c(Result result) {
        if (m11749i()) {
            result = null;
        }
        mo9452b(result);
        this.f12040g = EnumC3345g.FINISHED;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: e */
    public final void m11746e(Progress... progressArr) {
        this.f12036a = progressArr[0];
        f12035c.obtainMessage(2, new C3343e(this, progressArr)).sendToTarget();
    }
}
