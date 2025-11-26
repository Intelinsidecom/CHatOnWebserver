package android.support.v4.content;

import android.os.Process;

/* JADX INFO: Add missing generic type declarations: [Params, Result] */
/* compiled from: ModernAsyncTask.java */
/* renamed from: android.support.v4.content.o */
/* loaded from: classes.dex */
class C0102o<Params, Result> extends AbstractCallableC0108u<Params, Result> {

    /* renamed from: a */
    final /* synthetic */ AbstractC0100m f339a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0102o(AbstractC0100m abstractC0100m) {
        super(null);
        this.f339a = abstractC0100m;
    }

    @Override // java.util.concurrent.Callable
    public Result call() throws SecurityException, IllegalArgumentException {
        this.f339a.f337i.set(true);
        Process.setThreadPriority(10);
        return (Result) this.f339a.m369d(this.f339a.mo328a((Object[]) this.f348b));
    }
}
