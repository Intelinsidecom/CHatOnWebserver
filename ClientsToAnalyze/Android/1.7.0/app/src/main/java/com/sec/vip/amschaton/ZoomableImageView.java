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
import com.sec.chaton.util.C1341p;

/* loaded from: classes.dex */
public class ZoomableImageView extends View {

    /* renamed from: A */
    float f4741A;

    /* renamed from: B */
    float f4742B;

    /* renamed from: C */
    float f4743C;

    /* renamed from: D */
    float f4744D;

    /* renamed from: E */
    float f4745E;

    /* renamed from: F */
    private Handler f4746F;

    /* renamed from: G */
    private GestureDetector f4747G;

    /* renamed from: H */
    private int f4748H;

    /* renamed from: I */
    private Runnable f4749I;

    /* renamed from: J */
    private Runnable f4750J;

    /* renamed from: a */
    private Bitmap f4751a;

    /* renamed from: b */
    private int f4752b;

    /* renamed from: c */
    private int f4753c;

    /* renamed from: d */
    Paint f4754d;

    /* renamed from: e */
    Matrix f4755e;

    /* renamed from: f */
    Matrix f4756f;

    /* renamed from: g */
    PointF f4757g;

    /* renamed from: h */
    float f4758h;

    /* renamed from: i */
    float f4759i;

    /* renamed from: j */
    float f4760j;

    /* renamed from: k */
    int f4761k;

    /* renamed from: l */
    float f4762l;

    /* renamed from: m */
    float f4763m;

    /* renamed from: n */
    float f4764n;

    /* renamed from: o */
    float f4765o;

    /* renamed from: p */
    float f4766p;

    /* renamed from: q */
    float f4767q;

    /* renamed from: r */
    float f4768r;

    /* renamed from: s */
    float f4769s;

    /* renamed from: t */
    boolean f4770t;

    /* renamed from: u */
    float f4771u;

    /* renamed from: v */
    float f4772v;

    /* renamed from: w */
    PointF f4773w;

    /* renamed from: x */
    PointF f4774x;

    /* renamed from: y */
    PointF f4775y;

    /* renamed from: z */
    boolean f4776z;

    public void setDefaultScale(int i) {
        this.f4748H = i;
    }

    public ZoomableImageView(Context context) {
        super(context);
        this.f4751a = null;
        this.f4755e = new Matrix();
        this.f4756f = new Matrix();
        this.f4757g = new PointF();
        this.f4758h = 1.0f;
        this.f4759i = 0.0f;
        this.f4760j = 0.0f;
        this.f4761k = 0;
        this.f4769s = 0.2f;
        this.f4770t = false;
        this.f4771u = 0.5f;
        this.f4772v = 1.0f;
        this.f4773w = new PointF();
        this.f4774x = new PointF();
        this.f4775y = new PointF();
        this.f4776z = false;
        this.f4746F = new Handler();
        this.f4742B = 3.0f;
        this.f4743C = 25.0f;
        this.f4744D = 20.0f;
        this.f4749I = new RunnableC1401f(this);
        this.f4750J = new RunnableC1402g(this);
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.f4745E = context.getResources().getDisplayMetrics().density;
        m4849a();
        this.f4747G = new GestureDetector(new C1403h(this));
    }

    public ZoomableImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4751a = null;
        this.f4755e = new Matrix();
        this.f4756f = new Matrix();
        this.f4757g = new PointF();
        this.f4758h = 1.0f;
        this.f4759i = 0.0f;
        this.f4760j = 0.0f;
        this.f4761k = 0;
        this.f4769s = 0.2f;
        this.f4770t = false;
        this.f4771u = 0.5f;
        this.f4772v = 1.0f;
        this.f4773w = new PointF();
        this.f4774x = new PointF();
        this.f4775y = new PointF();
        this.f4776z = false;
        this.f4746F = new Handler();
        this.f4742B = 3.0f;
        this.f4743C = 25.0f;
        this.f4744D = 20.0f;
        this.f4749I = new RunnableC1401f(this);
        this.f4750J = new RunnableC1402g(this);
        this.f4745E = context.getResources().getDisplayMetrics().density;
        m4849a();
        this.f4747G = new GestureDetector(new C1403h(this));
        this.f4748H = 0;
    }

    /* renamed from: a */
    private void m4849a() {
        this.f4754d = new Paint();
        this.f4754d.setAntiAlias(true);
        this.f4754d.setDither(true);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int i5;
        float f;
        int i6;
        int i7 = 0;
        super.onSizeChanged(i, i2, i3, i4);
        this.f4752b = i;
        this.f4753c = i2;
        if (this.f4751a != null) {
            int height = this.f4751a.getHeight();
            int width = this.f4751a.getWidth();
            if (this.f4748H == 0) {
                if (this.f4752b > this.f4753c) {
                    if (width > this.f4752b) {
                        f = this.f4752b / width;
                        i6 = (this.f4753c - ((int) (height * f))) / 2;
                        this.f4755e.setScale(f, f);
                        this.f4755e.postTranslate(0.0f, i6);
                    } else {
                        f = this.f4753c / height;
                        int i8 = (this.f4752b - ((int) (width * f))) / 2;
                        this.f4755e.setScale(f, f);
                        this.f4755e.postTranslate(i8, 0.0f);
                        i7 = i8;
                        i6 = 0;
                    }
                } else if (height > this.f4753c) {
                    f = this.f4753c / height;
                    int i9 = (this.f4752b - ((int) (width * f))) / 2;
                    this.f4755e.setScale(f, f);
                    this.f4755e.postTranslate(i9, 0.0f);
                    i7 = i9;
                    i6 = 0;
                } else {
                    f = this.f4752b / width;
                    i6 = (this.f4753c - ((int) (height * f))) / 2;
                    this.f4755e.setScale(f, f);
                    this.f4755e.postTranslate(0.0f, i6);
                }
                this.f4759i = i7;
                this.f4760j = i6;
                this.f4758h = f;
                this.f4741A = f;
            } else {
                if (width > this.f4752b) {
                    int i10 = (this.f4753c - height) / 2;
                    this.f4755e.postTranslate(0.0f, i10);
                    i5 = 0;
                    i7 = i10;
                } else {
                    i5 = (this.f4752b - width) / 2;
                    this.f4755e.postTranslate(i5, 0.0f);
                }
                this.f4759i = i5;
                this.f4760j = i7;
                this.f4758h = 1.0f;
                this.f4741A = 1.0f;
            }
            invalidate();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f4751a != null && canvas != null) {
            canvas.drawBitmap(this.f4751a, this.f4755e, this.f4754d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m4852b() {
        boolean z;
        boolean z2 = false;
        if (this.f4751a != null) {
            float[] fArr = new float[9];
            this.f4755e.getValues(fArr);
            this.f4758h = fArr[0];
            if (this.f4758h < this.f4741A) {
                float f = this.f4741A / this.f4758h;
                this.f4755e.postScale(f, f, this.f4752b / 2, this.f4753c / 2);
                invalidate();
            }
            this.f4755e.getValues(fArr);
            this.f4758h = fArr[0];
            this.f4759i = fArr[2];
            this.f4760j = fArr[5];
            int width = this.f4752b - ((int) (this.f4751a.getWidth() * this.f4758h));
            int height = this.f4753c - ((int) (this.f4751a.getHeight() * this.f4758h));
            if (width >= 0) {
                this.f4762l = width / 2;
                z = true;
            } else if (this.f4759i > 0.0f) {
                this.f4762l = 0.0f;
                z = true;
            } else if (this.f4759i < width) {
                this.f4762l = width;
                z = true;
            } else {
                z = false;
            }
            if (height >= 0) {
                this.f4763m = height / 2;
                z2 = true;
            } else if (this.f4760j > 0.0f) {
                this.f4763m = 0.0f;
                z2 = true;
            } else if (this.f4760j < height) {
                this.f4763m = height;
                z2 = true;
            }
            if (z || z2) {
                if (!z2) {
                    this.f4763m = this.f4760j;
                }
                if (!z) {
                    this.f4762l = this.f4759i;
                }
                this.f4770t = true;
                this.f4746F.removeCallbacks(this.f4749I);
                this.f4746F.postDelayed(this.f4749I, 100L);
            }
        }
    }

    /* renamed from: c */
    private void m4854c() {
        boolean z;
        boolean z2 = true;
        if (this.f4751a != null) {
            float[] fArr = new float[9];
            this.f4755e.getValues(fArr);
            this.f4758h = fArr[0];
            if (this.f4758h < this.f4741A) {
                float f = this.f4741A / this.f4758h;
                this.f4755e.postScale(f, f, this.f4752b / 2, this.f4753c / 2);
                invalidate();
            }
            this.f4755e.getValues(fArr);
            this.f4758h = fArr[0];
            this.f4759i = fArr[2];
            this.f4760j = fArr[5];
            int width = this.f4752b - ((int) (this.f4751a.getWidth() * this.f4758h));
            int height = this.f4753c - ((int) (this.f4751a.getHeight() * this.f4758h));
            if (width >= 0) {
                this.f4762l = width / 2;
                z = true;
            } else if (this.f4759i > 0.0f) {
                this.f4762l = 0.0f;
                z = true;
            } else if (this.f4759i < width) {
                this.f4762l = width;
                z = true;
            } else {
                z = false;
            }
            if (height >= 0) {
                this.f4763m = height / 2;
            } else if (this.f4760j > 0.0f) {
                this.f4763m = 0.0f;
            } else if (this.f4760j < height) {
                this.f4763m = height;
            } else {
                z2 = false;
            }
            if (z || z2) {
                if (!z2) {
                    this.f4763m = this.f4760j;
                }
                if (!z) {
                    this.f4762l = this.f4759i;
                }
                this.f4755e.postTranslate(this.f4762l - this.f4759i, this.f4763m - this.f4760j);
            }
        }
    }

    /* renamed from: d */
    public boolean m4859d(MotionEvent motionEvent) {
        if (!this.f4747G.onTouchEvent(motionEvent) && !this.f4770t) {
            float[] fArr = new float[9];
            switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
                case 0:
                    if (!this.f4770t) {
                        this.f4756f.set(this.f4755e);
                        this.f4757g.set(motionEvent.getX(), motionEvent.getY());
                        this.f4761k = 1;
                        break;
                    }
                    break;
                case 1:
                case 6:
                    this.f4761k = 0;
                    this.f4755e.getValues(fArr);
                    this.f4759i = fArr[2];
                    this.f4760j = fArr[5];
                    this.f4758h = fArr[0];
                    if (!this.f4770t) {
                        m4852b();
                        break;
                    }
                    break;
                case 2:
                    this.f4776z = false;
                    if (this.f4761k == 1 && !this.f4770t) {
                        this.f4755e.set(this.f4756f);
                        this.f4755e.postTranslate(motionEvent.getX() - this.f4757g.x, motionEvent.getY() - this.f4757g.y);
                        this.f4755e.getValues(fArr);
                        this.f4759i = fArr[2];
                        this.f4760j = fArr[5];
                        this.f4758h = fArr[0];
                        break;
                    } else if (this.f4761k == 2 && !this.f4770t) {
                        float fM4847a = m4847a(motionEvent);
                        if (fM4847a > 10.0f) {
                            this.f4755e.set(this.f4756f);
                            float f = fM4847a / this.f4772v;
                            this.f4755e.getValues(fArr);
                            this.f4758h = fArr[0];
                            if (this.f4758h * f <= this.f4741A) {
                                this.f4755e.postScale(this.f4741A / this.f4758h, this.f4741A / this.f4758h, this.f4773w.x, this.f4773w.y);
                            } else if (this.f4758h * f >= this.f4742B) {
                                this.f4755e.postScale(this.f4742B / this.f4758h, this.f4742B / this.f4758h, this.f4773w.x, this.f4773w.y);
                            } else {
                                this.f4755e.postScale(f, f, this.f4773w.x, this.f4773w.y);
                            }
                            this.f4776z = true;
                        }
                        if (!this.f4776z) {
                            this.f4755e.set(this.f4756f);
                        }
                        m4850a(this.f4774x, motionEvent);
                        this.f4755e.postTranslate(this.f4774x.x - this.f4775y.x, this.f4774x.y - this.f4775y.y);
                        this.f4755e.getValues(fArr);
                        this.f4759i = fArr[2];
                        this.f4760j = fArr[5];
                        this.f4758h = fArr[0];
                        m4854c();
                        break;
                    }
                    break;
                case 5:
                    this.f4772v = m4847a(motionEvent);
                    if (this.f4772v > 10.0f) {
                        this.f4756f.set(this.f4755e);
                        m4850a(this.f4773w, motionEvent);
                        this.f4761k = 2;
                    }
                    m4850a(this.f4775y, motionEvent);
                    break;
            }
            invalidate();
        }
        return true;
    }

    /* renamed from: a */
    private float m4847a(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return FloatMath.sqrt((x * x) + (y * y));
    }

    /* renamed from: a */
    private void m4850a(PointF pointF, MotionEvent motionEvent) {
        pointF.set((motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f, (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f);
    }

    /* renamed from: B */
    public float m4856B() {
        return this.f4758h;
    }

    /* renamed from: C */
    public void m4857C() {
        this.f4755e = new Matrix();
        this.f4756f = new Matrix();
        this.f4758h = 1.0f;
        this.f4759i = 0.0f;
        this.f4760j = 0.0f;
    }

    /* renamed from: D */
    public PointF m4858D() {
        return new PointF(this.f4759i, this.f4760j);
    }

    public void setBitmap(Bitmap bitmap) {
        int i;
        float f;
        int i2;
        if (bitmap != null) {
            this.f4751a = bitmap;
            this.f4752b = getWidth();
            this.f4753c = getHeight();
            int height = this.f4751a.getHeight();
            int width = this.f4751a.getWidth();
            this.f4755e.reset();
            if (this.f4748H == 0) {
                if (width > this.f4752b) {
                    f = this.f4752b / width;
                    i2 = (this.f4753c - ((int) (height * f))) / 2;
                    this.f4755e.setScale(f, f);
                    this.f4755e.postTranslate(0.0f, i2);
                } else {
                    f = this.f4753c / height;
                    int i3 = (this.f4752b - ((int) (width * f))) / 2;
                    this.f4755e.setScale(f, f);
                    this.f4755e.postTranslate(i3, 0.0f);
                    i = i3;
                    i2 = 0;
                }
                this.f4759i = i;
                this.f4760j = i2;
                this.f4758h = f;
                this.f4741A = f;
            } else {
                if (width > this.f4752b) {
                    i = height > this.f4753c ? 0 : (this.f4753c - height) / 2;
                    this.f4755e.postTranslate(0.0f, i);
                } else {
                    int i4 = (this.f4752b - width) / 2;
                    i = height <= this.f4753c ? (this.f4753c - height) / 2 : 0;
                    this.f4755e.postTranslate(i4, 0.0f);
                    int i5 = i;
                    i = i4;
                    i = i5;
                }
                this.f4759i = i;
                this.f4760j = i;
                this.f4758h = 1.0f;
                this.f4741A = 1.0f;
            }
            invalidate();
            return;
        }
        C1341p.m4651a("bitmap is null", getClass().getSimpleName());
    }
}
