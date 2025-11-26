package com.sec.vip.cropimage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
class ImageModifyView extends ImageViewTouchBase {

    /* renamed from: a */
    ArrayList f4425a;

    /* renamed from: b */
    C0742o f4426b;

    /* renamed from: c */
    float f4427c;

    /* renamed from: d */
    float f4428d;

    /* renamed from: e */
    int f4429e;

    /* renamed from: f */
    boolean f4430f;

    /* renamed from: g */
    Context f4431g;

    public ImageModifyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4425a = new ArrayList();
        this.f4426b = null;
        this.f4430f = false;
    }

    /* renamed from: a */
    private PointF m4310a(float f, float f2, float f3, float f4, float f5) {
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
    private void m4311b(C0742o c0742o) {
        Rect rect = c0742o.f4489d;
        int iMax = Math.max(0, getLeft() - rect.left);
        int iMin = Math.min(0, getRight() - rect.right);
        int iMax2 = Math.max(0, getTop() - rect.top);
        int iMin2 = Math.min(0, getBottom() - rect.bottom);
        if (iMax == 0) {
            iMax = iMin;
        }
        if (iMax2 != 0) {
            iMin2 = iMax2;
        }
        if (iMax == 0 && iMin2 == 0) {
            return;
        }
        m4326b(iMax, iMin2);
    }

    /* renamed from: c */
    private void m4312c(C0742o c0742o) {
        Rect rect = c0742o.f4489d;
        float fMax = Math.max(1.0f, Math.min((getWidth() / rect.width()) * 0.6f, (getHeight() / rect.height()) * 0.6f) * m4325b());
        if (Math.abs(fMax - m4325b()) / fMax > 0.1d) {
            float[] fArr = {c0742o.f4490e.centerX(), c0742o.f4490e.centerY()};
            getImageMatrix().mapPoints(fArr);
            m4321a(fMax, fArr[0], fArr[1], 300.0f);
        }
        m4311b(c0742o);
    }

    @Override // com.sec.vip.cropimage.ImageViewTouchBase
    /* renamed from: a */
    public void mo4313a() {
        this.f4425a.clear();
    }

    @Override // com.sec.vip.cropimage.ImageViewTouchBase
    /* renamed from: a */
    protected void mo4277a(float f, float f2) {
        super.mo4277a(f, f2);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f4425a.size()) {
                return;
            }
            C0742o c0742o = (C0742o) this.f4425a.get(i2);
            c0742o.f4491f.postTranslate(f, f2);
            c0742o.m4364c();
            i = i2 + 1;
        }
    }

    @Override // com.sec.vip.cropimage.ImageViewTouchBase
    /* renamed from: a */
    protected void mo4278a(float f, float f2, float f3) {
        super.mo4278a(f, f2, f3);
        Iterator it = this.f4425a.iterator();
        while (it.hasNext()) {
            C0742o c0742o = (C0742o) it.next();
            c0742o.f4491f.set(getImageMatrix());
            c0742o.m4364c();
        }
    }

    /* renamed from: a */
    public void m4314a(C0742o c0742o) {
        this.f4425a.add(c0742o);
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f4425a.size()) {
                return;
            }
            ((C0742o) this.f4425a.get(i2)).m4357a(canvas);
            i = i2 + 1;
        }
    }

    @Override // com.sec.vip.cropimage.ImageViewTouchBase, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f4438j.m4339b() != null) {
            Iterator it = this.f4425a.iterator();
            while (it.hasNext()) {
                C0742o c0742o = (C0742o) it.next();
                c0742o.f4491f.set(getImageMatrix());
                c0742o.m4364c();
                if (c0742o.f4487b) {
                    m4312c(c0742o);
                }
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ImageModify imageModify = (ImageModify) this.f4431g;
        if (imageModify.f4399a) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                int i = 0;
                while (true) {
                    if (i >= this.f4425a.size()) {
                        break;
                    } else {
                        C0742o c0742o = (C0742o) this.f4425a.get(i);
                        int iM4353a = c0742o.m4353a(x, y);
                        if (iM4353a != 1) {
                            this.f4429e = iM4353a;
                            this.f4426b = c0742o;
                            this.f4427c = x;
                            this.f4428d = y;
                            this.f4430f = true;
                            this.f4426b.m4359a(iM4353a == 32 ? EnumC0729b.Move : EnumC0729b.Grow);
                            break;
                        } else {
                            i++;
                        }
                    }
                }
            case 1:
                if (this.f4426b != null) {
                    m4312c(this.f4426b);
                    this.f4426b.m4359a(EnumC0729b.None);
                }
                this.f4426b = null;
                break;
            case 2:
                if (this.f4426b != null) {
                    if (this.f4429e == 32) {
                        PointF pointFM4310a = m4310a(motionEvent.getX(), motionEvent.getY(), imageModify.m4307a(), imageModify.m4308b(), imageModify.m4309c());
                        if (this.f4430f) {
                            PointF pointFM4310a2 = m4310a(this.f4427c, this.f4428d, imageModify.m4307a(), imageModify.m4308b(), imageModify.m4309c());
                            this.f4427c = pointFM4310a2.x;
                            this.f4428d = pointFM4310a2.y;
                            this.f4430f = false;
                        }
                        this.f4426b.m4355a(this.f4429e, pointFM4310a.x - this.f4427c, pointFM4310a.y - this.f4428d);
                        this.f4427c = pointFM4310a.x;
                        this.f4428d = pointFM4310a.y;
                    } else {
                        this.f4426b.m4355a(this.f4429e, x - this.f4427c, y - this.f4428d);
                        this.f4427c = x;
                        this.f4428d = y;
                    }
                    m4311b(this.f4426b);
                    break;
                }
                break;
        }
        switch (motionEvent.getAction()) {
            case 1:
                m4324a(true, true);
                break;
            case 2:
                if (m4325b() == 1.0f) {
                    m4324a(true, true);
                    break;
                }
                break;
        }
        return true;
    }
}
