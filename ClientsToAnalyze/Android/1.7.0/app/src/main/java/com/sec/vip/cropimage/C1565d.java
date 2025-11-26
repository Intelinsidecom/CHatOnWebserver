package com.sec.vip.cropimage;

import android.graphics.Bitmap;
import android.graphics.Matrix;

/* compiled from: RotateBitmap.java */
/* renamed from: com.sec.vip.cropimage.d */
/* loaded from: classes.dex */
public class C1565d {

    /* renamed from: a */
    private Bitmap f5501a;

    /* renamed from: b */
    private int f5502b;

    public C1565d(Bitmap bitmap) {
        this.f5501a = bitmap;
        this.f5502b = 0;
    }

    public C1565d(Bitmap bitmap, int i) {
        this.f5501a = bitmap;
        this.f5502b = i % 360;
    }

    /* renamed from: a */
    public void m5733a(int i) {
        this.f5502b = i;
    }

    /* renamed from: a */
    public int m5732a() {
        return this.f5502b;
    }

    /* renamed from: b */
    public Bitmap m5735b() {
        return this.f5501a;
    }

    /* renamed from: a */
    public void m5734a(Bitmap bitmap) {
        this.f5501a = bitmap;
    }

    /* renamed from: c */
    public Matrix m5736c() {
        Matrix matrix = new Matrix();
        if (this.f5502b != 0) {
            matrix.preTranslate(-(this.f5501a.getWidth() / 2), -(this.f5501a.getHeight() / 2));
            matrix.postRotate(this.f5502b);
            matrix.postTranslate(m5739f() / 2, m5738e() / 2);
        }
        return matrix;
    }

    /* renamed from: d */
    public boolean m5737d() {
        return (this.f5502b / 90) % 2 != 0;
    }

    /* renamed from: e */
    public int m5738e() {
        return m5737d() ? this.f5501a.getWidth() : this.f5501a.getHeight();
    }

    /* renamed from: f */
    public int m5739f() {
        return m5737d() ? this.f5501a.getHeight() : this.f5501a.getWidth();
    }
}
