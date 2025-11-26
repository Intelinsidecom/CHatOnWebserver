package p010b.p014d.p015a;

import java.io.InputStream;
import p010b.p014d.p017c.AbstractC0307a;
import p010b.p014d.p018d.p019a.C0311a;
import p010b.p014d.p018d.p019a.C0313c;

/* compiled from: HttpResponse.java */
/* renamed from: b.d.a.l */
/* loaded from: classes.dex */
public abstract class AbstractC0297l {

    /* renamed from: e */
    private static final AbstractC0307a f663e = AbstractC0307a.m1036a(C0299n.class);

    /* renamed from: a */
    protected final InterfaceC0289d f664a;

    /* renamed from: b */
    protected int f665b;

    /* renamed from: d */
    protected InputStream f667d;

    /* renamed from: c */
    protected String f666c = null;

    /* renamed from: f */
    private boolean f668f = false;

    /* renamed from: g */
    private C0313c f669g = null;

    /* renamed from: h */
    private C0311a f670h = null;

    /* renamed from: a */
    public abstract String mo1026a(String str);

    /* renamed from: d */
    public abstract void mo1029d();

    public AbstractC0297l(InterfaceC0289d interfaceC0289d) {
        this.f664a = interfaceC0289d;
    }

    /* renamed from: a */
    public int m1025a() {
        return this.f665b;
    }

    /* renamed from: b */
    public InputStream m1027b() {
        if (this.f668f) {
            throw new IllegalStateException("Stream has already been consumed.");
        }
        return this.f667d;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0056 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0051 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String m1028c() throws java.lang.Throwable {
        /*
            r6 = this;
            r0 = 0
            java.lang.String r1 = r6.f666c
            if (r1 != 0) goto L7d
            r1 = 0
            java.io.InputStream r2 = r6.m1027b()     // Catch: java.lang.Throwable -> L8c java.io.IOException -> L99
            if (r2 != 0) goto L1a
            if (r2 == 0) goto L11
            r2.close()     // Catch: java.io.IOException -> L80
        L11:
            if (r0 == 0) goto L16
            r1.close()     // Catch: java.io.IOException -> L82
        L16:
            r6.m1024e()
        L19:
            return r0
        L1a:
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L92 java.io.IOException -> L9f
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L92 java.io.IOException -> L9f
            java.lang.String r4 = "UTF-8"
            r3.<init>(r2, r4)     // Catch: java.lang.Throwable -> L92 java.io.IOException -> L9f
            r1.<init>(r3)     // Catch: java.lang.Throwable -> L92 java.io.IOException -> L9f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L3d java.lang.Throwable -> L97
            r0.<init>()     // Catch: java.io.IOException -> L3d java.lang.Throwable -> L97
        L2c:
            java.lang.String r3 = r1.readLine()     // Catch: java.io.IOException -> L3d java.lang.Throwable -> L97
            if (r3 == 0) goto L5d
            java.lang.StringBuilder r3 = r0.append(r3)     // Catch: java.io.IOException -> L3d java.lang.Throwable -> L97
            java.lang.String r4 = "\n"
            r3.append(r4)     // Catch: java.io.IOException -> L3d java.lang.Throwable -> L97
            goto L2c
        L3d:
            r0 = move-exception
            r5 = r2
            r2 = r1
            r1 = r5
        L41:
            b.g r3 = new b.g     // Catch: java.lang.Throwable -> L4b
            java.lang.String r4 = r0.getMessage()     // Catch: java.lang.Throwable -> L4b
            r3.<init>(r4, r0)     // Catch: java.lang.Throwable -> L4b
            throw r3     // Catch: java.lang.Throwable -> L4b
        L4b:
            r0 = move-exception
            r5 = r1
            r1 = r2
            r2 = r5
        L4f:
            if (r2 == 0) goto L54
            r2.close()     // Catch: java.io.IOException -> L88
        L54:
            if (r1 == 0) goto L59
            r1.close()     // Catch: java.io.IOException -> L8a
        L59:
            r6.m1024e()
            throw r0
        L5d:
            java.lang.String r0 = r0.toString()     // Catch: java.io.IOException -> L3d java.lang.Throwable -> L97
            r6.f666c = r0     // Catch: java.io.IOException -> L3d java.lang.Throwable -> L97
            b.d.c.a r0 = p010b.p014d.p015a.AbstractC0297l.f663e     // Catch: java.io.IOException -> L3d java.lang.Throwable -> L97
            java.lang.String r3 = r6.f666c     // Catch: java.io.IOException -> L3d java.lang.Throwable -> L97
            r0.mo1038a(r3)     // Catch: java.io.IOException -> L3d java.lang.Throwable -> L97
            r2.close()     // Catch: java.io.IOException -> L3d java.lang.Throwable -> L97
            r0 = 1
            r6.f668f = r0     // Catch: java.io.IOException -> L3d java.lang.Throwable -> L97
            if (r2 == 0) goto L75
            r2.close()     // Catch: java.io.IOException -> L84
        L75:
            if (r1 == 0) goto L7a
            r1.close()     // Catch: java.io.IOException -> L86
        L7a:
            r6.m1024e()
        L7d:
            java.lang.String r0 = r6.f666c
            goto L19
        L80:
            r2 = move-exception
            goto L11
        L82:
            r1 = move-exception
            goto L16
        L84:
            r0 = move-exception
            goto L75
        L86:
            r0 = move-exception
            goto L7a
        L88:
            r2 = move-exception
            goto L54
        L8a:
            r1 = move-exception
            goto L59
        L8c:
            r1 = move-exception
            r2 = r0
            r5 = r1
            r1 = r0
            r0 = r5
            goto L4f
        L92:
            r1 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L4f
        L97:
            r0 = move-exception
            goto L4f
        L99:
            r1 = move-exception
            r2 = r0
            r5 = r0
            r0 = r1
            r1 = r5
            goto L41
        L9f:
            r1 = move-exception
            r5 = r1
            r1 = r2
            r2 = r0
            r0 = r5
            goto L41
        */
        throw new UnsupportedOperationException("Method not decompiled: p010b.p014d.p015a.AbstractC0297l.m1028c():java.lang.String");
    }

    /* renamed from: e */
    private void m1024e() {
        try {
            mo1029d();
        } catch (Exception e) {
        }
    }

    public String toString() {
        return "HttpResponse{statusCode=" + this.f665b + ", responseAsString='" + this.f666c + "', is=" + this.f667d + ", streamConsumed=" + this.f668f + '}';
    }
}
