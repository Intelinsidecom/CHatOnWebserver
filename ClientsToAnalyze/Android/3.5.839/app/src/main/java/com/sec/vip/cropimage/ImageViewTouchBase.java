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
    private final Matrix f18648a;

    /* renamed from: b */
    private final float[] f18649b;

    /* renamed from: c */
    private Runnable f18650c;

    /* renamed from: h */
    protected Matrix f18651h;

    /* renamed from: i */
    protected Matrix f18652i;

    /* renamed from: j */
    protected final C5135v f18653j;

    /* renamed from: k */
    int f18654k;

    /* renamed from: l */
    int f18655l;

    /* renamed from: m */
    float f18656m;

    /* renamed from: n */
    protected Handler f18657n;

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f18654k = i3 - i;
        this.f18655l = i4 - i2;
        Runnable runnable = this.f18650c;
        if (runnable != null) {
            this.f18650c = null;
            runnable.run();
        }
        if (this.f18653j.m19596b() != null) {
            m19553a(this.f18653j, this.f18651h);
            setImageMatrix(m19564c());
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
        if (i != 4 || m19562b() <= 1.0f) {
            return super.onKeyUp(i, keyEvent);
        }
        m19557a(1.0f);
        return true;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        m19552a(bitmap, 0);
    }

    /* renamed from: a */
    private void m19552a(Bitmap bitmap, int i) {
        super.setImageBitmap(bitmap);
        Drawable drawable = getDrawable();
        if (drawable != null) {
            drawable.setDither(true);
        }
        Bitmap bitmapM19596b = this.f18653j.m19596b();
        this.f18653j.m19595a(bitmap);
        this.f18653j.m19594a(i);
        if (bitmapM19596b != null && !bitmapM19596b.equals(bitmap)) {
            bitmapM19596b.recycle();
        }
    }

    /* renamed from: a */
    public void mo19548a() {
        m19559a((Bitmap) null, 0, true);
    }

    /* renamed from: a */
    public void m19559a(Bitmap bitmap, int i, boolean z) {
        m19560a(new C5135v(bitmap, i), z);
    }

    /* renamed from: a */
    public void m19560a(C5135v c5135v, boolean z) {
        if (getWidth() <= 0) {
            this.f18650c = new RunnableC5131r(this, c5135v, z);
            return;
        }
        if (c5135v.m19596b() != null) {
            m19553a(c5135v, this.f18651h);
            m19552a(c5135v.m19596b(), c5135v.m19593a());
        } else {
            this.f18651h.reset();
            setImageBitmap(null);
        }
        if (z) {
            this.f18652i.reset();
        }
        setImageMatrix(m19564c());
        this.f18656m = m19565d();
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0094  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m19561a(boolean r8, boolean r9) {
        /*
            r7 = this;
            r6 = 1073741824(0x40000000, float:2.0)
            r0 = 0
            com.sec.vip.cropimage.v r1 = r7.f18653j
            android.graphics.Bitmap r1 = r1.m19596b()
            if (r1 != 0) goto Lc
        Lb:
            return
        Lc:
            android.graphics.Matrix r1 = r7.m19564c()
            android.graphics.RectF r2 = new android.graphics.RectF
            com.sec.vip.cropimage.v r3 = r7.f18653j
            android.graphics.Bitmap r3 = r3.m19596b()
            int r3 = r3.getWidth()
            float r3 = (float) r3
            com.sec.vip.cropimage.v r4 = r7.f18653j
            android.graphics.Bitmap r4 = r4.m19596b()
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
            r7.mo19549a(r0, r1)
            android.graphics.Matrix r0 = r7.m19564c()
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
        throw new UnsupportedOperationException("Method not decompiled: com.sec.vip.cropimage.ImageViewTouchBase.m19561a(boolean, boolean):void");
    }

    public ImageViewTouchBase(Context context) {
        super(context);
        this.f18651h = new Matrix();
        this.f18652i = new Matrix();
        this.f18648a = new Matrix();
        this.f18649b = new float[9];
        this.f18653j = new C5135v(null);
        this.f18654k = -1;
        this.f18655l = -1;
        this.f18657n = new Handler();
        this.f18650c = null;
        m19554e();
    }

    public ImageViewTouchBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18651h = new Matrix();
        this.f18652i = new Matrix();
        this.f18648a = new Matrix();
        this.f18649b = new float[9];
        this.f18653j = new C5135v(null);
        this.f18654k = -1;
        this.f18655l = -1;
        this.f18657n = new Handler();
        this.f18650c = null;
        m19554e();
    }

    /* renamed from: e */
    private void m19554e() {
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    /* renamed from: a */
    protected float m19556a(Matrix matrix, int i) {
        matrix.getValues(this.f18649b);
        if (i < this.f18649b.length) {
            return this.f18649b[i];
        }
        return 0.0f;
    }

    /* renamed from: a */
    protected float m19555a(Matrix matrix) {
        return m19556a(matrix, 0);
    }

    /* renamed from: b */
    public float m19562b() {
        return m19555a(this.f18652i);
    }

    /* renamed from: a */
    private void m19553a(C5135v c5135v, Matrix matrix) {
        float width = getWidth();
        float height = getHeight();
        float fM19600f = c5135v.m19600f();
        float fM19599e = c5135v.m19599e();
        matrix.reset();
        float fMin = Math.min(Math.min(width / fM19600f, 3.0f), Math.min(height / fM19599e, 3.0f));
        matrix.postConcat(c5135v.m19597c());
        matrix.postScale(fMin, fMin);
        matrix.postTranslate((width - (fM19600f * fMin)) / 2.0f, (height - (fM19599e * fMin)) / 2.0f);
    }

    /* renamed from: c */
    protected Matrix m19564c() {
        this.f18648a.set(this.f18651h);
        this.f18648a.postConcat(this.f18652i);
        return this.f18648a;
    }

    /* renamed from: d */
    protected float m19565d() {
        if (this.f18653j.m19596b() == null) {
            return 1.0f;
        }
        return Math.max(this.f18653j.m19600f() / this.f18654k, this.f18653j.m19599e() / this.f18655l) * 4.0f;
    }

    /* renamed from: a */
    protected void mo19550a(float f, float f2, float f3) {
        if (f > this.f18656m) {
            f = this.f18656m;
        }
        float fM19562b = f / m19562b();
        this.f18652i.postScale(fM19562b, fM19562b, f2, f3);
        setImageMatrix(m19564c());
        m19561a(true, true);
    }

    /* renamed from: a */
    protected void m19558a(float f, float f2, float f3, float f4) {
        float fM19562b = (f - m19562b()) / f4;
        float fM19562b2 = m19562b();
        this.f18657n.post(new RunnableC5132s(this, f4, System.currentTimeMillis(), fM19562b2, fM19562b, f2, f3));
    }

    /* renamed from: a */
    protected void m19557a(float f) {
        mo19550a(f, getWidth() / 2.0f, getHeight() / 2.0f);
    }

    /* renamed from: a */
    protected void mo19549a(float f, float f2) {
        this.f18652i.postTranslate(f, f2);
    }

    /* renamed from: b */
    protected void m19563b(float f, float f2) {
        mo19549a(f, f2);
        setImageMatrix(m19564c());
    }
}
