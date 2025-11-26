package com.sec.chaton.p067j;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.p137vk.sdk.api.VKApiConst;
import com.sec.chaton.chat.translate.C1850c;
import com.sec.chaton.util.C4865cc;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.EnumC4867ce;
import com.sec.chaton.util.EnumC4868cf;
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
public class C2433c {
    /* renamed from: a */
    public static String m10535a(InputStream inputStream) throws IOException {
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
                        C4904y.m18635a(e2, C2433c.class.getSimpleName());
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
    protected static boolean m10538a() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) CommonApplication.m18732r().getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    /* renamed from: b */
    public static DefaultHttpClient m10539b() {
        return m10537a(30000, 30000);
    }

    /* renamed from: a */
    public static DefaultHttpClient m10537a(int i, int i2) {
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(basicHttpParams, "utf-8");
        HttpProtocolParams.setHttpElementCharset(basicHttpParams, "UTF-8");
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, i);
        HttpConnectionParams.setSoTimeout(basicHttpParams, i2);
        basicHttpParams.setBooleanParameter("http.protocol.expect-continue", false);
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme(VKApiConst.HTTPS, SSLSocketFactory.getSocketFactory(), 443));
        return new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
    }

    /* renamed from: a */
    protected static String m10536a(String str, List<NameValuePair> list) {
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
    public static String m10534a(EnumC4867ce enumC4867ce, EnumC4868cf enumC4868cf) {
        switch (C2443d.f8764a[enumC4868cf.ordinal()]) {
            case 1:
                return C4865cc.m18444a(enumC4867ce);
            case 2:
                return C4865cc.m18449b(enumC4867ce);
            case 3:
                return C4865cc.m18454d(enumC4867ce);
            case 4:
                return C4865cc.m18456e(enumC4867ce);
            case 5:
                return C4865cc.m18458f(enumC4867ce);
            case 6:
                return C4865cc.m18468k(enumC4867ce);
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
                return C4865cc.m18470l(enumC4867ce);
            case 11:
                return C4865cc.m18460g(enumC4867ce);
            case 12:
                return C4865cc.m18466j(enumC4867ce);
            case 13:
                return C1850c.m9024d().m9026a();
            case 14:
                return C4865cc.m18462h(enumC4867ce);
            default:
                return "";
        }
    }
}
