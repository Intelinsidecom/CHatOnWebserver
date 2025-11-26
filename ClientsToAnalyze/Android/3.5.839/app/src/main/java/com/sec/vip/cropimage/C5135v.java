package com.sec.vip.cropimage;

import android.graphics.Bitmap;
import android.graphics.Matrix;

/* compiled from: RotateBitmap.java */
/* renamed from: com.sec.vip.cropimage.v */
/* loaded from: classes.dex */
public class C5135v {

    /* renamed from: a */
    private Bitmap f18721a;

    /* renamed from: b */
    private int f18722b;

    public C5135v(Bitmap bitmap) {
        this.f18721a = bitmap;
        this.f18722b = 0;
    }

    public C5135v(Bitmap bitmap, int i) {
        this.f18721a = bitmap;
        this.f18722b = i % 360;
    }

    /* renamed from: a */
    public void m19594a(int i) {
        this.f18722b = i;
    }

    /* renamed from: a */
    public int m19593a() {
        return this.f18722b;
    }

    /* renamed from: b */
    public Bitmap m19596b() {
        return this.f18721a;
    }

    /* renamed from: a */
    public void m19595a(Bitmap bitmap) {
        this.f18721a = bitmap;
    }

    /* renamed from: c */
    public Matrix m19597c() {
        Matrix matrix = new Matrix();
        if (this.f18722b != 0) {
            matrix.preTranslate(-(this.f18721a.getWidth() / 2), -(this.f18721a.getHeight() / 2));
            matrix.postRotate(this.f18722b);
            matrix.postTranslate(m19600f() / 2, m19599e() / 2);
        }
        return matrix;
    }

    /* renamed from: d */
    public boolean m19598d() {
        return (this.f18722b / 90) % 2 != 0;
    }

    /* renamed from: e */
    public int m19599e() {
        return m19598d() ? this.f18721a.getWidth() : this.f18721a.getHeight();
    }

    /* renamed from: f */
    public int m19600f() {
        return m19598d() ? this.f18721a.getHeight() : this.f18721a.getWidth();
    }
}
