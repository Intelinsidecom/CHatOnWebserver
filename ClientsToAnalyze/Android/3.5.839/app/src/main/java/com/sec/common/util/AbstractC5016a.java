package com.sec.common.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;

/* compiled from: AsyncWorker.java */
/* renamed from: com.sec.common.util.a */
/* loaded from: classes.dex */
public abstract class AbstractC5016a<Params, Progress, Result> {

    /* renamed from: a */
    private static final String f18299a = AbstractC5016a.class.getSimpleName();

    /* renamed from: b */
    private static final HandlerC5029f f18300b = new HandlerC5029f(null);

    /* renamed from: e */
    protected Progress f18303e;

    /* renamed from: f */
    private ExecutorService f18304f;

    /* renamed from: c */
    private AbstractCallableC5031h<Params, Result> f18301c = new C5025b(this);

    /* renamed from: d */
    private FutureTask<Result> f18302d = new C5026c(this, this.f18301c);

    /* renamed from: g */
    private EnumC5030g f18305g = EnumC5030g.PENDING;

    /* renamed from: a */
    protected abstract Result mo6106a(Params... paramsArr);

    public AbstractC5016a(ExecutorService executorService) {
        this.f18304f = executorService;
    }

    /* renamed from: f */
    public final Progress m19061f() {
        return this.f18303e;
    }

    /* renamed from: g */
    public final EnumC5030g m19062g() {
        return this.f18305g;
    }

    /* renamed from: h */
    public boolean m19063h() {
        return this.f18302d.isCancelled();
    }

    /* renamed from: a */
    public boolean m19058a(boolean z) {
        return this.f18302d.cancel(z);
    }

    /* renamed from: d */
    public final AbstractC5016a<Params, Progress, Result> m19059d(Params... paramsArr) {
        if (this.f18305g != EnumC5030g.PENDING) {
            switch (C5027d.f18337a[this.f18305g.ordinal()]) {
                case 1:
                    throw new IllegalStateException("Cannot execute task: the task is already running.");
                case 2:
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.f18305g = EnumC5030g.RUNNING;
        mo6107a();
        this.f18301c.f18344b = paramsArr;
        this.f18304f.execute(this.f18302d);
        return this;
    }

    /* renamed from: a */
    protected void mo6107a() {
    }

    /* renamed from: a */
    protected void mo6108a(Result result) {
    }

    /* renamed from: b */
    protected void mo6109b() {
    }

    /* renamed from: b */
    protected void mo7398b(Progress progress) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m19055c(Result result) {
        if (m19063h()) {
            result = null;
        }
        mo6108a((AbstractC5016a<Params, Progress, Result>) result);
        this.f18305g = EnumC5030g.FINISHED;
    }

    /* renamed from: e */
    protected final void m19060e(Progress... progressArr) {
        this.f18303e = progressArr[0];
        f18300b.obtainMessage(2, new C5028e(this, progressArr)).sendToTarget();
    }
}
