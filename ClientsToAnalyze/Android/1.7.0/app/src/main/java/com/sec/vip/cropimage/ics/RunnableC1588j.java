package com.sec.vip.cropimage.ics;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import com.sec.vip.cropimage.C1598o;

/* compiled from: CropImage.java */
/* renamed from: com.sec.vip.cropimage.ics.j */
/* loaded from: classes.dex */
class RunnableC1588j implements Runnable {

    /* renamed from: a */
    float f5606a = 1.0f;

    /* renamed from: b */
    Matrix f5607b;

    /* renamed from: c */
    final /* synthetic */ CropImage f5608c;

    RunnableC1588j(CropImage cropImage) {
        this.f5608c = cropImage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m5813a() {
        int i;
        int i2;
        boolean z = false;
        C1598o c1598o = new C1598o(this.f5608c.f5576n);
        int width = this.f5608c.f5577o.getWidth();
        int height = this.f5608c.f5577o.getHeight();
        Rect rect = new Rect(0, 0, width, height);
        int iMin = (Math.min(width, height) * 4) / 5;
        if (this.f5608c.f5566c == 0 || this.f5608c.f5567d == 0) {
            i = iMin;
            i2 = iMin;
        } else if (this.f5608c.f5566c > this.f5608c.f5567d) {
            i = (this.f5608c.f5567d * iMin) / this.f5608c.f5566c;
            i2 = iMin;
        } else {
            i2 = (this.f5608c.f5566c * iMin) / this.f5608c.f5567d;
            i = iMin;
        }
        RectF rectF = new RectF((width - i2) / 2, (height - i) / 2, i2 + r5, i + r6);
        Matrix matrix = this.f5607b;
        boolean z2 = this.f5608c.f5573k;
        int i3 = this.f5608c.f5579q;
        int i4 = this.f5608c.f5580r;
        if (this.f5608c.f5566c != 0 && this.f5608c.f5567d != 0) {
            z = true;
        }
        c1598o.m5827a(matrix, rect, rectF, z2, i3, i4, z);
        this.f5608c.f5576n.m5677a(c1598o);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f5607b = this.f5608c.f5576n.getImageMatrix();
        this.f5606a = 1.0f / this.f5606a;
        this.f5608c.f5568f.post(new RunnableC1591m(this));
    }
}
