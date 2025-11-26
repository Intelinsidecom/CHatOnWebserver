package com.sec.chaton.p022h;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.http.AndroidHttpClient;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p015d.C0634f;
import com.sec.chaton.p022h.p024b.C0774a;
import com.sec.chaton.p022h.p024b.C0775b;
import com.sec.chaton.util.C1763bs;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1793y;
import com.sec.chaton.util.EnumC1764bt;
import com.sec.chaton.util.EnumC1765bu;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.List;
import java.util.regex.Pattern;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: ChatONHttpClient2.java */
/* renamed from: com.sec.chaton.h.c */
/* loaded from: classes.dex */
public class C0776c {

    /* renamed from: a */
    public static String f2850a = "application/json";

    /* renamed from: b */
    private static final Pattern f2851b = Pattern.compile("^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");

    /* renamed from: a */
    public static C0101b m3304a(C0101b c0101b, String str) {
        return m3305a(c0101b, str, EnumC1764bt.PRIMARY);
    }

    /* renamed from: a */
    public static C0101b m3305a(C0101b c0101b, String str, EnumC1764bt enumC1764bt) throws IOException {
        m3325c(c0101b, str, enumC1764bt);
        if (c0101b.m669c().m3403k() == -1) {
            m3324b(c0101b, str, enumC1764bt);
        }
        return c0101b;
    }

    /* renamed from: b */
    private static void m3324b(C0101b c0101b, String str, EnumC1764bt enumC1764bt) throws IOException {
        if ((c0101b.m669c().m3399g() == 101 || c0101b.m669c().m3399g() == 102 || c0101b.m669c().m3399g() == 103) && enumC1764bt == EnumC1764bt.PRIMARY && c0101b.m675h() == 500) {
            m3325c(c0101b, str, EnumC1764bt.SECONDARY);
            return;
        }
        if (!TextUtils.isEmpty(c0101b.m674g())) {
            if (enumC1764bt == EnumC1764bt.PRIMARY) {
                if (ConnectTimeoutException.class.toString().equals(c0101b.m674g())) {
                    m3325c(c0101b, str, EnumC1764bt.PRIMARY);
                }
                if (ConnectTimeoutException.class.toString().equals(c0101b.m674g())) {
                    m3305a(c0101b, str, EnumC1764bt.SECONDARY);
                    return;
                }
                return;
            }
            if (ConnectTimeoutException.class.toString().equals(c0101b.m674g())) {
                m3325c(c0101b, str, EnumC1764bt.SECONDARY);
            }
            if (ConnectTimeoutException.class.toString().equals(c0101b.m674g()) && c0101b.m669c().m3399g() != 101 && c0101b.m669c().m3399g() != 102 && c0101b.m669c().m3399g() != 103) {
                new C0634f(new Handler(Looper.getMainLooper())).m2884a();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x006a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.sec.chaton.p007a.p008a.C0101b m3325c(com.sec.chaton.p007a.p008a.C0101b r4, java.lang.String r5, com.sec.chaton.util.EnumC1764bt r6) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 328
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p022h.C0776c.m3325c(com.sec.chaton.a.a.b, java.lang.String, com.sec.chaton.util.bt):com.sec.chaton.a.a.b");
    }

    /* renamed from: a */
    private static InputStream m3306a(HttpUriRequest httpUriRequest, C0798h c0798h, C0101b c0101b) {
        HttpResponse httpResponseExecute;
        HttpClient httpClientM3323b = c0798h.m3403k() == -1 ? m3323b() : m3314a(c0798h.m3403k(), c0798h.m3403k());
        try {
            C1786r.m6061b("excute start to : " + httpUriRequest.getURI(), C0776c.class.getSimpleName());
            try {
                try {
                    try {
                        httpResponseExecute = httpClientM3323b.execute(httpUriRequest);
                    } catch (UnknownHostException e) {
                        c0101b.m661a(e.getClass().toString());
                        c0101b.m659a(EnumC0803m.ERROR);
                        C1786r.m6056a(e, C0776c.class.getSimpleName());
                        httpResponseExecute = null;
                    } catch (ClientProtocolException e2) {
                        c0101b.m661a(e2.getClass().toString());
                        c0101b.m659a(EnumC0803m.ERROR);
                        C1786r.m6056a(e2, C0776c.class.getSimpleName());
                        httpResponseExecute = null;
                    }
                } catch (ConnectTimeoutException e3) {
                    c0101b.m661a(e3.getClass().toString());
                    c0101b.m659a(EnumC0803m.ERROR);
                    C1786r.m6056a(e3, C0776c.class.getSimpleName());
                    httpResponseExecute = null;
                } catch (Exception e4) {
                    c0101b.m661a(e4.getClass().toString());
                    c0101b.m659a(EnumC0803m.ERROR);
                    C1786r.m6056a(e4, C0776c.class.getSimpleName());
                    httpResponseExecute = null;
                }
            } catch (IOException e5) {
                c0101b.m661a(e5.getClass().toString());
                c0101b.m659a(EnumC0803m.ERROR);
                C1786r.m6056a(e5, C0776c.class.getSimpleName());
                httpResponseExecute = null;
            }
            if (httpResponseExecute == null) {
                if (httpClientM3323b instanceof AndroidHttpClient) {
                    ((AndroidHttpClient) httpClientM3323b).close();
                }
                return null;
            }
            int statusCode = httpResponseExecute.getStatusLine().getStatusCode();
            if (httpResponseExecute.getEntity() != null && httpResponseExecute.getEntity().getContentType() != null) {
                c0101b.m668b(httpResponseExecute.getEntity().getContentType().getValue());
            }
            c0101b.m666b(statusCode);
            c0101b.m663a(true);
            c0101b.m661a((String) null);
            C1786r.m6061b("excute end, statusCode : " + statusCode + " from " + httpUriRequest.getURI(), C0776c.class.getSimpleName());
            if (statusCode == 200) {
                c0101b.m659a(EnumC0803m.SUCCESS);
            } else if (statusCode != 0) {
                if (statusCode == 204) {
                    c0101b.m659a(EnumC0803m.NO_CONTENT);
                    if (httpClientM3323b instanceof AndroidHttpClient) {
                        ((AndroidHttpClient) httpClientM3323b).close();
                    }
                    return null;
                }
                c0101b.m659a(EnumC0803m.ERROR);
                c0101b.m662a(httpResponseExecute);
                C1786r.m6054a("HttpStatus is " + statusCode + ", Description : " + httpResponseExecute.getStatusLine().getReasonPhrase(), C0776c.class.getSimpleName());
            }
            try {
                InputStream ungzippedContent = AndroidHttpClient.getUngzippedContent(httpResponseExecute.getEntity());
                if (httpClientM3323b instanceof AndroidHttpClient) {
                    ((AndroidHttpClient) httpClientM3323b).close();
                }
                return ungzippedContent;
            } catch (IOException e6) {
                C1786r.m6056a(e6, C0776c.class.getSimpleName());
                if (httpClientM3323b instanceof AndroidHttpClient) {
                    ((AndroidHttpClient) httpClientM3323b).close();
                }
                return null;
            }
        } catch (Throwable th) {
            if (httpClientM3323b instanceof AndroidHttpClient) {
                ((AndroidHttpClient) httpClientM3323b).close();
            }
            throw th;
        }
    }

    /* renamed from: a */
    public static String m3309a(InputStream inputStream) {
        if (inputStream != null) {
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (true) {
                try {
                    try {
                        String line = bufferedReader.readLine();
                        if (line != null) {
                            sb.append(line).append("\n");
                        } else {
                            try {
                                break;
                            } catch (IOException e) {
                                e = e;
                                e.printStackTrace();
                                return sb.toString();
                            }
                        }
                    } catch (IOException e2) {
                        C1786r.m6056a(e2, C0776c.class.getSimpleName());
                        try {
                            bufferedReader.close();
                        } catch (IOException e3) {
                            e = e3;
                            e.printStackTrace();
                            return sb.toString();
                        }
                    }
                } catch (Throwable th) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                    throw th;
                }
            }
            bufferedReader.close();
            return sb.toString();
        }
        return "";
    }

    /* renamed from: a */
    protected static Object m3307a(InputStream inputStream, C0798h c0798h) {
        try {
            return new C1793y().m6111a(inputStream, c0798h.m3398f());
        } catch (IOException e) {
            C1786r.m6056a(e, C0776c.class.getSimpleName());
            return null;
        } catch (IllegalAccessException e2) {
            C1786r.m6056a(e2, C0776c.class.getSimpleName());
            return null;
        } catch (InstantiationException e3) {
            C1786r.m6056a(e3, C0776c.class.getSimpleName());
            return null;
        } catch (XmlPullParserException e4) {
            C1786r.m6056a(e4, C0776c.class.getSimpleName());
            return null;
        }
    }

    /* renamed from: a */
    protected static void m3315a(InputStream inputStream, C0101b c0101b) {
        String strM3309a = m3309a(inputStream);
        C1786r.m6066e("errorMessage : " + strM3309a, C0776c.class.getSimpleName());
        c0101b.m658a(C0774a.m3302a(C0775b.m3303a(strM3309a)));
    }

    /* renamed from: a */
    protected static boolean m3317a() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) GlobalApplication.m3260b().getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    /* renamed from: b */
    public static DefaultHttpClient m3323b() {
        return m3314a(30000, 30000);
    }

    /* renamed from: a */
    public static DefaultHttpClient m3314a(int i, int i2) {
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(basicHttpParams, "utf-8");
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, i);
        HttpConnectionParams.setSoTimeout(basicHttpParams, i2);
        basicHttpParams.setBooleanParameter("http.protocol.expect-continue", false);
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        return new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
    }

    /* renamed from: a */
    public static HttpUriRequest m3312a(C0798h c0798h, String str, EnumC1764bt enumC1764bt) {
        try {
            URL url = new URL(c0798h.m3394b());
            String str2 = url.getProtocol() + "://" + url.getHost();
            String file = url.getFile();
            if (m3318a(str2)) {
                try {
                    str2 = "http://" + InetAddress.getByName(str2).getHostName();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                    return null;
                }
            }
            String str3 = str2 + file;
            switch (C0784d.f2886a[c0798h.m3395c().ordinal()]) {
            }
            return null;
        } catch (MalformedURLException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* renamed from: b */
    public static HttpUriRequest m3321b(C0798h c0798h, String str, EnumC1764bt enumC1764bt) {
        if (c0798h.m3393a() == EnumC1765bu.BYPASS) {
            return m3312a(c0798h, str, enumC1764bt);
        }
        String strM3308a = m3308a(enumC1764bt, c0798h.m3393a());
        if (m3318a(strM3308a)) {
            try {
                String hostName = InetAddress.getByName(strM3308a).getHostName();
                if (m3319b(enumC1764bt, c0798h.m3393a()) == 443) {
                    strM3308a = "https://" + hostName;
                } else {
                    strM3308a = "http://" + hostName;
                }
            } catch (UnknownHostException e) {
                C1786r.m6056a(e, C0776c.class.getSimpleName());
                return null;
            }
        }
        String str2 = strM3308a + c0798h.m3394b();
        switch (C0784d.f2886a[c0798h.m3395c().ordinal()]) {
            case 1:
                return m3311a(c0798h, str2);
            case 2:
                return m3313a(c0798h, str2, str);
            case 3:
                return m3322b(c0798h, str2, str);
            case 4:
                return m3320b(c0798h, str2);
            default:
                return null;
        }
    }

    /* renamed from: a */
    private static HttpUriRequest m3311a(C0798h c0798h, String str) {
        return new HttpGet(m3310a(str, c0798h.m3396d()));
    }

    /* renamed from: a */
    protected static String m3310a(String str, List list) {
        int i = 0;
        boolean z = str.contains("?");
        if (list != null && list.size() > 0) {
            StringBuffer stringBuffer = new StringBuffer(str);
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    BasicNameValuePair basicNameValuePair = (BasicNameValuePair) list.get(i2);
                    if (z) {
                        stringBuffer.append("&");
                    } else {
                        stringBuffer.append("?");
                        z = true;
                    }
                    stringBuffer.append(basicNameValuePair.getName() + "=" + basicNameValuePair.getValue());
                    i = i2 + 1;
                } else {
                    stringBuffer.append("&r=" + System.currentTimeMillis());
                    return stringBuffer.toString();
                }
            }
        } else {
            return str;
        }
    }

    /* renamed from: a */
    protected static void m3316a(HttpUriRequest httpUriRequest, List list) {
        if (list != null && list.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    BasicNameValuePair basicNameValuePair = (BasicNameValuePair) list.get(i2);
                    httpUriRequest.addHeader(basicNameValuePair.getName(), basicNameValuePair.getValue());
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    private static HttpUriRequest m3313a(C0798h c0798h, String str, String str2) {
        HttpPost httpPost = new HttpPost(m3310a(str, c0798h.m3396d()));
        if (str2 != null) {
            if (str2.length() > AndroidHttpClient.getMinGzipSize(GlobalApplication.m3260b().getContentResolver())) {
                try {
                    httpPost.setEntity(AndroidHttpClient.getCompressedEntity(str2.getBytes(), GlobalApplication.m3260b().getContentResolver()));
                    httpPost.addHeader("Content-Encoding", "gzip");
                } catch (IOException e) {
                    C1786r.m6056a(e, C0776c.class.getSimpleName());
                    return null;
                }
            } else {
                try {
                    StringEntity stringEntity = new StringEntity(str2, "UTF-8");
                    stringEntity.setContentEncoding("UTF-8");
                    httpPost.setEntity(stringEntity);
                } catch (UnsupportedEncodingException e2) {
                    C1786r.m6056a(e2, C0776c.class.getSimpleName());
                    return null;
                }
            }
        }
        return httpPost;
    }

    /* renamed from: b */
    private static HttpUriRequest m3322b(C0798h c0798h, String str, String str2) {
        HttpPut httpPut = new HttpPut(m3310a(str, c0798h.m3396d()));
        if (str2 != null) {
            try {
                StringEntity stringEntity = new StringEntity(str2, "UTF-8");
                stringEntity.setContentEncoding("UTF-8");
                httpPut.setEntity(stringEntity);
                return httpPut;
            } catch (UnsupportedEncodingException e) {
                C1786r.m6056a(e, C0776c.class.getSimpleName());
                return null;
            }
        }
        return httpPut;
    }

    /* renamed from: b */
    private static HttpUriRequest m3320b(C0798h c0798h, String str) {
        return new HttpDelete(m3310a(str, c0798h.m3396d()));
    }

    /* renamed from: a */
    private static boolean m3318a(String str) {
        return f2851b.matcher(str).matches();
    }

    /* renamed from: a */
    public static String m3308a(EnumC1764bt enumC1764bt, EnumC1765bu enumC1765bu) {
        switch (C0784d.f2887b[enumC1765bu.ordinal()]) {
            case 1:
                return C1763bs.m5969a(enumC1764bt);
            case 2:
                return C1763bs.m5973b(enumC1764bt);
            case 3:
                return C1763bs.m5977d(enumC1764bt);
            case 4:
                return C1763bs.m5979e(enumC1764bt);
            case 5:
                return "http://hub.samsungapps.com";
            default:
                return null;
        }
    }

    /* renamed from: b */
    protected static int m3319b(EnumC1764bt enumC1764bt, EnumC1765bu enumC1765bu) {
        switch (C0784d.f2887b[enumC1765bu.ordinal()]) {
            case 1:
                return 443;
            case 2:
                return C1763bs.m5974c(enumC1764bt);
            case 3:
                return C1763bs.m5980f(enumC1764bt);
            default:
                return 80;
        }
    }
}
