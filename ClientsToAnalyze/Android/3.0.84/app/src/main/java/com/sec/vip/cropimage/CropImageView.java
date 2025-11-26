package com.sec.vip.cropimage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class CropImageView extends ImageViewTouchBase {

    /* renamed from: a */
    public Context f13188a;

    /* renamed from: b */
    public ArrayList<C3619o> f13189b;

    /* renamed from: c */
    C3619o f13190c;

    /* renamed from: d */
    float f13191d;

    /* renamed from: e */
    float f13192e;

    /* renamed from: f */
    int f13193f;

    /* renamed from: g */
    boolean f13194g;

    @Override // com.sec.vip.cropimage.ImageViewTouchBase
    /* renamed from: a */
    public /* bridge */ /* synthetic */ float mo12922a() {
        return super.mo12922a();
    }

    @Override // com.sec.vip.cropimage.ImageViewTouchBase
    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo12926a(boolean z, boolean z2) {
        super.mo12926a(z, z2);
    }

    @Override // com.sec.vip.cropimage.ImageViewTouchBase
    /* renamed from: b */
    public /* bridge */ /* synthetic */ void mo12927b() {
        super.mo12927b();
    }

    @Override // com.sec.vip.cropimage.ImageViewTouchBase, android.view.View, android.view.KeyEvent.Callback
    public /* bridge */ /* synthetic */ boolean onKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.sec.vip.cropimage.ImageViewTouchBase, android.view.View, android.view.KeyEvent.Callback
    public /* bridge */ /* synthetic */ boolean onKeyUp(int i, KeyEvent keyEvent) {
        return super.onKeyUp(i, keyEvent);
    }

    @Override // com.sec.vip.cropimage.ImageViewTouchBase, android.widget.ImageView
    public /* bridge */ /* synthetic */ void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
    }

    @Override // com.sec.vip.cropimage.ImageViewTouchBase
    public /* bridge */ /* synthetic */ void setImageBitmapResetBase(Bitmap bitmap, int i, boolean z) {
        super.setImageBitmapResetBase(bitmap, i, z);
    }

    @Override // com.sec.vip.cropimage.ImageViewTouchBase
    public /* bridge */ /* synthetic */ void setImageRotateBitmapResetBase(C3605ak c3605ak, boolean z) {
        super.setImageRotateBitmapResetBase(c3605ak, z);
    }

    @Override // com.sec.vip.cropimage.ImageViewTouchBase
    public /* bridge */ /* synthetic */ void setRecycler(InterfaceC3602ah interfaceC3602ah) {
        super.setRecycler(interfaceC3602ah);
    }

    @Override // com.sec.vip.cropimage.ImageViewTouchBase, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f13242j.m12987b() != null) {
            Iterator<C3619o> it = this.f13189b.iterator();
            while (it.hasNext()) {
                C3619o next = it.next();
                next.f13306f.set(getImageMatrix());
                next.m13015c();
                if (next.f13302b) {
                    m12920a(next, false);
                }
            }
        }
    }

    public CropImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13189b = new ArrayList<>();
        this.f13190c = null;
        this.f13194g = false;
    }

    @Override // com.sec.vip.cropimage.ImageViewTouchBase
    /* renamed from: a */
    protected void mo12924a(float f, float f2, float f3) {
        super.mo12924a(f, f2, f3);
        Iterator<C3619o> it = this.f13189b.iterator();
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
        int size = this.f13189b.size();
        for (int i = 0; i < size; i++) {
            C3619o c3619o = this.f13189b.get(i);
            c3619o.f13306f.postTranslate(f, f2);
            c3619o.m13015c();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) throws Resources.NotFoundException {
        int i = 0;
        MonitoredActivity monitoredActivity = (MonitoredActivity) this.f13188a;
        if (monitoredActivity.f13248e) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                int size = this.f13189b.size();
                while (true) {
                    if (i >= size) {
                        break;
                    } else {
                        C3619o c3619o = this.f13189b.get(i);
                        int iM13003a = c3619o.m13003a(x, y);
                        if (iM13003a == 1) {
                            i++;
                        } else {
                            this.f13193f = iM13003a;
                            this.f13190c = c3619o;
                            this.f13191d = x;
                            this.f13192e = y;
                            this.f13194g = true;
                            this.f13190c.m13010a(iM13003a == 32 ? EnumC3620p.Move : EnumC3620p.Grow);
                            break;
                        }
                    }
                }
            case 1:
                if (this.f13190c != null) {
                    m12920a(this.f13190c, true);
                    this.f13190c.m13010a(EnumC3620p.None);
                }
                this.f13190c = null;
                break;
            case 2:
                if (this.f13190c != null) {
                    if (this.f13193f == 32) {
                        PointF pointFM12919a = m12919a(x, y, monitoredActivity.mo12916a(), monitoredActivity.mo12917b(), monitoredActivity.mo12918c());
                        if (this.f13194g) {
                            PointF pointFM12919a2 = m12919a(this.f13191d, this.f13192e, monitoredActivity.mo12916a(), monitoredActivity.mo12917b(), monitoredActivity.mo12918c());
                            this.f13191d = pointFM12919a2.x;
                            this.f13192e = pointFM12919a2.y;
                            this.f13194g = false;
                        }
                        this.f13190c.m13006a(this.f13193f, pointFM12919a.x - this.f13191d, pointFM12919a.y - this.f13192e, monitoredActivity.mo12918c());
                        this.f13191d = pointFM12919a.x;
                        this.f13192e = pointFM12919a.y;
                    } else {
                        this.f13190c.m13006a(this.f13193f, x - this.f13191d, y - this.f13192e, monitoredActivity.mo12918c());
                        this.f13191d = x;
                        this.f13192e = y;
                    }
                    m12921b(this.f13190c);
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
    private PointF m12919a(float f, float f2, float f3, float f4, float f5) {
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
    private void m12921b(C3619o c3619o) {
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
        if (iMax != 0 || iMax2 != 0) {
            m12971b(iMax, iMax2);
        }
    }

    /* renamed from: a */
    private void m12920a(C3619o c3619o, boolean z) {
        Rect rect = c3619o.f13304d;
        float fMax = Math.max(1.0f, Math.min((getWidth() / rect.width()) * 0.6f, (getHeight() / rect.height()) * 0.6f) * mo12922a());
        if (Math.abs(fMax - mo12922a()) / fMax > 0.1d) {
            float[] fArr = {c3619o.f13305e.centerX(), c3619o.f13305e.centerY()};
            getImageMatrix().mapPoints(fArr);
            if (z) {
                m12970a(fMax, fArr[0], fArr[1], 300.0f);
            } else {
                mo12924a(fMax, fArr[0], fArr[1]);
            }
        }
        m12921b(c3619o);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) throws Throwable {
        super.onDraw(canvas);
        int size = this.f13189b.size();
        for (int i = 0; i < size; i++) {
            this.f13189b.get(i).m13008a(canvas);
        }
    }

    /* renamed from: a */
    public void m12925a(C3619o c3619o) {
        this.f13189b.add(c3619o);
        invalidate();
    }
}
