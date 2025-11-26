package com.sec.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.v4.view.AbstractC0144ae;
import android.support.v4.view.InterfaceC0196cc;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import com.sec.common.C4991e;

/* loaded from: classes.dex */
public class PagerPositionStrip2 extends View implements InterfaceC0196cc {

    /* renamed from: a */
    private ViewPager f18475a;

    /* renamed from: b */
    private AbstractC0144ae f18476b;

    /* renamed from: c */
    private int f18477c;

    /* renamed from: d */
    private int f18478d;

    /* renamed from: e */
    private int f18479e;

    /* renamed from: f */
    private int f18480f;

    /* renamed from: g */
    private int f18481g;

    /* renamed from: h */
    private int f18482h;

    /* renamed from: i */
    private Drawable f18483i;

    /* renamed from: j */
    private Drawable f18484j;

    /* renamed from: k */
    private Drawable f18485k;

    /* renamed from: l */
    private Drawable f18486l;

    /* renamed from: m */
    private Drawable f18487m;

    /* renamed from: n */
    private int f18488n;

    /* renamed from: o */
    private int f18489o;

    /* renamed from: p */
    private int f18490p;

    /* renamed from: q */
    private int f18491q;

    public PagerPositionStrip2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18489o = 0;
        this.f18490p = 0;
        this.f18491q = 0;
        m19275a(context, attributeSet);
    }

    public PagerPositionStrip2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f18489o = 0;
        this.f18490p = 0;
        this.f18491q = 0;
        m19275a(context, attributeSet);
    }

    /* renamed from: a */
    private void m19275a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C4991e.PagerPositionStrip);
        this.f18483i = typedArrayObtainStyledAttributes.getDrawable(0);
        this.f18486l = typedArrayObtainStyledAttributes.getDrawable(1);
        this.f18487m = typedArrayObtainStyledAttributes.getDrawable(2);
        this.f18484j = typedArrayObtainStyledAttributes.getDrawable(3);
        this.f18485k = typedArrayObtainStyledAttributes.getDrawable(4);
        this.f18489o = typedArrayObtainStyledAttributes.getDimensionPixelSize(5, this.f18489o);
        this.f18488n = typedArrayObtainStyledAttributes.getInt(6, 5);
        this.f18490p = this.f18483i.getIntrinsicWidth();
        this.f18491q = this.f18483i.getIntrinsicHeight();
        this.f18491q = Math.max(this.f18491q, this.f18486l.getIntrinsicHeight());
        this.f18491q = Math.max(this.f18491q, this.f18487m.getIntrinsicHeight());
        if (this.f18484j != null) {
            this.f18490p = Math.max(this.f18490p, this.f18484j.getIntrinsicWidth());
            this.f18491q = Math.max(this.f18491q, this.f18484j.getIntrinsicHeight());
        }
        if (this.f18485k != null) {
            this.f18490p = Math.max(this.f18490p, this.f18485k.getIntrinsicWidth());
            this.f18491q = Math.max(this.f18491q, this.f18485k.getIntrinsicHeight());
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawable;
        int paddingLeft;
        int i = 0;
        super.onDraw(canvas);
        new Paint().setAntiAlias(true);
        canvas.drawColor(0);
        if (this.f18481g > 0) {
            Drawable drawable2 = this.f18486l;
            int paddingLeft2 = getPaddingLeft();
            int intrinsicWidth = paddingLeft2 + drawable2.getIntrinsicWidth();
            int paddingTop = getPaddingTop();
            if (drawable2.getIntrinsicHeight() < this.f18491q) {
                paddingTop += (this.f18491q - drawable2.getIntrinsicHeight()) >> 1;
            }
            drawable2.setBounds(paddingLeft2, paddingTop, drawable2.getIntrinsicWidth() + paddingLeft2, drawable2.getIntrinsicHeight() + paddingTop);
            drawable2.draw(canvas);
            i = intrinsicWidth;
        }
        int intrinsicWidth2 = i;
        for (int i2 = this.f18479e; i2 <= this.f18480f; i2++) {
            if (i2 == 0 && this.f18484j != null) {
                drawable = this.f18484j;
            } else if (i2 == this.f18477c - 1 && this.f18485k != null) {
                drawable = this.f18485k;
            } else {
                drawable = this.f18483i;
            }
            if (i2 == 0 && this.f18481g == 0) {
                paddingLeft = getPaddingLeft();
            } else {
                paddingLeft = intrinsicWidth2 + this.f18489o;
            }
            intrinsicWidth2 = drawable.getIntrinsicWidth() + paddingLeft;
            int paddingTop2 = getPaddingTop();
            if (drawable.getIntrinsicHeight() < this.f18491q) {
                paddingTop2 += (this.f18491q - drawable.getIntrinsicHeight()) >> 1;
            }
            if (this.f18478d == i2) {
                drawable.setState(SELECTED_STATE_SET);
            } else {
                drawable.setState(EMPTY_STATE_SET);
            }
            drawable.setBounds(paddingLeft, paddingTop2, drawable.getIntrinsicWidth() + paddingLeft, drawable.getIntrinsicHeight() + paddingTop2);
            drawable.draw(canvas);
        }
        if (this.f18481g != this.f18482h) {
            Drawable drawable3 = this.f18487m;
            int i3 = intrinsicWidth2 + this.f18489o;
            int intrinsicWidth3 = drawable3.getIntrinsicWidth() + i3;
            int paddingTop3 = getPaddingTop();
            if (drawable3.getIntrinsicHeight() < this.f18491q) {
                paddingTop3 += (this.f18491q - drawable3.getIntrinsicHeight()) >> 1;
            }
            drawable3.setBounds(i3, paddingTop3, drawable3.getIntrinsicWidth() + i3, drawable3.getIntrinsicHeight() + paddingTop3);
            drawable3.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int iMin;
        int iMin2;
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int paddingLeft = (((this.f18490p + this.f18489o) * ((this.f18480f - this.f18479e) + 1)) - this.f18489o) + getPaddingLeft() + getPaddingRight();
        if (this.f18481g > 0) {
            paddingLeft += this.f18486l.getIntrinsicWidth() + this.f18489o;
        }
        if (this.f18481g != this.f18482h) {
            paddingLeft += this.f18487m.getIntrinsicWidth() + this.f18489o;
        }
        int paddingTop = this.f18491q + getPaddingTop() + getPaddingBottom();
        switch (mode) {
            case Integer.MIN_VALUE:
                iMin = Math.min(size, paddingLeft);
                break;
            case 0:
                iMin = paddingLeft;
                break;
            case 1073741824:
                iMin = paddingLeft;
                break;
            default:
                iMin = 0;
                break;
        }
        switch (mode2) {
            case Integer.MIN_VALUE:
                iMin2 = Math.min(size2, paddingTop);
                break;
            case 0:
                iMin2 = paddingTop;
                break;
            case 1073741824:
                iMin2 = paddingTop;
                break;
            default:
                iMin2 = 0;
                break;
        }
        setMeasuredDimension(iMin, iMin2);
    }

    public void setViewPager(ViewPager viewPager) {
        this.f18475a = viewPager;
        this.f18476b = this.f18475a.m421b();
        this.f18475a.setOnPageChangeListener(this);
        this.f18478d = this.f18475a.m424c();
        this.f18477c = this.f18476b.mo612b();
        m19274a();
        requestLayout();
        invalidate();
    }

    public void setFirstIndicator(Drawable drawable) {
        this.f18484j = drawable;
        requestLayout();
        invalidate();
    }

    public void setIndicator(Drawable drawable) {
        this.f18483i = drawable;
        requestLayout();
        invalidate();
    }

    public void setLastIndicator(Drawable drawable) {
        this.f18485k = drawable;
        requestLayout();
        invalidate();
    }

    @Override // android.support.v4.view.InterfaceC0196cc
    /* renamed from: a */
    public void mo620a(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.InterfaceC0196cc
    /* renamed from: a */
    public void mo619a(int i) {
        this.f18478d = i;
        m19274a();
        requestLayout();
        invalidate();
    }

    @Override // android.support.v4.view.InterfaceC0196cc
    /* renamed from: b */
    public void mo622b(int i) {
    }

    /* renamed from: a */
    private void m19274a() {
        this.f18481g = this.f18478d / this.f18488n;
        this.f18482h = (this.f18477c - 1) / this.f18488n;
        this.f18479e = this.f18481g * this.f18488n;
        this.f18480f = this.f18479e + (this.f18488n - 1);
        if (this.f18480f >= this.f18477c) {
            this.f18480f = this.f18477c - 1;
        }
    }
}
