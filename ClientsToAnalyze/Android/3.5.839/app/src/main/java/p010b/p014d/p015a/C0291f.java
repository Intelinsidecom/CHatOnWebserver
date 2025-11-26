package p010b.p014d.p015a;

import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p010b.C0320g;
import p010b.p013c.C0283b;
import p010b.p014d.p017c.AbstractC0307a;
import p010b.p014d.p020e.C0317a;

/* compiled from: HttpClientImpl.java */
/* renamed from: b.d.a.f */
/* loaded from: classes.dex */
public class C0291f extends AbstractC0288c implements Serializable {

    /* renamed from: b */
    private static final AbstractC0307a f645b = AbstractC0307a.m1036a(C0291f.class);

    /* renamed from: c */
    private static boolean f646c;

    /* renamed from: d */
    private static final Map<InterfaceC0289d, InterfaceC0287b> f647d;

    static {
        f646c = false;
        try {
            String property = System.getProperty("java.specification.version");
            if (property != null) {
                f646c = 1.5d > Double.parseDouble(property);
            }
            if (C0283b.m989a().m977a()) {
                f646c = false;
                System.setProperty("http.keepAlive", "false");
            }
        } catch (SecurityException e) {
            f646c = true;
        }
        f647d = new HashMap(1);
    }

    public C0291f() {
        super(C0283b.m989a());
    }

    @Override // p010b.p014d.p015a.InterfaceC0287b
    /* renamed from: a */
    public AbstractC0297l mo992a(C0296k c0296k) throws Throwable {
        C0299n c0299n;
        Throwable th;
        OutputStream outputStream;
        int i;
        C0299n c0299n2;
        HttpURLConnection httpURLConnectionM1005a;
        OutputStream outputStream2;
        OutputStream outputStream3;
        int iM1001s = this.f643a.m1001s() + 1;
        C0299n c0299n3 = null;
        for (int i2 = 0; i2 < iM1001s; i2++) {
            int responseCode = -1;
            try {
                httpURLConnectionM1005a = m1005a(c0296k.m1021c());
                httpURLConnectionM1005a.setDoInput(true);
                m1004a(c0296k, httpURLConnectionM1005a);
                httpURLConnectionM1005a.setRequestMethod(c0296k.m1019a().name());
                if (c0296k.m1019a() != EnumC0301p.POST) {
                    outputStream2 = null;
                } else {
                    if (C0295j.m1010a(c0296k.m1020b())) {
                        String str = "----Twitter4J-upload" + System.currentTimeMillis();
                        httpURLConnectionM1005a.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + str);
                        String str2 = "--" + str;
                        httpURLConnectionM1005a.setDoOutput(true);
                        outputStream3 = httpURLConnectionM1005a.getOutputStream();
                        try {
                            DataOutputStream dataOutputStream = new DataOutputStream(outputStream3);
                            for (C0295j c0295j : c0296k.m1020b()) {
                                if (c0295j.m1016e()) {
                                    m993a(dataOutputStream, str2 + "\r\n");
                                    m993a(dataOutputStream, "Content-Disposition: form-data; name=\"" + c0295j.m1012a() + "\"; filename=\"" + c0295j.m1014c().getName() + "\"\r\n");
                                    m993a(dataOutputStream, "Content-Type: " + c0295j.m1018g() + "\r\n\r\n");
                                    BufferedInputStream bufferedInputStream = new BufferedInputStream(c0295j.m1017f() ? c0295j.m1015d() : new FileInputStream(c0295j.m1014c()));
                                    byte[] bArr = new byte[1024];
                                    while (true) {
                                        int i3 = bufferedInputStream.read(bArr);
                                        if (i3 == -1) {
                                            break;
                                        }
                                        dataOutputStream.write(bArr, 0, i3);
                                    }
                                    m993a(dataOutputStream, "\r\n");
                                    bufferedInputStream.close();
                                } else {
                                    m993a(dataOutputStream, str2 + "\r\n");
                                    m993a(dataOutputStream, "Content-Disposition: form-data; name=\"" + c0295j.m1012a() + "\"\r\n");
                                    m993a(dataOutputStream, "Content-Type: text/plain; charset=UTF-8\r\n\r\n");
                                    f645b.mo1038a(c0295j.m1013b());
                                    dataOutputStream.write(c0295j.m1013b().getBytes("UTF-8"));
                                    m993a(dataOutputStream, "\r\n");
                                }
                            }
                            m993a(dataOutputStream, str2 + "--\r\n");
                            m993a(dataOutputStream, "\r\n");
                        } catch (Throwable th2) {
                            c0299n = c0299n3;
                            th = th2;
                            outputStream = outputStream3;
                            i = -1;
                            try {
                                try {
                                    outputStream.close();
                                } catch (Exception e) {
                                }
                                throw th;
                            } catch (IOException e2) {
                                e = e2;
                                responseCode = i;
                                c0299n2 = c0299n;
                            }
                        }
                    } else {
                        httpURLConnectionM1005a.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                        String strM1011b = C0295j.m1011b(c0296k.m1020b());
                        f645b.mo1039a("Post Params: ", strM1011b);
                        byte[] bytes = strM1011b.getBytes("UTF-8");
                        httpURLConnectionM1005a.setRequestProperty("Content-Length", Integer.toString(bytes.length));
                        httpURLConnectionM1005a.setDoOutput(true);
                        outputStream3 = httpURLConnectionM1005a.getOutputStream();
                        outputStream3.write(bytes);
                    }
                    outputStream3.flush();
                    outputStream3.close();
                    outputStream2 = outputStream3;
                }
                try {
                    c0299n2 = new C0299n(httpURLConnectionM1005a, this.f643a);
                } catch (Throwable th3) {
                    i = -1;
                    OutputStream outputStream4 = outputStream2;
                    c0299n = c0299n3;
                    th = th3;
                    outputStream = outputStream4;
                }
            } catch (Throwable th4) {
                c0299n = c0299n3;
                th = th4;
                outputStream = null;
                i = -1;
            }
            try {
                responseCode = httpURLConnectionM1005a.getResponseCode();
                if (f645b.mo1041a()) {
                    f645b.mo1038a("Response: ");
                    Map<String, List<String>> headerFields = httpURLConnectionM1005a.getHeaderFields();
                    for (String str3 : headerFields.keySet()) {
                        for (String str4 : headerFields.get(str3)) {
                            if (str3 != null) {
                                f645b.mo1038a(str3 + ": " + str4);
                            } else {
                                f645b.mo1038a(str4);
                            }
                        }
                    }
                }
                if (responseCode < 200 || (responseCode != 302 && 300 <= responseCode)) {
                    if (responseCode == 420 || responseCode == 400 || responseCode < 500 || i2 == this.f643a.m1001s()) {
                        throw new C0320g(c0299n2.m1028c(), c0299n2);
                    }
                    try {
                        try {
                            outputStream2.close();
                        } catch (IOException e3) {
                            e = e3;
                        }
                    } catch (Exception e4) {
                    }
                    c0299n3 = c0299n2;
                    try {
                        if (f645b.mo1041a() && c0299n3 != null) {
                            c0299n3.m1028c();
                        }
                        f645b.mo1038a("Sleeping " + this.f643a.m1002t() + " seconds until the next retry.");
                        Thread.sleep(this.f643a.m1002t() * 1000);
                    } catch (InterruptedException e5) {
                    }
                } else {
                    try {
                        outputStream2.close();
                    } catch (Exception e6) {
                    }
                    return c0299n2;
                }
                e = e3;
                if (i2 == this.f643a.m1001s()) {
                    throw new C0320g(e.getMessage(), e, responseCode);
                }
                c0299n3 = c0299n2;
                if (f645b.mo1041a()) {
                    c0299n3.m1028c();
                }
                f645b.mo1038a("Sleeping " + this.f643a.m1002t() + " seconds until the next retry.");
                Thread.sleep(this.f643a.m1002t() * 1000);
            } catch (Throwable th5) {
                th = th5;
                outputStream = outputStream2;
                c0299n = c0299n2;
                i = responseCode;
                outputStream.close();
                throw th;
            }
        }
        return c0299n3;
    }

    /* renamed from: a */
    private void m1004a(C0296k c0296k, HttpURLConnection httpURLConnection) {
        String strMo955a;
        if (f645b.mo1041a()) {
            f645b.mo1038a("Request: ");
            f645b.mo1039a(c0296k.m1019a().name() + " ", c0296k.m1021c());
        }
        if (c0296k.m1022d() != null && (strMo955a = c0296k.m1022d().mo955a(c0296k)) != null) {
            if (f645b.mo1041a()) {
                f645b.mo1039a("Authorization: ", C0317a.m1073a(strMo955a));
            }
            httpURLConnection.addRequestProperty("Authorization", strMo955a);
        }
        if (c0296k.m1023e() != null) {
            for (String str : c0296k.m1023e().keySet()) {
                httpURLConnection.addRequestProperty(str, c0296k.m1023e().get(str));
                f645b.mo1038a(str + ": " + c0296k.m1023e().get(str));
            }
        }
    }

    /* renamed from: a */
    protected HttpURLConnection m1005a(String str) {
        HttpURLConnection httpURLConnection;
        if (m994a() && !f646c) {
            if (this.f643a.m997o() != null && !this.f643a.m997o().equals("")) {
                if (f645b.mo1041a()) {
                    f645b.mo1038a("Proxy AuthUser: " + this.f643a.m997o());
                    f645b.mo1038a("Proxy AuthPassword: " + C0317a.m1073a(this.f643a.m998p()));
                }
                Authenticator.setDefault(new C0292g(this));
            }
            Proxy proxy = new Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(this.f643a.m995m(), this.f643a.m996n()));
            if (f645b.mo1041a()) {
                f645b.mo1038a("Opening proxied connection(" + this.f643a.m995m() + ":" + this.f643a.m996n() + ")");
            }
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection(proxy);
        } else {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        }
        if (this.f643a.m999q() > 0 && !f646c) {
            httpURLConnection.setConnectTimeout(this.f643a.m999q());
        }
        if (this.f643a.m1000r() > 0 && !f646c) {
            httpURLConnection.setReadTimeout(this.f643a.m1000r());
        }
        httpURLConnection.setInstanceFollowRedirects(false);
        return httpURLConnection;
    }
}
