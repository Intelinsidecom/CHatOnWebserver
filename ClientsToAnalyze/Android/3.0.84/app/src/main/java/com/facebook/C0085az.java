package com.facebook;

import com.facebook.model.GraphObject;
import com.facebook.model.GraphObjectList;
import com.facebook.p008b.C0099m;
import com.facebook.p008b.C0105s;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import twitter4j.internal.http.HttpResponseCode;

/* compiled from: Response.java */
/* renamed from: com.facebook.az */
/* loaded from: classes.dex */
public class C0085az {

    /* renamed from: a */
    static final /* synthetic */ boolean f145a;

    /* renamed from: b */
    private final HttpURLConnection f146b;

    /* renamed from: c */
    private final GraphObject f147c;

    /* renamed from: d */
    private final GraphObjectList<GraphObject> f148d;

    /* renamed from: e */
    private final boolean f149e;

    /* renamed from: f */
    private final C0061ab f150f;

    /* renamed from: g */
    private final C0072am f151g;

    static {
        f145a = !C0085az.class.desiredAssertionStatus();
    }

    C0085az(C0072am c0072am, HttpURLConnection httpURLConnection, GraphObject graphObject, boolean z) {
        this.f151g = c0072am;
        this.f146b = httpURLConnection;
        this.f147c = graphObject;
        this.f148d = null;
        this.f149e = z;
        this.f150f = null;
    }

    C0085az(C0072am c0072am, HttpURLConnection httpURLConnection, GraphObjectList<GraphObject> graphObjectList, boolean z) {
        this.f151g = c0072am;
        this.f146b = httpURLConnection;
        this.f147c = null;
        this.f148d = graphObjectList;
        this.f149e = z;
        this.f150f = null;
    }

    C0085az(C0072am c0072am, HttpURLConnection httpURLConnection, C0061ab c0061ab) {
        this.f151g = c0072am;
        this.f146b = httpURLConnection;
        this.f147c = null;
        this.f148d = null;
        this.f149e = false;
        this.f150f = c0061ab;
    }

    /* renamed from: a */
    public final C0061ab m215a() {
        return this.f150f;
    }

    /* renamed from: b */
    public final GraphObject m217b() {
        return this.f147c;
    }

    /* renamed from: a */
    public final <T extends GraphObject> T m216a(Class<T> cls) {
        if (this.f147c == null) {
            return null;
        }
        if (cls == null) {
            throw new NullPointerException("Must pass in a valid interface that extends GraphObject");
        }
        return (T) this.f147c.cast(cls);
    }

    /* renamed from: c */
    public C0072am m218c() {
        return this.f151g;
    }

    public String toString() {
        String str;
        try {
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(this.f146b != null ? this.f146b.getResponseCode() : HttpResponseCode.f13733OK);
            str = String.format("%d", objArr);
        } catch (IOException e) {
            str = "unknown";
        }
        return "{Response:  responseCode: " + str + ", graphObject: " + this.f147c + ", error: " + this.f150f + ", isFromCache:" + this.f149e + "}";
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0029  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static java.util.List<com.facebook.C0085az> m212a(java.net.HttpURLConnection r7, com.facebook.C0083ax r8) {
        /*
            r1 = 0
            r0 = 0
            r3 = 0
            int r2 = r7.getResponseCode()     // Catch: com.facebook.C0180y -> L2b org.json.JSONException -> L43 java.io.IOException -> L60 java.lang.Throwable -> L7d
            r4 = 400(0x190, float:5.6E-43)
            if (r2 < r4) goto L19
            java.io.InputStream r2 = r7.getErrorStream()     // Catch: com.facebook.C0180y -> L2b org.json.JSONException -> L43 java.io.IOException -> L60 java.lang.Throwable -> L7d
            r1 = r2
        L10:
            r0 = 0
            java.util.List r0 = m211a(r1, r7, r8, r0)     // Catch: com.facebook.C0180y -> L2b org.json.JSONException -> L43 java.io.IOException -> L60 java.lang.Throwable -> L7d
            com.facebook.p008b.C0105s.m270a(r1)
        L18:
            return r0
        L19:
            java.io.InputStream r2 = r7.getInputStream()     // Catch: com.facebook.C0180y -> L2b org.json.JSONException -> L43 java.io.IOException -> L60 java.lang.Throwable -> L7d
            if (r1 == 0) goto L29
            if (r1 == 0) goto L29
            if (r2 == 0) goto L29
            java.io.InputStream r1 = r0.m227a(r3, r2)     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L85 org.json.JSONException -> L88 com.facebook.C0180y -> L8b
            if (r1 != 0) goto L10
        L29:
            r1 = r2
            goto L10
        L2b:
            r0 = move-exception
        L2c:
            com.facebook.ak r2 = com.facebook.EnumC0070ak.REQUESTS     // Catch: java.lang.Throwable -> L7d
            java.lang.String r3 = "Response"
            java.lang.String r4 = "Response <Error>: %s"
            r5 = 1
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> L7d
            r6 = 0
            r5[r6] = r0     // Catch: java.lang.Throwable -> L7d
            com.facebook.p008b.C0099m.m245a(r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L7d
            java.util.List r0 = m214a(r8, r7, r0)     // Catch: java.lang.Throwable -> L7d
            com.facebook.p008b.C0105s.m270a(r1)
            goto L18
        L43:
            r0 = move-exception
        L44:
            com.facebook.ak r2 = com.facebook.EnumC0070ak.REQUESTS     // Catch: java.lang.Throwable -> L7d
            java.lang.String r3 = "Response"
            java.lang.String r4 = "Response <Error>: %s"
            r5 = 1
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> L7d
            r6 = 0
            r5[r6] = r0     // Catch: java.lang.Throwable -> L7d
            com.facebook.p008b.C0099m.m245a(r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L7d
            com.facebook.y r2 = new com.facebook.y     // Catch: java.lang.Throwable -> L7d
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L7d
            java.util.List r0 = m214a(r8, r7, r2)     // Catch: java.lang.Throwable -> L7d
            com.facebook.p008b.C0105s.m270a(r1)
            goto L18
        L60:
            r0 = move-exception
        L61:
            com.facebook.ak r2 = com.facebook.EnumC0070ak.REQUESTS     // Catch: java.lang.Throwable -> L7d
            java.lang.String r3 = "Response"
            java.lang.String r4 = "Response <Error>: %s"
            r5 = 1
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> L7d
            r6 = 0
            r5[r6] = r0     // Catch: java.lang.Throwable -> L7d
            com.facebook.p008b.C0099m.m245a(r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L7d
            com.facebook.y r2 = new com.facebook.y     // Catch: java.lang.Throwable -> L7d
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L7d
            java.util.List r0 = m214a(r8, r7, r2)     // Catch: java.lang.Throwable -> L7d
            com.facebook.p008b.C0105s.m270a(r1)
            goto L18
        L7d:
            r0 = move-exception
        L7e:
            com.facebook.p008b.C0105s.m270a(r1)
            throw r0
        L82:
            r0 = move-exception
            r1 = r2
            goto L7e
        L85:
            r0 = move-exception
            r1 = r2
            goto L61
        L88:
            r0 = move-exception
            r1 = r2
            goto L44
        L8b:
            r0 = move-exception
            r1 = r2
            goto L2c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.C0085az.m212a(java.net.HttpURLConnection, com.facebook.ax):java.util.List");
    }

    /* renamed from: a */
    static List<C0085az> m211a(InputStream inputStream, HttpURLConnection httpURLConnection, C0083ax c0083ax, boolean z) throws Throwable {
        String strM266a = C0105s.m266a(inputStream);
        C0099m.m245a(EnumC0070ak.INCLUDE_RAW_RESPONSES, "Response", "Response (raw)\n  Size: %d\n  Response:\n%s\n", Integer.valueOf(strM266a.length()), strM266a);
        List<C0085az> listM213a = m213a(httpURLConnection, c0083ax, new JSONTokener(strM266a).nextValue(), z);
        C0099m.m245a(EnumC0070ak.REQUESTS, "Response", "Response\n  Id: %s\n  Size: %d\n  Responses:\n%s\n", c0083ax.m200b(), Integer.valueOf(strM266a.length()), listM213a);
        return listM213a;
    }

    /* renamed from: a */
    private static List<C0085az> m213a(HttpURLConnection httpURLConnection, List<C0072am> list, Object obj, boolean z) throws JSONException {
        Object obj2;
        if (!f145a && httpURLConnection == null && !z) {
            throw new AssertionError();
        }
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        if (size == 1) {
            C0072am c0072am = list.get(0);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("body", obj);
                jSONObject.put("code", httpURLConnection != null ? httpURLConnection.getResponseCode() : HttpResponseCode.f13733OK);
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                obj2 = jSONArray;
            } catch (IOException e) {
                arrayList.add(new C0085az(c0072am, httpURLConnection, new C0061ab(httpURLConnection, e)));
            } catch (JSONException e2) {
                arrayList.add(new C0085az(c0072am, httpURLConnection, new C0061ab(httpURLConnection, e2)));
                obj2 = obj;
            }
        } else {
            obj2 = obj;
        }
        if (!(obj2 instanceof JSONArray) || ((JSONArray) obj2).length() != size) {
            throw new C0180y("Unexpected number of results");
        }
        JSONArray jSONArray2 = (JSONArray) obj2;
        for (int i = 0; i < jSONArray2.length(); i++) {
            C0072am c0072am2 = list.get(i);
            try {
                arrayList.add(m210a(c0072am2, httpURLConnection, jSONArray2.get(i), z, obj));
            } catch (C0180y e3) {
                arrayList.add(new C0085az(c0072am2, httpURLConnection, new C0061ab(httpURLConnection, e3)));
            } catch (JSONException e4) {
                arrayList.add(new C0085az(c0072am2, httpURLConnection, new C0061ab(httpURLConnection, e4)));
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private static C0085az m210a(C0072am c0072am, HttpURLConnection httpURLConnection, Object obj, boolean z, Object obj2) throws JSONException {
        C0107ba c0107baM168a;
        if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            C0061ab c0061abM111a = C0061ab.m111a(jSONObject, obj2, httpURLConnection);
            if (c0061abM111a != null) {
                if (c0061abM111a.m113b() == 190 && (c0107baM168a = c0072am.m168a()) != null) {
                    c0107baM168a.m326i();
                }
                return new C0085az(c0072am, httpURLConnection, c0061abM111a);
            }
            Object objM265a = C0105s.m265a(jSONObject, "body", "FACEBOOK_NON_JSON_RESULT");
            if (objM265a instanceof JSONObject) {
                return new C0085az(c0072am, httpURLConnection, GraphObject.Factory.create((JSONObject) objM265a), z);
            }
            if (objM265a instanceof JSONArray) {
                return new C0085az(c0072am, httpURLConnection, (GraphObjectList<GraphObject>) GraphObject.Factory.createList((JSONArray) objM265a, GraphObject.class), z);
            }
            obj = JSONObject.NULL;
        }
        if (obj == JSONObject.NULL) {
            return new C0085az(c0072am, httpURLConnection, (GraphObject) null, z);
        }
        throw new C0180y("Got unexpected object type in response, class: " + obj.getClass().getSimpleName());
    }

    /* renamed from: a */
    static List<C0085az> m214a(List<C0072am> list, HttpURLConnection httpURLConnection, C0180y c0180y) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new C0085az(list.get(i), httpURLConnection, new C0061ab(httpURLConnection, c0180y)));
        }
        return arrayList;
    }
}
