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
import android.view.View;

/* loaded from: classes.dex */
public class ColorPickerView extends View {

    /* renamed from: A */
    private int f4138A;

    /* renamed from: B */
    private int f4139B;

    /* renamed from: C */
    private int f4140C;

    /* renamed from: D */
    private int f4141D;

    /* renamed from: E */
    private int f4142E;

    /* renamed from: F */
    private int f4143F;

    /* renamed from: G */
    private int f4144G;

    /* renamed from: H */
    private int f4145H;

    /* renamed from: I */
    private int f4146I;

    /* renamed from: J */
    private int f4147J;

    /* renamed from: K */
    private InterfaceC0666bm f4148K;

    /* renamed from: a */
    private int[] f4149a;

    /* renamed from: b */
    private Paint f4150b;

    /* renamed from: c */
    private Paint f4151c;

    /* renamed from: d */
    private Paint f4152d;

    /* renamed from: e */
    private Paint f4153e;

    /* renamed from: f */
    private Paint f4154f;

    /* renamed from: g */
    private Paint f4155g;

    /* renamed from: h */
    private Paint f4156h;

    /* renamed from: i */
    private Bitmap f4157i;

    /* renamed from: j */
    private Canvas f4158j;

    /* renamed from: k */
    private Rect f4159k;

    /* renamed from: l */
    private int f4160l;

    /* renamed from: m */
    private float[] f4161m;

    /* renamed from: n */
    private int[] f4162n;

    /* renamed from: o */
    private final int f4163o;

    /* renamed from: p */
    private final int f4164p;

    /* renamed from: q */
    private final int f4165q;

    /* renamed from: r */
    private int f4166r;

    /* renamed from: s */
    private float f4167s;

    /* renamed from: t */
    private int f4168t;

    /* renamed from: u */
    private int f4169u;

    /* renamed from: v */
    private int f4170v;

    /* renamed from: w */
    private int f4171w;

    /* renamed from: x */
    private int f4172x;

    /* renamed from: y */
    private int f4173y;

    /* renamed from: z */
    private int f4174z;

    public ColorPickerView(Context context, int i, int i2, int i3) {
        super(context);
        this.f4159k = new Rect();
        this.f4160l = -16777216;
        this.f4161m = new float[3];
        this.f4162n = new int[3];
        this.f4163o = -1;
        this.f4164p = 30;
        this.f4165q = 31;
        this.f4166r = -1;
        this.f4167s = 1.0f;
        this.f4168t = 0;
        this.f4169u = 0;
        this.f4170v = 35;
        this.f4171w = 5;
        this.f4172x = 160;
        this.f4173y = 160;
        this.f4174z = 150;
        this.f4138A = 5;
        this.f4139B = 20;
        this.f4140C = 2;
        this.f4141D = 390;
        this.f4142E = 2;
        this.f4143F = 16;
        this.f4144G = 40;
        this.f4145H = 300;
        this.f4146I = 18;
        this.f4147J = 4;
        this.f4148K = null;
        setWindowSize(i, i2);
        setColor(i3);
    }

    /* renamed from: a */
    private int m4163a(int i) {
        int i2 = (int) ((i * this.f4167s) + 0.5d);
        if (i2 == 0) {
            return 1;
        }
        return i2;
    }

    /* renamed from: a */
    private int m4164a(int i, int i2, float f) {
        return Math.round((i2 - i) * f) + i;
    }

    /* renamed from: a */
    private int m4165a(int[] iArr, float f) {
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
        return Color.argb(m4164a(Color.alpha(i2), Color.alpha(i3), f2), m4164a(Color.red(i2), Color.red(i3), f2), m4164a(Color.green(i2), Color.green(i3), f2), m4164a(Color.blue(i2), Color.blue(i3), f2));
    }

    /* renamed from: a */
    private void m4166a() {
        this.f4170v = m4163a(this.f4170v);
        this.f4171w = m4163a(this.f4171w);
        this.f4172x = m4163a(this.f4172x);
        this.f4173y = m4163a(this.f4173y);
        this.f4174z = m4163a(this.f4174z);
        this.f4138A = m4163a(this.f4138A);
        this.f4139B = m4163a(this.f4139B);
        this.f4140C = m4163a(this.f4140C);
        this.f4141D = m4163a(this.f4141D);
        this.f4142E = m4163a(this.f4142E);
        this.f4143F = m4163a(this.f4143F);
        this.f4144G = m4163a(this.f4144G);
        this.f4145H = m4163a(this.f4145H);
        this.f4146I = m4163a(this.f4146I);
        this.f4147J = m4163a(this.f4147J);
        this.f4159k.set(this.f4141D, this.f4171w, this.f4141D + this.f4143F + this.f4144G, this.f4171w + this.f4145H);
    }

    /* renamed from: a */
    private void m4167a(Canvas canvas, int i) {
        this.f4156h.setColor(-16777216);
        canvas.drawRect(new Rect(1, i - 3, this.f4144G, i + 3), this.f4156h);
        this.f4156h.setColor(-1);
        canvas.drawRect(new Rect(1, i - 1, this.f4144G, i + 1), this.f4156h);
    }

    /* renamed from: a */
    private void m4168a(Canvas canvas, int i, int i2) {
        this.f4155g.setColor(-1);
        canvas.drawOval(new RectF(i - this.f4143F, i2 - this.f4143F, this.f4143F + i, this.f4143F + i2), this.f4155g);
    }

    /* renamed from: b */
    private void m4169b() {
        this.f4149a = new int[]{-65536, -65281, -16776961, -16711681, -16711936, -256, -65536};
        new SweepGradient(0.0f, 0.0f, this.f4149a, (float[]) null);
        ComposeShader composeShader = new ComposeShader(new SweepGradient(0.0f, 0.0f, this.f4149a, (float[]) null), new RadialGradient(0.0f, 0.0f, this.f4172x, -1, -16777216, Shader.TileMode.CLAMP), PorterDuff.Mode.SCREEN);
        this.f4150b = new Paint(1);
        this.f4150b.setShader(composeShader);
        this.f4150b.setStyle(Paint.Style.FILL);
        this.f4150b.setDither(true);
        this.f4151c = new Paint(1);
        this.f4151c.setColor(-1);
        this.f4151c.setStyle(Paint.Style.STROKE);
        this.f4151c.setStrokeWidth(this.f4138A);
        this.f4151c.setDither(true);
        this.f4152d = new Paint(1);
        this.f4152d.setColor(-1);
        this.f4152d.setStyle(Paint.Style.FILL);
        this.f4152d.setDither(true);
        this.f4153e = new Paint(1);
        this.f4153e.setColor(-7829368);
        this.f4153e.setStyle(Paint.Style.STROKE);
        this.f4153e.setStrokeWidth(this.f4140C);
        this.f4153e.setDither(true);
        this.f4154f = new Paint(1);
        this.f4154f.setColor(-1);
        this.f4154f.setStyle(Paint.Style.STROKE);
        this.f4154f.setStrokeWidth(this.f4142E);
        this.f4154f.setDither(true);
        this.f4157i = Bitmap.createBitmap(this.f4144G, this.f4145H, Bitmap.Config.RGB_565);
        this.f4158j = new Canvas(this.f4157i);
        this.f4155g = new Paint(1);
        this.f4155g.setStyle(Paint.Style.STROKE);
        this.f4155g.setStrokeWidth(this.f4146I);
        this.f4156h = new Paint(1);
        this.f4156h.setStyle(Paint.Style.STROKE);
        this.f4156h.setStrokeWidth(this.f4147J);
    }

    /* renamed from: b */
    private boolean m4170b(int i) {
        return ((i >> 16) & 255) == (i & 255) && ((i >> 8) & 255) == (i & 255);
    }

    /* renamed from: c */
    private void m4171c() {
        m4172d();
        float f = (float) (6.283185307179586d - (this.f4161m[0] / 57.29577951308232d));
        float f2 = this.f4161m[1] * this.f4174z;
        this.f4162n[0] = (int) (Math.cos(f) * f2);
        this.f4162n[1] = (int) (f2 * Math.sin(f));
        this.f4162n[2] = this.f4145H - ((int) (this.f4161m[2] * this.f4145H));
    }

    /* renamed from: d */
    private void m4172d() {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.HSVToColor(new float[]{this.f4161m[0], this.f4161m[1], 1.0f}), -16777216});
        gradientDrawable.setDither(true);
        gradientDrawable.setLevel(10000);
        gradientDrawable.setBounds(0, 0, this.f4144G, this.f4145H);
        gradientDrawable.draw(this.f4158j);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(this.f4168t, this.f4169u);
        canvas.translate(this.f4170v, this.f4171w);
        canvas.translate(this.f4172x, this.f4173y);
        canvas.drawOval(new RectF(-this.f4174z, -this.f4174z, this.f4174z, this.f4174z), this.f4150b);
        canvas.drawOval(new RectF(-this.f4174z, -this.f4174z, this.f4174z, this.f4174z), this.f4151c);
        canvas.drawOval(new RectF(-this.f4139B, -this.f4139B, this.f4139B, this.f4139B), this.f4152d);
        canvas.drawOval(new RectF(-this.f4139B, -this.f4139B, this.f4139B, this.f4139B), this.f4153e);
        m4168a(canvas, this.f4162n[0], this.f4162n[1]);
        canvas.translate(-this.f4172x, -this.f4173y);
        canvas.translate(-this.f4170v, -this.f4171w);
        canvas.translate(this.f4159k.left, this.f4159k.top);
        canvas.drawBitmap(this.f4157i, 0.0f, 0.0f, (Paint) null);
        canvas.drawRect(new RectF(0.0f, 0.0f, this.f4157i.getWidth(), this.f4157i.getHeight()), this.f4154f);
        m4167a(canvas, this.f4162n[2]);
        canvas.restore();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:30:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f3  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r15) {
        /*
            Method dump skipped, instructions count: 288
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.vip.amschaton.ColorPickerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setColor(int i) {
        this.f4160l = i;
        Color.colorToHSV(i, this.f4161m);
        if (m4170b(i)) {
            this.f4161m[1] = 0.0f;
        }
        m4171c();
    }

    public void setColorChangedListener(InterfaceC0666bm interfaceC0666bm) {
        this.f4148K = interfaceC0666bm;
    }

    public void setWindowSize(int i, int i2) {
        float f = i / 480.0f;
        float f2 = i2 / 340.0f;
        if (f < f2) {
            this.f4167s = f;
        } else {
            this.f4167s = f2;
        }
        this.f4168t = (int) ((i / 2) - (this.f4167s * 240.0f));
        this.f4169u = (int) ((i2 / 2) - (this.f4167s * 170.0f));
        m4166a();
        m4169b();
        setColor(this.f4160l);
    }
}
