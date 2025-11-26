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
import android.util.AttributeSet;
import android.util.FloatMath;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;

/* loaded from: classes.dex */
public class ZoomableImageView extends ImageView {

    /* renamed from: A */
    private Bitmap f10343A;

    /* renamed from: B */
    private int f10344B;

    /* renamed from: C */
    private int f10345C;

    /* renamed from: D */
    private Handler f10346D;

    /* renamed from: E */
    private GestureDetector f10347E;

    /* renamed from: F */
    private int f10348F;

    /* renamed from: G */
    private Runnable f10349G;

    /* renamed from: H */
    private Runnable f10350H;

    /* renamed from: a */
    Paint f10351a;

    /* renamed from: b */
    Matrix f10352b;

    /* renamed from: c */
    Matrix f10353c;

    /* renamed from: d */
    PointF f10354d;

    /* renamed from: e */
    float f10355e;

    /* renamed from: f */
    float f10356f;

    /* renamed from: g */
    float f10357g;

    /* renamed from: h */
    float f10358h;

    /* renamed from: i */
    int f10359i;

    /* renamed from: j */
    float f10360j;

    /* renamed from: k */
    float f10361k;

    /* renamed from: l */
    float f10362l;

    /* renamed from: m */
    float f10363m;

    /* renamed from: n */
    float f10364n;

    /* renamed from: o */
    float f10365o;

    /* renamed from: p */
    float f10366p;

    /* renamed from: q */
    float f10367q;

    /* renamed from: r */
    boolean f10368r;

    /* renamed from: s */
    float f10369s;

    /* renamed from: t */
    float f10370t;

    /* renamed from: u */
    PointF f10371u;

    /* renamed from: v */
    float f10372v;

    /* renamed from: w */
    float f10373w;

    /* renamed from: x */
    float f10374x;

    /* renamed from: y */
    float f10375y;

    /* renamed from: z */
    float f10376z;

    public void setDefaultScale(int i) {
        this.f10348F = i;
    }

    public ZoomableImageView(Context context) {
        super(context);
        this.f10343A = null;
        this.f10352b = new Matrix();
        this.f10353c = new Matrix();
        this.f10354d = new PointF();
        this.f10359i = 0;
        this.f10367q = 0.2f;
        this.f10368r = false;
        this.f10369s = 0.5f;
        this.f10370t = 1.0f;
        this.f10371u = new PointF();
        this.f10346D = new Handler();
        this.f10373w = 4.0f;
        this.f10374x = 25.0f;
        this.f10375y = 20.0f;
        this.f10349G = new RunnableC2839ax(this);
        this.f10350H = new RunnableC2840ay(this);
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.f10376z = context.getResources().getDisplayMetrics().density;
        m11915b();
        this.f10347E = new GestureDetector(new C2841az(this));
    }

    public ZoomableImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10343A = null;
        this.f10352b = new Matrix();
        this.f10353c = new Matrix();
        this.f10354d = new PointF();
        this.f10359i = 0;
        this.f10367q = 0.2f;
        this.f10368r = false;
        this.f10369s = 0.5f;
        this.f10370t = 1.0f;
        this.f10371u = new PointF();
        this.f10346D = new Handler();
        this.f10373w = 4.0f;
        this.f10374x = 25.0f;
        this.f10375y = 20.0f;
        this.f10349G = new RunnableC2839ax(this);
        this.f10350H = new RunnableC2840ay(this);
        this.f10376z = context.getResources().getDisplayMetrics().density;
        m11915b();
        this.f10347E = new GestureDetector(new C2841az(this));
        this.f10348F = 0;
    }

    /* renamed from: b */
    private void m11915b() {
        this.f10351a = new Paint();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int i5;
        float f;
        int i6;
        int i7 = 0;
        super.onSizeChanged(i, i2, i3, i4);
        this.f10344B = i;
        this.f10345C = i2;
        if (this.f10343A != null) {
            int height = this.f10343A.getHeight();
            int width = this.f10343A.getWidth();
            if (this.f10348F == 0) {
                if (width > this.f10344B) {
                    f = this.f10344B / width;
                    i6 = (this.f10345C - ((int) (height * f))) / 2;
                    this.f10352b.setScale(f, f);
                    this.f10352b.postTranslate(0.0f, i6);
                } else {
                    f = this.f10345C / height;
                    int i8 = (this.f10344B - ((int) (width * f))) / 2;
                    this.f10352b.setScale(f, f);
                    this.f10352b.postTranslate(i8, 0.0f);
                    i7 = i8;
                    i6 = 0;
                }
                this.f10356f = i7;
                this.f10357g = i6;
                this.f10355e = f;
                this.f10372v = f;
            } else {
                if (width > this.f10344B) {
                    int i9 = (this.f10345C - height) / 2;
                    this.f10352b.postTranslate(0.0f, i9);
                    i5 = 0;
                    i7 = i9;
                } else {
                    i5 = (this.f10344B - width) / 2;
                    this.f10352b.postTranslate(i5, 0.0f);
                }
                this.f10356f = i5;
                this.f10357g = i7;
                this.f10355e = 1.0f;
                this.f10372v = 1.0f;
            }
            invalidate();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f10343A != null && canvas != null) {
            canvas.drawBitmap(this.f10343A, this.f10352b, this.f10351a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m11917c() {
        boolean z;
        boolean z2 = false;
        if (this.f10343A != null) {
            float[] fArr = new float[9];
            this.f10352b.getValues(fArr);
            this.f10355e = fArr[0];
            if (this.f10355e < this.f10372v) {
                float f = this.f10372v / this.f10355e;
                this.f10352b.postScale(f, f, this.f10344B / 2, this.f10345C / 2);
                invalidate();
            }
            this.f10352b.getValues(fArr);
            this.f10355e = fArr[0];
            this.f10356f = fArr[2];
            this.f10357g = fArr[5];
            int width = this.f10344B - ((int) (this.f10343A.getWidth() * this.f10355e));
            int height = this.f10345C - ((int) (this.f10343A.getHeight() * this.f10355e));
            if (width >= 0) {
                this.f10360j = width / 2;
                z = true;
            } else if (this.f10356f > 0.0f) {
                this.f10360j = 0.0f;
                z = true;
            } else if (this.f10356f < width) {
                this.f10360j = width;
                z = true;
            } else {
                z = false;
            }
            if (height >= 0) {
                this.f10361k = height / 2;
                z2 = true;
            } else if (this.f10357g > 0.0f) {
                this.f10361k = 0.0f;
                z2 = true;
            } else if (this.f10357g < height) {
                this.f10361k = height;
                z2 = true;
            }
            if (z || z2) {
                if (!z2) {
                    this.f10361k = this.f10357g;
                }
                if (!z) {
                    this.f10360j = this.f10356f;
                }
                this.f10368r = true;
                this.f10346D.removeCallbacks(this.f10349G);
                this.f10346D.postDelayed(this.f10349G, 100L);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f10347E.onTouchEvent(motionEvent) && !this.f10368r) {
            float[] fArr = new float[9];
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.f10353c.set(this.f10352b);
                    this.f10354d.set(motionEvent.getX(), motionEvent.getY());
                    this.f10359i = 1;
                    break;
                case 1:
                case 6:
                    this.f10359i = 0;
                    this.f10352b.getValues(fArr);
                    this.f10356f = fArr[2];
                    this.f10357g = fArr[5];
                    this.f10355e = fArr[0];
                    m11917c();
                    break;
                case 2:
                    if (this.f10359i == 1 && !this.f10368r) {
                        this.f10352b.set(this.f10353c);
                        float x = motionEvent.getX() - this.f10354d.x;
                        float y = motionEvent.getY() - this.f10354d.y;
                        if (getDrawable() == null || !m11919a()) {
                            this.f10352b.postTranslate(x, y);
                            this.f10352b.getValues(fArr);
                            this.f10356f = fArr[2];
                            this.f10357g = fArr[5];
                            this.f10355e = fArr[0];
                            break;
                        }
                    } else if (this.f10359i == 2 && !this.f10368r) {
                        float fM11911a = m11911a(motionEvent);
                        if (fM11911a > 10.0f) {
                            this.f10352b.set(this.f10353c);
                            float f = fM11911a / this.f10370t;
                            this.f10352b.getValues(fArr);
                            this.f10355e = fArr[0];
                            if (this.f10355e * f <= this.f10372v) {
                                this.f10352b.postScale(this.f10372v / this.f10355e, this.f10372v / this.f10355e, this.f10371u.x, this.f10371u.y);
                            } else if (this.f10355e * f >= this.f10373w) {
                                this.f10352b.postScale(this.f10373w / this.f10355e, this.f10373w / this.f10355e, this.f10371u.x, this.f10371u.y);
                                this.f10370t = m11911a(motionEvent);
                                if (this.f10370t > 10.0f) {
                                    this.f10353c.set(this.f10352b);
                                    m11913a(this.f10371u, motionEvent);
                                    this.f10359i = 2;
                                }
                            } else {
                                this.f10352b.postScale(f, f, this.f10371u.x, this.f10371u.y);
                            }
                            this.f10358h = f;
                            this.f10352b.getValues(fArr);
                            this.f10356f = fArr[2];
                            this.f10357g = fArr[5];
                            this.f10355e = fArr[0];
                            break;
                        }
                    }
                    break;
                case 5:
                    this.f10370t = m11911a(motionEvent);
                    if (this.f10370t > 10.0f) {
                        this.f10353c.set(this.f10352b);
                        m11913a(this.f10371u, motionEvent);
                        this.f10359i = 2;
                        break;
                    }
                    break;
            }
            invalidate();
        }
        return true;
    }

    /* renamed from: a */
    public boolean m11919a() {
        float[] fArr = new float[9];
        this.f10352b.getValues(fArr);
        int intrinsicWidth = getDrawable().getIntrinsicWidth();
        int intrinsicHeight = getDrawable().getIntrinsicHeight();
        return ((int) (((float) intrinsicWidth) * fArr[0])) <= getWidth() || ((int) (fArr[4] * ((float) intrinsicHeight))) <= getHeight();
    }

    /* renamed from: a */
    private float m11911a(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return FloatMath.sqrt((x * x) + (y * y));
    }

    /* renamed from: a */
    private void m11913a(PointF pointF, MotionEvent motionEvent) {
        pointF.set((motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f, (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f);
    }

    public void setBitmap(Bitmap bitmap) {
        int i;
        float f;
        int i2;
        if (bitmap != null) {
            this.f10343A = bitmap;
            this.f10344B = getWidth();
            this.f10345C = getHeight();
            int height = this.f10343A.getHeight();
            int width = this.f10343A.getWidth();
            this.f10352b.reset();
            if (this.f10348F == 0) {
                if (width > this.f10344B) {
                    f = this.f10344B / width;
                    i2 = (this.f10345C - ((int) (height * f))) / 2;
                    this.f10352b.setScale(f, f);
                    this.f10352b.postTranslate(0.0f, i2);
                } else {
                    f = this.f10345C / height;
                    int i3 = (this.f10344B - ((int) (width * f))) / 2;
                    this.f10352b.setScale(f, f);
                    this.f10352b.postTranslate(i3, 0.0f);
                    i = i3;
                    i2 = 0;
                }
                this.f10356f = i;
                this.f10357g = i2;
                this.f10355e = f;
                this.f10372v = f;
            } else {
                if (width > this.f10344B) {
                    i = height > this.f10345C ? 0 : (this.f10345C - height) / 2;
                    this.f10352b.postTranslate(0.0f, i);
                } else {
                    int i4 = (this.f10344B - width) / 2;
                    i = height <= this.f10345C ? (this.f10345C - height) / 2 : 0;
                    this.f10352b.postTranslate(i4, 0.0f);
                    int i5 = i;
                    i = i4;
                    i = i5;
                }
                this.f10356f = i;
                this.f10357g = i;
                this.f10355e = 1.0f;
                this.f10372v = 1.0f;
            }
            invalidate();
            return;
        }
        this.f10343A = null;
        Log.d("ZoomableImageView", "bitmap is null");
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (bitmap != null) {
            setBitmap(bitmap);
        }
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
