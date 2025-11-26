package com.sec.vip.amschaton;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.os.Handler;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.util.FloatMath;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.util.C1786r;

/* loaded from: classes.dex */
public class ZoomableImageView extends View {

    /* renamed from: A */
    float f6729A;

    /* renamed from: B */
    float f6730B;

    /* renamed from: C */
    float f6731C;

    /* renamed from: D */
    float f6732D;

    /* renamed from: E */
    float f6733E;

    /* renamed from: F */
    private Handler f6734F;

    /* renamed from: G */
    private GestureDetector f6735G;

    /* renamed from: H */
    private int f6736H;

    /* renamed from: I */
    private Runnable f6737I;

    /* renamed from: J */
    private Runnable f6738J;

    /* renamed from: a */
    private Bitmap f6739a;

    /* renamed from: b */
    private int f6740b;

    /* renamed from: c */
    private int f6741c;

    /* renamed from: d */
    Paint f6742d;

    /* renamed from: e */
    Matrix f6743e;

    /* renamed from: f */
    Matrix f6744f;

    /* renamed from: g */
    PointF f6745g;

    /* renamed from: h */
    float f6746h;

    /* renamed from: i */
    float f6747i;

    /* renamed from: j */
    float f6748j;

    /* renamed from: k */
    int f6749k;

    /* renamed from: l */
    float f6750l;

    /* renamed from: m */
    float f6751m;

    /* renamed from: n */
    float f6752n;

    /* renamed from: o */
    float f6753o;

    /* renamed from: p */
    float f6754p;

    /* renamed from: q */
    float f6755q;

    /* renamed from: r */
    float f6756r;

    /* renamed from: s */
    float f6757s;

    /* renamed from: t */
    boolean f6758t;

    /* renamed from: u */
    float f6759u;

    /* renamed from: v */
    float f6760v;

    /* renamed from: w */
    PointF f6761w;

    /* renamed from: x */
    PointF f6762x;

    /* renamed from: y */
    PointF f6763y;

    /* renamed from: z */
    boolean f6764z;

    public void setDefaultScale(int i) {
        this.f6736H = i;
    }

    public ZoomableImageView(Context context) {
        super(context);
        this.f6739a = null;
        this.f6743e = new Matrix();
        this.f6744f = new Matrix();
        this.f6745g = new PointF();
        this.f6746h = 1.0f;
        this.f6747i = 0.0f;
        this.f6748j = 0.0f;
        this.f6749k = 0;
        this.f6757s = 0.2f;
        this.f6758t = false;
        this.f6759u = 0.5f;
        this.f6760v = 1.0f;
        this.f6761w = new PointF();
        this.f6762x = new PointF();
        this.f6763y = new PointF();
        this.f6764z = false;
        this.f6734F = new Handler();
        this.f6730B = 3.0f;
        this.f6731C = 25.0f;
        this.f6732D = 20.0f;
        this.f6737I = new RunnableC1883bp(this);
        this.f6738J = new RunnableC1884bq(this);
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.f6733E = context.getResources().getDisplayMetrics().density;
        m6374a();
        this.f6735G = new GestureDetector(new C1885br(this));
    }

    public ZoomableImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6739a = null;
        this.f6743e = new Matrix();
        this.f6744f = new Matrix();
        this.f6745g = new PointF();
        this.f6746h = 1.0f;
        this.f6747i = 0.0f;
        this.f6748j = 0.0f;
        this.f6749k = 0;
        this.f6757s = 0.2f;
        this.f6758t = false;
        this.f6759u = 0.5f;
        this.f6760v = 1.0f;
        this.f6761w = new PointF();
        this.f6762x = new PointF();
        this.f6763y = new PointF();
        this.f6764z = false;
        this.f6734F = new Handler();
        this.f6730B = 3.0f;
        this.f6731C = 25.0f;
        this.f6732D = 20.0f;
        this.f6737I = new RunnableC1883bp(this);
        this.f6738J = new RunnableC1884bq(this);
        this.f6733E = context.getResources().getDisplayMetrics().density;
        m6374a();
        this.f6735G = new GestureDetector(new C1885br(this));
        this.f6736H = 0;
    }

    /* renamed from: a */
    private void m6374a() {
        this.f6742d = new Paint();
        this.f6742d.setAntiAlias(true);
        this.f6742d.setDither(true);
        this.f6742d.setFilterBitmap(true);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int i5;
        float f;
        int i6;
        int i7 = 0;
        super.onSizeChanged(i, i2, i3, i4);
        this.f6740b = i;
        this.f6741c = i2;
        if (this.f6739a != null) {
            int height = this.f6739a.getHeight();
            int width = this.f6739a.getWidth();
            if (this.f6736H == 0) {
                if (this.f6740b > this.f6741c) {
                    if (width > this.f6740b) {
                        f = this.f6740b / width;
                        i6 = (this.f6741c - ((int) (height * f))) / 2;
                        this.f6743e.setScale(f, f);
                        this.f6743e.postTranslate(0.0f, i6);
                    } else {
                        f = this.f6741c / height;
                        int i8 = (this.f6740b - ((int) (width * f))) / 2;
                        this.f6743e.setScale(f, f);
                        this.f6743e.postTranslate(i8, 0.0f);
                        i7 = i8;
                        i6 = 0;
                    }
                } else if (height > this.f6741c) {
                    f = this.f6741c / height;
                    int i9 = (this.f6740b - ((int) (width * f))) / 2;
                    this.f6743e.setScale(f, f);
                    this.f6743e.postTranslate(i9, 0.0f);
                    i7 = i9;
                    i6 = 0;
                } else {
                    f = this.f6740b / width;
                    i6 = (this.f6741c - ((int) (height * f))) / 2;
                    this.f6743e.setScale(f, f);
                    this.f6743e.postTranslate(0.0f, i6);
                }
                this.f6747i = i7;
                this.f6748j = i6;
                this.f6746h = f;
                this.f6729A = f;
            } else {
                if (width > this.f6740b) {
                    int i10 = (this.f6741c - height) / 2;
                    this.f6743e.postTranslate(0.0f, i10);
                    i5 = 0;
                    i7 = i10;
                } else {
                    i5 = (this.f6740b - width) / 2;
                    this.f6743e.postTranslate(i5, 0.0f);
                }
                this.f6747i = i5;
                this.f6748j = i7;
                this.f6746h = 1.0f;
                this.f6729A = 1.0f;
            }
            invalidate();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f6739a != null && canvas != null) {
            canvas.drawBitmap(this.f6739a, this.f6743e, this.f6742d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m6377b() {
        boolean z;
        boolean z2 = false;
        if (this.f6739a != null) {
            float[] fArr = new float[9];
            this.f6743e.getValues(fArr);
            this.f6746h = fArr[0];
            if (this.f6746h < this.f6729A) {
                float f = this.f6729A / this.f6746h;
                this.f6743e.postScale(f, f, this.f6740b / 2, this.f6741c / 2);
                invalidate();
            }
            this.f6743e.getValues(fArr);
            this.f6746h = fArr[0];
            this.f6747i = fArr[2];
            this.f6748j = fArr[5];
            int width = this.f6740b - ((int) (this.f6739a.getWidth() * this.f6746h));
            int height = this.f6741c - ((int) (this.f6739a.getHeight() * this.f6746h));
            if (width >= 0) {
                this.f6750l = width / 2;
                z = true;
            } else if (this.f6747i > 0.0f) {
                this.f6750l = 0.0f;
                z = true;
            } else if (this.f6747i < width) {
                this.f6750l = width;
                z = true;
            } else {
                z = false;
            }
            if (height >= 0) {
                this.f6751m = height / 2;
                z2 = true;
            } else if (this.f6748j > 0.0f) {
                this.f6751m = 0.0f;
                z2 = true;
            } else if (this.f6748j < height) {
                this.f6751m = height;
                z2 = true;
            }
            if (z || z2) {
                if (!z2) {
                    this.f6751m = this.f6748j;
                }
                if (!z) {
                    this.f6750l = this.f6747i;
                }
                this.f6758t = true;
                this.f6734F.removeCallbacks(this.f6737I);
                this.f6734F.postDelayed(this.f6737I, 100L);
            }
        }
    }

    /* renamed from: c */
    private void m6379c() {
        boolean z;
        boolean z2 = true;
        if (this.f6739a != null) {
            float[] fArr = new float[9];
            this.f6743e.getValues(fArr);
            this.f6746h = fArr[0];
            if (this.f6746h < this.f6729A) {
                float f = this.f6729A / this.f6746h;
                this.f6743e.postScale(f, f, this.f6740b / 2, this.f6741c / 2);
                invalidate();
            }
            this.f6743e.getValues(fArr);
            this.f6746h = fArr[0];
            this.f6747i = fArr[2];
            this.f6748j = fArr[5];
            int width = this.f6740b - ((int) (this.f6739a.getWidth() * this.f6746h));
            int height = this.f6741c - ((int) (this.f6739a.getHeight() * this.f6746h));
            if (width >= 0) {
                this.f6750l = width / 2;
                z = true;
            } else if (this.f6747i > 0.0f) {
                this.f6750l = 0.0f;
                z = true;
            } else if (this.f6747i < width) {
                this.f6750l = width;
                z = true;
            } else {
                z = false;
            }
            if (height >= 0) {
                this.f6751m = height / 2;
            } else if (this.f6748j > 0.0f) {
                this.f6751m = 0.0f;
            } else if (this.f6748j < height) {
                this.f6751m = height;
            } else {
                z2 = false;
            }
            if (z || z2) {
                if (!z2) {
                    this.f6751m = this.f6748j;
                }
                if (!z) {
                    this.f6750l = this.f6747i;
                }
                this.f6743e.postTranslate(this.f6750l - this.f6747i, this.f6751m - this.f6748j);
            }
        }
    }

    /* renamed from: d */
    public boolean m6384d(MotionEvent motionEvent) {
        if (!this.f6735G.onTouchEvent(motionEvent) && !this.f6758t) {
            float[] fArr = new float[9];
            switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
                case 0:
                    if (!this.f6758t) {
                        this.f6744f.set(this.f6743e);
                        this.f6745g.set(motionEvent.getX(), motionEvent.getY());
                        this.f6749k = 1;
                        break;
                    }
                    break;
                case 1:
                case 6:
                    this.f6749k = 0;
                    this.f6743e.getValues(fArr);
                    this.f6747i = fArr[2];
                    this.f6748j = fArr[5];
                    this.f6746h = fArr[0];
                    if (!this.f6758t) {
                        m6377b();
                        break;
                    }
                    break;
                case 2:
                    this.f6764z = false;
                    if (this.f6749k == 1 && !this.f6758t) {
                        this.f6743e.set(this.f6744f);
                        this.f6743e.postTranslate(motionEvent.getX() - this.f6745g.x, motionEvent.getY() - this.f6745g.y);
                        this.f6743e.getValues(fArr);
                        this.f6747i = fArr[2];
                        this.f6748j = fArr[5];
                        this.f6746h = fArr[0];
                        break;
                    } else if (this.f6749k == 2 && !this.f6758t) {
                        float fM6372a = m6372a(motionEvent);
                        if (fM6372a > 10.0f) {
                            this.f6743e.set(this.f6744f);
                            float f = fM6372a / this.f6760v;
                            this.f6743e.getValues(fArr);
                            this.f6746h = fArr[0];
                            if (this.f6746h * f <= this.f6729A) {
                                this.f6743e.postScale(this.f6729A / this.f6746h, this.f6729A / this.f6746h, this.f6761w.x, this.f6761w.y);
                            } else if (this.f6746h * f >= this.f6730B) {
                                this.f6743e.postScale(this.f6730B / this.f6746h, this.f6730B / this.f6746h, this.f6761w.x, this.f6761w.y);
                            } else {
                                this.f6743e.postScale(f, f, this.f6761w.x, this.f6761w.y);
                            }
                            this.f6764z = true;
                        }
                        if (!this.f6764z) {
                            this.f6743e.set(this.f6744f);
                        }
                        m6375a(this.f6762x, motionEvent);
                        this.f6743e.postTranslate(this.f6762x.x - this.f6763y.x, this.f6762x.y - this.f6763y.y);
                        this.f6743e.getValues(fArr);
                        this.f6747i = fArr[2];
                        this.f6748j = fArr[5];
                        this.f6746h = fArr[0];
                        m6379c();
                        break;
                    }
                    break;
                case 5:
                    this.f6760v = m6372a(motionEvent);
                    if (this.f6760v > 10.0f) {
                        this.f6744f.set(this.f6743e);
                        m6375a(this.f6761w, motionEvent);
                        this.f6749k = 2;
                    }
                    m6375a(this.f6763y, motionEvent);
                    break;
            }
            invalidate();
        }
        return true;
    }

    /* renamed from: a */
    private float m6372a(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return FloatMath.sqrt((x * x) + (y * y));
    }

    /* renamed from: a */
    private void m6375a(PointF pointF, MotionEvent motionEvent) {
        pointF.set((motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f, (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f);
    }

    /* renamed from: B */
    public float m6381B() {
        return this.f6746h;
    }

    /* renamed from: C */
    public void m6382C() {
        this.f6743e = new Matrix();
        this.f6744f = new Matrix();
        this.f6746h = 1.0f;
        this.f6747i = 0.0f;
        this.f6748j = 0.0f;
    }

    /* renamed from: D */
    public PointF m6383D() {
        return new PointF(this.f6747i, this.f6748j);
    }

    public void setBitmap(Bitmap bitmap) {
        int i;
        float f;
        int i2;
        if (bitmap != null) {
            this.f6739a = bitmap;
            this.f6740b = getWidth();
            this.f6741c = getHeight();
            int height = this.f6739a.getHeight();
            int width = this.f6739a.getWidth();
            this.f6743e.reset();
            if (this.f6736H == 0) {
                if (width > this.f6740b) {
                    f = this.f6740b / width;
                    i2 = (this.f6741c - ((int) (height * f))) / 2;
                    this.f6743e.setScale(f, f);
                    this.f6743e.postTranslate(0.0f, i2);
                } else {
                    f = this.f6741c / height;
                    int i3 = (this.f6740b - ((int) (width * f))) / 2;
                    this.f6743e.setScale(f, f);
                    this.f6743e.postTranslate(i3, 0.0f);
                    i = i3;
                    i2 = 0;
                }
                this.f6747i = i;
                this.f6748j = i2;
                this.f6746h = f;
                this.f6729A = f;
            } else {
                if (width > this.f6740b) {
                    i = height > this.f6741c ? 0 : (this.f6741c - height) / 2;
                    this.f6743e.postTranslate(0.0f, i);
                } else {
                    int i4 = (this.f6740b - width) / 2;
                    i = height <= this.f6741c ? (this.f6741c - height) / 2 : 0;
                    this.f6743e.postTranslate(i4, 0.0f);
                    int i5 = i;
                    i = i4;
                    i = i5;
                }
                this.f6747i = i;
                this.f6748j = i;
                this.f6746h = 1.0f;
                this.f6729A = 1.0f;
            }
            invalidate();
            return;
        }
        C1786r.m6054a("bitmap is null", getClass().getSimpleName());
    }
}
