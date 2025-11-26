package com.sec.vip.amschaton;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.view.MotionEventCompat;
import android.view.MotionEvent;
import android.view.View;
import twitter4j.internal.http.HttpResponseCode;

/* loaded from: classes.dex */
public class ColorPickerView extends View {

    /* renamed from: A */
    private int f12356A;

    /* renamed from: B */
    private int f12357B;

    /* renamed from: C */
    private int f12358C;

    /* renamed from: D */
    private int f12359D;

    /* renamed from: E */
    private int f12360E;

    /* renamed from: F */
    private int f12361F;

    /* renamed from: G */
    private int f12362G;

    /* renamed from: H */
    private int f12363H;

    /* renamed from: I */
    private int f12364I;

    /* renamed from: J */
    private int f12365J;

    /* renamed from: K */
    private InterfaceC3433bh f12366K;

    /* renamed from: a */
    private int[] f12367a;

    /* renamed from: b */
    private Paint f12368b;

    /* renamed from: c */
    private Paint f12369c;

    /* renamed from: d */
    private Paint f12370d;

    /* renamed from: e */
    private Paint f12371e;

    /* renamed from: f */
    private Paint f12372f;

    /* renamed from: g */
    private Paint f12373g;

    /* renamed from: h */
    private Paint f12374h;

    /* renamed from: i */
    private Bitmap f12375i;

    /* renamed from: j */
    private Canvas f12376j;

    /* renamed from: k */
    private Rect f12377k;

    /* renamed from: l */
    private int f12378l;

    /* renamed from: m */
    private float[] f12379m;

    /* renamed from: n */
    private int[] f12380n;

    /* renamed from: o */
    private final int f12381o;

    /* renamed from: p */
    private final int f12382p;

    /* renamed from: q */
    private final int f12383q;

    /* renamed from: r */
    private int f12384r;

    /* renamed from: s */
    private float f12385s;

    /* renamed from: t */
    private int f12386t;

    /* renamed from: u */
    private int f12387u;

    /* renamed from: v */
    private int f12388v;

    /* renamed from: w */
    private int f12389w;

    /* renamed from: x */
    private int f12390x;

    /* renamed from: y */
    private int f12391y;

    /* renamed from: z */
    private int f12392z;

    public ColorPickerView(Context context, int i, int i2, int i3) {
        super(context);
        this.f12377k = new Rect();
        this.f12378l = -16777216;
        this.f12379m = new float[3];
        this.f12380n = new int[3];
        this.f12381o = -1;
        this.f12382p = 30;
        this.f12383q = 31;
        this.f12384r = -1;
        this.f12385s = 1.0f;
        this.f12386t = 0;
        this.f12387u = 0;
        this.f12388v = 35;
        this.f12389w = 10;
        this.f12390x = 160;
        this.f12391y = 160;
        this.f12392z = 150;
        this.f12356A = 5;
        this.f12357B = 31;
        this.f12358C = 10;
        this.f12359D = 390;
        this.f12360E = 2;
        this.f12361F = 16;
        this.f12362G = 40;
        this.f12363H = HttpResponseCode.MULTIPLE_CHOICES;
        this.f12364I = 18;
        this.f12365J = 4;
        this.f12366K = null;
        setWindowSize(i, i2);
        setColor(i3);
    }

    public void setWindowSize(int i, int i2) {
        float f = i / 480.0f;
        float f2 = i2 / 340.0f;
        if (f < f2) {
            this.f12385s = f;
        } else {
            this.f12385s = f2;
        }
        this.f12386t = (int) ((i / 2) - (this.f12385s * 240.0f));
        this.f12387u = (int) ((i2 / 2) - (this.f12385s * 170.0f));
        m12077a();
        m12080b();
        setColor(this.f12378l);
    }

    public void setColor(int i) {
        this.f12378l = i;
        Color.colorToHSV(i, this.f12379m);
        if (m12081b(i)) {
            this.f12379m[1] = 0.0f;
        }
        m12082c();
    }

    public void setColorChangedListener(InterfaceC3433bh interfaceC3433bh) {
        this.f12366K = interfaceC3433bh;
    }

    /* renamed from: a */
    private int m12074a(int i) {
        int i2 = (int) ((i * this.f12385s) + 0.5d);
        if (i2 == 0) {
            return 1;
        }
        return i2;
    }

    /* renamed from: b */
    private boolean m12081b(int i) {
        return ((i >> 16) & MotionEventCompat.ACTION_MASK) == (i & MotionEventCompat.ACTION_MASK) && ((i >> 8) & MotionEventCompat.ACTION_MASK) == (i & MotionEventCompat.ACTION_MASK);
    }

    /* renamed from: a */
    private void m12077a() {
        this.f12388v = m12074a(this.f12388v);
        this.f12389w = m12074a(this.f12389w);
        this.f12390x = m12074a(this.f12390x);
        this.f12391y = m12074a(this.f12391y);
        this.f12392z = m12074a(this.f12392z);
        this.f12356A = m12074a(this.f12356A);
        this.f12357B = m12074a(this.f12357B);
        this.f12358C = m12074a(this.f12358C);
        this.f12359D = m12074a(this.f12359D);
        this.f12360E = m12074a(this.f12360E);
        this.f12361F = m12074a(this.f12361F);
        this.f12362G = m12074a(this.f12362G);
        this.f12363H = m12074a(this.f12363H);
        this.f12364I = m12074a(this.f12364I);
        this.f12365J = m12074a(this.f12365J);
        this.f12377k.set(this.f12359D, this.f12389w, this.f12359D + this.f12361F + this.f12362G, this.f12389w + this.f12363H);
    }

    /* renamed from: b */
    private void m12080b() {
        this.f12367a = new int[]{-65536, -65281, -16776961, -16711681, -16711936, -256, -65536};
        new SweepGradient(0.0f, 0.0f, this.f12367a, (float[]) null);
        ComposeShader composeShader = new ComposeShader(new SweepGradient(0.0f, 0.0f, this.f12367a, (float[]) null), new RadialGradient(0.0f, 0.0f, this.f12390x, -1, -16777216, Shader.TileMode.CLAMP), PorterDuff.Mode.SCREEN);
        this.f12368b = new Paint(1);
        this.f12368b.setShader(composeShader);
        this.f12368b.setStyle(Paint.Style.FILL);
        this.f12368b.setDither(true);
        this.f12369c = new Paint(1);
        this.f12369c.setColor(-1);
        this.f12369c.setStyle(Paint.Style.STROKE);
        this.f12369c.setStrokeWidth(this.f12356A);
        this.f12369c.setDither(true);
        this.f12370d = new Paint(1);
        this.f12370d.setColor(-1);
        this.f12370d.setStyle(Paint.Style.FILL);
        this.f12370d.setDither(true);
        this.f12371e = new Paint(1);
        this.f12371e.setColor(-7829368);
        this.f12371e.setStyle(Paint.Style.STROKE);
        this.f12371e.setStrokeWidth(this.f12358C);
        this.f12371e.setDither(true);
        this.f12372f = new Paint(1);
        this.f12372f.setColor(-1);
        this.f12372f.setStyle(Paint.Style.STROKE);
        this.f12372f.setStrokeWidth(this.f12360E);
        this.f12372f.setDither(true);
        this.f12375i = Bitmap.createBitmap(this.f12362G, this.f12363H, Bitmap.Config.RGB_565);
        this.f12376j = new Canvas(this.f12375i);
        this.f12373g = new Paint(1);
        this.f12373g.setStyle(Paint.Style.STROKE);
        this.f12373g.setStrokeWidth(this.f12364I);
        this.f12374h = new Paint(1);
        this.f12374h.setStyle(Paint.Style.STROKE);
        this.f12374h.setStrokeWidth(this.f12365J);
    }

    /* renamed from: c */
    private void m12082c() {
        m12083d();
        float f = (float) (6.283185307179586d - (this.f12379m[0] / 57.29577951308232d));
        float f2 = this.f12379m[1] * this.f12392z;
        this.f12380n[0] = (int) (Math.cos(f) * f2);
        this.f12380n[1] = (int) (f2 * Math.sin(f));
        this.f12380n[2] = this.f12363H - ((int) (this.f12379m[2] * this.f12363H));
    }

    /* renamed from: d */
    private void m12083d() {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.HSVToColor(new float[]{this.f12379m[0], this.f12379m[1], 1.0f}), -16777216});
        gradientDrawable.setDither(true);
        gradientDrawable.setLevel(10000);
        gradientDrawable.setBounds(0, 0, this.f12362G, this.f12363H);
        gradientDrawable.draw(this.f12376j);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(this.f12386t, this.f12387u);
        canvas.translate(this.f12388v, this.f12389w);
        canvas.translate(this.f12390x, this.f12391y);
        canvas.drawOval(new RectF(-this.f12392z, -this.f12392z, this.f12392z, this.f12392z), this.f12368b);
        canvas.drawOval(new RectF(-this.f12392z, -this.f12392z, this.f12392z, this.f12392z), this.f12369c);
        canvas.drawOval(new RectF(-this.f12357B, -this.f12357B, this.f12357B, this.f12357B), this.f12370d);
        canvas.drawOval(new RectF(-this.f12357B, -this.f12357B, this.f12357B, this.f12357B), this.f12371e);
        m12079a(canvas, this.f12380n[0], this.f12380n[1]);
        canvas.translate(-this.f12390x, -this.f12391y);
        canvas.translate(-this.f12388v, -this.f12389w);
        canvas.translate(this.f12377k.left, this.f12377k.top);
        canvas.drawBitmap(this.f12375i, 0.0f, 0.0f, (Paint) null);
        canvas.drawRect(new RectF(0.0f, 0.0f, this.f12375i.getWidth(), this.f12375i.getHeight()), this.f12372f);
        m12078a(canvas, this.f12380n[2]);
        canvas.restore();
    }

    /* renamed from: a */
    private void m12079a(Canvas canvas, int i, int i2) {
        this.f12373g.setColor(-1);
        canvas.drawOval(new RectF(i - this.f12361F, i2 - this.f12361F, this.f12361F + i, this.f12361F + i2), this.f12373g);
    }

    /* renamed from: a */
    private void m12078a(Canvas canvas, int i) {
        this.f12374h.setColor(-16777216);
        canvas.drawRect(new Rect(1, i - 3, this.f12362G, i + 3), this.f12374h);
        this.f12374h.setColor(-1);
        canvas.drawRect(new Rect(1, i - 1, this.f12362G, i + 1), this.f12374h);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX() - this.f12386t;
        float y = motionEvent.getY() - this.f12387u;
        int i = (int) y;
        if (i < 0) {
            i = 0;
        }
        if (i > this.f12363H) {
            i = this.f12363H;
        }
        float f = (x - this.f12388v) - this.f12390x;
        float f2 = (y - this.f12389w) - this.f12391y;
        float fSqrt = (float) Math.sqrt((f * f) + (f2 * f2));
        boolean z = fSqrt <= ((float) (this.f12392z + (this.f12361F * 2)));
        boolean z2 = fSqrt <= ((float) this.f12357B);
        if (fSqrt > this.f12392z) {
            fSqrt = this.f12392z;
        }
        boolean zContains = this.f12377k.contains(Math.round(x), Math.round(y));
        switch (motionEvent.getAction()) {
            case 0:
                this.f12384r = -1;
                if (z) {
                    this.f12384r = 30;
                    break;
                } else if (zContains) {
                    this.f12384r = 31;
                    break;
                }
                break;
            case 2:
                if (this.f12384r == 30) {
                    float fAtan2 = (float) Math.atan2(f2, f);
                    float f3 = (float) (fAtan2 / 6.283185307179586d);
                    if (f3 < 0.0f) {
                        f3 += 1.0f;
                    }
                    this.f12380n[0] = (int) Math.round(Math.cos(fAtan2) * fSqrt);
                    this.f12380n[1] = (int) Math.round(Math.sin(fAtan2) * fSqrt);
                    float[] fArr = new float[3];
                    Color.colorToHSV(!z2 ? m12076a(this.f12367a, f3) : -1, fArr);
                    this.f12379m[0] = fArr[0];
                    if (z2) {
                        this.f12379m[1] = fArr[1];
                    } else {
                        this.f12379m[1] = fSqrt / this.f12392z;
                    }
                    m12083d();
                    invalidate();
                    break;
                } else if (this.f12384r == 31 && this.f12380n[2] != i) {
                    this.f12380n[2] = i;
                    this.f12379m[2] = 1.0f - (i / this.f12363H);
                    invalidate();
                    break;
                }
                break;
        }
        if (this.f12366K != null) {
            this.f12366K.mo12289b(Color.HSVToColor(this.f12379m));
            this.f12370d.setColor(Color.HSVToColor(this.f12379m));
            invalidate(new Rect(-this.f12357B, -this.f12357B, this.f12357B, this.f12357B));
        }
        return true;
    }

    /* renamed from: a */
    private int m12075a(int i, int i2, float f) {
        return Math.round((i2 - i) * f) + i;
    }

    /* renamed from: a */
    private int m12076a(int[] iArr, float f) {
        if (f <= 0.0f) {
            return iArr[0];
        }
        if (f >= 1.0f) {
            return iArr[iArr.length - 1];
        }
        float length = (iArr.length - 1) * f;
        int i = (int) length;
        float f2 = length - i;
        int i2 = iArr[i];
        int i3 = iArr[i + 1];
        return Color.argb(m12075a(Color.alpha(i2), Color.alpha(i3), f2), m12075a(Color.red(i2), Color.red(i3), f2), m12075a(Color.green(i2), Color.green(i3), f2), m12075a(Color.blue(i2), Color.blue(i3), f2));
    }
}
