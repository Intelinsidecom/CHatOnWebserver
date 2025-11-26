package com.facebook.p009c;

import android.content.Context;
import com.facebook.p008b.C0087a;
import com.facebook.p008b.C0095i;
import com.facebook.p008b.C0105s;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

/* compiled from: UrlRedirectCache.java */
/* renamed from: com.facebook.c.n */
/* loaded from: classes.dex */
class C0146n {

    /* renamed from: a */
    static final String f332a = C0146n.class.getSimpleName();

    /* renamed from: b */
    private static final String f333b = f332a + "_Redirect";

    /* renamed from: c */
    private static volatile C0087a f334c;

    C0146n() {
    }

    /* renamed from: a */
    static synchronized C0087a m441a(Context context) {
        if (f334c == null) {
            f334c = new C0087a(context.getApplicationContext(), f332a, new C0095i());
        }
        return f334c;
    }

    /* renamed from: a */
    static URL m442a(Context context, URL url) throws Throwable {
        InputStreamReader inputStreamReader;
        InputStreamReader inputStreamReader2;
        boolean z = false;
        if (url == null) {
            return null;
        }
        String string = url.toString();
        try {
            C0087a c0087aM441a = m441a(context);
            String string2 = string;
            inputStreamReader = null;
            while (true) {
                try {
                    InputStream inputStreamM228a = c0087aM441a.m228a(string2, f333b);
                    if (inputStreamM228a == null) {
                        break;
                    }
                    inputStreamReader2 = new InputStreamReader(inputStreamM228a);
                    try {
                        char[] cArr = new char[128];
                        StringBuilder sb = new StringBuilder();
                        while (true) {
                            int i = inputStreamReader2.read(cArr, 0, cArr.length);
                            if (i <= 0) {
                                break;
                            }
                            sb.append(cArr, 0, i);
                        }
                        C0105s.m270a(inputStreamReader2);
                        string2 = sb.toString();
                        inputStreamReader = inputStreamReader2;
                        z = true;
                    } catch (MalformedURLException e) {
                        C0105s.m270a(inputStreamReader2);
                        return null;
                    } catch (IOException e2) {
                        C0105s.m270a(inputStreamReader2);
                        return null;
                    } catch (Throwable th) {
                        inputStreamReader = inputStreamReader2;
                        th = th;
                        C0105s.m270a(inputStreamReader);
                        throw th;
                    }
                } catch (MalformedURLException e3) {
                    inputStreamReader2 = inputStreamReader;
                } catch (IOException e4) {
                    inputStreamReader2 = inputStreamReader;
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            URL url2 = z ? new URL(string2) : null;
            C0105s.m270a(inputStreamReader);
            return url2;
        } catch (MalformedURLException e5) {
            inputStreamReader2 = null;
        } catch (IOException e6) {
            inputStreamReader2 = null;
        } catch (Throwable th3) {
            th = th3;
            inputStreamReader = null;
        }
    }

    /* renamed from: a */
    static void m443a(Context context, URL url, URL url2) throws Throwable {
        OutputStream outputStream;
        Throwable th;
        OutputStream outputStreamM230b;
        if (url != null && url2 != null) {
            try {
                try {
                    outputStreamM230b = m441a(context).m230b(url.toString(), f333b);
                } catch (Throwable th2) {
                    outputStream = null;
                    th = th2;
                }
                try {
                    outputStreamM230b.write(url2.toString().getBytes());
                    C0105s.m270a(outputStreamM230b);
                } catch (Throwable th3) {
                    outputStream = outputStreamM230b;
                    th = th3;
                    C0105s.m270a(outputStream);
                    throw th;
                }
            } catch (IOException e) {
                C0105s.m270a((Closeable) null);
            }
        }
    }
}
