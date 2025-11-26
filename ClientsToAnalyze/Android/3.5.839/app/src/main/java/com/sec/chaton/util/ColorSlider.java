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
import com.sec.common.util.C5034k;

/* loaded from: classes.dex */
public class ColorSlider extends View {

    /* renamed from: a */
    private Paint f17551a;

    /* renamed from: b */
    private Shader f17552b;

    /* renamed from: c */
    private int[] f17553c;

    /* renamed from: d */
    private float f17554d;

    /* renamed from: e */
    private PorterDuffXfermode f17555e;

    /* renamed from: f */
    private InterfaceC4819ak f17556f;

    public ColorSlider(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m18092a();
    }

    public ColorSlider(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m18092a();
    }

    public ColorSlider(Context context) {
        super(context);
        m18092a();
    }

    /* renamed from: a */
    void m18092a() {
        this.f17553c = new int[2];
        this.f17553c[0] = -16777216;
        this.f17553c[1] = -1;
        this.f17554d = 1.0f;
        this.f17551a = new Paint(1);
        this.f17551a.setStyle(Paint.Style.FILL);
        this.f17552b = new LinearGradient(0.0f, 0.0f, getWidth(), 0.0f, this.f17553c[0], this.f17553c[1], Shader.TileMode.CLAMP);
        this.f17555e = new PorterDuffXfermode(PorterDuff.Mode.XOR);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.f17551a.setShader(this.f17552b);
        this.f17551a.setStyle(Paint.Style.FILL);
        canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.f17551a);
        float width = this.f17554d * getWidth();
        this.f17551a.setShader(null);
        this.f17551a.setColor(-1);
        this.f17551a.setStyle(Paint.Style.STROKE);
        this.f17551a.setXfermode(this.f17555e);
        canvas.drawRect(width - 1.0f, 0.0f, width + 1.0f, getHeight() - 1, this.f17551a);
        canvas.drawRect(width - 2.0f, 1.0f, width + 2.0f, getHeight() - 2, this.f17551a);
        this.f17551a.reset();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(((int) C5034k.m19088a(100.0f)) * 2, (int) C5034k.m19088a(27.0f));
    }

    public void setColors(int i, int i2) {
        this.f17553c = null;
        this.f17553c = new int[2];
        this.f17553c[0] = i;
        this.f17553c[1] = i2;
        Log.d("ColorSlider", "setColors : " + getWidth() + "-" + getHeight());
        this.f17552b = null;
        this.f17552b = new LinearGradient(0.0f, 0.0f, getWidth(), 0.0f, this.f17553c[0], this.f17553c[1], Shader.TileMode.CLAMP);
        invalidate();
    }

    public void setColors(int[] iArr) {
        this.f17553c = null;
        this.f17553c = (int[]) iArr.clone();
        Log.d("ColorSlider", "setColors : " + getWidth() + "-" + getHeight());
        this.f17552b = null;
        this.f17552b = new LinearGradient(0.0f, 0.0f, getWidth(), 0.0f, this.f17553c, (float[]) null, Shader.TileMode.CLAMP);
        invalidate();
    }

    public void setSliderColorChangedListener(InterfaceC4819ak interfaceC4819ak) {
        this.f17556f = interfaceC4819ak;
    }

    /* renamed from: a */
    private int m18090a(int i, int i2, float f) {
        return Math.round((i2 - i) * f) + i;
    }

    /* renamed from: a */
    private int m18091a(int[] iArr, float f) {
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
        return Color.argb(m18090a(Color.alpha(i2), Color.alpha(i3), f2), m18090a(Color.red(i2), Color.red(i3), f2), m18090a(Color.green(i2), Color.green(i3), f2), m18090a(Color.blue(i2), Color.blue(i3), f2));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        switch (motionEvent.getAction()) {
            case 0:
            case 2:
                float width = x / getWidth();
                int iM18091a = m18091a(this.f17553c, width);
                if (this.f17556f != null) {
                    this.f17556f.m18180a(this, iM18091a, width);
                }
                this.f17554d = width;
                invalidate();
                break;
        }
        return true;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i3 == 0 && i4 == 0) {
            this.f17552b = null;
            this.f17552b = new LinearGradient(0.0f, 0.0f, getWidth(), getHeight(), this.f17553c, (float[]) null, Shader.TileMode.CLAMP);
        }
    }
}
