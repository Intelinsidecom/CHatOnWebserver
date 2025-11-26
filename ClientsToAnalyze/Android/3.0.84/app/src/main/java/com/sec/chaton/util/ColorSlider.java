package com.sec.chaton.util;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/* loaded from: classes.dex */
public class ColorSlider extends View {

    /* renamed from: a */
    private Paint f11450a;

    /* renamed from: b */
    private Shader f11451b;

    /* renamed from: c */
    private int[] f11452c;

    /* renamed from: d */
    private float f11453d;

    /* renamed from: e */
    private PorterDuffXfermode f11454e;

    /* renamed from: f */
    private InterfaceC3168aj f11455f;

    public ColorSlider(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m10948a();
    }

    public ColorSlider(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m10948a();
    }

    public ColorSlider(Context context) {
        super(context);
        m10948a();
    }

    /* renamed from: a */
    void m10948a() {
        this.f11452c = new int[2];
        this.f11452c[0] = -16777216;
        this.f11452c[1] = -1;
        this.f11453d = 1.0f;
        this.f11450a = new Paint(1);
        this.f11450a.setStyle(Paint.Style.FILL);
        this.f11451b = new LinearGradient(0.0f, 0.0f, getWidth(), 0.0f, this.f11452c[0], this.f11452c[1], Shader.TileMode.CLAMP);
        this.f11454e = new PorterDuffXfermode(PorterDuff.Mode.XOR);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.f11450a.setShader(this.f11451b);
        this.f11450a.setStyle(Paint.Style.FILL);
        canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.f11450a);
        float width = this.f11453d * getWidth();
        this.f11450a.setShader(null);
        this.f11450a.setColor(-1);
        this.f11450a.setStyle(Paint.Style.STROKE);
        this.f11450a.setXfermode(this.f11454e);
        canvas.drawRect(width - 1.0f, 0.0f, width + 1.0f, getHeight() - 1, this.f11450a);
        canvas.drawRect(width - 2.0f, 1.0f, width + 2.0f, getHeight() - 2, this.f11450a);
        this.f11450a.reset();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(((int) C3172an.m11085a(100.0f)) * 2, (int) C3172an.m11085a(27.0f));
    }

    public void setColors(int i, int i2) {
        this.f11452c = null;
        this.f11452c = new int[2];
        this.f11452c[0] = i;
        this.f11452c[1] = i2;
        Log.d("ColorSlider", "setColors : " + getWidth() + "-" + getHeight());
        this.f11451b = null;
        this.f11451b = new LinearGradient(0.0f, 0.0f, getWidth(), 0.0f, this.f11452c[0], this.f11452c[1], Shader.TileMode.CLAMP);
        invalidate();
    }

    public void setColors(int[] iArr) {
        this.f11452c = null;
        this.f11452c = (int[]) iArr.clone();
        Log.d("ColorSlider", "setColors : " + getWidth() + "-" + getHeight());
        this.f11451b = null;
        this.f11451b = new LinearGradient(0.0f, 0.0f, getWidth(), 0.0f, this.f11452c, (float[]) null, Shader.TileMode.CLAMP);
        invalidate();
    }

    public void setSliderColorChangedListener(InterfaceC3168aj interfaceC3168aj) {
        this.f11455f = interfaceC3168aj;
    }

    /* renamed from: a */
    private int m10946a(int i, int i2, float f) {
        return Math.round((i2 - i) * f) + i;
    }

    /* renamed from: a */
    private int m10947a(int[] iArr, float f) {
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
        return Color.argb(m10946a(Color.alpha(i2), Color.alpha(i3), f2), m10946a(Color.red(i2), Color.red(i3), f2), m10946a(Color.green(i2), Color.green(i3), f2), m10946a(Color.blue(i2), Color.blue(i3), f2));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        switch (motionEvent.getAction()) {
            case 0:
            case 2:
                float width = x / getWidth();
                int iM10947a = m10947a(this.f11452c, width);
                if (this.f11455f != null) {
                    this.f11455f.m11034a(this, iM10947a, width);
                }
                this.f11453d = width;
                invalidate();
                break;
        }
        return true;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i3 == 0 && i4 == 0) {
            this.f11451b = null;
            this.f11451b = new LinearGradient(0.0f, 0.0f, getWidth(), getHeight(), this.f11452c, (float[]) null, Shader.TileMode.CLAMP);
        }
    }
}
