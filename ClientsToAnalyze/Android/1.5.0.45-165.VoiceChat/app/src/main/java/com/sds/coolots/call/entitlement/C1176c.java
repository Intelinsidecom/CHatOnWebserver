package com.sds.coolots.call.entitlement;

import android.os.Handler;
import com.sds.coolots.common.util.Log;
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

/* renamed from: com.sds.coolots.call.entitlement.c */
/* loaded from: classes.dex */
public class C1176c extends Thread {

    /* renamed from: a */
    private Handler f2418a;

    public C1176c(Handler handler) {
        this.f2418a = null;
        this.f2418a = handler;
    }

    /* renamed from: a */
    private void m2217a(String str) {
        Log.m2963i("[ATNTEntitlementCheck]" + str);
    }

    /* renamed from: b */
    private void m2218b(String str) {
        Log.m2963i("[ATNTEntitlementCheck]" + str);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() throws IOException {
        int i = 3;
        m2217a("run()");
        try {
            HttpResponse httpResponseExecute = new DefaultHttpClient().execute(new HttpGet("http://entitlement.mobile.att.net/gvc1"));
            if (httpResponseExecute.getStatusLine().getStatusCode() == 200) {
                m2217a("response 200OK");
                i = 1;
            } else if (httpResponseExecute.getStatusLine().getStatusCode() == 403) {
                m2217a("response 403OK");
                i = 2;
            } else {
                m2217a("response network error");
            }
        } catch (ClientProtocolException e) {
            m2218b(e.getMessage() + "\n" + e.getCause());
        } catch (IOException e2) {
            m2218b(e2.getMessage() + "\n" + e2.getCause());
        }
        this.f2418a.sendEmptyMessage(i);
        super.run();
    }
}
