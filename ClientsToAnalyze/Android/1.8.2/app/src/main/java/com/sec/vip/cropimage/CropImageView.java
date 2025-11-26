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
    public Context f7477a;

    /* renamed from: b */
    public ArrayList f7478b;

    /* renamed from: c */
    C2077a f7479c;

    /* renamed from: d */
    float f7480d;

    /* renamed from: e */
    float f7481e;

    /* renamed from: f */
    int f7482f;

    /* renamed from: g */
    boolean f7483g;

    @Override // com.sec.vip.cropimage.ImageViewTouchBase
    /* renamed from: a */
    public /* bridge */ /* synthetic */ float mo7268a() {
        return super.mo7268a();
    }

    @Override // com.sec.vip.cropimage.ImageViewTouchBase
    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo7272a(boolean z, boolean z2) {
        super.mo7272a(z, z2);
    }

    @Override // com.sec.vip.cropimage.ImageViewTouchBase
    /* renamed from: b */
    public /* bridge */ /* synthetic */ void mo7273b() {
        super.mo7273b();
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
    public /* bridge */ /* synthetic */ void setImageRotateBitmapResetBase(C2119p c2119p, boolean z) {
        super.setImageRotateBitmapResetBase(c2119p, z);
    }

    @Override // com.sec.vip.cropimage.ImageViewTouchBase
    public /* bridge */ /* synthetic */ void setRecycler(InterfaceC2116m interfaceC2116m) {
        super.setRecycler(interfaceC2116m);
    }

    @Override // com.sec.vip.cropimage.ImageViewTouchBase, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f7528j.m7433b() != null) {
            Iterator it = this.f7478b.iterator();
            while (it.hasNext()) {
                C2077a c2077a = (C2077a) it.next();
                c2077a.f7540f.set(getImageMatrix());
                c2077a.m7334c();
                if (c2077a.f7536b) {
                    m7266a(c2077a, false);
                }
            }
        }
    }

    public CropImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7478b = new ArrayList();
        this.f7479c = null;
        this.f7483g = false;
    }

    @Override // com.sec.vip.cropimage.ImageViewTouchBase
    /* renamed from: a */
    protected void mo7270a(float f, float f2, float f3) {
        super.mo7270a(f, f2, f3);
        Iterator it = this.f7478b.iterator();
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
        int size = this.f7478b.size();
        for (int i = 0; i < size; i++) {
            C2077a c2077a = (C2077a) this.f7478b.get(i);
            c2077a.f7540f.postTranslate(f, f2);
            c2077a.m7334c();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) throws Resources.NotFoundException {
        int i = 0;
        MonitoredActivity monitoredActivity = (MonitoredActivity) this.f7477a;
        if (monitoredActivity.f7534e) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                int size = this.f7478b.size();
                while (true) {
                    if (i >= size) {
                        break;
                    } else {
                        C2077a c2077a = (C2077a) this.f7478b.get(i);
                        int iM7323a = c2077a.m7323a(x, y);
                        if (iM7323a == 1) {
                            i++;
                        } else {
                            this.f7482f = iM7323a;
                            this.f7479c = c2077a;
                            this.f7480d = x;
                            this.f7481e = y;
                            this.f7483g = true;
                            this.f7479c.m7329a(iM7323a == 32 ? EnumC2078b.Move : EnumC2078b.Grow);
                            break;
                        }
                    }
                }
            case 1:
                if (this.f7479c != null) {
                    m7266a(this.f7479c, true);
                    this.f7479c.m7329a(EnumC2078b.None);
                }
                this.f7479c = null;
                break;
            case 2:
                if (this.f7479c != null) {
                    if (this.f7482f == 32) {
                        PointF pointFM7265a = m7265a(x, y, monitoredActivity.mo7298a(), monitoredActivity.mo7299b(), monitoredActivity.mo7300c());
                        if (this.f7483g) {
                            PointF pointFM7265a2 = m7265a(this.f7480d, this.f7481e, monitoredActivity.mo7298a(), monitoredActivity.mo7299b(), monitoredActivity.mo7300c());
                            this.f7480d = pointFM7265a2.x;
                            this.f7481e = pointFM7265a2.y;
                            this.f7483g = false;
                        }
                        this.f7479c.m7325a(this.f7482f, pointFM7265a.x - this.f7480d, pointFM7265a.y - this.f7481e);
                        this.f7480d = pointFM7265a.x;
                        this.f7481e = pointFM7265a.y;
                    } else {
                        this.f7479c.m7325a(this.f7482f, x - this.f7480d, y - this.f7481e);
                        this.f7480d = x;
                        this.f7481e = y;
                    }
                    m7267b(this.f7479c);
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
    private PointF m7265a(float f, float f2, float f3, float f4, float f5) {
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
    private void m7267b(C2077a c2077a) {
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

    /* renamed from: a */
    private void m7266a(C2077a c2077a, boolean z) {
        Rect rect = c2077a.f7538d;
        float fMax = Math.max(1.0f, Math.min((getWidth() / rect.width()) * 0.6f, (getHeight() / rect.height()) * 0.6f) * mo7268a());
        if (Math.abs(fMax - mo7268a()) / fMax > 0.1d) {
            float[] fArr = {c2077a.f7539e.centerX(), c2077a.f7539e.centerY()};
            getImageMatrix().mapPoints(fArr);
            if (z) {
                m7312a(fMax, fArr[0], fArr[1], 300.0f);
            } else {
                mo7270a(fMax, fArr[0], fArr[1]);
            }
        }
        m7267b(c2077a);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.f7478b.size();
        for (int i = 0; i < size; i++) {
            ((C2077a) this.f7478b.get(i)).m7327a(canvas);
        }
    }

    /* renamed from: a */
    public void m7271a(C2077a c2077a) {
        this.f7478b.add(c2077a);
        invalidate();
    }
}
