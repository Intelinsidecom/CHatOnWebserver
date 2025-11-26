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
    private Paint f6272a;

    /* renamed from: b */
    private Shader f6273b;

    /* renamed from: c */
    private int[] f6274c;

    /* renamed from: d */
    private float f6275d;

    /* renamed from: e */
    private PorterDuffXfermode f6276e;

    /* renamed from: f */
    private InterfaceC1720ac f6277f;

    public ColorSlider(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m5837a();
    }

    public ColorSlider(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m5837a();
    }

    public ColorSlider(Context context) {
        super(context);
        m5837a();
    }

    /* renamed from: a */
    void m5837a() {
        this.f6274c = new int[2];
        this.f6274c[0] = -16777216;
        this.f6274c[1] = -1;
        this.f6275d = 1.0f;
        this.f6272a = new Paint(1);
        this.f6272a.setStyle(Paint.Style.FILL);
        this.f6273b = new LinearGradient(0.0f, 0.0f, getWidth(), 0.0f, this.f6274c[0], this.f6274c[1], Shader.TileMode.CLAMP);
        this.f6276e = new PorterDuffXfermode(PorterDuff.Mode.XOR);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.f6272a.setShader(this.f6273b);
        this.f6272a.setStyle(Paint.Style.FILL);
        canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.f6272a);
        float width = this.f6275d * getWidth();
        this.f6272a.setShader(null);
        this.f6272a.setColor(-1);
        this.f6272a.setStyle(Paint.Style.STROKE);
        this.f6272a.setXfermode(this.f6276e);
        canvas.drawRect(width - 1.0f, 0.0f, width + 1.0f, getHeight() - 1, this.f6272a);
        canvas.drawRect(width - 2.0f, 1.0f, width + 2.0f, getHeight() - 2, this.f6272a);
        this.f6272a.reset();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(((int) C1722ae.m5894a(100.0f)) * 2, (int) C1722ae.m5894a(27.0f));
    }

    public void setColors(int i, int i2) {
        this.f6274c = null;
        this.f6274c = new int[2];
        this.f6274c[0] = i;
        this.f6274c[1] = i2;
        Log.d("ColorSlider", "setColors : " + getWidth() + "-" + getHeight());
        this.f6273b = null;
        this.f6273b = new LinearGradient(0.0f, 0.0f, getWidth(), 0.0f, this.f6274c[0], this.f6274c[1], Shader.TileMode.CLAMP);
        invalidate();
    }

    public void setColors(int[] iArr) {
        this.f6274c = null;
        this.f6274c = (int[]) iArr.clone();
        Log.d("ColorSlider", "setColors : " + getWidth() + "-" + getHeight());
        this.f6273b = null;
        this.f6273b = new LinearGradient(0.0f, 0.0f, getWidth(), 0.0f, this.f6274c, (float[]) null, Shader.TileMode.CLAMP);
        invalidate();
    }

    public void setSliderColorChangedListener(InterfaceC1720ac interfaceC1720ac) {
        this.f6277f = interfaceC1720ac;
    }

    /* renamed from: a */
    private int m5835a(int i, int i2, float f) {
        return Math.round((i2 - i) * f) + i;
    }

    /* renamed from: a */
    private int m5836a(int[] iArr, float f) {
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
        return Color.argb(m5835a(Color.alpha(i2), Color.alpha(i3), f2), m5835a(Color.red(i2), Color.red(i3), f2), m5835a(Color.green(i2), Color.green(i3), f2), m5835a(Color.blue(i2), Color.blue(i3), f2));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
            case 2:
                float width = x / getWidth();
                int iM5836a = m5836a(this.f6274c, width);
                if (this.f6277f != null) {
                    this.f6277f.m5872a(this, iM5836a, width);
                }
                this.f6275d = width;
                invalidate();
                break;
        }
        return true;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i3 == 0 && i4 == 0) {
            this.f6273b = null;
            this.f6273b = new LinearGradient(0.0f, 0.0f, getWidth(), getHeight(), this.f6274c, (float[]) null, Shader.TileMode.CLAMP);
        }
    }
}
