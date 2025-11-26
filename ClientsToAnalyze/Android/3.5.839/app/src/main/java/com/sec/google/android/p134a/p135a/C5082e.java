package com.sec.google.android.p134a.p135a;

import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/* compiled from: EncodedStringValue.java */
/* renamed from: com.sec.google.android.a.a.e */
/* loaded from: classes.dex */
public class C5082e implements Cloneable {

    /* renamed from: a */
    private int f18524a;

    /* renamed from: b */
    private byte[] f18525b;

    public C5082e(int i, byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("EncodedStringValue: Text-string is null.");
        }
        this.f18524a = i;
        this.f18525b = new byte[bArr.length];
        System.arraycopy(bArr, 0, this.f18525b, 0, bArr.length);
    }

    public C5082e(int i, String str) {
        try {
            this.f18525b = str.getBytes("utf-8");
            this.f18524a = i;
        } catch (UnsupportedEncodingException e) {
            Log.e("EncodedStringValue", "Default encoding must be supported.", e);
        }
    }

    public C5082e(byte[] bArr) {
        this(106, bArr);
    }

    public C5082e(String str) {
        try {
            this.f18525b = str.getBytes("utf-8");
            this.f18524a = 106;
        } catch (UnsupportedEncodingException e) {
            Log.e("EncodedStringValue", "Default encoding must be supported.", e);
        }
    }

    /* renamed from: a */
    public int m19304a() {
        return this.f18524a;
    }

    /* renamed from: b */
    public byte[] m19307b() {
        byte[] bArr = new byte[this.f18525b.length];
        System.arraycopy(this.f18525b, 0, bArr, 0, this.f18525b.length);
        return bArr;
    }

    /* renamed from: a */
    public void m19305a(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("EncodedStringValue: Text-string is null.");
        }
        this.f18525b = new byte[bArr.length];
        System.arraycopy(bArr, 0, this.f18525b, 0, bArr.length);
    }

    /* renamed from: c */
    public String m19308c() {
        if (this.f18524a == 0) {
            return new String(this.f18525b);
        }
        try {
            return new String(this.f18525b, C5080c.m19300a(this.f18524a));
        } catch (UnsupportedEncodingException e) {
            try {
                return new String(this.f18525b, "iso-8859-1");
            } catch (UnsupportedEncodingException e2) {
                return new String(this.f18525b);
            }
        }
    }

    /* renamed from: b */
    public void m19306b(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("Text-string is null.");
        }
        if (this.f18525b == null) {
            this.f18525b = new byte[bArr.length];
            System.arraycopy(bArr, 0, this.f18525b, 0, bArr.length);
            return;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(this.f18525b);
            byteArrayOutputStream.write(bArr);
            this.f18525b = byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            throw new NullPointerException("appendTextString: failed when write a new Text-string");
        }
    }

    public Object clone() throws CloneNotSupportedException {
        super.clone();
        int length = this.f18525b.length;
        byte[] bArr = new byte[length];
        System.arraycopy(this.f18525b, 0, bArr, 0, length);
        try {
            return new C5082e(this.f18524a, bArr);
        } catch (Exception e) {
            Log.e("EncodedStringValue", "failed to clone an EncodedStringValue: " + this);
            e.printStackTrace();
            throw new CloneNotSupportedException(e.getMessage());
        }
    }

    /* renamed from: a */
    public static C5082e m19302a(C5082e c5082e) {
        if (c5082e == null) {
            return null;
        }
        return new C5082e(c5082e.f18524a, c5082e.f18525b);
    }

    /* renamed from: a */
    public static C5082e[] m19303a(String[] strArr) {
        int length = strArr.length;
        if (length > 0) {
            C5082e[] c5082eArr = new C5082e[length];
            for (int i = 0; i < length; i++) {
                c5082eArr[i] = new C5082e(strArr[i]);
            }
            return c5082eArr;
        }
        return null;
    }
}
