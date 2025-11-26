package com.sec.vip.cropimage;

import android.graphics.Bitmap;
import android.graphics.Matrix;

/* compiled from: RotateBitmap.java */
/* renamed from: com.sec.vip.cropimage.ak */
/* loaded from: classes.dex */
public class C3605ak {

    /* renamed from: a */
    private Bitmap f13272a;

    /* renamed from: b */
    private int f13273b;

    public C3605ak(Bitmap bitmap) {
        this.f13272a = bitmap;
        this.f13273b = 0;
    }

    public C3605ak(Bitmap bitmap, int i) {
        this.f13272a = bitmap;
        this.f13273b = i % 360;
    }

    /* renamed from: a */
    public void m12985a(int i) {
        this.f13273b = i;
    }

    /* renamed from: a */
    public int m12984a() {
        return this.f13273b;
    }

    /* renamed from: b */
    public Bitmap m12987b() {
        return this.f13272a;
    }

    /* renamed from: a */
    public void m12986a(Bitmap bitmap) {
        this.f13272a = bitmap;
    }

    /* renamed from: c */
    public Matrix m12988c() {
        Matrix matrix = new Matrix();
        if (this.f13273b != 0) {
            matrix.preTranslate(-(this.f13272a.getWidth() / 2), -(this.f13272a.getHeight() / 2));
            matrix.postRotate(this.f13273b);
            matrix.postTranslate(m12991f() / 2, m12990e() / 2);
        }
        return matrix;
    }

    /* renamed from: d */
    public boolean m12989d() {
        return (this.f13273b / 90) % 2 != 0;
    }

    /* renamed from: e */
    public int m12990e() {
        return m12989d() ? this.f13272a.getWidth() : this.f13272a.getHeight();
    }

    /* renamed from: f */
    public int m12991f() {
        return m12989d() ? this.f13272a.getHeight() : this.f13272a.getWidth();
    }
}
