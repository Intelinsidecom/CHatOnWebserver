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
    private Paint f4415a;

    /* renamed from: b */
    private Shader f4416b;

    /* renamed from: c */
    private int[] f4417c;

    /* renamed from: d */
    private float f4418d;

    /* renamed from: e */
    private PorterDuffXfermode f4419e;

    /* renamed from: f */
    private InterfaceC1328c f4420f;

    public ColorSlider(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m4455a();
    }

    public ColorSlider(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m4455a();
    }

    public ColorSlider(Context context) {
        super(context);
        m4455a();
    }

    /* renamed from: a */
    void m4455a() {
        this.f4417c = new int[2];
        this.f4417c[0] = -16777216;
        this.f4417c[1] = -1;
        this.f4418d = 1.0f;
        this.f4415a = new Paint(1);
        this.f4415a.setStyle(Paint.Style.FILL);
        this.f4416b = new LinearGradient(0.0f, 0.0f, getWidth(), 0.0f, this.f4417c[0], this.f4417c[1], Shader.TileMode.CLAMP);
        this.f4419e = new PorterDuffXfermode(PorterDuff.Mode.XOR);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.f4415a.setShader(this.f4416b);
        this.f4415a.setStyle(Paint.Style.FILL);
        canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.f4415a);
        float width = this.f4418d * getWidth();
        this.f4415a.setShader(null);
        this.f4415a.setColor(-1);
        this.f4415a.setStyle(Paint.Style.STROKE);
        this.f4415a.setXfermode(this.f4419e);
        canvas.drawRect(width - 1.0f, 0.0f, width + 1.0f, getHeight() - 1, this.f4415a);
        canvas.drawRect(width - 2.0f, 1.0f, width + 2.0f, getHeight() - 2, this.f4415a);
        this.f4415a.reset();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(((int) C1301ax.m4544a(100.0f)) * 2, (int) C1301ax.m4544a(27.0f));
    }

    public void setColors(int i, int i2) {
        this.f4417c = null;
        this.f4417c = new int[2];
        this.f4417c[0] = i;
        this.f4417c[1] = i2;
        Log.d("ColorSlider", "setColors : " + getWidth() + "-" + getHeight());
        this.f4416b = null;
        this.f4416b = new LinearGradient(0.0f, 0.0f, getWidth(), 0.0f, this.f4417c[0], this.f4417c[1], Shader.TileMode.CLAMP);
        invalidate();
    }

    public void setColors(int[] iArr) {
        this.f4417c = null;
        this.f4417c = (int[]) iArr.clone();
        Log.d("ColorSlider", "setColors : " + getWidth() + "-" + getHeight());
        this.f4416b = null;
        this.f4416b = new LinearGradient(0.0f, 0.0f, getWidth(), 0.0f, this.f4417c, (float[]) null, Shader.TileMode.CLAMP);
        invalidate();
    }

    public void setSliderColorChangedListener(InterfaceC1328c interfaceC1328c) {
        this.f4420f = interfaceC1328c;
    }

    /* renamed from: a */
    private int m4453a(int i, int i2, float f) {
        return Math.round((i2 - i) * f) + i;
    }

    /* renamed from: a */
    private int m4454a(int[] iArr, float f) {
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
        return Color.argb(m4453a(Color.alpha(i2), Color.alpha(i3), f2), m4453a(Color.red(i2), Color.red(i3), f2), m4453a(Color.green(i2), Color.green(i3), f2), m4453a(Color.blue(i2), Color.blue(i3), f2));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
            case 2:
                float width = x / getWidth();
                int iM4454a = m4454a(this.f4417c, width);
                if (this.f4420f != null) {
                    this.f4420f.m4598a(this, iM4454a, width);
                }
                this.f4418d = width;
                invalidate();
                break;
        }
        return true;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i3 == 0 && i4 == 0) {
            this.f4416b = null;
            this.f4416b = new LinearGradient(0.0f, 0.0f, getWidth(), getHeight(), this.f4417c, (float[]) null, Shader.TileMode.CLAMP);
        }
    }
}
