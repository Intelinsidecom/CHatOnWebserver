package com.sec.vip.cropimage;

import android.graphics.Bitmap;
import android.graphics.Matrix;

/* compiled from: RotateBitmap.java */
/* renamed from: com.sec.vip.cropimage.p */
/* loaded from: classes.dex */
public class C2119p {

    /* renamed from: a */
    private Bitmap f7694a;

    /* renamed from: b */
    private int f7695b;

    public C2119p(Bitmap bitmap) {
        this.f7694a = bitmap;
        this.f7695b = 0;
    }

    public C2119p(Bitmap bitmap, int i) {
        this.f7694a = bitmap;
        this.f7695b = i % 360;
    }

    /* renamed from: a */
    public void m7431a(int i) {
        this.f7695b = i;
    }

    /* renamed from: a */
    public int m7430a() {
        return this.f7695b;
    }

    /* renamed from: b */
    public Bitmap m7433b() {
        return this.f7694a;
    }

    /* renamed from: a */
    public void m7432a(Bitmap bitmap) {
        this.f7694a = bitmap;
    }

    /* renamed from: c */
    public Matrix m7434c() {
        Matrix matrix = new Matrix();
        if (this.f7695b != 0) {
            matrix.preTranslate(-(this.f7694a.getWidth() / 2), -(this.f7694a.getHeight() / 2));
            matrix.postRotate(this.f7695b);
            matrix.postTranslate(m7437f() / 2, m7436e() / 2);
        }
        return matrix;
    }

    /* renamed from: d */
    public boolean m7435d() {
        return (this.f7695b / 90) % 2 != 0;
    }

    /* renamed from: e */
    public int m7436e() {
        return m7435d() ? this.f7694a.getWidth() : this.f7694a.getHeight();
    }

    /* renamed from: f */
    public int m7437f() {
        return m7435d() ? this.f7694a.getHeight() : this.f7694a.getWidth();
    }
}
