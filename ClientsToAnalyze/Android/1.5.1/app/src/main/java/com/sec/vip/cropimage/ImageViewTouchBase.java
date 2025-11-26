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
    private final Matrix f4432a;

    /* renamed from: b */
    private final float[] f4433b;

    /* renamed from: c */
    private Recycler f4434c;

    /* renamed from: d */
    private Runnable f4435d;

    /* renamed from: h */
    protected Matrix f4436h;

    /* renamed from: i */
    protected Matrix f4437i;

    /* renamed from: j */
    protected final RotateBitmap f4438j;

    /* renamed from: k */
    int f4439k;

    /* renamed from: l */
    int f4440l;

    /* renamed from: m */
    float f4441m;

    /* renamed from: n */
    protected Handler f4442n;

    public interface Recycler {
        /* renamed from: a */
        void m4329a(Bitmap bitmap);
    }

    public ImageViewTouchBase(Context context) {
        super(context);
        this.f4436h = new Matrix();
        this.f4437i = new Matrix();
        this.f4432a = new Matrix();
        this.f4433b = new float[9];
        this.f4438j = new RotateBitmap(null);
        this.f4439k = -1;
        this.f4440l = -1;
        this.f4442n = new Handler();
        this.f4435d = null;
        m4317e();
    }

    public ImageViewTouchBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4436h = new Matrix();
        this.f4437i = new Matrix();
        this.f4432a = new Matrix();
        this.f4433b = new float[9];
        this.f4438j = new RotateBitmap(null);
        this.f4439k = -1;
        this.f4440l = -1;
        this.f4442n = new Handler();
        this.f4435d = null;
        m4317e();
    }

    /* renamed from: a */
    private void m4315a(Bitmap bitmap, int i) {
        super.setImageBitmap(bitmap);
        Drawable drawable = getDrawable();
        if (drawable != null) {
            drawable.setDither(true);
        }
        Bitmap bitmapM4339b = this.f4438j.m4339b();
        this.f4438j.m4338a(bitmap);
        this.f4438j.m4337a(i);
        if (bitmapM4339b == null || bitmapM4339b == bitmap || this.f4434c == null) {
            return;
        }
        this.f4434c.m4329a(bitmapM4339b);
    }

    /* renamed from: a */
    private void m4316a(RotateBitmap rotateBitmap, Matrix matrix) {
        float width = getWidth();
        float height = getHeight();
        float fM4343f = rotateBitmap.m4343f();
        float fM4342e = rotateBitmap.m4342e();
        matrix.reset();
        float fMin = Math.min(Math.min(width / fM4343f, 3.0f), Math.min(height / fM4342e, 3.0f));
        matrix.postConcat(rotateBitmap.m4340c());
        matrix.postScale(fMin, fMin);
        matrix.postTranslate((width - (fM4343f * fMin)) / 2.0f, (height - (fM4342e * fMin)) / 2.0f);
    }

    /* renamed from: e */
    private void m4317e() {
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    /* renamed from: a */
    protected float m4318a(Matrix matrix) {
        return m4319a(matrix, 0);
    }

    /* renamed from: a */
    protected float m4319a(Matrix matrix, int i) {
        matrix.getValues(this.f4433b);
        return this.f4433b[i];
    }

    /* renamed from: a */
    public void mo4313a() {
        m4322a((Bitmap) null, 0, true);
    }

    /* renamed from: a */
    protected void m4320a(float f) {
        mo4278a(f, getWidth() / 2.0f, getHeight() / 2.0f);
    }

    /* renamed from: a */
    protected void mo4277a(float f, float f2) {
        this.f4437i.postTranslate(f, f2);
    }

    /* renamed from: a */
    protected void mo4278a(float f, float f2, float f3) {
        float fM4325b = (f > this.f4441m ? this.f4441m : f) / m4325b();
        this.f4437i.postScale(fM4325b, fM4325b, f2, f3);
        setImageMatrix(m4327c());
        m4324a(true, true);
    }

    /* renamed from: a */
    protected void m4321a(float f, float f2, float f3, float f4) {
        float fM4325b = (f - m4325b()) / f4;
        float fM4325b2 = m4325b();
        this.f4442n.post(new RunnableC0731d(this, f4, System.currentTimeMillis(), fM4325b2, fM4325b, f2, f3));
    }

    /* renamed from: a */
    public void m4322a(Bitmap bitmap, int i, boolean z) {
        m4323a(new RotateBitmap(bitmap, i), z);
    }

    /* renamed from: a */
    public void m4323a(RotateBitmap rotateBitmap, boolean z) {
        if (getWidth() <= 0) {
            this.f4435d = new RunnableC0730c(this, rotateBitmap, z);
            return;
        }
        if (rotateBitmap.m4339b() != null) {
            m4316a(rotateBitmap, this.f4436h);
            m4315a(rotateBitmap.m4339b(), rotateBitmap.m4336a());
        } else {
            this.f4436h.reset();
            setImageBitmap(null);
        }
        if (z) {
            this.f4437i.reset();
        }
        setImageMatrix(m4327c());
        this.f4441m = m4328d();
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0099  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void m4324a(boolean r8, boolean r9) {
        /*
            r7 = this;
            r6 = 1073741824(0x40000000, float:2.0)
            r5 = 0
            com.sec.vip.cropimage.RotateBitmap r0 = r7.f4438j
            android.graphics.Bitmap r0 = r0.m4339b()
            if (r0 != 0) goto Lc
        Lb:
            return
        Lc:
            android.graphics.Matrix r0 = r7.m4327c()
            android.graphics.RectF r1 = new android.graphics.RectF
            com.sec.vip.cropimage.RotateBitmap r2 = r7.f4438j
            android.graphics.Bitmap r2 = r2.m4339b()
            int r2 = r2.getWidth()
            float r2 = (float) r2
            com.sec.vip.cropimage.RotateBitmap r3 = r7.f4438j
            android.graphics.Bitmap r3 = r3.m4339b()
            int r3 = r3.getHeight()
            float r3 = (float) r3
            r1.<init>(r5, r5, r2, r3)
            r0.mapRect(r1)
            float r0 = r1.height()
            float r2 = r1.width()
            if (r9 == 0) goto L99
            int r3 = r7.getHeight()
            float r4 = (float) r3
            int r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r4 >= 0) goto L66
            float r3 = (float) r3
            float r0 = r3 - r0
            float r0 = r0 / r6
            float r3 = r1.top
            float r0 = r0 - r3
        L48:
            if (r8 == 0) goto L97
            int r3 = r7.getWidth()
            float r4 = (float) r3
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 >= 0) goto L80
            float r3 = (float) r3
            float r2 = r3 - r2
            float r2 = r2 / r6
            float r1 = r1.left
            float r1 = r2 - r1
        L5b:
            r7.mo4277a(r1, r0)
            android.graphics.Matrix r0 = r7.m4327c()
            r7.setImageMatrix(r0)
            goto Lb
        L66:
            float r0 = r1.top
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 <= 0) goto L70
            float r0 = r1.top
            float r0 = -r0
            goto L48
        L70:
            float r0 = r1.bottom
            float r3 = (float) r3
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 >= 0) goto L99
            int r0 = r7.getHeight()
            float r0 = (float) r0
            float r3 = r1.bottom
            float r0 = r0 - r3
            goto L48
        L80:
            float r2 = r1.left
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 <= 0) goto L8a
            float r1 = r1.left
            float r1 = -r1
            goto L5b
        L8a:
            float r2 = r1.right
            float r4 = (float) r3
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 >= 0) goto L97
            float r2 = (float) r3
            float r1 = r1.right
            float r1 = r2 - r1
            goto L5b
        L97:
            r1 = r5
            goto L5b
        L99:
            r0 = r5
            goto L48
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.vip.cropimage.ImageViewTouchBase.m4324a(boolean, boolean):void");
    }

    /* renamed from: b */
    protected float m4325b() {
        return m4318a(this.f4437i);
    }

    /* renamed from: b */
    protected void m4326b(float f, float f2) {
        mo4277a(f, f2);
        setImageMatrix(m4327c());
    }

    /* renamed from: c */
    protected Matrix m4327c() {
        this.f4432a.set(this.f4436h);
        this.f4432a.postConcat(this.f4437i);
        return this.f4432a;
    }

    /* renamed from: d */
    protected float m4328d() {
        if (this.f4438j.m4339b() == null) {
            return 1.0f;
        }
        return Math.max(this.f4438j.m4343f() / this.f4439k, this.f4438j.m4342e() / this.f4440l) * 4.0f;
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
        if (i != 4 || m4325b() <= 1.0f) {
            return super.onKeyUp(i, keyEvent);
        }
        m4320a(1.0f);
        return true;
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f4439k = i3 - i;
        this.f4440l = i4 - i2;
        Runnable runnable = this.f4435d;
        if (runnable != null) {
            this.f4435d = null;
            runnable.run();
        }
        if (this.f4438j.m4339b() != null) {
            m4316a(this.f4438j, this.f4436h);
            setImageMatrix(m4327c());
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        m4315a(bitmap, 0);
    }
}
