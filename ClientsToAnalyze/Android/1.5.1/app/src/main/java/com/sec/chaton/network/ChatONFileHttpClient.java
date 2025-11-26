package com.sec.chaton.network;

import android.net.Uri;
import android.net.http.AndroidHttpClient;
import com.sec.chaton.network.code.FaultCodeExtractor;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ServerAddressMgr;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;

/* loaded from: classes.dex */
public class ChatONFileHttpClient {
    /* renamed from: a */
    private static InputStream m2698a(HttpUriRequest httpUriRequest) {
        String str;
        HttpClient httpClientM2721b = ChatONHttpClient2.m2721b();
        try {
            if (!ChatONHttpClient2.m2716a()) {
                throw new IOException("NetWork is not available");
            }
            ChatONLogWriter.m3506b("execute to : " + httpUriRequest.getURI().toString(), "ChatONFileHttpClient");
            HttpResponse httpResponseExecute = httpClientM2721b.execute(httpUriRequest);
            int statusCode = httpResponseExecute.getStatusLine().getStatusCode();
            ChatONLogWriter.m3506b("execute end, status code : " + statusCode, "ChatONFileHttpClient");
            if (statusCode == 200) {
                return httpResponseExecute.getEntity().getContent();
            }
            String strM2825a = null;
            if (httpResponseExecute.getEntity() != null) {
                try {
                    InputStream content = httpResponseExecute.getEntity().getContent();
                    String strM2709a = ChatONHttpClient2.m2709a(content);
                    strM2825a = FaultCodeExtractor.m2825a(strM2709a);
                    ChatONLogWriter.m3511e(strM2709a, ChatONFileHttpClient.class.getSimpleName());
                    if (content != null) {
                        try {
                            content.close();
                        } catch (Exception e) {
                        }
                    }
                    str = strM2825a;
                } catch (Exception e2) {
                    ChatONLogWriter.m3501a(e2, ChatONFileHttpClient.class.getSimpleName());
                    str = strM2825a;
                }
            } else {
                str = null;
            }
            throw new IOException(str);
        } finally {
            if (httpClientM2721b instanceof AndroidHttpClient) {
                ((AndroidHttpClient) httpClientM2721b).close();
            }
        }
    }

    /* renamed from: a */
    public static String m2699a(HttpEnvelope httpEnvelope, String str, byte[] bArr) throws IOException {
        HttpUriRequest httpUriRequestM2702a;
        InputStream inputStreamM2698a;
        String str2 = str == null ? ChatONHttpClient2.m2708a(ServerAddressMgr.ServerType.PRIMARY, httpEnvelope.m2728a()) + httpEnvelope.m2729b() : str + httpEnvelope.m2729b();
        ChatONLogWriter.m3508c("[ChatONFileHttpClient] Request URL : " + str2, "ChatONFileHttpClient");
        switch (C0343e.f2538a[httpEnvelope.m2730c().ordinal()]) {
            case 1:
                httpUriRequestM2702a = m2703b(httpEnvelope, str2, bArr);
                if (httpEnvelope.m2735h() != null) {
                    httpUriRequestM2702a.addHeader("Content-Type", httpEnvelope.m2735h());
                    break;
                }
                break;
            case 2:
                httpUriRequestM2702a = m2702a(httpEnvelope, str2);
                break;
            default:
                httpUriRequestM2702a = null;
                break;
        }
        if (httpUriRequestM2702a == null || (inputStreamM2698a = m2698a(httpUriRequestM2702a)) == null) {
            return null;
        }
        String strM2709a = ChatONHttpClient2.m2709a(inputStreamM2698a);
        try {
            inputStreamM2698a.close();
            return strM2709a;
        } catch (IOException e) {
            return strM2709a;
        }
    }

    /* renamed from: a */
    public static String m2700a(HttpEnvelope httpEnvelope, byte[] bArr) {
        return m2699a(httpEnvelope, null, bArr);
    }

    /* renamed from: a */
    public static String m2701a(String str, String str2, String str3, boolean z) throws IOException {
        InputStream inputStreamOpenStream = new URL(str).openStream();
        File file = new File(z ? str2 + "thumbnail//" : str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, String.valueOf(System.currentTimeMillis()) + str3);
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        int i = 0;
        while (true) {
            int i2 = inputStreamOpenStream.read();
            if (i2 == -1) {
                break;
            }
            fileOutputStream.write(i2);
            i++;
        }
        File file3 = new File(file, str3);
        boolean zRenameTo = file2.renameTo(file3);
        fileOutputStream.flush();
        fileOutputStream.close();
        Uri uriFromFile = zRenameTo ? Uri.fromFile(file3) : Uri.fromFile(file2);
        if (uriFromFile == null) {
            return null;
        }
        ChatONLogWriter.m3506b(uriFromFile.toString(), "File Downlad Task");
        return Uri.decode(uriFromFile.toString());
    }

    /* renamed from: a */
    private static HttpUriRequest m2702a(HttpEnvelope httpEnvelope, String str) {
        return new HttpGet(ChatONHttpClient2.m2710a(str, httpEnvelope.m2731d()));
    }

    /* renamed from: b */
    private static HttpUriRequest m2703b(HttpEnvelope httpEnvelope, String str, byte[] bArr) {
        HttpPost httpPost = new HttpPost(ChatONHttpClient2.m2710a(str, httpEnvelope.m2731d()));
        if (bArr != null) {
            httpPost.setEntity(new ByteArrayEntity(bArr));
        }
        return httpPost;
    }
}
