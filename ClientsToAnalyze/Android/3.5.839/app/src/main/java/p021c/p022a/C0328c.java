package p021c.p022a;

import com.sec.amsoma.AMSLibs;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLEncoder;
import java.security.AccessControlException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p021c.C0325a;
import p021c.C0349h;
import p021c.C0351j;

/* compiled from: HttpClient.java */
/* renamed from: c.a.c */
/* loaded from: classes.dex */
public class C0328c implements Serializable {

    /* renamed from: a */
    private static final boolean f725a = C0325a.m1118p();

    /* renamed from: m */
    private static boolean f726m;

    /* renamed from: c */
    private int f728c = C0325a.m1114l();

    /* renamed from: d */
    private int f729d = C0325a.m1115m() * 1000;

    /* renamed from: e */
    private String f730e = C0325a.m1116n();

    /* renamed from: f */
    private String f731f = C0325a.m1117o();

    /* renamed from: g */
    private String f732g = C0325a.m1102f();

    /* renamed from: h */
    private int f733h = C0325a.m1108i();

    /* renamed from: i */
    private String f734i = C0325a.m1104g();

    /* renamed from: j */
    private String f735j = C0325a.m1106h();

    /* renamed from: k */
    private int f736k = C0325a.m1110j();

    /* renamed from: l */
    private int f737l = C0325a.m1112k();

    /* renamed from: n */
    private Map<String, String> f738n = new HashMap();

    /* renamed from: o */
    private C0330e f739o = null;

    /* renamed from: p */
    private String f740p = C0325a.m1098d() + "api.t.sina.com.cn/oauth/request_token";

    /* renamed from: q */
    private String f741q = C0325a.m1098d() + "api.t.sina.com.cn/oauth/authorize";

    /* renamed from: r */
    private String f742r = C0325a.m1098d() + "api.t.sina.com.cn/oauth/authenticate";

    /* renamed from: s */
    private String f743s = C0325a.m1098d() + "api.t.sina.com.cn/oauth/access_token";

    /* renamed from: t */
    private String f744t = "https://api.weibo.com/oauth2/get_oauth2_token";

    /* renamed from: u */
    private AbstractC0331f f745u = null;

    /* renamed from: v */
    private String f746v = null;

    /* renamed from: b */
    private String f727b = null;

    static {
        f726m = false;
        try {
            String property = System.getProperty("java.specification.version");
            if (property != null) {
                f726m = 1.5d > Double.parseDouble(property);
            }
        } catch (AccessControlException e) {
            f726m = true;
        }
    }

    public C0328c() {
        m1151g(null);
        m1140a((String) null, (String) null);
        m1145b("Accept-Encoding", "gzip");
    }

    /* renamed from: a */
    public void m1139a(String str) {
        this.f730e = str;
        m1131d();
    }

    /* renamed from: b */
    public void m1144b(String str) {
        this.f731f = str;
        m1131d();
    }

    /* renamed from: a */
    public boolean m1141a() {
        return (this.f727b == null && this.f739o == null) ? false : true;
    }

    /* renamed from: a */
    public void m1140a(String str, String str2) {
        String strM1103f = C0325a.m1103f(str);
        String strM1105g = C0325a.m1105g(str2);
        if (strM1103f != null && strM1105g != null && strM1103f.length() != 0 && strM1105g.length() != 0) {
            this.f739o = new C0330e(strM1103f, strM1105g);
        }
    }

    /* renamed from: c */
    public C0333h m1146c(String str) {
        this.f745u = new C0333h(m1143b(this.f740p, new C0332g[]{new C0332g("oauth_callback", str)}, true), this);
        return (C0333h) this.f745u;
    }

    /* renamed from: a */
    public C0326a m1134a(C0333h c0333h, String str) throws C0351j {
        try {
            this.f745u = c0333h;
            this.f745u = new C0326a(m1143b(this.f743s, new C0332g[]{new C0332g("oauth_verifier", str)}, true));
            return (C0326a) this.f745u;
        } catch (C0351j e) {
            throw new C0351j("The user has not given access to the account.", e, e.m1241a());
        }
    }

    /* renamed from: b */
    public C0326a m1142b() {
        return new C0326a(m1143b(this.f744t, new C0332g[0], true).m1175c());
    }

    /* renamed from: a */
    public void m1138a(C0326a c0326a) {
        this.f745u = c0326a;
    }

    /* renamed from: d */
    public void m1148d(String str) {
        this.f740p = str;
    }

    /* renamed from: e */
    public void m1149e(String str) {
        this.f741q = str;
    }

    /* renamed from: c */
    public String m1147c() {
        return this.f742r;
    }

    /* renamed from: f */
    public void m1150f(String str) {
        this.f743s = str;
    }

    /* renamed from: d */
    private void m1131d() {
        if (this.f730e != null && this.f731f != null) {
            this.f727b = "Basic " + new String(new C0327b().m1124a((this.f730e + ":" + this.f731f).getBytes()));
            this.f739o = null;
        }
    }

    /* renamed from: g */
    public void m1151g(String str) {
        m1145b("User-Agent", C0325a.m1101e(str));
    }

    /* renamed from: a */
    public C0334i m1136a(String str, C0332g[] c0332gArr, boolean z) {
        C0332g[] c0332gArr2 = new C0332g[c0332gArr.length + 1];
        for (int i = 0; i < c0332gArr.length; i++) {
            c0332gArr2[i] = c0332gArr[i];
        }
        c0332gArr2[c0332gArr.length] = new C0332g("source", C0349h.f842a);
        return m1143b(str, c0332gArr2, z);
    }

    /* renamed from: a */
    public C0334i m1135a(String str, boolean z) {
        return m1143b(str, null, z);
    }

    /* renamed from: b */
    protected C0334i m1143b(String str, C0332g[] c0332gArr, boolean z) {
        String str2 = "GET";
        if (c0332gArr != null) {
            C0332g[] c0332gArr2 = new C0332g[c0332gArr.length + 1];
            for (int i = 0; i < c0332gArr.length; i++) {
                c0332gArr2[i] = c0332gArr[i];
            }
            c0332gArr2[c0332gArr.length] = new C0332g("source", C0349h.f842a);
            str2 = "POST";
            c0332gArr = c0332gArr2;
        }
        return m1137a(str, c0332gArr, z, str2);
    }

    /* renamed from: a */
    public C0334i m1137a(String str, C0332g[] c0332gArr, boolean z, String str2) throws Throwable {
        OutputStream outputStream;
        int i;
        int responseCode;
        C0334i c0334i;
        OutputStream outputStream2;
        int i2 = this.f728c + 1;
        C0334i c0334i2 = null;
        for (int i3 = 0; i3 < i2; i3++) {
            try {
                HttpURLConnection httpURLConnectionM1132h = m1132h(str);
                httpURLConnectionM1132h.setDoInput(true);
                m1128a(str, c0332gArr, httpURLConnectionM1132h, z, str2);
                if (c0332gArr != null || "POST".equals(str2)) {
                    httpURLConnectionM1132h.setRequestMethod("POST");
                    httpURLConnectionM1132h.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    httpURLConnectionM1132h.setDoOutput(true);
                    String strM1127a = "";
                    if (c0332gArr != null) {
                        strM1127a = m1127a(c0332gArr);
                    }
                    m1130c("Post Params: ", strM1127a);
                    byte[] bytes = strM1127a.getBytes("UTF-8");
                    httpURLConnectionM1132h.setRequestProperty("Content-Length", Integer.toString(bytes.length));
                    outputStream = httpURLConnectionM1132h.getOutputStream();
                    try {
                        outputStream.write(bytes);
                        outputStream.flush();
                        outputStream.close();
                        outputStream2 = outputStream;
                    } catch (Throwable th) {
                        th = th;
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
                            c0334i = c0334i2;
                        }
                    }
                } else if ("DELETE".equals(str2)) {
                    httpURLConnectionM1132h.setRequestMethod("DELETE");
                    outputStream2 = null;
                } else {
                    httpURLConnectionM1132h.setRequestMethod("GET");
                    outputStream2 = null;
                }
                try {
                    c0334i = new C0334i(httpURLConnectionM1132h);
                    try {
                        responseCode = httpURLConnectionM1132h.getResponseCode();
                    } catch (Throwable th2) {
                        th = th2;
                        outputStream = outputStream2;
                        c0334i2 = c0334i;
                        i = -1;
                    }
                    try {
                        if (f725a) {
                            m1133i("Response: ");
                            Map<String, List<String>> headerFields = httpURLConnectionM1132h.getHeaderFields();
                            for (String str3 : headerFields.keySet()) {
                                for (String str4 : headerFields.get(str3)) {
                                    if (str3 != null) {
                                        m1133i(str3 + ": " + str4);
                                    } else {
                                        m1133i(str4);
                                    }
                                }
                            }
                        }
                        if (responseCode != 200) {
                            if (responseCode < 500 || i3 == this.f728c) {
                                throw new C0351j(m1125a(responseCode) + "\n" + c0334i.m1174b(), responseCode);
                            }
                            try {
                                try {
                                    outputStream2.close();
                                } catch (IOException e3) {
                                    e = e3;
                                }
                            } catch (Exception e4) {
                            }
                            c0334i2 = c0334i;
                            try {
                                if (f725a && c0334i2 != null) {
                                    c0334i2.m1174b();
                                }
                                m1133i("Sleeping " + this.f729d + " millisecs for next retry.");
                                Thread.sleep(this.f729d);
                            } catch (InterruptedException e5) {
                            }
                        } else {
                            try {
                                outputStream2.close();
                            } catch (Exception e6) {
                            }
                            return c0334i;
                        }
                        e = e3;
                        if (i3 == this.f728c) {
                            throw new C0351j(e.getMessage(), e, responseCode);
                        }
                        c0334i2 = c0334i;
                        if (f725a) {
                            c0334i2.m1174b();
                        }
                        m1133i("Sleeping " + this.f729d + " millisecs for next retry.");
                        Thread.sleep(this.f729d);
                    } catch (Throwable th3) {
                        th = th3;
                        outputStream = outputStream2;
                        c0334i2 = c0334i;
                        i = responseCode;
                        outputStream.close();
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    outputStream = outputStream2;
                    i = -1;
                }
            } catch (Throwable th5) {
                th = th5;
                outputStream = null;
                i = -1;
            }
        }
        return c0334i2;
    }

    /* renamed from: a */
    public static String m1127a(C0332g[] c0332gArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < c0332gArr.length; i++) {
            if (i != 0) {
                stringBuffer.append("&");
            }
            try {
                stringBuffer.append(URLEncoder.encode(c0332gArr[i].f758a, "UTF-8")).append("=").append(URLEncoder.encode(c0332gArr[i].f759b, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
            }
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    private void m1128a(String str, C0332g[] c0332gArr, HttpURLConnection httpURLConnection, boolean z, String str2) {
        String strM1162a;
        m1133i("Request: ");
        m1130c(str2 + " ", str);
        if (z) {
            if (this.f727b != null || this.f739o != null) {
            }
            if (this.f739o != null) {
                strM1162a = this.f739o.m1162a(str2, str, c0332gArr, this.f745u);
            } else if (this.f727b != null) {
                strM1162a = this.f727b;
            } else {
                throw new IllegalStateException("Neither user ID/password combination nor OAuth consumer key/secret combination supplied");
            }
            httpURLConnection.addRequestProperty("Authorization", strM1162a);
            m1133i("Authorization: " + strM1162a);
        }
        for (String str3 : this.f738n.keySet()) {
            httpURLConnection.addRequestProperty(str3, this.f738n.get(str3));
            m1133i(str3 + ": " + this.f738n.get(str3));
        }
    }

    /* renamed from: b */
    public void m1145b(String str, String str2) {
        this.f738n.put(str, str2);
    }

    /* renamed from: h */
    private HttpURLConnection m1132h(String str) {
        HttpURLConnection httpURLConnection;
        if (this.f732g != null && !this.f732g.equals("")) {
            if (this.f734i != null && !this.f734i.equals("")) {
                m1133i("Proxy AuthUser: " + this.f734i);
                m1133i("Proxy AuthPassword: " + this.f735j);
                Authenticator.setDefault(new C0329d(this));
            }
            Proxy proxy = new Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(this.f732g, this.f733h));
            if (f725a) {
                m1133i("Opening proxied connection(" + this.f732g + ":" + this.f733h + ")");
            }
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection(proxy);
        } else {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        }
        if (this.f736k > 0 && !f726m) {
            httpURLConnection.setConnectTimeout(this.f736k);
        }
        if (this.f737l > 0 && !f726m) {
            httpURLConnection.setReadTimeout(this.f737l);
        }
        return httpURLConnection;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0328c)) {
            return false;
        }
        C0328c c0328c = (C0328c) obj;
        if (this.f736k == c0328c.f736k && this.f733h == c0328c.f733h && this.f737l == c0328c.f737l && this.f728c == c0328c.f728c && this.f729d == c0328c.f729d) {
            if (this.f743s == null ? c0328c.f743s != null : !this.f743s.equals(c0328c.f743s)) {
                return false;
            }
            if (this.f742r.equals(c0328c.f742r) && this.f741q.equals(c0328c.f741q)) {
                if (this.f727b == null ? c0328c.f727b != null : !this.f727b.equals(c0328c.f727b)) {
                    return false;
                }
                if (this.f739o == null ? c0328c.f739o != null : !this.f739o.equals(c0328c.f739o)) {
                    return false;
                }
                if (this.f745u == null ? c0328c.f745u != null : !this.f745u.equals(c0328c.f745u)) {
                    return false;
                }
                if (this.f731f == null ? c0328c.f731f != null : !this.f731f.equals(c0328c.f731f)) {
                    return false;
                }
                if (this.f735j == null ? c0328c.f735j != null : !this.f735j.equals(c0328c.f735j)) {
                    return false;
                }
                if (this.f734i == null ? c0328c.f734i != null : !this.f734i.equals(c0328c.f734i)) {
                    return false;
                }
                if (this.f732g == null ? c0328c.f732g != null : !this.f732g.equals(c0328c.f732g)) {
                    return false;
                }
                if (this.f738n.equals(c0328c.f738n) && this.f740p.equals(c0328c.f740p)) {
                    if (this.f730e != null) {
                        if (this.f730e.equals(c0328c.f730e)) {
                            return true;
                        }
                    } else if (c0328c.f730e == null) {
                        return true;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return (((this.f743s != null ? this.f743s.hashCode() : 0) + (((((((((this.f739o != null ? this.f739o.hashCode() : 0) + (((((((((this.f735j != null ? this.f735j.hashCode() : 0) + (((this.f734i != null ? this.f734i.hashCode() : 0) + (((((this.f732g != null ? this.f732g.hashCode() : 0) + (((this.f731f != null ? this.f731f.hashCode() : 0) + (((this.f730e != null ? this.f730e.hashCode() : 0) + ((((((this.f727b != null ? this.f727b.hashCode() : 0) * 31) + this.f728c) * 31) + this.f729d) * 31)) * 31)) * 31)) * 31) + this.f733h) * 31)) * 31)) * 31) + this.f736k) * 31) + this.f737l) * 31) + this.f738n.hashCode()) * 31)) * 31) + this.f740p.hashCode()) * 31) + this.f741q.hashCode()) * 31) + this.f742r.hashCode()) * 31)) * 31) + (this.f745u != null ? this.f745u.hashCode() : 0);
    }

    /* renamed from: i */
    private static void m1133i(String str) {
        if (f725a) {
            System.out.println("[" + new Date() + "]" + str);
        }
    }

    /* renamed from: c */
    private static void m1130c(String str, String str2) {
        if (f725a) {
            m1133i(str + str2);
        }
    }

    /* renamed from: a */
    private static String m1125a(int i) {
        String str = null;
        switch (i) {
            case 304:
                break;
            case AMSLibs.ENUM_VIP_AMS_SAVE_THUMBNAIL_IMAGE_SIZE /* 400 */:
                str = "The request was invalid.  An accompanying error message will explain why. This is the status code will be returned during rate limiting.";
                break;
            case 401:
                str = "Authentication credentials were missing or incorrect.";
                break;
            case 403:
                str = "The request is understood, but it has been refused.  An accompanying error message will explain why.";
                break;
            case 404:
                str = "The URI requested is invalid or the resource requested, such as a user, does not exists.";
                break;
            case 406:
                str = "Returned by the Search API when an invalid format is specified in the request.";
                break;
            case 500:
                str = "Something is broken.  Please post to the group so the Weibo team can investigate.";
                break;
            case 502:
                str = "Weibo is down or being upgraded.";
                break;
            case 503:
                str = "Service Unavailable: The Weibo servers are up, but overloaded with requests. Try again later. The search and trend methods use this to indicate when you are being rate limited.";
                break;
            default:
                str = "";
                break;
        }
        return i + ":" + str;
    }
}
