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
public class AsyncTaskC0453aw extends AsyncTask<Void, Void, List<C0456az>> {

    /* renamed from: a */
    private static final String f1102a = AsyncTaskC0453aw.class.getCanonicalName();

    /* renamed from: b */
    private static Method f1103b;

    /* renamed from: c */
    private final HttpURLConnection f1104c;

    /* renamed from: d */
    private final C0454ax f1105d;

    /* renamed from: e */
    private Exception f1106e;

    static {
        for (Method method : AsyncTask.class.getMethods()) {
            if ("executeOnExecutor".equals(method.getName())) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 2 && parameterTypes[0] == Executor.class && parameterTypes[1].isArray()) {
                    f1103b = method;
                    return;
                }
            }
        }
    }

    public AsyncTaskC0453aw(C0454ax c0454ax) {
        this(null, c0454ax);
    }

    public AsyncTaskC0453aw(HttpURLConnection httpURLConnection, C0454ax c0454ax) {
        this.f1105d = c0454ax;
        this.f1104c = httpURLConnection;
    }

    public String toString() {
        return "{RequestAsyncTask:  connection: " + this.f1104c + ", requests: " + this.f1105d + "}";
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        if (this.f1105d.m1645c() == null) {
            this.f1105d.m1638a(new Handler());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(List<C0456az> list) {
        super.onPostExecute(list);
        if (this.f1106e != null) {
            Log.d(f1102a, String.format("onPostExecute: exception encountered during request: %s", this.f1106e.getMessage()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public List<C0456az> doInBackground(Void... voidArr) {
        List<C0456az> listM1586a;
        try {
            if (this.f1104c == null) {
                listM1586a = this.f1105d.m1649g();
            } else {
                listM1586a = C0443am.m1586a(this.f1104c, this.f1105d);
            }
            return listM1586a;
        } catch (Exception e) {
            this.f1106e = e;
            return null;
        }
    }

    /* renamed from: a */
    AsyncTaskC0453aw m1632a() {
        if (f1103b != null) {
            f1103b.invoke(this, C0498bu.m1808a(), null);
        } else {
            execute(new Void[0]);
        }
        return this;
    }
}
