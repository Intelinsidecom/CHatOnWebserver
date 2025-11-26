package com.facebook;

import android.annotation.TargetApi;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.concurrent.Executor;

/* compiled from: RequestAsyncTask.java */
@TargetApi(3)
/* renamed from: com.facebook.aw */
/* loaded from: classes.dex */
public class AsyncTaskC0082aw extends AsyncTask<Void, Void, List<C0085az>> {

    /* renamed from: a */
    private static final String f133a = AsyncTaskC0082aw.class.getCanonicalName();

    /* renamed from: b */
    private static Method f134b;

    /* renamed from: c */
    private final HttpURLConnection f135c;

    /* renamed from: d */
    private final C0083ax f136d;

    /* renamed from: e */
    private Exception f137e;

    static {
        for (Method method : AsyncTask.class.getMethods()) {
            if ("executeOnExecutor".equals(method.getName())) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 2 && parameterTypes[0] == Executor.class && parameterTypes[1].isArray()) {
                    f134b = method;
                    return;
                }
            }
        }
    }

    public AsyncTaskC0082aw(C0083ax c0083ax) {
        this(null, c0083ax);
    }

    public AsyncTaskC0082aw(HttpURLConnection httpURLConnection, C0083ax c0083ax) {
        this.f136d = c0083ax;
        this.f135c = httpURLConnection;
    }

    public String toString() {
        return "{RequestAsyncTask:  connection: " + this.f135c + ", requests: " + this.f136d + "}";
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        if (this.f136d.m201c() == null) {
            this.f136d.m194a(new Handler());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(List<C0085az> list) {
        super.onPostExecute(list);
        if (this.f137e != null) {
            Log.d(f133a, String.format("onPostExecute: exception encountered during request: %s", this.f137e.getMessage()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public List<C0085az> doInBackground(Void... voidArr) {
        List<C0085az> listM142a;
        try {
            if (this.f135c == null) {
                listM142a = this.f136d.m205g();
            } else {
                listM142a = C0072am.m142a(this.f135c, this.f136d);
            }
            return listM142a;
        } catch (Exception e) {
            this.f137e = e;
            return null;
        }
    }

    /* renamed from: a */
    AsyncTaskC0082aw m188a() {
        if (f134b != null) {
            f134b.invoke(this, C0127bu.m365a(), null);
        } else {
            execute(new Void[0]);
        }
        return this;
    }
}
