package com.sec.google.android.p134a.p135a;

import android.net.Uri;
import java.util.HashMap;
import java.util.Map;

/* compiled from: PduPart.java */
/* renamed from: com.sec.google.android.a.a.q */
/* loaded from: classes.dex */
public class C5094q {

    /* renamed from: a */
    static final byte[] f18552a = "from-data".getBytes();

    /* renamed from: b */
    static final byte[] f18553b = "attachment".getBytes();

    /* renamed from: c */
    static final byte[] f18554c = "inline".getBytes();

    /* renamed from: d */
    private Map<Integer, Object> f18555d;

    /* renamed from: e */
    private Uri f18556e = null;

    /* renamed from: f */
    private byte[] f18557f = null;

    public C5094q() {
        this.f18555d = null;
        this.f18555d = new HashMap();
    }

    /* renamed from: a */
    public void m19381a(byte[] bArr) {
        if (bArr != null) {
            this.f18557f = new byte[bArr.length];
            System.arraycopy(bArr, 0, this.f18557f, 0, bArr.length);
        }
    }

    /* renamed from: a */
    public byte[] m19382a() {
        if (this.f18557f == null) {
            return null;
        }
        byte[] bArr = new byte[this.f18557f.length];
        System.arraycopy(this.f18557f, 0, bArr, 0, this.f18557f.length);
        return bArr;
    }

    /* renamed from: a */
    public void m19380a(Uri uri) {
        this.f18556e = uri;
    }

    /* renamed from: b */
    public Uri m19383b() {
        return this.f18556e;
    }

    /* renamed from: b */
    public void m19384b(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            throw new IllegalArgumentException("Content-Id may not be null or empty.");
        }
        if (bArr.length > 1 && ((char) bArr[0]) == '<' && ((char) bArr[bArr.length - 1]) == '>') {
            this.f18555d.put(192, bArr);
            return;
        }
        byte[] bArr2 = new byte[bArr.length + 2];
        bArr2[0] = 60;
        bArr2[bArr2.length - 1] = 62;
        System.arraycopy(bArr, 0, bArr2, 1, bArr.length);
        this.f18555d.put(192, bArr2);
    }

    /* renamed from: c */
    public byte[] m19386c() {
        return (byte[]) this.f18555d.get(192);
    }

    /* renamed from: a */
    public void m19379a(int i) {
        this.f18555d.put(129, Integer.valueOf(i));
    }

    /* renamed from: d */
    public int m19387d() {
        Integer num = (Integer) this.f18555d.get(129);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    /* renamed from: c */
    public void m19385c(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("null content-location");
        }
        this.f18555d.put(142, bArr);
    }

    /* renamed from: e */
    public byte[] m19390e() {
        return (byte[]) this.f18555d.get(142);
    }

    /* renamed from: d */
    public void m19388d(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("null content-disposition");
        }
        this.f18555d.put(197, bArr);
    }

    /* renamed from: f */
    public byte[] m19392f() {
        return (byte[]) this.f18555d.get(197);
    }

    /* renamed from: e */
    public void m19389e(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("null content-type");
        }
        this.f18555d.put(145, bArr);
    }

    /* renamed from: g */
    public byte[] m19394g() {
        return (byte[]) this.f18555d.get(145);
    }

    /* renamed from: f */
    public void m19391f(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("null content-transfer-encoding");
        }
        this.f18555d.put(200, bArr);
    }

    /* renamed from: h */
    public byte[] m19396h() {
        return (byte[]) this.f18555d.get(200);
    }

    /* renamed from: g */
    public void m19393g(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("null content-id");
        }
        this.f18555d.put(151, bArr);
    }

    /* renamed from: i */
    public byte[] m19397i() {
        return (byte[]) this.f18555d.get(151);
    }

    /* renamed from: h */
    public void m19395h(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("null content-id");
        }
        this.f18555d.put(152, bArr);
    }

    /* renamed from: j */
    public byte[] m19398j() {
        return (byte[]) this.f18555d.get(152);
    }

    /* renamed from: k */
    public String m19399k() {
        byte[] bArr = (byte[]) this.f18555d.get(151);
        byte[] bArr2 = (bArr == null && (bArr = (byte[]) this.f18555d.get(152)) == null) ? (byte[]) this.f18555d.get(142) : bArr;
        return bArr2 == null ? "cid:" + new String((byte[]) this.f18555d.get(192)) : new String(bArr2);
    }
}
