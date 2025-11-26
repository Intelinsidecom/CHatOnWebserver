package com.sec.chaton.util;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: classes.dex */
public class ColorSelector extends View {

    /* renamed from: a */
    private Paint f3647a;

    /* renamed from: b */
    private Paint f3648b;

    /* renamed from: c */
    private int[] f3649c;

    /* renamed from: d */
    private OnColorChangedListener f3650d;

    /* renamed from: e */
    private OnColorSelectedListener f3651e;

    /* renamed from: f */
    private int f3652f;

    /* renamed from: g */
    private int f3653g;

    /* renamed from: h */
    private int f3654h;

    /* renamed from: i */
    private int f3655i;

    /* renamed from: j */
    private boolean f3656j;

    /* renamed from: k */
    private boolean f3657k;

    public interface OnColorChangedListener {
        /* renamed from: a */
        void m3557a(int i);
    }

    public interface OnColorSelectedListener {
        /* renamed from: a */
        void m3558a(int i);
    }

    public ColorSelector(Context context) {
        super(context);
        m3556a();
    }

    public ColorSelector(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m3556a();
    }

    public ColorSelector(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m3556a();
    }

    /* renamed from: a */
    private int m3554a(int i, int i2, float f) {
        return Math.round((i2 - i) * f) + i;
    }

    /* renamed from: a */
    private int m3555a(int[] iArr, float f) {
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
        return Color.argb(m3554a(Color.alpha(i2), Color.alpha(i3), f2), m3554a(Color.red(i2), Color.red(i3), f2), m3554a(Color.green(i2), Color.green(i3), f2), m3554a(Color.blue(i2), Color.blue(i3), f2));
    }

    /* renamed from: a */
    void m3556a() {
        this.f3649c = new int[]{-65536, -65281, -16776961, -16711681, -16711936, -256, -65536};
        SweepGradient sweepGradient = new SweepGradient(0.0f, 0.0f, this.f3649c, (float[]) null);
        this.f3647a = new Paint(1);
        this.f3647a.setShader(sweepGradient);
        this.f3647a.setStyle(Paint.Style.STROKE);
        this.f3647a.setStrokeWidth(Dip.m3571a(32.0f));
        this.f3648b = new Paint(1);
        this.f3648b.setStrokeWidth(Dip.m3571a(5.0f));
        this.f3652f = (int) Dip.m3571a(100.0f);
        this.f3653g = (int) Dip.m3571a(100.0f);
        this.f3654h = (int) Dip.m3571a(32.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float strokeWidth = this.f3652f - (this.f3647a.getStrokeWidth() * 0.5f);
        canvas.translate(this.f3652f, this.f3652f);
        canvas.drawOval(new RectF(-strokeWidth, -strokeWidth, strokeWidth, strokeWidth), this.f3647a);
        canvas.drawCircle(0.0f, 0.0f, this.f3654h, this.f3648b);
        if (this.f3656j) {
            int color = this.f3648b.getColor();
            this.f3648b.setStyle(Paint.Style.STROKE);
            if (this.f3657k) {
                this.f3648b.setAlpha(255);
            } else {
                this.f3648b.setAlpha(128);
            }
            canvas.drawCircle(0.0f, 0.0f, this.f3654h + this.f3648b.getStrokeWidth(), this.f3648b);
            this.f3648b.setStyle(Paint.Style.FILL);
            this.f3648b.setColor(color);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(this.f3652f * 2, this.f3653g * 2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0038  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r9) {
        /*
            r8 = this;
            r7 = 0
            r6 = 1
            float r0 = r9.getX()
            int r1 = r8.f3652f
            float r1 = (float) r1
            float r0 = r0 - r1
            float r1 = r9.getY()
            int r2 = r8.f3653g
            float r2 = (float) r2
            float r1 = r1 - r2
            float r2 = r0 * r0
            float r3 = r1 * r1
            float r2 = r2 + r3
            double r2 = (double) r2
            double r2 = java.lang.Math.sqrt(r2)
            int r4 = r8.f3654h
            double r4 = (double) r4
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 > 0) goto L2c
            r2 = r6
        L24:
            int r3 = r9.getAction()
            switch(r3) {
                case 0: goto L2e;
                case 1: goto L73;
                case 2: goto L38;
                default: goto L2b;
            }
        L2b:
            return r6
        L2c:
            r2 = r7
            goto L24
        L2e:
            r8.f3656j = r2
            if (r2 == 0) goto L38
            r8.f3657k = r6
            r8.invalidate()
            goto L2b
        L38:
            boolean r3 = r8.f3656j
            if (r3 == 0) goto L46
            boolean r0 = r8.f3657k
            if (r0 == r2) goto L2b
            r8.f3657k = r2
            r8.invalidate()
            goto L2b
        L46:
            double r1 = (double) r1
            double r3 = (double) r0
            double r0 = java.lang.Math.atan2(r1, r3)
            float r0 = (float) r0
            r1 = 1086918618(0x40c90fda, float:6.283185)
            float r0 = r0 / r1
            r1 = 0
            int r1 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r1 >= 0) goto L59
            r1 = 1065353216(0x3f800000, float:1.0)
            float r0 = r0 + r1
        L59:
            android.graphics.Paint r1 = r8.f3648b
            int[] r2 = r8.f3649c
            int r0 = r8.m3555a(r2, r0)
            r1.setColor(r0)
            com.sec.chaton.util.ColorSelector$OnColorChangedListener r0 = r8.f3650d
            android.graphics.Paint r1 = r8.f3648b
            int r1 = r1.getColor()
            r0.m3557a(r1)
            r8.invalidate()
            goto L2b
        L73:
            if (r2 == 0) goto L80
            com.sec.chaton.util.ColorSelector$OnColorSelectedListener r0 = r8.f3651e
            android.graphics.Paint r1 = r8.f3648b
            int r1 = r1.getColor()
            r0.m3558a(r1)
        L80:
            com.sec.chaton.util.ColorSelector$OnColorChangedListener r0 = r8.f3650d
            android.graphics.Paint r1 = r8.f3648b
            int r1 = r1.getColor()
            r0.m3557a(r1)
            r8.f3656j = r7
            r8.invalidate()
            goto L2b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.util.ColorSelector.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setColor(int i) {
        this.f3656j = true;
        this.f3648b.setColor(i);
        invalidate();
        this.f3656j = false;
    }

    public void setColorPickerChangedListener(OnColorChangedListener onColorChangedListener) {
        this.f3650d = onColorChangedListener;
    }

    public void setColorPickerSelectedListener(OnColorSelectedListener onColorSelectedListener) {
        this.f3651e = onColorSelectedListener;
    }

    public void setInitialColor(int i) {
        this.f3655i = i;
        this.f3648b.setColor(this.f3655i);
    }
}
