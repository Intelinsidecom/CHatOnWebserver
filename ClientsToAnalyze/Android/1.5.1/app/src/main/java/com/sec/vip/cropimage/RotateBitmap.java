package com.sec.vip.cropimage;

import android.graphics.Bitmap;
import android.graphics.Matrix;

/* loaded from: classes.dex */
public class RotateBitmap {

    /* renamed from: a */
    private Bitmap f4444a;

    /* renamed from: b */
    private int f4445b;

    public RotateBitmap(Bitmap bitmap) {
        this.f4444a = bitmap;
        this.f4445b = 0;
    }

    public RotateBitmap(Bitmap bitmap, int i) {
        this.f4444a = bitmap;
        this.f4445b = i % 360;
    }

    /* renamed from: a */
    public int m4336a() {
        return this.f4445b;
    }

    /* renamed from: a */
    public void m4337a(int i) {
        this.f4445b = i;
    }

    /* renamed from: a */
    public void m4338a(Bitmap bitmap) {
        this.f4444a = bitmap;
    }

    /* renamed from: b */
    public Bitmap m4339b() {
        return this.f4444a;
    }

    /* renamed from: c */
    public Matrix m4340c() {
        Matrix matrix = new Matrix();
        if (this.f4445b != 0) {
            matrix.preTranslate(-(this.f4444a.getWidth() / 2), -(this.f4444a.getHeight() / 2));
            matrix.postRotate(this.f4445b);
            matrix.postTranslate(m4343f() / 2, m4342e() / 2);
        }
        return matrix;
    }

    /* renamed from: d */
    public boolean m4341d() {
        return (this.f4445b / 90) % 2 != 0;
    }

    /* renamed from: e */
    public int m4342e() {
        return m4341d() ? this.f4444a.getWidth() : this.f4444a.getHeight();
    }

    /* renamed from: f */
    public int m4343f() {
        return m4341d() ? this.f4444a.getHeight() : this.f4444a.getWidth();
    }
}
