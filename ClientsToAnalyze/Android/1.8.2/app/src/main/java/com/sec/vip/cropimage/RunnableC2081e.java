package com.sec.vip.cropimage;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;

/* compiled from: ImageModify.java */
/* renamed from: com.sec.vip.cropimage.e */
/* loaded from: classes.dex */
class RunnableC2081e implements Runnable {

    /* renamed from: a */
    float f7567a = 1.0f;

    /* renamed from: b */
    Matrix f7568b;

    /* renamed from: c */
    final /* synthetic */ ImageModify f7569c;

    RunnableC2081e(ImageModify imageModify) {
        this.f7569c = imageModify;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7336a() {
        int i;
        int i2;
        int i3;
        boolean z = false;
        C2077a c2077a = new C2077a(this.f7569c.f7505q);
        try {
            int width = this.f7569c.f7506r.getWidth();
            int height = this.f7569c.f7506r.getHeight();
            Rect rect = new Rect(0, 0, width, height);
            if ((width - height) * (this.f7569c.f7494f - this.f7569c.f7495g) > 0) {
            }
            int iMax = Math.max(width, height);
            if (this.f7569c.f7494f == 0 || this.f7569c.f7495g == 0) {
                i = height;
                i2 = width;
            } else {
                int iMin = Math.min(width, height);
                if (this.f7569c.f7494f > this.f7569c.f7495g) {
                    int i4 = (this.f7569c.f7495g * iMin) / this.f7569c.f7494f;
                    i = (this.f7569c.f7495g * iMax) / this.f7569c.f7494f;
                    i3 = i4;
                    i2 = iMax;
                } else {
                    int i5 = (this.f7569c.f7494f * iMin) / this.f7569c.f7495g;
                    i2 = (this.f7569c.f7494f * iMax) / this.f7569c.f7495g;
                    i3 = iMin;
                    iMin = i5;
                    i = iMax;
                }
                if (i2 > width || i > height) {
                    i = i3;
                    i2 = iMin;
                }
            }
            Log.d("xx", "width : " + width + " height : " + height + " cropW : " + i2 + " cropH : " + i);
            RectF rectF = new RectF((width - i2) / 2, (height - i) / 2, i2 + r6, i + r9);
            Matrix matrix = this.f7568b;
            boolean z2 = this.f7569c.f7501m;
            int i6 = this.f7569c.f7507s;
            int i7 = this.f7569c.f7508t;
            if (this.f7569c.f7494f != 0 && this.f7569c.f7495g != 0) {
                z = true;
            }
            c2077a.m7328a(matrix, rect, rectF, z2, i6, i7, z);
            this.f7569c.f7505q.m7305a(c2077a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f7568b = this.f7569c.f7505q.m7314c();
        this.f7567a = 1.0f / this.f7567a;
        this.f7569c.f7496h.post(new RunnableC2082f(this));
    }
}
