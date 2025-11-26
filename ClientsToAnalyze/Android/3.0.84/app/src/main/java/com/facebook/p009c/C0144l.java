package com.facebook.p009c;

import android.content.Context;
import com.facebook.EnumC0070ak;
import com.facebook.p008b.C0087a;
import com.facebook.p008b.C0095i;
import com.facebook.p008b.C0099m;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: ImageResponseCache.java */
/* renamed from: com.facebook.c.l */
/* loaded from: classes.dex */
public class C0144l {

    /* renamed from: a */
    static final String f329a = C0144l.class.getSimpleName();

    /* renamed from: b */
    private static volatile C0087a f330b;

    /* renamed from: a */
    static synchronized C0087a m437a(Context context) {
        if (f330b == null) {
            f330b = new C0087a(context.getApplicationContext(), f329a, new C0095i());
        }
        return f330b;
    }

    /* renamed from: a */
    static InputStream m439a(URL url, Context context) {
        if (url == null || !m440a(url)) {
            return null;
        }
        try {
            return m437a(context).m226a(url.toString());
        } catch (IOException e) {
            C0099m.m243a(EnumC0070ak.CACHE, 5, f329a, e.toString());
            return null;
        }
    }

    /* renamed from: a */
    static InputStream m438a(Context context, HttpURLConnection httpURLConnection) {
        if (httpURLConnection.getResponseCode() != 200) {
            return null;
        }
        URL url = httpURLConnection.getURL();
        InputStream inputStream = httpURLConnection.getInputStream();
        if (m440a(url)) {
            try {
                return m437a(context).m227a(url.toString(), new C0145m(inputStream, httpURLConnection));
            } catch (IOException e) {
                return inputStream;
            }
        }
        return inputStream;
    }

    /* renamed from: a */
    private static boolean m440a(URL url) {
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
