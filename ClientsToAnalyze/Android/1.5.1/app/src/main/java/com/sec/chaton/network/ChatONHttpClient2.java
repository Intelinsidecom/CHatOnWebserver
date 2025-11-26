package com.sec.chaton.network;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.http.AndroidHttpClient;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.sec.chaton.common.entry.HttpEntry;
import com.sec.chaton.control.GLDControl;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.network.code.FaultCodeConvertor;
import com.sec.chaton.network.code.FaultCodeExtractor;
import com.sec.chaton.trunk.parser.AbstractXmlParser;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatOnXmlParser;
import com.sec.chaton.util.ServerAddressMgr;
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

/* loaded from: classes.dex */
public class ChatONHttpClient2 {

    /* renamed from: a */
    private static final Pattern f2428a = Pattern.compile("^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");

    /* renamed from: a */
    public static HttpEntry m2704a(HttpEntry httpEntry, String str) {
        return m2705a(httpEntry, str, ServerAddressMgr.ServerType.PRIMARY);
    }

    /* renamed from: a */
    public static HttpEntry m2705a(HttpEntry httpEntry, String str, ServerAddressMgr.ServerType serverType) throws IOException {
        m2723c(httpEntry, str, serverType);
        m2722b(httpEntry, str, serverType);
        return httpEntry;
    }

    /* renamed from: a */
    private static InputStream m2706a(HttpUriRequest httpUriRequest, HttpEnvelope httpEnvelope, HttpEntry httpEntry) {
        HttpResponse httpResponseExecute;
        HttpClient httpClientM2721b = m2721b();
        try {
            ChatONLogWriter.m3506b("excute start to : " + httpUriRequest.getURI(), ChatONHttpClient2.class.getSimpleName());
            try {
                try {
                    httpResponseExecute = httpClientM2721b.execute(httpUriRequest);
                } catch (ClientProtocolException e) {
                    httpEntry.m1948a(e.getClass().toString());
                    httpEntry.m1946a(HttpResultCode.ERROR);
                    ChatONLogWriter.m3501a(e, ChatONHttpClient2.class.getSimpleName());
                    httpResponseExecute = null;
                } catch (IOException e2) {
                    httpEntry.m1948a(e2.getClass().toString());
                    httpEntry.m1946a(HttpResultCode.ERROR);
                    ChatONLogWriter.m3501a(e2, ChatONHttpClient2.class.getSimpleName());
                    httpResponseExecute = null;
                } catch (Exception e3) {
                    httpEntry.m1948a(e3.getClass().toString());
                    httpEntry.m1946a(HttpResultCode.ERROR);
                    ChatONLogWriter.m3501a(e3, ChatONHttpClient2.class.getSimpleName());
                    httpResponseExecute = null;
                }
            } catch (UnknownHostException e4) {
                httpEntry.m1948a(e4.getClass().toString());
                httpEntry.m1946a(HttpResultCode.ERROR);
                ChatONLogWriter.m3501a(e4, ChatONHttpClient2.class.getSimpleName());
                httpResponseExecute = null;
            } catch (ConnectTimeoutException e5) {
                httpEntry.m1948a(e5.getClass().toString());
                httpEntry.m1946a(HttpResultCode.ERROR);
                ChatONLogWriter.m3501a(e5, ChatONHttpClient2.class.getSimpleName());
                httpResponseExecute = null;
            }
            if (httpResponseExecute == null) {
                if (httpClientM2721b instanceof AndroidHttpClient) {
                    ((AndroidHttpClient) httpClientM2721b).close();
                }
                return null;
            }
            int statusCode = httpResponseExecute.getStatusLine().getStatusCode();
            httpEntry.m1952b(statusCode);
            httpEntry.m1949a(true);
            ChatONLogWriter.m3506b("excute end, statusCode : " + statusCode + " from " + httpUriRequest.getURI(), ChatONHttpClient2.class.getSimpleName());
            if (statusCode == 200) {
                httpEntry.m1946a(HttpResultCode.SUCCESS);
            } else if (statusCode != 0) {
                if (statusCode == 204) {
                    httpEntry.m1946a(HttpResultCode.NO_CONTENT);
                    if (httpClientM2721b instanceof AndroidHttpClient) {
                        ((AndroidHttpClient) httpClientM2721b).close();
                    }
                    return null;
                }
                httpEntry.m1946a(HttpResultCode.ERROR);
                ChatONLogWriter.m3499a("HttpStatus is " + statusCode + ", Description : " + httpResponseExecute.getStatusLine().getReasonPhrase(), ChatONHttpClient2.class.getSimpleName());
            }
            try {
                InputStream ungzippedContent = AndroidHttpClient.getUngzippedContent(httpResponseExecute.getEntity());
                if (httpClientM2721b instanceof AndroidHttpClient) {
                    ((AndroidHttpClient) httpClientM2721b).close();
                }
                return ungzippedContent;
            } catch (IOException e6) {
                ChatONLogWriter.m3501a(e6, ChatONHttpClient2.class.getSimpleName());
                if (httpClientM2721b instanceof AndroidHttpClient) {
                    ((AndroidHttpClient) httpClientM2721b).close();
                }
                return null;
            }
        } catch (Throwable th) {
            if (httpClientM2721b instanceof AndroidHttpClient) {
                ((AndroidHttpClient) httpClientM2721b).close();
            }
            throw th;
        }
    }

    /* renamed from: a */
    protected static Object m2707a(InputStream inputStream, HttpEnvelope httpEnvelope) {
        try {
            return new ChatOnXmlParser().m3551a(inputStream, httpEnvelope.m2733f());
        } catch (IOException e) {
            ChatONLogWriter.m3501a(e, ChatONHttpClient2.class.getSimpleName());
            return null;
        } catch (IllegalAccessException e2) {
            ChatONLogWriter.m3501a(e2, ChatONHttpClient2.class.getSimpleName());
            return null;
        } catch (InstantiationException e3) {
            ChatONLogWriter.m3501a(e3, ChatONHttpClient2.class.getSimpleName());
            return null;
        } catch (XmlPullParserException e4) {
            ChatONLogWriter.m3501a(e4, ChatONHttpClient2.class.getSimpleName());
            return null;
        }
    }

    /* renamed from: a */
    public static String m2708a(ServerAddressMgr.ServerType serverType, ServerAddressMgr.ServerWhat serverWhat) {
        switch (C0342d.f2537b[serverWhat.ordinal()]) {
            case 1:
                return ServerAddressMgr.m3628a(serverType);
            case 2:
                return ServerAddressMgr.m3630b(serverType);
            case 3:
                return ServerAddressMgr.m3635d(serverType);
            case 4:
                return ServerAddressMgr.m3637e(serverType);
            default:
                return null;
        }
    }

    /* renamed from: a */
    public static String m2709a(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        while (true) {
            try {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                sb.append(line).append("\n");
            } catch (IOException e) {
                ChatONLogWriter.m3501a(e, ChatONHttpClient2.class.getSimpleName());
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    protected static String m2710a(String str, List list) {
        if (list == null || list.size() <= 0) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer(str);
        int i = 0;
        while (i < list.size()) {
            BasicNameValuePair basicNameValuePair = (BasicNameValuePair) list.get(i);
            stringBuffer.append(i == 0 ? "?" : "&");
            stringBuffer.append(basicNameValuePair.getName() + "=" + basicNameValuePair.getValue());
            i++;
        }
        stringBuffer.append("&r=" + System.currentTimeMillis());
        return stringBuffer.toString();
    }

    /* renamed from: a */
    private static HttpUriRequest m2711a(HttpEnvelope httpEnvelope, String str) {
        return new HttpGet(m2710a(str, httpEnvelope.m2731d()));
    }

    /* renamed from: a */
    public static HttpUriRequest m2712a(HttpEnvelope httpEnvelope, String str, ServerAddressMgr.ServerType serverType) {
        String strM2708a = m2708a(serverType, httpEnvelope.m2728a());
        if (m2717a(strM2708a)) {
            try {
                String hostName = InetAddress.getByName(strM2708a).getHostName();
                strM2708a = m2718b(serverType, httpEnvelope.m2728a()) == 443 ? "https://" + hostName : "http://" + hostName;
            } catch (UnknownHostException e) {
                ChatONLogWriter.m3501a(e, ChatONHttpClient2.class.getSimpleName());
                return null;
            }
        }
        String str2 = strM2708a + httpEnvelope.m2729b();
        switch (C0342d.f2536a[httpEnvelope.m2730c().ordinal()]) {
        }
        return null;
    }

    /* renamed from: a */
    private static HttpUriRequest m2713a(HttpEnvelope httpEnvelope, String str, String str2) {
        HttpPost httpPost = new HttpPost(m2710a(str, httpEnvelope.m2731d()));
        if (str2 == null) {
            return httpPost;
        }
        if (str2.length() > AndroidHttpClient.getMinGzipSize(GlobalApplication.m2387e().getContentResolver())) {
            try {
                httpPost.setEntity(AndroidHttpClient.getCompressedEntity(str2.getBytes(), GlobalApplication.m2387e().getContentResolver()));
                AndroidHttpClient.modifyRequestToAcceptGzipResponse(httpPost);
                httpPost.addHeader("Content-Encoding", "gzip");
                return httpPost;
            } catch (IOException e) {
                ChatONLogWriter.m3501a(e, ChatONHttpClient2.class.getSimpleName());
                return null;
            }
        }
        try {
            StringEntity stringEntity = new StringEntity(str2, "UTF-8");
            stringEntity.setContentEncoding("UTF-8");
            httpPost.setEntity(stringEntity);
            return httpPost;
        } catch (UnsupportedEncodingException e2) {
            ChatONLogWriter.m3501a(e2, ChatONHttpClient2.class.getSimpleName());
            return null;
        }
    }

    /* renamed from: a */
    protected static void m2714a(InputStream inputStream, HttpEntry httpEntry) throws IOException {
        String strM2709a = m2709a(inputStream);
        ChatONLogWriter.m3511e("errorMessage : " + strM2709a, ChatONHttpClient2.class.getSimpleName());
        httpEntry.m1945a(FaultCodeConvertor.m2824a(FaultCodeExtractor.m2825a(strM2709a)));
    }

    /* renamed from: a */
    protected static void m2715a(HttpUriRequest httpUriRequest, List list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return;
            }
            BasicNameValuePair basicNameValuePair = (BasicNameValuePair) list.get(i2);
            httpUriRequest.addHeader(basicNameValuePair.getName(), basicNameValuePair.getValue());
            i = i2 + 1;
        }
    }

    /* renamed from: a */
    protected static boolean m2716a() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) GlobalApplication.m2387e().getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    /* renamed from: a */
    private static boolean m2717a(String str) {
        return f2428a.matcher(str).matches();
    }

    /* renamed from: b */
    protected static int m2718b(ServerAddressMgr.ServerType serverType, ServerAddressMgr.ServerWhat serverWhat) {
        switch (C0342d.f2537b[serverWhat.ordinal()]) {
            case 1:
                return 443;
            case 2:
                return ServerAddressMgr.m3632c(serverType);
            case 3:
                return ServerAddressMgr.m3638f(serverType);
            default:
                return 80;
        }
    }

    /* renamed from: b */
    private static HttpUriRequest m2719b(HttpEnvelope httpEnvelope, String str) {
        return new HttpDelete(m2710a(str, httpEnvelope.m2731d()));
    }

    /* renamed from: b */
    private static HttpUriRequest m2720b(HttpEnvelope httpEnvelope, String str, String str2) {
        HttpPut httpPut = new HttpPut(m2710a(str, httpEnvelope.m2731d()));
        if (str2 == null) {
            return httpPut;
        }
        try {
            StringEntity stringEntity = new StringEntity(str2, "UTF-8");
            stringEntity.setContentEncoding("UTF-8");
            httpPut.setEntity(stringEntity);
            return httpPut;
        } catch (UnsupportedEncodingException e) {
            ChatONLogWriter.m3501a(e, ChatONHttpClient2.class.getSimpleName());
            return null;
        }
    }

    /* renamed from: b */
    public static DefaultHttpClient m2721b() {
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(basicHttpParams, "utf-8");
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, 30000);
        HttpConnectionParams.setSoTimeout(basicHttpParams, 30000);
        basicHttpParams.setBooleanParameter("http.protocol.expect-continue", false);
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        return new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
    }

    /* renamed from: b */
    private static void m2722b(HttpEntry httpEntry, String str, ServerAddressMgr.ServerType serverType) throws IOException {
        if ((httpEntry.m1954c().m2734g() == 101 || httpEntry.m1954c().m2734g() == 102 || httpEntry.m1954c().m2734g() == 103) && serverType == ServerAddressMgr.ServerType.PRIMARY && httpEntry.m1959h() == 500) {
            m2723c(httpEntry, str, ServerAddressMgr.ServerType.SECONDARY);
            return;
        }
        if (TextUtils.isEmpty(httpEntry.m1958g())) {
            return;
        }
        if (serverType == ServerAddressMgr.ServerType.PRIMARY) {
            if (httpEntry.m1958g().equals(ConnectTimeoutException.class.toString())) {
                m2723c(httpEntry, str, ServerAddressMgr.ServerType.PRIMARY);
            }
            if (httpEntry.m1958g().equals(ConnectTimeoutException.class.toString())) {
                m2705a(httpEntry, str, ServerAddressMgr.ServerType.SECONDARY);
                return;
            }
            return;
        }
        if (httpEntry.m1958g().equals(ConnectTimeoutException.class.toString())) {
            m2723c(httpEntry, str, ServerAddressMgr.ServerType.SECONDARY);
        }
        if (!httpEntry.m1958g().equals(ConnectTimeoutException.class.toString()) || httpEntry.m1954c().m2734g() == 101 || httpEntry.m1954c().m2734g() == 102 || httpEntry.m1954c().m2734g() == 103) {
            return;
        }
        new GLDControl(new Handler(Looper.getMainLooper())).m2000a();
    }

    /* renamed from: c */
    private static HttpEntry m2723c(HttpEntry httpEntry, String str, ServerAddressMgr.ServerType serverType) throws IOException {
        AbstractXmlParser abstractXmlParser;
        Object objM2707a;
        HttpUriRequest httpUriRequestM2712a = m2712a(httpEntry.m1954c(), str, serverType);
        if (httpUriRequestM2712a != null) {
            m2715a(httpUriRequestM2712a, httpEntry.m1954c().m2732e());
            if (m2716a()) {
                InputStream inputStreamM2706a = m2706a(httpUriRequestM2712a, httpEntry.m1954c(), httpEntry);
                if (inputStreamM2706a != null) {
                    try {
                        if (httpEntry.m1951b() == HttpResultCode.SUCCESS || httpEntry.m1951b() == HttpResultCode.NO_CONTENT) {
                            try {
                            } catch (IllegalAccessException e) {
                                ChatONLogWriter.m3501a(e, ChatONHttpClient2.class.getSimpleName());
                            } catch (InstantiationException e2) {
                                ChatONLogWriter.m3501a(e2, ChatONHttpClient2.class.getSimpleName());
                                abstractXmlParser = null;
                            }
                            abstractXmlParser = httpEntry.m1954c().m2736i() != null ? (AbstractXmlParser) httpEntry.m1954c().m2736i().newInstance() : null;
                            if (abstractXmlParser == null) {
                                objM2707a = m2707a(inputStreamM2706a, httpEntry.m1954c());
                                if (httpEntry.m1954c().m2733f() != null && objM2707a == null) {
                                    ChatONLogWriter.m3499a("Result is null because of parsing Error.", ChatONHttpClient2.class.getSimpleName());
                                    httpEntry.m1946a(HttpResultCode.ERROR);
                                }
                            } else {
                                try {
                                    objM2707a = abstractXmlParser.parse(inputStreamM2706a);
                                } catch (Exception e3) {
                                    ChatONLogWriter.m3501a(e3, ChatONHttpClient2.class.getSimpleName());
                                    httpEntry.m1946a(HttpResultCode.ERROR);
                                    objM2707a = null;
                                }
                            }
                            httpEntry.m1947a(objM2707a);
                        } else {
                            m2714a(inputStreamM2706a, httpEntry);
                        }
                    } finally {
                        if (inputStreamM2706a != null) {
                            try {
                                inputStreamM2706a.close();
                            } catch (IOException e4) {
                                ChatONLogWriter.m3501a(e4, ChatONHttpClient2.class.getSimpleName());
                            }
                        }
                    }
                }
            } else {
                ChatONLogWriter.m3506b("execute fail : " + httpUriRequestM2712a.getURI(), ChatONHttpClient2.class.getSimpleName());
                httpEntry.m1946a(HttpResultCode.ERROR);
            }
        } else {
            httpEntry.m1946a(HttpResultCode.ERROR);
        }
        return httpEntry;
    }
}
