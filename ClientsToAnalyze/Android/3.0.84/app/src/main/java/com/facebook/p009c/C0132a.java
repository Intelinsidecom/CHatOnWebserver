package com.facebook.p009c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import com.facebook.p008b.C0105s;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ImageDownloader.java */
/* renamed from: com.facebook.c.a */
/* loaded from: classes.dex */
public class C0132a {

    /* renamed from: a */
    private static final Handler f289a = new Handler();

    /* renamed from: b */
    private static C0156x f290b = new C0156x(8);

    /* renamed from: c */
    private static C0156x f291c = new C0156x(2);

    /* renamed from: d */
    private static final Map<C0138f, C0137e> f292d = new HashMap();

    /* renamed from: a */
    public static void m407a(C0139g c0139g) {
        if (c0139g != null) {
            C0138f c0138f = new C0138f(c0139g.m421b(), c0139g.m424e());
            synchronized (f292d) {
                C0137e c0137e = f292d.get(c0138f);
                if (c0137e != null) {
                    c0137e.f310b = c0139g;
                    c0137e.f311c = false;
                    c0137e.f309a.mo416a();
                } else {
                    m410a(c0139g, c0138f, c0139g.m423d());
                }
            }
        }
    }

    /* renamed from: b */
    public static void m413b(C0139g c0139g) {
        C0138f c0138f = new C0138f(c0139g.m421b(), c0139g.m424e());
        synchronized (f292d) {
            C0137e c0137e = f292d.get(c0138f);
            if (c0137e != null) {
                c0137e.f309a.mo416a();
            }
        }
    }

    /* renamed from: a */
    private static void m410a(C0139g c0139g, C0138f c0138f, boolean z) {
        m409a(c0139g, c0138f, f291c, new RunnableC0135c(c0139g.m420a(), c0138f, z));
    }

    /* renamed from: a */
    private static void m408a(C0139g c0139g, C0138f c0138f) {
        m409a(c0139g, c0138f, f290b, new RunnableC0136d(c0139g.m420a(), c0138f));
    }

    /* renamed from: a */
    private static void m409a(C0139g c0139g, C0138f c0138f, C0156x c0156x, Runnable runnable) {
        synchronized (f292d) {
            C0137e c0137e = new C0137e(null);
            c0137e.f310b = c0139g;
            f292d.put(c0138f, c0137e);
            c0137e.f309a = c0156x.m473a(runnable);
        }
    }

    /* renamed from: a */
    private static void m406a(C0138f c0138f, Exception exc, Bitmap bitmap, boolean z) {
        C0139g c0139g;
        InterfaceC0142j interfaceC0142jM422c;
        C0137e c0137eM403a = m403a(c0138f);
        if (c0137eM403a != null && !c0137eM403a.f311c && (interfaceC0142jM422c = (c0139g = c0137eM403a.f310b).m422c()) != null) {
            f289a.post(new RunnableC0134b(c0139g, exc, z, bitmap, interfaceC0142jM422c));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m412b(C0138f c0138f, Context context, boolean z) throws IOException {
        boolean z2;
        InputStream inputStreamM439a;
        URL urlM442a;
        if (!z || (urlM442a = C0146n.m442a(context, c0138f.f312a)) == null) {
            z2 = false;
            inputStreamM439a = null;
        } else {
            InputStream inputStreamM439a2 = C0144l.m439a(urlM442a, context);
            inputStreamM439a = inputStreamM439a2;
            z2 = inputStreamM439a2 != null;
        }
        if (!z2) {
            inputStreamM439a = C0144l.m439a(c0138f.f312a, context);
        }
        if (inputStreamM439a != null) {
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamM439a);
            C0105s.m270a((Closeable) inputStreamM439a);
            m406a(c0138f, (Exception) null, bitmapDecodeStream, z2);
        } else {
            C0137e c0137eM403a = m403a(c0138f);
            if (c0137eM403a != null && !c0137eM403a.f311c) {
                m408a(c0137eM403a.f310b, c0138f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0013. Please report as an issue. */
    /* JADX WARN: Not initialized variable reg: 5, insn: 0x0097: MOVE (r3 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:33:0x0097 */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m411b(com.facebook.p009c.C0138f r11, android.content.Context r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 204
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.p009c.C0132a.m411b(com.facebook.c.f, android.content.Context):void");
    }

    /* renamed from: a */
    private static C0137e m403a(C0138f c0138f) {
        C0137e c0137eRemove;
        synchronized (f292d) {
            c0137eRemove = f292d.remove(c0138f);
        }
        return c0137eRemove;
    }
}
