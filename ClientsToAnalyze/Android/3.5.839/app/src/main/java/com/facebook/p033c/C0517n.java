package com.facebook.p033c;

import android.content.Context;
import com.facebook.p032b.C0458a;
import com.facebook.p032b.C0466i;
import com.facebook.p032b.C0476s;
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
class C0517n {

    /* renamed from: a */
    static final String f1301a = C0517n.class.getSimpleName();

    /* renamed from: b */
    private static final String f1302b = f1301a + "_Redirect";

    /* renamed from: c */
    private static volatile C0458a f1303c;

    C0517n() {
    }

    /* renamed from: a */
    static synchronized C0458a m1884a(Context context) {
        if (f1303c == null) {
            f1303c = new C0458a(context.getApplicationContext(), f1301a, new C0466i());
        }
        return f1303c;
    }

    /* renamed from: a */
    static URL m1885a(Context context, URL url) throws Throwable {
        InputStreamReader inputStreamReader;
        InputStreamReader inputStreamReader2;
        boolean z = false;
        if (url == null) {
            return null;
        }
        String string = url.toString();
        try {
            C0458a c0458aM1884a = m1884a(context);
            String string2 = string;
            inputStreamReader = null;
            while (true) {
                try {
                    InputStream inputStreamM1672a = c0458aM1884a.m1672a(string2, f1302b);
                    if (inputStreamM1672a == null) {
                        break;
                    }
                    inputStreamReader2 = new InputStreamReader(inputStreamM1672a);
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
                        C0476s.m1714a(inputStreamReader2);
                        string2 = sb.toString();
                        inputStreamReader = inputStreamReader2;
                        z = true;
                    } catch (MalformedURLException e) {
                        C0476s.m1714a(inputStreamReader2);
                        return null;
                    } catch (IOException e2) {
                        C0476s.m1714a(inputStreamReader2);
                        return null;
                    } catch (Throwable th) {
                        inputStreamReader = inputStreamReader2;
                        th = th;
                        C0476s.m1714a(inputStreamReader);
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
            C0476s.m1714a(inputStreamReader);
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
    static void m1886a(Context context, URL url, URL url2) throws Throwable {
        OutputStream outputStream;
        Throwable th;
        OutputStream outputStreamM1674b;
        if (url != null && url2 != null) {
            try {
                try {
                    outputStreamM1674b = m1884a(context).m1674b(url.toString(), f1302b);
                } catch (Throwable th2) {
                    outputStream = null;
                    th = th2;
                }
                try {
                    outputStreamM1674b.write(url2.toString().getBytes());
                    C0476s.m1714a(outputStreamM1674b);
                } catch (Throwable th3) {
                    outputStream = outputStreamM1674b;
                    th = th3;
                    C0476s.m1714a(outputStream);
                    throw th;
                }
            } catch (IOException e) {
                C0476s.m1714a((Closeable) null);
            }
        }
    }
}
