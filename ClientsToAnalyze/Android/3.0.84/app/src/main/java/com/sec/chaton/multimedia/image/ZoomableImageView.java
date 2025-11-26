package com.sec.chaton.multimedia.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.util.FloatMath;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;

/* loaded from: classes.dex */
public class ZoomableImageView extends ImageView {

    /* renamed from: A */
    private Bitmap f7037A;

    /* renamed from: B */
    private int f7038B;

    /* renamed from: C */
    private int f7039C;

    /* renamed from: D */
    private Handler f7040D;

    /* renamed from: E */
    private GestureDetector f7041E;

    /* renamed from: F */
    private int f7042F;

    /* renamed from: G */
    private Runnable f7043G;

    /* renamed from: H */
    private Runnable f7044H;

    /* renamed from: a */
    Paint f7045a;

    /* renamed from: b */
    Matrix f7046b;

    /* renamed from: c */
    Matrix f7047c;

    /* renamed from: d */
    PointF f7048d;

    /* renamed from: e */
    float f7049e;

    /* renamed from: f */
    float f7050f;

    /* renamed from: g */
    float f7051g;

    /* renamed from: h */
    float f7052h;

    /* renamed from: i */
    int f7053i;

    /* renamed from: j */
    float f7054j;

    /* renamed from: k */
    float f7055k;

    /* renamed from: l */
    float f7056l;

    /* renamed from: m */
    float f7057m;

    /* renamed from: n */
    float f7058n;

    /* renamed from: o */
    float f7059o;

    /* renamed from: p */
    float f7060p;

    /* renamed from: q */
    float f7061q;

    /* renamed from: r */
    boolean f7062r;

    /* renamed from: s */
    float f7063s;

    /* renamed from: t */
    float f7064t;

    /* renamed from: u */
    PointF f7065u;

    /* renamed from: v */
    float f7066v;

    /* renamed from: w */
    float f7067w;

    /* renamed from: x */
    float f7068x;

    /* renamed from: y */
    float f7069y;

    /* renamed from: z */
    float f7070z;

    public void setDefaultScale(int i) {
        this.f7042F = i;
    }

    public ZoomableImageView(Context context) {
        super(context);
        this.f7037A = null;
        this.f7046b = new Matrix();
        this.f7047c = new Matrix();
        this.f7048d = new PointF();
        this.f7053i = 0;
        this.f7061q = 0.2f;
        this.f7062r = false;
        this.f7063s = 0.5f;
        this.f7064t = 1.0f;
        this.f7065u = new PointF();
        this.f7040D = new Handler();
        this.f7067w = 4.0f;
        this.f7068x = 25.0f;
        this.f7069y = 20.0f;
        this.f7043G = new RunnableC1870au(this);
        this.f7044H = new RunnableC1871av(this);
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.f7070z = context.getResources().getDisplayMetrics().density;
        m7692b();
        this.f7041E = new GestureDetector(new C1872aw(this));
    }

    public ZoomableImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7037A = null;
        this.f7046b = new Matrix();
        this.f7047c = new Matrix();
        this.f7048d = new PointF();
        this.f7053i = 0;
        this.f7061q = 0.2f;
        this.f7062r = false;
        this.f7063s = 0.5f;
        this.f7064t = 1.0f;
        this.f7065u = new PointF();
        this.f7040D = new Handler();
        this.f7067w = 4.0f;
        this.f7068x = 25.0f;
        this.f7069y = 20.0f;
        this.f7043G = new RunnableC1870au(this);
        this.f7044H = new RunnableC1871av(this);
        this.f7070z = context.getResources().getDisplayMetrics().density;
        m7692b();
        this.f7041E = new GestureDetector(new C1872aw(this));
        this.f7042F = 0;
    }

    /* renamed from: b */
    private void m7692b() {
        this.f7045a = new Paint();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int i5;
        float f;
        int i6;
        int i7 = 0;
        super.onSizeChanged(i, i2, i3, i4);
        this.f7038B = i;
        this.f7039C = i2;
        if (this.f7037A != null) {
            int height = this.f7037A.getHeight();
            int width = this.f7037A.getWidth();
            if (this.f7042F == 0) {
                if (width > this.f7038B) {
                    f = this.f7038B / width;
                    i6 = (this.f7039C - ((int) (height * f))) / 2;
                    this.f7046b.setScale(f, f);
                    this.f7046b.postTranslate(0.0f, i6);
                } else {
                    f = this.f7039C / height;
                    int i8 = (this.f7038B - ((int) (width * f))) / 2;
                    this.f7046b.setScale(f, f);
                    this.f7046b.postTranslate(i8, 0.0f);
                    i7 = i8;
                    i6 = 0;
                }
                this.f7050f = i7;
                this.f7051g = i6;
                this.f7049e = f;
                this.f7066v = f;
            } else {
                if (width > this.f7038B) {
                    int i9 = (this.f7039C - height) / 2;
                    this.f7046b.postTranslate(0.0f, i9);
                    i5 = 0;
                    i7 = i9;
                } else {
                    i5 = (this.f7038B - width) / 2;
                    this.f7046b.postTranslate(i5, 0.0f);
                }
                this.f7050f = i5;
                this.f7051g = i7;
                this.f7049e = 1.0f;
                this.f7066v = 1.0f;
            }
            invalidate();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f7037A != null && canvas != null) {
            canvas.drawBitmap(this.f7037A, this.f7046b, this.f7045a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m7694c() {
        boolean z;
        boolean z2 = false;
        if (this.f7037A != null) {
            float[] fArr = new float[9];
            this.f7046b.getValues(fArr);
            this.f7049e = fArr[0];
            if (this.f7049e < this.f7066v) {
                float f = this.f7066v / this.f7049e;
                this.f7046b.postScale(f, f, this.f7038B / 2, this.f7039C / 2);
                invalidate();
            }
            this.f7046b.getValues(fArr);
            this.f7049e = fArr[0];
            this.f7050f = fArr[2];
            this.f7051g = fArr[5];
            int width = this.f7038B - ((int) (this.f7037A.getWidth() * this.f7049e));
            int height = this.f7039C - ((int) (this.f7037A.getHeight() * this.f7049e));
            if (width >= 0) {
                this.f7054j = width / 2;
                z = true;
            } else if (this.f7050f > 0.0f) {
                this.f7054j = 0.0f;
                z = true;
            } else if (this.f7050f < width) {
                this.f7054j = width;
                z = true;
            } else {
                z = false;
            }
            if (height >= 0) {
                this.f7055k = height / 2;
                z2 = true;
            } else if (this.f7051g > 0.0f) {
                this.f7055k = 0.0f;
                z2 = true;
            } else if (this.f7051g < height) {
                this.f7055k = height;
                z2 = true;
            }
            if (z || z2) {
                if (!z2) {
                    this.f7055k = this.f7051g;
                }
                if (!z) {
                    this.f7054j = this.f7050f;
                }
                this.f7062r = true;
                this.f7040D.removeCallbacks(this.f7043G);
                this.f7040D.postDelayed(this.f7043G, 100L);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f7041E.onTouchEvent(motionEvent) && !this.f7062r) {
            float[] fArr = new float[9];
            switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
                case 0:
                    this.f7047c.set(this.f7046b);
                    this.f7048d.set(motionEvent.getX(), motionEvent.getY());
                    this.f7053i = 1;
                    break;
                case 1:
                case 6:
                    this.f7053i = 0;
                    this.f7046b.getValues(fArr);
                    this.f7050f = fArr[2];
                    this.f7051g = fArr[5];
                    this.f7049e = fArr[0];
                    m7694c();
                    break;
                case 2:
                    if (this.f7053i == 1 && !this.f7062r) {
                        this.f7046b.set(this.f7047c);
                        float x = motionEvent.getX() - this.f7048d.x;
                        float y = motionEvent.getY() - this.f7048d.y;
                        if (getDrawable() == null || !m7696a()) {
                            this.f7046b.postTranslate(x, y);
                            this.f7046b.getValues(fArr);
                            this.f7050f = fArr[2];
                            this.f7051g = fArr[5];
                            this.f7049e = fArr[0];
                            break;
                        }
                    } else if (this.f7053i == 2 && !this.f7062r) {
                        float fM7688a = m7688a(motionEvent);
                        if (fM7688a > 10.0f) {
                            this.f7046b.set(this.f7047c);
                            float f = fM7688a / this.f7064t;
                            this.f7046b.getValues(fArr);
                            this.f7049e = fArr[0];
                            if (this.f7049e * f <= this.f7066v) {
                                this.f7046b.postScale(this.f7066v / this.f7049e, this.f7066v / this.f7049e, this.f7065u.x, this.f7065u.y);
                            } else if (this.f7049e * f >= this.f7067w) {
                                this.f7046b.postScale(this.f7067w / this.f7049e, this.f7067w / this.f7049e, this.f7065u.x, this.f7065u.y);
                                this.f7064t = m7688a(motionEvent);
                                if (this.f7064t > 10.0f) {
                                    this.f7047c.set(this.f7046b);
                                    m7690a(this.f7065u, motionEvent);
                                    this.f7053i = 2;
                                }
                            } else {
                                this.f7046b.postScale(f, f, this.f7065u.x, this.f7065u.y);
                            }
                            this.f7052h = f;
                            this.f7046b.getValues(fArr);
                            this.f7050f = fArr[2];
                            this.f7051g = fArr[5];
                            this.f7049e = fArr[0];
                            break;
                        }
                    }
                    break;
                case 5:
                    this.f7064t = m7688a(motionEvent);
                    if (this.f7064t > 10.0f) {
                        this.f7047c.set(this.f7046b);
                        m7690a(this.f7065u, motionEvent);
                        this.f7053i = 2;
                        break;
                    }
                    break;
            }
            invalidate();
        }
        return true;
    }

    /* renamed from: a */
    public boolean m7696a() {
        float[] fArr = new float[9];
        this.f7046b.getValues(fArr);
        int intrinsicWidth = getDrawable().getIntrinsicWidth();
        int intrinsicHeight = getDrawable().getIntrinsicHeight();
        return ((int) (((float) intrinsicWidth) * fArr[0])) <= getWidth() || ((int) (fArr[4] * ((float) intrinsicHeight))) <= getHeight();
    }

    /* renamed from: a */
    private float m7688a(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return FloatMath.sqrt((x * x) + (y * y));
    }

    /* renamed from: a */
    private void m7690a(PointF pointF, MotionEvent motionEvent) {
        pointF.set((motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f, (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f);
    }

    public void setBitmap(Bitmap bitmap) {
        int i;
        float f;
        int i2;
        if (bitmap != null) {
            this.f7037A = bitmap;
            this.f7038B = getWidth();
            this.f7039C = getHeight();
            int height = this.f7037A.getHeight();
            int width = this.f7037A.getWidth();
            this.f7046b.reset();
            if (this.f7042F == 0) {
                if (width > this.f7038B) {
                    f = this.f7038B / width;
                    i2 = (this.f7039C - ((int) (height * f))) / 2;
                    this.f7046b.setScale(f, f);
                    this.f7046b.postTranslate(0.0f, i2);
                } else {
                    f = this.f7039C / height;
                    int i3 = (this.f7038B - ((int) (width * f))) / 2;
                    this.f7046b.setScale(f, f);
                    this.f7046b.postTranslate(i3, 0.0f);
                    i = i3;
                    i2 = 0;
                }
                this.f7050f = i;
                this.f7051g = i2;
                this.f7049e = f;
                this.f7066v = f;
            } else {
                if (width > this.f7038B) {
                    i = height > this.f7039C ? 0 : (this.f7039C - height) / 2;
                    this.f7046b.postTranslate(0.0f, i);
                } else {
                    int i4 = (this.f7038B - width) / 2;
                    i = height <= this.f7039C ? (this.f7039C - height) / 2 : 0;
                    this.f7046b.postTranslate(i4, 0.0f);
                    int i5 = i;
                    i = i4;
                    i = i5;
                }
                this.f7050f = i;
                this.f7051g = i;
                this.f7049e = 1.0f;
                this.f7066v = 1.0f;
            }
            invalidate();
            return;
        }
        this.f7037A = null;
        Log.d("ZoomableImageView", "bitmap is null");
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        setBitmap(bitmap);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        setBackgroundResource(i);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (drawable != null) {
            if (drawable instanceof BitmapDrawable) {
                setBitmap(((BitmapDrawable) drawable).getBitmap());
                return;
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            setBitmap(bitmapCreateBitmap);
        }
    }
}
