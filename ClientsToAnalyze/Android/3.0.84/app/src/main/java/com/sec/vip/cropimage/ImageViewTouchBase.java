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
    private final Matrix f13236a;

    /* renamed from: b */
    private final float[] f13237b;

    /* renamed from: c */
    private InterfaceC3602ah f13238c;

    /* renamed from: d */
    private Runnable f13239d;

    /* renamed from: h */
    protected Matrix f13240h;

    /* renamed from: i */
    protected Matrix f13241i;

    /* renamed from: j */
    protected final C3605ak f13242j;

    /* renamed from: k */
    int f13243k;

    /* renamed from: l */
    int f13244l;

    /* renamed from: m */
    float f13245m;

    /* renamed from: n */
    protected Handler f13246n;

    public void setRecycler(InterfaceC3602ah interfaceC3602ah) {
        this.f13238c = interfaceC3602ah;
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f13243k = i3 - i;
        this.f13244l = i4 - i2;
        Runnable runnable = this.f13239d;
        if (runnable != null) {
            this.f13239d = null;
            runnable.run();
        }
        if (this.f13242j.m12987b() != null) {
            m12965a(this.f13242j, this.f13240h);
            setImageMatrix(m12972c());
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
        if (i != 4 || mo12922a() <= 1.0f) {
            return super.onKeyUp(i, keyEvent);
        }
        m12969a(1.0f);
        return true;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        m12964a(bitmap, 0);
    }

    /* renamed from: a */
    private void m12964a(Bitmap bitmap, int i) {
        super.setImageBitmap(bitmap);
        Drawable drawable = getDrawable();
        if (drawable != null) {
            drawable.setDither(true);
        }
        Bitmap bitmapM12987b = this.f13242j.m12987b();
        this.f13242j.m12986a(bitmap);
        this.f13242j.m12985a(i);
        if (bitmapM12987b != null && !bitmapM12987b.equals(bitmap)) {
            bitmapM12987b.recycle();
        }
    }

    /* renamed from: b */
    public void mo12927b() {
        setImageBitmapResetBase(null, 0, true);
    }

    public void setImageBitmapResetBase(Bitmap bitmap, int i, boolean z) {
        setImageRotateBitmapResetBase(new C3605ak(bitmap, i), z);
    }

    public void setImageRotateBitmapResetBase(C3605ak c3605ak, boolean z) {
        if (getWidth() <= 0) {
            this.f13239d = new RunnableC3600af(this, c3605ak, z);
            return;
        }
        if (c3605ak.m12987b() != null) {
            m12965a(c3605ak, this.f13240h);
            m12964a(c3605ak.m12987b(), c3605ak.m12984a());
        } else {
            this.f13240h.reset();
            setImageBitmap(null);
        }
        if (z) {
            this.f13241i.reset();
        }
        setImageMatrix(m12972c());
        this.f13245m = m12973d();
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0094  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo12926a(boolean r8, boolean r9) {
        /*
            r7 = this;
            r6 = 1073741824(0x40000000, float:2.0)
            r0 = 0
            com.sec.vip.cropimage.ak r1 = r7.f13242j
            android.graphics.Bitmap r1 = r1.m12987b()
            if (r1 != 0) goto Lc
        Lb:
            return
        Lc:
            android.graphics.Matrix r1 = r7.m12972c()
            android.graphics.RectF r2 = new android.graphics.RectF
            com.sec.vip.cropimage.ak r3 = r7.f13242j
            android.graphics.Bitmap r3 = r3.m12987b()
            int r3 = r3.getWidth()
            float r3 = (float) r3
            com.sec.vip.cropimage.ak r4 = r7.f13242j
            android.graphics.Bitmap r4 = r4.m12987b()
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
            r7.mo12923a(r0, r1)
            android.graphics.Matrix r0 = r7.m12972c()
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
        throw new UnsupportedOperationException("Method not decompiled: com.sec.vip.cropimage.ImageViewTouchBase.mo12926a(boolean, boolean):void");
    }

    public ImageViewTouchBase(Context context) {
        super(context);
        this.f13240h = new Matrix();
        this.f13241i = new Matrix();
        this.f13236a = new Matrix();
        this.f13237b = new float[9];
        this.f13242j = new C3605ak(null);
        this.f13243k = -1;
        this.f13244l = -1;
        this.f13246n = new Handler();
        this.f13239d = null;
        m12966e();
    }

    public ImageViewTouchBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13240h = new Matrix();
        this.f13241i = new Matrix();
        this.f13236a = new Matrix();
        this.f13237b = new float[9];
        this.f13242j = new C3605ak(null);
        this.f13243k = -1;
        this.f13244l = -1;
        this.f13246n = new Handler();
        this.f13239d = null;
        m12966e();
    }

    /* renamed from: e */
    private void m12966e() {
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    /* renamed from: a */
    protected float m12968a(Matrix matrix, int i) {
        matrix.getValues(this.f13237b);
        if (i < this.f13237b.length) {
            return this.f13237b[i];
        }
        return 0.0f;
    }

    /* renamed from: a */
    protected float m12967a(Matrix matrix) {
        return m12968a(matrix, 0);
    }

    /* renamed from: a */
    public float mo12922a() {
        return m12967a(this.f13241i);
    }

    /* renamed from: a */
    private void m12965a(C3605ak c3605ak, Matrix matrix) {
        float width = getWidth();
        float height = getHeight();
        float fM12991f = c3605ak.m12991f();
        float fM12990e = c3605ak.m12990e();
        matrix.reset();
        float fMin = Math.min(Math.min(width / fM12991f, 3.0f), Math.min(height / fM12990e, 3.0f));
        matrix.postConcat(c3605ak.m12988c());
        matrix.postScale(fMin, fMin);
        matrix.postTranslate((width - (fM12991f * fMin)) / 2.0f, (height - (fM12990e * fMin)) / 2.0f);
    }

    /* renamed from: c */
    protected Matrix m12972c() {
        this.f13236a.set(this.f13240h);
        this.f13236a.postConcat(this.f13241i);
        return this.f13236a;
    }

    /* renamed from: d */
    protected float m12973d() {
        if (this.f13242j.m12987b() == null) {
            return 1.0f;
        }
        return Math.max(this.f13242j.m12991f() / this.f13243k, this.f13242j.m12990e() / this.f13244l) * 4.0f;
    }

    /* renamed from: a */
    protected void mo12924a(float f, float f2, float f3) {
        if (f > this.f13245m) {
            f = this.f13245m;
        }
        float fMo12922a = f / mo12922a();
        this.f13241i.postScale(fMo12922a, fMo12922a, f2, f3);
        setImageMatrix(m12972c());
        mo12926a(true, true);
    }

    /* renamed from: a */
    protected void m12970a(float f, float f2, float f3, float f4) {
        float fMo12922a = (f - mo12922a()) / f4;
        float fMo12922a2 = mo12922a();
        this.f13246n.post(new RunnableC3601ag(this, f4, System.currentTimeMillis(), fMo12922a2, fMo12922a, f2, f3));
    }

    /* renamed from: a */
    protected void m12969a(float f) {
        mo12924a(f, getWidth() / 2.0f, getHeight() / 2.0f);
    }

    /* renamed from: a */
    protected void mo12923a(float f, float f2) {
        this.f13241i.postTranslate(f, f2);
    }

    /* renamed from: b */
    protected void m12971b(float f, float f2) {
        mo12923a(f, f2);
        setImageMatrix(m12972c());
    }
}
