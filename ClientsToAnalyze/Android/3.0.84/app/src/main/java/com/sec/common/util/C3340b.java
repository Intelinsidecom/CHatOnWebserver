package com.sec.common.util;

import android.os.Process;

/* JADX INFO: Add missing generic type declarations: [Params, Result] */
/* compiled from: AsyncWorker.java */
/* renamed from: com.sec.common.util.b */
/* loaded from: classes.dex */
class C3340b<Params, Result> extends AbstractCallableC3346h<Params, Result> {

    /* renamed from: a */
    final /* synthetic */ AbstractC3331a f12070a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C3340b(AbstractC3331a abstractC3331a) {
        super(null);
        this.f12070a = abstractC3331a;
    }

    @Override // java.util.concurrent.Callable
    public Result call() throws SecurityException, IllegalArgumentException {
        Process.setThreadPriority(10);
        return (Result) this.f12070a.mo9453c((Object[]) this.f12079b);
    }
}
