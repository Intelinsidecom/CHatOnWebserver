package com.sec.chaton.util;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;
import com.sec.common.util.C5034k;

/* loaded from: classes.dex */
public class ColorSelector extends View {

    /* renamed from: a */
    private Paint f17540a;

    /* renamed from: b */
    private Paint f17541b;

    /* renamed from: c */
    private int[] f17542c;

    /* renamed from: d */
    private InterfaceC4817ai f17543d;

    /* renamed from: e */
    private InterfaceC4818aj f17544e;

    /* renamed from: f */
    private int f17545f;

    /* renamed from: g */
    private int f17546g;

    /* renamed from: h */
    private int f17547h;

    /* renamed from: i */
    private int f17548i;

    /* renamed from: j */
    private boolean f17549j;

    /* renamed from: k */
    private boolean f17550k;

    public ColorSelector(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m18089a();
    }

    public ColorSelector(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m18089a();
    }

    public ColorSelector(Context context) {
        super(context);
        m18089a();
    }

    /* renamed from: a */
    void m18089a() {
        this.f17542c = new int[]{-65536, -65281, -16776961, -16711681, -16711936, -256, -65536};
        SweepGradient sweepGradient = new SweepGradient(0.0f, 0.0f, this.f17542c, (float[]) null);
        this.f17540a = new Paint(1);
        this.f17540a.setShader(sweepGradient);
        this.f17540a.setStyle(Paint.Style.STROKE);
        this.f17540a.setStrokeWidth(C5034k.m19088a(32.0f));
        this.f17541b = new Paint(1);
        this.f17541b.setStrokeWidth(C5034k.m19088a(5.0f));
        this.f17545f = (int) C5034k.m19088a(100.0f);
        this.f17546g = (int) C5034k.m19088a(100.0f);
        this.f17547h = (int) C5034k.m19088a(32.0f);
    }

    public void setInitialColor(int i) {
        this.f17548i = i;
        this.f17541b.setColor(this.f17548i);
    }

    public void setColorPickerChangedListener(InterfaceC4817ai interfaceC4817ai) {
        this.f17543d = interfaceC4817ai;
    }

    public void setColorPickerSelectedListener(InterfaceC4818aj interfaceC4818aj) {
        this.f17544e = interfaceC4818aj;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float strokeWidth = this.f17545f - (this.f17540a.getStrokeWidth() * 0.5f);
        canvas.translate(this.f17545f, this.f17545f);
        canvas.drawOval(new RectF(-strokeWidth, -strokeWidth, strokeWidth, strokeWidth), this.f17540a);
        canvas.drawCircle(0.0f, 0.0f, this.f17547h, this.f17541b);
        if (this.f17549j) {
            int color = this.f17541b.getColor();
            this.f17541b.setStyle(Paint.Style.STROKE);
            if (this.f17550k) {
                this.f17541b.setAlpha(255);
            } else {
                this.f17541b.setAlpha(128);
            }
            canvas.drawCircle(0.0f, 0.0f, this.f17547h + this.f17541b.getStrokeWidth(), this.f17541b);
            this.f17541b.setStyle(Paint.Style.FILL);
            this.f17541b.setColor(color);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(this.f17545f * 2, this.f17546g * 2);
    }

    /* renamed from: a */
    private int m18087a(int i, int i2, float f) {
        return Math.round((i2 - i) * f) + i;
    }

    /* renamed from: a */
    private int m18088a(int[] iArr, float f) {
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
        return Color.argb(m18087a(Color.alpha(i2), Color.alpha(i3), f2), m18087a(Color.red(i2), Color.red(i3), f2), m18087a(Color.green(i2), Color.green(i3), f2), m18087a(Color.blue(i2), Color.blue(i3), f2));
    }

    public void setColor(int i) {
        this.f17549j = true;
        this.f17541b.setColor(i);
        invalidate();
        this.f17549j = false;
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
            int r3 = r9.f17545f
            float r3 = (float) r3
            float r3 = r0 - r3
            float r0 = r10.getY()
            int r4 = r9.f17546g
            float r4 = (float) r4
            float r4 = r0 - r4
            float r0 = r3 * r3
            float r5 = r4 * r4
            float r0 = r0 + r5
            double r5 = (double) r0
            double r5 = java.lang.Math.sqrt(r5)
            int r0 = r9.f17547h
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
            r9.f17549j = r0
            if (r0 == 0) goto L3a
            r9.f17550k = r1
            r9.invalidate()
            goto L2d
        L3a:
            boolean r2 = r9.f17549j
            if (r2 == 0) goto L48
            boolean r2 = r9.f17550k
            if (r2 == r0) goto L2d
            r9.f17550k = r0
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
            android.graphics.Paint r2 = r9.f17541b
            int[] r3 = r9.f17542c
            int r0 = r9.m18088a(r3, r0)
            r2.setColor(r0)
            com.sec.chaton.util.ai r0 = r9.f17543d
            android.graphics.Paint r2 = r9.f17541b
            int r2 = r2.getColor()
            r0.m18178a(r2)
            r9.invalidate()
            goto L2d
        L75:
            if (r0 == 0) goto L82
            com.sec.chaton.util.aj r0 = r9.f17544e
            android.graphics.Paint r3 = r9.f17541b
            int r3 = r3.getColor()
            r0.m18179a(r3)
        L82:
            com.sec.chaton.util.ai r0 = r9.f17543d
            android.graphics.Paint r3 = r9.f17541b
            int r3 = r3.getColor()
            r0.m18178a(r3)
            r9.f17549j = r2
            r9.invalidate()
            goto L2d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.util.ColorSelector.onTouchEvent(android.view.MotionEvent):boolean");
    }
}
