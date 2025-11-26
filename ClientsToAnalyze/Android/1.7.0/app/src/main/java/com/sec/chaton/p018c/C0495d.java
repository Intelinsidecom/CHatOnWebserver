package com.sec.chaton.p018c;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.http.AndroidHttpClient;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p013a.C0225x;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.chaton.p018c.p022d.C0496a;
import com.sec.chaton.p018c.p022d.C0497b;
import com.sec.chaton.util.C1296as;
import com.sec.chaton.util.C1341p;
import com.sec.chaton.util.C1349x;
import com.sec.chaton.util.EnumC1289al;
import com.sec.chaton.util.EnumC1333h;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
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
/* renamed from: com.sec.chaton.c.d */
/* loaded from: classes.dex */
public class C0495d {

    /* renamed from: a */
    public static String f1584a = "application/json";

    /* renamed from: b */
    private static final Pattern f1585b = Pattern.compile("^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");

    /* renamed from: a */
    public static C0259g m2498a(C0259g c0259g, String str) {
        return m2499a(c0259g, str, EnumC1289al.PRIMARY);
    }

    /* renamed from: a */
    public static C0259g m2499a(C0259g c0259g, String str, EnumC1289al enumC1289al) throws IOException {
        m2518c(c0259g, str, enumC1289al);
        if (c0259g.m931c().m2538k() == -1) {
            m2517b(c0259g, str, enumC1289al);
        }
        return c0259g;
    }

    /* renamed from: b */
    private static void m2517b(C0259g c0259g, String str, EnumC1289al enumC1289al) throws IOException {
        if ((c0259g.m931c().m2534g() == 101 || c0259g.m931c().m2534g() == 102 || c0259g.m931c().m2534g() == 103) && enumC1289al == EnumC1289al.PRIMARY && c0259g.m936h() == 500) {
            m2518c(c0259g, str, EnumC1289al.SECONDARY);
            return;
        }
        if (!TextUtils.isEmpty(c0259g.m935g())) {
            if (enumC1289al == EnumC1289al.PRIMARY) {
                if (ConnectTimeoutException.class.toString().equals(c0259g.m935g())) {
                    m2518c(c0259g, str, EnumC1289al.PRIMARY);
                }
                if (ConnectTimeoutException.class.toString().equals(c0259g.m935g())) {
                    m2499a(c0259g, str, EnumC1289al.SECONDARY);
                    return;
                }
                return;
            }
            if (ConnectTimeoutException.class.toString().equals(c0259g.m935g())) {
                m2518c(c0259g, str, EnumC1289al.SECONDARY);
            }
            if (ConnectTimeoutException.class.toString().equals(c0259g.m935g()) && c0259g.m931c().m2534g() != 101 && c0259g.m931c().m2534g() != 102 && c0259g.m931c().m2534g() != 103) {
                new C0225x(new Handler(Looper.getMainLooper())).m869a();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x006f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.sec.chaton.p015b.p016a.C0259g m2518c(com.sec.chaton.p015b.p016a.C0259g r4, java.lang.String r5, com.sec.chaton.util.EnumC1289al r6) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 310
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p018c.C0495d.m2518c(com.sec.chaton.b.a.g, java.lang.String, com.sec.chaton.util.al):com.sec.chaton.b.a.g");
    }

    /* renamed from: a */
    private static InputStream m2500a(HttpUriRequest httpUriRequest, C0503j c0503j, C0259g c0259g) {
        HttpResponse httpResponseExecute;
        HttpClient httpClientM2516b = c0503j.m2538k() == -1 ? m2516b() : m2508a(c0503j.m2538k(), c0503j.m2538k());
        try {
            C1341p.m4658b("excute start to : " + httpUriRequest.getURI(), C0495d.class.getSimpleName());
            try {
                try {
                    try {
                        httpResponseExecute = httpClientM2516b.execute(httpUriRequest);
                    } catch (UnknownHostException e) {
                        c0259g.m925a(e.getClass().toString());
                        c0259g.m923a(EnumC0518y.ERROR);
                        C1341p.m4653a(e, C0495d.class.getSimpleName());
                        httpResponseExecute = null;
                    } catch (ClientProtocolException e2) {
                        c0259g.m925a(e2.getClass().toString());
                        c0259g.m923a(EnumC0518y.ERROR);
                        C1341p.m4653a(e2, C0495d.class.getSimpleName());
                        httpResponseExecute = null;
                    }
                } catch (ConnectTimeoutException e3) {
                    c0259g.m925a(e3.getClass().toString());
                    c0259g.m923a(EnumC0518y.ERROR);
                    C1341p.m4653a(e3, C0495d.class.getSimpleName());
                    httpResponseExecute = null;
                } catch (Exception e4) {
                    c0259g.m925a(e4.getClass().toString());
                    c0259g.m923a(EnumC0518y.ERROR);
                    C1341p.m4653a(e4, C0495d.class.getSimpleName());
                    httpResponseExecute = null;
                }
            } catch (IOException e5) {
                c0259g.m925a(e5.getClass().toString());
                c0259g.m923a(EnumC0518y.ERROR);
                C1341p.m4653a(e5, C0495d.class.getSimpleName());
                httpResponseExecute = null;
            }
            if (httpResponseExecute == null) {
                if (httpClientM2516b instanceof AndroidHttpClient) {
                    ((AndroidHttpClient) httpClientM2516b).close();
                }
                return null;
            }
            int statusCode = httpResponseExecute.getStatusLine().getStatusCode();
            c0259g.m929b(statusCode);
            c0259g.m926a(true);
            c0259g.m925a((String) null);
            C1341p.m4658b("excute end, statusCode : " + statusCode + " from " + httpUriRequest.getURI(), C0495d.class.getSimpleName());
            if (statusCode == 200) {
                c0259g.m923a(EnumC0518y.SUCCESS);
            } else if (statusCode != 0) {
                if (statusCode == 204) {
                    c0259g.m923a(EnumC0518y.NO_CONTENT);
                    if (httpClientM2516b instanceof AndroidHttpClient) {
                        ((AndroidHttpClient) httpClientM2516b).close();
                    }
                    return null;
                }
                c0259g.m923a(EnumC0518y.ERROR);
                C1341p.m4651a("HttpStatus is " + statusCode + ", Description : " + httpResponseExecute.getStatusLine().getReasonPhrase(), C0495d.class.getSimpleName());
            }
            try {
                InputStream ungzippedContent = AndroidHttpClient.getUngzippedContent(httpResponseExecute.getEntity());
                if (httpClientM2516b instanceof AndroidHttpClient) {
                    ((AndroidHttpClient) httpClientM2516b).close();
                }
                return ungzippedContent;
            } catch (IOException e6) {
                C1341p.m4653a(e6, C0495d.class.getSimpleName());
                if (httpClientM2516b instanceof AndroidHttpClient) {
                    ((AndroidHttpClient) httpClientM2516b).close();
                }
                return null;
            }
        } catch (Throwable th) {
            if (httpClientM2516b instanceof AndroidHttpClient) {
                ((AndroidHttpClient) httpClientM2516b).close();
            }
            throw th;
        }
    }

    /* renamed from: a */
    public static String m2503a(InputStream inputStream) {
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
                        C1341p.m4653a(e2, C0495d.class.getSimpleName());
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
    protected static Object m2501a(InputStream inputStream, C0503j c0503j) {
        try {
            return new C1349x().m4713a(inputStream, c0503j.m2533f());
        } catch (IOException e) {
            C1341p.m4653a(e, C0495d.class.getSimpleName());
            return null;
        } catch (IllegalAccessException e2) {
            C1341p.m4653a(e2, C0495d.class.getSimpleName());
            return null;
        } catch (InstantiationException e3) {
            C1341p.m4653a(e3, C0495d.class.getSimpleName());
            return null;
        } catch (XmlPullParserException e4) {
            C1341p.m4653a(e4, C0495d.class.getSimpleName());
            return null;
        }
    }

    /* renamed from: a */
    protected static void m2509a(InputStream inputStream, C0259g c0259g) {
        String strM2503a = m2503a(inputStream);
        C1341p.m4662e("errorMessage : " + strM2503a, C0495d.class.getSimpleName());
        c0259g.m922a(C0496a.m2519a(C0497b.m2520a(strM2503a)));
    }

    /* renamed from: a */
    protected static boolean m2511a() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) GlobalApplication.m3100a().getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    /* renamed from: b */
    public static DefaultHttpClient m2516b() {
        return m2508a(30000, 30000);
    }

    /* renamed from: a */
    public static DefaultHttpClient m2508a(int i, int i2) {
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
    public static HttpUriRequest m2506a(C0503j c0503j, String str, EnumC1289al enumC1289al) {
        String strM2502a = m2502a(enumC1289al, c0503j.m2528a());
        if (m2512a(strM2502a)) {
            try {
                String hostName = InetAddress.getByName(strM2502a).getHostName();
                if (m2513b(enumC1289al, c0503j.m2528a()) == 443) {
                    strM2502a = "https://" + hostName;
                } else {
                    strM2502a = "http://" + hostName;
                }
            } catch (UnknownHostException e) {
                C1341p.m4653a(e, C0495d.class.getSimpleName());
                return null;
            }
        }
        String str2 = strM2502a + c0503j.m2529b();
        switch (C0508o.f1650a[c0503j.m2530c().ordinal()]) {
        }
        return null;
    }

    /* renamed from: a */
    private static HttpUriRequest m2505a(C0503j c0503j, String str) {
        return new HttpGet(m2504a(str, c0503j.m2531d()));
    }

    /* renamed from: a */
    protected static String m2504a(String str, List list) {
        if (list != null && list.size() > 0) {
            StringBuffer stringBuffer = new StringBuffer(str);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    BasicNameValuePair basicNameValuePair = (BasicNameValuePair) list.get(i2);
                    stringBuffer.append(i2 == 0 ? "?" : "&");
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
    protected static void m2510a(HttpUriRequest httpUriRequest, List list) {
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
    private static HttpUriRequest m2507a(C0503j c0503j, String str, String str2) {
        HttpPost httpPost = new HttpPost(m2504a(str, c0503j.m2531d()));
        if (str2 != null) {
            if (str2.length() > AndroidHttpClient.getMinGzipSize(GlobalApplication.m3100a().getContentResolver())) {
                try {
                    httpPost.setEntity(AndroidHttpClient.getCompressedEntity(str2.getBytes(), GlobalApplication.m3100a().getContentResolver()));
                    httpPost.addHeader("Content-Encoding", "gzip");
                } catch (IOException e) {
                    C1341p.m4653a(e, C0495d.class.getSimpleName());
                    return null;
                }
            } else {
                try {
                    StringEntity stringEntity = new StringEntity(str2, "UTF-8");
                    stringEntity.setContentEncoding("UTF-8");
                    httpPost.setEntity(stringEntity);
                } catch (UnsupportedEncodingException e2) {
                    C1341p.m4653a(e2, C0495d.class.getSimpleName());
                    return null;
                }
            }
        }
        return httpPost;
    }

    /* renamed from: b */
    private static HttpUriRequest m2515b(C0503j c0503j, String str, String str2) {
        HttpPut httpPut = new HttpPut(m2504a(str, c0503j.m2531d()));
        if (str2 != null) {
            try {
                StringEntity stringEntity = new StringEntity(str2, "UTF-8");
                stringEntity.setContentEncoding("UTF-8");
                httpPut.setEntity(stringEntity);
                return httpPut;
            } catch (UnsupportedEncodingException e) {
                C1341p.m4653a(e, C0495d.class.getSimpleName());
                return null;
            }
        }
        return httpPut;
    }

    /* renamed from: b */
    private static HttpUriRequest m2514b(C0503j c0503j, String str) {
        return new HttpDelete(m2504a(str, c0503j.m2531d()));
    }

    /* renamed from: a */
    private static boolean m2512a(String str) {
        return f1585b.matcher(str).matches();
    }

    /* renamed from: a */
    public static String m2502a(EnumC1289al enumC1289al, EnumC1333h enumC1333h) {
        switch (C0508o.f1651b[enumC1333h.ordinal()]) {
            case 1:
                return C1296as.m4517a(enumC1289al);
            case 2:
                return C1296as.m4521b(enumC1289al);
            case 3:
                return C1296as.m4525d(enumC1289al);
            case 4:
                return C1296as.m4527e(enumC1289al);
            default:
                return null;
        }
    }

    /* renamed from: b */
    protected static int m2513b(EnumC1289al enumC1289al, EnumC1333h enumC1333h) {
        switch (C0508o.f1651b[enumC1333h.ordinal()]) {
            case 1:
                return 443;
            case 2:
                return C1296as.m4522c(enumC1289al);
            case 3:
                return C1296as.m4528f(enumC1289al);
            default:
                return 80;
        }
    }
}
