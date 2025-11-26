package com.sec.chaton.util;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: classes.dex */
public class ColorSelector extends View {

    /* renamed from: a */
    private Paint f11439a;

    /* renamed from: b */
    private Paint f11440b;

    /* renamed from: c */
    private int[] f11441c;

    /* renamed from: d */
    private InterfaceC3166ah f11442d;

    /* renamed from: e */
    private InterfaceC3167ai f11443e;

    /* renamed from: f */
    private int f11444f;

    /* renamed from: g */
    private int f11445g;

    /* renamed from: h */
    private int f11446h;

    /* renamed from: i */
    private int f11447i;

    /* renamed from: j */
    private boolean f11448j;

    /* renamed from: k */
    private boolean f11449k;

    public ColorSelector(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m10945a();
    }

    public ColorSelector(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m10945a();
    }

    public ColorSelector(Context context) {
        super(context);
        m10945a();
    }

    /* renamed from: a */
    void m10945a() {
        this.f11441c = new int[]{-65536, -65281, -16776961, -16711681, -16711936, -256, -65536};
        SweepGradient sweepGradient = new SweepGradient(0.0f, 0.0f, this.f11441c, (float[]) null);
        this.f11439a = new Paint(1);
        this.f11439a.setShader(sweepGradient);
        this.f11439a.setStyle(Paint.Style.STROKE);
        this.f11439a.setStrokeWidth(C3172an.m11085a(32.0f));
        this.f11440b = new Paint(1);
        this.f11440b.setStrokeWidth(C3172an.m11085a(5.0f));
        this.f11444f = (int) C3172an.m11085a(100.0f);
        this.f11445g = (int) C3172an.m11085a(100.0f);
        this.f11446h = (int) C3172an.m11085a(32.0f);
    }

    public void setInitialColor(int i) {
        this.f11447i = i;
        this.f11440b.setColor(this.f11447i);
    }

    public void setColorPickerChangedListener(InterfaceC3166ah interfaceC3166ah) {
        this.f11442d = interfaceC3166ah;
    }

    public void setColorPickerSelectedListener(InterfaceC3167ai interfaceC3167ai) {
        this.f11443e = interfaceC3167ai;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float strokeWidth = this.f11444f - (this.f11439a.getStrokeWidth() * 0.5f);
        canvas.translate(this.f11444f, this.f11444f);
        canvas.drawOval(new RectF(-strokeWidth, -strokeWidth, strokeWidth, strokeWidth), this.f11439a);
        canvas.drawCircle(0.0f, 0.0f, this.f11446h, this.f11440b);
        if (this.f11448j) {
            int color = this.f11440b.getColor();
            this.f11440b.setStyle(Paint.Style.STROKE);
            if (this.f11449k) {
                this.f11440b.setAlpha(MotionEventCompat.ACTION_MASK);
            } else {
                this.f11440b.setAlpha(128);
            }
            canvas.drawCircle(0.0f, 0.0f, this.f11446h + this.f11440b.getStrokeWidth(), this.f11440b);
            this.f11440b.setStyle(Paint.Style.FILL);
            this.f11440b.setColor(color);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(this.f11444f * 2, this.f11445g * 2);
    }

    /* renamed from: a */
    private int m10943a(int i, int i2, float f) {
        return Math.round((i2 - i) * f) + i;
    }

    /* renamed from: a */
    private int m10944a(int[] iArr, float f) {
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
        return Color.argb(m10943a(Color.alpha(i2), Color.alpha(i3), f2), m10943a(Color.red(i2), Color.red(i3), f2), m10943a(Color.green(i2), Color.green(i3), f2), m10943a(Color.blue(i2), Color.blue(i3), f2));
    }

    public void setColor(int i) {
        this.f11448j = true;
        this.f11440b.setColor(i);
        invalidate();
        this.f11448j = false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:12:0x003a  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r10) {
        /*
            r9 = this;
            r2 = 0
            r1 = 1
            float r0 = r10.getX()
            int r3 = r9.f11444f
            float r3 = (float) r3
            float r3 = r0 - r3
            float r0 = r10.getY()
            int r4 = r9.f11445g
            float r4 = (float) r4
            float r4 = r0 - r4
            float r0 = r3 * r3
            float r5 = r4 * r4
            float r0 = r0 + r5
            double r5 = (double) r0
            double r5 = java.lang.Math.sqrt(r5)
            int r0 = r9.f11446h
            double r7 = (double) r0
            int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r0 > 0) goto L2e
            r0 = r1
        L26:
            int r5 = r10.getAction()
            switch(r5) {
                case 0: goto L30;
                case 1: goto L75;
                case 2: goto L3a;
                default: goto L2d;
            }
        L2d:
            return r1
        L2e:
            r0 = r2
            goto L26
        L30:
            r9.f11448j = r0
            if (r0 == 0) goto L3a
            r9.f11449k = r1
            r9.invalidate()
            goto L2d
        L3a:
            boolean r2 = r9.f11448j
            if (r2 == 0) goto L48
            boolean r2 = r9.f11449k
            if (r2 == r0) goto L2d
            r9.f11449k = r0
            r9.invalidate()
            goto L2d
        L48:
            double r4 = (double) r4
            double r2 = (double) r3
            double r2 = java.lang.Math.atan2(r4, r2)
            float r0 = (float) r2
            r2 = 1086918618(0x40c90fda, float:6.283185)
            float r0 = r0 / r2
            r2 = 0
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 >= 0) goto L5b
            r2 = 1065353216(0x3f800000, float:1.0)
            float r0 = r0 + r2
        L5b:
            android.graphics.Paint r2 = r9.f11440b
            int[] r3 = r9.f11441c
            int r0 = r9.m10944a(r3, r0)
            r2.setColor(r0)
            com.sec.chaton.util.ah r0 = r9.f11442d
            android.graphics.Paint r2 = r9.f11440b
            int r2 = r2.getColor()
            r0.m11032a(r2)
            r9.invalidate()
            goto L2d
        L75:
            if (r0 == 0) goto L82
            com.sec.chaton.util.ai r0 = r9.f11443e
            android.graphics.Paint r3 = r9.f11440b
            int r3 = r3.getColor()
            r0.m11033a(r3)
        L82:
            com.sec.chaton.util.ah r0 = r9.f11442d
            android.graphics.Paint r3 = r9.f11440b
            int r3 = r3.getColor()
            r0.m11032a(r3)
            r9.f11448j = r2
            r9.invalidate()
            goto L2d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.util.ColorSelector.onTouchEvent(android.view.MotionEvent):boolean");
    }
}
