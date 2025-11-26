package com.sec.vip.cropimage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.ImageView;

/* loaded from: classes.dex */
abstract class ImageViewTouchBase extends ImageView {

    /* renamed from: a */
    private final Matrix f5483a;

    /* renamed from: b */
    private final float[] f5484b;

    /* renamed from: c */
    private InterfaceC1566e f5485c;

    /* renamed from: d */
    private Runnable f5486d;

    /* renamed from: h */
    protected Matrix f5487h;

    /* renamed from: i */
    protected Matrix f5488i;

    /* renamed from: j */
    protected final C1565d f5489j;

    /* renamed from: k */
    int f5490k;

    /* renamed from: l */
    int f5491l;

    /* renamed from: m */
    float f5492m;

    /* renamed from: n */
    protected Handler f5493n;

    public void setRecycler(InterfaceC1566e interfaceC1566e) {
        this.f5485c = interfaceC1566e;
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f5490k = i3 - i;
        this.f5491l = i4 - i2;
        Runnable runnable = this.f5486d;
        if (runnable != null) {
            this.f5486d = null;
            runnable.run();
        }
        if (this.f5489j.m5735b() != null) {
            m5717a(this.f5489j, this.f5487h);
            setImageMatrix(m5724c());
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4 || mo5674a() <= 1.0f) {
            return super.onKeyUp(i, keyEvent);
        }
        m5721a(1.0f);
        return true;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        m5716a(bitmap, 0);
    }

    /* renamed from: a */
    private void m5716a(Bitmap bitmap, int i) {
        super.setImageBitmap(bitmap);
        Drawable drawable = getDrawable();
        if (drawable != null) {
            drawable.setDither(true);
        }
        Bitmap bitmapM5735b = this.f5489j.m5735b();
        this.f5489j.m5734a(bitmap);
        this.f5489j.m5733a(i);
        if (bitmapM5735b != null && !bitmapM5735b.equals(bitmap)) {
            bitmapM5735b.recycle();
        }
    }

    /* renamed from: b */
    public void mo5679b() {
        setImageBitmapResetBase(null, 0, true);
    }

    public void setImageBitmapResetBase(Bitmap bitmap, int i, boolean z) {
        setImageRotateBitmapResetBase(new C1565d(bitmap, i), z);
    }

    public void setImageRotateBitmapResetBase(C1565d c1565d, boolean z) {
        if (getWidth() <= 0) {
            this.f5486d = new RunnableC1567f(this, c1565d, z);
            return;
        }
        if (c1565d.m5735b() != null) {
            m5717a(c1565d, this.f5487h);
            m5716a(c1565d.m5735b(), c1565d.m5732a());
        } else {
            this.f5487h.reset();
            setImageBitmap(null);
        }
        if (z) {
            this.f5488i.reset();
        }
        setImageMatrix(m5724c());
        this.f5492m = m5725d();
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0094  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo5678a(boolean r8, boolean r9) {
        /*
            r7 = this;
            r6 = 1073741824(0x40000000, float:2.0)
            r0 = 0
            com.sec.vip.cropimage.d r1 = r7.f5489j
            android.graphics.Bitmap r1 = r1.m5735b()
            if (r1 != 0) goto Lc
        Lb:
            return
        Lc:
            android.graphics.Matrix r1 = r7.m5724c()
            android.graphics.RectF r2 = new android.graphics.RectF
            com.sec.vip.cropimage.d r3 = r7.f5489j
            android.graphics.Bitmap r3 = r3.m5735b()
            int r3 = r3.getWidth()
            float r3 = (float) r3
            com.sec.vip.cropimage.d r4 = r7.f5489j
            android.graphics.Bitmap r4 = r4.m5735b()
            int r4 = r4.getHeight()
            float r4 = (float) r4
            r2.<init>(r0, r0, r3, r4)
            r1.mapRect(r2)
            float r1 = r2.height()
            float r3 = r2.width()
            if (r9 == 0) goto L94
            int r4 = r7.getHeight()
            float r5 = (float) r4
            int r5 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r5 >= 0) goto L64
            float r4 = (float) r4
            float r1 = r4 - r1
            float r1 = r1 / r6
            float r4 = r2.top
            float r1 = r1 - r4
        L48:
            if (r8 == 0) goto L59
            int r4 = r7.getWidth()
            float r5 = (float) r4
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 >= 0) goto L7e
            float r0 = (float) r4
            float r0 = r0 - r3
            float r0 = r0 / r6
            float r2 = r2.left
            float r0 = r0 - r2
        L59:
            r7.mo5675a(r0, r1)
            android.graphics.Matrix r0 = r7.m5724c()
            r7.setImageMatrix(r0)
            goto Lb
        L64:
            float r1 = r2.top
            int r1 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r1 <= 0) goto L6e
            float r1 = r2.top
            float r1 = -r1
            goto L48
        L6e:
            float r1 = r2.bottom
            float r4 = (float) r4
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 >= 0) goto L94
            int r1 = r7.getHeight()
            float r1 = (float) r1
            float r4 = r2.bottom
            float r1 = r1 - r4
            goto L48
        L7e:
            float r3 = r2.left
            int r3 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r3 <= 0) goto L88
            float r0 = r2.left
            float r0 = -r0
            goto L59
        L88:
            float r3 = r2.right
            float r5 = (float) r4
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 >= 0) goto L59
            float r0 = (float) r4
            float r2 = r2.right
            float r0 = r0 - r2
            goto L59
        L94:
            r1 = r0
            goto L48
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.vip.cropimage.ImageViewTouchBase.mo5678a(boolean, boolean):void");
    }

    public ImageViewTouchBase(Context context) {
        super(context);
        this.f5487h = new Matrix();
        this.f5488i = new Matrix();
        this.f5483a = new Matrix();
        this.f5484b = new float[9];
        this.f5489j = new C1565d(null);
        this.f5490k = -1;
        this.f5491l = -1;
        this.f5493n = new Handler();
        this.f5486d = null;
        m5718e();
    }

    public ImageViewTouchBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5487h = new Matrix();
        this.f5488i = new Matrix();
        this.f5483a = new Matrix();
        this.f5484b = new float[9];
        this.f5489j = new C1565d(null);
        this.f5490k = -1;
        this.f5491l = -1;
        this.f5493n = new Handler();
        this.f5486d = null;
        m5718e();
    }

    /* renamed from: e */
    private void m5718e() {
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    /* renamed from: a */
    protected float m5720a(Matrix matrix, int i) {
        matrix.getValues(this.f5484b);
        if (i < this.f5484b.length) {
            return this.f5484b[i];
        }
        return 0.0f;
    }

    /* renamed from: a */
    protected float m5719a(Matrix matrix) {
        return m5720a(matrix, 0);
    }

    /* renamed from: a */
    public float mo5674a() {
        return m5719a(this.f5488i);
    }

    /* renamed from: a */
    private void m5717a(C1565d c1565d, Matrix matrix) {
        float width = getWidth();
        float height = getHeight();
        float fM5739f = c1565d.m5739f();
        float fM5738e = c1565d.m5738e();
        matrix.reset();
        float fMin = Math.min(Math.min(width / fM5739f, 3.0f), Math.min(height / fM5738e, 3.0f));
        matrix.postConcat(c1565d.m5736c());
        matrix.postScale(fMin, fMin);
        matrix.postTranslate((width - (fM5739f * fMin)) / 2.0f, (height - (fM5738e * fMin)) / 2.0f);
    }

    /* renamed from: c */
    protected Matrix m5724c() {
        this.f5483a.set(this.f5487h);
        this.f5483a.postConcat(this.f5488i);
        return this.f5483a;
    }

    /* renamed from: d */
    protected float m5725d() {
        if (this.f5489j.m5735b() == null) {
            return 1.0f;
        }
        return Math.max(this.f5489j.m5739f() / this.f5490k, this.f5489j.m5738e() / this.f5491l) * 4.0f;
    }

    /* renamed from: a */
    protected void mo5676a(float f, float f2, float f3) {
        if (f > this.f5492m) {
            f = this.f5492m;
        }
        float fMo5674a = f / mo5674a();
        this.f5488i.postScale(fMo5674a, fMo5674a, f2, f3);
        setImageMatrix(m5724c());
        mo5678a(true, true);
    }

    /* renamed from: a */
    protected void m5722a(float f, float f2, float f3, float f4) {
        float fMo5674a = (f - mo5674a()) / f4;
        float fMo5674a2 = mo5674a();
        this.f5493n.post(new RunnableC1568g(this, f4, System.currentTimeMillis(), fMo5674a2, fMo5674a, f2, f3));
    }

    /* renamed from: a */
    protected void m5721a(float f) {
        mo5676a(f, getWidth() / 2.0f, getHeight() / 2.0f);
    }

    /* renamed from: a */
    protected void mo5675a(float f, float f2) {
        this.f5488i.postTranslate(f, f2);
    }

    /* renamed from: b */
    protected void m5723b(float f, float f2) {
        mo5675a(f, f2);
        setImageMatrix(m5724c());
    }
}
