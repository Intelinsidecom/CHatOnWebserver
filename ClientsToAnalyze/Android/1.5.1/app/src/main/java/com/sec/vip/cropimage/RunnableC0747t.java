package com.sec.vip.cropimage;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;

/* renamed from: com.sec.vip.cropimage.t */
/* loaded from: classes.dex */
class RunnableC0747t implements Runnable {

    /* renamed from: a */
    float f4514a = 1.0f;

    /* renamed from: b */
    Matrix f4515b;

    /* renamed from: c */
    final /* synthetic */ CropImage f4516c;

    RunnableC0747t(CropImage cropImage) {
        this.f4516c = cropImage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m4366a() {
        int i;
        C0742o c0742o = new C0742o(this.f4516c.f4375n);
        int width = this.f4516c.f4376o.getWidth();
        int height = this.f4516c.f4376o.getHeight();
        Rect rect = new Rect(0, 0, width, height);
        int iMin = (Math.min(width, height) * 4) / 5;
        if (this.f4516c.f4365d == 0 || this.f4516c.f4366e == 0) {
            i = iMin;
        } else if (this.f4516c.f4365d > this.f4516c.f4366e) {
            i = iMin;
            iMin = (this.f4516c.f4366e * iMin) / this.f4516c.f4365d;
        } else {
            i = (this.f4516c.f4365d * iMin) / this.f4516c.f4366e;
        }
        c0742o.m4358a(this.f4515b, rect, new RectF((width - i) / 2, (height - iMin) / 2, r1 + i, iMin + r6), this.f4516c.f4372k, this.f4516c.f4378q, this.f4516c.f4379r, (this.f4516c.f4365d == 0 || this.f4516c.f4366e == 0) ? false : true);
        this.f4516c.f4375n.m4279a(c0742o);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4515b = this.f4516c.f4375n.getImageMatrix();
        this.f4514a = 1.0f / this.f4514a;
        this.f4516c.f4367f.post(new RunnableC0743p(this));
    }
}
