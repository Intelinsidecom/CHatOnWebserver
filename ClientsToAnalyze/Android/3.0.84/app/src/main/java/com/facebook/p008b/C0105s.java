package com.facebook.p008b;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.facebook.C0180y;
import com.sec.spp.push.Config;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* compiled from: Utility.java */
/* renamed from: com.facebook.b.s */
/* loaded from: classes.dex */
public final class C0105s {
    /* renamed from: a */
    public static <T> boolean m275a(Collection<T> collection, Collection<T> collection2) {
        if (collection2 == null || collection2.size() == 0) {
            return collection == null || collection.size() == 0;
        }
        HashSet hashSet = new HashSet(collection2);
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            if (!hashSet.contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static <T> boolean m274a(Collection<T> collection) {
        return collection == null || collection.size() == 0;
    }

    /* renamed from: a */
    public static boolean m273a(String str) {
        return str == null || str.length() == 0;
    }

    /* renamed from: b */
    static String m276b(String str) throws NoSuchAlgorithmException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : bArrDigest) {
                sb.append(Integer.toHexString((b >> 4) & 15));
                sb.append(Integer.toHexString((b >> 0) & 15));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    /* renamed from: a */
    public static Uri m264a(String str, String str2, Bundle bundle) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https");
        builder.authority(str);
        builder.path(str2);
        for (String str3 : bundle.keySet()) {
            Object obj = bundle.get(str3);
            if (obj instanceof String) {
                builder.appendQueryParameter(str3, (String) obj);
            }
        }
        return builder.build();
    }

    /* renamed from: a */
    public static void m269a(Bundle bundle, String str, Object obj) {
        if (obj instanceof String) {
            bundle.putString(str, (String) obj);
        } else if (obj instanceof Parcelable) {
            bundle.putParcelable(str, (Parcelable) obj);
        } else {
            if (obj instanceof byte[]) {
                bundle.putByteArray(str, (byte[]) obj);
                return;
            }
            throw new C0180y("attempted to add unsupported type to Bundle");
        }
    }

    /* renamed from: a */
    public static void m270a(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    /* renamed from: a */
    public static void m272a(URLConnection uRLConnection) {
        if (uRLConnection instanceof HttpURLConnection) {
            ((HttpURLConnection) uRLConnection).disconnect();
        }
    }

    /* renamed from: a */
    public static Object m265a(JSONObject jSONObject, String str, String str2) throws JSONException {
        Object objOpt = jSONObject.opt(str);
        Object objNextValue = (objOpt == null || !(objOpt instanceof String)) ? objOpt : new JSONTokener((String) objOpt).nextValue();
        if (objNextValue == null || (objNextValue instanceof JSONObject) || (objNextValue instanceof JSONArray)) {
            return objNextValue;
        }
        if (str2 != null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt(str2, objNextValue);
            return jSONObject2;
        }
        throw new C0180y("Got an unexpected non-JSON object.");
    }

    /* renamed from: a */
    public static String m266a(InputStream inputStream) throws Throwable {
        InputStreamReader inputStreamReader;
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            bufferedInputStream = new BufferedInputStream(inputStream);
            try {
                inputStreamReader = new InputStreamReader(bufferedInputStream);
            } catch (Throwable th) {
                th = th;
                inputStreamReader = null;
                bufferedInputStream2 = bufferedInputStream;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStreamReader = null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            char[] cArr = new char[2048];
            while (true) {
                int i = inputStreamReader.read(cArr);
                if (i != -1) {
                    sb.append(cArr, 0, i);
                } else {
                    String string = sb.toString();
                    m270a((Closeable) bufferedInputStream);
                    m270a(inputStreamReader);
                    return string;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream2 = bufferedInputStream;
            m270a((Closeable) bufferedInputStream2);
            m270a(inputStreamReader);
            throw th;
        }
    }

    /* renamed from: a */
    private static void m268a(Context context, String str) {
        CookieSyncManager.createInstance(context).sync();
        CookieManager cookieManager = CookieManager.getInstance();
        String cookie = cookieManager.getCookie(str);
        if (cookie != null) {
            String[] strArrSplit = cookie.split(Config.KEYVALUE_SPLIT);
            for (String str2 : strArrSplit) {
                String[] strArrSplit2 = str2.split("=");
                if (strArrSplit2.length > 0) {
                    cookieManager.setCookie(str, strArrSplit2[0].trim() + "=;expires=Sat, 1 Jan 2000 00:00:01 UTC;");
                }
            }
            cookieManager.removeExpiredCookie();
        }
    }

    /* renamed from: a */
    public static void m267a(Context context) {
        m268a(context, "facebook.com");
        m268a(context, ".facebook.com");
        m268a(context, "https://facebook.com");
        m268a(context, "https://.facebook.com");
    }

    /* renamed from: a */
    public static void m271a(String str, String str2) {
    }
}
