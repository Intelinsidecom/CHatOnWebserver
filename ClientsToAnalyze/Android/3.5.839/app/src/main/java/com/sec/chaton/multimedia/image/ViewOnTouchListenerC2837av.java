package com.sec.chaton.multimedia.image;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.util.FloatMath;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.sec.chaton.util.C4812ad;
import com.sec.chaton.util.C4904y;

/* compiled from: ZoomListener.java */
/* renamed from: com.sec.chaton.multimedia.image.av */
/* loaded from: classes.dex */
public class ViewOnTouchListenerC2837av implements View.OnTouchListener {

    /* renamed from: a */
    private static final String f10417a = ViewOnTouchListenerC2837av.class.getSimpleName();

    /* renamed from: n */
    boolean f10430n;

    /* renamed from: p */
    private ImageView f10432p;

    /* renamed from: q */
    private InterfaceC2838aw f10433q;

    /* renamed from: b */
    int f10418b = 0;

    /* renamed from: c */
    Matrix f10419c = new Matrix();

    /* renamed from: d */
    Matrix f10420d = new Matrix();

    /* renamed from: e */
    PointF f10421e = new PointF();

    /* renamed from: f */
    PointF f10422f = new PointF();

    /* renamed from: g */
    float f10423g = 1.0f;

    /* renamed from: h */
    final float f10424h = 4.0f;

    /* renamed from: i */
    boolean f10425i = true;

    /* renamed from: j */
    int f10426j = 0;

    /* renamed from: k */
    int f10427k = 0;

    /* renamed from: l */
    int f10428l = 0;

    /* renamed from: m */
    int f10429m = 0;

    /* renamed from: o */
    private GestureDetector f10431o = new GestureDetector(new C2842b(this));

    /* renamed from: a */
    public void m11930a(ImageView imageView) {
        if (imageView != null && imageView.getDrawable() != null) {
            this.f10426j = imageView.getDrawable().getIntrinsicWidth();
            this.f10427k = imageView.getDrawable().getIntrinsicHeight();
            this.f10428l = imageView.getWidth();
            this.f10429m = imageView.getHeight();
            imageView.setScaleType(ImageView.ScaleType.MATRIX);
            C4812ad.m18153a(imageView);
            this.f10419c.set(imageView.getImageMatrix());
            this.f10420d.set(this.f10419c);
        }
    }

    public ViewOnTouchListenerC2837av() {
    }

    public ViewOnTouchListenerC2837av(InterfaceC2838aw interfaceC2838aw) {
        this.f10433q = interfaceC2838aw;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        ImageView imageView = (ImageView) view;
        this.f10432p = imageView;
        if (this.f10425i) {
            m11930a(imageView);
            this.f10425i = false;
        }
        switch (motionEvent.getAction() & 255) {
            case 0:
                if (C4904y.f17872b) {
                    C4904y.m18639b("ACTION_DOWN", getClass().getSimpleName());
                }
                this.f10420d.set(this.f10419c);
                this.f10421e.set(motionEvent.getX(), motionEvent.getY());
                C4904y.m18639b("Mode = DRAG", f10417a);
                this.f10418b = 1;
                break;
            case 1:
            case 6:
                if (C4904y.f17872b) {
                    C4904y.m18639b("ACTION_POINTER_UP/ACTION_UP", getClass().getSimpleName());
                }
                if (this.f10418b == 2 && motionEvent.getPointerCount() > 1) {
                    this.f10430n = true;
                    if (C4904y.f17872b) {
                        C4904y.m18639b("POINTS: " + motionEvent.getPointerCount(), getClass().getSimpleName());
                        break;
                    }
                } else {
                    if (C4904y.f17872b) {
                        C4904y.m18639b("POINTS: " + motionEvent.getPointerCount(), getClass().getSimpleName());
                    }
                    this.f10418b = 0;
                    this.f10430n = false;
                    m11928b(imageView);
                    break;
                }
                break;
            case 2:
                if (C4904y.f17872b) {
                    C4904y.m18639b("ACTION_MOVE", getClass().getSimpleName());
                }
                if (this.f10418b == 1) {
                    this.f10419c.set(this.f10420d);
                    if (!m11931a()) {
                        this.f10419c.postTranslate(motionEvent.getX() - this.f10421e.x, motionEvent.getY() - this.f10421e.y);
                        break;
                    }
                } else if (this.f10418b == 2 && !this.f10430n) {
                    float fM11926a = m11926a(motionEvent);
                    if (fM11926a > 10.0f) {
                        this.f10419c.set(this.f10420d);
                        float f = fM11926a / this.f10423g;
                        this.f10419c.postScale(f, f, this.f10422f.x, this.f10422f.y);
                        break;
                    }
                }
                break;
            case 5:
                if (C4904y.f17872b) {
                    C4904y.m18639b("ACTION_POINTER_DOWN", getClass().getSimpleName());
                }
                this.f10423g = m11926a(motionEvent);
                if (this.f10423g > 10.0f) {
                    this.f10420d.set(this.f10419c);
                    m11927a(this.f10422f, motionEvent);
                    this.f10418b = 2;
                    break;
                }
                break;
        }
        imageView.setImageMatrix(this.f10419c);
        this.f10431o.onTouchEvent(motionEvent);
        return true;
    }

    /* renamed from: a */
    private float m11926a(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() <= 1) {
            return 0.0f;
        }
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return FloatMath.sqrt((x * x) + (y * y));
    }

    /* renamed from: a */
    private void m11927a(PointF pointF, MotionEvent motionEvent) {
        pointF.set((motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f, (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f);
    }

    /* renamed from: a */
    public boolean m11931a() {
        float[] fArr = new float[9];
        this.f10419c.getValues(fArr);
        return ((int) (((float) this.f10426j) * fArr[0])) <= this.f10428l && ((int) (fArr[4] * ((float) this.f10427k))) <= this.f10429m;
    }

    /* renamed from: b */
    public boolean m11932b() {
        return m11931a() && this.f10418b != 2;
    }

    /* renamed from: a */
    public void m11929a(float f, float f2) {
        if (m11931a()) {
            float[] fArr = new float[9];
            this.f10419c.getValues(fArr);
            if (fArr[0] <= 4.0f && fArr[4] <= 4.0f) {
                this.f10419c.postScale(2.0f, 2.0f, f, f2);
                m11928b(this.f10432p);
            } else {
                return;
            }
        } else {
            m11930a(this.f10432p);
        }
        this.f10432p.setImageMatrix(this.f10419c);
    }

    /* renamed from: b */
    private void m11928b(ImageView imageView) {
        float[] fArr = new float[9];
        this.f10419c.getValues(fArr);
        this.f10420d.getValues(new float[9]);
        int i = (int) (this.f10426j * fArr[0]);
        int i2 = (int) (this.f10427k * fArr[4]);
        if (fArr[0] > 4.0f || fArr[4] > 4.0f) {
            this.f10419c.postScale(4.0f / fArr[0], 4.0f / fArr[4], this.f10422f.x, this.f10422f.y);
            this.f10419c.getValues(fArr);
            i = (int) (this.f10426j * fArr[0]);
            i2 = (int) (this.f10427k * fArr[4]);
        }
        if (i <= this.f10428l && i2 <= this.f10429m) {
            C4812ad.m18153a(imageView);
            this.f10419c.set(imageView.getImageMatrix());
            this.f10420d.set(this.f10419c);
            return;
        }
        if (i > this.f10428l || i2 > this.f10429m) {
            if (fArr[2] > 0.0f) {
                if (i < this.f10428l) {
                    fArr[2] = (this.f10428l - i) * 0.5f;
                } else {
                    fArr[2] = 0.0f;
                }
            } else if (i < this.f10428l) {
                fArr[2] = (this.f10428l - i) * 0.5f;
            } else if (Math.abs(fArr[2]) > Math.abs(this.f10428l - i)) {
                fArr[2] = this.f10428l - i;
            }
            if (fArr[5] > 0.0f) {
                if (i2 < this.f10429m) {
                    fArr[5] = (this.f10429m - i2) * 0.5f;
                } else {
                    fArr[5] = 0.0f;
                }
            } else if (i2 < this.f10429m) {
                fArr[5] = (this.f10429m - i2) * 0.5f;
            } else if (Math.abs(fArr[5]) > Math.abs(this.f10429m - i2)) {
                fArr[5] = this.f10429m - i2;
            }
        }
        this.f10419c.setValues(fArr);
        this.f10420d.set(this.f10419c);
    }

    /* renamed from: c */
    public void m11933c() {
        if (this.f10433q != null) {
            this.f10433q.mo11845e();
        }
    }
}
