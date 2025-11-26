package android.support.v4.content;

import android.os.AsyncTask;
import java.util.concurrent.CountDownLatch;

/* renamed from: android.support.v4.content.a */
/* loaded from: classes.dex */
final class AsyncTaskC0019a extends AsyncTask implements Runnable {

    /* renamed from: a */
    Object f130a;

    /* renamed from: b */
    boolean f131b;

    /* renamed from: c */
    final /* synthetic */ AsyncTaskLoader f132c;

    /* renamed from: d */
    private CountDownLatch f133d = new CountDownLatch(1);

    AsyncTaskC0019a(AsyncTaskLoader asyncTaskLoader) {
        this.f132c = asyncTaskLoader;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Object doInBackground(Void... voidArr) {
        this.f130a = this.f132c.m140v();
        return this.f130a;
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        try {
            this.f132c.m132a(this, this.f130a);
        } finally {
            this.f133d.countDown();
        }
    }

    @Override // android.os.AsyncTask
    protected void onPostExecute(Object obj) {
        try {
            this.f132c.m134b(this, obj);
        } finally {
            this.f133d.countDown();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f131b = false;
        this.f132c.m139u();
    }
}
