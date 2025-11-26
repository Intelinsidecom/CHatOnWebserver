package com.sec.vip.cropimage;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;

/* compiled from: ImageModify.java */
/* renamed from: com.sec.vip.cropimage.h */
/* loaded from: classes.dex */
class RunnableC5121h implements Runnable {

    /* renamed from: a */
    float f18692a = 1.0f;

    /* renamed from: b */
    Matrix f18693b;

    /* renamed from: c */
    final /* synthetic */ ImageModify f18694c;

    RunnableC5121h(ImageModify imageModify) {
        this.f18694c = imageModify;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m19584a() {
        int i;
        int i2;
        int i3;
        C5114a c5114a = new C5114a(this.f18694c.f18612E);
        if (this.f18694c.f18613F != null) {
            int width = this.f18694c.f18613F.getWidth();
            int height = this.f18694c.f18613F.getHeight();
            Rect rect = new Rect(0, 0, width, height);
            int iMax = Math.max(width, height);
            if (this.f18694c.f18634t == 0 || this.f18694c.f18635u == 0) {
                i = height;
                i2 = width;
            } else {
                int iMin = Math.min(width, height);
                if (this.f18694c.f18634t > this.f18694c.f18635u) {
                    int i4 = (this.f18694c.f18635u * iMin) / this.f18694c.f18634t;
                    i = (this.f18694c.f18635u * iMax) / this.f18694c.f18634t;
                    i3 = i4;
                    i2 = iMax;
                } else {
                    int i5 = (this.f18694c.f18634t * iMin) / this.f18694c.f18635u;
                    i2 = (this.f18694c.f18634t * iMax) / this.f18694c.f18635u;
                    i3 = iMin;
                    iMin = i5;
                    i = iMax;
                }
                if (i2 > width || i > height) {
                    i = i3;
                    i2 = iMin;
                }
            }
            c5114a.m19576a(this.f18693b, rect, new RectF((width - i2) / 2, (height - i) / 2, i2 + r6, i + r4), this.f18694c.f18608A, this.f18694c.f18614G, this.f18694c.f18615H, (this.f18694c.f18634t == 0 || this.f18694c.f18635u == 0) ? false : true);
            this.f18694c.f18612E.m19551a(c5114a);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f18693b = this.f18694c.f18612E.m19564c();
        this.f18692a = 1.0f / this.f18692a;
        this.f18694c.f18636v.post(new RunnableC5122i(this));
    }
}
