package com.sec.chaton.p018c;

import android.net.Uri;
import android.net.http.AndroidHttpClient;
import com.sec.chaton.p018c.p022d.C0497b;
import com.sec.chaton.util.C1341p;
import com.sec.chaton.util.EnumC1289al;
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
/* renamed from: com.sec.chaton.c.ac */
/* loaded from: classes.dex */
public class C0478ac {
    /* renamed from: a */
    public static String m2468a(String str, String str2, String str3, boolean z) {
        Uri uriFromFile;
        if (C1341p.f4578b) {
            C1341p.m4658b("requestUrl: " + str, "File Downlad Task");
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
            if (C1341p.f4578b && i % 1000 == 0) {
                C1341p.m4658b("nReadCount: " + i + ", fileName: " + str3, "File Downlad Task");
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
            if (C1341p.f4578b) {
                C1341p.m4658b("uri: " + uriFromFile.toString() + ", fileName:" + str3, "File Downlad Task");
            }
            return Uri.decode(uriFromFile.toString());
        }
        return null;
    }

    /* renamed from: a */
    public static String m2467a(C0503j c0503j, byte[] bArr) {
        return m2466a(c0503j, null, bArr);
    }

    /* renamed from: a */
    public static String m2466a(C0503j c0503j, String str, byte[] bArr) throws IOException {
        String str2;
        HttpUriRequest httpUriRequestM2469a;
        InputStream inputStreamM2465a;
        if (str == null) {
            str2 = C0495d.m2502a(EnumC1289al.PRIMARY, c0503j.m2528a()) + c0503j.m2529b();
        } else {
            str2 = str + c0503j.m2529b();
        }
        C1341p.m4660c("[ChatONFileHttpClient] Request URL : " + str2, "ChatONFileHttpClient");
        switch (C0513t.f1672a[c0503j.m2530c().ordinal()]) {
            case 1:
                httpUriRequestM2469a = m2470b(c0503j, str2, bArr);
                if (c0503j.m2535h() != null) {
                    httpUriRequestM2469a.addHeader("Content-Type", c0503j.m2535h());
                    break;
                }
                break;
            case 2:
                httpUriRequestM2469a = m2469a(c0503j, str2);
                break;
            default:
                httpUriRequestM2469a = null;
                break;
        }
        if (httpUriRequestM2469a == null || (inputStreamM2465a = m2465a(httpUriRequestM2469a)) == null) {
            return null;
        }
        String strM2503a = C0495d.m2503a(inputStreamM2465a);
        try {
            inputStreamM2465a.close();
            return strM2503a;
        } catch (IOException e) {
            return strM2503a;
        }
    }

    /* renamed from: a */
    private static InputStream m2465a(HttpUriRequest httpUriRequest) {
        HttpClient httpClientM2516b = C0495d.m2516b();
        try {
            if (!C0495d.m2511a()) {
                throw new IOException("NetWork is not available");
            }
            C1341p.m4658b("execute to : " + httpUriRequest.getURI().toString(), "ChatONFileHttpClient");
            HttpResponse httpResponseExecute = httpClientM2516b.execute(httpUriRequest);
            int statusCode = httpResponseExecute.getStatusLine().getStatusCode();
            C1341p.m4658b("execute end, status code : " + statusCode, "ChatONFileHttpClient");
            if (statusCode != 200) {
                String strM2520a = null;
                if (httpResponseExecute.getEntity() != null) {
                    try {
                        InputStream content = httpResponseExecute.getEntity().getContent();
                        String strM2503a = C0495d.m2503a(content);
                        strM2520a = C0497b.m2520a(strM2503a);
                        C1341p.m4662e(strM2503a, C0478ac.class.getSimpleName());
                        if (content != null) {
                            try {
                                content.close();
                            } catch (Exception e) {
                            }
                        }
                    } catch (Exception e2) {
                        C1341p.m4653a(e2, C0478ac.class.getSimpleName());
                    }
                }
                throw new IOException(strM2520a);
            }
            return httpResponseExecute.getEntity().getContent();
        } finally {
            if (httpClientM2516b instanceof AndroidHttpClient) {
                ((AndroidHttpClient) httpClientM2516b).close();
            }
        }
    }

    /* renamed from: a */
    private static HttpUriRequest m2469a(C0503j c0503j, String str) {
        return new HttpGet(C0495d.m2504a(str, c0503j.m2531d()));
    }

    /* renamed from: b */
    private static HttpUriRequest m2470b(C0503j c0503j, String str, byte[] bArr) {
        HttpPost httpPost = new HttpPost(C0495d.m2504a(str, c0503j.m2531d()));
        if (bArr != null) {
            httpPost.setEntity(new ByteArrayEntity(bArr));
        }
        return httpPost;
    }
}
