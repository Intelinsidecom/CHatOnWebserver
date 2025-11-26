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
    private Paint f3658a;

    /* renamed from: b */
    private Shader f3659b;

    /* renamed from: c */
    private int[] f3660c;

    /* renamed from: d */
    private float f3661d;

    /* renamed from: e */
    private PorterDuffXfermode f3662e;

    /* renamed from: f */
    private OnSliderColorChangedListener f3663f;

    public interface OnSliderColorChangedListener {
        /* renamed from: a */
        void m3563a(ColorSlider colorSlider, int i, float f);
    }

    public ColorSlider(Context context) {
        super(context);
        m3561a();
    }

    public ColorSlider(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m3561a();
    }

    public ColorSlider(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m3561a();
    }

    /* renamed from: a */
    private int m3559a(int i, int i2, float f) {
        return Math.round((i2 - i) * f) + i;
    }

    /* renamed from: a */
    private int m3560a(int[] iArr, float f) {
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
        return Color.argb(m3559a(Color.alpha(i2), Color.alpha(i3), f2), m3559a(Color.red(i2), Color.red(i3), f2), m3559a(Color.green(i2), Color.green(i3), f2), m3559a(Color.blue(i2), Color.blue(i3), f2));
    }

    /* renamed from: a */
    void m3561a() {
        this.f3660c = new int[2];
        this.f3660c[0] = -16777216;
        this.f3660c[1] = -1;
        this.f3661d = 1.0f;
        this.f3658a = new Paint(1);
        this.f3658a.setStyle(Paint.Style.FILL);
        this.f3659b = new LinearGradient(0.0f, 0.0f, getWidth(), 0.0f, this.f3660c[0], this.f3660c[1], Shader.TileMode.CLAMP);
        this.f3662e = new PorterDuffXfermode(PorterDuff.Mode.XOR);
    }

    /* renamed from: b */
    int m3562b() {
        return m3560a(this.f3660c, this.f3661d);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.f3658a.setShader(this.f3659b);
        this.f3658a.setStyle(Paint.Style.FILL);
        canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.f3658a);
        float width = this.f3661d * getWidth();
        this.f3658a.setShader(null);
        this.f3658a.setColor(-1);
        this.f3658a.setStyle(Paint.Style.STROKE);
        this.f3658a.setXfermode(this.f3662e);
        canvas.drawRect(width - 1.0f, 0.0f, width + 1.0f, getHeight() - 1, this.f3658a);
        canvas.drawRect(width - 2.0f, 1.0f, width + 2.0f, getHeight() - 2, this.f3658a);
        this.f3658a.reset();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(((int) Dip.m3571a(100.0f)) * 2, (int) Dip.m3571a(27.0f));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i3 == 0 && i4 == 0) {
            this.f3659b = null;
            this.f3659b = new LinearGradient(0.0f, 0.0f, getWidth(), getHeight(), this.f3660c, (float[]) null, Shader.TileMode.CLAMP);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
            case 2:
                float width = x / getWidth();
                int iM3560a = m3560a(this.f3660c, width);
                if (this.f3663f != null) {
                    this.f3663f.m3563a(this, iM3560a, width);
                }
                this.f3661d = width;
                invalidate();
                break;
        }
        return true;
    }

    public void setColors(int i, int i2) {
        this.f3660c = null;
        this.f3660c = new int[2];
        this.f3660c[0] = i;
        this.f3660c[1] = i2;
        Log.d("ColorSlider", "setColors : " + getWidth() + "-" + getHeight());
        this.f3659b = null;
        this.f3659b = new LinearGradient(0.0f, 0.0f, getWidth(), 0.0f, this.f3660c[0], this.f3660c[1], Shader.TileMode.CLAMP);
        invalidate();
    }

    public void setColors(int[] iArr) {
        this.f3660c = null;
        this.f3660c = (int[]) iArr.clone();
        Log.d("ColorSlider", "setColors : " + getWidth() + "-" + getHeight());
        this.f3659b = null;
        this.f3659b = new LinearGradient(0.0f, 0.0f, getWidth(), 0.0f, this.f3660c, (float[]) null, Shader.TileMode.CLAMP);
        invalidate();
    }

    public void setSliderColorChangedListener(OnSliderColorChangedListener onSliderColorChangedListener) {
        this.f3663f = onSliderColorChangedListener;
    }
}
