package com.sec.chaton.util;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: classes.dex */
public class ColorSelector extends View {

    /* renamed from: a */
    private Paint f6261a;

    /* renamed from: b */
    private Paint f6262b;

    /* renamed from: c */
    private int[] f6263c;

    /* renamed from: d */
    private InterfaceC1718aa f6264d;

    /* renamed from: e */
    private InterfaceC1719ab f6265e;

    /* renamed from: f */
    private int f6266f;

    /* renamed from: g */
    private int f6267g;

    /* renamed from: h */
    private int f6268h;

    /* renamed from: i */
    private int f6269i;

    /* renamed from: j */
    private boolean f6270j;

    /* renamed from: k */
    private boolean f6271k;

    public ColorSelector(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m5834a();
    }

    public ColorSelector(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m5834a();
    }

    public ColorSelector(Context context) {
        super(context);
        m5834a();
    }

    /* renamed from: a */
    void m5834a() {
        this.f6263c = new int[]{-65536, -65281, -16776961, -16711681, -16711936, -256, -65536};
        SweepGradient sweepGradient = new SweepGradient(0.0f, 0.0f, this.f6263c, (float[]) null);
        this.f6261a = new Paint(1);
        this.f6261a.setShader(sweepGradient);
        this.f6261a.setStyle(Paint.Style.STROKE);
        this.f6261a.setStrokeWidth(C1722ae.m5894a(32.0f));
        this.f6262b = new Paint(1);
        this.f6262b.setStrokeWidth(C1722ae.m5894a(5.0f));
        this.f6266f = (int) C1722ae.m5894a(100.0f);
        this.f6267g = (int) C1722ae.m5894a(100.0f);
        this.f6268h = (int) C1722ae.m5894a(32.0f);
    }

    public void setInitialColor(int i) {
        this.f6269i = i;
        this.f6262b.setColor(this.f6269i);
    }

    public void setColorPickerChangedListener(InterfaceC1718aa interfaceC1718aa) {
        this.f6264d = interfaceC1718aa;
    }

    public void setColorPickerSelectedListener(InterfaceC1719ab interfaceC1719ab) {
        this.f6265e = interfaceC1719ab;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float strokeWidth = this.f6266f - (this.f6261a.getStrokeWidth() * 0.5f);
        canvas.translate(this.f6266f, this.f6266f);
        canvas.drawOval(new RectF(-strokeWidth, -strokeWidth, strokeWidth, strokeWidth), this.f6261a);
        canvas.drawCircle(0.0f, 0.0f, this.f6268h, this.f6262b);
        if (this.f6270j) {
            int color = this.f6262b.getColor();
            this.f6262b.setStyle(Paint.Style.STROKE);
            if (this.f6271k) {
                this.f6262b.setAlpha(MotionEventCompat.ACTION_MASK);
            } else {
                this.f6262b.setAlpha(AccessibilityEventCompat.TYPE_VIEW_HOVER_ENTER);
            }
            canvas.drawCircle(0.0f, 0.0f, this.f6268h + this.f6262b.getStrokeWidth(), this.f6262b);
            this.f6262b.setStyle(Paint.Style.FILL);
            this.f6262b.setColor(color);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(this.f6266f * 2, this.f6267g * 2);
    }

    /* renamed from: a */
    private int m5832a(int i, int i2, float f) {
        return Math.round((i2 - i) * f) + i;
    }

    /* renamed from: a */
    private int m5833a(int[] iArr, float f) {
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
        return Color.argb(m5832a(Color.alpha(i2), Color.alpha(i3), f2), m5832a(Color.red(i2), Color.red(i3), f2), m5832a(Color.green(i2), Color.green(i3), f2), m5832a(Color.blue(i2), Color.blue(i3), f2));
    }

    public void setColor(int i) {
        this.f6270j = true;
        this.f6262b.setColor(i);
        invalidate();
        this.f6270j = false;
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
            int r3 = r9.f6266f
            float r3 = (float) r3
            float r3 = r0 - r3
            float r0 = r10.getY()
            int r4 = r9.f6267g
            float r4 = (float) r4
            float r4 = r0 - r4
            float r0 = r3 * r3
            float r5 = r4 * r4
            float r0 = r0 + r5
            double r5 = (double) r0
            double r5 = java.lang.Math.sqrt(r5)
            int r0 = r9.f6268h
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
            r9.f6270j = r0
            if (r0 == 0) goto L3a
            r9.f6271k = r1
            r9.invalidate()
            goto L2d
        L3a:
            boolean r2 = r9.f6270j
            if (r2 == 0) goto L48
            boolean r2 = r9.f6271k
            if (r2 == r0) goto L2d
            r9.f6271k = r0
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
            android.graphics.Paint r2 = r9.f6262b
            int[] r3 = r9.f6263c
            int r0 = r9.m5833a(r3, r0)
            r2.setColor(r0)
            com.sec.chaton.util.aa r0 = r9.f6264d
            android.graphics.Paint r2 = r9.f6262b
            int r2 = r2.getColor()
            r0.m5870a(r2)
            r9.invalidate()
            goto L2d
        L75:
            if (r0 == 0) goto L82
            com.sec.chaton.util.ab r0 = r9.f6265e
            android.graphics.Paint r3 = r9.f6262b
            int r3 = r3.getColor()
            r0.m5871a(r3)
        L82:
            com.sec.chaton.util.aa r0 = r9.f6264d
            android.graphics.Paint r3 = r9.f6262b
            int r3 = r3.getColor()
            r0.m5870a(r3)
            r9.f6270j = r2
            r9.invalidate()
            goto L2d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.util.ColorSelector.onTouchEvent(android.view.MotionEvent):boolean");
    }
}
