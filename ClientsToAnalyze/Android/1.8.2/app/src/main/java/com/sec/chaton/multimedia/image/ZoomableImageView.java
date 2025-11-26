package com.sec.chaton.multimedia.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.ImageView;

/* loaded from: classes.dex */
public class ZoomableImageView extends ImageView {

    /* renamed from: a */
    private Matrix f3620a;

    /* renamed from: b */
    private Matrix f3621b;

    /* renamed from: c */
    private Matrix f3622c;

    /* renamed from: d */
    private Matrix f3623d;

    /* renamed from: e */
    private Paint f3624e;

    /* renamed from: f */
    private float[] f3625f;

    /* renamed from: g */
    private Bitmap f3626g;

    /* renamed from: h */
    private int f3627h;

    /* renamed from: i */
    private int f3628i;

    /* renamed from: j */
    private float f3629j;

    /* renamed from: k */
    private Runnable f3630k;

    /* renamed from: l */
    private Runnable f3631l;

    /* renamed from: m */
    private Runnable f3632m;

    /* renamed from: n */
    private double f3633n;

    /* renamed from: o */
    private ScaleGestureDetector f3634o;

    /* renamed from: p */
    private GestureDetector f3635p;

    public ZoomableImageView(Context context) {
        super(context);
        this.f3620a = new Matrix();
        this.f3621b = new Matrix();
        this.f3622c = new Matrix();
        this.f3623d = new Matrix();
        this.f3625f = new float[9];
        this.f3627h = -1;
        this.f3628i = -1;
        this.f3630k = null;
        this.f3631l = null;
        this.f3632m = null;
        this.f3633n = 0.0d;
        m3871a(context);
    }

    public ZoomableImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3620a = new Matrix();
        this.f3621b = new Matrix();
        this.f3622c = new Matrix();
        this.f3623d = new Matrix();
        this.f3625f = new float[9];
        this.f3627h = -1;
        this.f3628i = -1;
        this.f3630k = null;
        this.f3631l = null;
        this.f3632m = null;
        this.f3633n = 0.0d;
        m3871a(context);
    }

    /* renamed from: a */
    private void m3871a(Context context) {
        this.f3624e = new Paint();
        this.f3624e.setDither(true);
        this.f3624e.setFilterBitmap(true);
        this.f3624e.setAntiAlias(true);
        this.f3631l = new RunnableC0988f(this);
        this.f3634o = new ScaleGestureDetector(context, new C0993k(this));
        this.f3635p = new GestureDetector(context, new C0992j(this, null));
        if (Build.VERSION.SDK_INT >= 11) {
            setLayerType(2, null);
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f3627h = i3 - i;
        this.f3628i = i4 - i2;
        Runnable runnable = this.f3630k;
        if (runnable != null) {
            this.f3630k = null;
            runnable.run();
        }
        if (this.f3626g != null) {
            m3872a(this.f3626g, this.f3620a);
            setImageMatrix(m3884b());
        }
    }

    /* renamed from: a */
    private static void m3873a(Matrix matrix, float[] fArr) {
        matrix.mapPoints(fArr);
    }

    @Override // android.widget.ImageView
    public void setImageMatrix(Matrix matrix) {
        if (matrix != null && matrix.isIdentity()) {
            matrix = null;
        }
        if ((matrix == null && !this.f3623d.isIdentity()) || (matrix != null && !this.f3623d.equals(matrix))) {
            this.f3623d.set(matrix);
            invalidate();
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        setImageBitmap(BitmapFactory.decodeResource(getResources(), i));
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        setImageBitmap(((BitmapDrawable) drawable).getBitmap());
    }

    public void setBitmap(Bitmap bitmap) {
        setImageBitmap(bitmap);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        int width = getWidth();
        if (Build.VERSION.SDK_INT >= 11 && bitmap != null && bitmap.getHeight() > 1800) {
            setLayerType(1, null);
        }
        if (width <= 0) {
            this.f3630k = new RunnableC0989g(this, bitmap);
            return;
        }
        if (bitmap != null) {
            m3872a(bitmap, this.f3620a);
            this.f3626g = bitmap;
        } else {
            this.f3620a.reset();
            this.f3626g = bitmap;
        }
        this.f3621b.reset();
        setImageMatrix(m3884b());
        this.f3629j = m3886c();
        m3879a(m3887d());
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b4  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void m3883a(boolean r11, boolean r12, boolean r13) {
        /*
            r10 = this;
            r2 = 2
            r9 = 1073741824(0x40000000, float:2.0)
            r1 = 0
            r8 = 1
            r7 = 0
            android.graphics.Bitmap r0 = r10.f3626g
            if (r0 != 0) goto Lb
        La:
            return
        Lb:
            android.graphics.Matrix r0 = r10.m3884b()
            float[] r3 = new float[r2]
            r3 = {x00b6: FILL_ARRAY_DATA , data: [0, 0} // fill-array
            float[] r4 = new float[r2]
            android.graphics.Bitmap r2 = r10.f3626g
            int r2 = r2.getWidth()
            float r2 = (float) r2
            r4[r7] = r2
            android.graphics.Bitmap r2 = r10.f3626g
            int r2 = r2.getHeight()
            float r2 = (float) r2
            r4[r8] = r2
            m3873a(r0, r3)
            m3873a(r0, r4)
            r0 = r4[r8]
            r2 = r3[r8]
            float r0 = r0 - r2
            r2 = r4[r7]
            r5 = r3[r7]
            float r5 = r2 - r5
            if (r11 == 0) goto Lb4
            int r2 = r10.getHeight()
            float r6 = (float) r2
            int r6 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r6 >= 0) goto L80
            float r2 = (float) r2
            float r0 = r2 - r0
            float r0 = r0 / r9
            r2 = r3[r8]
            float r0 = r0 - r2
            r2 = r0
        L4c:
            if (r12 == 0) goto Lb2
            int r0 = r10.getWidth()
            float r6 = (float) r0
            int r6 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r6 >= 0) goto L9c
            float r0 = (float) r0
            float r0 = r0 - r5
            float r0 = r0 / r9
            r3 = r3[r7]
            float r0 = r0 - r3
        L5d:
            r10.m3880a(r0, r2)
            if (r13 == 0) goto L78
            android.view.animation.TranslateAnimation r3 = new android.view.animation.TranslateAnimation
            float r0 = -r0
            float r2 = -r2
            r3.<init>(r0, r1, r2, r1)
            long r0 = android.os.SystemClock.elapsedRealtime()
            r3.setStartTime(r0)
            r0 = 250(0xfa, double:1.235E-321)
            r3.setDuration(r0)
            r10.setAnimation(r3)
        L78:
            android.graphics.Matrix r0 = r10.m3884b()
            r10.setImageMatrix(r0)
            goto La
        L80:
            r0 = r3[r8]
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L8b
            r0 = r3[r8]
            float r0 = -r0
            r2 = r0
            goto L4c
        L8b:
            r0 = r4[r8]
            float r2 = (float) r2
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 >= 0) goto Lb4
            int r0 = r10.getHeight()
            float r0 = (float) r0
            r2 = r4[r8]
            float r0 = r0 - r2
            r2 = r0
            goto L4c
        L9c:
            r5 = r3[r7]
            int r5 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r5 <= 0) goto La6
            r0 = r3[r7]
            float r0 = -r0
            goto L5d
        La6:
            r3 = r4[r7]
            float r5 = (float) r0
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 >= 0) goto Lb2
            float r0 = (float) r0
            r3 = r4[r7]
            float r0 = r0 - r3
            goto L5d
        Lb2:
            r0 = r1
            goto L5d
        Lb4:
            r2 = r1
            goto L4c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.multimedia.image.ZoomableImageView.m3883a(boolean, boolean, boolean):void");
    }

    /* renamed from: a */
    protected float m3878a(Matrix matrix, int i) {
        matrix.getValues(this.f3625f);
        return this.f3625f[i];
    }

    /* renamed from: a */
    protected float m3877a(Matrix matrix) {
        if (this.f3626g != null) {
            return m3878a(matrix, 0);
        }
        return 1.0f;
    }

    /* renamed from: a */
    public float m3876a() {
        return m3877a(this.f3621b);
    }

    /* renamed from: a */
    private void m3872a(Bitmap bitmap, Matrix matrix) {
        float width = getWidth();
        float height = getHeight();
        matrix.reset();
        float fMin = Math.min(width / bitmap.getWidth(), 1.0f);
        float fMin2 = Math.min(height / bitmap.getHeight(), 1.0f);
        if (fMin <= fMin2) {
            fMin2 = fMin;
        }
        matrix.setScale(fMin2, fMin2);
        matrix.postTranslate((width - (bitmap.getWidth() * fMin2)) / 2.0f, (height - (fMin2 * bitmap.getHeight())) / 2.0f);
    }

    /* renamed from: b */
    protected Matrix m3884b() {
        this.f3622c.set(this.f3620a);
        this.f3622c.postConcat(this.f3621b);
        return this.f3622c;
    }

    /* renamed from: c */
    protected float m3886c() {
        if (this.f3626g == null) {
            return 1.0f;
        }
        return Math.max(this.f3626g.getWidth() / this.f3627h, this.f3626g.getHeight() / this.f3628i) * 16.0f;
    }

    /* renamed from: d */
    public float m3887d() {
        if (this.f3626g == null) {
            return 1.0f;
        }
        return Math.max(Math.min(this.f3627h / this.f3626g.getWidth(), this.f3628i / this.f3626g.getHeight()), 1.0f);
    }

    /* renamed from: a */
    protected void m3881a(float f, float f2, float f3) {
        if (f > this.f3629j) {
            f = this.f3629j;
        }
        float fM3876a = f / m3876a();
        this.f3621b.postScale(fM3876a, fM3876a, f2, f3);
        setImageMatrix(m3884b());
        m3883a(true, true, false);
    }

    /* renamed from: a */
    protected void m3882a(float f, float f2, float f3, float f4) {
        float fM3876a = (f - m3876a()) / f4;
        post(new RunnableC0990h(this, f4, System.currentTimeMillis(), m3876a(), fM3876a, f2, f3));
    }

    /* renamed from: a */
    public void m3879a(float f) {
        m3881a(f, getWidth() / 2.0f, getHeight() / 2.0f);
    }

    /* renamed from: a */
    protected void m3880a(float f, float f2) {
        this.f3621b.postTranslate(f, f2);
    }

    /* renamed from: b */
    protected void m3885b(float f, float f2, float f3) {
        this.f3632m = new RunnableC0991i(this, f3, System.currentTimeMillis(), f, f2);
        post(this.f3632m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public float m3874b(float f, float f2, float f3, float f4) {
        float f5 = (f / f4) - 1.0f;
        return (((f5 * f5 * f5) + 1.0f) * f3) + f2;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f3626g != null && !this.f3626g.isRecycled()) {
            if (Build.VERSION.SDK_INT >= 11 && getLayerType() == 2) {
                canvas.drawBitmap(this.f3626g, this.f3623d, null);
                return;
            }
            if (System.currentTimeMillis() - this.f3633n > 250.0d) {
                canvas.drawBitmap(this.f3626g, this.f3623d, this.f3624e);
                this.f3633n = System.currentTimeMillis();
            } else {
                canvas.drawBitmap(this.f3626g, this.f3623d, null);
                removeCallbacks(this.f3631l);
                postDelayed(this.f3631l, 250L);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f3626g != null) {
            int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
            if ((action == 1 || action == 6) && m3876a() <= m3887d()) {
                m3879a(m3887d());
            }
            this.f3634o.onTouchEvent(motionEvent);
            if (!this.f3634o.isInProgress()) {
                this.f3635p.onTouchEvent(motionEvent);
            }
        }
        return true;
    }
}
