package com.sec.vip.cropimage.honeycomb;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import com.sec.vip.cropimage.C1598o;

/* compiled from: CropImage.java */
/* renamed from: com.sec.vip.cropimage.honeycomb.c */
/* loaded from: classes.dex */
class RunnableC1572c implements Runnable {

    /* renamed from: a */
    float f5546a = 1.0f;

    /* renamed from: b */
    Matrix f5547b;

    /* renamed from: c */
    final /* synthetic */ CropImage f5548c;

    RunnableC1572c(CropImage cropImage) {
        this.f5548c = cropImage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m5770a() {
        int i;
        int i2;
        boolean z = false;
        C1598o c1598o = new C1598o(this.f5548c.f5529n);
        int width = this.f5548c.f5530o.getWidth();
        int height = this.f5548c.f5530o.getHeight();
        Rect rect = new Rect(0, 0, width, height);
        int iMin = (Math.min(width, height) * 4) / 5;
        if (this.f5548c.f5519c == 0 || this.f5548c.f5520d == 0) {
            i = iMin;
            i2 = iMin;
        } else if (this.f5548c.f5519c > this.f5548c.f5520d) {
            i = (this.f5548c.f5520d * iMin) / this.f5548c.f5519c;
            i2 = iMin;
        } else {
            i2 = (this.f5548c.f5519c * iMin) / this.f5548c.f5520d;
            i = iMin;
        }
        RectF rectF = new RectF((width - i2) / 2, (height - i) / 2, i2 + r5, i + r6);
        Matrix matrix = this.f5547b;
        boolean z2 = this.f5548c.f5526k;
        int i3 = this.f5548c.f5532q;
        int i4 = this.f5548c.f5533r;
        if (this.f5548c.f5519c != 0 && this.f5548c.f5520d != 0) {
            z = true;
        }
        c1598o.m5827a(matrix, rect, rectF, z2, i3, i4, z);
        this.f5548c.f5529n.m5677a(c1598o);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f5547b = this.f5548c.f5529n.getImageMatrix();
        this.f5546a = 1.0f / this.f5546a;
        this.f5548c.f5521f.post(new RunnableC1571b(this));
    }
}
