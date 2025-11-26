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
import android.view.View;
import twitter4j.internal.http.HttpResponseCode;

/* loaded from: classes.dex */
public class ColorPickerView extends View {

    /* renamed from: A */
    private int f6692A;

    /* renamed from: B */
    private int f6693B;

    /* renamed from: C */
    private int f6694C;

    /* renamed from: D */
    private int f6695D;

    /* renamed from: E */
    private int f6696E;

    /* renamed from: F */
    private int f6697F;

    /* renamed from: G */
    private int f6698G;

    /* renamed from: H */
    private int f6699H;

    /* renamed from: I */
    private int f6700I;

    /* renamed from: J */
    private int f6701J;

    /* renamed from: K */
    private InterfaceC1871bd f6702K;

    /* renamed from: a */
    private int[] f6703a;

    /* renamed from: b */
    private Paint f6704b;

    /* renamed from: c */
    private Paint f6705c;

    /* renamed from: d */
    private Paint f6706d;

    /* renamed from: e */
    private Paint f6707e;

    /* renamed from: f */
    private Paint f6708f;

    /* renamed from: g */
    private Paint f6709g;

    /* renamed from: h */
    private Paint f6710h;

    /* renamed from: i */
    private Bitmap f6711i;

    /* renamed from: j */
    private Canvas f6712j;

    /* renamed from: k */
    private Rect f6713k;

    /* renamed from: l */
    private int f6714l;

    /* renamed from: m */
    private float[] f6715m;

    /* renamed from: n */
    private int[] f6716n;

    /* renamed from: o */
    private final int f6717o;

    /* renamed from: p */
    private final int f6718p;

    /* renamed from: q */
    private final int f6719q;

    /* renamed from: r */
    private int f6720r;

    /* renamed from: s */
    private float f6721s;

    /* renamed from: t */
    private int f6722t;

    /* renamed from: u */
    private int f6723u;

    /* renamed from: v */
    private int f6724v;

    /* renamed from: w */
    private int f6725w;

    /* renamed from: x */
    private int f6726x;

    /* renamed from: y */
    private int f6727y;

    /* renamed from: z */
    private int f6728z;

    public ColorPickerView(Context context, int i, int i2, int i3) {
        super(context);
        this.f6713k = new Rect();
        this.f6714l = -16777216;
        this.f6715m = new float[3];
        this.f6716n = new int[3];
        this.f6717o = -1;
        this.f6718p = 30;
        this.f6719q = 31;
        this.f6720r = -1;
        this.f6721s = 1.0f;
        this.f6722t = 0;
        this.f6723u = 0;
        this.f6724v = 35;
        this.f6725w = 10;
        this.f6726x = 160;
        this.f6727y = 160;
        this.f6728z = 150;
        this.f6692A = 5;
        this.f6693B = 20;
        this.f6694C = 2;
        this.f6695D = 390;
        this.f6696E = 2;
        this.f6697F = 16;
        this.f6698G = 40;
        this.f6699H = HttpResponseCode.MULTIPLE_CHOICES;
        this.f6700I = 18;
        this.f6701J = 4;
        this.f6702K = null;
        setWindowSize(i, i2);
        setColor(i3);
    }

    public void setWindowSize(int i, int i2) {
        float f = i / 480.0f;
        float f2 = i2 / 340.0f;
        if (f < f2) {
            this.f6721s = f;
        } else {
            this.f6721s = f2;
        }
        this.f6722t = (int) ((i / 2) - (this.f6721s * 240.0f));
        this.f6723u = (int) ((i2 / 2) - (this.f6721s * 170.0f));
        m6365a();
        m6368b();
        setColor(this.f6714l);
    }

    public void setColor(int i) {
        this.f6714l = i;
        Color.colorToHSV(i, this.f6715m);
        if (m6369b(i)) {
            this.f6715m[1] = 0.0f;
        }
        m6370c();
    }

    public void setColorChangedListener(InterfaceC1871bd interfaceC1871bd) {
        this.f6702K = interfaceC1871bd;
    }

    /* renamed from: a */
    private int m6362a(int i) {
        int i2 = (int) ((i * this.f6721s) + 0.5d);
        if (i2 == 0) {
            return 1;
        }
        return i2;
    }

    /* renamed from: b */
    private boolean m6369b(int i) {
        return ((i >> 16) & MotionEventCompat.ACTION_MASK) == (i & MotionEventCompat.ACTION_MASK) && ((i >> 8) & MotionEventCompat.ACTION_MASK) == (i & MotionEventCompat.ACTION_MASK);
    }

    /* renamed from: a */
    private void m6365a() {
        this.f6724v = m6362a(this.f6724v);
        this.f6725w = m6362a(this.f6725w);
        this.f6726x = m6362a(this.f6726x);
        this.f6727y = m6362a(this.f6727y);
        this.f6728z = m6362a(this.f6728z);
        this.f6692A = m6362a(this.f6692A);
        this.f6693B = m6362a(this.f6693B);
        this.f6694C = m6362a(this.f6694C);
        this.f6695D = m6362a(this.f6695D);
        this.f6696E = m6362a(this.f6696E);
        this.f6697F = m6362a(this.f6697F);
        this.f6698G = m6362a(this.f6698G);
        this.f6699H = m6362a(this.f6699H);
        this.f6700I = m6362a(this.f6700I);
        this.f6701J = m6362a(this.f6701J);
        this.f6713k.set(this.f6695D, this.f6725w, this.f6695D + this.f6697F + this.f6698G, this.f6725w + this.f6699H);
    }

    /* renamed from: b */
    private void m6368b() {
        this.f6703a = new int[]{-65536, -65281, -16776961, -16711681, -16711936, -256, -65536};
        new SweepGradient(0.0f, 0.0f, this.f6703a, (float[]) null);
        ComposeShader composeShader = new ComposeShader(new SweepGradient(0.0f, 0.0f, this.f6703a, (float[]) null), new RadialGradient(0.0f, 0.0f, this.f6726x, -1, -16777216, Shader.TileMode.CLAMP), PorterDuff.Mode.SCREEN);
        this.f6704b = new Paint(1);
        this.f6704b.setShader(composeShader);
        this.f6704b.setStyle(Paint.Style.FILL);
        this.f6704b.setDither(true);
        this.f6705c = new Paint(1);
        this.f6705c.setColor(-1);
        this.f6705c.setStyle(Paint.Style.STROKE);
        this.f6705c.setStrokeWidth(this.f6692A);
        this.f6705c.setDither(true);
        this.f6706d = new Paint(1);
        this.f6706d.setColor(-1);
        this.f6706d.setStyle(Paint.Style.FILL);
        this.f6706d.setDither(true);
        this.f6707e = new Paint(1);
        this.f6707e.setColor(-7829368);
        this.f6707e.setStyle(Paint.Style.STROKE);
        this.f6707e.setStrokeWidth(this.f6694C);
        this.f6707e.setDither(true);
        this.f6708f = new Paint(1);
        this.f6708f.setColor(-1);
        this.f6708f.setStyle(Paint.Style.STROKE);
        this.f6708f.setStrokeWidth(this.f6696E);
        this.f6708f.setDither(true);
        this.f6711i = Bitmap.createBitmap(this.f6698G, this.f6699H, Bitmap.Config.RGB_565);
        this.f6712j = new Canvas(this.f6711i);
        this.f6709g = new Paint(1);
        this.f6709g.setStyle(Paint.Style.STROKE);
        this.f6709g.setStrokeWidth(this.f6700I);
        this.f6710h = new Paint(1);
        this.f6710h.setStyle(Paint.Style.STROKE);
        this.f6710h.setStrokeWidth(this.f6701J);
    }

    /* renamed from: c */
    private void m6370c() {
        m6371d();
        float f = (float) (6.283185307179586d - (this.f6715m[0] / 57.29577951308232d));
        float f2 = this.f6715m[1] * this.f6728z;
        this.f6716n[0] = (int) (Math.cos(f) * f2);
        this.f6716n[1] = (int) (f2 * Math.sin(f));
        this.f6716n[2] = this.f6699H - ((int) (this.f6715m[2] * this.f6699H));
    }

    /* renamed from: d */
    private void m6371d() {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.HSVToColor(new float[]{this.f6715m[0], this.f6715m[1], 1.0f}), -16777216});
        gradientDrawable.setDither(true);
        gradientDrawable.setLevel(10000);
        gradientDrawable.setBounds(0, 0, this.f6698G, this.f6699H);
        gradientDrawable.draw(this.f6712j);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(this.f6722t, this.f6723u);
        canvas.translate(this.f6724v, this.f6725w);
        canvas.translate(this.f6726x, this.f6727y);
        canvas.drawOval(new RectF(-this.f6728z, -this.f6728z, this.f6728z, this.f6728z), this.f6704b);
        canvas.drawOval(new RectF(-this.f6728z, -this.f6728z, this.f6728z, this.f6728z), this.f6705c);
        canvas.drawOval(new RectF(-this.f6693B, -this.f6693B, this.f6693B, this.f6693B), this.f6706d);
        canvas.drawOval(new RectF(-this.f6693B, -this.f6693B, this.f6693B, this.f6693B), this.f6707e);
        m6367a(canvas, this.f6716n[0], this.f6716n[1]);
        canvas.translate(-this.f6726x, -this.f6727y);
        canvas.translate(-this.f6724v, -this.f6725w);
        canvas.translate(this.f6713k.left, this.f6713k.top);
        canvas.drawBitmap(this.f6711i, 0.0f, 0.0f, (Paint) null);
        canvas.drawRect(new RectF(0.0f, 0.0f, this.f6711i.getWidth(), this.f6711i.getHeight()), this.f6708f);
        m6366a(canvas, this.f6716n[2]);
        canvas.restore();
    }

    /* renamed from: a */
    private void m6367a(Canvas canvas, int i, int i2) {
        this.f6709g.setColor(-1);
        canvas.drawOval(new RectF(i - this.f6697F, i2 - this.f6697F, this.f6697F + i, this.f6697F + i2), this.f6709g);
    }

    /* renamed from: a */
    private void m6366a(Canvas canvas, int i) {
        this.f6710h.setColor(-16777216);
        canvas.drawRect(new Rect(1, i - 3, this.f6698G, i + 3), this.f6710h);
        this.f6710h.setColor(-1);
        canvas.drawRect(new Rect(1, i - 1, this.f6698G, i + 1), this.f6710h);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00fb  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r15) {
        /*
            Method dump skipped, instructions count: 296
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.vip.amschaton.ColorPickerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* renamed from: a */
    private int m6363a(int i, int i2, float f) {
        return Math.round((i2 - i) * f) + i;
    }

    /* renamed from: a */
    private int m6364a(int[] iArr, float f) {
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
        return Color.argb(m6363a(Color.alpha(i2), Color.alpha(i3), f2), m6363a(Color.red(i2), Color.red(i3), f2), m6363a(Color.green(i2), Color.green(i3), f2), m6363a(Color.blue(i2), Color.blue(i3), f2));
    }
}
