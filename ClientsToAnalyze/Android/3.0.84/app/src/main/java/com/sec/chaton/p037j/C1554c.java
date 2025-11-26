package com.sec.chaton.p037j;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.sec.chaton.chat.p024b.C0952c;
import com.sec.chaton.util.C3216cd;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.util.EnumC3218cf;
import com.sec.chaton.util.EnumC3219cg;
import com.sec.common.CommonApplication;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;

/* compiled from: ChatONHttpClient2.java */
/* renamed from: com.sec.chaton.j.c */
/* loaded from: classes.dex */
public class C1554c {
    /* renamed from: a */
    public static String m6591a(InputStream inputStream) {
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
                        C3250y.m11443a(e2, C1554c.class.getSimpleName());
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
    protected static boolean m6594a() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) CommonApplication.m11493l().getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    /* renamed from: b */
    public static DefaultHttpClient m6595b() {
        return m6593a(30000, 30000);
    }

    /* renamed from: a */
    public static DefaultHttpClient m6593a(int i, int i2) {
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(basicHttpParams, "utf-8");
        HttpProtocolParams.setHttpElementCharset(basicHttpParams, "UTF-8");
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, i);
        HttpConnectionParams.setSoTimeout(basicHttpParams, i2);
        basicHttpParams.setBooleanParameter("http.protocol.expect-continue", false);
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        return new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
    }

    /* renamed from: a */
    protected static String m6592a(String str, List<NameValuePair> list) {
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
    public static String m6590a(EnumC3218cf enumC3218cf, EnumC3219cg enumC3219cg) {
        switch (C1566d.f5820a[enumC3219cg.ordinal()]) {
            case 1:
                return C3216cd.m11277a(enumC3218cf);
            case 2:
                return C3216cd.m11282b(enumC3218cf);
            case 3:
                return C3216cd.m11287d(enumC3218cf);
            case 4:
                return C3216cd.m11289e(enumC3218cf);
            case 5:
                return C3216cd.m11291f(enumC3218cf);
            case 6:
                return C3216cd.m11293g(enumC3218cf);
            case 7:
                return "http://hub.samsungapps.com";
            case 8:
                if ("account.samsung.com".equals("account.samsung.com")) {
                    return "https://auth.samsungosp.com";
                }
                return "https://stg-auth.samsungosp.com";
            case 9:
                if ("account.samsung.com".equals("account.samsung.com")) {
                    return "https://api.samsungosp.com";
                }
                return "https://stg-api.samsungosp.com";
            case 10:
                return C3216cd.m11295h(enumC3218cf);
            case 11:
                return "https://global-auth.translation.samsungosp.com";
            case 12:
                return C0952c.m5143c().m5146a();
            default:
                return "";
        }
    }
}
