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
import com.facebook.p008b.C0099m;
import com.facebook.p008b.C0105s;
import com.facebook.p008b.C0106t;
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
public class C0072am {

    /* renamed from: a */
    private static String f111a;

    /* renamed from: m */
    private static volatile String f112m;

    /* renamed from: b */
    private C0107ba f113b;

    /* renamed from: c */
    private EnumC0069aj f114c;

    /* renamed from: d */
    private String f115d;

    /* renamed from: e */
    private GraphObject f116e;

    /* renamed from: f */
    private String f117f;

    /* renamed from: g */
    private String f118g;

    /* renamed from: h */
    private String f119h;

    /* renamed from: i */
    private boolean f120i;

    /* renamed from: j */
    private Bundle f121j;

    /* renamed from: k */
    private InterfaceC0077ar f122k;

    /* renamed from: l */
    private String f123l;

    public C0072am() {
        this(null, null, null, null, null);
    }

    public C0072am(C0107ba c0107ba, String str, Bundle bundle, EnumC0069aj enumC0069aj, InterfaceC0077ar interfaceC0077ar) {
        this.f120i = true;
        this.f113b = c0107ba;
        this.f115d = str;
        this.f122k = interfaceC0077ar;
        m170a(enumC0069aj);
        if (bundle != null) {
            this.f121j = new Bundle(bundle);
        } else {
            this.f121j = new Bundle();
        }
        if (!this.f121j.containsKey("migration_bundle")) {
            this.f121j.putString("migration_bundle", "fbsdk:20121026");
        }
    }

    /* renamed from: a */
    public static C0072am m136a(C0107ba c0107ba, String str, GraphObject graphObject, InterfaceC0077ar interfaceC0077ar) {
        C0072am c0072am = new C0072am(c0107ba, str, null, EnumC0069aj.POST, interfaceC0077ar);
        c0072am.m172a(graphObject);
        return c0072am;
    }

    /* renamed from: a */
    public static C0072am m133a(C0107ba c0107ba, InterfaceC0078as interfaceC0078as) {
        return new C0072am(c0107ba, "me", null, null, new C0073an(interfaceC0078as));
    }

    /* renamed from: a */
    public static C0072am m134a(C0107ba c0107ba, InterfaceC0079at interfaceC0079at) {
        return new C0072am(c0107ba, "me/friends", null, null, new C0074ao(interfaceC0079at));
    }

    /* renamed from: a */
    public static C0072am m135a(C0107ba c0107ba, String str, InterfaceC0077ar interfaceC0077ar) {
        return new C0072am(c0107ba, str, null, null, interfaceC0077ar);
    }

    /* renamed from: a */
    public final void m172a(GraphObject graphObject) {
        this.f116e = graphObject;
    }

    /* renamed from: a */
    public final void m170a(EnumC0069aj enumC0069aj) {
        if (this.f123l != null && enumC0069aj != EnumC0069aj.GET) {
            throw new C0180y("Can't change HTTP method on request with overridden URL.");
        }
        if (enumC0069aj == null) {
            enumC0069aj = EnumC0069aj.GET;
        }
        this.f114c = enumC0069aj;
    }

    /* renamed from: a */
    public final void m169a(Bundle bundle) {
        this.f121j = bundle;
    }

    /* renamed from: a */
    public final C0107ba m168a() {
        return this.f113b;
    }

    /* renamed from: a */
    public final void m171a(InterfaceC0077ar interfaceC0077ar) {
        this.f122k = interfaceC0077ar;
    }

    /* renamed from: b */
    public final C0085az m173b() {
        return m137a(this);
    }

    /* renamed from: a */
    public static HttpURLConnection m139a(C0083ax c0083ax) {
        URL url;
        Iterator<C0072am> it = c0083ax.iterator();
        while (it.hasNext()) {
            it.next().m165f();
        }
        try {
            if (c0083ax.size() == 1) {
                url = new URL(c0083ax.get(0).m175d());
            } else {
                url = new URL("https://graph.facebook.com");
            }
            try {
                HttpURLConnection httpURLConnectionM140a = m140a(url);
                m147a(c0083ax, httpURLConnectionM140a);
                return httpURLConnectionM140a;
            } catch (IOException e) {
                throw new C0180y("could not construct request body", e);
            } catch (JSONException e2) {
                throw new C0180y("could not construct request body", e2);
            }
        } catch (MalformedURLException e3) {
            throw new C0180y("could not construct URL for request", e3);
        }
    }

    /* renamed from: a */
    public static C0085az m137a(C0072am c0072am) {
        List<C0085az> listM144a = m144a(c0072am);
        if (listM144a == null || listM144a.size() != 1) {
            throw new C0180y("invalid state: expected a single response");
        }
        return listM144a.get(0);
    }

    /* renamed from: a */
    public static List<C0085az> m144a(C0072am... c0072amArr) {
        C0106t.m277a(c0072amArr, "requests");
        return m143a((Collection<C0072am>) Arrays.asList(c0072amArr));
    }

    /* renamed from: a */
    public static List<C0085az> m143a(Collection<C0072am> collection) {
        return m156b(new C0083ax(collection));
    }

    /* renamed from: b */
    public static List<C0085az> m156b(C0083ax c0083ax) {
        C0106t.m281c(c0083ax, "requests");
        try {
            return m142a(m139a(c0083ax), c0083ax);
        } catch (Exception e) {
            List<C0085az> listM214a = C0085az.m214a(c0083ax.m202d(), null, new C0180y(e));
            m148a(c0083ax, listM214a);
            return listM214a;
        }
    }

    /* renamed from: b */
    public static AsyncTaskC0082aw m154b(C0072am... c0072amArr) {
        C0106t.m277a(c0072amArr, "requests");
        return m153b((Collection<C0072am>) Arrays.asList(c0072amArr));
    }

    /* renamed from: b */
    public static AsyncTaskC0082aw m153b(Collection<C0072am> collection) {
        return m159c(new C0083ax(collection));
    }

    /* renamed from: c */
    public static AsyncTaskC0082aw m159c(C0083ax c0083ax) {
        C0106t.m281c(c0083ax, "requests");
        AsyncTaskC0082aw asyncTaskC0082aw = new AsyncTaskC0082aw(c0083ax);
        asyncTaskC0082aw.m188a();
        return asyncTaskC0082aw;
    }

    /* renamed from: a */
    public static List<C0085az> m142a(HttpURLConnection httpURLConnection, C0083ax c0083ax) {
        List<C0085az> listM212a = C0085az.m212a(httpURLConnection, c0083ax);
        C0105s.m272a(httpURLConnection);
        int size = c0083ax.size();
        if (size != listM212a.size()) {
            throw new C0180y(String.format("Received %d responses while expecting %d", Integer.valueOf(listM212a.size()), Integer.valueOf(size)));
        }
        m148a(c0083ax, listM212a);
        HashSet hashSet = new HashSet();
        Iterator<C0072am> it = c0083ax.iterator();
        while (it.hasNext()) {
            C0072am next = it.next();
            if (next.f113b != null) {
                hashSet.add(next.f113b);
            }
        }
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            ((C0107ba) it2.next()).m327l();
        }
        return listM212a;
    }

    public String toString() {
        return "{Request:  session: " + this.f113b + ", graphPath: " + this.f115d + ", graphObject: " + this.f116e + ", restMethod: " + this.f117f + ", httpMethod: " + this.f114c + ", parameters: " + this.f121j + "}";
    }

    /* renamed from: a */
    static void m148a(C0083ax c0083ax, List<C0085az> list) {
        int size = c0083ax.size();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < size; i++) {
            C0072am c0072amM192a = c0083ax.get(i);
            if (c0072amM192a.f122k != null) {
                arrayList.add(new Pair(c0072amM192a.f122k, list.get(i)));
            }
        }
        if (arrayList.size() > 0) {
            RunnableC0075ap runnableC0075ap = new RunnableC0075ap(arrayList, c0083ax);
            Handler handlerM201c = c0083ax.m201c();
            if (handlerM201c == null) {
                runnableC0075ap.run();
            } else {
                handlerM201c.post(runnableC0075ap);
            }
        }
    }

    /* renamed from: a */
    static HttpURLConnection m140a(URL url) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestProperty("User-Agent", m167h());
        httpURLConnection.setRequestProperty("Content-Type", m166g());
        httpURLConnection.setChunkedStreamingMode(0);
        return httpURLConnection;
    }

    /* renamed from: e */
    private void m164e() {
        if (this.f113b != null) {
            if (!this.f113b.m319b()) {
                throw new C0180y("Session provided to a Request in un-opened state.");
            }
            if (!this.f121j.containsKey("access_token")) {
                String strM322e = this.f113b.m322e();
                C0099m.m246a(strM322e);
                this.f121j.putString("access_token", strM322e);
            }
        }
        this.f121j.putString("sdk", "android");
        this.f121j.putString("format", Renren.RESPONSE_FORMAT_JSON);
    }

    /* renamed from: a */
    private String m138a(String str) {
        Uri.Builder builderEncodedPath = new Uri.Builder().encodedPath(str);
        for (String str2 : this.f121j.keySet()) {
            Object obj = this.f121j.get(str2);
            if (obj == null) {
                obj = "";
            }
            if (!m162d(obj)) {
                if (this.f114c == EnumC0069aj.GET) {
                    throw new IllegalArgumentException(String.format("Unsupported parameter type for GET request: %s", obj.getClass().getSimpleName()));
                }
            } else {
                builderEncodedPath.appendQueryParameter(str2, m163e(obj).toString());
            }
        }
        return builderEncodedPath.toString();
    }

    /* renamed from: c */
    final String m174c() {
        String str;
        if (this.f123l != null) {
            throw new C0180y("Can't override URL for a batch request");
        }
        if (this.f117f != null) {
            str = "method/" + this.f117f;
        } else {
            str = this.f115d;
        }
        m164e();
        return m138a(str);
    }

    /* renamed from: d */
    final String m175d() {
        String str;
        if (this.f123l != null) {
            return this.f123l.toString();
        }
        if (this.f117f != null) {
            str = "https://api.facebook.com/method/" + this.f117f;
        } else {
            str = "https://graph.facebook.com/" + this.f115d;
        }
        m164e();
        return m138a(str);
    }

    /* renamed from: a */
    private void m151a(JSONArray jSONArray, Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (this.f118g != null) {
            jSONObject.put("name", this.f118g);
            jSONObject.put("omit_response_on_success", this.f120i);
        }
        if (this.f119h != null) {
            jSONObject.put("depends_on", this.f119h);
        }
        String strM174c = m174c();
        jSONObject.put("relative_url", strM174c);
        jSONObject.put("method", this.f114c);
        if (this.f113b != null) {
            C0099m.m246a(this.f113b.m322e());
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = this.f121j.keySet().iterator();
        while (it.hasNext()) {
            Object obj = this.f121j.get(it.next());
            if (m160c(obj)) {
                String str = String.format("%s%d", "file", Integer.valueOf(bundle.size()));
                arrayList.add(str);
                C0105s.m269a(bundle, str, obj);
            }
        }
        if (!arrayList.isEmpty()) {
            jSONObject.put("attached_files", TextUtils.join(",", arrayList));
        }
        if (this.f116e != null) {
            ArrayList arrayList2 = new ArrayList();
            m149a(this.f116e, strM174c, new C0076aq(this, arrayList2));
            jSONObject.put("body", TextUtils.join("&", arrayList2));
        }
        jSONArray.put(jSONObject);
    }

    /* renamed from: f */
    private void m165f() {
        if (this.f115d != null && this.f117f != null) {
            throw new IllegalArgumentException("Only one of a graph path or REST method may be specified per request.");
        }
    }

    /* renamed from: a */
    static final void m147a(C0083ax c0083ax, HttpURLConnection httpURLConnection) throws ProtocolException {
        C0099m c0099m = new C0099m(EnumC0070ak.REQUESTS, "Request");
        int size = c0083ax.size();
        EnumC0069aj enumC0069aj = size == 1 ? c0083ax.get(0).f114c : EnumC0069aj.POST;
        httpURLConnection.setRequestMethod(enumC0069aj.name());
        URL url = httpURLConnection.getURL();
        c0099m.m254c("Request:\n");
        c0099m.m251a("Id", (Object) c0083ax.m200b());
        c0099m.m251a("URL", url);
        c0099m.m251a("Method", (Object) httpURLConnection.getRequestMethod());
        c0099m.m251a("User-Agent", (Object) httpURLConnection.getRequestProperty("User-Agent"));
        c0099m.m251a("Content-Type", (Object) httpURLConnection.getRequestProperty("Content-Type"));
        httpURLConnection.setConnectTimeout(c0083ax.m191a());
        httpURLConnection.setReadTimeout(c0083ax.m191a());
        if (!(enumC0069aj == EnumC0069aj.POST)) {
            c0099m.m250a();
            return;
        }
        httpURLConnection.setDoOutput(true);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
        try {
            C0081av c0081av = new C0081av(bufferedOutputStream, c0099m);
            if (size == 1) {
                C0072am c0072amM192a = c0083ax.get(0);
                c0099m.m254c("  Parameters:\n");
                m145a(c0072amM192a.f121j, c0081av);
                c0099m.m254c("  Attachments:\n");
                m158b(c0072amM192a.f121j, c0081av);
                if (c0072amM192a.f116e != null) {
                    m149a(c0072amM192a.f116e, url.getPath(), c0081av);
                }
            } else {
                String strM161d = m161d(c0083ax);
                if (C0105s.m273a(strM161d)) {
                    throw new C0180y("At least one request in a batch must have an open Session, or a default app ID must be specified.");
                }
                c0081av.mo177a("batch_app_id", strM161d);
                Bundle bundle = new Bundle();
                m146a(c0081av, c0083ax, bundle);
                c0099m.m254c("  Attachments:\n");
                m158b(bundle, c0081av);
            }
            bufferedOutputStream.close();
            c0099m.m250a();
        } catch (Throwable th) {
            bufferedOutputStream.close();
            throw th;
        }
    }

    /* renamed from: a */
    private static void m149a(GraphObject graphObject, String str, InterfaceC0080au interfaceC0080au) {
        boolean z;
        if (str.startsWith("me/") || str.startsWith("/me/")) {
            int iIndexOf = str.indexOf(":");
            int iIndexOf2 = str.indexOf("?");
            z = iIndexOf > 3 && (iIndexOf2 == -1 || iIndexOf < iIndexOf2);
        } else {
            z = false;
        }
        for (Map.Entry<String, Object> entry : graphObject.asMap().entrySet()) {
            m150a(entry.getKey(), entry.getValue(), interfaceC0080au, z && entry.getKey().equalsIgnoreCase(SlookAirButtonRecentMediaAdapter.IMAGE_TYPE));
        }
    }

    /* renamed from: a */
    private static void m150a(String str, Object obj, InterfaceC0080au interfaceC0080au, boolean z) {
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
                    m150a(String.format("%s[%s]", str, next), jSONObject.opt(next), interfaceC0080au, z);
                }
                return;
            }
            if (jSONObject.has("id")) {
                m150a(str, jSONObject.optString("id"), interfaceC0080au, z);
                return;
            } else {
                if (jSONObject.has("url")) {
                    m150a(str, jSONObject.optString("url"), interfaceC0080au, z);
                    return;
                }
                return;
            }
        }
        if (JSONArray.class.isAssignableFrom(cls)) {
            JSONArray jSONArray = (JSONArray) obj2;
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                m150a(String.format("%s[%d]", str, Integer.valueOf(i)), jSONArray.opt(i), interfaceC0080au, z);
            }
            return;
        }
        if (String.class.isAssignableFrom(cls) || Number.class.isAssignableFrom(cls) || Boolean.class.isAssignableFrom(cls)) {
            interfaceC0080au.mo177a(str, obj2.toString());
        } else if (Date.class.isAssignableFrom(cls)) {
            interfaceC0080au.mo177a(str, new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US).format((Date) obj2));
        }
    }

    /* renamed from: a */
    private static void m145a(Bundle bundle, C0081av c0081av) {
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (m162d(obj)) {
                c0081av.m183a(str, obj);
            }
        }
    }

    /* renamed from: b */
    private static void m158b(Bundle bundle, C0081av c0081av) {
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (m160c(obj)) {
                c0081av.m183a(str, obj);
            }
        }
    }

    /* renamed from: a */
    private static void m146a(C0081av c0081av, Collection<C0072am> collection, Bundle bundle) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        Iterator<C0072am> it = collection.iterator();
        while (it.hasNext()) {
            it.next().m151a(jSONArray, bundle);
        }
        c0081av.mo177a("batch", jSONArray.toString());
    }

    /* renamed from: g */
    private static String m166g() {
        return String.format("multipart/form-data; boundary=%s", "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f");
    }

    /* renamed from: h */
    private static String m167h() {
        if (f112m == null) {
            f112m = String.format("%s.%s", "FBAndroidSDK", "3.0.0");
        }
        return f112m;
    }

    /* renamed from: d */
    private static String m161d(C0083ax c0083ax) {
        if (!C0105s.m273a(c0083ax.m204f())) {
            return c0083ax.m204f();
        }
        Iterator<C0072am> it = c0083ax.iterator();
        while (it.hasNext()) {
            C0107ba c0107ba = it.next().f113b;
            if (c0107ba != null) {
                return c0107ba.m321d();
            }
        }
        return f111a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static <T extends GraphObject> List<T> m157b(C0085az c0085az, Class<T> cls) {
        GraphObjectList<GraphObject> data;
        GraphMultiResult graphMultiResult = (GraphMultiResult) c0085az.m216a(GraphMultiResult.class);
        if (graphMultiResult != null && (data = graphMultiResult.getData()) != null) {
            return data.castToListOf(cls);
        }
        return null;
    }

    /* renamed from: c */
    private static boolean m160c(Object obj) {
        return (obj instanceof Bitmap) || (obj instanceof byte[]) || (obj instanceof ParcelFileDescriptor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static boolean m162d(Object obj) {
        return (obj instanceof String) || (obj instanceof Boolean) || (obj instanceof Number) || (obj instanceof Date);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public static String m163e(Object obj) {
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
