package com.sec.vip.amschaton;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.FloatMath;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.util.ChatONLogWriter;

/* loaded from: classes.dex */
public class ZoomableImageView extends View {

    /* renamed from: A */
    float f4195A;

    /* renamed from: B */
    float f4196B;

    /* renamed from: C */
    float f4197C;

    /* renamed from: D */
    float f4198D;

    /* renamed from: E */
    float f4199E;

    /* renamed from: F */
    private Handler f4200F;

    /* renamed from: G */
    private GestureDetector f4201G;

    /* renamed from: H */
    private int f4202H;

    /* renamed from: I */
    private Handler f4203I;

    /* renamed from: J */
    private View[] f4204J;

    /* renamed from: K */
    private boolean f4205K;

    /* renamed from: L */
    private Runnable f4206L;

    /* renamed from: M */
    private Runnable f4207M;

    /* renamed from: N */
    private Runnable f4208N;

    /* renamed from: a */
    private Bitmap f4209a;

    /* renamed from: b */
    private int f4210b;

    /* renamed from: c */
    private int f4211c;

    /* renamed from: d */
    Paint f4212d;

    /* renamed from: e */
    Matrix f4213e;

    /* renamed from: f */
    Matrix f4214f;

    /* renamed from: g */
    PointF f4215g;

    /* renamed from: h */
    float f4216h;

    /* renamed from: i */
    float f4217i;

    /* renamed from: j */
    float f4218j;

    /* renamed from: k */
    int f4219k;

    /* renamed from: l */
    float f4220l;

    /* renamed from: m */
    float f4221m;

    /* renamed from: n */
    float f4222n;

    /* renamed from: o */
    float f4223o;

    /* renamed from: p */
    float f4224p;

    /* renamed from: q */
    float f4225q;

    /* renamed from: r */
    float f4226r;

    /* renamed from: s */
    float f4227s;

    /* renamed from: t */
    boolean f4228t;

    /* renamed from: u */
    float f4229u;

    /* renamed from: v */
    float f4230v;

    /* renamed from: w */
    PointF f4231w;

    /* renamed from: x */
    PointF f4232x;

    /* renamed from: y */
    PointF f4233y;

    /* renamed from: z */
    boolean f4234z;

    public ZoomableImageView(Context context) {
        super(context);
        this.f4209a = null;
        this.f4213e = new Matrix();
        this.f4214f = new Matrix();
        this.f4215g = new PointF();
        this.f4216h = 1.0f;
        this.f4217i = 0.0f;
        this.f4218j = 0.0f;
        this.f4219k = 0;
        this.f4227s = 0.2f;
        this.f4228t = false;
        this.f4229u = 0.5f;
        this.f4230v = 1.0f;
        this.f4231w = new PointF();
        this.f4232x = new PointF();
        this.f4233y = new PointF();
        this.f4234z = false;
        this.f4200F = new Handler();
        this.f4196B = 3.0f;
        this.f4197C = 25.0f;
        this.f4198D = 20.0f;
        this.f4203I = new Handler();
        this.f4204J = new View[4];
        this.f4205K = false;
        this.f4206L = new RunnableC0708k(this);
        this.f4207M = new RunnableC0710m(this);
        this.f4208N = new RunnableC0711n(this);
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.f4199E = context.getResources().getDisplayMetrics().density;
        m4205a();
        this.f4201G = new GestureDetector(new C0712o(this));
    }

    public ZoomableImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4209a = null;
        this.f4213e = new Matrix();
        this.f4214f = new Matrix();
        this.f4215g = new PointF();
        this.f4216h = 1.0f;
        this.f4217i = 0.0f;
        this.f4218j = 0.0f;
        this.f4219k = 0;
        this.f4227s = 0.2f;
        this.f4228t = false;
        this.f4229u = 0.5f;
        this.f4230v = 1.0f;
        this.f4231w = new PointF();
        this.f4232x = new PointF();
        this.f4233y = new PointF();
        this.f4234z = false;
        this.f4200F = new Handler();
        this.f4196B = 3.0f;
        this.f4197C = 25.0f;
        this.f4198D = 20.0f;
        this.f4203I = new Handler();
        this.f4204J = new View[4];
        this.f4205K = false;
        this.f4206L = new RunnableC0708k(this);
        this.f4207M = new RunnableC0710m(this);
        this.f4208N = new RunnableC0711n(this);
        this.f4199E = context.getResources().getDisplayMetrics().density;
        m4205a();
        this.f4201G = new GestureDetector(new C0712o(this));
        this.f4202H = 0;
    }

    /* renamed from: a */
    private void m4205a() {
        this.f4212d = new Paint();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m4206a(int i) {
        float f;
        float f2;
        if (this.f4228t || this.f4216h <= 1.0f) {
            return;
        }
        float[] fArr = new float[9];
        this.f4214f.set(this.f4213e);
        this.f4213e.set(this.f4214f);
        switch (i) {
            case 0:
                f = 0.0f;
                f2 = 10.0f;
                break;
            case 1:
                f = 10.0f;
                f2 = 0.0f;
                break;
            case 2:
                f = 0.0f;
                f2 = -10.0f;
                break;
            case 3:
                f = -10.0f;
                f2 = 0.0f;
                break;
            default:
                f = 0.0f;
                f2 = 0.0f;
                break;
        }
        this.f4213e.postTranslate(f2, f);
        this.f4213e.getValues(fArr);
        this.f4217i = fArr[2];
        this.f4218j = fArr[5];
        this.f4216h = fArr[0];
        if (!this.f4228t) {
            m4213b();
        }
        invalidate();
    }

    /* renamed from: a */
    private void m4207a(PointF pointF, MotionEvent motionEvent) {
        pointF.set((motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f, (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m4210a(boolean z) {
        if (this.f4205K) {
            if (z) {
                for (int i = 0; i < 4; i++) {
                    this.f4204J[i].setVisibility(0);
                }
                return;
            }
            for (int i2 = 0; i2 < 4; i2++) {
                this.f4204J[i2].setVisibility(8);
            }
        }
    }

    /* renamed from: b */
    private float m4211b(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return FloatMath.sqrt((x * x) + (y * y));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m4213b() {
        boolean z;
        boolean z2;
        if (this.f4209a == null) {
            return;
        }
        float[] fArr = new float[9];
        this.f4213e.getValues(fArr);
        this.f4216h = fArr[0];
        if (this.f4216h < this.f4195A) {
            float f = this.f4195A / this.f4216h;
            this.f4213e.postScale(f, f, this.f4210b / 2, this.f4211c / 2);
            invalidate();
        }
        this.f4213e.getValues(fArr);
        this.f4216h = fArr[0];
        this.f4217i = fArr[2];
        this.f4218j = fArr[5];
        int width = this.f4210b - ((int) (this.f4209a.getWidth() * this.f4216h));
        int height = this.f4211c - ((int) (this.f4209a.getHeight() * this.f4216h));
        if (width >= 0) {
            this.f4220l = width / 2;
            z = true;
        } else if (this.f4217i > 0.0f) {
            this.f4220l = 0.0f;
            z = true;
        } else if (this.f4217i < width) {
            this.f4220l = width;
            z = true;
        } else {
            z = false;
        }
        if (height >= 0) {
            this.f4221m = height / 2;
            z2 = true;
        } else if (this.f4218j > 0.0f) {
            this.f4221m = 0.0f;
            z2 = true;
        } else if (this.f4218j < height) {
            this.f4221m = height;
            z2 = true;
        } else {
            z2 = false;
        }
        if (z || z2) {
            if (!z2) {
                this.f4221m = this.f4218j;
            }
            if (!z) {
                this.f4220l = this.f4217i;
            }
            this.f4228t = true;
            this.f4200F.removeCallbacks(this.f4207M);
            this.f4200F.postDelayed(this.f4207M, 100L);
        }
    }

    /* renamed from: D */
    public float m4218D() {
        return this.f4216h;
    }

    /* renamed from: E */
    public void m4219E() {
        this.f4213e = new Matrix();
        this.f4214f = new Matrix();
        this.f4216h = 1.0f;
        this.f4217i = 0.0f;
        this.f4218j = 0.0f;
    }

    /* renamed from: F */
    public PointF m4220F() {
        return new PointF(this.f4217i, this.f4218j);
    }

    /* renamed from: a */
    public boolean m4221a(MotionEvent motionEvent) {
        if (!this.f4201G.onTouchEvent(motionEvent) && !this.f4228t) {
            float[] fArr = new float[9];
            switch (motionEvent.getAction() & 255) {
                case 0:
                    if (!this.f4228t) {
                        this.f4214f.set(this.f4213e);
                        this.f4215g.set(motionEvent.getX(), motionEvent.getY());
                        this.f4219k = 1;
                        break;
                    }
                    break;
                case 1:
                case 6:
                    this.f4219k = 0;
                    this.f4213e.getValues(fArr);
                    this.f4217i = fArr[2];
                    this.f4218j = fArr[5];
                    this.f4216h = fArr[0];
                    if (!this.f4228t) {
                        m4213b();
                    }
                    this.f4203I.postDelayed(this.f4206L, 2000L);
                    break;
                case 2:
                    this.f4234z = false;
                    if (this.f4219k == 1 && !this.f4228t) {
                        this.f4213e.set(this.f4214f);
                        this.f4213e.postTranslate(motionEvent.getX() - this.f4215g.x, motionEvent.getY() - this.f4215g.y);
                        this.f4213e.getValues(fArr);
                        this.f4217i = fArr[2];
                        this.f4218j = fArr[5];
                        this.f4216h = fArr[0];
                        break;
                    } else if (this.f4219k == 2 && !this.f4228t) {
                        float fM4211b = m4211b(motionEvent);
                        if (fM4211b > 10.0f) {
                            this.f4213e.set(this.f4214f);
                            float f = fM4211b / this.f4230v;
                            this.f4213e.getValues(fArr);
                            this.f4216h = fArr[0];
                            if (this.f4216h * f <= this.f4195A) {
                                this.f4213e.postScale(this.f4195A / this.f4216h, this.f4195A / this.f4216h, this.f4231w.x, this.f4231w.y);
                            } else if (this.f4216h * f >= this.f4196B) {
                                this.f4213e.postScale(this.f4196B / this.f4216h, this.f4196B / this.f4216h, this.f4231w.x, this.f4231w.y);
                            } else {
                                this.f4213e.postScale(f, f, this.f4231w.x, this.f4231w.y);
                            }
                            this.f4234z = true;
                        }
                        if (!this.f4234z) {
                            this.f4213e.set(this.f4214f);
                        }
                        m4207a(this.f4232x, motionEvent);
                        this.f4213e.postTranslate(this.f4232x.x - this.f4233y.x, this.f4232x.y - this.f4233y.y);
                        this.f4213e.getValues(fArr);
                        this.f4217i = fArr[2];
                        this.f4218j = fArr[5];
                        this.f4216h = fArr[0];
                        break;
                    }
                    break;
                case 5:
                    this.f4230v = m4211b(motionEvent);
                    if (this.f4230v > 10.0f) {
                        this.f4214f.set(this.f4213e);
                        m4207a(this.f4231w, motionEvent);
                        this.f4219k = 2;
                    }
                    m4207a(this.f4233y, motionEvent);
                    this.f4203I.removeCallbacks(this.f4206L);
                    m4210a(true);
                    break;
            }
            invalidate();
            return true;
        }
        return true;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f4209a == null || canvas == null) {
            return;
        }
        canvas.drawBitmap(this.f4209a, this.f4213e, this.f4212d);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        float f;
        int i8;
        super.onSizeChanged(i, i2, i3, i4);
        this.f4210b = i;
        this.f4211c = i2;
        if (this.f4209a != null) {
            int height = this.f4209a.getHeight();
            int width = this.f4209a.getWidth();
            if (this.f4202H == 0) {
                if (width > this.f4210b) {
                    float f2 = this.f4210b / width;
                    i8 = (this.f4211c - ((int) (height * f2))) / 2;
                    this.f4213e.setScale(f2, f2);
                    this.f4213e.postTranslate(0.0f, i8);
                    f = f2;
                    i7 = 0;
                } else {
                    float f3 = this.f4211c / height;
                    i7 = (this.f4210b - ((int) (width * f3))) / 2;
                    this.f4213e.setScale(f3, f3);
                    this.f4213e.postTranslate(i7, 0.0f);
                    f = f3;
                    i8 = 0;
                }
                this.f4217i = i7;
                this.f4218j = i8;
                this.f4216h = f;
                this.f4195A = f;
            } else {
                if (width > this.f4210b) {
                    i6 = (this.f4211c - height) / 2;
                    this.f4213e.postTranslate(0.0f, i6);
                    i5 = 0;
                } else {
                    int i9 = (this.f4210b - width) / 2;
                    this.f4213e.postTranslate(i9, 0.0f);
                    i5 = i9;
                    i6 = 0;
                }
                this.f4217i = i5;
                this.f4218j = i6;
                this.f4216h = 1.0f;
                this.f4195A = 1.0f;
            }
            invalidate();
        }
    }

    public void setBitmap(Bitmap bitmap) {
        int i;
        int i2;
        int i3;
        float f;
        int i4;
        if (bitmap == null) {
            ChatONLogWriter.m3499a("bitmap is null", getClass().getSimpleName());
            return;
        }
        this.f4209a = bitmap;
        this.f4210b = getWidth();
        this.f4211c = getHeight();
        int height = this.f4209a.getHeight();
        int width = this.f4209a.getWidth();
        this.f4213e.reset();
        if (this.f4202H == 0) {
            if (width > this.f4210b) {
                float f2 = this.f4210b / width;
                i4 = (this.f4211c - ((int) (height * f2))) / 2;
                this.f4213e.setScale(f2, f2);
                this.f4213e.postTranslate(0.0f, i4);
                f = f2;
                i3 = 0;
            } else {
                float f3 = this.f4211c / height;
                i3 = (this.f4210b - ((int) (width * f3))) / 2;
                this.f4213e.setScale(f3, f3);
                this.f4213e.postTranslate(i3, 0.0f);
                f = f3;
                i4 = 0;
            }
            this.f4217i = i3;
            this.f4218j = i4;
            this.f4216h = f;
            this.f4195A = f;
        } else {
            if (width > this.f4210b) {
                i2 = height > this.f4211c ? 0 : (this.f4211c - height) / 2;
                this.f4213e.postTranslate(0.0f, i2);
                i = 0;
            } else {
                i = (this.f4210b - width) / 2;
                i2 = height > this.f4211c ? 0 : (this.f4211c - height) / 2;
                this.f4213e.postTranslate(i, 0.0f);
            }
            this.f4217i = i;
            this.f4218j = i2;
            this.f4216h = 1.0f;
            this.f4195A = 1.0f;
        }
        invalidate();
    }

    public void setDefaultScale(int i) {
        this.f4202H = i;
    }

    public void setMoveDirectionButtonView(View view, int i) {
        this.f4204J[i] = view;
        this.f4204J[i].setOnClickListener(new ViewOnClickListenerC0709l(this, i));
        this.f4204J[i].setVisibility(8);
        this.f4205K = true;
    }
}
