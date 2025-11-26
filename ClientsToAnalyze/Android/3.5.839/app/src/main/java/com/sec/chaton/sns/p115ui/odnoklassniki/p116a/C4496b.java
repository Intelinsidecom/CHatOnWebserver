package com.sec.chaton.sns.p115ui.odnoklassniki.p116a;

import android.content.Context;
import com.p137vk.sdk.VKOpenAuthActivity;
import com.p137vk.sdk.api.VKApiConst;
import com.sec.chaton.sns.C4363a;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;

/* compiled from: Odnoklassniki.java */
/* renamed from: com.sec.chaton.sns.ui.odnoklassniki.a.b */
/* loaded from: classes.dex */
public class C4496b {

    /* renamed from: g */
    private static C4496b f16212g;

    /* renamed from: a */
    protected String f16213a;

    /* renamed from: b */
    protected String f16214b;

    /* renamed from: c */
    protected String f16215c;

    /* renamed from: d */
    protected String f16216d;

    /* renamed from: e */
    protected String f16217e;

    /* renamed from: f */
    protected HttpClient f16218f;

    /* renamed from: h */
    private Context f16219h;

    /* renamed from: a */
    public static final C4496b m17030a(Context context, String str, String str2, String str3) {
        if (str == null || str3 == null || str2 == null) {
            throw new IllegalArgumentException("Missing some application info. All parameters are required");
        }
        if (f16212g == null) {
            f16212g = new C4496b(context, str, str2, str3);
        }
        return f16212g;
    }

    private C4496b(Context context, String str, String str2, String str3) {
        this.f16213a = str;
        this.f16214b = str2;
        this.f16215c = str3;
        this.f16219h = context;
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        this.f16218f = new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
        this.f16216d = C4363a.m16549b(context);
        this.f16217e = C4363a.m16551c(context);
    }

    /* renamed from: a */
    public final void m17033a(Context context) {
        String strM17038a;
        String str;
        String[] strArrM17046a;
        String str2 = null;
        String strM16551c = C4363a.m16551c(context);
        HashMap map = new HashMap(4);
        map.put("refresh_token", strM16551c);
        map.put("grant_type", "refresh_token");
        map.put(VKOpenAuthActivity.VK_EXTRA_CLIENT_ID, "223397120");
        map.put("client_secret", "29341535E6AFF6362750637B");
        try {
            strM17038a = C4499e.m17038a(this.f16218f, "http://api.odnoklassniki.ru/oauth/token.do", map);
        } catch (IOException e) {
            strM17038a = null;
        }
        if (strM17038a == null || (strArrM17046a = C4501g.m17046a(strM17038a, true)) == null) {
            str = null;
        } else {
            str = strArrM17046a[0];
            if (strArrM17046a.length > 1) {
                str2 = strArrM17046a[1];
            }
        }
        if (str == null && strM17038a != null && strM17038a.contains("access_denied")) {
            throw new IllegalArgumentException();
        }
        this.f16216d = str;
        C4363a.m16547a(context, str);
        if (str2 != null) {
            C4363a.m16550b(context, str2);
        }
    }

    /* renamed from: a */
    public final String m17032a(String str, Map<String, String> map, String str2) throws NoSuchAlgorithmException {
        if (str == null) {
            throw new IllegalArgumentException("Api method can't be null");
        }
        TreeMap treeMap = new TreeMap();
        if (map != null && !map.isEmpty()) {
            treeMap.putAll(map);
        }
        treeMap.put("application_key", this.f16215c);
        treeMap.put("method", str);
        m17031a(treeMap);
        treeMap.put("access_token", C4363a.m16549b(this.f16219h));
        if ("post".equalsIgnoreCase(str2)) {
            return C4499e.m17038a(this.f16218f, "http://api.odnoklassniki.ru/fb.do", treeMap);
        }
        return C4499e.m17040b(this.f16218f, "http://api.odnoklassniki.ru/fb.do", treeMap);
    }

    /* renamed from: a */
    private final void m17031a(Map<String, String> map) throws NoSuchAlgorithmException {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append(entry.getKey()).append("=").append(entry.getValue());
        }
        map.put(VKApiConst.SIG, C4497c.m17035a(sb.toString() + C4497c.m17035a(C4363a.m16549b(this.f16219h) + this.f16214b)));
    }

    /* renamed from: b */
    public final void m17034b(Context context) {
        this.f16216d = null;
        this.f16217e = null;
        C4363a.m16546a(context);
    }
}
