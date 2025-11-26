package com.google.p034a.p039d;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

/* compiled from: JsonWriter.java */
/* renamed from: com.google.a.d.d */
/* loaded from: classes.dex */
public class C0669d implements Closeable, Flushable {

    /* renamed from: a */
    private static final String[] f1595a = new String[128];

    /* renamed from: b */
    private static final String[] f1596b;

    /* renamed from: c */
    private final Writer f1597c;

    /* renamed from: d */
    private int[] f1598d = new int[32];

    /* renamed from: e */
    private int f1599e = 0;

    /* renamed from: f */
    private String f1600f;

    /* renamed from: g */
    private String f1601g;

    /* renamed from: h */
    private boolean f1602h;

    /* renamed from: i */
    private boolean f1603i;

    /* renamed from: j */
    private String f1604j;

    /* renamed from: k */
    private boolean f1605k;

    static {
        for (int i = 0; i <= 31; i++) {
            f1595a[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        f1595a[34] = "\\\"";
        f1595a[92] = "\\\\";
        f1595a[9] = "\\t";
        f1595a[8] = "\\b";
        f1595a[10] = "\\n";
        f1595a[13] = "\\r";
        f1595a[12] = "\\f";
        f1596b = (String[]) f1595a.clone();
        f1596b[60] = "\\u003c";
        f1596b[62] = "\\u003e";
        f1596b[38] = "\\u0026";
        f1596b[61] = "\\u003d";
        f1596b[39] = "\\u0027";
    }

    public C0669d(Writer writer) {
        m2135a(6);
        this.f1601g = ":";
        this.f1605k = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.f1597c = writer;
    }

    /* renamed from: c */
    public final void m2143c(String str) {
        if (str.length() == 0) {
            this.f1600f = null;
            this.f1601g = ":";
        } else {
            this.f1600f = str;
            this.f1601g = ": ";
        }
    }

    /* renamed from: b */
    public final void m2142b(boolean z) {
        this.f1602h = z;
    }

    /* renamed from: g */
    public boolean m2146g() {
        return this.f1602h;
    }

    /* renamed from: c */
    public final void m2144c(boolean z) {
        this.f1603i = z;
    }

    /* renamed from: h */
    public final boolean m2147h() {
        return this.f1603i;
    }

    /* renamed from: d */
    public final void m2145d(boolean z) {
        this.f1605k = z;
    }

    /* renamed from: i */
    public final boolean m2148i() {
        return this.f1605k;
    }

    /* renamed from: b */
    public C0669d mo2009b() throws IOException {
        m2139j();
        return m2134a(1, "[");
    }

    /* renamed from: c */
    public C0669d mo2011c() {
        return m2133a(1, 2, "]");
    }

    /* renamed from: d */
    public C0669d mo2012d() throws IOException {
        m2139j();
        return m2134a(3, "{");
    }

    /* renamed from: e */
    public C0669d mo2013e() {
        return m2133a(3, 5, "}");
    }

    /* renamed from: a */
    private C0669d m2134a(int i, String str) throws IOException {
        m2138e(true);
        m2135a(i);
        this.f1597c.write(str);
        return this;
    }

    /* renamed from: a */
    private C0669d m2133a(int i, int i2, String str) throws IOException {
        int iM2132a = m2132a();
        if (iM2132a != i2 && iM2132a != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.f1604j != null) {
            throw new IllegalStateException("Dangling name: " + this.f1604j);
        }
        this.f1599e--;
        if (iM2132a == i2) {
            m2140k();
        }
        this.f1597c.write(str);
        return this;
    }

    /* renamed from: a */
    private void m2135a(int i) {
        if (this.f1599e == this.f1598d.length) {
            int[] iArr = new int[this.f1599e * 2];
            System.arraycopy(this.f1598d, 0, iArr, 0, this.f1599e);
            this.f1598d = iArr;
        }
        int[] iArr2 = this.f1598d;
        int i2 = this.f1599e;
        this.f1599e = i2 + 1;
        iArr2[i2] = i;
    }

    /* renamed from: a */
    private int m2132a() {
        if (this.f1599e == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        return this.f1598d[this.f1599e - 1];
    }

    /* renamed from: b */
    private void m2136b(int i) {
        this.f1598d[this.f1599e - 1] = i;
    }

    /* renamed from: a */
    public C0669d mo2006a(String str) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.f1604j != null) {
            throw new IllegalStateException();
        }
        if (this.f1599e == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f1604j = str;
        return this;
    }

    /* renamed from: j */
    private void m2139j() throws IOException {
        if (this.f1604j != null) {
            m2141l();
            m2137d(this.f1604j);
            this.f1604j = null;
        }
    }

    /* renamed from: b */
    public C0669d mo2010b(String str) throws IOException {
        if (str == null) {
            return mo2014f();
        }
        m2139j();
        m2138e(false);
        m2137d(str);
        return this;
    }

    /* renamed from: f */
    public C0669d mo2014f() throws IOException {
        if (this.f1604j != null) {
            if (this.f1605k) {
                m2139j();
                m2138e(false);
                this.f1597c.write("null");
            } else {
                this.f1604j = null;
            }
        } else {
            m2138e(false);
            this.f1597c.write("null");
        }
        return this;
    }

    /* renamed from: a */
    public C0669d mo2007a(boolean z) throws IOException {
        m2139j();
        m2138e(false);
        this.f1597c.write(z ? "true" : "false");
        return this;
    }

    /* renamed from: a */
    public C0669d mo2004a(long j) throws IOException {
        m2139j();
        m2138e(false);
        this.f1597c.write(Long.toString(j));
        return this;
    }

    /* renamed from: a */
    public C0669d mo2005a(Number number) throws IOException {
        if (number == null) {
            return mo2014f();
        }
        m2139j();
        String string = number.toString();
        if (!this.f1602h && (string.equals("-Infinity") || string.equals("Infinity") || string.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        m2138e(false);
        this.f1597c.append((CharSequence) string);
        return this;
    }

    public void flush() throws IOException {
        if (this.f1599e == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f1597c.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f1597c.close();
        int i = this.f1599e;
        if (i > 1 || (i == 1 && this.f1598d[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.f1599e = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m2137d(java.lang.String r8) throws java.io.IOException {
        /*
            r7 = this;
            r1 = 0
            boolean r0 = r7.f1603i
            if (r0 == 0) goto L26
            java.lang.String[] r0 = com.google.p034a.p039d.C0669d.f1596b
        L7:
            java.io.Writer r2 = r7.f1597c
            java.lang.String r3 = "\""
            r2.write(r3)
            int r4 = r8.length()
            r3 = r1
        L14:
            if (r3 >= r4) goto L49
            char r2 = r8.charAt(r3)
            r5 = 128(0x80, float:1.8E-43)
            if (r2 >= r5) goto L29
            r2 = r0[r2]
            if (r2 != 0) goto L30
        L22:
            int r2 = r3 + 1
            r3 = r2
            goto L14
        L26:
            java.lang.String[] r0 = com.google.p034a.p039d.C0669d.f1595a
            goto L7
        L29:
            r5 = 8232(0x2028, float:1.1535E-41)
            if (r2 != r5) goto L41
            java.lang.String r2 = "\\u2028"
        L30:
            if (r1 >= r3) goto L39
            java.io.Writer r5 = r7.f1597c
            int r6 = r3 - r1
            r5.write(r8, r1, r6)
        L39:
            java.io.Writer r1 = r7.f1597c
            r1.write(r2)
            int r1 = r3 + 1
            goto L22
        L41:
            r5 = 8233(0x2029, float:1.1537E-41)
            if (r2 != r5) goto L22
            java.lang.String r2 = "\\u2029"
            goto L30
        L49:
            if (r1 >= r4) goto L52
            java.io.Writer r0 = r7.f1597c
            int r2 = r4 - r1
            r0.write(r8, r1, r2)
        L52:
            java.io.Writer r0 = r7.f1597c
            java.lang.String r1 = "\""
            r0.write(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.p034a.p039d.C0669d.m2137d(java.lang.String):void");
    }

    /* renamed from: k */
    private void m2140k() throws IOException {
        if (this.f1600f != null) {
            this.f1597c.write("\n");
            int i = this.f1599e;
            for (int i2 = 1; i2 < i; i2++) {
                this.f1597c.write(this.f1600f);
            }
        }
    }

    /* renamed from: l */
    private void m2141l() throws IOException {
        int iM2132a = m2132a();
        if (iM2132a == 5) {
            this.f1597c.write(44);
        } else if (iM2132a != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        m2140k();
        m2136b(4);
    }

    /* renamed from: e */
    private void m2138e(boolean z) throws IOException {
        switch (m2132a()) {
            case 1:
                m2136b(2);
                m2140k();
                return;
            case 2:
                this.f1597c.append(',');
                m2140k();
                return;
            case 3:
            case 5:
            default:
                throw new IllegalStateException("Nesting problem.");
            case 4:
                this.f1597c.append((CharSequence) this.f1601g);
                m2136b(5);
                return;
            case 6:
                break;
            case 7:
                if (!this.f1602h) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
        }
        if (!this.f1602h && !z) {
            throw new IllegalStateException("JSON must start with an array or an object.");
        }
        m2136b(7);
    }
}
