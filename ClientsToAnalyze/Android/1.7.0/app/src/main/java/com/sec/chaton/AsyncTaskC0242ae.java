package com.sec.chaton;

import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;
import com.sec.chaton.p018c.C0495d;
import com.sec.chaton.util.C1323bs;
import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;

/* compiled from: HomeActivity.java */
/* renamed from: com.sec.chaton.ae */
/* loaded from: classes.dex */
class AsyncTaskC0242ae extends AsyncTask {

    /* renamed from: a */
    final /* synthetic */ HomeActivity f586a;

    /* renamed from: b */
    private int f587b;

    /* renamed from: c */
    private int f588c;

    /* renamed from: d */
    private int f589d;

    /* synthetic */ AsyncTaskC0242ae(HomeActivity homeActivity, C0462c c0462c) {
        this(homeActivity);
    }

    private AsyncTaskC0242ae(HomeActivity homeActivity) {
        this.f586a = homeActivity;
        this.f587b = 0;
        this.f588c = 1;
        this.f589d = 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(Void... voidArr) {
        AndroidHttpClient androidHttpClient;
        HttpClient httpClientM2516b = C0495d.m2516b();
        HttpGet httpGet = new HttpGet(this.f586a.m635b());
        try {
            try {
                try {
                    boolean z = this.f586a.m634b(EntityUtils.toString(httpClientM2516b.execute(httpGet).getEntity())) == this.f589d;
                    C1323bs.m4576a("ChatONVDownloadalbe", Boolean.valueOf(z));
                    C1323bs.m4576a("ChatONVDownloadPopup", Boolean.valueOf(z));
                } catch (ClientProtocolException e) {
                    httpGet.abort();
                    if (!(httpClientM2516b instanceof AndroidHttpClient)) {
                        return null;
                    }
                    androidHttpClient = (AndroidHttpClient) httpClientM2516b;
                } catch (Exception e2) {
                    httpGet.abort();
                    e2.printStackTrace();
                    if (!(httpClientM2516b instanceof AndroidHttpClient)) {
                        return null;
                    }
                    androidHttpClient = (AndroidHttpClient) httpClientM2516b;
                }
            } catch (IOException e3) {
                httpGet.abort();
                if (!(httpClientM2516b instanceof AndroidHttpClient)) {
                    return null;
                }
                androidHttpClient = (AndroidHttpClient) httpClientM2516b;
            }
            if (!(httpClientM2516b instanceof AndroidHttpClient)) {
                return null;
            }
            androidHttpClient = (AndroidHttpClient) httpClientM2516b;
            androidHttpClient.close();
            httpClientM2516b = null;
            return null;
        } catch (Throwable th) {
            if (httpClientM2516b instanceof AndroidHttpClient) {
                ((AndroidHttpClient) httpClientM2516b).close();
            }
            throw th;
        }
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        super.onCancelled();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Void r1) {
        super.onPostExecute(r1);
    }
}
