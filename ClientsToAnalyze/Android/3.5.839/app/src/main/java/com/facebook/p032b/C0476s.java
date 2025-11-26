package com.facebook.p032b;

import android.content.Context;
import android.hardware.motion.MotionRecognitionManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.facebook.C0551y;
import com.p137vk.sdk.api.VKApiConst;
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
public final class C0476s {
    /* renamed from: a */
    public static <T> boolean m1719a(Collection<T> collection, Collection<T> collection2) {
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
    public static <T> boolean m1718a(Collection<T> collection) {
        return collection == null || collection.size() == 0;
    }

    /* renamed from: a */
    public static boolean m1717a(String str) {
        return str == null || str.length() == 0;
    }

    /* renamed from: b */
    static String m1720b(String str) throws NoSuchAlgorithmException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b2 : bArrDigest) {
                sb.append(Integer.toHexString((b2 >> 4) & 15));
                sb.append(Integer.toHexString((b2 >> 0) & 15));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    /* renamed from: a */
    public static Uri m1708a(String str, String str2, Bundle bundle) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(VKApiConst.HTTPS);
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
    public static void m1713a(Bundle bundle, String str, Object obj) {
        if (obj instanceof String) {
            bundle.putString(str, (String) obj);
        } else if (obj instanceof Parcelable) {
            bundle.putParcelable(str, (Parcelable) obj);
        } else {
            if (obj instanceof byte[]) {
                bundle.putByteArray(str, (byte[]) obj);
                return;
            }
            throw new C0551y("attempted to add unsupported type to Bundle");
        }
    }

    /* renamed from: a */
    public static void m1714a(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    /* renamed from: a */
    public static void m1716a(URLConnection uRLConnection) {
        if (uRLConnection instanceof HttpURLConnection) {
            ((HttpURLConnection) uRLConnection).disconnect();
        }
    }

    /* renamed from: a */
    public static Object m1709a(JSONObject jSONObject, String str, String str2) throws JSONException {
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
        throw new C0551y("Got an unexpected non-JSON object.");
    }

    /* renamed from: a */
    public static String m1710a(InputStream inputStream) throws Throwable {
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
            char[] cArr = new char[MotionRecognitionManager.EVENT_TILT_TO_UNLOCK];
            while (true) {
                int i = inputStreamReader.read(cArr);
                if (i != -1) {
                    sb.append(cArr, 0, i);
                } else {
                    String string = sb.toString();
                    m1714a((Closeable) bufferedInputStream);
                    m1714a(inputStreamReader);
                    return string;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream2 = bufferedInputStream;
            m1714a((Closeable) bufferedInputStream2);
            m1714a(inputStreamReader);
            throw th;
        }
    }

    /* renamed from: a */
    private static void m1712a(Context context, String str) {
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
    public static void m1711a(Context context) {
        m1712a(context, "facebook.com");
        m1712a(context, ".facebook.com");
        m1712a(context, "https://facebook.com");
        m1712a(context, "https://.facebook.com");
    }

    /* renamed from: a */
    public static void m1715a(String str, String str2) {
    }
}
