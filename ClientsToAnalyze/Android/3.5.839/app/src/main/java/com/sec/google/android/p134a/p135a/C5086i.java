package com.sec.google.android.p134a.p135a;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/* compiled from: PduBody.java */
/* renamed from: com.sec.google.android.a.a.i */
/* loaded from: classes.dex */
public class C5086i {

    /* renamed from: a */
    private Vector<C5094q> f18527a;

    /* renamed from: b */
    private Map<String, C5094q> f18528b;

    /* renamed from: c */
    private Map<String, C5094q> f18529c;

    /* renamed from: d */
    private Map<String, C5094q> f18530d;

    /* renamed from: e */
    private Map<String, C5094q> f18531e;

    public C5086i() {
        this.f18527a = null;
        this.f18528b = null;
        this.f18529c = null;
        this.f18530d = null;
        this.f18531e = null;
        this.f18527a = new Vector<>();
        this.f18528b = new HashMap();
        this.f18529c = new HashMap();
        this.f18530d = new HashMap();
        this.f18531e = new HashMap();
    }

    /* renamed from: b */
    private void m19327b(C5094q c5094q) {
        byte[] bArrM19386c = c5094q.m19386c();
        if (bArrM19386c != null) {
            this.f18528b.put(new String(bArrM19386c), c5094q);
        }
        byte[] bArrM19390e = c5094q.m19390e();
        if (bArrM19390e != null) {
            this.f18529c.put(new String(bArrM19390e), c5094q);
        }
        byte[] bArrM19397i = c5094q.m19397i();
        if (bArrM19397i != null) {
            this.f18530d.put(new String(bArrM19397i), c5094q);
        }
        byte[] bArrM19398j = c5094q.m19398j();
        if (bArrM19398j != null) {
            this.f18531e.put(new String(bArrM19398j), c5094q);
        }
    }

    /* renamed from: a */
    public boolean m19332a(C5094q c5094q) {
        if (c5094q == null) {
            throw new NullPointerException();
        }
        m19327b(c5094q);
        return this.f18527a.add(c5094q);
    }

    /* renamed from: a */
    public void m19331a(int i, C5094q c5094q) {
        if (c5094q == null) {
            throw new NullPointerException();
        }
        m19327b(c5094q);
        this.f18527a.add(i, c5094q);
    }

    /* renamed from: a */
    public void m19330a() {
        this.f18527a.clear();
    }

    /* renamed from: a */
    public C5094q m19328a(int i) {
        return this.f18527a.get(i);
    }

    /* renamed from: b */
    public int m19333b() {
        return this.f18527a.size();
    }

    /* renamed from: a */
    public C5094q m19329a(String str) {
        return this.f18528b.get(str);
    }

    /* renamed from: b */
    public C5094q m19334b(String str) {
        return this.f18529c.get(str);
    }

    /* renamed from: c */
    public C5094q m19335c(String str) {
        return this.f18530d.get(str);
    }

    /* renamed from: d */
    public C5094q m19336d(String str) {
        return this.f18531e.get(str);
    }
}
