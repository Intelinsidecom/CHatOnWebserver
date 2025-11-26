package com.facebook.p033c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import com.facebook.p032b.C0476s;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ImageDownloader.java */
/* renamed from: com.facebook.c.a */
/* loaded from: classes.dex */
public class C0503a {

    /* renamed from: a */
    private static final Handler f1258a = new Handler();

    /* renamed from: b */
    private static C0527x f1259b = new C0527x(8);

    /* renamed from: c */
    private static C0527x f1260c = new C0527x(2);

    /* renamed from: d */
    private static final Map<C0509f, C0508e> f1261d = new HashMap();

    /* renamed from: a */
    public static void m1850a(C0510g c0510g) {
        if (c0510g != null) {
            C0509f c0509f = new C0509f(c0510g.m1864b(), c0510g.m1867e());
            synchronized (f1261d) {
                C0508e c0508e = f1261d.get(c0509f);
                if (c0508e != null) {
                    c0508e.f1279b = c0510g;
                    c0508e.f1280c = false;
                    c0508e.f1278a.mo1859a();
                } else {
                    m1853a(c0510g, c0509f, c0510g.m1866d());
                }
            }
        }
    }

    /* renamed from: b */
    public static void m1856b(C0510g c0510g) {
        C0509f c0509f = new C0509f(c0510g.m1864b(), c0510g.m1867e());
        synchronized (f1261d) {
            C0508e c0508e = f1261d.get(c0509f);
            if (c0508e != null) {
                c0508e.f1278a.mo1859a();
            }
        }
    }

    /* renamed from: a */
    private static void m1853a(C0510g c0510g, C0509f c0509f, boolean z) {
        m1852a(c0510g, c0509f, f1260c, new RunnableC0506c(c0510g.m1863a(), c0509f, z));
    }

    /* renamed from: a */
    private static void m1851a(C0510g c0510g, C0509f c0509f) {
        m1852a(c0510g, c0509f, f1259b, new RunnableC0507d(c0510g.m1863a(), c0509f));
    }

    /* renamed from: a */
    private static void m1852a(C0510g c0510g, C0509f c0509f, C0527x c0527x, Runnable runnable) {
        synchronized (f1261d) {
            C0508e c0508e = new C0508e(null);
            c0508e.f1279b = c0510g;
            f1261d.put(c0509f, c0508e);
            c0508e.f1278a = c0527x.m1916a(runnable);
        }
    }

    /* renamed from: a */
    private static void m1849a(C0509f c0509f, Exception exc, Bitmap bitmap, boolean z) {
        C0510g c0510g;
        InterfaceC0513j interfaceC0513jM1865c;
        C0508e c0508eM1846a = m1846a(c0509f);
        if (c0508eM1846a != null && !c0508eM1846a.f1280c && (interfaceC0513jM1865c = (c0510g = c0508eM1846a.f1279b).m1865c()) != null) {
            f1258a.post(new RunnableC0505b(c0510g, exc, z, bitmap, interfaceC0513jM1865c));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m1855b(C0509f c0509f, Context context, boolean z) throws IOException {
        boolean z2;
        InputStream inputStreamM1882a;
        URL urlM1885a;
        if (!z || (urlM1885a = C0517n.m1885a(context, c0509f.f1281a)) == null) {
            z2 = false;
            inputStreamM1882a = null;
        } else {
            InputStream inputStreamM1882a2 = C0515l.m1882a(urlM1885a, context);
            inputStreamM1882a = inputStreamM1882a2;
            z2 = inputStreamM1882a2 != null;
        }
        if (!z2) {
            inputStreamM1882a = C0515l.m1882a(c0509f.f1281a, context);
        }
        if (inputStreamM1882a != null) {
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamM1882a);
            C0476s.m1714a((Closeable) inputStreamM1882a);
            m1849a(c0509f, (Exception) null, bitmapDecodeStream, z2);
        } else {
            C0508e c0508eM1846a = m1846a(c0509f);
            if (c0508eM1846a != null && !c0508eM1846a.f1280c) {
                m1851a(c0508eM1846a.f1279b, c0509f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0013. Please report as an issue. */
    /* JADX WARN: Not initialized variable reg: 5, insn: 0x0098: MOVE (r3 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:33:0x0098 */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m1854b(com.facebook.p033c.C0509f r11, android.content.Context r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 206
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.p033c.C0503a.m1854b(com.facebook.c.f, android.content.Context):void");
    }

    /* renamed from: a */
    private static C0508e m1846a(C0509f c0509f) {
        C0508e c0508eRemove;
        synchronized (f1261d) {
            c0508eRemove = f1261d.remove(c0509f);
        }
        return c0508eRemove;
    }
}
