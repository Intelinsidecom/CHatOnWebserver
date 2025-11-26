package com.sec.chaton.multimedia.image;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.support.v4.view.MotionEventCompat;
import android.util.FloatMath;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.sec.chaton.util.C3162ad;
import com.sec.chaton.util.C3250y;

/* compiled from: ZoomListener.java */
/* renamed from: com.sec.chaton.multimedia.image.as */
/* loaded from: classes.dex */
public class ViewOnTouchListenerC1868as implements View.OnTouchListener {

    /* renamed from: a */
    private static final String f7106a = ViewOnTouchListenerC1868as.class.getSimpleName();

    /* renamed from: n */
    boolean f7119n;

    /* renamed from: p */
    private ImageView f7121p;

    /* renamed from: q */
    private InterfaceC1869at f7122q;

    /* renamed from: b */
    int f7107b = 0;

    /* renamed from: c */
    Matrix f7108c = new Matrix();

    /* renamed from: d */
    Matrix f7109d = new Matrix();

    /* renamed from: e */
    PointF f7110e = new PointF();

    /* renamed from: f */
    PointF f7111f = new PointF();

    /* renamed from: g */
    float f7112g = 1.0f;

    /* renamed from: h */
    final float f7113h = 4.0f;

    /* renamed from: i */
    boolean f7114i = true;

    /* renamed from: j */
    int f7115j = 0;

    /* renamed from: k */
    int f7116k = 0;

    /* renamed from: l */
    int f7117l = 0;

    /* renamed from: m */
    int f7118m = 0;

    /* renamed from: o */
    private GestureDetector f7120o = new GestureDetector(new C1849a(this));

    /* renamed from: a */
    public void m7704a(ImageView imageView) {
        if (imageView != null && imageView.getDrawable() != null) {
            this.f7115j = imageView.getDrawable().getIntrinsicWidth();
            this.f7116k = imageView.getDrawable().getIntrinsicHeight();
            this.f7117l = imageView.getWidth();
            this.f7118m = imageView.getHeight();
            imageView.setScaleType(ImageView.ScaleType.MATRIX);
            C3162ad.m11008a(imageView);
            this.f7108c.set(imageView.getImageMatrix());
            this.f7109d.set(this.f7108c);
        }
    }

    public ViewOnTouchListenerC1868as() {
    }

    public ViewOnTouchListenerC1868as(InterfaceC1869at interfaceC1869at) {
        this.f7122q = interfaceC1869at;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        ImageView imageView = (ImageView) view;
        this.f7121p = imageView;
        if (this.f7114i) {
            m7704a(imageView);
            this.f7114i = false;
        }
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
                if (C3250y.f11734b) {
                    C3250y.m11450b("ACTION_DOWN", getClass().getSimpleName());
                }
                this.f7109d.set(this.f7108c);
                this.f7110e.set(motionEvent.getX(), motionEvent.getY());
                C3250y.m11450b("Mode = DRAG", f7106a);
                this.f7107b = 1;
                break;
            case 1:
            case 6:
                if (C3250y.f11734b) {
                    C3250y.m11450b("ACTION_POINTER_UP/ACTION_UP", getClass().getSimpleName());
                }
                if (this.f7107b == 2 && motionEvent.getPointerCount() > 1) {
                    this.f7119n = true;
                    if (C3250y.f11734b) {
                        C3250y.m11450b("POINTS: " + motionEvent.getPointerCount(), getClass().getSimpleName());
                        break;
                    }
                } else {
                    if (C3250y.f11734b) {
                        C3250y.m11450b("POINTS: " + motionEvent.getPointerCount(), getClass().getSimpleName());
                    }
                    this.f7107b = 0;
                    this.f7119n = false;
                    m7702b(imageView);
                    break;
                }
                break;
            case 2:
                if (C3250y.f11734b) {
                    C3250y.m11450b("ACTION_MOVE", getClass().getSimpleName());
                }
                if (this.f7107b == 1) {
                    this.f7108c.set(this.f7109d);
                    if (!m7705a()) {
                        this.f7108c.postTranslate(motionEvent.getX() - this.f7110e.x, motionEvent.getY() - this.f7110e.y);
                        break;
                    }
                } else if (this.f7107b == 2 && !this.f7119n) {
                    float fM7700a = m7700a(motionEvent);
                    if (fM7700a > 10.0f) {
                        this.f7108c.set(this.f7109d);
                        float f = fM7700a / this.f7112g;
                        this.f7108c.postScale(f, f, this.f7111f.x, this.f7111f.y);
                        break;
                    }
                }
                break;
            case 5:
                if (C3250y.f11734b) {
                    C3250y.m11450b("ACTION_POINTER_DOWN", getClass().getSimpleName());
                }
                this.f7112g = m7700a(motionEvent);
                if (this.f7112g > 10.0f) {
                    this.f7109d.set(this.f7108c);
                    m7701a(this.f7111f, motionEvent);
                    this.f7107b = 2;
                    break;
                }
                break;
        }
        imageView.setImageMatrix(this.f7108c);
        this.f7120o.onTouchEvent(motionEvent);
        return true;
    }

    /* renamed from: a */
    private float m7700a(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() <= 1) {
            return 0.0f;
        }
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return FloatMath.sqrt((x * x) + (y * y));
    }

    /* renamed from: a */
    private void m7701a(PointF pointF, MotionEvent motionEvent) {
        pointF.set((motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f, (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f);
    }

    /* renamed from: a */
    public boolean m7705a() {
        float[] fArr = new float[9];
        this.f7108c.getValues(fArr);
        return ((int) (((float) this.f7115j) * fArr[0])) <= this.f7117l && ((int) (fArr[4] * ((float) this.f7116k))) <= this.f7118m;
    }

    /* renamed from: b */
    public boolean m7706b() {
        return m7705a() && this.f7107b != 2;
    }

    /* renamed from: a */
    public void m7703a(float f, float f2) {
        if (m7705a()) {
            float[] fArr = new float[9];
            this.f7108c.getValues(fArr);
            if (fArr[0] <= 4.0f && fArr[4] <= 4.0f) {
                this.f7108c.postScale(2.0f, 2.0f, f, f2);
                m7702b(this.f7121p);
            } else {
                return;
            }
        } else {
            m7704a(this.f7121p);
        }
        this.f7121p.setImageMatrix(this.f7108c);
    }

    /* renamed from: b */
    private void m7702b(ImageView imageView) {
        float[] fArr = new float[9];
        this.f7108c.getValues(fArr);
        this.f7109d.getValues(new float[9]);
        int i = (int) (this.f7115j * fArr[0]);
        int i2 = (int) (this.f7116k * fArr[4]);
        if (fArr[0] > 4.0f || fArr[4] > 4.0f) {
            this.f7108c.postScale(4.0f / fArr[0], 4.0f / fArr[4], this.f7111f.x, this.f7111f.y);
            this.f7108c.getValues(fArr);
            i = (int) (this.f7115j * fArr[0]);
            i2 = (int) (this.f7116k * fArr[4]);
        }
        if (i <= this.f7117l && i2 <= this.f7118m) {
            C3162ad.m11008a(imageView);
            this.f7108c.set(imageView.getImageMatrix());
            this.f7109d.set(this.f7108c);
            return;
        }
        if (i > this.f7117l || i2 > this.f7118m) {
            if (fArr[2] > 0.0f) {
                if (i < this.f7117l) {
                    fArr[2] = (this.f7117l - i) * 0.5f;
                } else {
                    fArr[2] = 0.0f;
                }
            } else if (i < this.f7117l) {
                fArr[2] = (this.f7117l - i) * 0.5f;
            } else if (Math.abs(fArr[2]) > Math.abs(this.f7117l - i)) {
                fArr[2] = this.f7117l - i;
            }
            if (fArr[5] > 0.0f) {
                if (i2 < this.f7118m) {
                    fArr[5] = (this.f7118m - i2) * 0.5f;
                } else {
                    fArr[5] = 0.0f;
                }
            } else if (i2 < this.f7118m) {
                fArr[5] = (this.f7118m - i2) * 0.5f;
            } else if (Math.abs(fArr[5]) > Math.abs(this.f7118m - i2)) {
                fArr[5] = this.f7118m - i2;
            }
        }
        this.f7108c.setValues(fArr);
        this.f7109d.set(this.f7108c);
    }

    /* renamed from: c */
    public void m7707c() {
        if (this.f7122q != null) {
            this.f7122q.mo7631f();
        }
    }
}
