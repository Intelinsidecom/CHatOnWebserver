package com.sec.vip.cropimage;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;

/* compiled from: CropImage.java */
/* renamed from: com.sec.vip.cropimage.f */
/* loaded from: classes.dex */
class RunnableC3610f implements Runnable {

    /* renamed from: a */
    float f13280a = 1.0f;

    /* renamed from: b */
    Matrix f13281b;

    /* renamed from: c */
    final /* synthetic */ CropImage f13282c;

    RunnableC3610f(CropImage cropImage) {
        this.f13282c = cropImage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m12992a() {
        int i;
        int i2;
        boolean z = false;
        C3619o c3619o = new C3619o(this.f13282c.f13165c);
        int width = this.f13282c.f13176o.getWidth();
        int height = this.f13282c.f13176o.getHeight();
        Rect rect = new Rect(0, 0, width, height);
        int iMin = (Math.min(width, height) * 4) / 5;
        if (this.f13282c.f13166d == 0 || this.f13282c.f13167f == 0) {
            i = iMin;
            i2 = iMin;
        } else if (this.f13282c.f13166d > this.f13282c.f13167f) {
            i = (this.f13282c.f13167f * iMin) / this.f13282c.f13166d;
            i2 = iMin;
        } else {
            i2 = (this.f13282c.f13166d * iMin) / this.f13282c.f13167f;
            i = iMin;
        }
        RectF rectF = new RectF((width - i2) / 2, (height - i) / 2, i2 + r5, i + r6);
        Matrix matrix = this.f13281b;
        boolean z2 = this.f13282c.f13173l;
        int i3 = this.f13282c.f13182u;
        int i4 = this.f13282c.f13183v;
        if (this.f13282c.f13166d != 0 && this.f13282c.f13167f != 0) {
            z = true;
        }
        c3619o.m13009a(matrix, rect, rectF, z2, i3, i4, z);
        this.f13282c.f13165c.m12925a(c3619o);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f13281b = this.f13282c.f13165c.getImageMatrix();
        this.f13280a = 1.0f / this.f13280a;
        this.f13282c.f13168g.post(new RunnableC3611g(this));
    }
}
