package com.sec.common.util;

import com.sec.common.C4996f;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* JADX INFO: Add missing generic type declarations: [Result] */
/* compiled from: AsyncWorker.java */
/* renamed from: com.sec.common.util.c */
/* loaded from: classes.dex */
class C5026c<Result> extends FutureTask<Result> {

    /* renamed from: a */
    final /* synthetic */ AbstractC5016a f18336a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C5026c(AbstractC5016a abstractC5016a, Callable callable) {
        super(callable);
        this.f18336a = abstractC5016a;
    }

    @Override // java.util.concurrent.FutureTask
    protected void done() {
        Object obj = null;
        try {
            obj = super.get();
        } catch (InterruptedException e) {
            if (C4996f.f18229a.f18173e) {
                C4996f.f18229a.m18894h(AbstractC5016a.f18299a, e.getMessage());
            }
        } catch (CancellationException e2) {
            AbstractC5016a.f18300b.obtainMessage(3, new C5028e(this.f18336a, (Object[]) null)).sendToTarget();
            return;
        } catch (ExecutionException e3) {
            throw new RuntimeException("An error occured while executing doInBackground()", e3.getCause());
        } catch (Throwable th) {
            throw new RuntimeException("An error occured while executing doInBackground()", th);
        }
        AbstractC5016a.f18300b.obtainMessage(1, new C5028e(this.f18336a, obj)).sendToTarget();
    }
}
