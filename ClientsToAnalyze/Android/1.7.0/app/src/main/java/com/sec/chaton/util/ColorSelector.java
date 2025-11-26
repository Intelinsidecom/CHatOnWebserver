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
    private Paint f4404a;

    /* renamed from: b */
    private Paint f4405b;

    /* renamed from: c */
    private int[] f4406c;

    /* renamed from: d */
    private InterfaceC1300aw f4407d;

    /* renamed from: e */
    private InterfaceC1278aa f4408e;

    /* renamed from: f */
    private int f4409f;

    /* renamed from: g */
    private int f4410g;

    /* renamed from: h */
    private int f4411h;

    /* renamed from: i */
    private int f4412i;

    /* renamed from: j */
    private boolean f4413j;

    /* renamed from: k */
    private boolean f4414k;

    public ColorSelector(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m4452a();
    }

    public ColorSelector(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m4452a();
    }

    public ColorSelector(Context context) {
        super(context);
        m4452a();
    }

    /* renamed from: a */
    void m4452a() {
        this.f4406c = new int[]{-65536, -65281, -16776961, -16711681, -16711936, -256, -65536};
        SweepGradient sweepGradient = new SweepGradient(0.0f, 0.0f, this.f4406c, (float[]) null);
        this.f4404a = new Paint(1);
        this.f4404a.setShader(sweepGradient);
        this.f4404a.setStyle(Paint.Style.STROKE);
        this.f4404a.setStrokeWidth(C1301ax.m4544a(32.0f));
        this.f4405b = new Paint(1);
        this.f4405b.setStrokeWidth(C1301ax.m4544a(5.0f));
        this.f4409f = (int) C1301ax.m4544a(100.0f);
        this.f4410g = (int) C1301ax.m4544a(100.0f);
        this.f4411h = (int) C1301ax.m4544a(32.0f);
    }

    public void setInitialColor(int i) {
        this.f4412i = i;
        this.f4405b.setColor(this.f4412i);
    }

    public void setColorPickerChangedListener(InterfaceC1300aw interfaceC1300aw) {
        this.f4407d = interfaceC1300aw;
    }

    public void setColorPickerSelectedListener(InterfaceC1278aa interfaceC1278aa) {
        this.f4408e = interfaceC1278aa;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float strokeWidth = this.f4409f - (this.f4404a.getStrokeWidth() * 0.5f);
        canvas.translate(this.f4409f, this.f4409f);
        canvas.drawOval(new RectF(-strokeWidth, -strokeWidth, strokeWidth, strokeWidth), this.f4404a);
        canvas.drawCircle(0.0f, 0.0f, this.f4411h, this.f4405b);
        if (this.f4413j) {
            int color = this.f4405b.getColor();
            this.f4405b.setStyle(Paint.Style.STROKE);
            if (this.f4414k) {
                this.f4405b.setAlpha(MotionEventCompat.ACTION_MASK);
            } else {
                this.f4405b.setAlpha(128);
            }
            canvas.drawCircle(0.0f, 0.0f, this.f4411h + this.f4405b.getStrokeWidth(), this.f4405b);
            this.f4405b.setStyle(Paint.Style.FILL);
            this.f4405b.setColor(color);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(this.f4409f * 2, this.f4410g * 2);
    }

    /* renamed from: a */
    private int m4450a(int i, int i2, float f) {
        return Math.round((i2 - i) * f) + i;
    }

    /* renamed from: a */
    private int m4451a(int[] iArr, float f) {
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
        return Color.argb(m4450a(Color.alpha(i2), Color.alpha(i3), f2), m4450a(Color.red(i2), Color.red(i3), f2), m4450a(Color.green(i2), Color.green(i3), f2), m4450a(Color.blue(i2), Color.blue(i3), f2));
    }

    public void setColor(int i) {
        this.f4413j = true;
        this.f4405b.setColor(i);
        invalidate();
        this.f4413j = false;
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
            int r3 = r9.f4409f
            float r3 = (float) r3
            float r3 = r0 - r3
            float r0 = r10.getY()
            int r4 = r9.f4410g
            float r4 = (float) r4
            float r4 = r0 - r4
            float r0 = r3 * r3
            float r5 = r4 * r4
            float r0 = r0 + r5
            double r5 = (double) r0
            double r5 = java.lang.Math.sqrt(r5)
            int r0 = r9.f4411h
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
            r9.f4413j = r0
            if (r0 == 0) goto L3a
            r9.f4414k = r1
            r9.invalidate()
            goto L2d
        L3a:
            boolean r2 = r9.f4413j
            if (r2 == 0) goto L48
            boolean r2 = r9.f4414k
            if (r2 == r0) goto L2d
            r9.f4414k = r0
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
            android.graphics.Paint r2 = r9.f4405b
            int[] r3 = r9.f4406c
            int r0 = r9.m4451a(r3, r0)
            r2.setColor(r0)
            com.sec.chaton.util.aw r0 = r9.f4407d
            android.graphics.Paint r2 = r9.f4405b
            int r2 = r2.getColor()
            r0.m4543a(r2)
            r9.invalidate()
            goto L2d
        L75:
            if (r0 == 0) goto L82
            com.sec.chaton.util.aa r0 = r9.f4408e
            android.graphics.Paint r3 = r9.f4405b
            int r3 = r3.getColor()
            r0.m4489a(r3)
        L82:
            com.sec.chaton.util.aw r0 = r9.f4407d
            android.graphics.Paint r3 = r9.f4405b
            int r3 = r3.getColor()
            r0.m4543a(r3)
            r9.f4413j = r2
            r9.invalidate()
            goto L2d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.util.ColorSelector.onTouchEvent(android.view.MotionEvent):boolean");
    }
}
