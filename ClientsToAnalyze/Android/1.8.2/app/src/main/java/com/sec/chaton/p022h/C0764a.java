package com.sec.chaton.p022h;

import android.net.Uri;
import android.net.http.AndroidHttpClient;
import com.sec.chaton.p022h.p024b.C0775b;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.EnumC1764bt;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;

/* compiled from: ChatONFileHttpClient.java */
/* renamed from: com.sec.chaton.h.a */
/* loaded from: classes.dex */
public class C0764a {
    /* renamed from: a */
    public static String m3270a(String str, String str2, String str3, boolean z) {
        Uri uriFromFile;
        if (C1786r.f6452b) {
            C1786r.m6061b("requestUrl: " + str, "File Downlad Task");
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setDoInput(true);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(30000);
        httpURLConnection.connect();
        InputStream inputStream = httpURLConnection.getInputStream();
        if (z) {
            str2 = str2 + "thumbnail//";
        }
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, String.valueOf(System.currentTimeMillis()) + str3);
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        int i = 0;
        while (true) {
            int i2 = inputStream.read();
            if (i2 == -1) {
                break;
            }
            fileOutputStream.write(i2);
            i++;
            if (C1786r.f6452b && i % 1000 == 0) {
                C1786r.m6061b("nReadCount: " + i + ", fileName: " + str3, "File Downlad Task");
            }
        }
        File file3 = new File(file, str3);
        boolean zRenameTo = file2.renameTo(file3);
        fileOutputStream.flush();
        fileOutputStream.close();
        if (zRenameTo) {
            uriFromFile = Uri.fromFile(file3);
        } else {
            uriFromFile = Uri.fromFile(file2);
        }
        if (uriFromFile != null) {
            if (C1786r.f6452b) {
                C1786r.m6061b("uri: " + uriFromFile.toString() + ", fileName:" + str3, "File Downlad Task");
            }
            return Uri.decode(uriFromFile.toString());
        }
        return null;
    }

    /* renamed from: a */
    public static String m3269a(C0798h c0798h, byte[] bArr) {
        return m3268a(c0798h, null, bArr);
    }

    /* renamed from: a */
    public static String m3268a(C0798h c0798h, String str, byte[] bArr) throws IOException {
        String str2;
        HttpUriRequest httpUriRequestM3271a;
        InputStream inputStreamM3267a;
        if (str == null) {
            str2 = C0776c.m3308a(EnumC1764bt.PRIMARY, c0798h.m3393a()) + c0798h.m3394b();
        } else {
            str2 = str + c0798h.m3394b();
        }
        C1786r.m6063c("[ChatONFileHttpClient] Request URL : " + str2, "ChatONFileHttpClient");
        switch (C0773b.f2821a[c0798h.m3395c().ordinal()]) {
            case 1:
                httpUriRequestM3271a = m3272b(c0798h, str2, bArr);
                if (c0798h.m3400h() != null) {
                    httpUriRequestM3271a.addHeader("Content-Type", c0798h.m3400h());
                    break;
                }
                break;
            case 2:
                httpUriRequestM3271a = m3271a(c0798h, str2);
                break;
            default:
                httpUriRequestM3271a = null;
                break;
        }
        if (httpUriRequestM3271a == null || (inputStreamM3267a = m3267a(httpUriRequestM3271a)) == null) {
            return null;
        }
        String strM3309a = C0776c.m3309a(inputStreamM3267a);
        try {
            inputStreamM3267a.close();
            return strM3309a;
        } catch (IOException e) {
            return strM3309a;
        }
    }

    /* renamed from: a */
    private static InputStream m3267a(HttpUriRequest httpUriRequest) {
        HttpClient httpClientM3323b = C0776c.m3323b();
        try {
            if (!C0776c.m3317a()) {
                throw new IOException("NetWork is not available");
            }
            C1786r.m6061b("execute to : " + httpUriRequest.getURI().toString(), "ChatONFileHttpClient");
            HttpResponse httpResponseExecute = httpClientM3323b.execute(httpUriRequest);
            int statusCode = httpResponseExecute.getStatusLine().getStatusCode();
            C1786r.m6061b("execute end, status code : " + statusCode, "ChatONFileHttpClient");
            if (statusCode != 200) {
                String strM3303a = null;
                if (httpResponseExecute.getEntity() != null) {
                    try {
                        InputStream content = httpResponseExecute.getEntity().getContent();
                        String strM3309a = C0776c.m3309a(content);
                        strM3303a = C0775b.m3303a(strM3309a);
                        C1786r.m6066e(strM3309a, C0764a.class.getSimpleName());
                        if (content != null) {
                            try {
                                content.close();
                            } catch (Exception e) {
                            }
                        }
                    } catch (Exception e2) {
                        C1786r.m6056a(e2, C0764a.class.getSimpleName());
                    }
                }
                throw new IOException(strM3303a);
            }
            return httpResponseExecute.getEntity().getContent();
        } finally {
            if (httpClientM3323b instanceof AndroidHttpClient) {
                ((AndroidHttpClient) httpClientM3323b).close();
            }
        }
    }

    /* renamed from: a */
    private static HttpUriRequest m3271a(C0798h c0798h, String str) {
        return new HttpGet(C0776c.m3310a(str, c0798h.m3396d()));
    }

    /* renamed from: b */
    private static HttpUriRequest m3272b(C0798h c0798h, String str, byte[] bArr) {
        HttpPost httpPost = new HttpPost(C0776c.m3310a(str, c0798h.m3396d()));
        if (bArr != null) {
            httpPost.setEntity(new ByteArrayEntity(bArr));
        }
        return httpPost;
    }
}
