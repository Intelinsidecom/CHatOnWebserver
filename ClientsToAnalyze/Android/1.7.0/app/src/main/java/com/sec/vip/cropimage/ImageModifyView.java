package com.sec.vip.cropimage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ImageModify.java */
/* loaded from: classes.dex */
class ImageModifyView extends ImageViewTouchBase {

    /* renamed from: a */
    ArrayList f5476a;

    /* renamed from: b */
    C1598o f5477b;

    /* renamed from: c */
    float f5478c;

    /* renamed from: d */
    float f5479d;

    /* renamed from: e */
    int f5480e;

    /* renamed from: f */
    boolean f5481f;

    /* renamed from: g */
    Context f5482g;

    @Override // com.sec.vip.cropimage.ImageViewTouchBase, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f5489j.m5735b() != null) {
            Iterator it = this.f5476a.iterator();
            while (it.hasNext()) {
                C1598o c1598o = (C1598o) it.next();
                c1598o.f5626f.set(getImageMatrix());
                c1598o.m5833c();
                if (c1598o.f5622b) {
                    m5714c(c1598o);
                }
            }
        }
    }

    public ImageModifyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5476a = new ArrayList();
        this.f5477b = null;
        this.f5481f = false;
    }

    @Override // com.sec.vip.cropimage.ImageViewTouchBase
    /* renamed from: a */
    protected void mo5676a(float f, float f2, float f3) {
        super.mo5676a(f, f2, f3);
        Iterator it = this.f5476a.iterator();
        while (it.hasNext()) {
            C1598o c1598o = (C1598o) it.next();
            c1598o.f5626f.set(getImageMatrix());
            c1598o.m5833c();
        }
    }

    @Override // com.sec.vip.cropimage.ImageViewTouchBase
    /* renamed from: a */
    protected void mo5675a(float f, float f2) {
        super.mo5675a(f, f2);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f5476a.size()) {
                C1598o c1598o = (C1598o) this.f5476a.get(i2);
                c1598o.f5626f.postTranslate(f, f2);
                c1598o.m5833c();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) throws Resources.NotFoundException {
        ImageModify imageModify = (ImageModify) this.f5482g;
        if (imageModify.f5451a) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                int i = 0;
                while (true) {
                    if (i >= this.f5476a.size()) {
                        break;
                    } else {
                        C1598o c1598o = (C1598o) this.f5476a.get(i);
                        int iM5822a = c1598o.m5822a(x, y);
                        if (iM5822a == 1) {
                            i++;
                        } else {
                            this.f5480e = iM5822a;
                            this.f5477b = c1598o;
                            this.f5478c = x;
                            this.f5479d = y;
                            this.f5481f = true;
                            this.f5477b.m5828a(iM5822a == 32 ? EnumC1564c.Move : EnumC1564c.Grow);
                            break;
                        }
                    }
                }
            case 1:
                if (this.f5477b != null) {
                    m5714c(this.f5477b);
                    this.f5477b.m5828a(EnumC1564c.None);
                }
                this.f5477b = null;
                break;
            case 2:
                if (this.f5477b != null) {
                    if (this.f5480e == 32) {
                        PointF pointFM5712a = m5712a(motionEvent.getX(), motionEvent.getY(), imageModify.mo5709a(), imageModify.mo5710b(), imageModify.mo5711c());
                        if (this.f5481f) {
                            PointF pointFM5712a2 = m5712a(this.f5478c, this.f5479d, imageModify.mo5709a(), imageModify.mo5710b(), imageModify.mo5711c());
                            this.f5478c = pointFM5712a2.x;
                            this.f5479d = pointFM5712a2.y;
                            this.f5481f = false;
                        }
                        this.f5477b.m5824a(this.f5480e, pointFM5712a.x - this.f5478c, pointFM5712a.y - this.f5479d);
                        this.f5478c = pointFM5712a.x;
                        this.f5479d = pointFM5712a.y;
                    } else {
                        this.f5477b.m5824a(this.f5480e, x - this.f5478c, y - this.f5479d);
                        this.f5478c = x;
                        this.f5479d = y;
                    }
                    m5713b(this.f5477b);
                    break;
                }
                break;
        }
        switch (motionEvent.getAction()) {
            case 1:
                mo5678a(true, true);
                break;
            case 2:
                if (mo5674a() == 1.0f) {
                    mo5678a(true, true);
                    break;
                }
                break;
        }
        return true;
    }

    /* renamed from: a */
    private PointF m5712a(float f, float f2, float f3, float f4, float f5) {
        PointF pointF = new PointF(0.0f, 0.0f);
        switch ((int) f5) {
            case 90:
                pointF.set(f2, f3 - f);
                return pointF;
            case 180:
                pointF.set(f3 - f, f4 - f2);
                return pointF;
            case 270:
                pointF.set(f4 - f2, f);
                return pointF;
            default:
                pointF.set(f, f2);
                return pointF;
        }
    }

    /* renamed from: b */
    private void m5713b(C1598o c1598o) {
        Rect rect = c1598o.f5624d;
        int iMax = Math.max(0, getLeft() - rect.left);
        int iMin = Math.min(0, getRight() - rect.right);
        int iMax2 = Math.max(0, getTop() - rect.top);
        int iMin2 = Math.min(0, getBottom() - rect.bottom);
        if (iMax == 0) {
            iMax = iMin;
        }
        if (iMax2 == 0) {
            iMax2 = iMin2;
        }
        if (iMax != 0 || iMax2 != 0) {
            m5723b(iMax, iMax2);
        }
    }

    /* renamed from: c */
    private void m5714c(C1598o c1598o) {
        Rect rect = c1598o.f5624d;
        float fMax = Math.max(1.0f, Math.min((getWidth() / rect.width()) * 0.6f, (getHeight() / rect.height()) * 0.6f) * mo5674a());
        if (Math.abs(fMax - mo5674a()) / fMax > 0.1d) {
            float[] fArr = {c1598o.f5625e.centerX(), c1598o.f5625e.centerY()};
            getImageMatrix().mapPoints(fArr);
            m5722a(fMax, fArr[0], fArr[1], 300.0f);
        }
        m5713b(c1598o);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f5476a.size()) {
                ((C1598o) this.f5476a.get(i2)).m5826a(canvas);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    public void m5715a(C1598o c1598o) {
        this.f5476a.add(c1598o);
        invalidate();
    }

    @Override // com.sec.vip.cropimage.ImageViewTouchBase
    /* renamed from: b */
    public void mo5679b() {
        this.f5476a.clear();
    }
}
