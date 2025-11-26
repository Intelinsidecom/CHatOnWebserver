package com.sec.chaton.p067j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;

/* compiled from: TcpBaseWorker.java */
/* renamed from: com.sec.chaton.j.x */
/* loaded from: classes.dex */
public abstract class AbstractC2473x<Params, Progress, Result> {

    /* renamed from: a */
    private static final String f8874a = AbstractC2473x.class.getSimpleName();

    /* renamed from: b */
    private static final HandlerC2414ac f8875b = new HandlerC2414ac();

    /* renamed from: e */
    private ExecutorService f8878e;

    /* renamed from: c */
    private AbstractCallableC2416ae<Params, Result> f8876c = new C2474y(this);

    /* renamed from: d */
    private FutureTask<Result> f8877d = new C2475z(this, this.f8876c);

    /* renamed from: f */
    private EnumC2415ad f8879f = EnumC2415ad.PENDING;

    /* renamed from: b */
    protected abstract Result mo10474b(Params... paramsArr);

    public AbstractC2473x(ExecutorService executorService) {
        this.f8878e = executorService;
    }

    /* renamed from: a */
    public boolean m10700a() {
        return this.f8877d.isCancelled();
    }

    /* renamed from: a */
    public boolean m10701a(boolean z) {
        return this.f8877d.cancel(z);
    }

    /* renamed from: a */
    public final AbstractC2473x<Params, Progress, Result> m10699a(Params... paramsArr) {
        if (this.f8879f != EnumC2415ad.PENDING) {
            switch (this.f8879f) {
                case RUNNING:
                    throw new IllegalStateException("Cannot execute task: the task is already running.");
                case FINISHED:
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.f8879f = EnumC2415ad.RUNNING;
        m10702b();
        this.f8876c.f8595b = paramsArr;
        this.f8878e.submit(this.f8877d);
        return this;
    }

    /* renamed from: b */
    protected void m10702b() {
    }

    /* renamed from: a */
    protected void mo10529a(Result result) {
    }

    /* renamed from: c */
    protected void mo10476c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m10696b(Result result) {
        if (m10700a()) {
            result = null;
        }
        mo10529a((AbstractC2473x<Params, Progress, Result>) result);
        this.f8879f = EnumC2415ad.FINISHED;
    }
}
