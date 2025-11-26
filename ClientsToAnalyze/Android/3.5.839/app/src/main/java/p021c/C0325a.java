package p021c;

import com.sec.chaton.privateplugin.data.Spam;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.AccessControlException;
import java.util.Properties;

/* compiled from: Configuration.java */
/* renamed from: c.a */
/* loaded from: classes.dex */
public class C0325a {

    /* renamed from: a */
    private static Properties f713a;

    /* renamed from: b */
    private static boolean f714b;

    static {
        m1091a();
    }

    /* renamed from: a */
    static void m1091a() throws ClassNotFoundException {
        f713a = new Properties();
        f713a.setProperty("weibo4j.debug", "true");
        f713a.setProperty("weibo4j.source", C0349h.f842a);
        f713a.setProperty("weibo4j.clientURL", "http://open.t.sina.com.cn/-{weibo4j.clientVersion}.xml");
        f713a.setProperty("weibo4j.http.userAgent", "weibo4j http://open.t.sina.com.cn/ /{weibo4j.clientVersion}");
        f713a.setProperty("weibo4j.http.useSSL", "false");
        f713a.setProperty("weibo4j.http.proxyHost.fallback", "http.proxyHost");
        f713a.setProperty("weibo4j.http.proxyPort.fallback", "http.proxyPort");
        f713a.setProperty("weibo4j.http.connectionTimeout", "20000");
        f713a.setProperty("weibo4j.http.readTimeout", "120000");
        f713a.setProperty("weibo4j.http.retryCount", "3");
        f713a.setProperty("weibo4j.http.retryIntervalSecs", "10");
        f713a.setProperty("weibo4j.async.numThreads", Spam.ACTIVITY_REPORT);
        f713a.setProperty("weibo4j.clientVersion", C0348g.m1223a());
        try {
            Class.forName("dalvik.system.VMRuntime");
            f713a.setProperty("weibo4j.dalvik", "true");
        } catch (ClassNotFoundException e) {
            f713a.setProperty("weibo4j.dalvik", "false");
        }
        f714b = m1107h("weibo4j.dalvik");
        if (m1093a(f713a, "." + File.separatorChar + "weibo4j.properties") || m1092a(f713a, C0325a.class.getResourceAsStream("/WEB-INF/weibo4j.properties")) || m1092a(f713a, C0325a.class.getResourceAsStream("/weibo4j.properties"))) {
        }
    }

    /* renamed from: a */
    private static boolean m1093a(Properties properties, String str) throws IOException {
        try {
            File file = new File(str);
            if (file.exists() && file.isFile()) {
                properties.load(new FileInputStream(file));
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m1092a(Properties properties, InputStream inputStream) throws IOException {
        try {
            properties.load(inputStream);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: b */
    public static boolean m1095b() {
        return f714b;
    }

    /* renamed from: c */
    public static boolean m1097c() {
        return m1107h("weibo4j.http.useSSL");
    }

    /* renamed from: d */
    public static String m1098d() {
        return m1097c() ? "https://" : "http://";
    }

    /* renamed from: a */
    public static String m1089a(String str) {
        return m1090a("weibo4j.clientVersion", str);
    }

    /* renamed from: e */
    public static String m1100e() {
        return m1111j("weibo4j.source");
    }

    /* renamed from: f */
    public static String m1102f() {
        return m1111j("weibo4j.http.proxyHost");
    }

    /* renamed from: g */
    public static String m1104g() {
        return m1111j("weibo4j.http.proxyUser");
    }

    /* renamed from: b */
    public static String m1094b(String str) {
        return m1090a("weibo4j.clientURL", str);
    }

    /* renamed from: h */
    public static String m1106h() {
        return m1111j("weibo4j.http.proxyPassword");
    }

    /* renamed from: i */
    public static int m1108i() {
        return m1109i("weibo4j.http.proxyPort");
    }

    /* renamed from: j */
    public static int m1110j() {
        return m1109i("weibo4j.http.connectionTimeout");
    }

    /* renamed from: k */
    public static int m1112k() {
        return m1109i("weibo4j.http.readTimeout");
    }

    /* renamed from: l */
    public static int m1114l() {
        return m1109i("weibo4j.http.retryCount");
    }

    /* renamed from: m */
    public static int m1115m() {
        return m1109i("weibo4j.http.retryIntervalSecs");
    }

    /* renamed from: n */
    public static String m1116n() {
        return m1111j("weibo4j.user");
    }

    /* renamed from: c */
    public static String m1096c(String str) {
        return m1090a("weibo4j.user", str);
    }

    /* renamed from: o */
    public static String m1117o() {
        return m1111j("weibo4j.password");
    }

    /* renamed from: d */
    public static String m1099d(String str) {
        return m1090a("weibo4j.password", str);
    }

    /* renamed from: e */
    public static String m1101e(String str) {
        return m1090a("weibo4j.http.userAgent", str);
    }

    /* renamed from: f */
    public static String m1103f(String str) {
        return m1090a("weibo4j.oauth.consumerKey", str);
    }

    /* renamed from: g */
    public static String m1105g(String str) {
        return m1090a("weibo4j.oauth.consumerSecret", str);
    }

    /* renamed from: h */
    public static boolean m1107h(String str) {
        return Boolean.valueOf(m1111j(str)).booleanValue();
    }

    /* renamed from: i */
    public static int m1109i(String str) {
        try {
            return Integer.parseInt(m1111j(str));
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /* renamed from: j */
    public static String m1111j(String str) {
        return m1090a(str, (String) null);
    }

    /* renamed from: a */
    public static String m1090a(String str, String str2) {
        String property;
        String property2;
        try {
            property = System.getProperty(str, str2);
            if (property == null) {
                property = f713a.getProperty(str);
            }
            if (property == null && (property2 = f713a.getProperty(str + ".fallback")) != null) {
                property = System.getProperty(property2);
            }
        } catch (AccessControlException e) {
            property = str2;
        }
        return m1113k(property);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0053  */
    /* renamed from: k */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String m1113k(java.lang.String r5) {
        /*
            r4 = 0
            if (r5 != 0) goto L4
        L3:
            return r5
        L4:
            r0 = -1
            java.lang.String r1 = "{"
            int r1 = r5.indexOf(r1, r4)
            if (r0 == r1) goto L53
            java.lang.String r0 = "}"
            int r0 = r5.indexOf(r0, r1)
            int r2 = r1 + 1
            if (r0 <= r2) goto L53
            int r2 = r1 + 1
            java.lang.String r2 = r5.substring(r2, r0)
            int r3 = r2.length()
            if (r3 <= 0) goto L53
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r1 = r5.substring(r4, r1)
            java.lang.StringBuilder r1 = r3.append(r1)
            java.lang.String r2 = m1111j(r2)
            java.lang.StringBuilder r1 = r1.append(r2)
            int r0 = r0 + 1
            java.lang.String r0 = r5.substring(r0)
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.String r0 = r0.toString()
        L48:
            boolean r1 = r0.equals(r5)
            if (r1 != 0) goto L3
            java.lang.String r5 = m1113k(r0)
            goto L3
        L53:
            r0 = r5
            goto L48
        */
        throw new UnsupportedOperationException("Method not decompiled: p021c.C0325a.m1113k(java.lang.String):java.lang.String");
    }

    /* renamed from: p */
    public static boolean m1118p() {
        return m1107h("weibo4j.debug");
    }
}
