package com.facebook.p033c;

import android.content.Context;
import com.facebook.EnumC0441ak;
import com.facebook.p032b.C0458a;
import com.facebook.p032b.C0466i;
import com.facebook.p032b.C0470m;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: ImageResponseCache.java */
/* renamed from: com.facebook.c.l */
/* loaded from: classes.dex */
public class C0515l {

    /* renamed from: a */
    static final String f1298a = C0515l.class.getSimpleName();

    /* renamed from: b */
    private static volatile C0458a f1299b;

    /* renamed from: a */
    static synchronized C0458a m1880a(Context context) {
        if (f1299b == null) {
            f1299b = new C0458a(context.getApplicationContext(), f1298a, new C0466i());
        }
        return f1299b;
    }

    /* renamed from: a */
    static InputStream m1882a(URL url, Context context) {
        if (url == null || !m1883a(url)) {
            return null;
        }
        try {
            return m1880a(context).m1670a(url.toString());
        } catch (IOException e) {
            C0470m.m1687a(EnumC0441ak.CACHE, 5, f1298a, e.toString());
            return null;
        }
    }

    /* renamed from: a */
    static InputStream m1881a(Context context, HttpURLConnection httpURLConnection) {
        if (httpURLConnection.getResponseCode() != 200) {
            return null;
        }
        URL url = httpURLConnection.getURL();
        InputStream inputStream = httpURLConnection.getInputStream();
        if (m1883a(url)) {
            try {
                return m1880a(context).m1671a(url.toString(), new C0516m(inputStream, httpURLConnection));
            } catch (IOException e) {
                return inputStream;
            }
        }
        return inputStream;
    }

    /* renamed from: a */
    private static boolean m1883a(URL url) {
        if (url != null) {
            String host = url.getHost();
            if (host.endsWith("fbcdn.net")) {
                return true;
            }
            if (host.startsWith("fbcdn") && host.endsWith("akamaihd.net")) {
                return true;
            }
        }
        return false;
    }
}
