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
import com.sec.chaton.util.C3250y;

/* loaded from: classes.dex */
public class ZoomableImageView extends View {

    /* renamed from: A */
    PointF f12393A;

    /* renamed from: B */
    PointF f12394B;

    /* renamed from: C */
    boolean f12395C;

    /* renamed from: D */
    float f12396D;

    /* renamed from: E */
    float f12397E;

    /* renamed from: F */
    float f12398F;

    /* renamed from: G */
    float f12399G;

    /* renamed from: H */
    float f12400H;

    /* renamed from: I */
    private Runnable f12401I;

    /* renamed from: J */
    private Runnable f12402J;

    /* renamed from: a */
    private Bitmap f12403a;

    /* renamed from: b */
    private int f12404b;

    /* renamed from: c */
    private int f12405c;

    /* renamed from: d */
    private Handler f12406d;

    /* renamed from: e */
    private GestureDetector f12407e;

    /* renamed from: f */
    private int f12408f;

    /* renamed from: g */
    Paint f12409g;

    /* renamed from: h */
    Matrix f12410h;

    /* renamed from: i */
    Matrix f12411i;

    /* renamed from: j */
    PointF f12412j;

    /* renamed from: k */
    float f12413k;

    /* renamed from: l */
    float f12414l;

    /* renamed from: m */
    float f12415m;

    /* renamed from: n */
    int f12416n;

    /* renamed from: o */
    float f12417o;

    /* renamed from: p */
    float f12418p;

    /* renamed from: q */
    float f12419q;

    /* renamed from: r */
    float f12420r;

    /* renamed from: s */
    float f12421s;

    /* renamed from: t */
    float f12422t;

    /* renamed from: u */
    float f12423u;

    /* renamed from: v */
    float f12424v;

    /* renamed from: w */
    boolean f12425w;

    /* renamed from: x */
    float f12426x;

    /* renamed from: y */
    float f12427y;

    /* renamed from: z */
    PointF f12428z;

    public void setDefaultScale(int i) {
        this.f12408f = i;
    }

    public ZoomableImageView(Context context) {
        super(context);
        this.f12403a = null;
        this.f12410h = new Matrix();
        this.f12411i = new Matrix();
        this.f12412j = new PointF();
        this.f12413k = 1.0f;
        this.f12414l = 0.0f;
        this.f12415m = 0.0f;
        this.f12416n = 0;
        this.f12424v = 0.2f;
        this.f12425w = false;
        this.f12426x = 0.5f;
        this.f12427y = 1.0f;
        this.f12428z = new PointF();
        this.f12393A = new PointF();
        this.f12394B = new PointF();
        this.f12395C = false;
        this.f12406d = new Handler();
        this.f12397E = 3.0f;
        this.f12398F = 25.0f;
        this.f12399G = 20.0f;
        this.f12401I = new RunnableC3445bt(this);
        this.f12402J = new RunnableC3446bu(this);
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.f12400H = context.getResources().getDisplayMetrics().density;
        m12086a();
        this.f12407e = new GestureDetector(new C3447bv(this));
    }

    public ZoomableImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12403a = null;
        this.f12410h = new Matrix();
        this.f12411i = new Matrix();
        this.f12412j = new PointF();
        this.f12413k = 1.0f;
        this.f12414l = 0.0f;
        this.f12415m = 0.0f;
        this.f12416n = 0;
        this.f12424v = 0.2f;
        this.f12425w = false;
        this.f12426x = 0.5f;
        this.f12427y = 1.0f;
        this.f12428z = new PointF();
        this.f12393A = new PointF();
        this.f12394B = new PointF();
        this.f12395C = false;
        this.f12406d = new Handler();
        this.f12397E = 3.0f;
        this.f12398F = 25.0f;
        this.f12399G = 20.0f;
        this.f12401I = new RunnableC3445bt(this);
        this.f12402J = new RunnableC3446bu(this);
        this.f12400H = context.getResources().getDisplayMetrics().density;
        m12086a();
        this.f12407e = new GestureDetector(new C3447bv(this));
        this.f12408f = 0;
    }

    /* renamed from: a */
    private void m12086a() {
        this.f12409g = new Paint();
        this.f12409g.setAntiAlias(true);
        this.f12409g.setDither(true);
        this.f12409g.setFilterBitmap(true);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int i5;
        float f;
        int i6;
        int i7 = 0;
        super.onSizeChanged(i, i2, i3, i4);
        this.f12404b = i;
        this.f12405c = i2;
        if (this.f12403a != null) {
            int height = this.f12403a.getHeight();
            int width = this.f12403a.getWidth();
            if (this.f12408f == 0) {
                if (this.f12404b > this.f12405c) {
                    if (height >= width) {
                        f = this.f12405c / height;
                        i6 = (this.f12404b - ((int) (width * f))) / 2;
                        this.f12410h.setScale(f, f);
                        this.f12410h.postTranslate(i6, 0.0f);
                    } else {
                        f = this.f12404b / width;
                        int i8 = (this.f12405c - ((int) (height * f))) / 2;
                        this.f12410h.setScale(f, f);
                        this.f12410h.postTranslate(0.0f, i8);
                        i6 = 0;
                        i7 = i8;
                    }
                } else if (height >= width) {
                    f = this.f12404b / width;
                    int i9 = (this.f12405c - ((int) (height * f))) / 2;
                    this.f12410h.setScale(f, f);
                    this.f12410h.postTranslate(0.0f, i9);
                    i6 = 0;
                    i7 = i9;
                } else {
                    f = this.f12405c / height;
                    i6 = (this.f12404b - ((int) (width * f))) / 2;
                    this.f12410h.setScale(f, f);
                    this.f12410h.postTranslate(i6, 0.0f);
                }
                this.f12414l = i6;
                this.f12415m = i7;
                this.f12413k = f;
                this.f12396D = f;
            } else {
                if (width > this.f12404b) {
                    int i10 = (this.f12405c - height) / 2;
                    this.f12410h.postTranslate(0.0f, i10);
                    i5 = 0;
                    i7 = i10;
                } else {
                    i5 = (this.f12404b - width) / 2;
                    this.f12410h.postTranslate(i5, 0.0f);
                }
                this.f12414l = i5;
                this.f12415m = i7;
                this.f12413k = 1.0f;
                this.f12396D = 1.0f;
            }
            invalidate();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f12403a != null && canvas != null) {
            canvas.drawBitmap(this.f12403a, this.f12410h, this.f12409g);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m12089b() {
        boolean z;
        boolean z2 = false;
        if (this.f12403a != null) {
            float[] fArr = new float[9];
            this.f12410h.getValues(fArr);
            this.f12413k = fArr[0];
            if (this.f12413k < this.f12396D) {
                float f = this.f12396D / this.f12413k;
                this.f12410h.postScale(f, f, this.f12404b / 2, this.f12405c / 2);
                invalidate();
            }
            this.f12410h.getValues(fArr);
            this.f12413k = fArr[0];
            this.f12414l = fArr[2];
            this.f12415m = fArr[5];
            int width = this.f12404b - ((int) (this.f12403a.getWidth() * this.f12413k));
            int height = this.f12405c - ((int) (this.f12403a.getHeight() * this.f12413k));
            if (width >= 0) {
                this.f12417o = width / 2;
                z = true;
            } else if (this.f12414l > 0.0f) {
                this.f12417o = 0.0f;
                z = true;
            } else if (this.f12414l < width) {
                this.f12417o = width;
                z = true;
            } else {
                z = false;
            }
            if (height >= 0) {
                this.f12418p = height / 2;
                z2 = true;
            } else if (this.f12415m > 0.0f) {
                this.f12418p = 0.0f;
                z2 = true;
            } else if (this.f12415m < height) {
                this.f12418p = height;
                z2 = true;
            }
            if (z || z2) {
                if (!z2) {
                    this.f12418p = this.f12415m;
                }
                if (!z) {
                    this.f12417o = this.f12414l;
                }
                this.f12425w = true;
                this.f12406d.removeCallbacks(this.f12401I);
                this.f12406d.postDelayed(this.f12401I, 100L);
            }
        }
    }

    /* renamed from: c */
    private void m12091c() {
        boolean z;
        boolean z2 = true;
        if (this.f12403a != null) {
            float[] fArr = new float[9];
            this.f12410h.getValues(fArr);
            this.f12413k = fArr[0];
            if (this.f12413k < this.f12396D) {
                float f = this.f12396D / this.f12413k;
                this.f12410h.postScale(f, f, this.f12404b / 2, this.f12405c / 2);
                invalidate();
            }
            this.f12410h.getValues(fArr);
            this.f12413k = fArr[0];
            this.f12414l = fArr[2];
            this.f12415m = fArr[5];
            int width = this.f12404b - ((int) (this.f12403a.getWidth() * this.f12413k));
            int height = this.f12405c - ((int) (this.f12403a.getHeight() * this.f12413k));
            if (width >= 0) {
                this.f12417o = width / 2;
                z = true;
            } else if (this.f12414l > 0.0f) {
                this.f12417o = 0.0f;
                z = true;
            } else if (this.f12414l < width) {
                this.f12417o = width;
                z = true;
            } else {
                z = false;
            }
            if (height >= 0) {
                this.f12418p = height / 2;
            } else if (this.f12415m > 0.0f) {
                this.f12418p = 0.0f;
            } else if (this.f12415m < height) {
                this.f12418p = height;
            } else {
                z2 = false;
            }
            if (z || z2) {
                if (!z2) {
                    this.f12418p = this.f12415m;
                }
                if (!z) {
                    this.f12417o = this.f12414l;
                }
                this.f12410h.postTranslate(this.f12417o - this.f12414l, this.f12418p - this.f12415m);
            }
        }
    }

    /* renamed from: d */
    public boolean m12096d(MotionEvent motionEvent) {
        if (!this.f12407e.onTouchEvent(motionEvent) && !this.f12425w) {
            float[] fArr = new float[9];
            switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
                case 0:
                    this.f12411i.set(this.f12410h);
                    this.f12412j.set(motionEvent.getX(), motionEvent.getY());
                    this.f12416n = 1;
                    break;
                case 1:
                case 6:
                    this.f12416n = 0;
                    this.f12410h.getValues(fArr);
                    this.f12414l = fArr[2];
                    this.f12415m = fArr[5];
                    this.f12413k = fArr[0];
                    m12089b();
                    break;
                case 2:
                    this.f12395C = false;
                    if (this.f12416n == 1 && !this.f12425w) {
                        this.f12410h.set(this.f12411i);
                        this.f12410h.postTranslate(motionEvent.getX() - this.f12412j.x, motionEvent.getY() - this.f12412j.y);
                        this.f12410h.getValues(fArr);
                        this.f12414l = fArr[2];
                        this.f12415m = fArr[5];
                        this.f12413k = fArr[0];
                        break;
                    } else if (this.f12416n == 2 && !this.f12425w) {
                        float fM12084a = m12084a(motionEvent);
                        if (fM12084a > 10.0f) {
                            this.f12410h.set(this.f12411i);
                            float f = fM12084a / this.f12427y;
                            this.f12410h.getValues(fArr);
                            this.f12413k = fArr[0];
                            if (this.f12413k * f <= this.f12396D) {
                                this.f12410h.postScale(this.f12396D / this.f12413k, this.f12396D / this.f12413k, this.f12428z.x, this.f12428z.y);
                            } else if (this.f12413k * f >= this.f12397E) {
                                this.f12410h.postScale(this.f12397E / this.f12413k, this.f12397E / this.f12413k, this.f12428z.x, this.f12428z.y);
                            } else {
                                this.f12410h.postScale(f, f, this.f12428z.x, this.f12428z.y);
                            }
                            this.f12395C = true;
                        }
                        if (!this.f12395C) {
                            this.f12410h.set(this.f12411i);
                        }
                        m12087a(this.f12393A, motionEvent);
                        this.f12410h.postTranslate(this.f12393A.x - this.f12394B.x, this.f12393A.y - this.f12394B.y);
                        this.f12410h.getValues(fArr);
                        this.f12414l = fArr[2];
                        this.f12415m = fArr[5];
                        this.f12413k = fArr[0];
                        m12091c();
                        break;
                    }
                    break;
                case 5:
                    this.f12427y = m12084a(motionEvent);
                    if (this.f12427y > 10.0f) {
                        this.f12411i.set(this.f12410h);
                        m12087a(this.f12428z, motionEvent);
                        this.f12416n = 2;
                    }
                    m12087a(this.f12394B, motionEvent);
                    break;
            }
            invalidate();
        }
        return true;
    }

    /* renamed from: a */
    private float m12084a(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return FloatMath.sqrt((x * x) + (y * y));
    }

    /* renamed from: a */
    private void m12087a(PointF pointF, MotionEvent motionEvent) {
        pointF.set((motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f, (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f);
    }

    /* renamed from: B */
    public float m12093B() {
        return this.f12413k;
    }

    /* renamed from: C */
    public void m12094C() {
        this.f12410h = new Matrix();
        this.f12411i = new Matrix();
        this.f12413k = 1.0f;
        this.f12414l = 0.0f;
        this.f12415m = 0.0f;
    }

    /* renamed from: D */
    public PointF m12095D() {
        return new PointF(this.f12414l, this.f12415m);
    }

    public void setBitmap(Bitmap bitmap) {
        int i;
        float f;
        int i2;
        if (bitmap != null) {
            this.f12403a = bitmap;
            this.f12404b = getWidth();
            this.f12405c = getHeight();
            int height = this.f12403a.getHeight();
            int width = this.f12403a.getWidth();
            this.f12410h.reset();
            if (this.f12408f == 0) {
                if (width > this.f12404b) {
                    f = this.f12404b / width;
                    i2 = (this.f12405c - ((int) (height * f))) / 2;
                    this.f12410h.setScale(f, f);
                    this.f12410h.postTranslate(0.0f, i2);
                } else {
                    f = this.f12405c / height;
                    int i3 = (this.f12404b - ((int) (width * f))) / 2;
                    this.f12410h.setScale(f, f);
                    this.f12410h.postTranslate(i3, 0.0f);
                    i = i3;
                    i2 = 0;
                }
                this.f12414l = i;
                this.f12415m = i2;
                this.f12413k = f;
                this.f12396D = f;
            } else {
                if (width > this.f12404b) {
                    i = height > this.f12405c ? 0 : (this.f12405c - height) / 2;
                    this.f12410h.postTranslate(0.0f, i);
                } else {
                    int i4 = (this.f12404b - width) / 2;
                    i = height <= this.f12405c ? (this.f12405c - height) / 2 : 0;
                    this.f12410h.postTranslate(i4, 0.0f);
                    int i5 = i;
                    i = i4;
                    i = i5;
                }
                this.f12414l = i;
                this.f12415m = i;
                this.f12413k = 1.0f;
                this.f12396D = 1.0f;
            }
            invalidate();
            return;
        }
        C3250y.m11442a("bitmap is null", getClass().getSimpleName());
    }
}
