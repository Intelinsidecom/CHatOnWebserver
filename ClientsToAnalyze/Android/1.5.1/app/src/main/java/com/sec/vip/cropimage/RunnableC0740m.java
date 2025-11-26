package com.sec.vip.cropimage;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;

/* renamed from: com.sec.vip.cropimage.m */
/* loaded from: classes.dex */
class RunnableC0740m implements Runnable {

    /* renamed from: a */
    float f4480a = 1.0f;

    /* renamed from: b */
    Matrix f4481b;

    /* renamed from: c */
    final /* synthetic */ ImageModify f4482c;

    RunnableC0740m(ImageModify imageModify) {
        this.f4482c = imageModify;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m4346a() {
        int i;
        int i2;
        int i3;
        C0742o c0742o = new C0742o(this.f4482c.f4413o);
        int width = this.f4482c.f4414p.getWidth();
        int height = this.f4482c.f4414p.getHeight();
        Rect rect = new Rect(0, 0, width, height);
        if ((width - height) * (this.f4482c.f4403e - this.f4482c.f4404f) > 0) {
        }
        int iMax = Math.max(width, height);
        if (this.f4482c.f4403e == 0 || this.f4482c.f4404f == 0) {
            iMax = height;
            i = width;
        } else {
            int iMin = Math.min(width, height);
            if (this.f4482c.f4403e > this.f4482c.f4404f) {
                i3 = (this.f4482c.f4404f * iMin) / this.f4482c.f4403e;
                i2 = iMin;
                i = iMax;
                iMax = (this.f4482c.f4404f * iMax) / this.f4482c.f4403e;
            } else {
                i2 = (this.f4482c.f4403e * iMin) / this.f4482c.f4404f;
                i3 = iMin;
                i = (this.f4482c.f4403e * iMax) / this.f4482c.f4404f;
            }
            if (i > width || iMax > height) {
                iMax = i3;
                i = i2;
            }
        }
        c0742o.m4358a(this.f4481b, rect, new RectF((width - i) / 2, (height - iMax) / 2, r1 + i, iMax + r6), this.f4482c.f4410l, this.f4482c.f4415q, this.f4482c.f4416r, (this.f4482c.f4403e == 0 || this.f4482c.f4404f == 0) ? false : true);
        this.f4482c.f4413o.m4314a(c0742o);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4481b = this.f4482c.f4413o.m4327c();
        this.f4480a = 1.0f / this.f4480a;
        this.f4482c.f4405g.post(new RunnableC0724a(this));
    }
}
