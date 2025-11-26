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
    ArrayList<C5114a> f18641a;

    /* renamed from: b */
    C5114a f18642b;

    /* renamed from: c */
    float f18643c;

    /* renamed from: d */
    float f18644d;

    /* renamed from: e */
    int f18645e;

    /* renamed from: f */
    boolean f18646f;

    /* renamed from: g */
    Context f18647g;

    @Override // com.sec.vip.cropimage.ImageViewTouchBase, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f18653j.m19596b() != null) {
            Iterator<C5114a> it = this.f18641a.iterator();
            while (it.hasNext()) {
                C5114a next = it.next();
                next.f18664f.set(getImageMatrix());
                next.m19582c();
                if (next.f18660b) {
                    m19547c(next);
                }
            }
        }
    }

    public ImageModifyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18641a = new ArrayList<>();
        this.f18642b = null;
        this.f18646f = false;
    }

    @Override // com.sec.vip.cropimage.ImageViewTouchBase
    /* renamed from: a */
    protected void mo19550a(float f, float f2, float f3) {
        super.mo19550a(f, f2, f3);
        Iterator<C5114a> it = this.f18641a.iterator();
        while (it.hasNext()) {
            C5114a next = it.next();
            next.f18664f.set(getImageMatrix());
            next.m19582c();
        }
    }

    @Override // com.sec.vip.cropimage.ImageViewTouchBase
    /* renamed from: a */
    protected void mo19549a(float f, float f2) {
        super.mo19549a(f, f2);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f18641a.size()) {
                C5114a c5114a = this.f18641a.get(i2);
                c5114a.f18664f.postTranslate(f, f2);
                c5114a.m19582c();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) throws Resources.NotFoundException {
        ImageModify imageModify = (ImageModify) this.f18647g;
        if (imageModify.f18629n) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                int i = 0;
                while (true) {
                    if (i >= this.f18641a.size()) {
                        break;
                    } else {
                        C5114a c5114a = this.f18641a.get(i);
                        int iM19573a = c5114a.m19573a(x, y);
                        if (iM19573a == 1) {
                            i++;
                        } else {
                            this.f18645e = iM19573a;
                            this.f18642b = c5114a;
                            this.f18643c = x;
                            this.f18644d = y;
                            this.f18646f = true;
                            this.f18642b.m19577a(iM19573a == 32 ? EnumC5115b.Move : EnumC5115b.Grow);
                            break;
                        }
                    }
                }
            case 1:
                if (this.f18642b != null) {
                    m19547c(this.f18642b);
                    this.f18642b.m19577a(EnumC5115b.None);
                }
                this.f18642b = null;
                break;
            case 2:
                if (this.f18642b != null) {
                    if (this.f18645e == 32) {
                        PointF pointFM19545a = m19545a(motionEvent.getX(), motionEvent.getY(), imageModify.m19541f(), imageModify.m19542g(), imageModify.m19543h());
                        if (this.f18646f) {
                            PointF pointFM19545a2 = m19545a(this.f18643c, this.f18644d, imageModify.m19541f(), imageModify.m19542g(), imageModify.m19543h());
                            this.f18643c = pointFM19545a2.x;
                            this.f18644d = pointFM19545a2.y;
                            this.f18646f = false;
                        }
                        this.f18642b.m19574a(this.f18645e, pointFM19545a.x - this.f18643c, pointFM19545a.y - this.f18644d);
                        this.f18643c = pointFM19545a.x;
                        this.f18644d = pointFM19545a.y;
                    } else {
                        this.f18642b.m19574a(this.f18645e, x - this.f18643c, y - this.f18644d);
                        this.f18643c = x;
                        this.f18644d = y;
                    }
                    m19546b(this.f18642b);
                    break;
                }
                break;
        }
        switch (motionEvent.getAction()) {
            case 1:
                m19561a(true, true);
                break;
            case 2:
                if (m19562b() == 1.0f) {
                    m19561a(true, true);
                    break;
                }
                break;
        }
        return true;
    }

    /* renamed from: a */
    private PointF m19545a(float f, float f2, float f3, float f4, float f5) {
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
    private void m19546b(C5114a c5114a) {
        Rect rect = c5114a.f18662d;
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
        int i = rect.width() > getWidth() ? 0 : iMax;
        int i2 = rect.height() <= getHeight() ? iMax2 : 0;
        if (i != 0 || i2 != 0) {
            m19563b(i, i2);
        }
    }

    /* renamed from: c */
    private void m19547c(C5114a c5114a) {
        Rect rect = c5114a.f18662d;
        float fMax = Math.max(1.0f, Math.min((getWidth() / rect.width()) * 0.6f, (getHeight() / rect.height()) * 0.6f) * m19562b());
        if (Math.abs(fMax - m19562b()) / fMax > 0.1d) {
            float[] fArr = {c5114a.f18663e.centerX(), c5114a.f18663e.centerY()};
            getImageMatrix().mapPoints(fArr);
            m19558a(fMax, fArr[0], fArr[1], 300.0f);
        }
        m19546b(c5114a);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) throws Throwable {
        super.onDraw(canvas);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f18641a.size()) {
                this.f18641a.get(i2).m19575a(canvas);
                m19546b(this.f18641a.get(i2));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    public void m19551a(C5114a c5114a) {
        this.f18641a.add(c5114a);
        invalidate();
    }

    @Override // com.sec.vip.cropimage.ImageViewTouchBase
    /* renamed from: a */
    public void mo19548a() {
        this.f18641a.clear();
    }
}
