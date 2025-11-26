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
    private final Matrix f7522a;

    /* renamed from: b */
    private final float[] f7523b;

    /* renamed from: c */
    private InterfaceC2116m f7524c;

    /* renamed from: d */
    private Runnable f7525d;

    /* renamed from: h */
    protected Matrix f7526h;

    /* renamed from: i */
    protected Matrix f7527i;

    /* renamed from: j */
    protected final C2119p f7528j;

    /* renamed from: k */
    int f7529k;

    /* renamed from: l */
    int f7530l;

    /* renamed from: m */
    float f7531m;

    /* renamed from: n */
    protected Handler f7532n;

    public void setRecycler(InterfaceC2116m interfaceC2116m) {
        this.f7524c = interfaceC2116m;
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f7529k = i3 - i;
        this.f7530l = i4 - i2;
        Runnable runnable = this.f7525d;
        if (runnable != null) {
            this.f7525d = null;
            runnable.run();
        }
        if (this.f7528j.m7433b() != null) {
            m7307a(this.f7528j, this.f7526h);
            setImageMatrix(m7314c());
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
        if (i != 4 || mo7268a() <= 1.0f) {
            return super.onKeyUp(i, keyEvent);
        }
        m7311a(1.0f);
        return true;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        m7306a(bitmap, 0);
    }

    /* renamed from: a */
    private void m7306a(Bitmap bitmap, int i) {
        super.setImageBitmap(bitmap);
        Drawable drawable = getDrawable();
        if (drawable != null) {
            drawable.setDither(true);
        }
        Bitmap bitmapM7433b = this.f7528j.m7433b();
        this.f7528j.m7432a(bitmap);
        this.f7528j.m7431a(i);
        if (bitmapM7433b != null && bitmapM7433b != bitmap && this.f7524c != null) {
            this.f7524c.m7428a(bitmapM7433b);
        }
    }

    /* renamed from: b */
    public void mo7273b() {
        setImageBitmapResetBase(null, 0, true);
    }

    public void setImageBitmapResetBase(Bitmap bitmap, int i, boolean z) {
        setImageRotateBitmapResetBase(new C2119p(bitmap, i), z);
    }

    public void setImageRotateBitmapResetBase(C2119p c2119p, boolean z) {
        if (getWidth() <= 0) {
            this.f7525d = new RunnableC2114k(this, c2119p, z);
            return;
        }
        if (c2119p.m7433b() != null) {
            m7307a(c2119p, this.f7526h);
            m7306a(c2119p.m7433b(), c2119p.m7430a());
        } else {
            this.f7526h.reset();
            setImageBitmap(null);
        }
        if (z) {
            this.f7527i.reset();
        }
        setImageMatrix(m7314c());
        this.f7531m = m7315d();
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0094  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo7272a(boolean r8, boolean r9) {
        /*
            r7 = this;
            r6 = 1073741824(0x40000000, float:2.0)
            r0 = 0
            com.sec.vip.cropimage.p r1 = r7.f7528j
            android.graphics.Bitmap r1 = r1.m7433b()
            if (r1 != 0) goto Lc
        Lb:
            return
        Lc:
            android.graphics.Matrix r1 = r7.m7314c()
            android.graphics.RectF r2 = new android.graphics.RectF
            com.sec.vip.cropimage.p r3 = r7.f7528j
            android.graphics.Bitmap r3 = r3.m7433b()
            int r3 = r3.getWidth()
            float r3 = (float) r3
            com.sec.vip.cropimage.p r4 = r7.f7528j
            android.graphics.Bitmap r4 = r4.m7433b()
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
            r7.mo7269a(r0, r1)
            android.graphics.Matrix r0 = r7.m7314c()
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
        throw new UnsupportedOperationException("Method not decompiled: com.sec.vip.cropimage.ImageViewTouchBase.mo7272a(boolean, boolean):void");
    }

    public ImageViewTouchBase(Context context) {
        super(context);
        this.f7526h = new Matrix();
        this.f7527i = new Matrix();
        this.f7522a = new Matrix();
        this.f7523b = new float[9];
        this.f7528j = new C2119p(null);
        this.f7529k = -1;
        this.f7530l = -1;
        this.f7532n = new Handler();
        this.f7525d = null;
        m7308e();
    }

    public ImageViewTouchBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7526h = new Matrix();
        this.f7527i = new Matrix();
        this.f7522a = new Matrix();
        this.f7523b = new float[9];
        this.f7528j = new C2119p(null);
        this.f7529k = -1;
        this.f7530l = -1;
        this.f7532n = new Handler();
        this.f7525d = null;
        m7308e();
    }

    /* renamed from: e */
    private void m7308e() {
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    /* renamed from: a */
    protected float m7310a(Matrix matrix, int i) {
        matrix.getValues(this.f7523b);
        if (i < this.f7523b.length) {
            return this.f7523b[i];
        }
        return 0.0f;
    }

    /* renamed from: a */
    protected float m7309a(Matrix matrix) {
        return m7310a(matrix, 0);
    }

    /* renamed from: a */
    public float mo7268a() {
        return m7309a(this.f7527i);
    }

    /* renamed from: a */
    private void m7307a(C2119p c2119p, Matrix matrix) {
        float width = getWidth();
        float height = getHeight();
        float fM7437f = c2119p.m7437f();
        float fM7436e = c2119p.m7436e();
        matrix.reset();
        float fMin = Math.min(Math.min(width / fM7437f, 3.0f), Math.min(height / fM7436e, 3.0f));
        matrix.postConcat(c2119p.m7434c());
        matrix.postScale(fMin, fMin);
        matrix.postTranslate((width - (fM7437f * fMin)) / 2.0f, (height - (fM7436e * fMin)) / 2.0f);
    }

    /* renamed from: c */
    protected Matrix m7314c() {
        this.f7522a.set(this.f7526h);
        this.f7522a.postConcat(this.f7527i);
        return this.f7522a;
    }

    /* renamed from: d */
    protected float m7315d() {
        if (this.f7528j.m7433b() == null) {
            return 1.0f;
        }
        return Math.max(this.f7528j.m7437f() / this.f7529k, this.f7528j.m7436e() / this.f7530l) * 4.0f;
    }

    /* renamed from: a */
    protected void mo7270a(float f, float f2, float f3) {
        if (f > this.f7531m) {
            f = this.f7531m;
        }
        float fMo7268a = f / mo7268a();
        this.f7527i.postScale(fMo7268a, fMo7268a, f2, f3);
        setImageMatrix(m7314c());
        mo7272a(true, true);
    }

    /* renamed from: a */
    protected void m7312a(float f, float f2, float f3, float f4) {
        float fMo7268a = (f - mo7268a()) / f4;
        float fMo7268a2 = mo7268a();
        this.f7532n.post(new RunnableC2115l(this, f4, System.currentTimeMillis(), fMo7268a2, fMo7268a, f2, f3));
    }

    /* renamed from: a */
    protected void m7311a(float f) {
        mo7270a(f, getWidth() / 2.0f, getHeight() / 2.0f);
    }

    /* renamed from: a */
    protected void mo7269a(float f, float f2) {
        this.f7527i.postTranslate(f, f2);
    }

    /* renamed from: b */
    protected void m7313b(float f, float f2) {
        mo7269a(f, f2);
        setImageMatrix(m7314c());
    }
}
