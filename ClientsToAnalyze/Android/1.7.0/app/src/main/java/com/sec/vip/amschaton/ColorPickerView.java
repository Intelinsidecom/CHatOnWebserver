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

/* loaded from: classes.dex */
public class ColorPickerView extends View {

    /* renamed from: A */
    private int f4704A;

    /* renamed from: B */
    private int f4705B;

    /* renamed from: C */
    private int f4706C;

    /* renamed from: D */
    private int f4707D;

    /* renamed from: E */
    private int f4708E;

    /* renamed from: F */
    private int f4709F;

    /* renamed from: G */
    private int f4710G;

    /* renamed from: H */
    private int f4711H;

    /* renamed from: I */
    private int f4712I;

    /* renamed from: J */
    private int f4713J;

    /* renamed from: K */
    private InterfaceC1384au f4714K;

    /* renamed from: a */
    private int[] f4715a;

    /* renamed from: b */
    private Paint f4716b;

    /* renamed from: c */
    private Paint f4717c;

    /* renamed from: d */
    private Paint f4718d;

    /* renamed from: e */
    private Paint f4719e;

    /* renamed from: f */
    private Paint f4720f;

    /* renamed from: g */
    private Paint f4721g;

    /* renamed from: h */
    private Paint f4722h;

    /* renamed from: i */
    private Bitmap f4723i;

    /* renamed from: j */
    private Canvas f4724j;

    /* renamed from: k */
    private Rect f4725k;

    /* renamed from: l */
    private int f4726l;

    /* renamed from: m */
    private float[] f4727m;

    /* renamed from: n */
    private int[] f4728n;

    /* renamed from: o */
    private final int f4729o;

    /* renamed from: p */
    private final int f4730p;

    /* renamed from: q */
    private final int f4731q;

    /* renamed from: r */
    private int f4732r;

    /* renamed from: s */
    private float f4733s;

    /* renamed from: t */
    private int f4734t;

    /* renamed from: u */
    private int f4735u;

    /* renamed from: v */
    private int f4736v;

    /* renamed from: w */
    private int f4737w;

    /* renamed from: x */
    private int f4738x;

    /* renamed from: y */
    private int f4739y;

    /* renamed from: z */
    private int f4740z;

    public ColorPickerView(Context context, int i, int i2, int i3) {
        super(context);
        this.f4725k = new Rect();
        this.f4726l = -16777216;
        this.f4727m = new float[3];
        this.f4728n = new int[3];
        this.f4729o = -1;
        this.f4730p = 30;
        this.f4731q = 31;
        this.f4732r = -1;
        this.f4733s = 1.0f;
        this.f4734t = 0;
        this.f4735u = 0;
        this.f4736v = 35;
        this.f4737w = 10;
        this.f4738x = 160;
        this.f4739y = 160;
        this.f4740z = 150;
        this.f4704A = 5;
        this.f4705B = 20;
        this.f4706C = 2;
        this.f4707D = 390;
        this.f4708E = 2;
        this.f4709F = 16;
        this.f4710G = 40;
        this.f4711H = 300;
        this.f4712I = 18;
        this.f4713J = 4;
        this.f4714K = null;
        setWindowSize(i, i2);
        setColor(i3);
    }

    public void setWindowSize(int i, int i2) {
        float f = i / 480.0f;
        float f2 = i2 / 340.0f;
        if (f < f2) {
            this.f4733s = f;
        } else {
            this.f4733s = f2;
        }
        this.f4734t = (int) ((i / 2) - (this.f4733s * 240.0f));
        this.f4735u = (int) ((i2 / 2) - (this.f4733s * 170.0f));
        m4840a();
        m4843b();
        setColor(this.f4726l);
    }

    public void setColor(int i) {
        this.f4726l = i;
        Color.colorToHSV(i, this.f4727m);
        if (m4844b(i)) {
            this.f4727m[1] = 0.0f;
        }
        m4845c();
    }

    public void setColorChangedListener(InterfaceC1384au interfaceC1384au) {
        this.f4714K = interfaceC1384au;
    }

    /* renamed from: a */
    private int m4837a(int i) {
        int i2 = (int) ((i * this.f4733s) + 0.5d);
        if (i2 == 0) {
            return 1;
        }
        return i2;
    }

    /* renamed from: b */
    private boolean m4844b(int i) {
        return ((i >> 16) & MotionEventCompat.ACTION_MASK) == (i & MotionEventCompat.ACTION_MASK) && ((i >> 8) & MotionEventCompat.ACTION_MASK) == (i & MotionEventCompat.ACTION_MASK);
    }

    /* renamed from: a */
    private void m4840a() {
        this.f4736v = m4837a(this.f4736v);
        this.f4737w = m4837a(this.f4737w);
        this.f4738x = m4837a(this.f4738x);
        this.f4739y = m4837a(this.f4739y);
        this.f4740z = m4837a(this.f4740z);
        this.f4704A = m4837a(this.f4704A);
        this.f4705B = m4837a(this.f4705B);
        this.f4706C = m4837a(this.f4706C);
        this.f4707D = m4837a(this.f4707D);
        this.f4708E = m4837a(this.f4708E);
        this.f4709F = m4837a(this.f4709F);
        this.f4710G = m4837a(this.f4710G);
        this.f4711H = m4837a(this.f4711H);
        this.f4712I = m4837a(this.f4712I);
        this.f4713J = m4837a(this.f4713J);
        this.f4725k.set(this.f4707D, this.f4737w, this.f4707D + this.f4709F + this.f4710G, this.f4737w + this.f4711H);
    }

    /* renamed from: b */
    private void m4843b() {
        this.f4715a = new int[]{-65536, -65281, -16776961, -16711681, -16711936, -256, -65536};
        new SweepGradient(0.0f, 0.0f, this.f4715a, (float[]) null);
        ComposeShader composeShader = new ComposeShader(new SweepGradient(0.0f, 0.0f, this.f4715a, (float[]) null), new RadialGradient(0.0f, 0.0f, this.f4738x, -1, -16777216, Shader.TileMode.CLAMP), PorterDuff.Mode.SCREEN);
        this.f4716b = new Paint(1);
        this.f4716b.setShader(composeShader);
        this.f4716b.setStyle(Paint.Style.FILL);
        this.f4716b.setDither(true);
        this.f4717c = new Paint(1);
        this.f4717c.setColor(-1);
        this.f4717c.setStyle(Paint.Style.STROKE);
        this.f4717c.setStrokeWidth(this.f4704A);
        this.f4717c.setDither(true);
        this.f4718d = new Paint(1);
        this.f4718d.setColor(-1);
        this.f4718d.setStyle(Paint.Style.FILL);
        this.f4718d.setDither(true);
        this.f4719e = new Paint(1);
        this.f4719e.setColor(-7829368);
        this.f4719e.setStyle(Paint.Style.STROKE);
        this.f4719e.setStrokeWidth(this.f4706C);
        this.f4719e.setDither(true);
        this.f4720f = new Paint(1);
        this.f4720f.setColor(-1);
        this.f4720f.setStyle(Paint.Style.STROKE);
        this.f4720f.setStrokeWidth(this.f4708E);
        this.f4720f.setDither(true);
        this.f4723i = Bitmap.createBitmap(this.f4710G, this.f4711H, Bitmap.Config.RGB_565);
        this.f4724j = new Canvas(this.f4723i);
        this.f4721g = new Paint(1);
        this.f4721g.setStyle(Paint.Style.STROKE);
        this.f4721g.setStrokeWidth(this.f4712I);
        this.f4722h = new Paint(1);
        this.f4722h.setStyle(Paint.Style.STROKE);
        this.f4722h.setStrokeWidth(this.f4713J);
    }

    /* renamed from: c */
    private void m4845c() {
        m4846d();
        float f = (float) (6.283185307179586d - (this.f4727m[0] / 57.29577951308232d));
        float f2 = this.f4727m[1] * this.f4740z;
        this.f4728n[0] = (int) (Math.cos(f) * f2);
        this.f4728n[1] = (int) (f2 * Math.sin(f));
        this.f4728n[2] = this.f4711H - ((int) (this.f4727m[2] * this.f4711H));
    }

    /* renamed from: d */
    private void m4846d() {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.HSVToColor(new float[]{this.f4727m[0], this.f4727m[1], 1.0f}), -16777216});
        gradientDrawable.setDither(true);
        gradientDrawable.setLevel(10000);
        gradientDrawable.setBounds(0, 0, this.f4710G, this.f4711H);
        gradientDrawable.draw(this.f4724j);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(this.f4734t, this.f4735u);
        canvas.translate(this.f4736v, this.f4737w);
        canvas.translate(this.f4738x, this.f4739y);
        canvas.drawOval(new RectF(-this.f4740z, -this.f4740z, this.f4740z, this.f4740z), this.f4716b);
        canvas.drawOval(new RectF(-this.f4740z, -this.f4740z, this.f4740z, this.f4740z), this.f4717c);
        canvas.drawOval(new RectF(-this.f4705B, -this.f4705B, this.f4705B, this.f4705B), this.f4718d);
        canvas.drawOval(new RectF(-this.f4705B, -this.f4705B, this.f4705B, this.f4705B), this.f4719e);
        m4842a(canvas, this.f4728n[0], this.f4728n[1]);
        canvas.translate(-this.f4738x, -this.f4739y);
        canvas.translate(-this.f4736v, -this.f4737w);
        canvas.translate(this.f4725k.left, this.f4725k.top);
        canvas.drawBitmap(this.f4723i, 0.0f, 0.0f, (Paint) null);
        canvas.drawRect(new RectF(0.0f, 0.0f, this.f4723i.getWidth(), this.f4723i.getHeight()), this.f4720f);
        m4841a(canvas, this.f4728n[2]);
        canvas.restore();
    }

    /* renamed from: a */
    private void m4842a(Canvas canvas, int i, int i2) {
        this.f4721g.setColor(-1);
        canvas.drawOval(new RectF(i - this.f4709F, i2 - this.f4709F, this.f4709F + i, this.f4709F + i2), this.f4721g);
    }

    /* renamed from: a */
    private void m4841a(Canvas canvas, int i) {
        this.f4722h.setColor(-16777216);
        canvas.drawRect(new Rect(1, i - 3, this.f4710G, i + 3), this.f4722h);
        this.f4722h.setColor(-1);
        canvas.drawRect(new Rect(1, i - 1, this.f4710G, i + 1), this.f4722h);
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
    private int m4838a(int i, int i2, float f) {
        return Math.round((i2 - i) * f) + i;
    }

    /* renamed from: a */
    private int m4839a(int[] iArr, float f) {
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
        return Color.argb(m4838a(Color.alpha(i2), Color.alpha(i3), f2), m4838a(Color.red(i2), Color.red(i3), f2), m4838a(Color.green(i2), Color.green(i3), f2), m4838a(Color.blue(i2), Color.blue(i3), f2));
    }
}
