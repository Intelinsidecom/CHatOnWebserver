package com.sds.coolots.common.httpAdaptor;

import com.sds.coolots.MainApplication;
import com.sds.coolots.common.util.Log;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.SingleClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

/* renamed from: com.sds.coolots.common.httpAdaptor.b */
/* loaded from: classes.dex */
public class C1252b implements HttpClientInterface {

    /* renamed from: d */
    public static final boolean f3031d = true;

    /* renamed from: e */
    private static final boolean f3032e = false;

    /* renamed from: g */
    private static ClientConnectionManager f3033g = null;

    /* renamed from: a */
    protected int f3034a = 6000;

    /* renamed from: b */
    protected int f3035b = 6000;

    /* renamed from: c */
    protected String f3036c = "[ApacheHttpClient]";

    /* renamed from: f */
    private ClientConnectionManager f3037f = null;

    /* renamed from: h */
    private Serializable f3038h;

    /* renamed from: i */
    private HttpClient f3039i;

    /* renamed from: a */
    private ClientConnectionManager m2924a(HttpParams httpParams) {
        if (this.f3037f == null) {
            SchemeRegistry schemeRegistry = new SchemeRegistry();
            schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
            schemeRegistry.register(new Scheme("https", new C1257g(), 443));
            this.f3037f = new SingleClientConnManager(httpParams, schemeRegistry);
        }
        return this.f3037f;
    }

    /* renamed from: a */
    protected DefaultHttpClient m2925a() {
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, this.f3034a);
        HttpConnectionParams.setSoTimeout(basicHttpParams, this.f3035b);
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient(m2924a(basicHttpParams), basicHttpParams);
        defaultHttpClient.addRequestInterceptor(new C1255e(this));
        return defaultHttpClient;
    }

    /* renamed from: a */
    public void m2926a(String str) {
        Log.m2958e(String.valueOf(this.f3036c) + str);
    }

    /* renamed from: b */
    public void m2927b(String str) {
        Log.m2954d(String.valueOf(this.f3036c) + str);
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpClientInterface
    public void cancelTransaction() {
        if (this.f3039i != null) {
            this.f3039i.getConnectionManager().shutdown();
        }
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpClientInterface
    public Serializable getTransactionResult() {
        return this.f3038h;
    }

    /* JADX WARN: Type inference failed for: r0v23, types: [byte[], java.io.Serializable] */
    @Override // com.sds.coolots.common.httpAdaptor.HttpClientInterface
    public int httpTransaction(String str, String str2, int i) {
        this.f3035b = i;
        try {
            m2927b("CONNECTING=" + str2);
            this.f3039i = m2925a();
            HttpPost httpPost = new HttpPost(str2);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair("si", MainApplication.mConfig.getSessionID()));
            arrayList.add(new BasicNameValuePair("value", str));
            UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(arrayList, "UTF-8");
            if (str.length() > 3000) {
                urlEncodedFormEntity.setChunked(true);
            }
            httpPost.setEntity(urlEncodedFormEntity);
            ?? r0 = (byte[]) this.f3039i.execute(httpPost, new C1253c(this));
            this.f3039i.getConnectionManager().shutdown();
            if (r0 == 0 || r0.length == 0) {
                return -4;
            }
            this.f3038h = r0;
            return 0;
        } catch (InterruptedIOException e) {
            m2926a(e.getMessage());
            return -10;
        } catch (UnsupportedEncodingException e2) {
            m2926a(e2.getMessage());
            return -14;
        } catch (IOException e3) {
            m2926a(e3.getMessage());
            return -7;
        } catch (Exception e4) {
            m2926a(e4.getMessage());
            return -1;
        } catch (OutOfMemoryError e5) {
            m2926a(e5.getMessage());
            return -7;
        }
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpClientInterface
    public int httpsTransaction(String str, String str2, String str3, int i) {
        this.f3035b = i;
        try {
            m2927b("CONNECTING=" + str3);
            this.f3039i = m2925a();
            HttpPost httpPost = new HttpPost(str3);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair("v1", str));
            arrayList.add(new BasicNameValuePair("v2", str2));
            httpPost.setEntity(new UrlEncodedFormEntity(arrayList, "UTF-8"));
            String str4 = (String) this.f3039i.execute(httpPost, new C1254d(this));
            this.f3039i.getConnectionManager().shutdown();
            if (str4 == null || str4.isEmpty()) {
                return -4;
            }
            m2927b("RCV Orginal Length=" + str4.length());
            m2927b("RCV Orginal Data=<" + str4 + ">");
            this.f3038h = str4;
            return 0;
        } catch (InterruptedIOException e) {
            m2926a(e.getMessage());
            return -10;
        } catch (UnsupportedEncodingException e2) {
            m2926a(e2.getMessage());
            return -14;
        } catch (IOException e3) {
            m2926a(e3.getMessage());
            return -7;
        } catch (Exception e4) {
            m2926a(e4.getMessage());
            return -1;
        }
    }
}
