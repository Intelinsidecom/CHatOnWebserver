package com.sec.chaton.p067j;

import com.sec.common.C4996f;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* JADX INFO: Add missing generic type declarations: [Result] */
/* compiled from: TcpBaseWorker.java */
/* renamed from: com.sec.chaton.j.z */
/* loaded from: classes.dex */
class C2475z<Result> extends FutureTask<Result> {

    /* renamed from: a */
    final /* synthetic */ AbstractC2473x f8881a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C2475z(AbstractC2473x abstractC2473x, Callable callable) {
        super(callable);
        this.f8881a = abstractC2473x;
    }

    @Override // java.util.concurrent.FutureTask
    protected void done() {
        Result result = null;
        try {
            result = get();
        } catch (InterruptedException e) {
            if (C4996f.f18229a.f18173e) {
                C4996f.f18229a.m18894h(AbstractC2473x.f8874a, e.getMessage());
            }
        } catch (CancellationException e2) {
            AbstractC2473x.f8875b.obtainMessage(3, new C2413ab(this.f8881a, (Object[]) null)).sendToTarget();
            return;
        } catch (ExecutionException e3) {
            throw new RuntimeException("An error occured while executing doInBackground()", e3.getCause());
        } catch (Throwable th) {
            throw new RuntimeException("An error occured while executing doInBackground()", th);
        }
        AbstractC2473x.f8875b.obtainMessage(1, new C2413ab(this.f8881a, result)).sendToTarget();
    }
}
