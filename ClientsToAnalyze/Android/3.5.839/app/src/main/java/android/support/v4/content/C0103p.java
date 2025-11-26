package android.support.v4.content;

import android.util.Log;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* JADX INFO: Add missing generic type declarations: [Result] */
/* compiled from: ModernAsyncTask.java */
/* renamed from: android.support.v4.content.p */
/* loaded from: classes.dex */
class C0103p<Result> extends FutureTask<Result> {

    /* renamed from: a */
    final /* synthetic */ AbstractC0100m f340a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0103p(AbstractC0100m abstractC0100m, Callable callable) {
        super(callable);
        this.f340a = abstractC0100m;
    }

    @Override // java.util.concurrent.FutureTask
    protected void done() {
        try {
            this.f340a.m368c(get());
        } catch (InterruptedException e) {
            Log.w("AsyncTask", e);
        } catch (CancellationException e2) {
            this.f340a.m368c(null);
        } catch (ExecutionException e3) {
            throw new RuntimeException("An error occured while executing doInBackground()", e3.getCause());
        } catch (Throwable th) {
            throw new RuntimeException("An error occured while executing doInBackground()", th);
        }
    }
}
