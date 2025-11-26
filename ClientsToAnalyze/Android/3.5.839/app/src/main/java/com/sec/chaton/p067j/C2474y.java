package com.sec.chaton.p067j;

/* JADX INFO: Add missing generic type declarations: [Params, Result] */
/* compiled from: TcpBaseWorker.java */
/* renamed from: com.sec.chaton.j.y */
/* loaded from: classes.dex */
class C2474y<Params, Result> extends AbstractCallableC2416ae<Params, Result> {

    /* renamed from: a */
    final /* synthetic */ AbstractC2473x f8880a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C2474y(AbstractC2473x abstractC2473x) {
        super(null);
        this.f8880a = abstractC2473x;
    }

    @Override // java.util.concurrent.Callable
    public Result call() {
        return (Result) this.f8880a.mo10474b((Object[]) this.f8595b);
    }
}
