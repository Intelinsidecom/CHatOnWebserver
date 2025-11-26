package android.support.v4.content;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: ModernAsyncTask.java */
/* renamed from: android.support.v4.content.m */
/* loaded from: classes.dex */
abstract class AbstractC0100m<Params, Progress, Result> {

    /* renamed from: a */
    private static final ThreadFactory f329a = new ThreadFactoryC0101n();

    /* renamed from: b */
    private static final BlockingQueue<Runnable> f330b = new LinkedBlockingQueue(10);

    /* renamed from: d */
    public static final Executor f332d = new ThreadPoolExecutor(5, 128, 1, TimeUnit.SECONDS, f330b, f329a);

    /* renamed from: c */
    private static final HandlerC0106s f331c = new HandlerC0106s(null);

    /* renamed from: e */
    private static volatile Executor f333e = f332d;

    /* renamed from: h */
    private volatile EnumC0107t f336h = EnumC0107t.PENDING;

    /* renamed from: i */
    private final AtomicBoolean f337i = new AtomicBoolean();

    /* renamed from: f */
    private final AbstractCallableC0108u<Params, Result> f334f = new C0102o(this);

    /* renamed from: g */
    private final FutureTask<Result> f335g = new C0103p(this, this.f334f);

    /* renamed from: a */
    protected abstract Result mo328a(Params... paramsArr);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m368c(Result result) {
        if (!this.f337i.get()) {
            m369d(result);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public Result m369d(Result result) {
        f331c.obtainMessage(1, new C0105r(this, result)).sendToTarget();
        return result;
    }

    /* renamed from: b */
    protected void m373b() {
    }

    /* renamed from: a */
    protected void mo330a(Result result) {
    }

    /* renamed from: b */
    protected void m375b(Progress... progressArr) {
    }

    /* renamed from: b */
    protected void m374b(Result result) {
        mo329a();
    }

    /* renamed from: a */
    protected void mo329a() {
    }

    /* renamed from: c */
    public final boolean m376c() {
        return this.f335g.isCancelled();
    }

    /* renamed from: a */
    public final boolean m372a(boolean z) {
        return this.f335g.cancel(z);
    }

    /* renamed from: a */
    public final AbstractC0100m<Params, Progress, Result> m371a(Executor executor, Params... paramsArr) {
        if (this.f336h != EnumC0107t.PENDING) {
            switch (C0104q.f341a[this.f336h.ordinal()]) {
                case 1:
                    throw new IllegalStateException("Cannot execute task: the task is already running.");
                case 2:
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.f336h = EnumC0107t.RUNNING;
        m373b();
        this.f334f.f348b = paramsArr;
        executor.execute(this.f335g);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m370e(Result result) {
        if (m376c()) {
            m374b((AbstractC0100m<Params, Progress, Result>) result);
        } else {
            mo330a((AbstractC0100m<Params, Progress, Result>) result);
        }
        this.f336h = EnumC0107t.FINISHED;
    }
}
