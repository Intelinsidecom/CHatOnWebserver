package com.sec.vip.cropimage.ics;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import com.sec.vip.cropimage.C2077a;

/* compiled from: CropImage.java */
/* renamed from: com.sec.vip.cropimage.ics.g */
/* loaded from: classes.dex */
class RunnableC2106g implements Runnable {

    /* renamed from: a */
    float f7668a = 1.0f;

    /* renamed from: b */
    Matrix f7669b;

    /* renamed from: c */
    final /* synthetic */ CropImage f7670c;

    RunnableC2106g(CropImage cropImage) {
        this.f7670c = cropImage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7424a() {
        int i;
        int i2;
        boolean z = false;
        C2077a c2077a = new C2077a(this.f7670c.f7647n);
        int width = this.f7670c.f7648o.getWidth();
        int height = this.f7670c.f7648o.getHeight();
        Rect rect = new Rect(0, 0, width, height);
        int iMin = (Math.min(width, height) * 4) / 5;
        if (this.f7670c.f7637c == 0 || this.f7670c.f7638d == 0) {
            i = iMin;
            i2 = iMin;
        } else if (this.f7670c.f7637c > this.f7670c.f7638d) {
            i = (this.f7670c.f7638d * iMin) / this.f7670c.f7637c;
            i2 = iMin;
        } else {
            i2 = (this.f7670c.f7637c * iMin) / this.f7670c.f7638d;
            i = iMin;
        }
        RectF rectF = new RectF((width - i2) / 2, (height - i) / 2, i2 + r5, i + r6);
        Matrix matrix = this.f7669b;
        boolean z2 = this.f7670c.f7644k;
        int i3 = this.f7670c.f7650q;
        int i4 = this.f7670c.f7651r;
        if (this.f7670c.f7637c != 0 && this.f7670c.f7638d != 0) {
            z = true;
        }
        c2077a.m7328a(matrix, rect, rectF, z2, i3, i4, z);
        this.f7670c.f7647n.m7271a(c2077a);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f7669b = this.f7670c.f7647n.getImageMatrix();
        this.f7668a = 1.0f / this.f7668a;
        this.f7670c.f7639f.post(new RunnableC2107h(this));
    }
}
