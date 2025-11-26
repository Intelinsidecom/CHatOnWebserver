package com.sec.chaton.p037j;

import android.net.http.AndroidHttpClient;
import com.sec.chaton.p037j.p039b.C1553b;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.util.EnumC3218cf;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;

/* compiled from: ChatONFileHttpClient.java */
/* renamed from: com.sec.chaton.j.a */
/* loaded from: classes.dex */
public class C1540a {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ce A[PHI: r2
  0x00ce: PHI (r2v7 java.io.FileOutputStream) = (r2v6 java.io.FileOutputStream), (r2v8 java.io.FileOutputStream) binds: [B:24:0x00cc, B:41:0x0126] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x012d  */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.io.OutputStream] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m6538a(java.lang.String r8, java.lang.String r9, java.lang.String r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 310
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p037j.C1540a.m6538a(java.lang.String, java.lang.String, java.lang.String, boolean):java.lang.String");
    }

    /* renamed from: a */
    public static String m6537a(C1580h c1580h, byte[] bArr) {
        return m6536a(c1580h, null, bArr);
    }

    /* renamed from: a */
    public static String m6536a(C1580h c1580h, String str, byte[] bArr) throws IOException {
        String str2;
        HttpUriRequest httpUriRequestM6539a;
        InputStream inputStreamM6535a;
        if (str == null) {
            str2 = C1554c.m6590a(EnumC3218cf.PRIMARY, c1580h.m6698a()) + c1580h.m6702b();
        } else {
            str2 = str + c1580h.m6702b();
        }
        C3250y.m11453c("[ChatONFileHttpClient] Request URL : " + str2, "ChatONFileHttpClient");
        switch (C1551b.f5704a[c1580h.m11692k().ordinal()]) {
            case 1:
                httpUriRequestM6539a = m6540b(c1580h, str2, bArr);
                if (c1580h.m6707g() != null) {
                    httpUriRequestM6539a.addHeader("Content-Type", c1580h.m6707g());
                    break;
                }
                break;
            case 2:
                httpUriRequestM6539a = m6539a(c1580h, str2);
                break;
            default:
                httpUriRequestM6539a = null;
                break;
        }
        if (httpUriRequestM6539a == null || (inputStreamM6535a = m6535a(httpUriRequestM6539a)) == null) {
            return null;
        }
        String strM6591a = C1554c.m6591a(inputStreamM6535a);
        try {
            inputStreamM6535a.close();
            return strM6591a;
        } catch (IOException e) {
            return strM6591a;
        }
    }

    /* renamed from: a */
    private static InputStream m6535a(HttpUriRequest httpUriRequest) {
        HttpClient httpClientM6595b = C1554c.m6595b();
        try {
            if (!C1554c.m6594a()) {
                throw new IOException("NetWork is not available");
            }
            C3250y.m11450b("execute to : " + httpUriRequest.getURI().toString(), "ChatONFileHttpClient");
            HttpResponse httpResponseExecute = httpClientM6595b.execute(httpUriRequest);
            int statusCode = httpResponseExecute.getStatusLine().getStatusCode();
            C3250y.m11450b("execute end, status code : " + statusCode, "ChatONFileHttpClient");
            if (statusCode != 200) {
                String strM6588a = null;
                if (httpResponseExecute.getEntity() != null) {
                    try {
                        InputStream content = httpResponseExecute.getEntity().getContent();
                        String strM6591a = C1554c.m6591a(content);
                        strM6588a = C1553b.m6588a(strM6591a);
                        C3250y.m11456e(strM6591a, C1540a.class.getSimpleName());
                        if (content != null) {
                            try {
                                content.close();
                            } catch (Exception e) {
                            }
                        }
                    } catch (Exception e2) {
                        C3250y.m11443a(e2, C1540a.class.getSimpleName());
                    }
                }
                throw new IOException(strM6588a);
            }
            return httpResponseExecute.getEntity().getContent();
        } finally {
            if (httpClientM6595b instanceof AndroidHttpClient) {
                ((AndroidHttpClient) httpClientM6595b).close();
            }
        }
    }

    /* renamed from: a */
    private static HttpUriRequest m6539a(C1580h c1580h, String str) {
        return new HttpGet(C1554c.m6592a(str, c1580h.m6706f()));
    }

    /* renamed from: b */
    private static HttpUriRequest m6540b(C1580h c1580h, String str, byte[] bArr) {
        HttpPost httpPost = new HttpPost(C1554c.m6592a(str, c1580h.m6706f()));
        if (bArr != null) {
            httpPost.setEntity(new ByteArrayEntity(bArr));
        }
        return httpPost;
    }
}
