package com.sec.chaton.p067j;

import android.net.http.AndroidHttpClient;
import android.text.TextUtils;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p067j.p069b.C2432b;
import com.sec.chaton.util.C4808a;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.EnumC4867ce;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;

/* compiled from: ChatONFileHttpClient.java */
/* renamed from: com.sec.chaton.j.a */
/* loaded from: classes.dex */
public class C2410a {
    /* renamed from: a */
    public static String m10441a(C2454e c2454e, byte[] bArr) {
        return m10440a(c2454e, null, bArr);
    }

    /* renamed from: a */
    public static String m10440a(C2454e c2454e, String str, byte[] bArr) throws IOException {
        String str2;
        HttpUriRequest httpUriRequestM10443a;
        InputStream inputStreamM10439a;
        if (str == null) {
            str2 = C2433c.m10534a(EnumC4867ce.PRIMARY, c2454e.m10628a()) + c2454e.m10631b();
        } else {
            str2 = str + c2454e.m10631b();
        }
        C4904y.m18641c("[ChatONFileHttpClient] Request URL : " + str2, "ChatONFileHttpClient");
        switch (C2430b.f8654a[c2454e.m18942i().ordinal()]) {
            case 1:
                httpUriRequestM10443a = m10444b(c2454e, str2, bArr);
                if (c2454e.m10634e() != null) {
                    httpUriRequestM10443a.addHeader("Content-Type", c2454e.m10634e());
                    break;
                }
                break;
            case 2:
                httpUriRequestM10443a = m10443a(c2454e, str2);
                break;
            default:
                httpUriRequestM10443a = null;
                break;
        }
        if (httpUriRequestM10443a == null || (inputStreamM10439a = m10439a(httpUriRequestM10443a)) == null) {
            return null;
        }
        String strM10535a = C2433c.m10535a(inputStreamM10439a);
        try {
            inputStreamM10439a.close();
            return strM10535a;
        } catch (IOException e) {
            return strM10535a;
        }
    }

    /* renamed from: a */
    private static InputStream m10439a(HttpUriRequest httpUriRequest) {
        HttpClient httpClientM10539b = C2433c.m10539b();
        try {
            if (!C2433c.m10538a()) {
                throw new IOException("NetWork is not available");
            }
            C4904y.m18639b("execute to : " + httpUriRequest.getURI().toString(), "ChatONFileHttpClient");
            HttpResponse httpResponseExecute = httpClientM10539b.execute(httpUriRequest);
            int statusCode = httpResponseExecute.getStatusLine().getStatusCode();
            C4904y.m18639b("execute end, status code : " + statusCode, "ChatONFileHttpClient");
            if (statusCode != 200) {
                String strM10533a = null;
                if (httpResponseExecute.getEntity() != null) {
                    try {
                        InputStream content = httpResponseExecute.getEntity().getContent();
                        String strM10535a = C2433c.m10535a(content);
                        strM10533a = C2432b.m10533a(strM10535a);
                        C4904y.m18646e(strM10535a, C2410a.class.getSimpleName());
                        if (content != null) {
                            try {
                                content.close();
                            } catch (Exception e) {
                            }
                        }
                    } catch (Exception e2) {
                        C4904y.m18635a(e2, C2410a.class.getSimpleName());
                    }
                }
                throw new IOException(strM10533a);
            }
            return httpResponseExecute.getEntity().getContent();
        } finally {
            if (httpClientM10539b instanceof AndroidHttpClient) {
                ((AndroidHttpClient) httpClientM10539b).close();
            }
        }
    }

    /* renamed from: a */
    private static HttpUriRequest m10443a(C2454e c2454e, String str) {
        return new HttpGet(C2433c.m10536a(str, c2454e.m10633d()));
    }

    /* renamed from: b */
    private static HttpUriRequest m10444b(C2454e c2454e, String str, byte[] bArr) {
        HttpPost httpPost = new HttpPost(m10442a(str, c2454e));
        if (bArr != null) {
            httpPost.setEntity(new ByteArrayEntity(bArr));
        }
        return httpPost;
    }

    /* renamed from: a */
    private static String m10442a(String str, C2454e c2454e) throws IOException {
        Map<String, String> mapM = c2454e.m18946m();
        if (mapM == null || mapM.isEmpty()) {
            throw new IOException("paramMap is empty");
        }
        String string = new StringBuffer().append("imei=").append(C4822an.m18228d()).append("&filename=").append(mapM.get("filename")).toString();
        if (C4904y.f17872b) {
            C4904y.m18639b("[File Upload/Before Encrypt] : " + string, "ChatONFileHttpClient");
        }
        try {
            String strM18595a = GlobalApplication.m10284c().m18595a();
            if (TextUtils.isEmpty(strM18595a)) {
                throw new IOException("Fail in getting a key");
            }
            String strM18098a = C4808a.m18098a(new C4808a(C4808a.m18100b(strM18595a), C4808a.m18101c(strM18595a)).m18102b(string.getBytes()));
            if (C4904y.f17872b) {
                C4904y.m18639b("[File Upload/After Encrypt] : " + strM18098a, "ChatONFileHttpClient");
            }
            String string2 = new StringBuffer().append(str).append("?uid=").append(C4809aa.m18104a().m18121a("uid", "")).append("&param=").append(strM18098a).append("&r=" + System.currentTimeMillis()).toString();
            if (C4904y.f17872b) {
                C4904y.m18639b("[File requestURL: " + string2, "ChatONFileHttpClient");
            }
            return string2;
        } catch (Exception e) {
            throw new IOException("Encryption Error");
        }
    }
}
