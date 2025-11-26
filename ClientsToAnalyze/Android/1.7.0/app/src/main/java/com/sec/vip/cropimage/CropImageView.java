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
    public Context f5434a;

    /* renamed from: b */
    public ArrayList f5435b;

    /* renamed from: c */
    C1598o f5436c;

    /* renamed from: d */
    float f5437d;

    /* renamed from: e */
    float f5438e;

    /* renamed from: f */
    int f5439f;

    /* renamed from: g */
    boolean f5440g;

    @Override // com.sec.vip.cropimage.ImageViewTouchBase
    /* renamed from: a */
    public /* bridge */ /* synthetic */ float mo5674a() {
        return super.mo5674a();
    }

    @Override // com.sec.vip.cropimage.ImageViewTouchBase
    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo5678a(boolean z, boolean z2) {
        super.mo5678a(z, z2);
    }

    @Override // com.sec.vip.cropimage.ImageViewTouchBase
    /* renamed from: b */
    public /* bridge */ /* synthetic */ void mo5679b() {
        super.mo5679b();
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
    public /* bridge */ /* synthetic */ void setImageRotateBitmapResetBase(C1565d c1565d, boolean z) {
        super.setImageRotateBitmapResetBase(c1565d, z);
    }

    @Override // com.sec.vip.cropimage.ImageViewTouchBase
    public /* bridge */ /* synthetic */ void setRecycler(InterfaceC1566e interfaceC1566e) {
        super.setRecycler(interfaceC1566e);
    }

    @Override // com.sec.vip.cropimage.ImageViewTouchBase, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f5489j.m5735b() != null) {
            Iterator it = this.f5435b.iterator();
            while (it.hasNext()) {
                C1598o c1598o = (C1598o) it.next();
                c1598o.f5626f.set(getImageMatrix());
                c1598o.m5833c();
                if (c1598o.f5622b) {
                    m5672a(c1598o, false);
                }
            }
        }
    }

    public CropImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5435b = new ArrayList();
        this.f5436c = null;
        this.f5440g = false;
    }

    @Override // com.sec.vip.cropimage.ImageViewTouchBase
    /* renamed from: a */
    protected void mo5676a(float f, float f2, float f3) {
        super.mo5676a(f, f2, f3);
        Iterator it = this.f5435b.iterator();
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
        int size = this.f5435b.size();
        for (int i = 0; i < size; i++) {
            C1598o c1598o = (C1598o) this.f5435b.get(i);
            c1598o.f5626f.postTranslate(f, f2);
            c1598o.m5833c();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) throws Resources.NotFoundException {
        int i = 0;
        MonitoredActivity monitoredActivity = (MonitoredActivity) this.f5434a;
        if (monitoredActivity.f5495e) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                int size = this.f5435b.size();
                while (true) {
                    if (i >= size) {
                        break;
                    } else {
                        C1598o c1598o = (C1598o) this.f5435b.get(i);
                        int iM5822a = c1598o.m5822a(x, y);
                        if (iM5822a == 1) {
                            i++;
                        } else {
                            this.f5439f = iM5822a;
                            this.f5436c = c1598o;
                            this.f5437d = x;
                            this.f5438e = y;
                            this.f5440g = true;
                            this.f5436c.m5828a(iM5822a == 32 ? EnumC1564c.Move : EnumC1564c.Grow);
                            break;
                        }
                    }
                }
            case 1:
                if (this.f5436c != null) {
                    m5672a(this.f5436c, true);
                    this.f5436c.m5828a(EnumC1564c.None);
                }
                this.f5436c = null;
                break;
            case 2:
                if (this.f5436c != null) {
                    if (this.f5439f == 32) {
                        PointF pointFM5671a = m5671a(x, y, monitoredActivity.mo5709a(), monitoredActivity.mo5710b(), monitoredActivity.mo5711c());
                        if (this.f5440g) {
                            PointF pointFM5671a2 = m5671a(this.f5437d, this.f5438e, monitoredActivity.mo5709a(), monitoredActivity.mo5710b(), monitoredActivity.mo5711c());
                            this.f5437d = pointFM5671a2.x;
                            this.f5438e = pointFM5671a2.y;
                            this.f5440g = false;
                        }
                        this.f5436c.m5824a(this.f5439f, pointFM5671a.x - this.f5437d, pointFM5671a.y - this.f5438e);
                        this.f5437d = pointFM5671a.x;
                        this.f5438e = pointFM5671a.y;
                    } else {
                        this.f5436c.m5824a(this.f5439f, x - this.f5437d, y - this.f5438e);
                        this.f5437d = x;
                        this.f5438e = y;
                    }
                    m5673b(this.f5436c);
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
    private PointF m5671a(float f, float f2, float f3, float f4, float f5) {
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
    private void m5673b(C1598o c1598o) {
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

    /* renamed from: a */
    private void m5672a(C1598o c1598o, boolean z) {
        Rect rect = c1598o.f5624d;
        float fMax = Math.max(1.0f, Math.min((getWidth() / rect.width()) * 0.6f, (getHeight() / rect.height()) * 0.6f) * mo5674a());
        if (Math.abs(fMax - mo5674a()) / fMax > 0.1d) {
            float[] fArr = {c1598o.f5625e.centerX(), c1598o.f5625e.centerY()};
            getImageMatrix().mapPoints(fArr);
            if (z) {
                m5722a(fMax, fArr[0], fArr[1], 300.0f);
            } else {
                mo5676a(fMax, fArr[0], fArr[1]);
            }
        }
        m5673b(c1598o);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.f5435b.size();
        for (int i = 0; i < size; i++) {
            ((C1598o) this.f5435b.get(i)).m5826a(canvas);
        }
    }

    /* renamed from: a */
    public void m5677a(C1598o c1598o) {
        this.f5435b.add(c1598o);
        invalidate();
    }
}
