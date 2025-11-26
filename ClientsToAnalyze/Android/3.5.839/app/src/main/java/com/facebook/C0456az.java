package com.facebook;

import com.facebook.model.GraphObject;
import com.facebook.model.GraphObjectList;
import com.facebook.p032b.C0470m;
import com.facebook.p032b.C0476s;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* compiled from: Response.java */
/* renamed from: com.facebook.az */
/* loaded from: classes.dex */
public class C0456az {

    /* renamed from: a */
    static final /* synthetic */ boolean f1114a;

    /* renamed from: b */
    private final HttpURLConnection f1115b;

    /* renamed from: c */
    private final GraphObject f1116c;

    /* renamed from: d */
    private final GraphObjectList<GraphObject> f1117d;

    /* renamed from: e */
    private final boolean f1118e;

    /* renamed from: f */
    private final C0432ab f1119f;

    /* renamed from: g */
    private final C0443am f1120g;

    static {
        f1114a = !C0456az.class.desiredAssertionStatus();
    }

    C0456az(C0443am c0443am, HttpURLConnection httpURLConnection, GraphObject graphObject, boolean z) {
        this.f1120g = c0443am;
        this.f1115b = httpURLConnection;
        this.f1116c = graphObject;
        this.f1117d = null;
        this.f1118e = z;
        this.f1119f = null;
    }

    C0456az(C0443am c0443am, HttpURLConnection httpURLConnection, GraphObjectList<GraphObject> graphObjectList, boolean z) {
        this.f1120g = c0443am;
        this.f1115b = httpURLConnection;
        this.f1116c = null;
        this.f1117d = graphObjectList;
        this.f1118e = z;
        this.f1119f = null;
    }

    C0456az(C0443am c0443am, HttpURLConnection httpURLConnection, C0432ab c0432ab) {
        this.f1120g = c0443am;
        this.f1115b = httpURLConnection;
        this.f1116c = null;
        this.f1117d = null;
        this.f1118e = false;
        this.f1119f = c0432ab;
    }

    /* renamed from: a */
    public final C0432ab m1659a() {
        return this.f1119f;
    }

    /* renamed from: b */
    public final GraphObject m1661b() {
        return this.f1116c;
    }

    /* renamed from: a */
    public final <T extends GraphObject> T m1660a(Class<T> cls) {
        if (this.f1116c == null) {
            return null;
        }
        if (cls == null) {
            throw new NullPointerException("Must pass in a valid interface that extends GraphObject");
        }
        return (T) this.f1116c.cast(cls);
    }

    /* renamed from: c */
    public C0443am m1662c() {
        return this.f1120g;
    }

    public String toString() {
        String str;
        try {
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(this.f1115b != null ? this.f1115b.getResponseCode() : 200);
            str = String.format("%d", objArr);
        } catch (IOException e) {
            str = "unknown";
        }
        return "{Response:  responseCode: " + str + ", graphObject: " + this.f1116c + ", error: " + this.f1119f + ", isFromCache:" + this.f1118e + "}";
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0029  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static java.util.List<com.facebook.C0456az> m1656a(java.net.HttpURLConnection r7, com.facebook.C0454ax r8) {
        /*
            r1 = 0
            r0 = 0
            r3 = 0
            int r2 = r7.getResponseCode()     // Catch: com.facebook.C0551y -> L2b org.json.JSONException -> L45 java.io.IOException -> L64 java.lang.Throwable -> L83
            r4 = 400(0x190, float:5.6E-43)
            if (r2 < r4) goto L19
            java.io.InputStream r2 = r7.getErrorStream()     // Catch: com.facebook.C0551y -> L2b org.json.JSONException -> L45 java.io.IOException -> L64 java.lang.Throwable -> L83
            r1 = r2
        L10:
            r0 = 0
            java.util.List r0 = m1655a(r1, r7, r8, r0)     // Catch: com.facebook.C0551y -> L2b org.json.JSONException -> L45 java.io.IOException -> L64 java.lang.Throwable -> L83
            com.facebook.p032b.C0476s.m1714a(r1)
        L18:
            return r0
        L19:
            java.io.InputStream r2 = r7.getInputStream()     // Catch: com.facebook.C0551y -> L2b org.json.JSONException -> L45 java.io.IOException -> L64 java.lang.Throwable -> L83
            if (r1 == 0) goto L29
            if (r1 == 0) goto L29
            if (r2 == 0) goto L29
            java.io.InputStream r1 = r0.m1671a(r3, r2)     // Catch: java.lang.Throwable -> L88 java.io.IOException -> L8b org.json.JSONException -> L8e com.facebook.C0551y -> L91
            if (r1 != 0) goto L10
        L29:
            r1 = r2
            goto L10
        L2b:
            r0 = move-exception
        L2c:
            com.facebook.ak r2 = com.facebook.EnumC0441ak.REQUESTS     // Catch: java.lang.Throwable -> L83
            java.lang.String r3 = "Response"
            java.lang.String r4 = "Response <Error>: %s"
            r5 = 1
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> L83
            r6 = 0
            r5[r6] = r0     // Catch: java.lang.Throwable -> L83
            com.facebook.p032b.C0470m.m1689a(r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L83
            java.util.List r0 = m1658a(r8, r7, r0)     // Catch: java.lang.Throwable -> L83
            com.facebook.p032b.C0476s.m1714a(r1)
            goto L18
        L45:
            r0 = move-exception
        L46:
            com.facebook.ak r2 = com.facebook.EnumC0441ak.REQUESTS     // Catch: java.lang.Throwable -> L83
            java.lang.String r3 = "Response"
            java.lang.String r4 = "Response <Error>: %s"
            r5 = 1
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> L83
            r6 = 0
            r5[r6] = r0     // Catch: java.lang.Throwable -> L83
            com.facebook.p032b.C0470m.m1689a(r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L83
            com.facebook.y r2 = new com.facebook.y     // Catch: java.lang.Throwable -> L83
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L83
            java.util.List r0 = m1658a(r8, r7, r2)     // Catch: java.lang.Throwable -> L83
            com.facebook.p032b.C0476s.m1714a(r1)
            goto L18
        L64:
            r0 = move-exception
        L65:
            com.facebook.ak r2 = com.facebook.EnumC0441ak.REQUESTS     // Catch: java.lang.Throwable -> L83
            java.lang.String r3 = "Response"
            java.lang.String r4 = "Response <Error>: %s"
            r5 = 1
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> L83
            r6 = 0
            r5[r6] = r0     // Catch: java.lang.Throwable -> L83
            com.facebook.p032b.C0470m.m1689a(r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L83
            com.facebook.y r2 = new com.facebook.y     // Catch: java.lang.Throwable -> L83
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L83
            java.util.List r0 = m1658a(r8, r7, r2)     // Catch: java.lang.Throwable -> L83
            com.facebook.p032b.C0476s.m1714a(r1)
            goto L18
        L83:
            r0 = move-exception
        L84:
            com.facebook.p032b.C0476s.m1714a(r1)
            throw r0
        L88:
            r0 = move-exception
            r1 = r2
            goto L84
        L8b:
            r0 = move-exception
            r1 = r2
            goto L65
        L8e:
            r0 = move-exception
            r1 = r2
            goto L46
        L91:
            r0 = move-exception
            r1 = r2
            goto L2c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.C0456az.m1656a(java.net.HttpURLConnection, com.facebook.ax):java.util.List");
    }

    /* renamed from: a */
    static List<C0456az> m1655a(InputStream inputStream, HttpURLConnection httpURLConnection, C0454ax c0454ax, boolean z) throws Throwable {
        String strM1710a = C0476s.m1710a(inputStream);
        C0470m.m1689a(EnumC0441ak.INCLUDE_RAW_RESPONSES, "Response", "Response (raw)\n  Size: %d\n  Response:\n%s\n", Integer.valueOf(strM1710a.length()), strM1710a);
        List<C0456az> listM1657a = m1657a(httpURLConnection, c0454ax, new JSONTokener(strM1710a).nextValue(), z);
        C0470m.m1689a(EnumC0441ak.REQUESTS, "Response", "Response\n  Id: %s\n  Size: %d\n  Responses:\n%s\n", c0454ax.m1644b(), Integer.valueOf(strM1710a.length()), listM1657a);
        return listM1657a;
    }

    /* renamed from: a */
    private static List<C0456az> m1657a(HttpURLConnection httpURLConnection, List<C0443am> list, Object obj, boolean z) throws JSONException {
        Object obj2;
        if (!f1114a && httpURLConnection == null && !z) {
            throw new AssertionError();
        }
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        if (size == 1) {
            C0443am c0443am = list.get(0);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("body", obj);
                jSONObject.put("code", httpURLConnection != null ? httpURLConnection.getResponseCode() : 200);
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                obj2 = jSONArray;
            } catch (IOException e) {
                arrayList.add(new C0456az(c0443am, httpURLConnection, new C0432ab(httpURLConnection, e)));
            } catch (JSONException e2) {
                arrayList.add(new C0456az(c0443am, httpURLConnection, new C0432ab(httpURLConnection, e2)));
                obj2 = obj;
            }
        } else {
            obj2 = obj;
        }
        if (!(obj2 instanceof JSONArray) || ((JSONArray) obj2).length() != size) {
            throw new C0551y("Unexpected number of results");
        }
        JSONArray jSONArray2 = (JSONArray) obj2;
        for (int i = 0; i < jSONArray2.length(); i++) {
            C0443am c0443am2 = list.get(i);
            try {
                arrayList.add(m1654a(c0443am2, httpURLConnection, jSONArray2.get(i), z, obj));
            } catch (C0551y e3) {
                arrayList.add(new C0456az(c0443am2, httpURLConnection, new C0432ab(httpURLConnection, e3)));
            } catch (JSONException e4) {
                arrayList.add(new C0456az(c0443am2, httpURLConnection, new C0432ab(httpURLConnection, e4)));
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private static C0456az m1654a(C0443am c0443am, HttpURLConnection httpURLConnection, Object obj, boolean z, Object obj2) throws JSONException {
        C0478ba c0478baM1612a;
        if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            C0432ab c0432abM1554a = C0432ab.m1554a(jSONObject, obj2, httpURLConnection);
            if (c0432abM1554a != null) {
                if (c0432abM1554a.m1557c() == 190 && (c0478baM1612a = c0443am.m1612a()) != null) {
                    c0478baM1612a.m1769i();
                }
                return new C0456az(c0443am, httpURLConnection, c0432abM1554a);
            }
            Object objM1709a = C0476s.m1709a(jSONObject, "body", "FACEBOOK_NON_JSON_RESULT");
            if (objM1709a instanceof JSONObject) {
                return new C0456az(c0443am, httpURLConnection, GraphObject.Factory.create((JSONObject) objM1709a), z);
            }
            if (objM1709a instanceof JSONArray) {
                return new C0456az(c0443am, httpURLConnection, (GraphObjectList<GraphObject>) GraphObject.Factory.createList((JSONArray) objM1709a, GraphObject.class), z);
            }
            obj = JSONObject.NULL;
        }
        if (obj == JSONObject.NULL) {
            return new C0456az(c0443am, httpURLConnection, (GraphObject) null, z);
        }
        throw new C0551y("Got unexpected object type in response, class: " + obj.getClass().getSimpleName());
    }

    /* renamed from: a */
    static List<C0456az> m1658a(List<C0443am> list, HttpURLConnection httpURLConnection, C0551y c0551y) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new C0456az(list.get(i), httpURLConnection, new C0432ab(httpURLConnection, c0551y)));
        }
        return arrayList;
    }
}
