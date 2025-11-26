package com.sec.vip.cropimage;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;

/* compiled from: ImageModify.java */
/* renamed from: com.sec.vip.cropimage.m */
/* loaded from: classes.dex */
class RunnableC1596m implements Runnable {

    /* renamed from: a */
    float f5616a = 1.0f;

    /* renamed from: b */
    Matrix f5617b;

    /* renamed from: c */
    final /* synthetic */ ImageModify f5618c;

    RunnableC1596m(ImageModify imageModify) {
        this.f5618c = imageModify;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m5815a() {
        int i;
        int i2;
        int i3;
        C1598o c1598o = new C1598o(this.f5618c.f5467r);
        if (this.f5618c.f5468s != null) {
            int width = this.f5618c.f5468s.getWidth();
            int height = this.f5618c.f5468s.getHeight();
            Rect rect = new Rect(0, 0, width, height);
            if ((width - height) * (this.f5618c.f5457h - this.f5618c.f5458i) > 0) {
            }
            int iMax = Math.max(width, height);
            if (this.f5618c.f5457h == 0 || this.f5618c.f5458i == 0) {
                i = height;
                i2 = width;
            } else {
                int iMin = Math.min(width, height);
                if (this.f5618c.f5457h > this.f5618c.f5458i) {
                    int i4 = (this.f5618c.f5458i * iMin) / this.f5618c.f5457h;
                    i = (this.f5618c.f5458i * iMax) / this.f5618c.f5457h;
                    i3 = i4;
                    i2 = iMax;
                } else {
                    int i5 = (this.f5618c.f5457h * iMin) / this.f5618c.f5458i;
                    i2 = (this.f5618c.f5457h * iMax) / this.f5618c.f5458i;
                    i3 = iMin;
                    iMin = i5;
                    i = iMax;
                }
                if (i2 > width || i > height) {
                    i = i3;
                    i2 = iMin;
                }
            }
            c1598o.m5827a(this.f5617b, rect, new RectF((width - i2) / 2, (height - i) / 2, i2 + r6, i + r4), this.f5618c.f5464o, this.f5618c.f5469t, this.f5618c.f5470u, (this.f5618c.f5457h == 0 || this.f5618c.f5458i == 0) ? false : true);
            this.f5618c.f5467r.m5715a(c1598o);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f5617b = this.f5618c.f5467r.m5724c();
        this.f5616a = 1.0f / this.f5616a;
        this.f5618c.f5459j.post(new RunnableC1563b(this));
    }
}
