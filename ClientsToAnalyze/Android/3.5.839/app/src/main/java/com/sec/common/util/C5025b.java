package com.sec.common.util;

import android.os.Process;

/* JADX INFO: Add missing generic type declarations: [Params, Result] */
/* compiled from: AsyncWorker.java */
/* renamed from: com.sec.common.util.b */
/* loaded from: classes.dex */
class C5025b<Params, Result> extends AbstractCallableC5031h<Params, Result> {

    /* renamed from: a */
    final /* synthetic */ AbstractC5016a f18335a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C5025b(AbstractC5016a abstractC5016a) {
        super(null);
        this.f18335a = abstractC5016a;
    }

    @Override // java.util.concurrent.Callable
    public Result call() throws SecurityException, IllegalArgumentException {
        Process.setThreadPriority(10);
        return (Result) this.f18335a.mo6106a((Object[]) this.f18344b);
    }
}
