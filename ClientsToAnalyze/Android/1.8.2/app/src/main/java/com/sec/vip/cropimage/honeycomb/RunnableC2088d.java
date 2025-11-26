package com.sec.vip.cropimage.honeycomb;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import com.sec.vip.cropimage.C2077a;

/* compiled from: CropImage.java */
/* renamed from: com.sec.vip.cropimage.honeycomb.d */
/* loaded from: classes.dex */
class RunnableC2088d implements Runnable {

    /* renamed from: a */
    float f7608a = 1.0f;

    /* renamed from: b */
    Matrix f7609b;

    /* renamed from: c */
    final /* synthetic */ CropImage f7610c;

    RunnableC2088d(CropImage cropImage) {
        this.f7610c = cropImage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7379a() {
        int i;
        int i2;
        boolean z = false;
        C2077a c2077a = new C2077a(this.f7610c.f7591o);
        int width = this.f7610c.f7592p.getWidth();
        int height = this.f7610c.f7592p.getHeight();
        Rect rect = new Rect(0, 0, width, height);
        int iMin = (Math.min(width, height) * 4) / 5;
        if (this.f7610c.f7581d == 0 || this.f7610c.f7582f == 0) {
            i = iMin;
            i2 = iMin;
        } else if (this.f7610c.f7581d > this.f7610c.f7582f) {
            i = (this.f7610c.f7582f * iMin) / this.f7610c.f7581d;
            i2 = iMin;
        } else {
            i2 = (this.f7610c.f7581d * iMin) / this.f7610c.f7582f;
            i = iMin;
        }
        RectF rectF = new RectF((width - i2) / 2, (height - i) / 2, i2 + r5, i + r6);
        Matrix matrix = this.f7609b;
        boolean z2 = this.f7610c.f7588l;
        int i3 = this.f7610c.f7594r;
        int i4 = this.f7610c.f7595s;
        if (this.f7610c.f7581d != 0 && this.f7610c.f7582f != 0) {
            z = true;
        }
        c2077a.m7328a(matrix, rect, rectF, z2, i3, i4, z);
        this.f7610c.f7591o.m7271a(c2077a);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f7609b = this.f7610c.f7591o.getImageMatrix();
        this.f7608a = 1.0f / this.f7608a;
        this.f7610c.f7583g.post(new RunnableC2089e(this));
    }
}
