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
    ArrayList f7515a;

    /* renamed from: b */
    C2077a f7516b;

    /* renamed from: c */
    float f7517c;

    /* renamed from: d */
    float f7518d;

    /* renamed from: e */
    int f7519e;

    /* renamed from: f */
    boolean f7520f;

    /* renamed from: g */
    Context f7521g;

    @Override // com.sec.vip.cropimage.ImageViewTouchBase, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f7528j.m7433b() != null) {
            Iterator it = this.f7515a.iterator();
            while (it.hasNext()) {
                C2077a c2077a = (C2077a) it.next();
                c2077a.f7540f.set(getImageMatrix());
                c2077a.m7334c();
                if (c2077a.f7536b) {
                    m7304c(c2077a);
                }
            }
        }
        mo7272a(true, true);
    }

    public ImageModifyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7515a = new ArrayList();
        this.f7516b = null;
        this.f7520f = false;
    }

    @Override // com.sec.vip.cropimage.ImageViewTouchBase
    /* renamed from: a */
    protected void mo7270a(float f, float f2, float f3) {
        super.mo7270a(f, f2, f3);
        Iterator it = this.f7515a.iterator();
        while (it.hasNext()) {
            C2077a c2077a = (C2077a) it.next();
            c2077a.f7540f.set(getImageMatrix());
            c2077a.m7334c();
        }
    }

    @Override // com.sec.vip.cropimage.ImageViewTouchBase
    /* renamed from: a */
    protected void mo7269a(float f, float f2) {
        super.mo7269a(f, f2);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f7515a.size()) {
                C2077a c2077a = (C2077a) this.f7515a.get(i2);
                c2077a.f7540f.postTranslate(f, f2);
                c2077a.m7334c();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) throws Resources.NotFoundException {
        ImageModify imageModify = (ImageModify) this.f7521g;
        if (imageModify.f7490a) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                int i = 0;
                while (true) {
                    if (i >= this.f7515a.size()) {
                        break;
                    } else {
                        C2077a c2077a = (C2077a) this.f7515a.get(i);
                        int iM7323a = c2077a.m7323a(x, y);
                        if (iM7323a == 1) {
                            i++;
                        } else {
                            this.f7519e = iM7323a;
                            this.f7516b = c2077a;
                            this.f7517c = x;
                            this.f7518d = y;
                            this.f7520f = true;
                            if (iM7323a == 2 || iM7323a == 3 || iM7323a == 4 || iM7323a == 5) {
                                this.f7516b.m7329a(EnumC2078b.Grow_X);
                                break;
                            } else if (iM7323a == 8 || iM7323a == 9 || iM7323a == 16 || iM7323a == 17) {
                                this.f7516b.m7329a(EnumC2078b.Grow_Y);
                                break;
                            } else {
                                this.f7516b.m7329a(iM7323a == 32 ? EnumC2078b.Move : EnumC2078b.Grow);
                                break;
                            }
                        }
                    }
                }
                break;
            case 1:
                if (this.f7516b != null) {
                    m7304c(this.f7516b);
                    this.f7516b.m7329a(EnumC2078b.None);
                }
                this.f7516b = null;
                break;
            case 2:
                if (this.f7516b != null) {
                    if (this.f7519e == 32) {
                        PointF pointFM7302a = m7302a(motionEvent.getX(), motionEvent.getY(), imageModify.mo7298a(), imageModify.mo7299b(), imageModify.mo7300c());
                        if (this.f7520f) {
                            PointF pointFM7302a2 = m7302a(this.f7517c, this.f7518d, imageModify.mo7298a(), imageModify.mo7299b(), imageModify.mo7300c());
                            this.f7517c = pointFM7302a2.x;
                            this.f7518d = pointFM7302a2.y;
                            this.f7520f = false;
                        }
                        this.f7516b.m7325a(this.f7519e, pointFM7302a.x - this.f7517c, pointFM7302a.y - this.f7518d);
                        this.f7517c = pointFM7302a.x;
                        this.f7518d = pointFM7302a.y;
                    } else {
                        this.f7516b.m7325a(this.f7519e, x - this.f7517c, y - this.f7518d);
                        this.f7517c = x;
                        this.f7518d = y;
                    }
                    m7303b(this.f7516b);
                    break;
                }
                break;
        }
        switch (motionEvent.getAction()) {
            case 1:
                mo7272a(true, true);
                break;
            case 2:
                if (mo7268a() == 1.0f) {
                    mo7272a(true, true);
                    break;
                }
                break;
        }
        return true;
    }

    /* renamed from: a */
    private PointF m7302a(float f, float f2, float f3, float f4, float f5) {
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
    private void m7303b(C2077a c2077a) {
        Rect rect = c2077a.f7538d;
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
            m7313b(iMax, iMax2);
        }
    }

    /* renamed from: c */
    private void m7304c(C2077a c2077a) {
        Rect rect = c2077a.f7538d;
        float fMax = Math.max(1.0f, Math.min((getWidth() / rect.width()) * 0.6f, (getHeight() / rect.height()) * 0.6f) * mo7268a());
        if (Math.abs(fMax - mo7268a()) / fMax > 0.1d) {
            float[] fArr = {c2077a.f7539e.centerX(), c2077a.f7539e.centerY()};
            getImageMatrix().mapPoints(fArr);
            m7312a(fMax, fArr[0], fArr[1], 300.0f);
        }
        m7303b(c2077a);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f7515a.size()) {
                ((C2077a) this.f7515a.get(i2)).m7327a(canvas);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    public void m7305a(C2077a c2077a) {
        this.f7515a.add(c2077a);
        invalidate();
    }

    @Override // com.sec.vip.cropimage.ImageViewTouchBase
    /* renamed from: b */
    public void mo7273b() {
        this.f7515a.clear();
    }
}
