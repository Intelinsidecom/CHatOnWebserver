package com.sec.chaton.plugin.p083b;

import com.sec.chaton.plugin.p086e.InterfaceC2942a;
import com.sec.chaton.plugin.p087f.C2946a;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.List;
import org.apache.http.NameValuePair;

/* compiled from: HttpClient.java */
/* renamed from: com.sec.chaton.plugin.b.b */
/* loaded from: classes.dex */
public class C2925b {

    /* renamed from: a */
    private static final String f10798a = C2925b.class.getSimpleName();

    /* renamed from: a */
    private static HttpURLConnection m12158a(HttpURLConnection httpURLConnection, String str, int i, int i2, String str2, List<NameValuePair> list) throws ProtocolException {
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setRequestMethod(str);
        httpURLConnection.setConnectTimeout(i);
        httpURLConnection.setReadTimeout(i2);
        if (str2 != null) {
            httpURLConnection.setRequestProperty("Content-Type", str2);
        }
        if (list != null && !list.isEmpty()) {
            for (NameValuePair nameValuePair : list) {
                httpURLConnection.addRequestProperty(nameValuePair.getName(), nameValuePair.getValue());
                C2946a.m12189b("Header values [ " + nameValuePair.getName() + "][" + nameValuePair.getValue() + "]", f10798a);
            }
        }
        return httpURLConnection;
    }

    /* renamed from: a */
    public static void m12159a(URL url, EnumC2926c enumC2926c, AbstractC2932i abstractC2932i, AbstractC2929f abstractC2929f, int i, int i2, String str, List<NameValuePair> list, InterfaceC2942a interfaceC2942a) throws IOException {
        try {
            C2946a.m12189b(url.toString(), f10798a);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            try {
                m12158a(httpURLConnection, enumC2926c.toString(), i, i2, str, list);
                try {
                    if (abstractC2932i != null) {
                        abstractC2932i.mo12163a(httpURLConnection);
                    }
                    String strMo12156a = null;
                    try {
                        try {
                            try {
                                strMo12156a = abstractC2929f.mo12156a(httpURLConnection);
                                abstractC2929f.mo12157a();
                                httpURLConnection.disconnect();
                            } catch (SocketTimeoutException e) {
                                interfaceC2942a.mo12178a(-3);
                                C2946a.m12186a("Read Timeout occurs", f10798a);
                                abstractC2929f.mo12157a();
                                httpURLConnection.disconnect();
                                return;
                            } catch (InterruptedIOException e2) {
                                Thread.currentThread().interrupt();
                                interfaceC2942a.mo12178a(-2);
                                abstractC2929f.mo12157a();
                                httpURLConnection.disconnect();
                                return;
                            }
                        } catch (Exception e3) {
                            if (Thread.currentThread().isInterrupted()) {
                                C2946a.m12186a("Thread interrupted", f10798a);
                                interfaceC2942a.mo12178a(-2);
                                abstractC2929f.mo12157a();
                                httpURLConnection.disconnect();
                                return;
                            }
                            C2946a.m12187a(e3, f10798a);
                            C2924a c2924a = new C2924a();
                            try {
                                try {
                                    strMo12156a = c2924a.mo12156a(httpURLConnection);
                                } catch (IOException e4) {
                                    C2946a.m12187a(e4, f10798a);
                                }
                                abstractC2929f.mo12157a();
                                httpURLConnection.disconnect();
                            } finally {
                                c2924a.mo12157a();
                            }
                        }
                        int responseCode = 417;
                        String responseMessage = null;
                        try {
                            responseCode = httpURLConnection.getResponseCode();
                            responseMessage = httpURLConnection.getResponseMessage();
                            C2946a.m12189b("HTTP Response Code [" + responseCode + "][" + responseMessage + "]", f10798a);
                            C2946a.m12189b("HTTP Response [" + strMo12156a + "]", f10798a);
                        } catch (IOException e5) {
                            C2946a.m12187a(e5, f10798a);
                        }
                        switch (responseCode) {
                            case 200:
                                interfaceC2942a.mo12180a(strMo12156a);
                                return;
                            default:
                                interfaceC2942a.mo12179a(-4, responseCode, responseMessage, strMo12156a);
                                return;
                        }
                    } catch (Throwable th) {
                        abstractC2929f.mo12157a();
                        httpURLConnection.disconnect();
                        throw th;
                    }
                } catch (InterruptedIOException e6) {
                    interfaceC2942a.mo12178a(-2);
                } catch (SocketTimeoutException e7) {
                    httpURLConnection.disconnect();
                    interfaceC2942a.mo12178a(-3);
                    C2946a.m12186a("Write Timeout occurs", f10798a);
                } catch (Exception e8) {
                    C2946a.m12187a(e8, f10798a);
                    httpURLConnection.disconnect();
                    interfaceC2942a.mo12178a(-1);
                } finally {
                    abstractC2932i.mo12164a();
                }
            } catch (InterruptedIOException e9) {
                interfaceC2942a.mo12178a(-2);
            } catch (IOException e10) {
                httpURLConnection.disconnect();
                C2946a.m12187a(e10, f10798a);
                interfaceC2942a.mo12178a(-1);
            }
        } catch (IOException e11) {
            C2946a.m12187a(e11, f10798a);
            interfaceC2942a.mo12178a(-1);
        }
    }
}
