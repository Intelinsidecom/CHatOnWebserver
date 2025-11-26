package com.sec.common.util;

import com.sec.common.C3330f;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* JADX INFO: Add missing generic type declarations: [Result] */
/* compiled from: AsyncWorker.java */
/* renamed from: com.sec.common.util.c */
/* loaded from: classes.dex */
class C3341c<Result> extends FutureTask<Result> {

    /* renamed from: a */
    final /* synthetic */ AbstractC3331a f12071a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C3341c(AbstractC3331a abstractC3331a, Callable callable) {
        super(callable);
        this.f12071a = abstractC3331a;
    }

    @Override // java.util.concurrent.FutureTask
    protected void done() {
        Result result = null;
        try {
            result = get();
        } catch (InterruptedException e) {
            if (C3330f.f12033a.f11974d) {
                C3330f.f12033a.m11656c(AbstractC3331a.f12034b, e.getMessage());
            }
        } catch (CancellationException e2) {
            AbstractC3331a.f12035c.obtainMessage(3, new C3343e(this.f12071a, (Object[]) null)).sendToTarget();
            return;
        } catch (ExecutionException e3) {
            throw new RuntimeException("An error occured while executing doInBackground()", e3.getCause());
        } catch (Throwable th) {
            throw new RuntimeException("An error occured while executing doInBackground()", th);
        }
        AbstractC3331a.f12035c.obtainMessage(1, new C3343e(this.f12071a, result)).sendToTarget();
    }
}
