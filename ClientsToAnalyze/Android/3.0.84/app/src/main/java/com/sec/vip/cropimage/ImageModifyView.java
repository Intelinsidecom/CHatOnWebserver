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
    ArrayList<C3619o> f13229a;

    /* renamed from: b */
    C3619o f13230b;

    /* renamed from: c */
    float f13231c;

    /* renamed from: d */
    float f13232d;

    /* renamed from: e */
    int f13233e;

    /* renamed from: f */
    boolean f13234f;

    /* renamed from: g */
    Context f13235g;

    @Override // com.sec.vip.cropimage.ImageViewTouchBase, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f13242j.m12987b() != null) {
            Iterator<C3619o> it = this.f13229a.iterator();
            while (it.hasNext()) {
                C3619o next = it.next();
                next.f13306f.set(getImageMatrix());
                next.m13015c();
                if (next.f13302b) {
                    m12962c(next);
                }
            }
        }
    }

    public ImageModifyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13229a = new ArrayList<>();
        this.f13230b = null;
        this.f13234f = false;
    }

    @Override // com.sec.vip.cropimage.ImageViewTouchBase
    /* renamed from: a */
    protected void mo12924a(float f, float f2, float f3) {
        super.mo12924a(f, f2, f3);
        Iterator<C3619o> it = this.f13229a.iterator();
        while (it.hasNext()) {
            C3619o next = it.next();
            next.f13306f.set(getImageMatrix());
            next.m13015c();
        }
    }

    @Override // com.sec.vip.cropimage.ImageViewTouchBase
    /* renamed from: a */
    protected void mo12923a(float f, float f2) {
        super.mo12923a(f, f2);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f13229a.size()) {
                C3619o c3619o = this.f13229a.get(i2);
                c3619o.f13306f.postTranslate(f, f2);
                c3619o.m13015c();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) throws Resources.NotFoundException {
        ImageModify imageModify = (ImageModify) this.f13235g;
        if (imageModify.f13205a) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                int i = 0;
                while (true) {
                    if (i >= this.f13229a.size()) {
                        break;
                    } else {
                        C3619o c3619o = this.f13229a.get(i);
                        int iM13003a = c3619o.m13003a(x, y);
                        if (iM13003a == 1) {
                            i++;
                        } else {
                            this.f13233e = iM13003a;
                            this.f13230b = c3619o;
                            this.f13231c = x;
                            this.f13232d = y;
                            this.f13234f = true;
                            this.f13230b.m13010a(iM13003a == 32 ? EnumC3620p.Move : EnumC3620p.Grow);
                            break;
                        }
                    }
                }
            case 1:
                if (this.f13230b != null) {
                    m12962c(this.f13230b);
                    this.f13230b.m13010a(EnumC3620p.None);
                }
                this.f13230b = null;
                break;
            case 2:
                if (this.f13230b != null) {
                    if (this.f13233e == 32) {
                        PointF pointFM12960a = m12960a(motionEvent.getX(), motionEvent.getY(), imageModify.mo12916a(), imageModify.mo12917b(), imageModify.mo12918c());
                        if (this.f13234f) {
                            PointF pointFM12960a2 = m12960a(this.f13231c, this.f13232d, imageModify.mo12916a(), imageModify.mo12917b(), imageModify.mo12918c());
                            this.f13231c = pointFM12960a2.x;
                            this.f13232d = pointFM12960a2.y;
                            this.f13234f = false;
                        }
                        this.f13230b.m13005a(this.f13233e, pointFM12960a.x - this.f13231c, pointFM12960a.y - this.f13232d);
                        this.f13231c = pointFM12960a.x;
                        this.f13232d = pointFM12960a.y;
                    } else {
                        this.f13230b.m13005a(this.f13233e, x - this.f13231c, y - this.f13232d);
                        this.f13231c = x;
                        this.f13232d = y;
                    }
                    m12961b(this.f13230b);
                    break;
                }
                break;
        }
        switch (motionEvent.getAction()) {
            case 1:
                mo12926a(true, true);
                break;
            case 2:
                if (mo12922a() == 1.0f) {
                    mo12926a(true, true);
                    break;
                }
                break;
        }
        return true;
    }

    /* renamed from: a */
    private PointF m12960a(float f, float f2, float f3, float f4, float f5) {
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
    private void m12961b(C3619o c3619o) {
        Rect rect = c3619o.f13304d;
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
            m12971b(i, i2);
        }
    }

    /* renamed from: c */
    private void m12962c(C3619o c3619o) {
        Rect rect = c3619o.f13304d;
        float fMax = Math.max(1.0f, Math.min((getWidth() / rect.width()) * 0.6f, (getHeight() / rect.height()) * 0.6f) * mo12922a());
        if (Math.abs(fMax - mo12922a()) / fMax > 0.1d) {
            float[] fArr = {c3619o.f13305e.centerX(), c3619o.f13305e.centerY()};
            getImageMatrix().mapPoints(fArr);
            m12970a(fMax, fArr[0], fArr[1], 300.0f);
        }
        m12961b(c3619o);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) throws Throwable {
        super.onDraw(canvas);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f13229a.size()) {
                this.f13229a.get(i2).m13008a(canvas);
                m12961b(this.f13229a.get(i2));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    public void m12963a(C3619o c3619o) {
        this.f13229a.add(c3619o);
        invalidate();
    }

    @Override // com.sec.vip.cropimage.ImageViewTouchBase
    /* renamed from: b */
    public void mo12927b() {
        this.f13229a.clear();
    }
}
