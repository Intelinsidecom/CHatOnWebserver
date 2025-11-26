package com.p137vk.sdk.api.httpClient;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Looper;
import com.p137vk.sdk.VKSdkVersion;
import com.p137vk.sdk.VKUIHelper;
import com.p137vk.sdk.api.VKApiConst;
import com.p137vk.sdk.util.VKUtil;
import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;

/* loaded from: classes.dex */
public class VKHttpClient extends DefaultHttpClient {
    private static Executor mBackgroundExecutor = Executors.newCachedThreadPool();
    private static VKHttpClient sInstance;

    private VKHttpClient(ClientConnectionManager clientConnectionManager, HttpParams httpParams) {
        super(clientConnectionManager, httpParams);
    }

    public static VKHttpClient getClient() throws PackageManager.NameNotFoundException {
        if (sInstance == null) {
            SchemeRegistry schemeRegistry = new SchemeRegistry();
            schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
            schemeRegistry.register(new Scheme(VKApiConst.HTTPS, SSLSocketFactory.getSocketFactory(), 443));
            BasicHttpParams basicHttpParams = new BasicHttpParams();
            Activity topActivity = VKUIHelper.getTopActivity();
            if (topActivity != null) {
                try {
                    PackageManager packageManager = topActivity.getPackageManager();
                    if (packageManager != null) {
                        PackageInfo packageInfo = packageManager.getPackageInfo(topActivity.getPackageName(), 0);
                        basicHttpParams.setParameter("http.useragent", String.format(Locale.US, "%s/%s (%s; Android %d; Scale/%.2f; VK SDK %s; %s)", VKUtil.getApplicationName(topActivity), packageInfo.versionName, Build.MODEL, Integer.valueOf(Build.VERSION.SDK_INT), Float.valueOf(topActivity.getResources().getDisplayMetrics().density), VKSdkVersion.SDK_VERSION, packageInfo.packageName));
                    }
                } catch (Exception e) {
                }
            }
            sInstance = new VKHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
        }
        return sInstance;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0044 A[LOOP:0: B:8:0x003e->B:10:0x0044, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.apache.http.client.methods.HttpUriRequest requestWithVkRequest(com.p137vk.sdk.api.VKRequest r13) {
        /*
            r12 = 1
            r11 = 0
            r2 = 0
            com.vk.sdk.api.VKParameters r1 = r13.getPreparedParameters()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.util.Locale r3 = java.util.Locale.US
            java.lang.String r5 = "http%s://api.vk.com/method/%s"
            r0 = 2
            java.lang.Object[] r6 = new java.lang.Object[r0]
            boolean r0 = r13.secure
            if (r0 == 0) goto L54
            java.lang.String r0 = "s"
        L18:
            r6[r11] = r0
            java.lang.String r0 = r13.methodName
            r6[r12] = r0
            java.lang.String r0 = java.lang.String.format(r3, r5, r6)
            r4.<init>(r0)
            int[] r0 = com.p137vk.sdk.api.httpClient.VKHttpClient.C51983.$SwitchMap$com$vk$sdk$api$VKRequest$HttpMethod
            com.vk.sdk.api.VKRequest$HttpMethod r3 = r13.httpMethod
            int r3 = r3.ordinal()
            r0 = r0[r3]
            switch(r0) {
                case 1: goto L58;
                case 2: goto L76;
                default: goto L32;
            }
        L32:
            java.util.Map r3 = getDefaultHeaders()
            java.util.Set r0 = r3.keySet()
            java.util.Iterator r4 = r0.iterator()
        L3e:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto Lfa
            java.lang.Object r0 = r4.next()
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r1 = r3.get(r0)
            java.lang.String r1 = (java.lang.String) r1
            r2.addHeader(r0, r1)
            goto L3e
        L54:
            java.lang.String r0 = ""
            goto L18
        L58:
            int r0 = r1.size()
            if (r0 <= 0) goto L6c
            java.lang.String r0 = "?"
            java.lang.StringBuilder r0 = r4.append(r0)
            java.lang.String r1 = com.p137vk.sdk.util.VKStringJoiner.joinUriParams(r1)
            r0.append(r1)
        L6c:
            org.apache.http.client.methods.HttpGet r2 = new org.apache.http.client.methods.HttpGet
            java.lang.String r0 = r4.toString()
            r2.<init>(r0)
            goto L32
        L76:
            org.apache.http.client.methods.HttpPost r3 = new org.apache.http.client.methods.HttpPost
            java.lang.String r0 = r4.toString()
            r3.<init>(r0)
            java.util.ArrayList r4 = new java.util.ArrayList
            int r0 = r1.size()
            r4.<init>(r0)
            java.util.Set r0 = r1.entrySet()
            java.util.Iterator r5 = r0.iterator()
        L90:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto Leb
            java.lang.Object r0 = r5.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r1 = r0.getValue()
            boolean r6 = r1 instanceof java.util.Collection
            if (r6 == 0) goto Ld4
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r6 = r1.iterator()
        Laa:
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto L90
            java.lang.Object r1 = r6.next()
            org.apache.http.message.BasicNameValuePair r7 = new org.apache.http.message.BasicNameValuePair
            java.lang.String r8 = "%s[]"
            java.lang.Object[] r9 = new java.lang.Object[r12]
            java.lang.Object r10 = r0.getKey()
            r9[r11] = r10
            java.lang.String r8 = java.lang.String.format(r8, r9)
            if (r1 != 0) goto Lcf
            r1 = r2
        Lc8:
            r7.<init>(r8, r1)
            r4.add(r7)
            goto Laa
        Lcf:
            java.lang.String r1 = java.lang.String.valueOf(r1)
            goto Lc8
        Ld4:
            org.apache.http.message.BasicNameValuePair r6 = new org.apache.http.message.BasicNameValuePair
            java.lang.Object r0 = r0.getKey()
            java.lang.String r0 = (java.lang.String) r0
            if (r1 != 0) goto Le6
            r1 = r2
        Ldf:
            r6.<init>(r0, r1)
            r4.add(r6)
            goto L90
        Le6:
            java.lang.String r1 = java.lang.String.valueOf(r1)
            goto Ldf
        Leb:
            org.apache.http.client.entity.UrlEncodedFormEntity r0 = new org.apache.http.client.entity.UrlEncodedFormEntity     // Catch: java.io.UnsupportedEncodingException -> Lf9
            java.lang.String r1 = "UTF-8"
            r0.<init>(r4, r1)     // Catch: java.io.UnsupportedEncodingException -> Lf9
            r3.setEntity(r0)     // Catch: java.io.UnsupportedEncodingException -> Lf9
            r2 = r3
            goto L32
        Lf9:
            r0 = move-exception
        Lfa:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p137vk.sdk.api.httpClient.VKHttpClient.requestWithVkRequest(com.vk.sdk.api.VKRequest):org.apache.http.client.methods.HttpUriRequest");
    }

    public static HttpPost fileUploadRequest(String str, File... fileArr) {
        HttpPost httpPost = new HttpPost(str);
        httpPost.setEntity(new VKMultipartEntity(fileArr));
        return httpPost;
    }

    private static Map<String, String> getDefaultHeaders() {
        return new HashMap<String, String>() { // from class: com.vk.sdk.api.httpClient.VKHttpClient.1
            private static final long serialVersionUID = 200199014417610665L;

            {
                put("Accept-Encoding", "gzip");
            }
        };
    }

    public static void enqueueOperation(final VKAbstractOperation vKAbstractOperation) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            mBackgroundExecutor.execute(new Runnable() { // from class: com.vk.sdk.api.httpClient.VKHttpClient.2
                @Override // java.lang.Runnable
                public void run() {
                    VKHttpClient.enqueueOperation(vKAbstractOperation);
                }
            });
        } else {
            vKAbstractOperation.start();
        }
    }
}
