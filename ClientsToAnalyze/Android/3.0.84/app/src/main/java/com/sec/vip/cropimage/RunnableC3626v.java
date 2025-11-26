package com.sec.vip.cropimage;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;

/* compiled from: ImageModify.java */
/* renamed from: com.sec.vip.cropimage.v */
/* loaded from: classes.dex */
class RunnableC3626v implements Runnable {

    /* renamed from: a */
    float f13334a = 1.0f;

    /* renamed from: b */
    Matrix f13335b;

    /* renamed from: c */
    final /* synthetic */ ImageModify f13336c;

    RunnableC3626v(ImageModify imageModify) {
        this.f13336c = imageModify;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m13017a() {
        int i;
        int i2;
        int i3;
        C3619o c3619o = new C3619o(this.f13336c.f13221s);
        if (this.f13336c.f13222t != null) {
            int width = this.f13336c.f13222t.getWidth();
            int height = this.f13336c.f13222t.getHeight();
            Rect rect = new Rect(0, 0, width, height);
            int iMax = Math.max(width, height);
            if (this.f13336c.f13210h == 0 || this.f13336c.f13211i == 0) {
                i = height;
                i2 = width;
            } else {
                int iMin = Math.min(width, height);
                if (this.f13336c.f13210h > this.f13336c.f13211i) {
                    int i4 = (this.f13336c.f13211i * iMin) / this.f13336c.f13210h;
                    i = (this.f13336c.f13211i * iMax) / this.f13336c.f13210h;
                    i3 = i4;
                    i2 = iMax;
                } else {
                    int i5 = (this.f13336c.f13210h * iMin) / this.f13336c.f13211i;
                    i2 = (this.f13336c.f13210h * iMax) / this.f13336c.f13211i;
                    i3 = iMin;
                    iMin = i5;
                    i = iMax;
                }
                if (i2 > width || i > height) {
                    i = i3;
                    i2 = iMin;
                }
            }
            c3619o.m13009a(this.f13335b, rect, new RectF((width - i2) / 2, (height - i) / 2, i2 + r6, i + r4), this.f13336c.f13217o, this.f13336c.f13223u, this.f13336c.f13224v, (this.f13336c.f13210h == 0 || this.f13336c.f13211i == 0) ? false : true);
            this.f13336c.f13221s.m12963a(c3619o);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f13335b = this.f13336c.f13221s.m12972c();
        this.f13334a = 1.0f / this.f13334a;
        this.f13336c.f13212j.post(new RunnableC3627w(this));
    }
}
