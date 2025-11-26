package com.facebook;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Pair;
import com.facebook.model.GraphMultiResult;
import com.facebook.model.GraphObject;
import com.facebook.model.GraphObjectList;
import com.facebook.p032b.C0470m;
import com.facebook.p032b.C0476s;
import com.facebook.p032b.C0477t;
import com.renren.android.Renren;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Request.java */
/* renamed from: com.facebook.am */
/* loaded from: classes.dex */
public class C0443am {

    /* renamed from: a */
    private static String f1080a;

    /* renamed from: m */
    private static volatile String f1081m;

    /* renamed from: b */
    private C0478ba f1082b;

    /* renamed from: c */
    private EnumC0440aj f1083c;

    /* renamed from: d */
    private String f1084d;

    /* renamed from: e */
    private GraphObject f1085e;

    /* renamed from: f */
    private String f1086f;

    /* renamed from: g */
    private String f1087g;

    /* renamed from: h */
    private String f1088h;

    /* renamed from: i */
    private boolean f1089i;

    /* renamed from: j */
    private Bundle f1090j;

    /* renamed from: k */
    private InterfaceC0448ar f1091k;

    /* renamed from: l */
    private String f1092l;

    public C0443am() {
        this(null, null, null, null, null);
    }

    public C0443am(C0478ba c0478ba, String str, Bundle bundle, EnumC0440aj enumC0440aj, InterfaceC0448ar interfaceC0448ar) {
        this.f1089i = true;
        this.f1082b = c0478ba;
        this.f1084d = str;
        this.f1091k = interfaceC0448ar;
        m1614a(enumC0440aj);
        if (bundle != null) {
            this.f1090j = new Bundle(bundle);
        } else {
            this.f1090j = new Bundle();
        }
        if (!this.f1090j.containsKey("migration_bundle")) {
            this.f1090j.putString("migration_bundle", "fbsdk:20121026");
        }
    }

    /* renamed from: a */
    public static C0443am m1580a(C0478ba c0478ba, String str, GraphObject graphObject, InterfaceC0448ar interfaceC0448ar) {
        C0443am c0443am = new C0443am(c0478ba, str, null, EnumC0440aj.POST, interfaceC0448ar);
        c0443am.m1616a(graphObject);
        return c0443am;
    }

    /* renamed from: a */
    public static C0443am m1577a(C0478ba c0478ba, InterfaceC0449as interfaceC0449as) {
        return new C0443am(c0478ba, "me", null, null, new C0444an(interfaceC0449as));
    }

    /* renamed from: a */
    public static C0443am m1578a(C0478ba c0478ba, InterfaceC0450at interfaceC0450at) {
        return new C0443am(c0478ba, "me/friends", null, null, new C0445ao(interfaceC0450at));
    }

    /* renamed from: a */
    public static C0443am m1579a(C0478ba c0478ba, String str, InterfaceC0448ar interfaceC0448ar) {
        return new C0443am(c0478ba, str, null, null, interfaceC0448ar);
    }

    /* renamed from: a */
    public final void m1616a(GraphObject graphObject) {
        this.f1085e = graphObject;
    }

    /* renamed from: a */
    public final void m1614a(EnumC0440aj enumC0440aj) {
        if (this.f1092l != null && enumC0440aj != EnumC0440aj.GET) {
            throw new C0551y("Can't change HTTP method on request with overridden URL.");
        }
        if (enumC0440aj == null) {
            enumC0440aj = EnumC0440aj.GET;
        }
        this.f1083c = enumC0440aj;
    }

    /* renamed from: a */
    public final void m1613a(Bundle bundle) {
        this.f1090j = bundle;
    }

    /* renamed from: a */
    public final C0478ba m1612a() {
        return this.f1082b;
    }

    /* renamed from: a */
    public final void m1615a(InterfaceC0448ar interfaceC0448ar) {
        this.f1091k = interfaceC0448ar;
    }

    /* renamed from: b */
    public final C0456az m1617b() {
        return m1581a(this);
    }

    /* renamed from: a */
    public static HttpURLConnection m1583a(C0454ax c0454ax) {
        URL url;
        Iterator<C0443am> it = c0454ax.iterator();
        while (it.hasNext()) {
            it.next().m1609f();
        }
        try {
            if (c0454ax.size() == 1) {
                url = new URL(c0454ax.get(0).m1619d());
            } else {
                url = new URL("https://graph.facebook.com");
            }
            try {
                HttpURLConnection httpURLConnectionM1584a = m1584a(url);
                m1591a(c0454ax, httpURLConnectionM1584a);
                return httpURLConnectionM1584a;
            } catch (IOException e) {
                throw new C0551y("could not construct request body", e);
            } catch (JSONException e2) {
                throw new C0551y("could not construct request body", e2);
            }
        } catch (MalformedURLException e3) {
            throw new C0551y("could not construct URL for request", e3);
        }
    }

    /* renamed from: a */
    public static C0456az m1581a(C0443am c0443am) {
        List<C0456az> listM1588a = m1588a(c0443am);
        if (listM1588a == null || listM1588a.size() != 1) {
            throw new C0551y("invalid state: expected a single response");
        }
        return listM1588a.get(0);
    }

    /* renamed from: a */
    public static List<C0456az> m1588a(C0443am... c0443amArr) {
        C0477t.m1721a(c0443amArr, "requests");
        return m1587a((Collection<C0443am>) Arrays.asList(c0443amArr));
    }

    /* renamed from: a */
    public static List<C0456az> m1587a(Collection<C0443am> collection) {
        return m1600b(new C0454ax(collection));
    }

    /* renamed from: b */
    public static List<C0456az> m1600b(C0454ax c0454ax) {
        C0477t.m1725c(c0454ax, "requests");
        try {
            return m1586a(m1583a(c0454ax), c0454ax);
        } catch (Exception e) {
            List<C0456az> listM1658a = C0456az.m1658a(c0454ax.m1646d(), null, new C0551y(e));
            m1592a(c0454ax, listM1658a);
            return listM1658a;
        }
    }

    /* renamed from: b */
    public static AsyncTaskC0453aw m1598b(C0443am... c0443amArr) {
        C0477t.m1721a(c0443amArr, "requests");
        return m1597b((Collection<C0443am>) Arrays.asList(c0443amArr));
    }

    /* renamed from: b */
    public static AsyncTaskC0453aw m1597b(Collection<C0443am> collection) {
        return m1603c(new C0454ax(collection));
    }

    /* renamed from: c */
    public static AsyncTaskC0453aw m1603c(C0454ax c0454ax) {
        C0477t.m1725c(c0454ax, "requests");
        AsyncTaskC0453aw asyncTaskC0453aw = new AsyncTaskC0453aw(c0454ax);
        asyncTaskC0453aw.m1632a();
        return asyncTaskC0453aw;
    }

    /* renamed from: a */
    public static List<C0456az> m1586a(HttpURLConnection httpURLConnection, C0454ax c0454ax) {
        List<C0456az> listM1656a = C0456az.m1656a(httpURLConnection, c0454ax);
        C0476s.m1716a(httpURLConnection);
        int size = c0454ax.size();
        if (size != listM1656a.size()) {
            throw new C0551y(String.format("Received %d responses while expecting %d", Integer.valueOf(listM1656a.size()), Integer.valueOf(size)));
        }
        m1592a(c0454ax, listM1656a);
        HashSet hashSet = new HashSet();
        Iterator<C0443am> it = c0454ax.iterator();
        while (it.hasNext()) {
            C0443am next = it.next();
            if (next.f1082b != null) {
                hashSet.add(next.f1082b);
            }
        }
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            ((C0478ba) it2.next()).m1770l();
        }
        return listM1656a;
    }

    public String toString() {
        return "{Request:  session: " + this.f1082b + ", graphPath: " + this.f1084d + ", graphObject: " + this.f1085e + ", restMethod: " + this.f1086f + ", httpMethod: " + this.f1083c + ", parameters: " + this.f1090j + "}";
    }

    /* renamed from: a */
    static void m1592a(C0454ax c0454ax, List<C0456az> list) {
        int size = c0454ax.size();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < size; i++) {
            C0443am c0443amM1636a = c0454ax.get(i);
            if (c0443amM1636a.f1091k != null) {
                arrayList.add(new Pair(c0443amM1636a.f1091k, list.get(i)));
            }
        }
        if (arrayList.size() > 0) {
            RunnableC0446ap runnableC0446ap = new RunnableC0446ap(arrayList, c0454ax);
            Handler handlerM1645c = c0454ax.m1645c();
            if (handlerM1645c == null) {
                runnableC0446ap.run();
            } else {
                handlerM1645c.post(runnableC0446ap);
            }
        }
    }

    /* renamed from: a */
    static HttpURLConnection m1584a(URL url) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestProperty("User-Agent", m1611h());
        httpURLConnection.setRequestProperty("Content-Type", m1610g());
        httpURLConnection.setChunkedStreamingMode(0);
        return httpURLConnection;
    }

    /* renamed from: e */
    private void m1608e() {
        if (this.f1082b != null) {
            if (!this.f1082b.m1762b()) {
                throw new C0551y("Session provided to a Request in un-opened state.");
            }
            if (!this.f1090j.containsKey("access_token")) {
                String strM1765e = this.f1082b.m1765e();
                C0470m.m1690a(strM1765e);
                this.f1090j.putString("access_token", strM1765e);
            }
        }
        this.f1090j.putString("sdk", "android");
        this.f1090j.putString("format", Renren.RESPONSE_FORMAT_JSON);
    }

    /* renamed from: a */
    private String m1582a(String str) {
        Uri.Builder builderEncodedPath = new Uri.Builder().encodedPath(str);
        for (String str2 : this.f1090j.keySet()) {
            Object obj = this.f1090j.get(str2);
            if (obj == null) {
                obj = "";
            }
            if (!m1606d(obj)) {
                if (this.f1083c == EnumC0440aj.GET) {
                    throw new IllegalArgumentException(String.format("Unsupported parameter type for GET request: %s", obj.getClass().getSimpleName()));
                }
            } else {
                builderEncodedPath.appendQueryParameter(str2, m1607e(obj).toString());
            }
        }
        return builderEncodedPath.toString();
    }

    /* renamed from: c */
    final String m1618c() {
        String str;
        if (this.f1092l != null) {
            throw new C0551y("Can't override URL for a batch request");
        }
        if (this.f1086f != null) {
            str = "method/" + this.f1086f;
        } else {
            str = this.f1084d;
        }
        m1608e();
        return m1582a(str);
    }

    /* renamed from: d */
    final String m1619d() {
        String str;
        if (this.f1092l != null) {
            return this.f1092l.toString();
        }
        if (this.f1086f != null) {
            str = "https://api.facebook.com/method/" + this.f1086f;
        } else {
            str = "https://graph.facebook.com/" + this.f1084d;
        }
        m1608e();
        return m1582a(str);
    }

    /* renamed from: a */
    private void m1595a(JSONArray jSONArray, Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (this.f1087g != null) {
            jSONObject.put("name", this.f1087g);
            jSONObject.put("omit_response_on_success", this.f1089i);
        }
        if (this.f1088h != null) {
            jSONObject.put("depends_on", this.f1088h);
        }
        String strM1618c = m1618c();
        jSONObject.put("relative_url", strM1618c);
        jSONObject.put("method", this.f1083c);
        if (this.f1082b != null) {
            C0470m.m1690a(this.f1082b.m1765e());
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = this.f1090j.keySet().iterator();
        while (it.hasNext()) {
            Object obj = this.f1090j.get(it.next());
            if (m1604c(obj)) {
                String str = String.format("%s%d", "file", Integer.valueOf(bundle.size()));
                arrayList.add(str);
                C0476s.m1713a(bundle, str, obj);
            }
        }
        if (!arrayList.isEmpty()) {
            jSONObject.put("attached_files", TextUtils.join(",", arrayList));
        }
        if (this.f1085e != null) {
            ArrayList arrayList2 = new ArrayList();
            m1593a(this.f1085e, strM1618c, new C0447aq(this, arrayList2));
            jSONObject.put("body", TextUtils.join("&", arrayList2));
        }
        jSONArray.put(jSONObject);
    }

    /* renamed from: f */
    private void m1609f() {
        if (this.f1084d != null && this.f1086f != null) {
            throw new IllegalArgumentException("Only one of a graph path or REST method may be specified per request.");
        }
    }

    /* renamed from: a */
    static final void m1591a(C0454ax c0454ax, HttpURLConnection httpURLConnection) throws ProtocolException {
        C0470m c0470m = new C0470m(EnumC0441ak.REQUESTS, "Request");
        int size = c0454ax.size();
        EnumC0440aj enumC0440aj = size == 1 ? c0454ax.get(0).f1083c : EnumC0440aj.POST;
        httpURLConnection.setRequestMethod(enumC0440aj.name());
        URL url = httpURLConnection.getURL();
        c0470m.m1698c("Request:\n");
        c0470m.m1695a("Id", (Object) c0454ax.m1644b());
        c0470m.m1695a("URL", url);
        c0470m.m1695a("Method", (Object) httpURLConnection.getRequestMethod());
        c0470m.m1695a("User-Agent", (Object) httpURLConnection.getRequestProperty("User-Agent"));
        c0470m.m1695a("Content-Type", (Object) httpURLConnection.getRequestProperty("Content-Type"));
        httpURLConnection.setConnectTimeout(c0454ax.m1635a());
        httpURLConnection.setReadTimeout(c0454ax.m1635a());
        if (!(enumC0440aj == EnumC0440aj.POST)) {
            c0470m.m1694a();
            return;
        }
        httpURLConnection.setDoOutput(true);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
        try {
            C0452av c0452av = new C0452av(bufferedOutputStream, c0470m);
            if (size == 1) {
                C0443am c0443amM1636a = c0454ax.get(0);
                c0470m.m1698c("  Parameters:\n");
                m1589a(c0443amM1636a.f1090j, c0452av);
                c0470m.m1698c("  Attachments:\n");
                m1602b(c0443amM1636a.f1090j, c0452av);
                if (c0443amM1636a.f1085e != null) {
                    m1593a(c0443amM1636a.f1085e, url.getPath(), c0452av);
                }
            } else {
                String strM1605d = m1605d(c0454ax);
                if (C0476s.m1717a(strM1605d)) {
                    throw new C0551y("At least one request in a batch must have an open Session, or a default app ID must be specified.");
                }
                c0452av.mo1621a("batch_app_id", strM1605d);
                Bundle bundle = new Bundle();
                m1590a(c0452av, c0454ax, bundle);
                c0470m.m1698c("  Attachments:\n");
                m1602b(bundle, c0452av);
            }
            bufferedOutputStream.close();
            c0470m.m1694a();
        } catch (Throwable th) {
            bufferedOutputStream.close();
            throw th;
        }
    }

    /* renamed from: a */
    private static void m1593a(GraphObject graphObject, String str, InterfaceC0451au interfaceC0451au) {
        boolean z;
        if (str.startsWith("me/") || str.startsWith("/me/")) {
            int iIndexOf = str.indexOf(":");
            int iIndexOf2 = str.indexOf("?");
            z = iIndexOf > 3 && (iIndexOf2 == -1 || iIndexOf < iIndexOf2);
        } else {
            z = false;
        }
        for (Map.Entry<String, Object> entry : graphObject.asMap().entrySet()) {
            m1594a(entry.getKey(), entry.getValue(), interfaceC0451au, z && entry.getKey().equalsIgnoreCase(SlookAirButtonRecentMediaAdapter.IMAGE_TYPE));
        }
    }

    /* renamed from: a */
    private static void m1594a(String str, Object obj, InterfaceC0451au interfaceC0451au, boolean z) {
        Class<?> cls;
        Object obj2;
        Class<?> cls2 = obj.getClass();
        if (GraphObject.class.isAssignableFrom(cls2)) {
            JSONObject innerJSONObject = ((GraphObject) obj).getInnerJSONObject();
            cls = innerJSONObject.getClass();
            obj2 = innerJSONObject;
        } else if (GraphObjectList.class.isAssignableFrom(cls2)) {
            JSONArray innerJSONArray = ((GraphObjectList) obj).getInnerJSONArray();
            cls = innerJSONArray.getClass();
            obj2 = innerJSONArray;
        } else {
            cls = cls2;
            obj2 = obj;
        }
        if (JSONObject.class.isAssignableFrom(cls)) {
            JSONObject jSONObject = (JSONObject) obj2;
            if (z) {
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    m1594a(String.format("%s[%s]", str, next), jSONObject.opt(next), interfaceC0451au, z);
                }
                return;
            }
            if (jSONObject.has("id")) {
                m1594a(str, jSONObject.optString("id"), interfaceC0451au, z);
                return;
            } else {
                if (jSONObject.has("url")) {
                    m1594a(str, jSONObject.optString("url"), interfaceC0451au, z);
                    return;
                }
                return;
            }
        }
        if (JSONArray.class.isAssignableFrom(cls)) {
            JSONArray jSONArray = (JSONArray) obj2;
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                m1594a(String.format("%s[%d]", str, Integer.valueOf(i)), jSONArray.opt(i), interfaceC0451au, z);
            }
            return;
        }
        if (String.class.isAssignableFrom(cls) || Number.class.isAssignableFrom(cls) || Boolean.class.isAssignableFrom(cls)) {
            interfaceC0451au.mo1621a(str, obj2.toString());
        } else if (Date.class.isAssignableFrom(cls)) {
            interfaceC0451au.mo1621a(str, new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US).format((Date) obj2));
        }
    }

    /* renamed from: a */
    private static void m1589a(Bundle bundle, C0452av c0452av) {
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (m1606d(obj)) {
                c0452av.m1627a(str, obj);
            }
        }
    }

    /* renamed from: b */
    private static void m1602b(Bundle bundle, C0452av c0452av) {
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (m1604c(obj)) {
                c0452av.m1627a(str, obj);
            }
        }
    }

    /* renamed from: a */
    private static void m1590a(C0452av c0452av, Collection<C0443am> collection, Bundle bundle) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        Iterator<C0443am> it = collection.iterator();
        while (it.hasNext()) {
            it.next().m1595a(jSONArray, bundle);
        }
        c0452av.mo1621a("batch", jSONArray.toString());
    }

    /* renamed from: g */
    private static String m1610g() {
        return String.format("multipart/form-data; boundary=%s", "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f");
    }

    /* renamed from: h */
    private static String m1611h() {
        if (f1081m == null) {
            f1081m = String.format("%s.%s", "FBAndroidSDK", "3.0.0");
        }
        return f1081m;
    }

    /* renamed from: d */
    private static String m1605d(C0454ax c0454ax) {
        if (!C0476s.m1717a(c0454ax.m1648f())) {
            return c0454ax.m1648f();
        }
        Iterator<C0443am> it = c0454ax.iterator();
        while (it.hasNext()) {
            C0478ba c0478ba = it.next().f1082b;
            if (c0478ba != null) {
                return c0478ba.m1764d();
            }
        }
        return f1080a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static <T extends GraphObject> List<T> m1601b(C0456az c0456az, Class<T> cls) {
        GraphObjectList<GraphObject> data;
        GraphMultiResult graphMultiResult = (GraphMultiResult) c0456az.m1660a(GraphMultiResult.class);
        if (graphMultiResult != null && (data = graphMultiResult.getData()) != null) {
            return data.castToListOf(cls);
        }
        return null;
    }

    /* renamed from: c */
    private static boolean m1604c(Object obj) {
        return (obj instanceof Bitmap) || (obj instanceof byte[]) || (obj instanceof ParcelFileDescriptor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static boolean m1606d(Object obj) {
        return (obj instanceof String) || (obj instanceof Boolean) || (obj instanceof Number) || (obj instanceof Date);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public static String m1607e(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if ((obj instanceof Boolean) || (obj instanceof Number)) {
            return obj.toString();
        }
        if (obj instanceof Date) {
            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US).format(obj);
        }
        throw new IllegalArgumentException("Unsupported parameter type.");
    }
}
